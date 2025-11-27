/* generated using openapi-typescript-codegen -- do not edit */
/* istanbul ignore file */
/* tslint:disable */
/* eslint-disable */
import type { postCreateRequest } from '../models/postCreateRequest';
import type { postPatchRequest } from '../models/postPatchRequest';
import type { postResponse } from '../models/postResponse';
import type { CancelablePromise } from '../core/CancelablePromise';
import { OpenAPI } from '../core/OpenAPI';
import { request as __request } from '../core/request';
export class PostsService {
    /**
     * Returns list of all posts
     * @returns postResponse List of posts
     * @throws ApiError
     */
    public static getApiV1Posts(): CancelablePromise<Array<postResponse>> {
        return __request(OpenAPI, {
            method: 'GET',
            url: '/api/v1/posts',
        });
    }
    /**
     * Creates a new post
     * @param requestBody
     * @returns postResponse post created
     * @throws ApiError
     */
    public static postApiV1Posts(
        requestBody: postCreateRequest,
    ): CancelablePromise<postResponse> {
        return __request(OpenAPI, {
            method: 'POST',
            url: '/api/v1/posts',
            body: requestBody,
            mediaType: 'application/json',
            errors: {
                400: `Bad request`,
            },
        });
    }
    /**
     * Getting post by id
     * @param postId
     * @returns postResponse post found
     * @throws ApiError
     */
    public static getApiV1Posts1(
        postId: number,
    ): CancelablePromise<postResponse> {
        return __request(OpenAPI, {
            method: 'GET',
            url: '/api/v1/posts/{post_id}',
            path: {
                'post_id': postId,
            },
            errors: {
                404: `post not found`,
            },
        });
    }
    /**
     * Edit a post using id
     * @param postId
     * @param requestBody
     * @returns postResponse post updated successfully
     * @throws ApiError
     */
    public static putApiV1Posts(
        postId: number,
        requestBody: postCreateRequest,
    ): CancelablePromise<postResponse> {
        return __request(OpenAPI, {
            method: 'PUT',
            url: '/api/v1/posts/{post_id}',
            path: {
                'post_id': postId,
            },
            body: requestBody,
            mediaType: 'application/json',
            errors: {
                400: `Missing required fields`,
                404: `post not found`,
            },
        });
    }
    /**
     * Edit a post using id
     * @param postId
     * @param requestBody
     * @returns postResponse post patched successfully
     * @throws ApiError
     */
    public static patchApiV1Posts(
        postId: number,
        requestBody: postPatchRequest,
    ): CancelablePromise<postResponse> {
        return __request(OpenAPI, {
            method: 'PATCH',
            url: '/api/v1/posts/{post_id}',
            path: {
                'post_id': postId,
            },
            body: requestBody,
            mediaType: 'application/json',
            errors: {
                400: `Missing required fields`,
                404: `post not found`,
            },
        });
    }
    /**
     * Delete post using id
     * @param postId
     * @returns void
     * @throws ApiError
     */
    public static deleteApiV1Posts(
        postId: number,
    ): CancelablePromise<void> {
        return __request(OpenAPI, {
            method: 'DELETE',
            url: '/api/v1/posts/{post_id}',
            path: {
                'post_id': postId,
            },
        });
    }
}
