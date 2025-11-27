/* generated using openapi-typescript-codegen -- do not edit */
/* istanbul ignore file */
/* tslint:disable */
/* eslint-disable */
import type { UserSummary } from './UserSummary';
export type UserListResponse = {
    data?: Array<UserSummary>;
    meta?: {
        total?: number;
        page?: number;
        limit?: number;
        totalPages?: number;
    };
};

