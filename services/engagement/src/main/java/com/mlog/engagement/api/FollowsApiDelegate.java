package com.mlog.engagement.api;

import org.springframework.lang.Nullable;
import java.util.UUID;
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
 * A delegate to be called by the {@link FollowsApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-18T20:05:32.776621850+07:00[Asia/Ho_Chi_Minh]", comments = "Generator version: 7.17.0")
public interface FollowsApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /api/v1/users/{target_user_id}/follow : Follow a user (author)
     * Action: Current logged-in user follows &#x60;target_user_id&#x60;. Use case: Use this when clicking \&quot;Follow\&quot; on a Profile or on a Post (get authorId from post data). 
     *
     * @param targetUserId The ID of the user/author to follow (required)
     * @param xUserinfo A base64-encoded JSON object containing user claims forwarded from the API gateway. After decoding, the JSON will contain user information such as subject (user ID), roles, etc. Example decoded object: &#x60;{\&quot;sub\&quot;: \&quot;user-uuid\&quot;, \&quot;realm_access\&quot;: {\&quot;roles\&quot;: [\&quot;user\&quot;]}, \&quot;email\&quot;: \&quot;user@example.com\&quot;}&#x60; (required)
     * @return Followed successfully (status code 204)
     *         or Cannot follow yourself (status code 400)
     *         or Already following (status code 409)
     * @see FollowsApi#followUser
     */
    default ResponseEntity<Void> followUser(UUID targetUserId,
        String xUserinfo) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /api/v1/users/{user_id}/followers : Get list of followers
     * List of people who are following &#x60;user_id&#x60;.
     *
     * @param userId  (required)
     * @param xUserinfo A base64-encoded JSON object containing user claims forwarded from the API gateway. After decoding, the JSON will contain user information such as subject (user ID), roles, etc. Example decoded object: &#x60;{\&quot;sub\&quot;: \&quot;user-uuid\&quot;, \&quot;realm_access\&quot;: {\&quot;roles\&quot;: [\&quot;user\&quot;]}, \&quot;email\&quot;: \&quot;user@example.com\&quot;}&#x60; (required)
     * @param page  (optional, default to 1)
     * @param limit  (optional, default to 20)
     * @return List of followers (status code 200)
     * @see FollowsApi#getAllFollowers
     */
    default ResponseEntity<UserListResponse> getAllFollowers(UUID userId,
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
     * GET /api/v1/users/{user_id}/following : Get list of following
     * List of people that &#x60;user_id&#x60; is following.
     *
     * @param userId  (required)
     * @param xUserinfo A base64-encoded JSON object containing user claims forwarded from the API gateway. After decoding, the JSON will contain user information such as subject (user ID), roles, etc. Example decoded object: &#x60;{\&quot;sub\&quot;: \&quot;user-uuid\&quot;, \&quot;realm_access\&quot;: {\&quot;roles\&quot;: [\&quot;user\&quot;]}, \&quot;email\&quot;: \&quot;user@example.com\&quot;}&#x60; (required)
     * @param page  (optional, default to 1)
     * @param limit  (optional, default to 20)
     * @return List of people being followed (status code 200)
     * @see FollowsApi#getAllFollowing
     */
    default ResponseEntity<UserListResponse> getAllFollowing(UUID userId,
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
     * DELETE /api/v1/users/{target_user_id}/follow : Unfollow a user
     *
     * @param targetUserId  (required)
     * @param xUserinfo A base64-encoded JSON object containing user claims forwarded from the API gateway. After decoding, the JSON will contain user information such as subject (user ID), roles, etc. Example decoded object: &#x60;{\&quot;sub\&quot;: \&quot;user-uuid\&quot;, \&quot;realm_access\&quot;: {\&quot;roles\&quot;: [\&quot;user\&quot;]}, \&quot;email\&quot;: \&quot;user@example.com\&quot;}&#x60; (required)
     * @return Unfollowed successfully (status code 204)
     * @see FollowsApi#unfollowUser
     */
    default ResponseEntity<Void> unfollowUser(UUID targetUserId,
        String xUserinfo) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
