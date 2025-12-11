package com.mlog.backend.content_service.dtos.requests;

import com.mlog.backend.content_service.utils.PostStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class PostCreateRequestDTO {

    @NotBlank(message = "Title is required")
    private String title;

    // Tên trường đã đổi từ 'content' sang 'body' theo DB Schema mới
    @NotBlank(message = "Body content is required")
    private String body;

    @NotNull(message = "Author ID is required")
    private Long authorId;

    @NotNull(message = "Category ID is required")
    private Long categoryId;

    private PostStatus status;

    // ID của các Tags liên quan (cho mối quan hệ Many-to-Many)
    private Set<Long> tagIds;

    // Trường cảm xúc, nếu bạn muốn giữ lại cho logic theme
    private String mood;

    // Trường này chỉ cần thiết nếu status là SCHEDULED
    private LocalDateTime scheduledAt;
}