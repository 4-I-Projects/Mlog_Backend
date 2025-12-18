package com.mlog.engagement.service;

import com.mlog.engagement.api.ApiUtil;
import com.mlog.engagement.api.FollowsApi;
import com.mlog.engagement.api.FollowsApiDelegate;
import com.mlog.engagement.enitty.FollowEntity;
import com.mlog.engagement.model.UserListResponse;
import com.mlog.engagement.model.UserSummary;
import com.mlog.engagement.openfeign.UserClient;
import com.mlog.engagement.openfeign.model.UserResponse;
import com.mlog.engagement.repository.FollowRepository;
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

@AllArgsConstructor
@Service
public class FollowService implements FollowsApiDelegate {
    private final FollowRepository followRepository;
    private final JwtUtils jwtUtils;
    private final UserClient userClient;

    @Transactional
    public ResponseEntity<Void> followUser(UUID targetUserId,
                                            String xUserinfo) {
        String userId = jwtUtils.getClaimAsString(xUserinfo, "sub")
                .orElseThrow(() -> new IllegalArgumentException("User ID (sub) not found in token"));
        FollowEntity follow = new FollowEntity();
        follow.setFollowerId(UUID.fromString(userId));
        follow.setFollowedId(targetUserId);
        followRepository.save(follow);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<UserListResponse> getAllFollowers(UUID userId,
                                                             String xUserinfo,
                                                             Integer page,
                                                             Integer limit) {
        List<FollowEntity> followEntities = followRepository.findAllByFollowedId(userId);
        List<UserSummary> users = new ArrayList<UserSummary>();
        for (FollowEntity followEntity : followEntities) {
            ResponseEntity<UserResponse> userResponse = userClient.getUserById(followEntity.getFollowerId());

            UserSummary userSummary = new UserSummary()
                    .id(followEntity.getFollowerId())
                    .avatarUrl(userResponse.getBody().getAvatarUrl())
                    .username(userResponse.getBody().getUsername());

            users.add(userSummary);
        }
        UserListResponse userListResponse = new UserListResponse();
        userListResponse.setData(users);
        return new ResponseEntity<>(userListResponse, HttpStatus.OK);
    }

    public ResponseEntity<UserListResponse> getAllFollowing(UUID userId,
                                                             String xUserinfo,
                                                             Integer page,
                                                             Integer limit) {
        List<FollowEntity> followEntities = followRepository.findAllByFollowerId(userId);
        List<UserSummary> users = new ArrayList<UserSummary>();
        for (FollowEntity followEntity : followEntities) {
            ResponseEntity<UserResponse> userResponse = userClient.getUserById(followEntity.getFollowedId());

            UserSummary userSummary = new UserSummary()
                    .id(followEntity.getFollowerId())
                    .avatarUrl(userResponse.getBody().getAvatarUrl())
                    .username(userResponse.getBody().getUsername());

            users.add(userSummary);
        }
        UserListResponse userListResponse = new UserListResponse();
        userListResponse.setData(users);
        return new ResponseEntity<>(userListResponse, HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<Void> unfollowUser(UUID targetUserId,
                                              String xUserinfo) {
        String userId = jwtUtils.getClaimAsString(xUserinfo, "sub")
                .orElseThrow(() -> new IllegalArgumentException("User ID (sub) not found in token"));
        followRepository.deleteByFollowerIdAndFollowedId(UUID.fromString(userId), targetUserId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
