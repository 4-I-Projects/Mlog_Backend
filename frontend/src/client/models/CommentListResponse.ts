/* generated using openapi-typescript-codegen -- do not edit */
/* istanbul ignore file */
/* tslint:disable */
/* eslint-disable */
import type { CommentResponse } from './CommentResponse';
export type CommentListResponse = {
    data?: Array<CommentResponse>;
    meta?: {
        nextCursor?: string | null;
        limit?: number;
    };
};

