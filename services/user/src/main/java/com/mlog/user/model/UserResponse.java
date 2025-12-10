package com.mlog.user.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.time.OffsetDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;

import jakarta.annotation.Generated;

/**
 * UserResponse
 */

@JsonTypeName("userResponse")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-03T23:46:20.550275+07:00[Asia/Ho_Chi_Minh]", comments = "Generator version: 7.17.0")
public class UserResponse {

    private UUID id;

    private String username;

    private String displayName;

    private String bio;

    private String avatarUrl;

    private Boolean banned;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime createdAt;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime updatedAt;

    public UserResponse id(UUID id) {
        this.id = id;
        return this;
    }

    /**
     * user's id, autoincrement
     *
     * @return id
     */

    @Schema(name = "id", example = "1", description = "user's id, autoincrement", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("id")
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }


    public UserResponse banned(Boolean banned) {
        this.banned = banned;
        return this;
    }

    /**
     * Whether the user is banned
     *
     * @return banned
     */

    @Schema(name = "banned", description = "Whether the user is banned", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("banned")
    public Boolean getBanned() {
        return banned;
    }

    public void setBanned(Boolean banned) {
        this.banned = banned;
    }

    public UserResponse username(String username) {
        this.username = username;
        return this;
    }

    /**
     * username, must be unique
     *
     * @return username
     */

    @Schema(name = "username", example = "6myduck10293", description = "username, must be unique", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserResponse displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * user's display name
     *
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

    public UserResponse bio(String bio) {
        this.bio = bio;
        return this;
    }

    /**
     * user's bio
     *
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

    public UserResponse avatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
        return this;
    }

    /**
     * Profile picture for the post.
     *
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

    public UserResponse createdAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * When the user created their account
     *
     * @return createdAt
     */
    @Valid
    @Schema(name = "created_at", description = "When the user created their account", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("created_at")
    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public UserResponse updatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    /**
     * When the user info was last modified
     *
     * @return updatedAt
     */
    @Valid
    @Schema(name = "updated_at", description = "When the user info was last modified", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("updated_at")
    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(OffsetDateTime updatedAt) {
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
        UserResponse userResponse = (UserResponse) o;
        return Objects.equals(this.id, userResponse.id) &&
                Objects.equals(this.username, userResponse.username) &&
                Objects.equals(this.displayName, userResponse.displayName) &&
                Objects.equals(this.bio, userResponse.bio) &&
                Objects.equals(this.banned, userResponse.banned) &&
                Objects.equals(this.avatarUrl, userResponse.avatarUrl) &&
                Objects.equals(this.createdAt, userResponse.createdAt) &&
                Objects.equals(this.updatedAt, userResponse.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, displayName, bio, avatarUrl, banned, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UserResponse {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    username: ").append(toIndentedString(username)).append("\n");
        sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
        sb.append("    bio: ").append(toIndentedString(bio)).append("\n");
        sb.append("    banned: ").append(toIndentedString(banned)).append("\n");
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

