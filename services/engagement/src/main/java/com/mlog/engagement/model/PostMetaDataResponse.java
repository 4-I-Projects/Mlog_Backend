package com.mlog.engagement.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.mlog.engagement.model.CommentResponse;
import com.mlog.engagement.model.UserSummary;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.lang.Nullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * PostMetaDataResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-17T15:41:58.906115920+07:00[Asia/Ho_Chi_Minh]", comments = "Generator version: 7.17.0")
public class PostMetaDataResponse {

  @Valid
  private List<@Valid CommentResponse> comments = new ArrayList<>();

  private Integer likeCount = 0;

  private @Nullable Boolean isLiked;

  private @Nullable UserSummary user;

  public PostMetaDataResponse comments(List<@Valid CommentResponse> comments) {
    this.comments = comments;
    return this;
  }

  public PostMetaDataResponse addCommentsItem(CommentResponse commentsItem) {
    if (this.comments == null) {
      this.comments = new ArrayList<>();
    }
    this.comments.add(commentsItem);
    return this;
  }

  /**
   * Get comments
   * @return comments
   */
  @Valid 
  @Schema(name = "comments", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("comments")
  public List<@Valid CommentResponse> getComments() {
    return comments;
  }

  public void setComments(List<@Valid CommentResponse> comments) {
    this.comments = comments;
  }

  public PostMetaDataResponse likeCount(Integer likeCount) {
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

  public PostMetaDataResponse isLiked(@Nullable Boolean isLiked) {
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

  public PostMetaDataResponse user(@Nullable UserSummary user) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PostMetaDataResponse postMetaDataResponse = (PostMetaDataResponse) o;
    return Objects.equals(this.comments, postMetaDataResponse.comments) &&
        Objects.equals(this.likeCount, postMetaDataResponse.likeCount) &&
        Objects.equals(this.isLiked, postMetaDataResponse.isLiked) &&
        Objects.equals(this.user, postMetaDataResponse.user);
  }

  @Override
  public int hashCode() {
    return Objects.hash(comments, likeCount, isLiked, user);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PostMetaDataResponse {\n");
    sb.append("    comments: ").append(toIndentedString(comments)).append("\n");
    sb.append("    likeCount: ").append(toIndentedString(likeCount)).append("\n");
    sb.append("    isLiked: ").append(toIndentedString(isLiked)).append("\n");
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
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

