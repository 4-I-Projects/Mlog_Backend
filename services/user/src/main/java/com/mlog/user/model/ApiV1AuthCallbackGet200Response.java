package com.mlog.user.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * ApiV1AuthCallbackGet200Response
 */

@JsonTypeName("_api_v1_auth_callback_get_200_response")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-03T23:46:20.550275+07:00[Asia/Ho_Chi_Minh]", comments = "Generator version: 7.17.0")
public class ApiV1AuthCallbackGet200Response {

  private @Nullable String message;

  private @Nullable String sessionId;

  public ApiV1AuthCallbackGet200Response message(@Nullable String message) {
    this.message = message;
    return this;
  }

  /**
   * Get message
   * @return message
   */
  
  @Schema(name = "message", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("message")
  public @Nullable String getMessage() {
    return message;
  }

  public void setMessage(@Nullable String message) {
    this.message = message;
  }

  public ApiV1AuthCallbackGet200Response sessionId(@Nullable String sessionId) {
    this.sessionId = sessionId;
    return this;
  }

  /**
   * Get sessionId
   * @return sessionId
   */
  
  @Schema(name = "sessionId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("sessionId")
  public @Nullable String getSessionId() {
    return sessionId;
  }

  public void setSessionId(@Nullable String sessionId) {
    this.sessionId = sessionId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiV1AuthCallbackGet200Response apiV1AuthCallbackGet200Response = (ApiV1AuthCallbackGet200Response) o;
    return Objects.equals(this.message, apiV1AuthCallbackGet200Response.message) &&
        Objects.equals(this.sessionId, apiV1AuthCallbackGet200Response.sessionId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message, sessionId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiV1AuthCallbackGet200Response {\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    sessionId: ").append(toIndentedString(sessionId)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

