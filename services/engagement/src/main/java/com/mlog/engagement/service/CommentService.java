package com.mlog.engagement.service;

import com.mlog.engagement.api.ApiUtil;
import com.mlog.engagement.api.CommentsApi;
import com.mlog.engagement.api.CommentsApiDelegate;
import com.mlog.engagement.enitty.CommentEntity;
import com.mlog.engagement.mapper.CommentMapper;
import com.mlog.engagement.model.CommentCreateRequest;
import com.mlog.engagement.model.CommentListResponse;
import com.mlog.engagement.model.CommentResponse;
import com.mlog.engagement.model.CommentUpdateRequest;
import com.mlog.engagement.repository.CommentRepository;
import com.mlog.engagement.utils.JwtUtils;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CommentService implements CommentsApiDelegate {
    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;
    private final JwtUtils jwtUtils;

    public ResponseEntity<CommentResponse> createComment(String xUserinfo,
                                                          CommentCreateRequest commentCreateRequest) {
        CommentEntity commentEntity = commentMapper.toCommentEntity(commentCreateRequest);
        CommentEntity saved = commentRepository.save(commentEntity);
        return new ResponseEntity<>(commentMapper.toCommentResponse(saved), HttpStatus.CREATED);
    }

    public ResponseEntity<Void> deleteComment(UUID commentId,
                                               String xUserinfo) {
        Optional<CommentEntity> commentEntity = commentRepository.findById(commentId);
        if (commentEntity.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        String userId = jwtUtils.getClaimAsString(xUserinfo, "sub")
                .orElseThrow(() -> new IllegalArgumentException("User ID (sub) not found in token"));

        if (!commentEntity.get().getUserId().equals(UUID.fromString(userId)))
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

        commentRepository.deleteById(commentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<CommentResponse> editComment(UUID commentId,
                                                        String xUserinfo,
                                                        CommentUpdateRequest commentUpdateRequest) {
        Optional<CommentEntity> commentEntity = commentRepository.findById(commentId);
        if (commentEntity.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        String userId = jwtUtils.getClaimAsString(xUserinfo, "sub")
                .orElseThrow(() -> new IllegalArgumentException("User ID (sub) not found in token"));

        if (!commentEntity.get().getUserId().equals(UUID.fromString(userId)))
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

        commentEntity.get().setContent(commentUpdateRequest.getContent());
        CommentEntity saved = commentRepository.save(commentEntity.get());
        return new ResponseEntity<>(commentMapper.toCommentResponse(saved), HttpStatus.OK);
    }

    public ResponseEntity<CommentListResponse> getAllCommentsOnPost(Long postId,
                                                                     String cursor,
                                                                     Integer limit) {
        List<CommentResponse> list = commentRepository.getByPostId(postId).stream().map(commentMapper::toCommentResponse).toList();
        CommentListResponse commentListResponse = new CommentListResponse().data(list);
        return new ResponseEntity<>(commentListResponse, HttpStatus.OK);
    }

    public ResponseEntity<CommentListResponse> getAllRepliesOfComment(UUID commentId,
                                                                       String cursor,
                                                                       Integer limit) {
        List<CommentEntity> replies = commentRepository.findAllByParentId(commentId);
        List<CommentResponse>  commentResponse = replies.stream().map(commentMapper::toCommentResponse).toList();
        CommentListResponse commentListResponse = new CommentListResponse().data(commentResponse);
        return new ResponseEntity<>(commentListResponse, HttpStatus.OK);
    }
}
