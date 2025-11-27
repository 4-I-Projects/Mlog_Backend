/* generated using openapi-typescript-codegen -- do not edit */
/* istanbul ignore file */
/* tslint:disable */
/* eslint-disable */
import type { UserSummary } from './UserSummary';
export type CommentResponse = {
    id?: string;
    postId?: number;
    parentId?: string | null;
    content?: string;
    user?: UserSummary;
    likeCount?: number;
    replyCount?: number;
    isLiked?: boolean;
    createdAt?: string;
    updatedAt?: string;
};

