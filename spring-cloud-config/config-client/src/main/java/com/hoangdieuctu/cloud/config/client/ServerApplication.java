package com.hoangdieuctu.cloud.config.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class ServerApplication {

    private static Logger logger = LoggerFactory.getLogger(ServerApplication.class);

    @Value("${user.role}")
    private String role;

    @PostConstruct
    public void init() {
        logger.info("User role: {}", role);
    }

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

}
