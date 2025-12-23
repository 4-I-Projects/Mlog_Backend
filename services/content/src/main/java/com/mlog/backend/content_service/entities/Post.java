package com.mlog.backend.content_service.entities;

import com.mlog.backend.content_service.utils.Auditable;
import com.mlog.backend.content_service.utils.PostStatus;
import jakarta.persistence.*;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "post")
@Getter
@Setter
public class Post extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Lob
    @Column(columnDefinition = "TEXT", nullable = false)
    private String body;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PostStatus status = PostStatus.DRAFT;

    // Các trường thời gian đặc biệt
    private LocalDateTime publishedAt;
    private LocalDateTime scheduledAt;
    private LocalDateTime deletedAt;

    // Mối quan hệ Many-to-One với Category
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    // author_id
    @Column(name = "author_id", nullable = false)
    private UUID authorId;

    // Mối quan hệ Many-to-Many với Tags (thông qua bảng PostTag)
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "post_tag",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> tags = new HashSet<>();

    private String mood;
}
