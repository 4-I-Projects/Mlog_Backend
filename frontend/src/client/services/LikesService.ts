/* generated using openapi-typescript-codegen -- do not edit */
/* istanbul ignore file */
/* tslint:disable */
/* eslint-disable */
import type { UserListResponse } from '../models/UserListResponse';
import type { CancelablePromise } from '../core/CancelablePromise';
import { OpenAPI } from '../core/OpenAPI';
import { request as __request } from '../core/request';
export class LikesService {
    /**
     * Get list of users who liked the post
     * @param postId
     * @param page
     * @param limit
     * @returns UserListResponse List of users who liked the post
     * @throws ApiError
     */
    public static getApiV1PostsLikes(
        postId: number,
        page: number = 1,
        limit: number = 20,
    ): CancelablePromise<UserListResponse> {
        return __request(OpenAPI, {
            method: 'GET',
            url: '/api/v1/posts/{post_id}/likes',
            path: {
                'post_id': postId,
            },
            query: {
                'page': page,
                'limit': limit,
            },
        });
    }
    /**
     * Like a post
     * @param postId
     * @returns any Liked successfully
     * @throws ApiError
     */
    public static postApiV1PostsLikes(
        postId: number,
    ): CancelablePromise<any> {
        return __request(OpenAPI, {
            method: 'POST',
            url: '/api/v1/posts/{post_id}/likes',
            path: {
                'post_id': postId,
            },
            errors: {
                409: `Already liked`,
            },
        });
    }
    /**
     * Unlike a post
     * @param postId
     * @returns void
     * @throws ApiError
     */
    public static deleteApiV1PostsLikes(
        postId: number,
    ): CancelablePromise<void> {
        return __request(OpenAPI, {
            method: 'DELETE',
            url: '/api/v1/posts/{post_id}/likes',
            path: {
                'post_id': postId,
            },
        });
    }
}
