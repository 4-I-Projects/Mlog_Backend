package com.mlog.engagement.config;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class FeignClient {
//    @Bean
//    public RequestInterceptor requestInterceptor() {
//        return requestTemplate -> {
//            requestTemplate.header("user", username);
//            requestTemplate.header("password", password);
//            requestTemplate.header("Accept", ContentType.APPLICATION_JSON.getMimeType());
//        };
//    }
}
