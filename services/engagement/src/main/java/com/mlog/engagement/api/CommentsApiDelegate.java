package com.mlog.engagement.api;

import com.mlog.engagement.model.CommentCreateRequest;
import com.mlog.engagement.model.CommentListResponse;
import com.mlog.engagement.model.CommentResponse;
import com.mlog.engagement.model.CommentUpdateRequest;
import org.springframework.lang.Nullable;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

/**
 * A delegate to be called by the {@link CommentsApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-18T07:05:13.042309488+07:00[Asia/Ho_Chi_Minh]", comments = "Generator version: 7.17.0")
public interface CommentsApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /api/v1/comments : Create a comment or reply
     * Send &#x60;parentId&#x60; to reply, leave null for root comment.
     *
     * @param xUserinfo A base64-encoded JSON object containing user claims forwarded from the API gateway. After decoding, the JSON will contain user information such as subject (user ID), roles, etc. Example decoded object: &#x60;{\&quot;sub\&quot;: \&quot;user-uuid\&quot;, \&quot;realm_access\&quot;: {\&quot;roles\&quot;: [\&quot;user\&quot;]}, \&quot;email\&quot;: \&quot;user@example.com\&quot;}&#x60; (required)
     * @param commentCreateRequest  (required)
     * @return Comment created (status code 201)
     * @see CommentsApi#createComment
     */
    default ResponseEntity<CommentResponse> createComment(String xUserinfo,
        CommentCreateRequest commentCreateRequest) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"replyCount\" : 1, \"isLiked\" : true, \"likeCount\" : 6, \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"postId\" : 0, \"user\" : { \"avatarUrl\" : \"avatarUrl\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"username\" : \"username\" }, \"parentId\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"content\" : \"content\", \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /api/v1/comments/{comment_id} : Soft delete a comment
     *
     * @param commentId  (required)
     * @param xUserinfo A base64-encoded JSON object containing user claims forwarded from the API gateway. After decoding, the JSON will contain user information such as subject (user ID), roles, etc. Example decoded object: &#x60;{\&quot;sub\&quot;: \&quot;user-uuid\&quot;, \&quot;realm_access\&quot;: {\&quot;roles\&quot;: [\&quot;user\&quot;]}, \&quot;email\&quot;: \&quot;user@example.com\&quot;}&#x60; (required)
     * @return Deleted (status code 204)
     * @see CommentsApi#deleteComment
     */
    default ResponseEntity<Void> deleteComment(UUID commentId,
        String xUserinfo) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PUT /api/v1/comments/{comment_id} : Update comment content
     * User can only edit the content, not the postId or parentId.
     *
     * @param commentId  (required)
     * @param xUserinfo A base64-encoded JSON object containing user claims forwarded from the API gateway. After decoding, the JSON will contain user information such as subject (user ID), roles, etc. Example decoded object: &#x60;{\&quot;sub\&quot;: \&quot;user-uuid\&quot;, \&quot;realm_access\&quot;: {\&quot;roles\&quot;: [\&quot;user\&quot;]}, \&quot;email\&quot;: \&quot;user@example.com\&quot;}&#x60; (required)
     * @param commentUpdateRequest  (required)
     * @return Updated successfully (status code 200)
     *         or Not authorized to edit this comment (status code 403)
     * @see CommentsApi#editComment
     */
    default ResponseEntity<CommentResponse> editComment(UUID commentId,
        String xUserinfo,
        CommentUpdateRequest commentUpdateRequest) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"replyCount\" : 1, \"isLiked\" : true, \"likeCount\" : 6, \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"postId\" : 0, \"user\" : { \"avatarUrl\" : \"avatarUrl\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"username\" : \"username\" }, \"parentId\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"content\" : \"content\", \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /api/v1/posts/{post_id}/comments : Get root comment for a post
     * Fetches only top-level comments (parentId &#x3D; null).  Use &#x60;replyCount&#x60; in response to decide whether to fetch replies. 
     *
     * @param postId  (required)
     * @param cursor ID/Time cursor for pagination (optional)
     * @param limit  (optional, default to 10)
     * @return List of comments (status code 200)
     * @see CommentsApi#getAllCommentsOnPost
     */
    default ResponseEntity<CommentListResponse> getAllCommentsOnPost(Long postId,
        String cursor,
        Integer limit) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"data\" : [ { \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"replyCount\" : 1, \"isLiked\" : true, \"likeCount\" : 6, \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"postId\" : 0, \"user\" : { \"avatarUrl\" : \"avatarUrl\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"username\" : \"username\" }, \"parentId\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"content\" : \"content\", \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\" }, { \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"replyCount\" : 1, \"isLiked\" : true, \"likeCount\" : 6, \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"postId\" : 0, \"user\" : { \"avatarUrl\" : \"avatarUrl\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"username\" : \"username\" }, \"parentId\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"content\" : \"content\", \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\" } ], \"meta\" : { \"nextCursor\" : \"nextCursor\", \"limit\" : 5 } }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /api/v1/comments/{comment_id}/replies : Get replies of a comment (Lazy loading)
     *
     * @param commentId  (required)
     * @param cursor  (optional)
     * @param limit  (optional, default to 5)
     * @return List of replies (status code 200)
     * @see CommentsApi#getAllRepliesOfComment
     */
    default ResponseEntity<CommentListResponse> getAllRepliesOfComment(UUID commentId,
        String cursor,
        Integer limit) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"data\" : [ { \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"replyCount\" : 1, \"isLiked\" : true, \"likeCount\" : 6, \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"postId\" : 0, \"user\" : { \"avatarUrl\" : \"avatarUrl\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"username\" : \"username\" }, \"parentId\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"content\" : \"content\", \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\" }, { \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"replyCount\" : 1, \"isLiked\" : true, \"likeCount\" : 6, \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"postId\" : 0, \"user\" : { \"avatarUrl\" : \"avatarUrl\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"username\" : \"username\" }, \"parentId\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"content\" : \"content\", \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\" } ], \"meta\" : { \"nextCursor\" : \"nextCursor\", \"limit\" : 5 } }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
