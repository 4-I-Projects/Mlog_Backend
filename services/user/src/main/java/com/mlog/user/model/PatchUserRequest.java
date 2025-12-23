package com.mlog.user.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * PatchUserRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-22T18:06:57.140338713+07:00[Asia/Ho_Chi_Minh]", comments = "Generator version: 7.17.0")
public class PatchUserRequest {

  private @Nullable String username;

  private @Nullable String displayName;

  private @Nullable String bio;

  private @Nullable String avatarUrl;

  public PatchUserRequest username(@Nullable String username) {
    this.username = username;
    return this;
  }

  /**
   * username, must be unique
   * @return username
   */
  
  @Schema(name = "username", example = "6myduck10293", description = "username, must be unique", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("username")
  public @Nullable String getUsername() {
    return username;
  }

  public void setUsername(@Nullable String username) {
    this.username = username;
  }

  public PatchUserRequest displayName(@Nullable String displayName) {
    this.displayName = displayName;
    return this;
  }

  /**
   * user's display name
   * @return displayName
   */
  
  @Schema(name = "display_name", example = "6myduck", description = "user's display name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("display_name")
  public @Nullable String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(@Nullable String displayName) {
    this.displayName = displayName;
  }

  public PatchUserRequest bio(@Nullable String bio) {
    this.bio = bio;
    return this;
  }

  /**
   * user's bio
   * @return bio
   */
  
  @Schema(name = "bio", example = "I'm the lord of all ducks", description = "user's bio", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("bio")
  public @Nullable String getBio() {
    return bio;
  }

  public void setBio(@Nullable String bio) {
    this.bio = bio;
  }

  public PatchUserRequest avatarUrl(@Nullable String avatarUrl) {
    this.avatarUrl = avatarUrl;
    return this;
  }

  /**
   * Profile picture for the post.
   * @return avatarUrl
   */
  
  @Schema(name = "avatar_url", example = "https://ipfs.io/ipfs/QmQA66xJFVcP5h8fs1PJt3fXeGwVPB55Q6o8PwEx1Jc2kz", description = "Profile picture for the post.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("avatar_url")
  public @Nullable String getAvatarUrl() {
    return avatarUrl;
  }

  public void setAvatarUrl(@Nullable String avatarUrl) {
    this.avatarUrl = avatarUrl;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PatchUserRequest patchUserRequest = (PatchUserRequest) o;
    return Objects.equals(this.username, patchUserRequest.username) &&
        Objects.equals(this.displayName, patchUserRequest.displayName) &&
        Objects.equals(this.bio, patchUserRequest.bio) &&
        Objects.equals(this.avatarUrl, patchUserRequest.avatarUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(username, displayName, bio, avatarUrl);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PatchUserRequest {\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    bio: ").append(toIndentedString(bio)).append("\n");
    sb.append("    avatarUrl: ").append(toIndentedString(avatarUrl)).append("\n");
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

