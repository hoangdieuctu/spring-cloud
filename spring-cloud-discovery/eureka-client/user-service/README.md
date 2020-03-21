# User Service #
The service will create a REST endpoint for getting user info.

# Code
```java
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
```
# Config
It also register to eureka service with service name is **user-service** and port is **8081**.

```properties
server.port=8081
spring.application.name=user-service
eureka.client.serviceUrl.defaultZone=http://localhost:8761/eureka
eureka.instance.preferIpAddress=true
```

# Testing
1. Browser at: http://localhost:8081/user?username=hoangdieuctu
2. The response: [user-service] - hoangdieuctu