# Spring Boot Configuration and Dependency Injection

## Spring Boot auto-configuration

Spring Boot’s auto-configuration feature is one of its most powerful capabilities, designed to reduce the amount of manual setup and configuration required for Spring applications. It automatically configures your Spring application based on the dependencies present on the classpath. This feature leverages convention over configuration, providing sensible defaults to streamline the development process.

### Key Concepts of Auto-Configuration

1. **Convention over Configuration**:

   - Spring Boot assumes reasonable defaults based on the libraries present in the classpath, minimizing the need for explicit configuration.

2. **Conditional Configuration**:

   - Auto-configuration beans are only created if specific conditions are met, allowing for a flexible and customizable setup.

3. **Exclusions and Overrides**:
   - Developers can exclude specific auto-configurations if they want to customize the setup further or use their configurations.

### How Auto-Configuration Works

Spring Boot’s auto-configuration is implemented using the `@EnableAutoConfiguration` annotation, which is typically used in combination with `@SpringBootApplication`.

```java
@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
```

The `@SpringBootApplication` annotation is a convenience annotation that combines `@Configuration`, `@EnableAutoConfiguration`, and `@ComponentScan`.

**Key Annotations and Classes**:

- `@EnableAutoConfiguration`: Instructs Spring Boot to start adding beans based on classpath settings, other beans, and various property settings.
- `META-INF/spring.factories`: This file lists auto-configuration classes, using the `EnableAutoConfiguration` key to point to the classes that need to be configured.

### Example: Web Application Auto-Configuration

When developing a web application with Spring Boot, the framework detects the presence of Spring MVC and Tomcat libraries in the classpath and auto-configures the necessary beans.

1. **Dependencies in `pom.xml`**:

   ```xml
   <dependencies>
       <dependency>
           <groupId>org.springframework.boot</groupId>
           <artifactId>spring-boot-starter-web</artifactId>
       </dependency>
   </dependencies>
   ```

2. **Auto-Configuration Classes**:
   - The `spring-boot-starter-web` includes `spring-boot-starter-tomcat` and `spring-boot-starter-json`, among other dependencies.
   - Spring Boot auto-configures beans like `DispatcherServlet`, `DefaultErrorAttributes`, and `DefaultErrorViewResolver`.

### Customizing Auto-Configuration

**1. Application Properties**:

- Spring Boot allows for customization of auto-configuration through the `application.properties` or `application.yml` files.

```properties
server.port=8081
spring.datasource.url=jdbc:mysql://localhost:3306/mydb
spring.datasource.username=root
spring.datasource.password=root
```

**2. Conditional Beans**:

- Use `@ConditionalOnMissingBean`, `@ConditionalOnProperty`, and other conditional annotations to control bean creation.

```java
@Configuration
public class MyAppConfig {

    @Bean
    @ConditionalOnMissingBean(DataSource.class)
    public DataSource dataSource() {
        return new HikariDataSource();
    }
}
```

**3. Excluding Auto-Configuration**:

- If you need to exclude specific auto-configurations, you can use the `@SpringBootApplication` annotation's `exclude` attribute.

```java
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
```

### Advantages of Auto-Configuration

1. **Reduced Boilerplate Code**:

   - By providing sensible defaults, auto-configuration significantly reduces the amount of code and configuration needed to set up a Spring application.

2. **Increased Productivity**:

   - Developers can focus on writing business logic rather than configuring the application infrastructure, leading to faster development cycles.

3. **Ease of Use**:
   - Auto-configuration makes it easier for new developers to start working with Spring Boot, as they don’t need to understand all the underlying configurations immediately.

### Debugging Auto-Configuration

Sometimes, it’s essential to understand what auto-configurations are being applied or why a particular configuration is not working as expected.

1. **Enable Debug Logging**:

   - Add the following property to `application.properties` to see detailed information about auto-configuration.

   ```properties
   debug=true
   ```

2. **Reviewing Auto-Configuration Report**:
   - When running the application with debug logging enabled, Spring Boot prints an auto-configuration report to the console. This report shows which configurations were applied and which were not, along with the reasons.

Spring Boot’s auto-configuration is a core feature that simplifies the setup and development of Spring applications by automatically configuring beans based on the presence of various dependencies and settings. It adheres to the principle of convention over configuration, providing sensible defaults while allowing for extensive customization and control. This approach reduces boilerplate code, increases developer productivity, and makes it easier for new developers to get started with Spring Boot.

## Externalizing configuration properties

Spring Boot provides several ways to externalize configuration, making it easy to manage environment-specific settings and other application properties. Externalizing configuration allows you to keep your code clean and your configuration flexible, enabling you to adjust settings without modifying your application’s code.

### Key Concepts

1. **Configuration Properties**: Parameters that control the behavior and functionality of your application.
2. **Profiles**: Sets of configuration that are specific to different environments (e.g., development, testing, production).
3. **Property Sources**: Locations from which configuration properties are loaded, such as property files, environment variables, command-line arguments, etc.

### Common Property Sources

1. **application.properties or application.yml**:

   - Located in the `src/main/resources` directory.
   - Default configuration file for Spring Boot applications.

2. **Profile-specific Properties**:

   - Files named `application-{profile}.properties` or `application-{profile}.yml`.
   - Activated using the `spring.profiles.active` property.

3. **Command-line Arguments**:

   - Passed when starting the application.
   - Example: `--server.port=8081`.

4. **Environment Variables**:

   - System environment variables.
   - Example: `export SERVER_PORT=8081`.

5. **Java System Properties**:

   - Passed as JVM arguments.
   - Example: `-Dserver.port=8081`.

6. **Spring Cloud Config Server**:
   - Externalized configuration server that manages properties across multiple applications and environments.

### Loading Configuration from application.properties or application.yml

**application.properties**:

```properties
server.port=8080
spring.datasource.url=jdbc:mysql://localhost:3306/mydb
spring.datasource.username=root
spring.datasource.password=root
```

**application.yml**:

```yaml
server:
  port: 8080

spring:
  datasource:
    url: jdbc:mysql://localhost:3306/mydb
    username: root
    password: root
```

### Using Profiles

**application-dev.properties**:

```properties
server.port=8081
spring.datasource.url=jdbc:mysql://localhost:3306/devdb
```

**application-prod.properties**:

```properties
server.port=8082
spring.datasource.url=jdbc:mysql://localhost:3306/proddb
```

**Activating Profiles**:

- Via `application.properties`:
  ```properties
  spring.profiles.active=dev
  ```
- Via command-line argument:
  ```sh
  java -jar demo-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod
  ```
- Via environment variable:
  ```sh
  export SPRING_PROFILES_ACTIVE=dev
  ```

### Accessing Configuration Properties in Code

**Using `@Value` Annotation**:

```java
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyComponent {

    @Value("${server.port}")
    private int serverPort;

    @Value("${spring.datasource.url}")
    private String datasourceUrl;

    // Getters and other methods...
}
```

**Using `@ConfigurationProperties`**:

```java
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
public class DatasourceConfig {

    private String url;
    private String username;
    private String password;

    // Getters and setters...
}
```

**Enabling `@ConfigurationProperties`**:

```java
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(DatasourceConfig.class)
public class AppConfig {
}
```

### Command-Line Arguments

**Running with Command-Line Arguments**:

```sh
java -jar demo-0.0.1-SNAPSHOT.jar --server.port=8083 --spring.datasource.url=jdbc:mysql://localhost:3306/testdb
```

### Environment Variables

**Setting Environment Variables**:

```sh
export SERVER_PORT=8084
export SPRING_DATASOURCE_URL=jdbc:mysql://localhost:3306/envdb
```

### Using Spring Cloud Config Server

**Setting Up Spring Cloud Config Server**:

1. **Add Dependencies**:

   ```xml
   <dependency>
       <groupId>org.springframework.cloud</groupId>
       <artifactId>spring-cloud-config-server</artifactId>
   </dependency>
   ```

2. **Enable Config Server**:

   ```java
   import org.springframework.boot.SpringApplication;
   import org.springframework.boot.autoconfigure.SpringBootApplication;
   import org.springframework.cloud.config.server.EnableConfigServer;

   @SpringBootApplication
   @EnableConfigServer
   public class ConfigServerApplication {
       public static void main(String[] args) {
           SpringApplication.run(ConfigServerApplication.class, args);
       }
   }
   ```

3. **Configure Application**:
   ```properties
   spring.cloud.config.server.git.uri=https://github.com/your-repo/config-repo
   ```

**Client Application Setup**:

1. **Add Dependencies**:

   ```xml
   <dependency>
       <groupId>org.springframework.cloud</groupId>
       <artifactId>spring-cloud-starter-config</artifactId>
   </dependency>
   ```

2. **Configure Application**:
   ```properties
   spring.config.import=optional:configserver:http://localhost:8888
   ```

Externalizing configuration properties in Spring Boot makes your application more flexible and easier to manage across different environments. By leveraging property files, profiles, environment variables, and even external configuration servers like Spring Cloud Config Server, you can create a robust and maintainable configuration strategy for your Spring Boot applications.

## Dependency Injection in Spring Boot

Dependency Injection (DI) is a fundamental concept in Spring Framework, and it plays a crucial role in building decoupled and testable applications. Spring Boot simplifies the use of DI by providing a variety of ways to inject dependencies into your application components.

### Key Concepts of Dependency Injection

1. **Inversion of Control (IoC)**: The control of object creation and dependency management is transferred from the application code to the Spring IoC container.
2. **Dependency Injection**: The process of providing dependencies to objects rather than the objects creating their own dependencies.

### Types of Dependency Injection

1. **Constructor Injection**: Dependencies are provided through a class constructor.
2. **Setter Injection**: Dependencies are provided through setter methods.
3. **Field Injection**: Dependencies are directly assigned to fields using annotations.

### Implementing Dependency Injection in Spring Boot

### 1. **Constructor Injection**

Constructor injection is considered the most preferred way of injecting dependencies, as it allows the class to be immutable and makes it easier to perform unit testing.

**Example**:

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    private final MyRepository myRepository;

    @Autowired
    public MyService(MyRepository myRepository) {
        this.myRepository = myRepository;
    }

    public void performService() {
        myRepository.doSomething();
    }
}
```

In this example, `MyService` is a service class that depends on `MyRepository`. The dependency is injected through the constructor.

### 2. **Setter Injection**

Setter injection allows the Spring container to call setter methods to inject dependencies after the object is constructed.

**Example**:

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    private MyRepository myRepository;

    @Autowired
    public void setMyRepository(MyRepository myRepository) {
        this.myRepository = myRepository;
    }

    public void performService() {
        myRepository.doSomething();
    }
}
```

In this example, `MyRepository` is injected into `MyService` using a setter method.

### 3. **Field Injection**

Field injection uses annotations to inject dependencies directly into fields. While it is less verbose, it is generally discouraged because it makes the class tightly coupled to the DI framework and harder to test.

**Example**:

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    @Autowired
    private MyRepository myRepository;

    public void performService() {
        myRepository.doSomething();
    }
}
```

In this example, `MyRepository` is injected directly into the field `myRepository` of `MyService`.

### Configuration of Dependencies

Dependencies can be configured using several annotations and XML configurations. However, annotations are more common in Spring Boot applications.

### 1. **Using `@Component`, `@Service`, `@Repository`, and `@Controller`**

Spring provides stereotype annotations to define Spring beans:

- `@Component`: Generic stereotype for any Spring-managed component.
- `@Service`: Specialization of `@Component` for service layer classes.
- `@Repository`: Specialization of `@Component` for data access layer classes.
- `@Controller`: Specialization of `@Component` for web layer classes.

**Example**:

```java
import org.springframework.stereotype.Repository;

@Repository
public class MyRepository {
    public void doSomething() {
        // Repository logic
    }
}
```

### 2. **Using `@Configuration` and `@Bean`**

`@Configuration` classes are used to define beans using the `@Bean` annotation.

**Example**:

```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MyService myService(MyRepository myRepository) {
        return new MyService(myRepository);
    }

    @Bean
    public MyRepository myRepository() {
        return new MyRepository();
    }
}
```

In this example, `AppConfig` is a configuration class that defines `MyService` and `MyRepository` beans.

### Scopes of Beans

Beans can have different scopes which define their lifecycle:

- `Singleton` (default): A single instance per Spring container.
- `Prototype`: A new instance every time it is requested.
- `Request`: A single instance per HTTP request (Web applications).
- `Session`: A single instance per HTTP session (Web applications).

**Example**:

```java
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class PrototypeService {
    // Service logic
}
```

### Autowiring Dependencies

**`@Autowired`**: Used to automatically inject dependencies by type.

**Example**:

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyComponent {

    @Autowired
    private MyService myService;

    public void execute() {
        myService.performService();
    }
}
```

**`@Qualifier`**: Used along with `@Autowired` to resolve ambiguity when multiple beans of the same type exist.

**Example**:

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    private final MyRepository myRepository;

    @Autowired
    public MyService(@Qualifier("myRepositoryImpl1") MyRepository myRepository) {
        this.myRepository = myRepository;
    }

    public void performService() {
        myRepository.doSomething();
    }
}
```

Dependency Injection in Spring Boot is a powerful mechanism that allows for better separation of concerns, easier testing, and more maintainable code. Spring Boot supports constructor injection, setter injection, and field injection, with constructor injection being the most preferred due to its advantages in immutability and testing. By using annotations such as `@Autowired`, `@Qualifier`, `@Component`, `@Service`, `@Repository`, `@Controller`, `@Configuration`, and `@Bean`, Spring Boot simplifies the management and injection of dependencies, allowing developers to focus on building robust and scalable applications.

## Introduction to Spring Boot Annotations

Spring Boot annotations simplify the development process by reducing boilerplate code and providing clear and concise ways to configure your application. These annotations can be broadly categorized based on their functionality, such as configuration, component scanning, dependency injection, web bindings, and more. Here, we'll cover the most commonly used Spring Boot annotations.

### 1. **Core Spring Boot Annotations**

**`@SpringBootApplication`**

- This is a convenience annotation that combines `@Configuration`, `@EnableAutoConfiguration`, and `@ComponentScan`.
- It enables auto-configuration and component scanning in a Spring Boot application.

```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
```

### 2. **Configuration Annotations**

**`@Configuration`**

- Indicates that the class can be used by the Spring IoC container as a source of bean definitions.
- It is used to define beans using `@Bean` methods.

```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MyService myService() {
        return new MyService();
    }
}
```

**`@Bean`**

- Indicates that a method produces a bean to be managed by the Spring container.

```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MyService myService() {
        return new MyService();
    }
}
```

**`@EnableAutoConfiguration`**

- Enables Spring Boot’s auto-configuration mechanism.

```java
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@EnableAutoConfiguration
public class MyApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }
}
```

**`@ComponentScan`**

- Configures component scanning directives for use with `@Configuration` classes.

```java
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example")
public class AppConfig {
}
```

### 3. **Stereotype Annotations**

**`@Component`**

- Indicates that an annotated class is a "component". Such classes are considered as candidates for auto-detection when using annotation-based configuration and classpath scanning.

```java
import org.springframework.stereotype.Component;

@Component
public class MyComponent {
}
```

**`@Service`**

- Specialization of `@Component` indicating that an annotated class is a "service".

```java
import org.springframework.stereotype.Service;

@Service
public class MyService {
}
```

**`@Repository`**

- Specialization of `@Component` for data access layers. It also provides a Spring Data exception translation.

```java
import org.springframework.stereotype.Repository;

@Repository
public class MyRepository {
}
```

**`@Controller`**

- Specialization of `@Component` for presentation layers, specifically for web controllers.

```java
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
    @GetMapping("/hello")
    public String sayHello() {
        return "hello";
    }
}
```

**`@RestController`**

- Combines `@Controller` and `@ResponseBody`. It indicates that the return value of the methods should be bound to the web response body.

```java
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, World!";
    }
}
```

### 4. **Dependency Injection Annotations**

**`@Autowired`**

- Marks a constructor, field, setter method, or configuration method to be autowired by Spring's dependency injection facilities.

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {
    private final MyRepository myRepository;

    @Autowired
    public MyService(MyRepository myRepository) {
        this.myRepository = myRepository;
    }
}
```

**`@Qualifier`**

- Specifies which bean to inject when multiple candidates are available.

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MyService {
    private final MyRepository myRepository;

    @Autowired
    public MyService(@Qualifier("myRepositoryImpl") MyRepository myRepository) {
        this.myRepository = myRepository;
    }
}
```

**`@Value`**

- Used to inject values from properties files into fields.

```java
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyComponent {
    @Value("${my.property}")
    private String myProperty;

    // Getters and other methods...
}
```

**`@ConfigurationProperties`**

- Binds the externalized properties to a configuration class.

```java
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app")
public class AppConfig {
    private String name;
    private String version;

    // Getters and setters...
}
```

**Enabling `@ConfigurationProperties`**:

```java
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(AppConfig.class)
public class AppConfig {
}
```

### 5. **Web Annotations**

**`@RequestMapping`**

- Provides routing information and maps HTTP requests to handler methods of MVC and REST controllers.

```java
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello() {
        return "Hello, World!";
    }
}
```

**`@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping`, `@PatchMapping`**

- Shortcut annotations for `@RequestMapping` with specific HTTP methods.

```java
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, World!";
    }
}
```

**`@PathVariable`**

- Binds a method parameter to a URI template variable.

```java
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @GetMapping("/user/{id}")
    public String getUser(@PathVariable String id) {
        return "User ID: " + id;
    }
}
```

**`@RequestParam`**

- Binds a method parameter to a web request parameter.

```java
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @GetMapping("/greet")
    public String greet(@RequestParam String name) {
        return "Hello, " + name;
    }
}
```

Spring Boot annotations provide a powerful and flexible way to manage configurations, components, and web requests in your application. Understanding these annotations and their usage can greatly enhance your ability to develop robust and maintainable Spring Boot applications. By reducing boilerplate code and enabling clear configuration, these annotations streamline the development process, allowing you to focus on building business functionality.

## Bean lifecycle in Spring Boot

In Spring Boot, beans are managed by the Spring IoC (Inversion of Control) container. Understanding the lifecycle of these beans is crucial for leveraging the full power of the Spring framework. The lifecycle includes various stages from bean instantiation to destruction, allowing developers to insert custom logic at different points.

### Key Phases of Bean Lifecycle

1. **Instantiation**: The bean is created by the Spring container.
2. **Populate Properties**: The Spring container injects dependencies as specified in the bean configuration.
3. **BeanNameAware**: If the bean implements `BeanNameAware`, the container passes the bean’s name to the `setBeanName()` method.
4. **BeanFactoryAware**: If the bean implements `BeanFactoryAware`, the container passes an instance of `BeanFactory` to the `setBeanFactory()` method.
5. **ApplicationContextAware**: If the bean implements `ApplicationContextAware`, the container passes an instance of `ApplicationContext` to the `setApplicationContext()` method.
6. **Pre-Initialization**: The `BeanPostProcessor` interface provides methods to add custom logic before and after the initialization of a bean.
7. **InitializingBean**: If the bean implements `InitializingBean`, the `afterPropertiesSet()` method is called.
8. **Custom Init Method**: If a custom initialization method is specified using the `@Bean` annotation or XML configuration, it is called.
9. **Post-Initialization**: The `BeanPostProcessor` interface provides methods to add custom logic after the initialization of a bean.
10. **Destruction**: Before the bean is destroyed, the `DisposableBean` interface and custom destroy methods (if any) are called.

### Bean Lifecycle Methods

### 1. **Instantiation**

The Spring container creates an instance of the bean.

```java
@Service
public class MyService {
    public MyService() {
        System.out.println("MyService bean instantiated");
    }
}
```

### 2. **Populate Properties**

The Spring container injects dependencies.

```java
@Service
public class MyService {

    @Autowired
    private MyRepository myRepository;

    public MyService() {
        System.out.println("MyService bean instantiated");
    }
}
```

### 3. **Aware Interfaces**

- **`BeanNameAware`**: The container calls `setBeanName()` to pass the bean’s name.

```java
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

@Component
public class MyBean implements BeanNameAware {
    @Override
    public void setBeanName(String name) {
        System.out.println("Bean name is: " + name);
    }
}
```

- **`BeanFactoryAware`**: The container calls `setBeanFactory()` to pass the `BeanFactory`.

```java
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.stereotype.Component;

@Component
public class MyBean implements BeanFactoryAware {
    @Override
    public void setBeanFactory(BeanFactory beanFactory) {
        System.out.println("BeanFactory is set");
    }
}
```

- **`ApplicationContextAware`**: The container calls `setApplicationContext()` to pass the `ApplicationContext`.

```java
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class MyBean implements ApplicationContextAware {
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        System.out.println("ApplicationContext is set");
    }
}
```

### 4. **BeanPostProcessor**

The `BeanPostProcessor` interface provides methods to add custom logic before and after the initialization of a bean.

```java
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        System.out.println("Before initialization: " + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        System.out.println("After initialization: " + beanName);
        return bean;
    }
}
```

### 5. **InitializingBean and Custom Init Method**

- **`InitializingBean`**: Implementing `afterPropertiesSet()` method.

```java
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class MyBean implements InitializingBean {
    @Override
    public void afterPropertiesSet() {
        System.out.println("After properties set");
    }
}
```

- **Custom Init Method**: Specified using `@Bean` annotation.

```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean(initMethod = "customInit")
    public MyBean myBean() {
        return new MyBean();
    }
}

public class MyBean {
    public void customInit() {
        System.out.println("Custom init method called");
    }
}
```

### 6. **DisposableBean and Custom Destroy Method**

- **`DisposableBean`**: Implementing `destroy()` method.

```java
import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

@Component
public class MyBean implements DisposableBean {
    @Override
    public void destroy() {
        System.out.println("Bean is being destroyed");
    }
}
```

- **Custom Destroy Method**: Specified using `@Bean` annotation.

```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean(destroyMethod = "customDestroy")
    public MyBean myBean() {
        return new MyBean();
    }
}

public class MyBean {
    public void customDestroy() {
        System.out.println("Custom destroy method called");
    }
}
```

The Spring Boot bean lifecycle provides a structured sequence of events from bean instantiation to destruction, offering multiple hooks for inserting custom logic at various points. By understanding and leveraging these lifecycle stages and methods, developers can build more robust, maintainable, and flexible applications. Through interfaces such as `InitializingBean` and `DisposableBean`, and annotations such as `@Bean` and `@PostConstruct`, Spring Boot makes it easy to manage bean lifecycles efficiently.
