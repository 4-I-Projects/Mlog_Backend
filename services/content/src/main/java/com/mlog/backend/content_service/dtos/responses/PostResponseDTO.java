package com.mlog.backend.content_service.dtos.responses;

import lombok.Builder;
import lombok.Data;

@Data
@Builder // Dùng Builder Pattern để dễ tạo response
public class PostResponseDTO {
    private Long id;
    private String title;
    private String content;
    private String mood;
}
