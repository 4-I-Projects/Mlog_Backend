# How to run

## 1. Set up Dockerfile for services
Run the command below in every single service (user, content, engagement)
```bash
./mvnw clean package 
```

## 2. Setup docker compose network
Run docker compose and build with images if run time running
```bash
docker compose up --build 
```
else remove *--build*

## 3. Setup Keycloak
- Access keycloak admin console at [localhost:8080](http://localhost:8080) and input admin credential as configured in .env file
- Create new realms (e.g. mlog)
- Create new client in realm (e.g. mlog-frontend)
- Enable user registration in Configure/Realm settings/Login/User registration 

## 4. Setup APISIX
- Access apisix admin console at [localhost:9000](http://localhost:9000) and input admin credential
- Go to [route list](http://localhost:9000/routes/list), create route to service, list of service is below
- Enable **cors** plugin across the gateway with [the plugin tab](http://localhost:9000/plugin/list)
- Enable **openid-connect** plugin with json value of:
```json
{
  "client_id": "dummy-public-client", 
  "client_secret": "dummy-secret-not-used", 
  "discovery": "http://keycloak:8080/realms/{realm_name}/.well-known/openid-configuration",
  "bearer_only": true,
  "use_jwks": true,
  "token_signing_alg_values_expected": "RS256"
}
```

## Services
- user_service:8080
- content_service:8081
- engagement_service:8080

