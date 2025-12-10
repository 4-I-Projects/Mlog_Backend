package com.mlog.user.service;

import com.mlog.user.api.UsersApiDelegate;
import com.mlog.user.entity.UserEntity;
import com.mlog.user.mapper.UserMapper;
import com.mlog.user.model.UserRequest;
import com.mlog.user.model.UserResponse;
import com.mlog.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService implements UsersApiDelegate {
    private final UserMapper userMapper;

    private final UserRepository userRepository;

    public ResponseEntity<UserResponse> createUser(UserRequest userRequest) {
        UserEntity userEntity = userMapper.toUser(userRequest);
        if (userRepository.existsByUsername(userEntity.getUsername()))
            throw new RuntimeException("user with that name already exists");
        UserEntity createdUserEntity = userRepository.save(userEntity);
        return new ResponseEntity<>(userMapper.toUserResponse(createdUserEntity), HttpStatus.CREATED);
    }

    public ResponseEntity<UserResponse> getCurrentUser() {
        userRepository.getFirstByUsername("admin");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<UserResponse> getUser(UUID userId) {
        UserEntity userEntity = userRepository.getFirstById(userId);
        return new ResponseEntity<>(userMapper.toUserResponse(userEntity), HttpStatus.OK);
    }

    public ResponseEntity<List<UserResponse>> listAllUsers() {
        Iterable<UserEntity> users = userRepository.findAll();
        List<UserResponse> userResponseList = new ArrayList<>();
        for (UserEntity userEntity : users) {
            userResponseList.add(userMapper.toUserResponse(userEntity));
        }
        return new ResponseEntity<>(userResponseList, HttpStatus.OK);

    }
}
