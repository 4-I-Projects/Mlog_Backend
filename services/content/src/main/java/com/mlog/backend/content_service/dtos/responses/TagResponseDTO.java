package com.mlog.backend.content_service.dtos.responses;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class TagResponseDTO {

    private Long id;
    private String name;
    private String description;

    // Auditing fields
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String createdBy;
    private String updatedBy;
}