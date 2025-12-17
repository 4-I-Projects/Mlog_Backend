package com.mlog.backend.content_service.services;

import com.mlog.backend.content_service.entities.Post;
import com.mlog.backend.content_service.entities.Category;
import com.mlog.backend.content_service.entities.Tag;
import com.mlog.backend.content_service.utils.PostStatus;
import com.mlog.backend.content_service.dtos.requests.PostCreateRequest;
import com.mlog.backend.content_service.dtos.requests.PostPatchRequest;
import com.mlog.backend.content_service.repositories.PostRepository;
import com.mlog.backend.content_service.repositories.CategoryRepository;
import com.mlog.backend.content_service.repositories.TagRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TagRepository tagRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post getPostById(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Post not found with id: " + postId));
    }

    public Post createPost(PostCreateRequest request) {
        Post post = new Post();

        post.setTitle(request.getTitle());
        post.setBody(request.getBody());
        post.setAuthorId(request.getAuthorId());

        post.setStatus(request.getStatus() != null ? request.getStatus() : PostStatus.DRAFT);

        if (post.getStatus() == PostStatus.PUBLISHED) {
            post.setPublishedAt(LocalDateTime.now());
        }
        if (post.getStatus() == PostStatus.SCHEDULED) {
            post.setScheduledAt(request.getScheduledAt());
        }

        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Invalid categoryId: Category not found."));
        post.setCategory(category);

        if (request.getTagIds() != null && !request.getTagIds().isEmpty()) {
            Set<Tag> tags = new HashSet<>(tagRepository.findAllById(request.getTagIds()));
            if (tags.size() != request.getTagIds().size()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "One or more Tag IDs are invalid.");
            }
            post.setTags(tags);
        }

        return postRepository.save(post);
    }

    public Post updatePost(Long postId, PostCreateRequest request) {
        Post post = getPostById(postId);

        post.setTitle(request.getTitle());
        post.setBody(request.getBody());
        post.setAuthorId(request.getAuthorId());

        PostStatus newStatus = request.getStatus() != null ? request.getStatus() : PostStatus.DRAFT;

        if (newStatus != post.getStatus()) {
            if (newStatus == PostStatus.PUBLISHED && post.getPublishedAt() == null) {
                post.setPublishedAt(LocalDateTime.now());
            } else if (newStatus == PostStatus.SCHEDULED) {
                post.setScheduledAt(request.getScheduledAt());
            } else if (newStatus == PostStatus.DELETED) {
                post.setDeletedAt(LocalDateTime.now());
            }
        }
        post.setStatus(newStatus);

        if (!post.getCategory().getId().equals(request.getCategoryId())) {
            Category category = categoryRepository.findById(request.getCategoryId())
                    .orElseThrow(() -> new ResponseStatusException(
                            HttpStatus.BAD_REQUEST, "Invalid categoryId: Category not found."));
            post.setCategory(category);
        }

        if (request.getTagIds() != null) {
            Set<Tag> tags = new HashSet<>(tagRepository.findAllById(request.getTagIds()));
            if (tags.size() != request.getTagIds().size()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "One or more Tag IDs are invalid.");
            }
            post.setTags(tags);
        }

        return postRepository.save(post);
    }

    public Post patchPost(Long postId, PostPatchRequest request) {
        Post post = getPostById(postId);

        Optional.ofNullable(request.getTitle()).ifPresent(post::setTitle);
        Optional.ofNullable(request.getBody()).ifPresent(post::setBody);
        Optional.ofNullable(request.getAuthorId()).ifPresent(post::setAuthorId);
        Optional.ofNullable(request.getMood()).ifPresent(post::setMood);

        Optional.ofNullable(request.getStatus()).ifPresent(newStatus -> {
            if (newStatus != post.getStatus()) {
                if (newStatus == PostStatus.PUBLISHED && post.getPublishedAt() == null) {
                    post.setPublishedAt(LocalDateTime.now());
                } else if (newStatus == PostStatus.SCHEDULED) {
                    // Cần có scheduledAt trong request nếu chuyển sang SCHEDULED
                    post.setScheduledAt(request.getScheduledAt() != null ? request.getScheduledAt() : null);
                } else if (newStatus == PostStatus.DELETED) {
                    post.setDeletedAt(LocalDateTime.now());
                } else {
                    post.setDeletedAt(null);
                }
                post.setStatus(newStatus);
            }
        });

        Optional.ofNullable(request.getCategoryId()).ifPresent(newCatId -> {
            if (!post.getCategory().getId().equals(newCatId)) {
                Category category = categoryRepository.findById(newCatId)
                        .orElseThrow(() -> new ResponseStatusException(
                                HttpStatus.BAD_REQUEST, "Invalid categoryId: Category not found."));
                post.setCategory(category);
            }
        });

        Optional.ofNullable(request.getTagIds()).ifPresent(tagIds -> {
            List<Tag> foundTags = tagRepository.findAllById(tagIds);

            if (foundTags.size() != tagIds.size()) {
                Set<Long> validIds = foundTags.stream().map(Tag::getId).collect(Collectors.toSet());
                Set<Long> invalidIds = tagIds.stream()
                        .filter(id -> !validIds.contains(id))
                        .collect(Collectors.toSet());

                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "One or more Tag IDs are invalid. Invalid IDs: " + invalidIds
                );
            }

            post.setTags(new HashSet<>(foundTags));
        });

        Optional.ofNullable(request.getMood()).ifPresent(post::setMood);
        return postRepository.save(post);
    }

    public void deletePost(Long postId) {
        Post post = getPostById(postId);

        if (post.getStatus() != PostStatus.DELETED) {
            post.setStatus(PostStatus.DELETED);
            post.setDeletedAt(LocalDateTime.now());
            postRepository.save(post);
        }
    }
}