package com.mlog.engagement;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openapitools.jackson.nullable.JsonNullableModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FullyQualifiedAnnotationBeanNameGenerator;
import org.springframework.context.annotation.Primary;

@EnableFeignClients
@SpringBootApplication(
        nameGenerator = FullyQualifiedAnnotationBeanNameGenerator.class
)
@ComponentScan(
        basePackages = {"com.mlog.engagement", "com.mlog.engagement.api" , "com.mlog.engagement.config"},
        nameGenerator = FullyQualifiedAnnotationBeanNameGenerator.class
)
public class EngagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(EngagementApplication.class, args);
    }

    @Bean(name = "com.mlog.engagement.OpenApiGeneratorApplication.jsonNullableModule")
    public JsonNullableModule jsonNullableModule() {
        return new JsonNullableModule();
    }

    @Bean
    @Primary
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
