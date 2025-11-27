/* generated using openapi-typescript-codegen -- do not edit */
/* istanbul ignore file */
/* tslint:disable */
/* eslint-disable */
export type roleResponse = {
    /**
     * role's id, autoincrement
     */
    id?: number;
    /**
     * role's name, must be unique
     */
    name?: string;
    /**
     * user's display name
     */
    display_name?: string;
    /**
     * user's bio
     */
    bio?: string;
    /**
     * Profile picture for the post.
     */
    avatar_url?: string;
    /**
     * When the user created their account
     */
    created_at?: string;
    /**
     * When the user info was last modified
     */
    updated_at?: string;
};

