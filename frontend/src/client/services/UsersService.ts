/* generated using openapi-typescript-codegen -- do not edit */
/* istanbul ignore file */
/* tslint:disable */
/* eslint-disable */
import type { userResponse } from '../models/userResponse';
import type { CancelablePromise } from '../core/CancelablePromise';
import { OpenAPI } from '../core/OpenAPI';
import { request as __request } from '../core/request';
export class UsersService {
    /**
     * Get all users
     * @returns userResponse get all users
     * @throws ApiError
     */
    public static listAllUsers(): CancelablePromise<Array<userResponse>> {
        return __request(OpenAPI, {
            method: 'GET',
            url: '/api/v1/users',
        });
    }
    /**
     * Get a specific user with the user_id
     * @param userId
     * @returns userResponse Get a specific user with the user_id
     * @throws ApiError
     */
    public static getUser(
        userId: string,
    ): CancelablePromise<userResponse> {
        return __request(OpenAPI, {
            method: 'GET',
            url: '/api/v1/users/{user_id}',
            path: {
                'user_id': userId,
            },
        });
    }
    /**
     * Get my user info
     * @returns userResponse Get my user info
     * @throws ApiError
     */
    public static getCurrentUser(): CancelablePromise<userResponse> {
        return __request(OpenAPI, {
            method: 'GET',
            url: '/api/v1/users/me',
        });
    }
}
