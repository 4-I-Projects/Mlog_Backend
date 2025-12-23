package com.mlog.user.mapper;

import com.mlog.user.entity.UserEntity;
import com.mlog.user.model.PatchUserRequest;
import com.mlog.user.model.UpdateUserRequest;
import com.mlog.user.model.UserRequest;
import com.mlog.user.model.UserResponse;
import org.mapstruct.*;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {
    @Mapping(target = "createdAt", expression = "java(getOffsetDatetimeOf(userEntity.getCreatedAt()))")
    @Mapping(target = "updatedAt", expression = "java(getOffsetDatetimeOf(userEntity.getUpdatedAt()))")
    UserResponse toUserResponse(UserEntity userEntity);

    @Mapping(target = "banned", constant = "false")
    UserEntity toUser(UserRequest userRequest);

    @Mapping(target = "id", ignore = true)
    void updateUserFromRequest(UpdateUserRequest updateUserRequest, @MappingTarget UserEntity userEntity);

    @Mapping(target = "id", ignore = true)
    void patchUserFromRequest(PatchUserRequest patchUserRequest, @MappingTarget UserEntity userEntity);

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
