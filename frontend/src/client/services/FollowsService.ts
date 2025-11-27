/* generated using openapi-typescript-codegen -- do not edit */
/* istanbul ignore file */
/* tslint:disable */
/* eslint-disable */
import type { UserListResponse } from '../models/UserListResponse';
import type { CancelablePromise } from '../core/CancelablePromise';
import { OpenAPI } from '../core/OpenAPI';
import { request as __request } from '../core/request';
export class FollowsService {
    /**
     * Follow a user (author)
     * Action: Current logged-in user follows `target_user_id`.
     * Use case: Use this when clicking "Follow" on a Profile or on a Post (get authorId from post data).
     *
     * @param targetUserId The ID of the user/author to follow
     * @returns void
     * @throws ApiError
     */
    public static postApiV1UsersFollow(
        targetUserId: number,
    ): CancelablePromise<void> {
        return __request(OpenAPI, {
            method: 'POST',
            url: '/api/v1/users/{target_user_id}/follow',
            path: {
                'target_user_id': targetUserId,
            },
            errors: {
                400: `Cannot follow yourself`,
                409: `Already following`,
            },
        });
    }
    /**
     * Unfollow a user
     * @param targetUserId
     * @returns void
     * @throws ApiError
     */
    public static deleteApiV1UsersFollow(
        targetUserId: number,
    ): CancelablePromise<void> {
        return __request(OpenAPI, {
            method: 'DELETE',
            url: '/api/v1/users/{target_user_id}/follow',
            path: {
                'target_user_id': targetUserId,
            },
        });
    }
    /**
     * Get list of followers
     * List of people who are following `user_id`.
     * @param userId
     * @param page
     * @param limit
     * @returns UserListResponse List of followers
     * @throws ApiError
     */
    public static getApiV1UsersFollowers(
        userId: number,
        page: number = 1,
        limit: number = 20,
    ): CancelablePromise<UserListResponse> {
        return __request(OpenAPI, {
            method: 'GET',
            url: '/api/v1/users/{user_id}/followers',
            path: {
                'user_id': userId,
            },
            query: {
                'page': page,
                'limit': limit,
            },
        });
    }
    /**
     * Get list of following
     * List of people that `user_id` is following.
     * @param userId
     * @param page
     * @param limit
     * @returns UserListResponse List of people being followed
     * @throws ApiError
     */
    public static getApiV1UsersFollowing(
        userId: number,
        page: number = 1,
        limit: number = 20,
    ): CancelablePromise<UserListResponse> {
        return __request(OpenAPI, {
            method: 'GET',
            url: '/api/v1/users/{user_id}/following',
            path: {
                'user_id': userId,
            },
            query: {
                'page': page,
                'limit': limit,
            },
        });
    }
}
