package com.mlog.engagement.mapper;

import com.mlog.engagement.enitty.CommentEntity;
import com.mlog.engagement.model.CommentCreateRequest;
import com.mlog.engagement.model.CommentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.openapitools.jackson.nullable.JsonNullable;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CommentMapper {
    @Mapping(target = "createdAt", expression = "java(java.time.Instant.now())")
    @Mapping(target = "updatedAt", expression = "java(java.time.Instant.now())")
    CommentEntity toCommentEntity(CommentCreateRequest commentCreateRequest);

    CommentResponse toCommentResponse(CommentEntity commentEntity);

    default UUID toUUID(JsonNullable<UUID> value) {
        if (value.isPresent()) return value.get();
        else return null;
    }

    default JsonNullable<UUID> toJsonNullableUUID(UUID value) {
        if (value == null) return JsonNullable.<UUID>undefined();
        else return JsonNullable.of(value);
    }

    default OffsetDateTime getOffsetDatetimeOf(Instant instant) {
        if (instant == null)
            return OffsetDateTime.now(ZoneOffset.ofHours(7));
        return instant.atOffset(ZoneOffset.ofHours(7));
    }

    default Instant getInstantOfOffsetDatetime(OffsetDateTime offsetDateTime) {
        if (offsetDateTime == null)
            return Instant.now();
        return offsetDateTime.toInstant();
    }
}
