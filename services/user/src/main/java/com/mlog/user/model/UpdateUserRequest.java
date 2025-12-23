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
 * UpdateUserRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-22T18:06:57.140338713+07:00[Asia/Ho_Chi_Minh]", comments = "Generator version: 7.17.0")
public class UpdateUserRequest {

  private String username;

  private String displayName;

  private String bio;

  private String avatarUrl;

  public UpdateUserRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public UpdateUserRequest(String username, String displayName, String bio, String avatarUrl) {
    this.username = username;
    this.displayName = displayName;
    this.bio = bio;
    this.avatarUrl = avatarUrl;
  }

  public UpdateUserRequest username(String username) {
    this.username = username;
    return this;
  }

  /**
   * username, must be unique
   * @return username
   */
  @NotNull 
  @Schema(name = "username", example = "6myduck10293", description = "username, must be unique", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("username")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public UpdateUserRequest displayName(String displayName) {
    this.displayName = displayName;
    return this;
  }

  /**
   * user's display name
   * @return displayName
   */
  @NotNull 
  @Schema(name = "display_name", example = "6myduck", description = "user's display name", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("display_name")
  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public UpdateUserRequest bio(String bio) {
    this.bio = bio;
    return this;
  }

  /**
   * user's bio
   * @return bio
   */
  @NotNull 
  @Schema(name = "bio", example = "I'm the lord of all ducks", description = "user's bio", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("bio")
  public String getBio() {
    return bio;
  }

  public void setBio(String bio) {
    this.bio = bio;
  }

  public UpdateUserRequest avatarUrl(String avatarUrl) {
    this.avatarUrl = avatarUrl;
    return this;
  }

  /**
   * Profile picture for the post.
   * @return avatarUrl
   */
  @NotNull 
  @Schema(name = "avatar_url", example = "https://ipfs.io/ipfs/QmQA66xJFVcP5h8fs1PJt3fXeGwVPB55Q6o8PwEx1Jc2kz", description = "Profile picture for the post.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("avatar_url")
  public String getAvatarUrl() {
    return avatarUrl;
  }

  public void setAvatarUrl(String avatarUrl) {
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
    UpdateUserRequest updateUserRequest = (UpdateUserRequest) o;
    return Objects.equals(this.username, updateUserRequest.username) &&
        Objects.equals(this.displayName, updateUserRequest.displayName) &&
        Objects.equals(this.bio, updateUserRequest.bio) &&
        Objects.equals(this.avatarUrl, updateUserRequest.avatarUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(username, displayName, bio, avatarUrl);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateUserRequest {\n");
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

