package com.mlog.engagement.service;

import com.mlog.engagement.api.LikesApiDelegate;
import com.mlog.engagement.model.UserListResponse;
import com.mlog.engagement.repository.CommentLikeRepository;
import com.mlog.engagement.repository.PostLikeRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;

@Service
@AllArgsConstructor
public class LikeService implements LikesApiDelegate {
    private final PostLikeRepository postLikeRepository;
    private final CommentLikeRepository commentLikeRepository;

    public Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    public ResponseEntity<Void> apiV1PostsPostIdLikesDelete(Long postId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<UserListResponse> apiV1PostsPostIdLikesGet(Long postId,
                Integer page,
                Integer limit) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> apiV1PostsPostIdLikesPost(Long postId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
