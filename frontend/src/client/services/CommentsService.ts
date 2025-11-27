/* generated using openapi-typescript-codegen -- do not edit */
/* istanbul ignore file */
/* tslint:disable */
/* eslint-disable */
import type { CommentCreateRequest } from '../models/CommentCreateRequest';
import type { CommentListResponse } from '../models/CommentListResponse';
import type { CommentResponse } from '../models/CommentResponse';
import type { CommentUpdateRequest } from '../models/CommentUpdateRequest';
import type { CancelablePromise } from '../core/CancelablePromise';
import { OpenAPI } from '../core/OpenAPI';
import { request as __request } from '../core/request';
export class CommentsService {
    /**
     * Get root comment for a post
     * Fetches only top-level comments (parentId = null).
     * Use `replyCount` in response to decide whether to fetch replies.
     *
     * @param postId
     * @param cursor ID/Time cursor for pagination
     * @param limit
     * @returns CommentListResponse List of comments
     * @throws ApiError
     */
    public static getApiV1PostsComments(
        postId: number,
        cursor?: string,
        limit: number = 10,
    ): CancelablePromise<CommentListResponse> {
        return __request(OpenAPI, {
            method: 'GET',
            url: '/api/v1/posts/{post_id}/comments',
            path: {
                'post_id': postId,
            },
            query: {
                'cursor': cursor,
                'limit': limit,
            },
        });
    }
    /**
     * Create a comment or reply
     * Send `parentId` to reply, leave null for root comment.
     * @param requestBody
     * @returns CommentResponse Comment created
     * @throws ApiError
     */
    public static postApiV1Comments(
        requestBody: CommentCreateRequest,
    ): CancelablePromise<CommentResponse> {
        return __request(OpenAPI, {
            method: 'POST',
            url: '/api/v1/comments',
            body: requestBody,
            mediaType: 'application/json',
        });
    }
    /**
     * Update comment content
     * User can only edit the content, not the postId or parentId.
     * @param commentId
     * @param requestBody
     * @returns CommentResponse Updated successfully
     * @throws ApiError
     */
    public static putApiV1Comments(
        commentId: string,
        requestBody: CommentUpdateRequest,
    ): CancelablePromise<CommentResponse> {
        return __request(OpenAPI, {
            method: 'PUT',
            url: '/api/v1/comments/{comment_id}',
            path: {
                'comment_id': commentId,
            },
            body: requestBody,
            mediaType: 'application/json',
            errors: {
                403: `Not authorized to edit this comment`,
            },
        });
    }
    /**
     * Soft delete a comment
     * @param commentId
     * @returns void
     * @throws ApiError
     */
    public static deleteApiV1Comments(
        commentId: string,
    ): CancelablePromise<void> {
        return __request(OpenAPI, {
            method: 'DELETE',
            url: '/api/v1/comments/{comment_id}',
            path: {
                'comment_id': commentId,
            },
        });
    }
    /**
     * Get replies of a comment (Lazy loading)
     * @param commentId
     * @param cursor
     * @param limit
     * @returns CommentListResponse List of replies
     * @throws ApiError
     */
    public static getApiV1CommentsReplies(
        commentId: string,
        cursor?: string,
        limit: number = 5,
    ): CancelablePromise<CommentListResponse> {
        return __request(OpenAPI, {
            method: 'GET',
            url: '/api/v1/comments/{comment_id}/replies',
            path: {
                'comment_id': commentId,
            },
            query: {
                'cursor': cursor,
                'limit': limit,
            },
        });
    }
}
