package com.hoangdieuctu.cloud.eureka.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class ServerApplication {

    @ResponseBody
    @GetMapping("/user")
    public String getUser(@RequestParam("username") String username) {
        return "[user-service] - " + username;
    }

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

}
