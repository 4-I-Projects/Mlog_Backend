package com.mlog.backend.content_service.dtos.responses;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class CategoryResponseDTO {

    private Long id;
    private String name;
    private String description;

    // Tùy chọn: Nếu bạn triển khai phân cấp Category
    // private Integer parentId;

    // Auditing fields
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String createdBy;
    private String updatedBy;
}