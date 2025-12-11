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
 * A delegate to be called by the {@link FollowsApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-11T14:36:31.411887001+07:00[Asia/Ho_Chi_Minh]", comments = "Generator version: 7.17.0")
public interface FollowsApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * DELETE /api/v1/users/{target_user_id}/follow : Unfollow a user
     *
     * @param targetUserId  (required)
     * @return Unfollowed successfully (status code 204)
     * @see FollowsApi#apiV1UsersTargetUserIdFollowDelete
     */
    default ResponseEntity<Void> apiV1UsersTargetUserIdFollowDelete(Integer targetUserId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /api/v1/users/{target_user_id}/follow : Follow a user (author)
     * Action: Current logged-in user follows &#x60;target_user_id&#x60;. Use case: Use this when clicking \&quot;Follow\&quot; on a Profile or on a Post (get authorId from post data). 
     *
     * @param targetUserId The ID of the user/author to follow (required)
     * @return Followed successfully (status code 204)
     *         or Cannot follow yourself (status code 400)
     *         or Already following (status code 409)
     * @see FollowsApi#apiV1UsersTargetUserIdFollowPost
     */
    default ResponseEntity<Void> apiV1UsersTargetUserIdFollowPost(Integer targetUserId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /api/v1/users/{user_id}/followers : Get list of followers
     * List of people who are following &#x60;user_id&#x60;.
     *
     * @param userId  (required)
     * @param page  (optional, default to 1)
     * @param limit  (optional, default to 20)
     * @return List of followers (status code 200)
     * @see FollowsApi#apiV1UsersUserIdFollowersGet
     */
    default ResponseEntity<UserListResponse> apiV1UsersUserIdFollowersGet(Integer userId,
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
     * GET /api/v1/users/{user_id}/following : Get list of following
     * List of people that &#x60;user_id&#x60; is following.
     *
     * @param userId  (required)
     * @param page  (optional, default to 1)
     * @param limit  (optional, default to 20)
     * @return List of people being followed (status code 200)
     * @see FollowsApi#apiV1UsersUserIdFollowingGet
     */
    default ResponseEntity<UserListResponse> apiV1UsersUserIdFollowingGet(Integer userId,
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

}
