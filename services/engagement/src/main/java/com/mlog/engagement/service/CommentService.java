package com.mlog.engagement.service;

import com.mlog.engagement.api.CommentsApiDelegate;
import com.mlog.engagement.model.CommentCreateRequest;
import com.mlog.engagement.model.CommentListResponse;
import com.mlog.engagement.model.CommentResponse;
import com.mlog.engagement.model.CommentUpdateRequest;
import com.mlog.engagement.repository.CommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CommentService implements CommentsApiDelegate {

    private final CommentRepository commentRepository;

    public Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    public ResponseEntity<Void> apiV1CommentsCommentIdDelete(UUID commentId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<CommentResponse> apiV1CommentsCommentIdPut(UUID commentId,
                                                                      CommentUpdateRequest commentUpdateRequest) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<CommentListResponse> apiV1CommentsCommentIdRepliesGet(UUID commentId,
                                                                                 String cursor,
                                                                                 Integer limit) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<CommentResponse> apiV1CommentsPost(CommentCreateRequest commentCreateRequest) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<CommentListResponse> apiV1PostsPostIdCommentsGet(Long postId,
                                                                            String cursor,
                                                                            Integer limit) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
