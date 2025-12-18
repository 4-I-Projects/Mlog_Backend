package com.mlog.engagement.enitty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;
import java.util.UUID;

@Data
@Entity
public class LikeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    Long postId;
    UUID commentId;
    UUID userId;

    @CreatedDate
    Instant createdAt;

    @CreatedBy
    String createdBy;
}
