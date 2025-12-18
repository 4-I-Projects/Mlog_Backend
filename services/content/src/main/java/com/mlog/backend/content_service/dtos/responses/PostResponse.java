package com.mlog.backend.content_service.dtos.responses;

import com.mlog.backend.content_service.utils.PostStatus;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
public class PostResponse {
    private Long id;
    private String title;

    private String body;

    private String mood;

    private PostStatus status;

    private LocalDateTime publishedAt;
    private LocalDateTime scheduledAt;
    private LocalDateTime deletedAt;

    private Long authorId;

    private CategoryResponse category;

    private Set<TagResponse> tags;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String createdBy;
    private String updatedBy;
}