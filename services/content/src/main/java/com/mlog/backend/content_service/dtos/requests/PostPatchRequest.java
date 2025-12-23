package com.mlog.backend.content_service.dtos.requests;

import com.mlog.backend.content_service.utils.PostStatus;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Data
public class PostPatchRequest {

    // ==========================================
    // Các trường cơ bản
    // ==========================================

    private String title;

    // Đổi tên từ 'content' sang 'body' theo DB Schema
    private String body;

    // Trường cảm xúc cho logic theme
    private String mood;

    // ==========================================
    // Các trường quan hệ và nghiệp vụ
    // ==========================================

    // ID của Tác giả (Có thể thay đổi tác giả bài viết)
    private UUID authorId;

    // ID của Category (Có thể thay đổi Danh mục)
    private Long categoryId;

    // Trạng thái bài viết (Dùng để chuyển từ DRAFT sang PUBLISHED, hoặc sang DELETED)
    private PostStatus status;

    // ID của các Tags mới/cần cập nhật (Set<Integer> sẽ thay thế toàn bộ Tags hiện tại)
    private Set<Long> tagIds;

    // Thời gian lên lịch (chỉ cần nếu status là SCHEDULED)
    private LocalDateTime scheduledAt;
}