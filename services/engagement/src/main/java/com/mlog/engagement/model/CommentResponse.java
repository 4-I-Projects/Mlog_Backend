package com.mlog.engagement.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.mlog.engagement.model.UserSummary;
import java.time.OffsetDateTime;
import java.util.UUID;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * CommentResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-17T15:41:58.906115920+07:00[Asia/Ho_Chi_Minh]", comments = "Generator version: 7.17.0")
public class CommentResponse {

  private @Nullable UUID id;

  private @Nullable Long postId;

  private @Nullable UUID parentId = null;

  private @Nullable String content;

  private @Nullable UserSummary user;

  private Integer likeCount = 0;

  private Integer replyCount = 0;

  private @Nullable Boolean isLiked;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable OffsetDateTime createdAt;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable OffsetDateTime updatedAt;

  public CommentResponse id(@Nullable UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   */
  @Valid 
  @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public @Nullable UUID getId() {
    return id;
  }

  public void setId(@Nullable UUID id) {
    this.id = id;
  }

  public CommentResponse postId(@Nullable Long postId) {
    this.postId = postId;
    return this;
  }

  /**
   * Get postId
   * @return postId
   */
  
  @Schema(name = "postId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("postId")
  public @Nullable Long getPostId() {
    return postId;
  }

  public void setPostId(@Nullable Long postId) {
    this.postId = postId;
  }

  public CommentResponse parentId(@Nullable UUID parentId) {
    this.parentId = parentId;
    return this;
  }

  /**
   * Get parentId
   * @return parentId
   */
  @Valid 
  @Schema(name = "parentId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("parentId")
  public @Nullable UUID getParentId() {
    return parentId;
  }

  public void setParentId(@Nullable UUID parentId) {
    this.parentId = parentId;
  }

  public CommentResponse content(@Nullable String content) {
    this.content = content;
    return this;
  }

  /**
   * Get content
   * @return content
   */
  
  @Schema(name = "content", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("content")
  public @Nullable String getContent() {
    return content;
  }

  public void setContent(@Nullable String content) {
    this.content = content;
  }

  public CommentResponse user(@Nullable UserSummary user) {
    this.user = user;
    return this;
  }

  /**
   * Get user
   * @return user
   */
  @Valid 
  @Schema(name = "user", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("user")
  public @Nullable UserSummary getUser() {
    return user;
  }

  public void setUser(@Nullable UserSummary user) {
    this.user = user;
  }

  public CommentResponse likeCount(Integer likeCount) {
    this.likeCount = likeCount;
    return this;
  }

  /**
   * Get likeCount
   * @return likeCount
   */
  
  @Schema(name = "likeCount", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("likeCount")
  public Integer getLikeCount() {
    return likeCount;
  }

  public void setLikeCount(Integer likeCount) {
    this.likeCount = likeCount;
  }

  public CommentResponse replyCount(Integer replyCount) {
    this.replyCount = replyCount;
    return this;
  }

  /**
   * Get replyCount
   * @return replyCount
   */
  
  @Schema(name = "replyCount", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("replyCount")
  public Integer getReplyCount() {
    return replyCount;
  }

  public void setReplyCount(Integer replyCount) {
    this.replyCount = replyCount;
  }

  public CommentResponse isLiked(@Nullable Boolean isLiked) {
    this.isLiked = isLiked;
    return this;
  }

  /**
   * Get isLiked
   * @return isLiked
   */
  
  @Schema(name = "isLiked", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("isLiked")
  public @Nullable Boolean getIsLiked() {
    return isLiked;
  }

  public void setIsLiked(@Nullable Boolean isLiked) {
    this.isLiked = isLiked;
  }

  public CommentResponse createdAt(@Nullable OffsetDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  /**
   * Get createdAt
   * @return createdAt
   */
  @Valid 
  @Schema(name = "createdAt", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("createdAt")
  public @Nullable OffsetDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(@Nullable OffsetDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public CommentResponse updatedAt(@Nullable OffsetDateTime updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

  /**
   * Get updatedAt
   * @return updatedAt
   */
  @Valid 
  @Schema(name = "updatedAt", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("updatedAt")
  public @Nullable OffsetDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(@Nullable OffsetDateTime updatedAt) {
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
    CommentResponse commentResponse = (CommentResponse) o;
    return Objects.equals(this.id, commentResponse.id) &&
        Objects.equals(this.postId, commentResponse.postId) &&
        Objects.equals(this.parentId, commentResponse.parentId) &&
        Objects.equals(this.content, commentResponse.content) &&
        Objects.equals(this.user, commentResponse.user) &&
        Objects.equals(this.likeCount, commentResponse.likeCount) &&
        Objects.equals(this.replyCount, commentResponse.replyCount) &&
        Objects.equals(this.isLiked, commentResponse.isLiked) &&
        Objects.equals(this.createdAt, commentResponse.createdAt) &&
        Objects.equals(this.updatedAt, commentResponse.updatedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, postId, parentId, content, user, likeCount, replyCount, isLiked, createdAt, updatedAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CommentResponse {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    postId: ").append(toIndentedString(postId)).append("\n");
    sb.append("    parentId: ").append(toIndentedString(parentId)).append("\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
    sb.append("    likeCount: ").append(toIndentedString(likeCount)).append("\n");
    sb.append("    replyCount: ").append(toIndentedString(replyCount)).append("\n");
    sb.append("    isLiked: ").append(toIndentedString(isLiked)).append("\n");
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

