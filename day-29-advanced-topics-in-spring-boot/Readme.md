# Advanced Topics in Spring Boot

## Introduction to Spring Boot Actuator

Spring Boot Actuator is a sub-project of Spring Boot that provides production-ready features to help you monitor and manage your application. It includes a number of built-in endpoints and metrics that can be used to understand the state of your application and to manage it effectively.

### Key Features:

- **Health Checks**: Provides health indicators to check the status of your application.
- **Metrics**: Exposes various metrics like memory usage, CPU usage, and HTTP request counts.
- **Auditing**: Tracks and logs significant application events.
- **HTTP Tracing**: Records HTTP request-response exchange data.
- **Custom Endpoints**: Allows creating custom endpoints for specific application needs.

### Example Configuration:

Add the Spring Boot Actuator dependency in your `pom.xml`:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

Enable Actuator endpoints in your `application.properties`:

```properties
management.endpoints.web.exposure.include=*
management.endpoint.health.show-details=always
```

Access the health endpoint:

```
http://localhost:8080/actuator/health
```

## Monitoring and Managing Spring Boot Applications

Spring Boot provides robust tools for monitoring and managing applications through Actuator and integration with external monitoring systems like Prometheus and Grafana.

### Integrating with Prometheus:

Add the Prometheus dependency:

```xml
<dependency>
    <groupId>io.micrometer</groupId>
    <artifactId>micrometer-registry-prometheus</artifactId>
</dependency>
```

Configure Prometheus in `application.properties`:

```properties
management.endpoints.web.exposure.include=prometheus
```

Prometheus will now be available at:

```
http://localhost:8080/actuator/prometheus
```

### Integrating with Grafana:

1. **Set up Prometheus as a data source in Grafana.**
2. **Create dashboards to visualize metrics from the Spring Boot application.**

## Spring Boot Profiles

Spring Boot Profiles provide a way to segregate parts of your application configuration and make it only available in certain environments.

### Defining Profiles:

In your `application.properties`:

```properties
spring.profiles.active=dev
```

Create `application-dev.properties` and `application-prod.properties` for different environments.

### Using Profiles in Code:

```java
@Profile("dev")
@Service
public class DevService {
    // Development-specific service implementation
}

@Profile("prod")
@Service
public class ProdService {
    // Production-specific service implementation
}
```

## Spring Boot Testing

Spring Boot simplifies testing by providing tools and annotations to facilitate different types of testing.

### Unit Testing with JUnit:

Add testing dependencies:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
</dependency>
```

Create a test class:

```java
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyServiceTests {

    @Autowired
    private MyService myService;

    @Test
    public void testServiceMethod() {
        assertEquals("expectedValue", myService.methodToTest());
    }
}
```

### Integration Testing:

Integration tests can be done using `@SpringBootTest` to load the full application context.

```java
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MyControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetEndpoint() {
        ResponseEntity<String> response = restTemplate.getForEntity("/endpoint", String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("expectedResponse", response.getBody());
    }
}
```

## Best Practices and Tips for Developing Spring Boot Applications

1. **Modularization**: Divide your application into multiple modules for better manageability.
2. **Configuration Management**: Use Spring Cloud Config for external configuration.
3. **Security**: Implement security best practices using Spring Security.
4. **Monitoring and Logging**: Integrate Actuator, Prometheus, and centralized logging systems.
5. **Exception Handling**: Use `@ControllerAdvice` for global exception handling.
6. **Documentation**: Use tools like Swagger for API documentation.
7. **Testing**: Invest in thorough unit and integration tests.
8. **Database Migrations**: Use Flyway or Liquibase for database versioning.
