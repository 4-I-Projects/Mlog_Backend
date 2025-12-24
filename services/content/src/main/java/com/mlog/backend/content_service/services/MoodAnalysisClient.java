package com.mlog.backend.content_service.services;

import com.example.aiservice.MoodRequest;
import com.example.aiservice.MoodResponse;
import com.example.aiservice.MoodServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class MoodAnalysisClient {

    // Inject Stub được tạo ra tự động từ file proto
    @GrpcClient("ai-mood-service")
    private MoodServiceGrpc.MoodServiceBlockingStub moodStub;

    public String analyze(String text) {
        try {
            // 1. Tạo request
            MoodRequest request = MoodRequest.newBuilder()
                    .setText(text)
                    .build();

            // 2. Gọi server Python và nhận response
            MoodResponse response = moodStub.analyzeMood(request);

            // 3. Xử lý kết quả
            System.out.println("--- Kết quả từ AI Server ---");
            System.out.println("Mood: " + response.getMood());
            System.out.println("Confidence: " + (response.getConfidence() * 100) + "%");
            System.out.println("Explanation: " + response.getExplanation());
            return response.getMood();

        } catch (Exception e) {
            System.err.println("Lỗi khi gọi gRPC Server: " + e.getMessage());
            return null;
        }
    }
}