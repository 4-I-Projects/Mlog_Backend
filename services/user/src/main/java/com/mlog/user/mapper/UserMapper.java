package com.mlog.user.mapper;

import com.mlog.user.entity.UserEntity;
import com.mlog.user.model.UserRequest;
import com.mlog.user.model.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {
    @Mapping(target = "createdAt", expression = "java(getOffsetDatetimeOf(userEntity.getCreatedAt()))")
    @Mapping(target = "updatedAt", expression = "java(getOffsetDatetimeOf(userEntity.getUpdatedAt()))")
    UserResponse toUserResponse(UserEntity userEntity);

    UserEntity toUser(UserRequest userRequest);

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
