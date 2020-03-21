Spring Cloud Config Server is a Spring Boot application. The responsibility is get the configuration files from git and return to the client.

# Dependencies
Add *spring-cloud-config-server*
```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-config-server</artifactId>
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

# Code
The main part of the application is a config class.

Add *@EnableConfigServer*
```java
@EnableConfigServer
@SpringBootApplication
public class ServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}
}
```
# Config
Config server port and git url.

*The setting **clone-on-start** can help to identify a misconfigured configuration source (such as an invalid repository URI) quickly, while the Config Server is starting up.*
```properties
server.port=8888
spring.cloud.config.server.git.uri=https://github.com/hoangdieuctu/service-config.git
spring.cloud.config.server.git.clone-on-start=true
```
# Security
For internal use (inside VPN) we can ignore the security. However, publish cloud config server need to be set an authentication.
## Add a dependency ##
```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-security</artifactId>
</dependency>
```
## Config username and password ##
```properties
spring.security.user.name=admin
spring.security.user.password=Admin@123
```

# Testing
1. Add some files in **service-config** repository
    - config-client-dev.properties
    - config-client-prod.properties
2. Run the server
3. Browser at: http://localhost:8888/config-client-dev.properties