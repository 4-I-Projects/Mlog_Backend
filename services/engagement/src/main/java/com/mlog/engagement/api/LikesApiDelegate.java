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
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-18T07:05:13.042309488+07:00[Asia/Ho_Chi_Minh]", comments = "Generator version: 7.17.0")
public interface LikesApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /api/v1/posts/{post_id}/likes : Get list of users who liked the post
     *
     * @param postId  (required)
     * @param xUserinfo A base64-encoded JSON object containing user claims forwarded from the API gateway. After decoding, the JSON will contain user information such as subject (user ID), roles, etc. Example decoded object: &#x60;{\&quot;sub\&quot;: \&quot;user-uuid\&quot;, \&quot;realm_access\&quot;: {\&quot;roles\&quot;: [\&quot;user\&quot;]}, \&quot;email\&quot;: \&quot;user@example.com\&quot;}&#x60; (required)
     * @param page  (optional, default to 1)
     * @param limit  (optional, default to 20)
     * @return List of users who liked the post (status code 200)
     * @see LikesApi#getAllLikesOfPost
     */
    default ResponseEntity<UserListResponse> getAllLikesOfPost(Long postId,
        String xUserinfo,
        Integer page,
        Integer limit) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"data\" : [ { \"avatarUrl\" : \"avatarUrl\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"username\" : \"username\" }, { \"avatarUrl\" : \"avatarUrl\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"username\" : \"username\" } ], \"meta\" : { \"total\" : 0, \"limit\" : 1, \"totalPages\" : 5, \"page\" : 6 } }";
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
     * @param xUserinfo A base64-encoded JSON object containing user claims forwarded from the API gateway. After decoding, the JSON will contain user information such as subject (user ID), roles, etc. Example decoded object: &#x60;{\&quot;sub\&quot;: \&quot;user-uuid\&quot;, \&quot;realm_access\&quot;: {\&quot;roles\&quot;: [\&quot;user\&quot;]}, \&quot;email\&quot;: \&quot;user@example.com\&quot;}&#x60; (required)
     * @return Liked successfully (status code 201)
     *         or Already liked (status code 409)
     * @see LikesApi#likePost
     */
    default ResponseEntity<Void> likePost(Long postId,
        String xUserinfo) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /api/v1/posts/{post_id}/likes : Unlike a post
     *
     * @param postId  (required)
     * @param xUserinfo A base64-encoded JSON object containing user claims forwarded from the API gateway. After decoding, the JSON will contain user information such as subject (user ID), roles, etc. Example decoded object: &#x60;{\&quot;sub\&quot;: \&quot;user-uuid\&quot;, \&quot;realm_access\&quot;: {\&quot;roles\&quot;: [\&quot;user\&quot;]}, \&quot;email\&quot;: \&quot;user@example.com\&quot;}&#x60; (required)
     * @return Unliked successfully (status code 204)
     * @see LikesApi#unlikePost
     */
    default ResponseEntity<Void> unlikePost(Long postId,
        String xUserinfo) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
