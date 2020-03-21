The Spring Cloud Config Client application will get the configuration from Config Server when starting.


# Dependencies
Add *spring-cloud-starter-config*
```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-config</artifactId>
    </dependency>
</dependencies>
```
And *spring-cloud-dependencies*
```xml
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-dependencies</artifactId>
            <version>${spring-cloud.version}</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
```
When it starting, it contact to server config to determine the resource location
```
2020-03-06 07:14:44.085  INFO 52869 --- [           main] c.c.c.ConfigServicePropertySourceLocator : Fetching config from server at : http://localhost:8888
2020-03-06 07:14:45.528  INFO 52869 --- [           main] c.c.c.ConfigServicePropertySourceLocator : Located environment: name=config-client, profiles=[dev], label=null, version=bd8f40a4f7c381f4116ecd5e634a40e9c3409a50, state=null
2020-03-06 07:14:45.529  INFO 52869 --- [           main] b.c.PropertySourceBootstrapConfiguration : Located property source: [BootstrapPropertySource {name='bootstrapProperties-configClient'}, BootstrapPropertySource {name='bootstrapProperties-https://hoangdieuctu@bitbucket.org/hoangdieuctu/service-config.git/config-client-dev.properties'}, BootstrapPropertySource {name='bootstrapProperties-https://hoangdieuctu@bitbucket.org/hoangdieuctu/service-config.git/config-client.properties'}]
```

# Sample using
*Use the properties like the local configuration*

```java
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
```
# Config
The important parts is application name and server config uri
```properties
spring.application.name=config-client
spring.cloud.config.uri=http://localhost:8888
```
# Security
If the config server enable security, add the credential.
```properties
spring.cloud.config.username=admin
spring.cloud.config.password=Admin@123
```

# Testing
1. Run the application with profile: dev

    ```
    java -jar -Dspring.profiles.active=dev client-config.jar
    ```

2. See the log

    ```
    2020-03-06 07:31:05.800  INFO 55763 --- [           main] c.h.e.s.client.ServerApplication         : User role: DEV
    ```
