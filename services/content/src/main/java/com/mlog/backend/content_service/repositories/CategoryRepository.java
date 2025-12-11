package com.mlog.backend.content_service.repositories;

import com.mlog.backend.content_service.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
