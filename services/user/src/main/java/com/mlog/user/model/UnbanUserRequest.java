package com.mlog.user.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;

/**
 * UnbanUserRequest
 */

@JsonTypeName("unbanUser_request")
public class UnbanUserRequest {

  private String reason;

  public UnbanUserRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public UnbanUserRequest(String reason) {
    this.reason = reason;
  }

  public UnbanUserRequest reason(String reason) {
    this.reason = reason;
    return this;
  }

  /**
   * The reason for unbanning the user
   * @return reason
   */
  @NotNull 
  @Schema(name = "reason", description = "The reason for unbanning the user", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("reason")
  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UnbanUserRequest unbanUserRequest = (UnbanUserRequest) o;
    return Objects.equals(this.reason, unbanUserRequest.reason);
  }

  @Override
  public int hashCode() {
    return Objects.hash(reason);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UnbanUserRequest {\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
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

