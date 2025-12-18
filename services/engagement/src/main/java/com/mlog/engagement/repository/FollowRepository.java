package com.mlog.engagement.repository;

import com.mlog.engagement.enitty.FollowEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FollowRepository extends CrudRepository<FollowEntity, UUID> {
    List<FollowEntity> findAllByFollowerId(UUID followerId);

    List<FollowEntity> findAllByFollowedId(UUID followedId);

    List<FollowEntity> findByFollowerIdAndFollowedId(UUID followerId, UUID followedId);

    List<FollowEntity> deleteByFollowerIdAndFollowedId(UUID followerId, UUID followedId);
}
