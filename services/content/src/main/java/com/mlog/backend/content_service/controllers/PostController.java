package com.mlog.backend.content_service.controllers;

import com.mlog.backend.content_service.dtos.responses.PostResponseDTO;
import com.mlog.backend.content_service.entities.Post;
import com.mlog.backend.content_service.dtos.requests.PostCreateRequestDTO;
import com.mlog.backend.content_service.dtos.requests.PostPatchRequestDTO;
import com.mlog.backend.content_service.dtos.responses.CategoryResponseDTO;
import com.mlog.backend.content_service.dtos.responses.TagResponseDTO;
import com.mlog.backend.content_service.services.PostService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    @Autowired
    private PostService postService;

    private PostResponseDTO toResponse(Post post) {
        // Ánh xạ Category
        CategoryResponseDTO categoryResponse = CategoryResponseDTO.builder()
                .id(post.getCategory().getId())
                .name(post.getCategory().getName())
                .description(post.getCategory().getDescription())
                .build();

        // Ánh xạ Tags
        Set<TagResponseDTO> tagResponses = post.getTags().stream()
                .map(tag -> TagResponseDTO.builder()
                        .id(tag.getId())
                        .name(tag.getName())
                        .build())
                .collect(Collectors.toSet());

        return PostResponseDTO.builder()
                .id(post.getId())
                .title(post.getTitle())
                .body(post.getBody())
                .status(post.getStatus())
                .publishedAt(post.getPublishedAt())
                .scheduledAt(post.getScheduledAt())
                .authorId(post.getAuthorId())
                .category(categoryResponse) // DTO Category
                .tags(tagResponses)       // DTO Tags
                .build();
    }

    // ==========================================
    // GET /api/v1/posts
    // ==========================================
    @GetMapping
    public ResponseEntity<List<PostResponseDTO>> getAllPosts() {
        List<Post> posts = postService.getAllPosts();
        List<PostResponseDTO> responseList = posts.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());

        return ResponseEntity.ok(responseList);
    }

    // ==========================================
    // POST /api/v1/posts
    // ==========================================
    @PostMapping
    public ResponseEntity<PostResponseDTO> createPost(@Valid @RequestBody PostCreateRequestDTO request) {
        Post createdPost = postService.createPost(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(toResponse(createdPost));
    }

    // ==========================================
    // GET /api/v1/posts/{post_id}
    // ==========================================
    @GetMapping("/{post_id}")
    public ResponseEntity<PostResponseDTO> getPostById(@PathVariable("post_id") Long postId) {
        Post post = postService.getPostById(postId);
        return ResponseEntity.ok(toResponse(post));
    }

    // ==========================================
    // PUT /api/v1/posts/{post_id}
    // ==========================================
    @PutMapping("/{post_id}")
    public ResponseEntity<PostResponseDTO> updatePost(
            @PathVariable("post_id") Long postId,
            @Valid @RequestBody PostCreateRequestDTO request) {

        Post updatedPost = postService.updatePost(postId, request);
        return ResponseEntity.ok(toResponse(updatedPost));
    }

    // ==========================================
    // PATCH /api/v1/posts/{post_id}
    // ==========================================
    @PatchMapping("/{post_id}")
    public ResponseEntity<PostResponseDTO> patchPost(
            @PathVariable("post_id") Long postId,
            @RequestBody PostPatchRequestDTO request) {

        Post patchedPost = postService.patchPost(postId, request);
        return ResponseEntity.ok(toResponse(patchedPost));
    }

    @DeleteMapping("/{post_id}")
    public ResponseEntity<Void> deletePost(@PathVariable("post_id") Long postId) {
        postService.deletePost(postId);
        // Trả về 204 No Content
        return ResponseEntity.noContent().build();
    }
}