/* generated using openapi-typescript-codegen -- do not edit */
/* istanbul ignore file */
/* tslint:disable */
/* eslint-disable */
import type { CancelablePromise } from '../core/CancelablePromise';
import { OpenAPI } from '../core/OpenAPI';
import { request as __request } from '../core/request';
export class AdminService {
    /**
     * Ban user with user_id
     * @param userId
     * @param requestBody Information about why the user is banned
     * @returns any User banned successfully
     * @throws ApiError
     */
    public static banUser(
        userId: string,
        requestBody: {
            /**
             * The reason for banning the user
             */
            reason: string;
        },
    ): CancelablePromise<any> {
        return __request(OpenAPI, {
            method: 'POST',
            url: '/api/v1/admin/users/{user_id}/ban',
            path: {
                'user_id': userId,
            },
            body: requestBody,
            mediaType: 'application/json',
        });
    }
    /**
     * Unban user with user_id
     * @param userId
     * @param requestBody Informations about why the user is unbanned
     * @returns any User unbanned successfully
     * @throws ApiError
     */
    public static unbanUser(
        userId: string,
        requestBody: {
            /**
             * The reason for unbanning the user
             */
            reason: string;
        },
    ): CancelablePromise<any> {
        return __request(OpenAPI, {
            method: 'POST',
            url: '/api/v1/admin/users/{user_id}/unban',
            path: {
                'user_id': userId,
            },
            body: requestBody,
            mediaType: 'application/json',
        });
    }
}
