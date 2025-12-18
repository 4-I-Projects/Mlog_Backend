package com.mlog.engagement.service;

import com.mlog.engagement.api.ApiUtil;
import com.mlog.engagement.api.LikesApi;
import com.mlog.engagement.api.LikesApiDelegate;
import com.mlog.engagement.enitty.FollowEntity;
import com.mlog.engagement.enitty.LikeEntity;
import com.mlog.engagement.model.UserListResponse;
import com.mlog.engagement.model.UserSummary;
import com.mlog.engagement.openfeign.UserClient;
import com.mlog.engagement.openfeign.model.UserResponse;
import com.mlog.engagement.repository.LikeRepository;
import com.mlog.engagement.utils.JwtUtils;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class LikeService implements LikesApiDelegate {
    private final LikeRepository likeRepository;
    private final JwtUtils jwtUtils;
    private final UserClient userClient;

    public ResponseEntity<UserListResponse> getAllLikesOfPost(Long postId,
                                                               String xUserinfo,
                                                               Integer page,
                                                               Integer limit) {
        List<LikeEntity> likeEntities = likeRepository.findAllByPostId(postId);
        List<UserSummary> userSummaries = likeEntities.stream().map(likeEntity -> new UserSummary().id(likeEntity.getUserId())).toList();
        List<UserSummary> users = new ArrayList<UserSummary>();
        for (LikeEntity likeEntity: likeEntities) {
            ResponseEntity<UserResponse> userResponse = userClient.getUserById(likeEntity.getUserId());

            UserSummary userSummary = new UserSummary()
                    .id(likeEntity.getUserId())
                    .avatarUrl(userResponse.getBody().getAvatarUrl())
                    .username(userResponse.getBody().getUsername());

            users.add(userSummary);
        }
        UserListResponse userListResponse = new UserListResponse();
        userListResponse.setData(users);
        return new ResponseEntity<>(userListResponse, HttpStatus.OK);
    }

    public ResponseEntity<Void> likePost(Long postId,
                                          String xUserinfo) {
        LikeEntity likeEntity = new LikeEntity();
        likeEntity.setPostId(postId);
        String userId = jwtUtils.getClaimAsString(xUserinfo, "sub")
                .orElseThrow(() -> new IllegalArgumentException("User ID (sub) not found in token"));
        likeEntity.setUserId(UUID.fromString(userId));
        likeRepository.save(likeEntity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<Void> unlikePost(Long postId,
                                            String xUserinfo) {
        String userId = jwtUtils.getClaimAsString(xUserinfo, "sub")
                .orElseThrow(() -> new IllegalArgumentException("User ID (sub) not found in token"));
        likeRepository.deleteByUserId(UUID.fromString(userId));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
