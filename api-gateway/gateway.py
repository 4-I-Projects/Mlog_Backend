from flask import Flask, request, jsonify, redirect, make_response
import requests
import uuid
# from flask_jwt_extended import JWTManager, create_access_token, get_jwt_identity, jwt_required

app = Flask(__name__)
# Config
CLIENT_ID = 'my-flask-client'
CLIENT_SECRET = 't5MnvsslIyEf8tgHyfhwxaUpqTwxFHzu'
IDP_URL = 'http://192.168.100.102:8080'
GATEWAY_URL = 'http://localhost:5000'

# Service Mapping (Định nghĩa service nào nằm ở đâu)
SERVICES = {
    'users': 'http://localhost:5001',   # Ví dụ: User Service chạy port 5001
    'posts': 'http://localhost:5002',   # Ví dụ: Post Service chạy port 5002
    'comments': 'http://localhost:5002' # Comment nằm chung Post service
}

sessions = {}

# --- AUTH ROUTES (Khớp với OpenAPI) ---

@app.route("/api/v1/auth/login", methods=['GET'])
def login():
    # Sửa lại redirect_uri cho đúng path mới
    redirect_uri = f"{GATEWAY_URL}/api/v1/auth/callback"
    url = f'{IDP_URL}/realms/test/protocol/openid-connect/auth?client_id={CLIENT_ID}&response_type=code&redirect_uri={redirect_uri}&scope=openid profile'
    
    response = make_response(redirect(url))
    return response

@app.route("/api/v1/auth/callback", methods=["GET", "POST"])
def callback():
    code = request.args.get('code')
    if not code:
        return jsonify({"error": "No code provided"}), 400

    data = {
        'grant_type': 'authorization_code',
        'code': code,
        'redirect_uri': f"{GATEWAY_URL}/api/v1/auth/callback",
        'client_id': CLIENT_ID,
        'client_secret': CLIENT_SECRET
    }
    
    try:
        # Gọi sang Keycloak lấy token
        token_res = requests.post(
            f'{IDP_URL}/realms/test/protocol/openid-connect/token',
            data=data
        )
        token_data = token_res.json()
        
        if 'access_token' not in token_data:
            return jsonify(token_data), 400

        # Tạo session lưu vào RAM
        session_id = str(uuid.uuid4())
        sessions[session_id] = { 
            "access_token": token_data.get('access_token'),
            "refresh_token": token_data.get('refresh_token')
        }

        # Trả về cookie cho Frontend
        # Lưu ý: Thực tế thường redirect về trang Home của Frontend (ví dụ localhost:3000)
        response = make_response(jsonify({"message": "Login successfully", "sessionId": session_id}))
        response.set_cookie("session_id", session_id, httponly=True) 
        return response
        
    except Exception as e:
        return jsonify({"error": str(e)}), 500

@app.route("/api/v1/auth/logout", methods=['GET'])
def logout():
    session_id = request.cookies.get('session_id')
    if session_id and session_id in sessions:
        refresh_token = sessions[session_id].get('refresh_token')
        
        # Logout bên Keycloak
        requests.post(
            f"{IDP_URL}/realms/test/protocol/openid-connect/logout", 
            data={
                "client_id": CLIENT_ID,
                "client_secret": CLIENT_SECRET,
                "refresh_token": refresh_token
            }
        )
        del sessions[session_id]

    response = make_response(jsonify({"message": "Logged out"}))
    response.set_cookie("session_id", '', expires=0)
    return response

# --- PROXY ROUTES (Logic quan trọng để Gateway hoạt động) ---

@app.route("/api/v1/<service_name>/<path:subpath>", methods=['GET', 'POST', 'PUT', 'DELETE', 'PATCH'])
def proxy(service_name, subpath):
    """
    Hàm này bắt các request dạng: /api/v1/users/me, /api/v1/posts/123...
    và chuyển tiếp sang microservice tương ứng.
    """
    # 1. Check Authentication
    session_id = request.cookies.get("session_id")
    if not session_id or session_id not in sessions:
        return jsonify({"message": "Unauthorized"}), 401
    
    access_token = sessions[session_id]['access_token']
    
    # 2. Determine Target URL
    # Logic đơn giản: map tên resource đầu tiên sang port
    # user -> service user, admin -> service user (ví dụ)
    base_url = None
    if service_name in ['users', 'admin']:
        base_url = SERVICES['users']
    elif service_name in ['posts', 'comments']:
        base_url = SERVICES['posts']
    
    if not base_url:
        return jsonify({"message": "Service not found"}), 404

    target_url = f"{base_url}/api/v1/{service_name}/{subpath}"
    
    # 3. Forward Request
    headers = {
        "Authorization": f"Bearer {access_token}",
        "Content-Type": request.content_type or "application/json"
    }

    try:
        resp = requests.request(
            method=request.method,
            url=target_url,
            headers=headers,
            data=request.get_data(),
            params=request.args
        )
        return (resp.content, resp.status_code, resp.headers.items())
    except Exception as e:
        return jsonify({"error": "Microservice unavailable", "details": str(e)}), 502

if __name__ == "__main__":
    app.run(host='0.0.0.0', port=5000, debug=True)
