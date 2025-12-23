package com.mlog.user.client;

import com.mlog.user.client.model.UserRepresentation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "keycloak-service", url = "${app.services.keycloak.url}")
public interface KeycloakClient {

    @PutMapping("/admin/realms/${app.services.keycloak.realm}/users/{userId}")
    void updateUser(
            @PathVariable("userId") String userId,
            @RequestHeader("Authorization") String bearerToken,
            UserRepresentation userRepresentation
    );
}
