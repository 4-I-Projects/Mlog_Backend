package com.mlog.user.model;

import java.net.URI;

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
 * UserRequest
 */

@JsonTypeName("userRequest")
public class UserRequest {

  @JsonProperty("id")
  private UUID id;

  public UserRequest id(UUID id) {
    this.id = id;
    return this;
  }

  @Schema(name = "id", description = "User UUID from Keycloak")
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  private String username;

  private String displayName;

  private String bio;

  private String avatarUrl;

  public UserRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public UserRequest(String username) {
    this.username = username;
  }

  public UserRequest username(String username) {
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

  public UserRequest displayName(String displayName) {
    this.displayName = displayName;
    return this;
  }

  /**
   * user's display name
   * @return displayName
   */
  
  @Schema(name = "display_name", example = "6myduck", description = "user's display name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("display_name")
  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public UserRequest bio(String bio) {
    this.bio = bio;
    return this;
  }

  /**
   * user's bio
   * @return bio
   */
  
  @Schema(name = "bio", example = "I'm the lord of all ducks", description = "user's bio", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("bio")
  public String getBio() {
    return bio;
  }

  public void setBio(String bio) {
    this.bio = bio;
  }

  public UserRequest avatarUrl(String avatarUrl) {
    this.avatarUrl = avatarUrl;
    return this;
  }

  /**
   * Profile picture for the post.
   * @return avatarUrl
   */
  
  @Schema(name = "avatar_url", example = "https://ipfs.io/ipfs/QmQA66xJFVcP5h8fs1PJt3fXeGwVPB55Q6o8PwEx1Jc2kz", description = "Profile picture for the post.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
    UserRequest userRequest = (UserRequest) o;
    return Objects.equals(this.username, userRequest.username) &&
        Objects.equals(this.displayName, userRequest.displayName) &&
        Objects.equals(this.bio, userRequest.bio) &&
        Objects.equals(this.avatarUrl, userRequest.avatarUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(username, displayName, bio, avatarUrl);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserRequest {\n");
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

