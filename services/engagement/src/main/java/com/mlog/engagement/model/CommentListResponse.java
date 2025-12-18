package com.mlog.engagement.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.mlog.engagement.model.CommentListResponseMeta;
import com.mlog.engagement.model.CommentResponse;
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
 * CommentListResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-17T15:41:58.906115920+07:00[Asia/Ho_Chi_Minh]", comments = "Generator version: 7.17.0")
public class CommentListResponse {

  @Valid
  private List<@Valid CommentResponse> data = new ArrayList<>();

  private @Nullable CommentListResponseMeta meta;

  public CommentListResponse data(List<@Valid CommentResponse> data) {
    this.data = data;
    return this;
  }

  public CommentListResponse addDataItem(CommentResponse dataItem) {
    if (this.data == null) {
      this.data = new ArrayList<>();
    }
    this.data.add(dataItem);
    return this;
  }

  /**
   * Get data
   * @return data
   */
  @Valid 
  @Schema(name = "data", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("data")
  public List<@Valid CommentResponse> getData() {
    return data;
  }

  public void setData(List<@Valid CommentResponse> data) {
    this.data = data;
  }

  public CommentListResponse meta(@Nullable CommentListResponseMeta meta) {
    this.meta = meta;
    return this;
  }

  /**
   * Get meta
   * @return meta
   */
  @Valid 
  @Schema(name = "meta", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("meta")
  public @Nullable CommentListResponseMeta getMeta() {
    return meta;
  }

  public void setMeta(@Nullable CommentListResponseMeta meta) {
    this.meta = meta;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CommentListResponse commentListResponse = (CommentListResponse) o;
    return Objects.equals(this.data, commentListResponse.data) &&
        Objects.equals(this.meta, commentListResponse.meta);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, meta);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CommentListResponse {\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    meta: ").append(toIndentedString(meta)).append("\n");
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

