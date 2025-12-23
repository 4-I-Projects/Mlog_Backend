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
- Access keycloak admin console on [localhost:8080](http://localhost:8080) and input admin credential as configured in .env file
- Create new realms (e.g. mlog)
- Create new client in realm (e.g. mlog-frontend)
- Enable user registration in Configure/Realm settings/Login/User registration 

