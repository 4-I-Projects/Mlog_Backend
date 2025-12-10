package com.mlog.user.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;

/**
 * RoleResponse
 */
@JsonTypeName("roleResponse")
public class RoleResponse {

  private Integer id;

  private String name;

  private String displayName;

  private String bio;

  private String avatarUrl;

  private String createdAt;

  private String updatedAt;

  public RoleResponse id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * role's id, autoincrement
   * @return id
   */

  @Schema(name = "id", example = "1", description = "role's id, autoincrement", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public RoleResponse name(String name) {
    this.name = name;
    return this;
  }

  /**
   * role's name, must be unique
   * @return name
   */
  
  @Schema(name = "name", example = "6myduck10293", description = "role's name, must be unique", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public RoleResponse displayName(String displayName) {
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

  public RoleResponse bio(String bio) {
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

  public RoleResponse avatarUrl(String avatarUrl) {
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

  public RoleResponse createdAt(String createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  /**
   * When the user created their account
   * @return createdAt
   */
  
  @Schema(name = "created_at", example = "date-time", description = "When the user created their account", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("created_at")
  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public RoleResponse updatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

  /**
   * When the user info was last modified
   * @return updatedAt
   */
  
  @Schema(name = "updated_at", example = "date-time", description = "When the user info was last modified", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("updated_at")
  public String getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RoleResponse roleResponse = (RoleResponse) o;
    return Objects.equals(this.id, roleResponse.id) &&
        Objects.equals(this.name, roleResponse.name) &&
        Objects.equals(this.displayName, roleResponse.displayName) &&
        Objects.equals(this.bio, roleResponse.bio) &&
        Objects.equals(this.avatarUrl, roleResponse.avatarUrl) &&
        Objects.equals(this.createdAt, roleResponse.createdAt) &&
        Objects.equals(this.updatedAt, roleResponse.updatedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, displayName, bio, avatarUrl, createdAt, updatedAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RoleResponse {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    bio: ").append(toIndentedString(bio)).append("\n");
    sb.append("    avatarUrl: ").append(toIndentedString(avatarUrl)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
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

