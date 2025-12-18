package com.mlog.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.annotation.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Data
public class UserEntity {
    @Id
    UUID id;

    String username;
    String displayName;
    String bio;
    String avatarUrl;

    Boolean banned = false;

    @CreatedDate
    Instant createdAt;

    @CreatedBy
    String createdBy;

    @LastModifiedDate
    Instant updatedAt;

    @LastModifiedBy
    String updatedBy;
}
