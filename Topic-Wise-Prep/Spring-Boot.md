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
