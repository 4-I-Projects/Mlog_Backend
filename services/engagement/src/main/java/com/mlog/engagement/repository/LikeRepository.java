package com.mlog.engagement.repository;

import com.mlog.engagement.enitty.LikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface LikeRepository extends JpaRepository<LikeEntity, UUID> {
    List<LikeEntity> findAllByPostId(Long postId);

    void deleteByUserId(UUID userId);

    void deleteByUserIdAndPostId(UUID userId, Long postId);
}
