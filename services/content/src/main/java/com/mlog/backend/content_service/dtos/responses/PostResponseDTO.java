package com.mlog.backend.content_service.dtos.responses;

import com.mlog.backend.content_service.utils.PostStatus;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
public class PostResponseDTO {

    // ==========================================
    // Thông tin cơ bản
    // ==========================================
    private Long id;
    private String title;

    // Đổi tên từ 'content' sang 'body' theo Entity/DB Schema
    private String body;

    // Cảm xúc của bài viết (dùng cho logic theme)
    private String mood;

    // ==========================================
    // Trạng thái và Thời gian
    // ==========================================
    private PostStatus status;
    private LocalDateTime publishedAt;
    private LocalDateTime scheduledAt;
    private LocalDateTime deletedAt;

    // ==========================================
    // Mối quan hệ
    // ==========================================

    // ID của tác giả
    private Long authorId;

    // Thông tin chi tiết của Category
    private CategoryResponseDTO category;

    // Danh sách các Tags
    private Set<TagResponseDTO> tags;

    // ==========================================
    // Auditing (Theo dõi)
    // ==========================================
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String createdBy;
    private String updatedBy;
}