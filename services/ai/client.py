from google.cloud import language_v1

def classify_mood_advanced(score, magnitude, score_threshold=0.25, magnitude_threshold=0.5):
    if magnitude < magnitude_threshold:
        # Nếu tổng cường độ cảm xúc quá thấp, văn bản được coi là Trung tính/Thực tế
        # (Không có đủ cảm xúc để phân loại Tích cực hay Tiêu cực).
        mood = "Trung tính/Thực tế"
        
    else:
        #  Phân loại Phân cực (Score) ---

        if score >= score_threshold:
            # Score dương và có đủ cường độ
            mood = "Tích cực"
            
        elif score <= -score_threshold:
            # Score âm và có đủ cường độ
            mood = "Tiêu cực"
            
        else:
            # Score gần 0 nhưng Magnitude cao (Hỗn hợp/Xung đột)
            # Tức là có nhiều cảm xúc trái ngược nhau được đề cập (ví dụ: "Sản phẩm tốt nhưng dịch vụ tệ")
            mood = "Hỗn hợp (Mixed)"
    
    return mood

def analyze_sentiment_vietnamese(text_content):
    """
    Phân tích tâm lý (sentiment) của một đoạn văn bản tiếng Việt bằng Cloud Natural Language API.
    """
    # Khởi tạo client. Thư viện sẽ tự động sử dụng biến môi trường 
    # GOOGLE_APPLICATION_CREDENTIALS để xác thực.
    client = language_v1.LanguageServiceClient()

    # Thiết lập loại tài liệu và ngôn ngữ
    document = language_v1.Document(
        content=text_content, 
        type_=language_v1.Document.Type.PLAIN_TEXT, 
        # API tự động phát hiện, nhưng nên chỉ định nếu biết trước
        language="vi" 
    )

    # Gọi API để phân tích tâm lý
    response = client.analyze_sentiment(document=document, encoding_type=language_v1.EncodingType.UTF8)

    print(f"--- Kết quả Phân tích Tâm lý ---")
    
    # Điểm số: -1.0 (Tiêu cực) đến 1.0 (Tích cực)
    score = response.document_sentiment.score
    # Độ lớn: 0.0 đến vô hạn, thể hiện cường độ cảm xúc
    magnitude = response.document_sentiment.magnitude

    print(f"Nội dung: {text_content}")
    print(f"Score (Điểm số): {score:.2f}")
    print(f"Magnitude (Cường độ): {magnitude:.2f}")
        
    print(f"Phân loại Mood: **{classify_mood_advanced(score, magnitude)}**")
    
    return score, magnitude

# analyze_sentiment_vietnamese("Sản phẩm này thật tuyệt vời, tôi rất hài lòng với chất lượng và dịch vụ giao hàng nhanh chóng.")

analyze_sentiment_vietnamese("Tôi thất vọng về trải nghiệm này. Hàng hóa bị hỏng và không ai hỗ trợ tôi.")