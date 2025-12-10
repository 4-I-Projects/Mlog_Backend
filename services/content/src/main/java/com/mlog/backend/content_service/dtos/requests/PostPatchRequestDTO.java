package com.mlog.backend.content_service.dtos.requests;

import lombok.Data;

@Data
public class PostPatchRequestDTO {
    // Các trường tùy chọn, chỉ được cập nhật khi cung cấp
    private String title;
    private String content;
    private String mood;
}
