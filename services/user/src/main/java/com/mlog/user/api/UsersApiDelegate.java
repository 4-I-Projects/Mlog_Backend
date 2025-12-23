package com.mlog.user.api;

import com.mlog.user.model.PatchUserRequest;
import java.util.UUID;
import com.mlog.user.model.UpdateUserRequest;
import com.mlog.user.model.UserRequest;
import com.mlog.user.model.UserResponse;
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
 * A delegate to be called by the {@link UsersApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-22T20:43:50.450487411+07:00[Asia/Ho_Chi_Minh]", comments = "Generator version: 7.17.0")
public interface UsersApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /api/v1/users : Create user
     *
     * @param xUserinfo A base64-encoded JSON object containing user claims forwarded from the API gateway. After decoding, the JSON will contain user information such as subject (user ID), roles, etc. Example decoded object: &#x60;{\&quot;sub\&quot;: \&quot;user-uuid\&quot;, \&quot;realm_access\&quot;: {\&quot;roles\&quot;: [\&quot;user\&quot;]}, \&quot;email\&quot;: \&quot;user@example.com\&quot;}&#x60; (required)
     * @param userRequest body of user create request (required)
     * @return created (status code 201)
     * @see UsersApi#createUser
     */
    default ResponseEntity<UserResponse> createUser(String xUserinfo,
        UserRequest userRequest) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"avatar_url\" : \"https://ipfs.io/ipfs/QmQA66xJFVcP5h8fs1PJt3fXeGwVPB55Q6o8PwEx1Jc2kz\", \"updated_at\" : \"2000-01-23T04:56:07.000+00:00\", \"bio\" : \"I'm the lord of all ducks\", \"created_at\" : \"2000-01-23T04:56:07.000+00:00\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"banned\" : true, \"display_name\" : \"6myduck\", \"username\" : \"6myduck10293\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /api/v1/users/me : Get my user info
     *
     * @param xUserinfo A base64-encoded JSON object containing user claims forwarded from the API gateway. After decoding, the JSON will contain user information such as subject (user ID), roles, etc. Example decoded object: &#x60;{\&quot;sub\&quot;: \&quot;user-uuid\&quot;, \&quot;realm_access\&quot;: {\&quot;roles\&quot;: [\&quot;user\&quot;]}, \&quot;email\&quot;: \&quot;user@example.com\&quot;}&#x60; (required)
     * @return Get my user info (status code 200)
     * @see UsersApi#getCurrentUser
     */
    default ResponseEntity<UserResponse> getCurrentUser(String xUserinfo) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"avatar_url\" : \"https://ipfs.io/ipfs/QmQA66xJFVcP5h8fs1PJt3fXeGwVPB55Q6o8PwEx1Jc2kz\", \"updated_at\" : \"2000-01-23T04:56:07.000+00:00\", \"bio\" : \"I'm the lord of all ducks\", \"created_at\" : \"2000-01-23T04:56:07.000+00:00\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"banned\" : true, \"display_name\" : \"6myduck\", \"username\" : \"6myduck10293\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /api/v1/users/{user_id} : Get a specific user with the user_id
     *
     * @param userId  (required)
     * @return Get a specific user with the user_id (status code 200)
     * @see UsersApi#getUser
     */
    default ResponseEntity<UserResponse> getUser(UUID userId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"avatar_url\" : \"https://ipfs.io/ipfs/QmQA66xJFVcP5h8fs1PJt3fXeGwVPB55Q6o8PwEx1Jc2kz\", \"updated_at\" : \"2000-01-23T04:56:07.000+00:00\", \"bio\" : \"I'm the lord of all ducks\", \"created_at\" : \"2000-01-23T04:56:07.000+00:00\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"banned\" : true, \"display_name\" : \"6myduck\", \"username\" : \"6myduck10293\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /api/v1/users : Get all users
     *
     * @return get all users (status code 200)
     * @see UsersApi#listAllUsers
     */
    default ResponseEntity<List<UserResponse>> listAllUsers() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"avatar_url\" : \"https://ipfs.io/ipfs/QmQA66xJFVcP5h8fs1PJt3fXeGwVPB55Q6o8PwEx1Jc2kz\", \"updated_at\" : \"2000-01-23T04:56:07.000+00:00\", \"bio\" : \"I'm the lord of all ducks\", \"created_at\" : \"2000-01-23T04:56:07.000+00:00\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"banned\" : true, \"display_name\" : \"6myduck\", \"username\" : \"6myduck10293\" }, { \"avatar_url\" : \"https://ipfs.io/ipfs/QmQA66xJFVcP5h8fs1PJt3fXeGwVPB55Q6o8PwEx1Jc2kz\", \"updated_at\" : \"2000-01-23T04:56:07.000+00:00\", \"bio\" : \"I'm the lord of all ducks\", \"created_at\" : \"2000-01-23T04:56:07.000+00:00\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"banned\" : true, \"display_name\" : \"6myduck\", \"username\" : \"6myduck10293\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PATCH /api/v1/users/me : Edit my info
     *
     * @param xUserinfo A base64-encoded JSON object containing user claims forwarded from the API gateway. After decoding, the JSON will contain user information such as subject (user ID), roles, etc. Example decoded object: &#x60;{\&quot;sub\&quot;: \&quot;user-uuid\&quot;, \&quot;realm_access\&quot;: {\&quot;roles\&quot;: [\&quot;user\&quot;]}, \&quot;email\&quot;: \&quot;user@example.com\&quot;}&#x60; (required)
     * @param patchUserRequest  (required)
     * @return User updated successfully (status code 200)
     *         or Invalid request (status code 400)
     *         or Unauthorized (status code 401)
     * @see UsersApi#patchCurrentUser
     */
    default ResponseEntity<UserResponse> patchCurrentUser(String xUserinfo,
        PatchUserRequest patchUserRequest) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"avatar_url\" : \"https://ipfs.io/ipfs/QmQA66xJFVcP5h8fs1PJt3fXeGwVPB55Q6o8PwEx1Jc2kz\", \"updated_at\" : \"2000-01-23T04:56:07.000+00:00\", \"bio\" : \"I'm the lord of all ducks\", \"created_at\" : \"2000-01-23T04:56:07.000+00:00\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"banned\" : true, \"display_name\" : \"6myduck\", \"username\" : \"6myduck10293\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PUT /api/v1/users/me : Edit my info
     *
     * @param xUserinfo A base64-encoded JSON object containing user claims forwarded from the API gateway. After decoding, the JSON will contain user information such as subject (user ID), roles, etc. Example decoded object: &#x60;{\&quot;sub\&quot;: \&quot;user-uuid\&quot;, \&quot;realm_access\&quot;: {\&quot;roles\&quot;: [\&quot;user\&quot;]}, \&quot;email\&quot;: \&quot;user@example.com\&quot;}&#x60; (required)
     * @param updateUserRequest  (required)
     * @return User updated successfully (status code 200)
     *         or Invalid request (status code 400)
     *         or Unauthorized (status code 401)
     * @see UsersApi#putCurrentUser
     */
    default ResponseEntity<UserResponse> putCurrentUser(String xUserinfo,
        UpdateUserRequest updateUserRequest) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"avatar_url\" : \"https://ipfs.io/ipfs/QmQA66xJFVcP5h8fs1PJt3fXeGwVPB55Q6o8PwEx1Jc2kz\", \"updated_at\" : \"2000-01-23T04:56:07.000+00:00\", \"bio\" : \"I'm the lord of all ducks\", \"created_at\" : \"2000-01-23T04:56:07.000+00:00\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"banned\" : true, \"display_name\" : \"6myduck\", \"username\" : \"6myduck10293\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
