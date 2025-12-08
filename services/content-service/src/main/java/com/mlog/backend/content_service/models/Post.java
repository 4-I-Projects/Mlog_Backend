package com.mlog.backend.content_service.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "posts")
@Data // Tạo getters, setters, toString, equals, hashCode (Lombok)
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Lob
    @Column(nullable = false)
    private String content;

    private String mood;

    // Thêm các trường khác như authorId, createdAt, updatedAt nếu cần
}
