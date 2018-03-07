package com.solera.global.app.metriq.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.solera.global.app.metriq")
@SpringBootApplication
@EnableAutoConfiguration
public class MetriqBoot {

    public static void main(String[] args) { 
        SpringApplication.run(MetriqBoot.class, args);
    }
}

