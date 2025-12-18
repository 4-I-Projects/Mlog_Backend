package com.mlog.backend.content_service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ContentServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(ContentServiceApplication.class, args);
	}
}
