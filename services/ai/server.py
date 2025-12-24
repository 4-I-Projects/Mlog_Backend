import os
import grpc
import json
from concurrent import futures
from dotenv import load_dotenv
from google import genai
from pydantic import BaseModel

# Import các file được generate từ proto
import mood_pb2
import mood_pb2_grpc

# --- CẤU HÌNH GEMINI ---
load_dotenv()
api_key = os.getenv("GEMINI_API_KEY")
client = genai.Client(api_key=api_key)

ALLOWED_MOODS = ["Happy", "Sad", "Angry", "Romantic", "Tired"]

class MoodResponseSchema(BaseModel):
    detected_mood: str
    confidence_score: float
    explanation_vi: str

# --- IMPLEMENTATION SERVICE ---
class MoodServiceServicer(mood_pb2_grpc.MoodServiceServicer):
    
    def AnalyzeMood(self, request, context):
        print(f"Nhận yêu cầu phân tích: {request.text[:50]}...")
        
        system_instruction = f"""
        You are a professional sentiment analyst. 
        Analyze the Vietnamese text and classify it into exactly ONE of these 
        English labels: {', '.join(ALLOWED_MOODS)}.
        """
        
        try:
            # Gọi Gemini API
            response = client.models.generate_content(
                model="gemini-2.5-flash", # Sử dụng bản stable 2.0 flash
                contents=f"Văn bản: '{request.text}'",
                config={
                    "system_instruction": system_instruction,
                    "response_mime_type": "application/json",
                    "response_schema": MoodResponseSchema,
                }
            )
            
            result = response.parsed
            
            # Trả về gRPC Response Message
            return mood_pb2.MoodResponse(
                mood=result.detected_mood,
                confidence=result.confidence_score,
                explanation=result.explanation_vi
            )
            
        except Exception as e:
            print(f"Lỗi khi xử lý: {e}")
            # Trả về lỗi gRPC nếu cần hoặc một response trống
            context.set_code(grpc.StatusCode.INTERNAL)
            context.set_details(f"Internal error: {str(e)}")
            return mood_pb2.MoodResponse()

# --- CHẠY SERVER ---
def serve():
    # Khởi tạo Server với ThreadPool
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    
    # Đăng ký service vào server
    mood_pb2_grpc.add_MoodServiceServicer_to_server(MoodServiceServicer(), server)
    
    # Lắng nghe tại port 50051 (phù hợp với cấu hình Java Spring Boot)
    port = "50051"
    server.add_insecure_port(f'[::]:{port}')
    
    print(f"gRPC AI Server đang chạy tại port {port}...")
    server.start()
    server.wait_for_termination()

if __name__ == "__main__":
    serve()