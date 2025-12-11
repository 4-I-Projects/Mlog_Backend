package com.mlog.engagement.repository;

import com.mlog.engagement.enitty.CommentLikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CommentLikeRepository extends JpaRepository<CommentLikeEntity, UUID> {
}
