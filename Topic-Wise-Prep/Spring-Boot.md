# SpringBoot

## Must Know Annotations:

1. @SpringBootApplication
2. @RestController
3. @RequestMapping
4. @GetMapping, @PostMapping, @PutMapping, @DeleteMapping, @PatchMapping
5. @Autowired
6. @Component, @Service, @Repository, @Controller
7. @Configuration
8. @Bean
9. @Entity
10. @Table, @Id, @GeneratedValue
11. @EnableAUtoConfiguration
12. @ComponentScan
13. @Value
14. @Profile
15. @PathVariable
16. @RequestParam
17. @RequestBody
18. @ResponseBody
19. @ExceptionHandler

## 3+ YOE SpringBoot Questions

1. Explain the concept of auto-configuration in Spring Boot.
2. Describe how to create a RESTful web service using Spring Boot. Provide a basic example with CRUD operations.
3. How do you handle exceptions in a Spring Boot application?
4. Explain how to use Spring Boot Actuator. What are some of the important endpoints?
5. How can you secure a Spring Boot application? Demonstrate the use of Spring Security for basic authentication and authorization.
6. How do you configure and use externalized configuration properties in a Spring Boot application? Provide an example using application.properties or application.yml.
7. Describe how to implement and use custom configuration properties in Spring Boot.
8. How do you set up and use multiple profiles in a Spring Boot application? Provide an example where different profiles have different configurations.
9. Explain how to configure and use Spring Data JPA with a Spring Boot application.
10. How do you write unit tests for a Spring Boot application? Provide an example of testing a service layer.
11. Demonstrate how to consume a RESTful web service in a Spring Boot application using RestTemplate or WebClient.
12. Explain how to implement asynchronous processing in a Spring Boot application. Provide an example using @Async.
13. What are the differences between Lazy and Eager Loading in Hibernate?
14. How to connect a Spring Boot application to a database using JDBC.
15. Differences between JPA and Hibernate.
16. How to create a custom endpoint in Spring Boot Actuator.
17. Differences between @SpringBootApplication and @EnableAutoConfiguration annotation.



----
----
----
----

# Comprehensive Guide to Spring Boot Annotations

## 1. Core Spring Annotations

### `@SpringBootApplication`
- **Summary**: Combines `@Configuration`, `@EnableAutoConfiguration`, and `@ComponentScan` with their default attributes.
- **Code Example**:
    ```java
    @SpringBootApplication
    public class MySpringBootApplication {
        public static void main(String[] args) {
            SpringApplication.run(MySpringBootApplication.class, args);
        }
    }
    ```

### `@Configuration`
- **Summary**: Indicates that the class can be used by the Spring IoC container as a source of bean definitions.
- **Code Example**:
    ```java
    @Configuration
    public class AppConfig {
        @Bean
        public MyService myService() {
            return new MyService();
        }
    }
    ```

### `@ComponentScan`
- **Summary**: Configures component scanning directives for use with `@Configuration` classes.
- **Code Example**:
    ```java
    @Configuration
    @ComponentScan(basePackages = "com.example")
    public class AppConfig {
    }
    ```

### `@Bean`
- **Summary**: Indicates that a method produces a bean to be managed by the Spring container.
- **Code Example**:
    ```java
    @Configuration
    public class AppConfig {
        @Bean
        public MyService myService() {
            return new MyService();
        }
    }
    ```

### `@Value`
- **Summary**: Injects values into fields from properties files.
- **Code Example**:
    ```java
    @Component
    public class MyComponent {
        @Value("${my.property}")
        private String myProperty;
    }
    ```

### `@Lazy`
- **Summary**: Marks a bean as lazy-initialized.
- **Code Example**:
    ```java
    @Configuration
    public class AppConfig {
        @Bean
        @Lazy
        public MyService myService() {
            return new MyService();
        }
    }
    ```

### `@Primary`
- **Summary**: Indicates that a bean should be given preference when multiple candidates are qualified to autowire a single-valued dependency.
- **Code Example**:
    ```java
    @Configuration
    public class AppConfig {
        @Bean
        @Primary
        public MyService myPrimaryService() {
            return new MyService();
        }
    }
    ```

### `@DependsOn`
- **Summary**: Specifies the bean dependencies.
- **Code Example**:
    ```java
    @Configuration
    public class AppConfig {
        @Bean
        @DependsOn({"bean1", "bean2"})
        public MyService myService() {
            return new MyService();
        }
    }
    ```

## 2. Spring Boot Testing Annotations

### `@SpringBootTest`
- **Summary**: Used to test Spring Boot applications.
- **Code Example**:
    ```java
    @SpringBootTest
    public class MySpringBootTests {
        @Test
        public void contextLoads() {
        }
    }
    ```

### `@MockBean`
- **Summary**: Used to add mock objects to the Spring application context.
- **Code Example**:
    ```java
    @SpringBootTest
    public class MySpringBootTests {
        @MockBean
        private MyService myService;

        @Test
        public void contextLoads() {
        }
    }
    ```

### `@SpyBean`
- **Summary**: Used to add spy objects to the Spring application context.
- **Code Example**:
    ```java
    @SpringBootTest
    public class MySpringBootTests {
        @SpyBean
        private MyService myService;

        @Test
        public void contextLoads() {
        }
    }
    ```

### `@WebMvcTest`
- **Summary**: Used for Spring MVC tests.
- **Code Example**:
    ```java
    @WebMvcTest
    public class MyWebMvcTests {
        @Autowired
        private MockMvc mockMvc;

        @Test
        public void shouldReturnDefaultMessage() throws Exception {
            this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                    .andExpect(content().string(containsString("Hello, World")));
        }
    }
    ```

### `@DataJpaTest`
- **Summary**: Used for JPA tests.
- **Code Example**:
    ```java
    @DataJpaTest
    public class MyDataJpaTests {
        @Autowired
        private UserRepository userRepository;

        @Test
        public void testFindByName() {
            User user = userRepository.findByName("John");
            assertThat(user.getName()).isEqualTo("John");
        }
    }
    ```

### `@RestClientTest`
- **Summary**: Used to test REST clients.
- **Code Example**:
    ```java
    @RestClientTest(MyRestClient.class)
    public class MyRestClientTests {
        @Autowired
        private MyRestClient myRestClient;

        @Test
        public void testGetHello() {
            String response = myRestClient.getHello();
            assertThat(response).isEqualTo("Hello");
        }
    }
    ```

### `@AutoConfigureMockMvc`
- **Summary**: Auto-configures MockMvc.
- **Code Example**:
    ```java
    @SpringBootTest
    @AutoConfigureMockMvc
    public class MySpringBootTests {
        @Autowired
        private MockMvc mockMvc;

        @Test
        public void shouldReturnDefaultMessage() throws Exception {
            this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                    .andExpect(content().string(containsString("Hello, World")));
        }
    }
    ```

### `@AutoConfigureJsonTesters`
- **Summary**: Auto-configures JSON testers.
- **Code Example**:
    ```java
    @SpringBootTest
    @AutoConfigureJsonTesters
    public class MySpringBootTests {
        @Autowired
        private JacksonTester<MyEntity> json;

        @Test
        public void testSerialize() throws Exception {
            MyEntity entity = new MyEntity("John", "Doe");
            assertThat(this.json.write(entity)).isEqualToJson("expected.json");
        }
    }
    ```

### `@JdbcTest`
- **Summary**: Used for JDBC tests.
- **Code Example**:
    ```java
    @JdbcTest
    public class MyJdbcTests {
        @Autowired
        private JdbcTemplate jdbcTemplate;

        @Test
        public void testQuery() {
            List<User> users = jdbcTemplate.query("SELECT * FROM users", new UserRowMapper());
            assertThat(users).hasSize(3);
        }
    }
    ```

### `@JsonTest`
- **Summary**: Used to test JSON serialization and deserialization.
- **Code Example**:
    ```java
    @JsonTest
    public class MyJsonTests {
        @Autowired
        private JacksonTester<MyEntity> json;

        @Test
        public void testSerialize() throws Exception {
            MyEntity entity = new MyEntity("John", "Doe");
            assertThat(this.json.write(entity)).isEqualToJson("expected.json");
        }

        @Test
        public void testDeserialize() throws Exception {
            String content = "{\"firstName\":\"John\",\"lastName\":\"Doe\"}";
            assertThat(this.json.parse(content)).isEqualTo(new MyEntity("John", "Doe"));
        }
    }
    ```

### `@TransactionalTest`
- **Summary**: Used to indicate that a test should be run within a transaction.
- **Code Example**:
    ```java
    @SpringBootTest
    @Transactional
    public class MyTransactionalTests {
        @Autowired
        private UserRepository userRepository;

        @Test
        public void testSaveAndFlush() {
            User user = new User("John", "Doe");
            userRepository.saveAndFlush(user);
            assertThat(userRepository.findByName("John")).isNotNull();
        }
    }
    ```

## 3. Spring Boot Data Access Annotations

### `@Entity`
- **Summary**: Specifies that the class is an entity and is mapped to a database table.
- **Code Example**:
    ```java
    @Entity
    public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;

        // getters and setters
    }
    ```

### `@Id`
- **Summary**: Specifies the primary key of an entity.
- **Code Example**:
    ```java
    @Entity
    public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;

        // getters and setters
    }
    ```

### `@GeneratedValue`
- **Summary**: Provides the specification of generation strategies for the values of primary keys.
- **Code Example**:
    ```java
    @Entity
    public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;

        // getters and setters
    }
    ```

### `@Column`
- **Summary**: Used to specify the mapped column for a persistent property or field.
- **Code Example**:
    ```java
    @Entity
    public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "user_name")
        private String name;

        // getters and setters
    }
    ```

### `@Table`
- **Summary**: Specifies the primary table for the annotated entity.
- **Code Example**:
    ```java
    @Entity
    @Table(name = "users")
    public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;

        // getters and setters
    }
    ```

### `@OneToOne`
- **Summary**: Defines a single-valued association to another entity that has a one-to-one multiplicity.
- **Code Example**:
    ```java
    @Entity
    public class Employee {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @OneToOne
        private ParkingSpot parkingSpot;

        // getters and setters
    }
    ```

### `@OneToMany`
- **Summary**: Defines a many-valued association with one-to-many multiplicity.
- **Code Example**:
    ```java
    @Entity
    public class Department {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @OneToMany(mappedBy = "department")
        private List<Employee> employees;

        // getters and setters
    }
    ```

### `@ManyToOne`
- **Summary**: Defines a single-valued association to another entity class that has many-to-one multiplicity.
- **Code Example**:
    ```java
    @Entity
    public class Employee {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        private Department department;

        // getters and setters
    }
    ```

### `@ManyToMany`
- **Summary**: Defines a many-valued association with many-to-many multiplicity.
- **Code Example**:
    ```java
    @Entity
    public class Student {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToMany
        private List<Course> courses;

        // getters and setters
    }
    ```

### `@JoinColumn`
- **Summary**: Specifies a column for joining an entity association.
- **Code Example**:
    ```java
    @Entity
    public class Employee {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @OneToOne
        @JoinColumn(name = "parking_spot_id")
        private ParkingSpot parkingSpot;

        // getters and setters
    }
    ```

### `@JoinTable`
- **Summary**: Specifies the mapping of associations. 
- **Code Example**:
    ```java
    @Entity
    public class Student {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToMany
        @JoinTable(name = "student_course",
                joinColumns = @JoinColumn(name = "student_id"),
                inverseJoinColumns = @JoinColumn(name = "course_id"))
        private List<Course> courses;

        // getters and setters
    }
    ```

### `@Repository`
- **Summary**: Indicates that an annotated class is a repository, which is an abstraction of data access and storage.
- **Code Example**:
    ```java
    @Repository
    public interface UserRepository extends JpaRepository<User, Long> {
        User findByName(String name);
    }
    ```

## 4. Spring Web Annotations

### `@RestController`
- **Summary**: Combines `@Controller` and `@ResponseBody`.
- **Code Example**:
    ```java
    @RestController
    @RequestMapping("/api")
    public class MyRestController {
        @GetMapping("/hello")
        public String hello() {
            return "Hello World";
        }
    }
    ```

### `@Controller`
- **Summary**: Marks a class as a Spring MVC controller.
- **Code Example**:
    ```java
    @Controller
    public class MyController {
        @RequestMapping("/hello")
        @ResponseBody
        public String hello() {
            return "Hello World";
        }
    }
    ```

### `@RequestMapping`
- **Summary**: Maps HTTP requests to handler methods of MVC and REST controllers.
- **Code Example**:
    ```java
    @RestController
    @RequestMapping("/api")
    public class MyRestController {
        @RequestMapping("/hello")
        public String hello() {
            return "Hello World";
        }
    }
    ```

### `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping`, `@PatchMapping`
- **Summary**: Composed annotations that act as shortcuts for `@RequestMapping` for specific HTTP methods.
    - `@GetMapping`:
        ```java
        @RestController
        @RequestMapping("/api")
        public class MyRestController {
            @GetMapping("/hello")
            public String hello() {
                return "Hello World";
            }
        }
        ```
    - `@PostMapping`:
        ```java
        @RestController
        @RequestMapping("/api")
        public class MyRestController {
            @PostMapping("/hello")
            public String hello(@RequestBody String name) {
                return "Hello " + name;
            }
        }
        ```
    - `@PutMapping`:
        ```java
        @RestController
        @RequestMapping("/api")
        public class MyRestController {
            @PutMapping("/hello")
            public String hello(@RequestBody String name) {
                return "Hello " + name;
            }
        }
        ```
    - `@DeleteMapping`:
        ```java
        @RestController
        @RequestMapping("/api")
        public class MyRestController {
            @DeleteMapping("/hello")
            public String hello() {
                return "Goodbye World";
            }
        }
        ```
    - `@PatchMapping`:
        ```java
        @RestController
        @RequestMapping("/api")
        public class MyRestController {
            @PatchMapping("/hello")
            public String hello(@RequestBody String name) {
                return "Hello " + name;
            }
        }
        ```

### `@PathVariable`
- **Summary**: Used to extract values from the URI path.
- **Code Example**:
    ```java
    @RestController
    @RequestMapping("/api")
    public class MyRestController {
        @GetMapping("/hello/{name}")
        public String hello(@PathVariable String name) {
            return "Hello " + name;
        }
    }
    ```

### `@RequestParam`
- **Summary**: Used to extract query parameters.
- **Code Example**:
    ```java
    @RestController
    @RequestMapping("/api")
    public class MyRestController {
        @GetMapping("/hello")
        public String hello(@RequestParam String name) {
            return "Hello " + name;
        }
    }
    ```

### `@RequestBody`
- **Summary**: Used to bind the HTTP request body to a method parameter.
- **Code Example**:
    ```java
    @RestController
    @RequestMapping("/api")
    public class MyRestController {
        @PostMapping("/hello")
        public String hello(@RequestBody String name) {
            return "Hello " + name;
        }
    }
    ```

## 5. Spring Boot Security Annotations

### `@EnableWebSecurity`
- **Summary**: Enables Spring Security’s web security support.
- **Code Example**:
    ```java
    @Configuration
    @EnableWebSecurity
    public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                .authorizeRequests()
                .antMatchers("/public/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll()
                .and()
                .logout().permitAll();
        }
    }
    ```

### `@Secured`
- **Summary**: Specifies a list of security roles that are allowed to access methods.
- **Code Example**:
    ```java
    @Service
    public class MyService {
        @Secured("ROLE_USER")
        public void securedMethod() {
            // secure code
        }
    }
    ```

### `@PreAuthorize`
- **Summary**: Used to authorize method calls based on the evaluation of an expression.
- **Code Example**:
    ```java
    @Service
    public class MyService {
        @PreAuthorize("hasRole('ROLE_USER')")
        public void preAuthorizedMethod() {
            // secure code
        }
    }
    ```

### `@PostAuthorize`
- **Summary**: Used to authorize method calls after the execution based on the evaluation of an expression.
- **Code Example**:
    ```java
    @Service
    public class MyService {
        @PostAuthorize("returnObject.name == authentication.name")
        public User postAuthorizedMethod() {
            // secure code
            return new User();
        }
    }
    ```

### `@RolesAllowed`
- **Summary**: Specifies the roles allowed to invoke a method.
- **Code Example**:
    ```java
    @Service
    public class MyService {
        @RolesAllowed("ROLE_USER")
        public void rolesAllowedMethod() {
            // secure code
        }
    }
    ```

### `@EnableGlobalMethodSecurity`
- **Summary**: Enables global method security.
- **Code Example**:
    ```java
    @Configuration
    @EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
    public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {
    }
    ```

### `@WithMockUser`
- **Summary**: Used in tests to mock a user with specific roles.
- **Code Example**:
    ```java
    @SpringBootTest
    public class MySecurityTests {
        @Test
        @WithMockUser(roles = "USER")
        public void testMethodWithUserRole() {
            // test code
        }
    }
    ```

## 6. Custom Annotations

### Creating Custom Annotations
- **Summary**: You can create your own annotations in Spring Boot.
- **Code Example**:
    ```java
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    public @interface LogExecutionTime {
    }

    @Aspect
    @Component
    public class LogExecutionTimeAspect {
        @Around("@annotation(com.example.LogExecutionTime)")
        public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
            long start = System.currentTimeMillis();
            Object proceed = joinPoint.proceed();
            long executionTime = System.currentTimeMillis() - start;
            System.out.println(joinPoint.getSignature() + " executed in " + executionTime + "ms");
            return proceed;
        }
    }

    @RestController
    public class MyController {
        @LogExecutionTime
        @GetMapping("/hello")
        public String hello() {
            return "Hello World";
        }
    }
    ```

This comprehensive guide covers the most important annotations in Spring Boot and provides examples of how to use them effectively. The guide also includes a section on creating custom annotations to help you extend Spring Boot’s capabilities to fit your needs.




----
----
----
----
----


### 1. Explain the Concept of Auto-Configuration in Spring Boot 
Spring Boot's auto-configuration feature attempts to automatically configure your Spring application based on the jar dependencies you have added. For example, if you have `spring-boot-starter-web` in your classpath, Spring Boot will automatically configure web-related components such as a dispatcher servlet, a default error page, etc.  **How it works:**  
- Spring Boot uses a series of `@Configuration` classes (found under the `META-INF/spring.factories` file within Spring Boot jars).

- These configuration classes are conditionally applied based on the presence of certain classes or properties in the classpath.  
**Example:** 

```java
// Application class with main method
@SpringBootApplication
public class MySpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(MySpringBootApplication.class, args);
    }
}

// Application.properties
server.port=8081
```

### 2. Describe How to Create a RESTful Web Service Using Spring Boot 

Creating a RESTful web service involves defining controllers that handle HTTP requests and responses.  
**Steps:** 
1. Create a Spring Boot application.

2. Define a REST controller.

3. Implement CRUD operations.  
**Example:** 

```java
// Main Application
@SpringBootApplication
public class RestApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }
}

// Model
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String role;
    
    // getters and setters
}

// Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

// Controller
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return repository.save(employee);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
        Employee employee = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
        employee.setName(employeeDetails.getName());
        employee.setRole(employeeDetails.getRole());
        return repository.save(employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id) {
        Employee employee = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
        repository.delete(employee);
        return ResponseEntity.ok().build();
    }
}
```

### 3. How Do You Handle Exceptions in a Spring Boot Application? 

Spring Boot provides several ways to handle exceptions in a web application:
 
1. **Using @ExceptionHandler:**   
This method is used within controllers.

```java
@RestController
@RequestMapping("/example")
public class ExampleController {

    @GetMapping("/{id}")
    public String getExample(@PathVariable String id) {
        if (id.equals("error")) {
            throw new CustomException("Custom exception occurred");
        }
        return "Example: " + id;
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<String> handleCustomException(CustomException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}

public class CustomException extends RuntimeException {
    public CustomException(String message) {
        super(message);
    }
}
```
 
2. **Using @ControllerAdvice:**  
This method is used globally across controllers.

```java
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<String> handleCustomException(CustomException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
```

### 4. Explain How to Use Spring Boot Actuator. What Are Some of the Important Endpoints? 

Spring Boot Actuator provides production-ready features for Spring Boot applications. It includes several built-in endpoints that help you monitor and manage your application.  
**How to Use:**  
1. Add the dependency:


```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```
 
2. Enable Actuator endpoints in `application.properties`:

```properties
management.endpoints.web.exposure.include=*
```
**Important Endpoints:**  
- **/actuator/health:**  Shows application health information.
 
- **/actuator/info:**  Displays arbitrary application info.
 
- **/actuator/metrics:**  Shows various metrics of the application.
 
- **/actuator/env:**  Shows environment properties.
 
- **/actuator/loggers:**  Exposes loggers and their levels.

### 5. How Can You Secure a Spring Boot Application? Demonstrate the Use of Spring Security for Basic Authentication and Authorization. 

Spring Security provides comprehensive security services for Java applications. It is highly customizable and can handle a variety of authentication and authorization scenarios.
**Steps:**  
1. Add the Spring Security dependency:


```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```
 
2. Configure Security:


```java
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("user").password(passwordEncoder().encode("password")).roles("USER")
            .and()
            .withUser("admin").password(passwordEncoder().encode("admin")).roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/admin/**").hasRole("ADMIN")
            .antMatchers("/user/**").hasRole("USER")
            .and()
            .httpBasic();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
```
 
3. Secure endpoints:


```java
@RestController
@RequestMapping("/admin")
public class AdminController {
    @GetMapping
    public String admin() {
        return "Admin content";
    }
}

@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping
    public String user() {
        return "User content";
    }
}
```

### 6. How Do You Configure and Use Externalized Configuration Properties in a Spring Boot Application? 

Spring Boot allows you to externalize your configuration so you can work with the same application code in different environments.
**Steps:**  
1. Create an `application.properties` or `application.yml` file.

2. Define properties.
 
3. Bind properties to a POJO using `@ConfigurationProperties`.
**Example:** 

```properties
# application.properties
app.name=MyApp
app.description=This is my application
```


```java
// Configuration class
@Configuration
@ConfigurationProperties(prefix = "app")
public class AppConfig {
    private String name;
    private String description;

    // getters and setters
}

// Using the configuration
@RestController
public class AppController {

    @Autowired
    private AppConfig config;

    @GetMapping("/config")
    public String getConfig() {
        return config.getName() + ": " + config.getDescription();
    }
}
```

### 7. Describe How to Implement and Use Custom Configuration Properties in Spring Boot. 
You can create custom properties by binding them to a POJO using `@ConfigurationProperties`.**Example:** 

```properties
# application.properties
custom.property1=value1
custom.property2=value2
```


```java
// Configuration class
@Configuration
@ConfigurationProperties(prefix = "custom")
public class CustomProperties {
    private String property1;
    private String property2;

    // getters and setters
}

// Using the configuration
@RestController
public class CustomController {

    @Autowired
    private CustomProperties properties;

    @GetMapping("/custom")
    public String getCustomProperties() {
        return properties.getProperty1() + ", " + properties.getProperty2();
    }
}
```

### 8. How Do You Set Up and Use Multiple Profiles in a Spring Boot Application? 

Spring Boot allows you to define multiple profiles for different environments (e.g., dev, test, prod).
**Steps:**  
1. Create profile-specific property files like `application-dev.properties` and `application-prod.properties`.
 
2. Activate a profile by setting `spring.profiles.active` property.
**Example:** 

```properties
# application-dev.properties
app.name=MyApp-Dev
```


```properties
# application-prod.properties
app.name=MyApp-Prod
```


```java
// Controller using the configuration
@RestController
public class ProfileController {

    @Value("${app.name}")
    private String appName;

    @GetMapping("/profile")
    public String getProfile() {
        return "Current profile: " + appName;
    }
}
```
Activate the desired profile in `application.properties`:

```properties
spring.profiles.active=dev
```

### 9. Explain How to Configure and Use Spring Data JPA with a Spring Boot Application. 

Spring Data JPA simplifies the implementation of JPA-based repositories.
**Steps:**  
1. Add dependencies:


```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>
</dependency>
```
 
2. Configure database connection in `application.properties`:

```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
```
 
3. Define an entity and a repository:


```java
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;

    // getters and setters
}

public interface ProductRepository extends JpaRepository<Product, Long> {
}
```
 
4. Use the repository in a service or controller:


```java
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @GetMapping
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return repository.save(product);
    }
}
```

### 10. How Do You Write Unit Tests for a Spring Boot Application? Provide an Example of Testing a Service Layer. 

Unit testing in Spring Boot can be done using JUnit and Mockito.
**Example:**  
1. Add dependencies:


```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
</dependency>
```
 
2. Write a service and its test:


```java
// Service class
@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product getProductById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }
}

// Test class
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService service;

    @MockBean
    private ProductRepository repository;

    @Test
    public void whenValidId_thenProductShouldBeFound() {
        Product product = new Product();
        product.setId(1L);
        product.setName("Product1");

        Mockito.when(repository.findById(1L)).thenReturn(Optional.of(product));

        Product found = service.getProductById(1L);

        assertEquals(found.getName(), "Product1");
    }
}
```

### 11. Demonstrate How to Consume a RESTful Web Service in a Spring Boot Application Using RestTemplate or WebClient. 
**Using RestTemplate:** 

```java
// Configuration class
@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

// Service to consume REST API
@Service
public class ApiService {

    @Autowired
    private RestTemplate restTemplate;

    public String getApiResponse() {
        String url = "https://api.example.com/data";
        return restTemplate.getForObject(url, String.class);
    }
}
```
**Using WebClient:** 

```java
// Configuration class
@Configuration
public class WebClientConfig {

    @Bean
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }
}

// Service to consume REST API
@Service
public class ApiService {

    @Autowired
    private WebClient.Builder webClientBuilder;

    public Mono<String> getApiResponse() {
        String url = "https://api.example.com/data";
        return webClientBuilder.build()
                               .get()
                               .uri(url)
                               .retrieve()
                               .bodyToMono(String.class);
    }
}
```

### 12. Explain How to Implement Asynchronous Processing in a Spring Boot Application. Provide an Example Using @Async. 
**Steps:** 
1. Enable async support.
 
2. Annotate methods with `@Async`.
**Example:** 

```java
// Configuration class
@Configuration
@EnableAsync
public class AsyncConfig {
}

// Service class
@Service
public class AsyncService {

    @Async
    public CompletableFuture<String> asyncMethod() {
        try {
            Thread.sleep(1000); // Simulate a long-running task
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture("Async result");
    }
}

// Controller
@RestController
@RequestMapping("/async")
public class AsyncController {

    @Autowired
    private AsyncService service;

    @GetMapping
    public CompletableFuture<String> getAsync() {
        return service.asyncMethod();
    }
}
```

### 13. What Are the Differences Between Lazy and Eager Loading in Hibernate? 
**Lazy Loading:** 
- Loads related entities on demand.

- Pros: Improves performance by loading data only when needed.
 
- Cons: Can lead to `LazyInitializationException` if the session is closed.
**Eager Loading:** 
- Loads related entities immediately.
 
- Pros: Avoids `LazyInitializationException`.

- Cons: Can impact performance due to unnecessary data loading.
**Example:** 

```java
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Category> categories;
}
```

### 14. How to Connect a Spring Boot Application to a Database Using JDBC. 
**Steps:**  
1. Add dependencies:


```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jdbc</artifactId>
</dependency>
<dependency>
    <groupId>com.mysql.cj</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <scope>runtime</scope>
</dependency>
```
 
2. Configure database connection in `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/mydb
spring.datasource.username=root
spring.datasource.password=secret
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```
 
3. Use `JdbcTemplate`:

```java
@RestController
@RequestMapping("/jdbc")
public class JdbcController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping
    public List<Map<String, Object>> getAll() {
        return jdbcTemplate.queryForList("SELECT * FROM users");
    }
}
```

### 15. Differences Between JPA and Hibernate 
 
- **JPA (Java Persistence API):** 
  - A specification for accessing, persisting, and managing data between Java objects and relational databases.

  - Defines a set of interfaces that can be implemented by various ORM tools.
 
- **Hibernate:** 
  - A popular ORM framework that implements the JPA specification.

  - Provides additional features beyond the JPA specification (e.g., caching, custom data types).

### 16. How to Create a Custom Endpoint in Spring Boot Actuator. 
**Steps:**  
1. Create an `Endpoint` implementation.

2. Register the endpoint.
**Example:** 

```java
// Custom Endpoint class
@Component
@Endpoint(id = "custom")
public class CustomEndpoint {

    @ReadOperation
    public String customEndpoint() {
        return "Custom endpoint response";
    }
}

// Enable actuator endpoints in application.properties
management.endpoints.web.exposure.include=custom
```

### 17. Differences Between @SpringBootApplication and @EnableAutoConfiguration Annotation 
 
- **@SpringBootApplication:**  
  - A convenience annotation that combines `@EnableAutoConfiguration`, `@ComponentScan`, and `@Configuration`.

  - Typically used to mark the main class of a Spring Boot application.
 
- **@EnableAutoConfiguration:** 
  - Enables Spring Boot’s auto-configuration mechanism.
 
  - Can be used on its own or as part of `@SpringBootApplication`.
**Example:** 

```java
// Using @SpringBootApplication
@SpringBootApplication
public class MySpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(MySpringBootApplication.class, args);
    }
}

// Using @EnableAutoConfiguration
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.example")
public class MySpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(MySpringBootApplication.class, args);
    }
}
```

These detailed explanations and examples should help you understand and implement various Spring Boot features effectively.
