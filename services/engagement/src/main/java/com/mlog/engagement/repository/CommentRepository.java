package com.mlog.engagement.repository;

import com.mlog.engagement.enitty.CommentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<CommentEntity, Integer> {
}
