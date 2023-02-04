package com.ninjaone.shared.infrastructure.configuration;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

@Configuration
public class EnvConfiguration {
    ResourceLoader resourceLoader;

    public EnvConfiguration(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Bean
    public Dotenv dotenv() {
        Resource resource = resourceLoader.getResource("classpath:/.env.local");

        return Dotenv
            .configure()
            .directory("/")
            .filename(resource.exists() ? ".env.local" : ".env")
            .load();
    }
}
