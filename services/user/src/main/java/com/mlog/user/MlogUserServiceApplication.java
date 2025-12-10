package com.mlog.user;

import com.fasterxml.jackson.databind.Module;
import com.viettel.sdk.Vauthz;
import com.viettel.sdk.VauthzConfig;
import com.viettel.sdk.api.VauthzApiError;
import com.viettel.sdk.api.VauthzContextError;
import com.viettel.sdk.openapi.models.UserCreate;
import com.viettel.sdk.openapi.models.UserRead;
import org.openapitools.jackson.nullable.JsonNullableModule;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FullyQualifiedAnnotationBeanNameGenerator;

import java.io.IOException;

@SpringBootApplication(
    nameGenerator = FullyQualifiedAnnotationBeanNameGenerator.class
)
@ComponentScan(
    nameGenerator = FullyQualifiedAnnotationBeanNameGenerator.class
)
public class MlogUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MlogUserServiceApplication.class, args);
    }

    @Bean(name = "com.mlog.user.OpenApiGeneratorApplication.jsonNullableModule")
    public Module jsonNullableModule() {
        return new JsonNullableModule();
    }

}