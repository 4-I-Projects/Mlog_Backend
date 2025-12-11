package com.mlog.backend.content_service.repositories;

import com.mlog.backend.content_service.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
