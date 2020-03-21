# Auth Service #
The service will create a REST endpoint for authentication. 
It make a REST request to user-service to get user info.

# Code
```java
@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class ServerApplication {

    @Autowired
    private RestTemplate restTemplate;

    @ResponseBody
    @GetMapping("/auth")
    public String auth(@RequestParam("username") String username) {
        String url = "http://user-service/user?username=" + username;
        String resp = restTemplate.getForObject(url, String.class);
        return "[auth-service] - " + resp;
    }

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
```

# @LoadBalanced
Used as a marker annotation indicating that the annotated RestTemplate should use a RibbonLoadBalancerClient for interacting with the service(s).

# Config
It also register to eureka service with service name is **auth-service** and port is **8082**.

```properties
server.port=8082
spring.application.name=auth-service
eureka.client.serviceUrl.defaultZone=http://localhost:8761/eureka
eureka.instance.preferIpAddress=true
```

# Testing
1. Browser at: http://localhost:8082/auth?username=hoangdieuctu
2. The response: [auth-service] - [user-service] - hoangdieuctu

# Summary
The communication between services only based on the application name.