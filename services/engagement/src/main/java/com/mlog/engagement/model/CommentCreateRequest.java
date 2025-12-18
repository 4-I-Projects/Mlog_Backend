package com.mlog.engagement.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.UUID;
import org.springframework.lang.Nullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * CommentCreateRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-17T15:41:58.906115920+07:00[Asia/Ho_Chi_Minh]", comments = "Generator version: 7.17.0")
public class CommentCreateRequest {

  private Long postId;

  private @Nullable UUID parentId = null;

  private String content;

  public CommentCreateRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CommentCreateRequest(Long postId, String content) {
    this.postId = postId;
    this.content = content;
  }

  public CommentCreateRequest postId(Long postId) {
    this.postId = postId;
    return this;
  }

  /**
   * Get postId
   * @return postId
   */
  @NotNull 
  @Schema(name = "postId", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("postId")
  public Long getPostId() {
    return postId;
  }

  public void setPostId(Long postId) {
    this.postId = postId;
  }

  public CommentCreateRequest parentId(@Nullable UUID parentId) {
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

  public CommentCreateRequest content(String content) {
    this.content = content;
    return this;
  }

  /**
   * Get content
   * @return content
   */
  @NotNull @Size(min = 1, max = 2000) 
  @Schema(name = "content", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("content")
  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CommentCreateRequest commentCreateRequest = (CommentCreateRequest) o;
    return Objects.equals(this.postId, commentCreateRequest.postId) &&
        Objects.equals(this.parentId, commentCreateRequest.parentId) &&
        Objects.equals(this.content, commentCreateRequest.content);
  }

  @Override
  public int hashCode() {
    return Objects.hash(postId, parentId, content);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CommentCreateRequest {\n");
    sb.append("    postId: ").append(toIndentedString(postId)).append("\n");
    sb.append("    parentId: ").append(toIndentedString(parentId)).append("\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
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

