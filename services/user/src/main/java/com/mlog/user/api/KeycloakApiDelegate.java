package com.mlog.user.api;

import com.mlog.user.model.ApiV1AuthCallbackGet200Response;
import org.springframework.lang.Nullable;
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
 * A delegate to be called by the {@link KeycloakApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-04T10:07:53.173542+07:00[Asia/Ho_Chi_Minh]", comments = "Generator version: 7.17.0")
public interface KeycloakApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /api/v1/auth/callback : OAuth2 callback endpoint for Keycloak
     *
     * @param code  (optional)
     * @return Login successful, Session Cookie set (status code 200)
     * @see KeycloakApi#apiV1AuthCallbackGet
     */
    default ResponseEntity<ApiV1AuthCallbackGet200Response> apiV1AuthCallbackGet(String code) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"sessionId\" : \"sessionId\", \"message\" : \"message\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /api/v1/auth : Redirect to Keycloak account management page
     *
     * @return Redirect to Keycloak (status code 302)
     * @see KeycloakApi#apiV1AuthGet
     */
    default ResponseEntity<Void> apiV1AuthGet() {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /api/v1/auth/login : Redirect user to Keycloak for login
     *
     * @return Redirect to Keycloak login page (status code 302)
     * @see KeycloakApi#apiV1AuthLoginGet
     */
    default ResponseEntity<Void> apiV1AuthLoginGet() {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /api/v1/auth/logout : Logout user and end Keycloak session
     *
     * @return Redirect to Keycloak logout page (status code 302)
     * @see KeycloakApi#apiV1AuthLogoutGet
     */
    default ResponseEntity<Void> apiV1AuthLogoutGet() {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /api/v1/auth/password/reset : Redirect to Keycloak password reset page
     *
     * @return Redirect to Keycloak (status code 302)
     * @see KeycloakApi#apiV1AuthPasswordResetGet
     */
    default ResponseEntity<Void> apiV1AuthPasswordResetGet() {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /api/v1/auth/register : Redirect to Keycloak registration page
     *
     * @return Redirect to Keycloak (status code 302)
     * @see KeycloakApi#apiV1AuthRegisterGet
     */
    default ResponseEntity<Void> apiV1AuthRegisterGet() {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
