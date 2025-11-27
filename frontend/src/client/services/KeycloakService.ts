/* generated using openapi-typescript-codegen -- do not edit */
/* istanbul ignore file */
/* tslint:disable */
/* eslint-disable */
import type { CancelablePromise } from '../core/CancelablePromise';
import { OpenAPI } from '../core/OpenAPI';
import { request as __request } from '../core/request';
export class KeycloakService {
    /**
     * Redirect to Keycloak account management page
     * @returns void
     * @throws ApiError
     */
    public static getApiV1Auth(): CancelablePromise<void> {
        return __request(OpenAPI, {
            method: 'GET',
            url: '/api/v1/auth',
            errors: {
                302: `Redirect to Keycloak`,
            },
        });
    }
    /**
     * Redirect user to Keycloak for login
     * @returns void
     * @throws ApiError
     */
    public static getApiV1AuthLogin(): CancelablePromise<void> {
        return __request(OpenAPI, {
            method: 'GET',
            url: '/api/v1/auth/login',
            errors: {
                302: `Redirect to Keycloak login page`,
            },
        });
    }
    /**
     * OAuth2 callback endpoint for Keycloak
     * @param code
     * @returns any Login successful, Session Cookie set
     * @throws ApiError
     */
    public static getApiV1AuthCallback(
        code?: string,
    ): CancelablePromise<{
        message?: string;
        sessionId?: string;
    }> {
        return __request(OpenAPI, {
            method: 'GET',
            url: '/api/v1/auth/callback',
            query: {
                'code': code,
            },
        });
    }
    /**
     * Logout user and end Keycloak session
     * @returns void
     * @throws ApiError
     */
    public static getApiV1AuthLogout(): CancelablePromise<void> {
        return __request(OpenAPI, {
            method: 'GET',
            url: '/api/v1/auth/logout',
            errors: {
                302: `Redirect to Keycloak logout page`,
            },
        });
    }
    /**
     * Redirect to Keycloak registration page
     * @returns void
     * @throws ApiError
     */
    public static getApiV1AuthRegister(): CancelablePromise<void> {
        return __request(OpenAPI, {
            method: 'GET',
            url: '/api/v1/auth/register',
            errors: {
                302: `Redirect to Keycloak`,
            },
        });
    }
    /**
     * Redirect to Keycloak password reset page
     * @returns void
     * @throws ApiError
     */
    public static getApiV1AuthPasswordReset(): CancelablePromise<void> {
        return __request(OpenAPI, {
            method: 'GET',
            url: '/api/v1/auth/password/reset',
            errors: {
                302: `Redirect to Keycloak`,
            },
        });
    }
}
