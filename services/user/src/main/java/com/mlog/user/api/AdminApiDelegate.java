package com.mlog.user.api;

import com.mlog.user.model.BanUserRequest;
import java.util.UUID;
import com.mlog.user.model.UnbanUserRequest;
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
 * A delegate to be called by the {@link AdminApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-07T20:19:34.840755520+07:00[Asia/Ho_Chi_Minh]", comments = "Generator version: 7.17.0")
public interface AdminApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /api/v1/admin/users/{user_id}/ban : Ban user with user_id
     *
     * @param userId  (required)
     * @param banUserRequest Information about why the user is banned (required)
     * @return User banned successfully (status code 200)
     * @see AdminApi#banUser
     */
    default ResponseEntity<Void> banUser(UUID userId,
        BanUserRequest banUserRequest) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /api/v1/admin/users/{user_id}/unban : Unban user with user_id
     *
     * @param userId  (required)
     * @param unbanUserRequest Informations about why the user is unbanned (required)
     * @return User unbanned successfully (status code 200)
     * @see AdminApi#unbanUser
     */
    default ResponseEntity<Void> unbanUser(UUID userId,
        UnbanUserRequest unbanUserRequest) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
