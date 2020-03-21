package com.hoangdieuctu.cloud.circuilt.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableCircuitBreaker
@SpringBootApplication
@EnableHystrixDashboard
public class ServerApplication {

    @ResponseBody
    @GetMapping("/hystrix/success")
    @HystrixCommand(fallbackMethod = "successCallback")
    public String getHystrixSuccess() {
        return "Success";
    }

    @ResponseBody
    @GetMapping("/hystrix/fail")
    @HystrixCommand(fallbackMethod = "failFallback")
    public String getHystrixFail() {
        throw new RuntimeException();
    }

    public String failFallback() {
        return "Fail fallback";
    }

    public String successCallback() {
        return "Success callback";
    }

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

}
