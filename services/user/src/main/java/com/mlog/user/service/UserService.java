package com.mlog.user.service;

import com.mlog.user.api.ApiUtil;
import com.mlog.user.api.UsersApi;
import com.mlog.user.api.UsersApiDelegate;
import com.mlog.user.entity.UserEntity;
import com.mlog.user.mapper.UserMapper;
import com.mlog.user.model.PatchUserRequest;
import com.mlog.user.model.UpdateUserRequest;
import com.mlog.user.model.UserRequest;
import com.mlog.user.model.UserResponse;
import com.mlog.user.repository.UserRepository;
import com.mlog.user.utils.JwtUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class UserService implements UsersApiDelegate {
    private final UserMapper userMapper;
    private final JwtUtils jwtUtils;

    private final UserRepository userRepository;

    @Override
    @Transactional
    public ResponseEntity<UserResponse> createUser(String xUserinfo,
                UserRequest userRequest) {
        String userId = jwtUtils.getClaimAsString(xUserinfo, "sub")
                .orElseThrow(() -> new IllegalArgumentException("User ID (sub) not found in token"));
        UserEntity userEntity = userMapper.toUser(userRequest);
        userEntity.setId(UUID.fromString(userId));
        if (userRepository.existsByUsername(userEntity.getUsername()))
            throw new RuntimeException("user with that name already exists");
        UserEntity createdUserEntity = userRepository.save(userEntity);
        return new ResponseEntity<>(userMapper.toUserResponse(createdUserEntity), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<UserResponse> getCurrentUser(String xUserinfo) {
        String userId = jwtUtils.getClaimAsString(xUserinfo, "sub")
                .orElseThrow(() -> new IllegalArgumentException("User ID (sub) not found in token"));
        Optional<UserEntity> userEntity = userRepository.findById(UUID.fromString(userId));
        if (userEntity.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(userMapper.toUserResponse(userEntity.get()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserResponse> getUser(UUID userId) {
        UserEntity userEntity = userRepository.getFirstById(userId);
        return new ResponseEntity<>(userMapper.toUserResponse(userEntity), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<UserResponse>> listAllUsers() {
        Iterable<UserEntity> users = userRepository.findAll();
        List<UserResponse> userResponseList = new ArrayList<>();
        for (UserEntity userEntity : users) {
            userResponseList.add(userMapper.toUserResponse(userEntity));
        }
        return new ResponseEntity<>(userResponseList, HttpStatus.OK);
    }

    @Override
    @Transactional
    public ResponseEntity<UserResponse> putCurrentUser(String xUserinfo,
                UpdateUserRequest updateUserRequest) {
        String userId = jwtUtils.getClaimAsString(xUserinfo, "sub")
                .orElseThrow(() -> new IllegalArgumentException("User ID (sub) not found in token"));

        UserEntity userEntity = userRepository.findById(UUID.fromString(userId))
                .orElseThrow(() -> new RuntimeException("User not found"));

        userMapper.updateUserFromRequest(updateUserRequest, userEntity);
        UserEntity updatedUser = userRepository.save(userEntity);

        return new ResponseEntity<>(userMapper.toUserResponse(updatedUser), HttpStatus.OK);
    }

    @Override
    @Transactional
    public ResponseEntity<UserResponse> patchCurrentUser(String xUserinfo,
                                                          PatchUserRequest patchUserRequest) {
        String userId = jwtUtils.getClaimAsString(xUserinfo, "sub")
                .orElseThrow(() -> new IllegalArgumentException("User ID (sub) not found in token"));
        log.info(userId);
        UserEntity userEntity = userRepository.findById(UUID.fromString(userId))
                .orElseThrow(() -> new RuntimeException("User not found"));

        userMapper.patchUserFromRequest(patchUserRequest, userEntity);
        UserEntity updatedUser = userRepository.save(userEntity);

        return new ResponseEntity<>(userMapper.toUserResponse(updatedUser), HttpStatus.OK);
    }
}
