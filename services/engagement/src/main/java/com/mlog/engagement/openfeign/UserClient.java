package com.mlog.engagement.openfeign;

import com.mlog.engagement.model.UserSummary;
import com.mlog.engagement.openfeign.model.UserResponse;
import feign.RequestInterceptor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(value = "user-service", url = "${app.services.user.url}")
public interface UserClient {
    @GetMapping("/api/v1/users/{userId}")
    ResponseEntity<UserResponse> getUserById(@PathVariable("userId") UUID userId);


}

