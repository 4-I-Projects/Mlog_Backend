package com.mlog.backend.content_service.services;

import com.mlog.backend.content_service.entities.Post;
import com.mlog.backend.content_service.entities.Category;
import com.mlog.backend.content_service.entities.Tag;
import com.mlog.backend.content_service.utils.PostStatus;
import com.mlog.backend.content_service.dtos.requests.PostCreateRequestDTO;
import com.mlog.backend.content_service.dtos.requests.PostPatchRequestDTO;
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
        // Có thể thêm logic lọc theo status != DELETED ở đây
        return postRepository.findAll();
    }

    public Post getPostById(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Post not found with id: " + postId));
    }

    public Post createPost(PostCreateRequestDTO request) {
        Post post = new Post();

        // 1. Ánh xạ các trường cơ bản
        post.setTitle(request.getTitle());
        post.setBody(request.getBody());
        post.setAuthorId(request.getAuthorId());

        // Thiết lập Status, nếu request không cung cấp thì mặc định là DRAFT
        post.setStatus(request.getStatus() != null ? request.getStatus() : PostStatus.DRAFT);

        // Thiết lập thời gian xuất bản/lên lịch (nếu có)
        if (post.getStatus() == PostStatus.PUBLISHED) {
            post.setPublishedAt(LocalDateTime.now());
        }
        if (post.getStatus() == PostStatus.SCHEDULED) {
            post.setScheduledAt(request.getScheduledAt());
        }

        // 2. Thiết lập mối quan hệ Category (Many-to-One)
        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Invalid categoryId: Category not found."));
        post.setCategory(category);

        // 3. Thiết lập mối quan hệ Tags (Many-to-Many)
        if (request.getTagIds() != null && !request.getTagIds().isEmpty()) {
            Set<Tag> tags = new HashSet<>(tagRepository.findAllById(request.getTagIds()));
            if (tags.size() != request.getTagIds().size()) {
                // Nếu số lượng tag tìm được ít hơn số lượng tagIds yêu cầu
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "One or more Tag IDs are invalid.");
            }
            post.setTags(tags);
        }

        // Auditing fields (createdBy, createdAt) sẽ được điền tự động

        return postRepository.save(post);
    }

    // ==========================================
    // UPDATE (PUT)
    // ==========================================

    public Post updatePost(Long postId, PostCreateRequestDTO request) {
        Post post = getPostById(postId); // Lấy bài viết (hoặc ném 404)

        // 1. Cập nhật các trường cơ bản
        post.setTitle(request.getTitle());
        post.setBody(request.getBody());
        post.setAuthorId(request.getAuthorId()); // Giả định authorId có thể được cập nhật

        // Cập nhật Status và timestamps
        PostStatus newStatus = request.getStatus() != null ? request.getStatus() : PostStatus.DRAFT;

        if (newStatus != post.getStatus()) {
            // Logic chuyển trạng thái
            if (newStatus == PostStatus.PUBLISHED && post.getPublishedAt() == null) {
                post.setPublishedAt(LocalDateTime.now());
            } else if (newStatus == PostStatus.SCHEDULED) {
                post.setScheduledAt(request.getScheduledAt());
            } else if (newStatus == PostStatus.DELETED) {
                post.setDeletedAt(LocalDateTime.now());
            }
        }
        post.setStatus(newStatus);


        // 2. Cập nhật Category
        if (!post.getCategory().getId().equals(request.getCategoryId())) {
            Category category = categoryRepository.findById(request.getCategoryId())
                    .orElseThrow(() -> new ResponseStatusException(
                            HttpStatus.BAD_REQUEST, "Invalid categoryId: Category not found."));
            post.setCategory(category);
        }

        // 3. Cập nhật Tags
        if (request.getTagIds() != null) {
            Set<Tag> tags = new HashSet<>(tagRepository.findAllById(request.getTagIds()));
            if (tags.size() != request.getTagIds().size()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "One or more Tag IDs are invalid.");
            }
            post.setTags(tags);
        }

        // Auditing fields (updatedBy, updatedAt) sẽ được điền tự động

        return postRepository.save(post);
    }

    // ==========================================
    // PATCH
    // ==========================================

    public Post patchPost(Long postId, PostPatchRequestDTO request) {
        Post post = getPostById(postId); // getPostById() phải ném 404 nếu không tìm thấy

        // 1. Cập nhật các trường tùy chọn (title, body, authorId, mood)
        Optional.ofNullable(request.getTitle()).ifPresent(post::setTitle);
        Optional.ofNullable(request.getBody()).ifPresent(post::setBody);
        Optional.ofNullable(request.getAuthorId()).ifPresent(post::setAuthorId);
        Optional.ofNullable(request.getMood()).ifPresent(post::setMood); // Thêm trường mood

        // 2. Cập nhật Status và timestamps
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
                    // Đảm bảo xóa deletedAt nếu trạng thái được thay đổi từ DELETED sang trạng thái khác (ví dụ: DRAFT)
                    post.setDeletedAt(null);
                }
                post.setStatus(newStatus);
            }
        });

        // 3. Cập nhật Category (nếu cung cấp)
        Optional.ofNullable(request.getCategoryId()).ifPresent(newCatId -> {
            // Chỉ cập nhật nếu Category ID mới khác ID hiện tại
            if (!post.getCategory().getId().equals(newCatId)) {
                Category category = categoryRepository.findById(newCatId)
                        .orElseThrow(() -> new ResponseStatusException(
                                HttpStatus.BAD_REQUEST, "Invalid categoryId: Category not found."));
                post.setCategory(category);
            }
        });

        // 4. Hoàn thiện Logic Cập nhật Tags (nếu cung cấp)
        Optional.ofNullable(request.getTagIds()).ifPresent(tagIds -> {
            // Lấy tất cả các Tag từ DB dựa trên ID
            List<Tag> foundTags = tagRepository.findAllById(tagIds);

            if (foundTags.size() != tagIds.size()) {
                // Tìm ra ID nào không hợp lệ để trả về thông báo lỗi chi tiết hơn
                Set<Long> validIds = foundTags.stream().map(Tag::getId).collect(Collectors.toSet());
                Set<Long> invalidIds = tagIds.stream()
                        .filter(id -> !validIds.contains(id))
                        .collect(Collectors.toSet());

                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "One or more Tag IDs are invalid. Invalid IDs: " + invalidIds
                );
            }

            // Cập nhật Tags (JPA sẽ tự động quản lý bảng PostTag)
            post.setTags(new HashSet<>(foundTags));
        });

        // Auditing fields (updatedBy, updatedAt) sẽ được điền tự động

        return postRepository.save(post);
    }

    public void deletePost(Long postId) {
        Post post = getPostById(postId); // Lấy bài viết, ném 404 nếu không tìm thấy

        if (post.getStatus() != PostStatus.DELETED) {
            post.setStatus(PostStatus.DELETED);
            post.setDeletedAt(LocalDateTime.now());
            postRepository.save(post);
        }
    }
}