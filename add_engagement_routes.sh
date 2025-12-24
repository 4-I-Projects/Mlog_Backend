#!/bin/bash

# create upstreams
curl localhost:9180/apisix/admin/upstreams/user_route -X PUT -H 'Content-Type: application/json' -d '{
  "name": "user_service",
  "nodes": {
    "user_service:8082": 1
  }
}'
curl localhost:9180/apisix/admin/upstreams/engagement_route -X PUT -H 'Content-Type: application/json' -d '{
  "name": "engagement_service",
  "nodes": {
    "engagement_service:8080": 1
  }
}'
curl localhost:9180/apisix/admin/upstreams/content_route -X PUT -H 'Content-Type: application/json' -d '{
  "name": "content_service",
  "nodes": {
    "content_service:50051": 1
  }
}'

curl localhost:9180/apisix/admin/routes -X POST -H 'Content-Type: application/json' -d '{
    "name": "user_route",
    "uris": [
        "/api/v1/users",
        "/api/v1/users/*"
    ],
    "methods": [
        "GET",
        "POST",
        "PUT",
        "DELETE",
        "PATCH",
        "HEAD",
        "OPTIONS",
        "CONNECT",
        "TRACE",
        "PURGE"
    ],
    "upstream_id": "user_route"
}'

curl localhost:9180/apisix/admin/routes -X POST -H 'Content-Type: application/json' -d '{
    "name": "content_route",
    "uris": [
        "/api/v1/posts",
        "/api/v1/posts/*"
    ],
    "methods": [
        "GET",
        "POST",
        "PUT",
        "DELETE",
        "PATCH",
        "HEAD",
        "OPTIONS",
        "CONNECT",
        "TRACE",
        "PURGE"
    ],
    "upstream_id": "content_route"
}'

curl localhost:9180/apisix/admin/routes -X POST -H 'Content-Type: application/json' -d '{
    "name": "engagement_route",
    "uris": [
        "/api/v1/posts/*/comments", 
        "/api/v1/comments", 
        "/api/v1/comments/*",
        "/api/v1/comments/*/replies", 
        "/api/v1/posts/*/likes",
        "/api/v1/users/*/follow",
        "/api/v1/users/*/followers",
        "/api/v1/users/*/following"
    ],
    "methods": [
        "GET",
        "POST",
        "PUT",
        "DELETE",
        "PATCH",
        "HEAD",
        "OPTIONS",
        "CONNECT",
        "TRACE",
        "PURGE"
    ],
    "upstream_id": "engagement_route"
}'

curl localhost:9180/apisix/admin/global_rules/1 -X PUT -H 'Content-Type: application/json' -d '{
    "id": "1",
    "plugins": {
        "cors": {},
        "openid-connect": {
            "client_id": "dummy-public-client", 
            "client_secret": "dummy-secret-not-used", 
            "discovery": "http://keycloak:8080/realms/mlog/.well-known/openid-configuration",
            "bearer_only": true,
            "use_jwks": true,
            "token_signing_alg_values_expected": "RS256"
        }
    }
}'
