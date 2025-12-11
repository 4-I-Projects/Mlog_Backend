package com.mlog.engagement;

import com.fasterxml.jackson.databind.Module;
import org.openapitools.jackson.nullable.JsonNullableModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FullyQualifiedAnnotationBeanNameGenerator;

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
    public Module jsonNullableModule() {
        return new JsonNullableModule();
    }
}
