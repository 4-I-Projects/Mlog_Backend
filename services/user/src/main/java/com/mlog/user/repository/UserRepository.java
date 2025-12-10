package com.mlog.user.repository;

import com.mlog.user.entity.UserEntity;
import com.mlog.user.model.UserResponse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, UUID> {
    UserEntity getFirstByUsername(String username);

    UserEntity getFirstById(UUID id);

    boolean existsByUsername(String username);
}
