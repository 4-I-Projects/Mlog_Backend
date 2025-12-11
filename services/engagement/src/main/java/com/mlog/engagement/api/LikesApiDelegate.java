package com.mlog.engagement.api;

import org.springframework.lang.Nullable;
import com.mlog.engagement.model.UserListResponse;
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
 * A delegate to be called by the {@link LikesApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-11T14:36:31.411887001+07:00[Asia/Ho_Chi_Minh]", comments = "Generator version: 7.17.0")
public interface LikesApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * DELETE /api/v1/posts/{post_id}/likes : Unlike a post
     *
     * @param postId  (required)
     * @return Unliked successfully (status code 204)
     * @see LikesApi#apiV1PostsPostIdLikesDelete
     */
    default ResponseEntity<Void> apiV1PostsPostIdLikesDelete(Long postId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /api/v1/posts/{post_id}/likes : Get list of users who liked the post
     *
     * @param postId  (required)
     * @param page  (optional, default to 1)
     * @param limit  (optional, default to 20)
     * @return List of users who liked the post (status code 200)
     * @see LikesApi#apiV1PostsPostIdLikesGet
     */
    default ResponseEntity<UserListResponse> apiV1PostsPostIdLikesGet(Long postId,
        Integer page,
        Integer limit) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"data\" : [ { \"avatarUrl\" : \"avatarUrl\", \"id\" : 6, \"username\" : \"username\" }, { \"avatarUrl\" : \"avatarUrl\", \"id\" : 6, \"username\" : \"username\" } ], \"meta\" : { \"total\" : 0, \"limit\" : 1, \"totalPages\" : 5, \"page\" : 6 } }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /api/v1/posts/{post_id}/likes : Like a post
     *
     * @param postId  (required)
     * @return Liked successfully (status code 201)
     *         or Already liked (status code 409)
     * @see LikesApi#apiV1PostsPostIdLikesPost
     */
    default ResponseEntity<Void> apiV1PostsPostIdLikesPost(Long postId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
