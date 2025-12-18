package com.mlog.engagement.repository;

import com.mlog.engagement.enitty.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, UUID> {
    List<CommentEntity> getByPostId(Long postId);

    List<CommentEntity> findAllByParentId(UUID parentId);
}
