package com.mlog.engagement.enitty;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(
    name = "follows",
    uniqueConstraints = @UniqueConstraint(columnNames = {"followerId", "followedId"})
)
public class FollowEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    // This will store the UUID of the user doing the following
    @Column(nullable = false)
    private UUID followerId;

    @Column(nullable = false)
    private UUID followedId;
}
