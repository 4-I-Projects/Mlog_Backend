package com.mlog.user.service;

import com.mlog.user.api.AdminApiDelegate;
import com.mlog.user.entity.UserEntity;
import com.mlog.user.model.BanUserRequest;
import com.mlog.user.model.UnbanUserRequest;
import com.mlog.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AdminService implements AdminApiDelegate {
    private final UserRepository userRepository;

    public ResponseEntity<Void> banUser(UUID userId, BanUserRequest banUserRequest) {
        Optional<UserEntity> user = userRepository.findById(userId);
        if (!user.isEmpty())  {
            user.get().setBanned(true);
            userRepository.save(user.get());
        }

        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Void> unbanUser(UUID userId, UnbanUserRequest unbanUserRequest) {
        Optional<UserEntity> user = userRepository.findById(userId);
        if (!user.isEmpty())  {
            user.get().setBanned(false);
            userRepository.save(user.get());
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
