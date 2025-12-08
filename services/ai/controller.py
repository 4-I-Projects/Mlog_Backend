from flask import Flask, request, jsonify
from google.cloud import language_v1
import os
import logging
import time

# --- Cấu hình logging ---
logging.basicConfig(level=logging.INFO, format='%(asctime)s - %(levelname)s - %(message)s')

# --- Khởi tạo Flask App ---
app = Flask(__name__)

# --- Cấu hình Ngưỡng Phân loại Mood ---
# Có thể điều chỉnh các ngưỡng này tùy theo kết quả thực tế với dữ liệu tiếng Việt của bạn
SCORE_THRESHOLD = 0.25
MAGNITUDE_THRESHOLD = 0.5

# --- KHAI BÁO BIẾN MÔI TRƯỜNG CHO AUTH ---
# Thư viện Google Cloud sẽ tự động tìm kiếm biến môi trường này
if not os.environ.get("GOOGLE_APPLICATION_CREDENTIALS"):
    logging.warning("Biến môi trường GOOGLE_APPLICATION_CREDENTIALS CHƯA được thiết lập.")
    logging.warning("Vui lòng thiết lập biến này trỏ đến file Service Account JSON.")


def classify_mood_advanced(score, magnitude, score_threshold=SCORE_THRESHOLD, magnitude_threshold=MAGNITUDE_THRESHOLD):
    """
    Phân loại mood dựa trên Score và Magnitude.
    """
    
    if magnitude < magnitude_threshold:
        # Nếu tổng cường độ cảm xúc quá thấp, văn bản được coi là Trung tính/Thực tế
        mood = "Trung tính/Thực tế"
        
    else:
        # Phân loại Phân cực (Score) ---
        if score >= score_threshold:
            # Score dương và có đủ cường độ
            mood = "Tích cực"
            
        elif score <= -score_threshold:
            # Score âm và có đủ cường độ
            mood = "Tiêu cực"
            
        else:
            # Score gần 0 nhưng Magnitude cao (Hỗn hợp/Xung đột)
            mood = "Hỗn hợp (Mixed)"
    
    return mood


def analyze_sentiment_vietnamese(text_content):
    """
    Phân tích tâm lý (sentiment) của một đoạn văn bản tiếng Việt bằng Cloud Natural Language API.
    """
    try:
        # Khởi tạo client. Thư viện sẽ tự động sử dụng Application Default Credentials.
        client = language_v1.LanguageServiceClient()

        # Thiết lập loại tài liệu và ngôn ngữ
        document = language_v1.Document(
            content=text_content, 
            type_=language_v1.Document.Type.PLAIN_TEXT, 
            language="vi" 
        )

        # Gọi API để phân tích tâm lý
        response = client.analyze_sentiment(document=document, encoding_type=language_v1.EncodingType.UTF8)

        score = response.document_sentiment.score
        magnitude = response.document_sentiment.magnitude
        
        mood = classify_mood_advanced(score, magnitude)

        return {
            "mood": mood,
            "score": score,
            "magnitude": magnitude
        }

    except Exception as e:
        logging.error(f"Lỗi khi gọi Cloud Natural Language API: {e}")
        # Trả về lỗi server hoặc lỗi xác thực (nếu GOOGLE_APPLICATION_CREDENTIALS sai)
        raise e

# ==========================================
# API ENDPOINT
# ==========================================

@app.route("/api/v1/posts/analyze-mood", methods=["POST"])
def analyze_mood_endpoint():
    """
    Endpoint nhận POST request chứa nội dung bài post và trả về mood.
    """
    try:
        # Kiểm tra Content-Type
        if not request.is_json:
            return jsonify({"error": "Content-Type phải là application/json"}), 400

        data = request.get_json()
        text_content = data.get("content")

        # Kiểm tra nội dung có hợp lệ không
        if not text_content or not isinstance(text_content, str):
            return jsonify({"error": "Trường 'content' là bắt buộc và phải là một chuỗi."}), 400

        # Giới hạn độ dài để tránh request quá lớn
        if len(text_content) > 5000:
             return jsonify({"error": "Nội dung quá dài (tối đa 5000 ký tự)."}), 400

        logging.info(f"Đã nhận request phân tích tâm lý cho nội dung: '{text_content[:50]}...'")

        # Gọi hàm phân tích tâm lý
        result = analyze_sentiment_vietnamese(text_content)

        logging.info(f"Kết quả phân tích: Mood={result['mood']}, Score={result['score']:.2f}, Mag={result['magnitude']:.2f}")

        # Trả về kết quả theo định dạng MoodResponse trong OpenAPI
        return jsonify({
            "mood": result["mood"],
            "score": result["score"],
            "magnitude": result["magnitude"],
            "analysis_source": "Google Cloud NL API"
        }), 200

    except Exception as e:
        # Xử lý các lỗi từ hàm analyze_sentiment_vietnamese (ví dụ: lỗi xác thực, lỗi API)
        error_msg = f"Lỗi Server nội bộ: {str(e)}"
        logging.error(error_msg)
        return jsonify({"error": "Lỗi xử lý dịch vụ AI. Vui lòng kiểm tra GOOGLE_APPLICATION_CREDENTIALS và quyền IAM."}), 500


if __name__ == "__main__":
    # Chạy Flask ở chế độ debug
    # Trong môi trường Production (như Cloud Run), bạn nên dùng Gunicorn hoặc uWSGI
    app.run(debug=True, host='0.0.0.0', port=5001)