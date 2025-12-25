package com.mlog.backend.content_service.controllers;

import com.mlog.backend.content_service.dtos.responses.PostResponse;
import com.mlog.backend.content_service.entities.Post;
import com.mlog.backend.content_service.dtos.requests.PostCreateRequest;
import com.mlog.backend.content_service.dtos.requests.PostPatchRequest;
import com.mlog.backend.content_service.dtos.responses.CategoryResponse;
import com.mlog.backend.content_service.dtos.responses.TagResponse;
import com.mlog.backend.content_service.services.CloudStorageService;
import com.mlog.backend.content_service.services.PostService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/posts")
@AllArgsConstructor
public class PostController {
    private final PostService postService;
    private final CloudStorageService cloudStorageService;

    private PostResponse toResponse(Post post) {
        CategoryResponse categoryResponse = CategoryResponse.builder()
                .id(post.getCategory().getId())
                .name(post.getCategory().getName())
                .description(post.getCategory().getDescription())
                .createdAt(post.getCategory().getCreatedAt())
                .updatedAt(post.getCategory().getUpdatedAt())
                .createdBy(post.getCategory().getCreatedBy())
                .updatedBy(post.getCategory().getUpdatedBy())
                .build();

        // Ánh xạ Tags
        Set<TagResponse> tagResponses = post.getTags().stream()
                .map(tag -> TagResponse.builder()
                        .id(tag.getId())
                        .name(tag.getName())
                        .description(tag.getDescription())
                        .createdAt(tag.getCreatedAt())
                        .updatedAt(tag.getUpdatedAt())
                        .createdBy(tag.getCreatedBy())
                        .updatedBy(tag.getUpdatedBy())
                        .build())
                .collect(Collectors.toSet());

        return PostResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .body(post.getBody())
                .status(post.getStatus())
                .publishedAt(post.getPublishedAt())
                .scheduledAt(post.getScheduledAt())
                .authorId(post.getAuthorId())
                .category(categoryResponse)
                .mood(post.getMood())
                .tags(tagResponses)
                .createdAt(post.getCreatedAt())
                .updatedAt(post.getUpdatedAt())
                .createdBy(post.getCreatedBy())
                .updatedBy(post.getUpdatedBy())
                .build();
    }

    // ==========================================
    // GET /api/v1/posts
    // ==========================================
    @GetMapping
    public ResponseEntity<List<PostResponse>> getAllPosts(@RequestParam(required = false) String authorId) {
        if (authorId != null && !authorId.isEmpty()) {
            UUID authorUuid;
            try {
                authorUuid = UUID.fromString(authorId);
            } catch (IllegalArgumentException e) {
                return ResponseEntity.badRequest().build();
            }
            List<Post> postsByAuthor = postService.getPostsByUserId(authorUuid);
            List<PostResponse> responseListByAuthor = postsByAuthor.stream()
                    .map(this::toResponse)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(responseListByAuthor);
        }

        List<Post> posts = postService.getAllPosts();
        List<PostResponse> responseList = posts.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());

        return ResponseEntity.ok(responseList);
    }

    // ==========================================
    // POST /api/v1/posts
    // ==========================================
    @PostMapping
    public ResponseEntity<PostResponse> createPost(@Valid @RequestBody PostCreateRequest request) {
        Post createdPost = postService.createPost(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(toResponse(createdPost));
    }

    // ==========================================
    // GET /api/v1/posts/{post_id}
    // ==========================================
    @GetMapping("/{post_id}")
    public ResponseEntity<PostResponse> getPostById(@PathVariable("post_id") Long postId) {
        Post post = postService.getPostById(postId);
        return ResponseEntity.ok(toResponse(post));
    }

    // ==========================================
    // PUT /api/v1/posts/{post_id}
    // ==========================================
    @PutMapping("/{post_id}")
    public ResponseEntity<PostResponse> updatePost(
            @PathVariable("post_id") Long postId,
            @Valid @RequestBody PostCreateRequest request) {

        Post updatedPost = postService.updatePost(postId, request);
        return ResponseEntity.ok(toResponse(updatedPost));
    }

    // ==========================================
    // PATCH /api/v1/posts/{post_id}
    // ==========================================
    @PatchMapping("/{post_id}")
    public ResponseEntity<PostResponse> patchPost(
            @PathVariable("post_id") Long postId,
            @RequestBody PostPatchRequest request) {

        Post patchedPost = postService.patchPost(postId, request);
        return ResponseEntity.ok(toResponse(patchedPost));
    }

    @DeleteMapping("/{post_id}")
    public ResponseEntity<Void> deletePost(@PathVariable("post_id") Long postId) {
        postService.deletePost(postId);
        // Trả về 204 No Content
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/upload-image")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            String url = cloudStorageService.uploadFile(file);
            return ResponseEntity.ok(url);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Lỗi upload: " + e.getMessage());
        }
    }
}