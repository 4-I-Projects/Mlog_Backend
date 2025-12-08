package com.mlog.backend.content_service.services;

import com.mlog.backend.content_service.dtos.requests.PostCreateRequestDTO;
import com.mlog.backend.content_service.dtos.requests.PostPatchRequestDTO;
import com.mlog.backend.content_service.models.Post;

import com.mlog.backend.content_service.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    // READ: Lấy tất cả bài viết
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    // READ: Lấy bài viết theo ID
    public Post getPostById(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Post not found with id: " + postId));
    }

    // CREATE: Tạo bài viết mới
    public Post createPost(PostCreateRequestDTO request) {
        Post post = new Post();
        post.setTitle(request.getTitle());
        post.setContent(request.getContent());
        post.setMood(request.getMood());
        return postRepository.save(post);
    }

    // PUT: Cập nhật toàn bộ bài viết
    public Post updatePost(Long postId, PostCreateRequestDTO request) {
        Post post = getPostById(postId); // Lấy bài viết (hoặc ném 404)

        // Cập nhật tất cả các trường
        post.setTitle(request.getTitle());
        post.setContent(request.getContent());
        post.setMood(request.getMood());

        return postRepository.save(post);
    }

    // PATCH: Cập nhật một phần bài viết
    public Post patchPost(Long postId, PostPatchRequestDTO request) {
        Post post = getPostById(postId); // Lấy bài viết (hoặc ném 404)

        if (request.getTitle() != null) {
            post.setTitle(request.getTitle());
        }
        if (request.getContent() != null) {
            post.setContent(request.getContent());
        }
        if (request.getMood() != null) {
            post.setMood(request.getMood());
        }

        return postRepository.save(post);
    }

    // DELETE: Xóa bài viết
    public void deletePost(Long postId) {
        if (!postRepository.existsById(postId)) {
            // Ném exception nếu không tìm thấy, giống như các phương thức GET/PUT/PATCH
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Post not found with id: " + postId);
        }
        postRepository.deleteById(postId);
    }
}
