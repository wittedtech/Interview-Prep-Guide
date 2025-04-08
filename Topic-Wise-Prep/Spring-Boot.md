# SpringBoot

## Must Know Annotations:

1. `@SpringBootApplication`
2. `@RestController`
3. `@RequestMapping`
4. `@GetMapping, @PostMapping, @PutMapping, @DeleteMapping, @PatchMapping`
5. `@Autowired`
6. `@Component, @Service, @Repository, @Controller`
7. `@Configuration`
8. `@Bean`
9. `@Entity`
10. `@Table, @Id, @GeneratedValue`
11. `@EnableAUtoConfiguration`
12. `@ComponentScan`
13. `@Value`
14. `@Profile`
15. `@PathVariable`
16. `@RequestParam`
17. `@RequestBody`
18. `@ResponseBody`
19. `@ExceptionHandler`

---

## All Other Annotations:

### 🔹 **Spring Core & Context**

1.  `@Lazy`
2.  `@Primary`
3.  `@Qualifier`
4.  `@Scope`
5.  `@DependsOn`
6.  `@Import`
7.  `@ImportResource`
8.  `@PropertySource`
9.  `@PropertySources`
10. `@ConfigurationProperties`

11. `@EnableConfigurationProperties`

---

### 🔹 **Spring Boot**

12. `@SpringBootTest`

13. `@TestConfiguration`

14. `@MockBean`

15. `@SpyBean`

16. `@DataJpaTest`

17. `@WebMvcTest`

18. `@RestClientTest`

19. `@JsonTest`

20. `@AutoConfigureMockMvc`

21. `@AutoConfigureTestDatabase`

22. `@EnableAutoConfiguration` _(already in Must Know Annotations list)_

23. `@SpringBootConfiguration`

24. `@BootstrapWith`

---

### 🔹 **Spring Web / MVC**

25. `@CrossOrigin`

26. `@RequestHeader`

27. `@CookieValue`

28. `@MatrixVariable`

29. `@SessionAttributes`

30. `@ModelAttribute`

31. `@InitBinder`

32. `@ResponseStatus`

33. `@ExceptionHandler` _(already in Must Know Annotations list)_

34. `@ControllerAdvice`

35. `@RestControllerAdvice`

---

### 🔹 **Validation / Binding**

36. `@Valid`

37. `@Validated`

> (JSR 380 / Bean Validation)

38. `@NotNull`

39. `@NotBlank`

40. `@NotEmpty`

41. `@Min`

42. `@Max`

43. `@Size`

44. `@Pattern`

45. `@Email`

46. `@Positive`

47. `@Negative`

48. `@AssertTrue`

49. `@AssertFalse`

50. `@Past`

51. `@Future`

52. `@Digits`

53. `@DecimalMin`

54. `@DecimalMax`

---

### 🔹 **JPA / Hibernate**

55. `@Column`

56. `@JoinColumn`

57. `@JoinTable`

58. `@OneToOne`

59. `@OneToMany`

60. `@ManyToOne`

61. `@ManyToMany`

62. `@OrderBy`

63. `@OrderColumn`

64. `@MapKey`

65. `@Embedded`

66. `@Embeddable`

67. `@MappedSuperclass`

68. `@Inheritance`

69. `@DiscriminatorColumn`

70. `@DiscriminatorValue`

71. `@Access`

72. `@Transient`

73. `@Version`

74. `@NamedQuery`

75. `@NamedEntityGraph`

76. `@SqlResultSetMapping`

77. `@Converter`

---

### 🔹 **Transactional / AOP**

78. `@Transactional`

79. `@EnableTransactionManagement`

80. `@Aspect`

81. `@Before`

82. `@After`

83. `@Around`

84. `@AfterReturning`

85. `@AfterThrowing`

86. `@Pointcut`

---

### 🔹 **Spring Scheduling / Async**

87. `@EnableScheduling`

88. `@Scheduled`

89. `@EnableAsync`

90. `@Async`

---

### 🔹 **Spring Security**

91. `@EnableWebSecurity`

92. `@EnableGlobalMethodSecurity`

93. `@PreAuthorize`

94. `@PostAuthorize`

95. `@PreFilter`

96. `@PostFilter`

97. `@Secured`

98. `@RolesAllowed`

99. `@AuthenticationPrincipal`

---

### 🔹 **Spring Caching**

100.  `@EnableCaching`

101.  `@Cacheable`

102.  `@CachePut`

103.  `@CacheEvict`

---

### 🔹 **Miscellaneous / Testing / Utility**

104.  `@Profile` _(already in Must Know Annotations list)_

105.  `@Conditional`

106.  `@ConditionalOnProperty`

107.  `@ConditionalOnClass`

108.  `@ConditionalOnMissingBean`

109.  `@ConditionalOnBean`

110.  `@ConditionalOnExpression`

111.  `@EnableAspectJAutoProxy`

112.  `@DirtiesContext`

113.  `@TestPropertySource`

114.  `@Sql`

115.  `@SqlGroup`

116.  `@Rollback`

---

---

---

---

---

## Comprehensive Guide to Important Spring Boot Annotations

### 1. Core Spring Annotations

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

### 2. Spring Boot Testing Annotations

#### `@SpringBootTest`

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

#### `@MockBean`

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

#### `@SpyBean`

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

#### `@WebMvcTest`

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

#### `@DataJpaTest`

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

#### `@RestClientTest`

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

#### `@AutoConfigureMockMvc`

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

#### `@AutoConfigureJsonTesters`

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

#### `@JdbcTest`

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

#### `@JsonTest`

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

#### `@TransactionalTest`

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

### 3. Spring Boot Data Access Annotations

#### `@Entity`

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

#### `@Id`

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

#### `@GeneratedValue`

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

#### `@Column`

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

#### `@Table`

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

#### `@OneToOne`

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

#### `@OneToMany`

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

#### `@ManyToOne`

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

#### `@ManyToMany`

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

#### `@JoinColumn`

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

#### `@JoinTable`

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

#### `@Repository`

- **Summary**: Indicates that an annotated class is a repository, which is an abstraction of data access and storage.
- **Code Example**:
  ```java
  @Repository
  public interface UserRepository extends JpaRepository<User, Long> {
      User findByName(String name);
  }
  ```

### 4. Spring Web Annotations

#### `@RestController`

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

#### `@Controller`

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

#### `@RequestMapping`

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

#### `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping`, `@PatchMapping`

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

#### `@PathVariable`

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

#### `@RequestParam`

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

#### `@RequestBody`

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

### 5. Spring Boot Security Annotations

#### `@EnableWebSecurity`

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

#### `@Secured`

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

#### `@PreAuthorize`

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

#### `@PostAuthorize`

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

#### `@RolesAllowed`

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

#### `@EnableGlobalMethodSecurity`

- **Summary**: Enables global method security.
- **Code Example**:
  ```java
  @Configuration
  @EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
  public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {
  }
  ```

#### `@WithMockUser`

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

### 6. Custom Annotations

#### Creating Custom Annotations

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

---

---

## All Other Annotations To Keep In Mind

### 🔹 **Spring Core & Context Annotations**

#### 1\. `@Lazy`

✅ **Purpose**:  
Delays the initialization of a Spring bean until it's requested.

⚙️ **Parameters**:

- `value` (default: `true`) – Indicates whether to lazily initialize the bean.

📌 **Use Case**:

- When a bean is resource-heavy and not always needed.
- Useful to break circular dependencies in some cases.

```java
@Component
@Lazy
public class HeavyService { ... }
```

```java
@Bean
@Lazy(false)
public MyService myService() { ... } // eager init despite default lazy config
```

#### 2\. `@Primary`

✅ **Purpose**:  
Marks a bean as the **default** when multiple beans of the same type exist.

⚙️ **Parameters**:

- None

📌 **Use Case**:

- When multiple `@Bean` definitions match a type and one needs to be preferred.

```java
@Bean
@Primary
public DataSource mainDataSource() { ... }

@Bean
public DataSource backupDataSource() { ... }
```

#### 3\. `@Qualifier`

✅ **Purpose**:  
Specifies **which bean** to inject when multiple candidates exist.

⚙️ **Parameters**:

- `value`: Name of the bean to inject

📌 **Use Case**:

- Used alongside `@Autowired` to resolve ambiguity.

```java
@Bean("mysqlDataSource")
public DataSource mysqlDs() { ... }

@Bean("postgresDataSource")
public DataSource pgDs() { ... }

@Autowired
@Qualifier("mysqlDataSource")
private DataSource dataSource;
```

#### 4\. `@Scope`

✅ **Purpose**:  
Defines the **scope** of a Spring bean.

⚙️ **Parameters**:

- `value`: Scope type (`singleton`, `prototype`, `request`, `session`, `application`, `websocket`)

📌 **Use Case**:

- Customizing lifecycle of beans.

```java
@Component
@Scope("prototype")
public class TempProcessor { ... }
```

#### 5\. `@DependsOn`

✅ **Purpose**:  
Specifies bean **dependencies** to ensure correct initialization order.

⚙️ **Parameters**:

- `value`: One or more bean names this bean depends on

📌 **Use Case**:

- When Bean A must be initialized after Bean B

```java
@Bean
@DependsOn("cacheManager")
public DataService dataService() { ... }
```

#### 6\. `@Import`

✅ **Purpose**:  
Imports additional `@Configuration` classes into the current context.

⚙️ **Parameters**:

- `value`: One or more configuration classes

📌 **Use Case**:

- Modularizing configurations across classes

```java
@Import({SecurityConfig.class, DataConfig.class})
@Configuration
public class AppConfig { }
```

#### 7\. `@ImportResource`

✅ **Purpose**:  
Loads **XML-based configurations** into a Java-based config class.

⚙️ **Parameters**:

- `locations`: Path(s) to XML config files

📌 **Use Case**:

- When integrating legacy Spring XML configs with modern Java config

```java
@ImportResource("classpath:legacy-beans.xml")
@Configuration
public class LegacySupportConfig { }
```

#### 8\. `@PropertySource`

✅ **Purpose**:  
Loads property files into Spring’s Environment.

⚙️ **Parameters**:

- `value`: Path to `.properties` file
- `encoding` (optional): File encoding
- `ignoreResourceNotFound` (default: `false`)

📌 **Use Case**:

- Externalizing configs to `.properties` files

```java
@PropertySource("classpath:app.properties")
@Configuration
public class PropertyConfig { }
```

#### 9\. `@PropertySources`

✅ **Purpose**:  
Allows specifying **multiple `@PropertySource`** annotations.

⚙️ **Parameters**:

- `value`: Array of `@PropertySource`

📌 **Use Case**:

- When you want to load multiple property files

```java
@PropertySources({
    @PropertySource("classpath:db.properties"),
    @PropertySource("classpath:app.properties")
})
@Configuration
public class AppConfig { }
```

#### 10\. `@ConfigurationProperties`

✅ **Purpose**:  
Binds properties from `.properties` or `.yml` to a Java POJO.

⚙️ **Parameters**:

- `prefix`: Prefix for property keys
- `ignoreUnknownFields` (default: `true`)
- `ignoreInvalidFields` (default: `false`)

📌 **Use Case**:

- Mapping structured properties into classes (strongly typed configuration)

```java
@ConfigurationProperties(prefix = "app.datasource")
public class DataSourceProps {
    private String url;
    private String username;
    private String password;
    // getters/setters
}
```

#### 11\. `@EnableConfigurationProperties`

✅ **Purpose**:  
Enables support for `@ConfigurationProperties` classes.

⚙️ **Parameters**:

- `value`: One or more `@ConfigurationProperties`\-annotated classes

📌 **Use Case**:

- Required when using `@ConfigurationProperties` without `@SpringBootApplication` or when manually registering beans.

```java
@EnableConfigurationProperties(DataSourceProps.class)
@Configuration
public class Config { }
```

---

### 🔹 **Spring Boot Annotations**

#### 12\. `@SpringBootTest`

✅ **Purpose**:  
Bootstraps the **entire Spring context** for integration testing.

⚙️ **Parameters**:

- `classes`: Custom config class to load
- `webEnvironment`: `MOCK`, `RANDOM_PORT`, `DEFINED_PORT`, `NONE`
- `properties`: Inline test properties

📌 **Use Case**:

- Full-stack tests with actual Spring Boot app context.

```java
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ApplicationTests { ... }
```

---

#### 13\. `@TestConfiguration`

✅ **Purpose**:  
Defines **test-specific configuration beans**, similar to `@Configuration`.

⚙️ **Parameters**:

- None

📌 **Use Case**:

- Use custom beans or override existing ones only during tests.

```java
@TestConfiguration
public class TestBeanConfig {
    @Bean
    public SomeService testService() { ... }
}
```

---

#### 14\. `@MockBean`

✅ **Purpose**:  
Adds a **Mockito mock** to the Spring context, replacing an existing bean.

⚙️ **Parameters**:

- `name`, `value`, `classes`, etc. – target bean info

📌 **Use Case**:

- Isolate a unit test by mocking dependencies in Spring-managed tests.

```java
@MockBean
private UserService userService;
```

---

#### 15\. `@SpyBean`

✅ **Purpose**:  
Adds a **spy** (partial mock) of a Spring bean using Mockito.

⚙️ **Parameters**:

- `classes`, `name`, `value`

📌 **Use Case**:

- Verify interaction with real bean methods while retaining real behavior.

```java
@SpyBean
private EmailService emailService;
```

---

#### 16\. `@DataJpaTest`

✅ **Purpose**:  
Configures Spring Data JPA test slice with **H2/in-memory DB**, scanning only repositories.

⚙️ **Parameters**:

- `showSql`, `properties`, `transactional`, `includeFilters`, etc.

📌 **Use Case**:

- Fast unit testing of JPA repositories.

```java
@DataJpaTest
class UserRepositoryTests { ... }
```

---

#### 17\. `@WebMvcTest`

✅ **Purpose**:  
Loads only Spring MVC components: **controllers**, **filters**, **advice**, etc.

⚙️ **Parameters**:

- `controllers`: Specific controller class(es) to test
- `excludeAutoConfiguration`, `excludeFilters`, etc.

📌 **Use Case**:

- Focused unit test for MVC controllers without loading full context.

```java
@WebMvcTest(UserController.class)
class UserControllerTest { ... }
```

---

#### 18\. `@RestClientTest`

✅ **Purpose**:  
Auto-configures components for testing **REST clients** like `RestTemplate`, `WebClient`.

⚙️ **Parameters**:

- `components`, `properties`, etc.

📌 **Use Case**:

- Testing REST clients without full app context.

```java
@RestClientTest(MyRestClient.class)
class RestClientTest { ... }
```

---

#### 19\. `@JsonTest`

✅ **Purpose**:  
Configures JSON-specific components like **`Jackson`, `Gson`, `Jsonb`** for serialization testing.

⚙️ **Parameters**:

- None commonly used

📌 **Use Case**:

- Unit test object JSON (de)serialization.

```java
@JsonTest
class JsonSerializationTest {
    @Autowired
    private JacksonTester<MyModel> jsonTester;
}
```

---

#### 20\. `@AutoConfigureMockMvc`

✅ **Purpose**:  
Adds **`MockMvc` support** to tests without starting an actual web server.

⚙️ **Parameters**:

- `addFilters`, `printOnlyOnFailure`, etc.

📌 **Use Case**:

- Used with `@SpringBootTest` to test controllers using `MockMvc`.

```java
@SpringBootTest
@AutoConfigureMockMvc
class MockMvcTest {
    @Autowired
    private MockMvc mockMvc;
}
```

---

#### 21\. `@AutoConfigureTestDatabase`

✅ **Purpose**:  
Overrides your **configured DataSource** with an **embedded test database** (like H2).

⚙️ **Parameters**:

- `replace`: `ANY`, `NONE`, `AUTO_CONFIGURED`
- `connection`: Embedded database connection config

📌 **Use Case**:

- JPA tests that should not affect production DBs.

```java
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.ANY)
class UserRepositoryTest { ... }
```

---

#### 22\. `@EnableAutoConfiguration` ✅ _(already known)_

✅ **Purpose**:  
Enables Spring Boot’s **auto-configuration** feature.

---

#### 23\. `@SpringBootConfiguration`

✅ **Purpose**:  
Designates the main **configuration class** for Spring Boot app. It’s a meta-annotation of `@Configuration`.

⚙️ **Parameters**:

- None

📌 **Use Case**:

- Automatically added to the class with `@SpringBootApplication`, rarely used directly.

```java
@SpringBootConfiguration
public class AppConfig { ... }
```

---

#### 24\. `@BootstrapWith`

✅ **Purpose**:  
Specifies the **test context bootstrapper** class to initialize the Spring TestContext framework.

⚙️ **Parameters**:

- `value`: Class implementing `TestContextBootstrapper`

📌 **Use Case**:

- Advanced use: Custom test context loading or setup.

```java
@BootstrapWith(MyCustomTestBootstrapper.class)
public class CustomTestContext { ... }
```

---

### 🔹 **Spring Web / MVC Annotations**

---

#### 25\. `@CrossOrigin`

✅ **Purpose**:  
Enables **Cross-Origin Resource Sharing (CORS)** for a controller or method.

⚙️ **Parameters**:

- `origins` – Allowed origins (`*`, or list of domains)
- `methods`, `allowedHeaders`, `exposedHeaders`, `maxAge`, `allowCredentials`

📌 **Use Case**:

- Allow frontend (e.g., React) from another domain to call Spring APIs.

```java
@CrossOrigin(origins = "http://localhost:3000")
@GetMapping("/users")
public List<User> getUsers() { ... }
```

---

#### 26\. `@RequestHeader`

✅ **Purpose**:  
Injects an HTTP request header into a controller method parameter.

⚙️ **Parameters**:

- `name`, `required` (default `true`), `defaultValue`

📌 **Use Case**:

- Extract custom headers like auth tokens or client info.

```java
@GetMapping("/info")
public String getHeader(@RequestHeader("User-Agent") String userAgent) { ... }
```

---

#### 27\. `@CookieValue`

✅ **Purpose**:  
Binds the value of an HTTP cookie to a method parameter.

⚙️ **Parameters**:

- `name`, `required`, `defaultValue`

📌 **Use Case**:

- Read session or user tracking cookies.

```java
@GetMapping("/profile")
public String getProfile(@CookieValue(name = "userId") String userId) { ... }
```

---

#### 28\. `@MatrixVariable`

✅ **Purpose**:  
Binds **matrix variables** from the URL (semi-colon-based parameters).

⚙️ **Parameters**:

- `name`, `pathVar`, `required`, `defaultValue`

📌 **Use Case**:

- Handle RESTful URLs like: `/cars;color=red;year=2012`

```java
@GetMapping("/cars/{path}")
public String getCar(@MatrixVariable(name = "color") String color) { ... }
```

> 🔍 _Matrix variables must be enabled via `UrlPathHelper.setRemoveSemicolonContent(false)`_

---

#### 29\. `@SessionAttributes`

✅ **Purpose**:  
Stores **model attributes in the HTTP session** across multiple requests.

⚙️ **Parameters**:

- `value` – attribute names to store in session
- `types` – attribute types

📌 **Use Case**:

- Maintain form data or wizard-like flows over multiple pages.

```java
@Controller
@SessionAttributes("userForm")
public class FormController {
    ...
}
```

---

#### 30\. `@ModelAttribute`

✅ **Purpose**:

1.  Binds a model object from request data to a method parameter.
2.  Adds data to model (when used at method level).

⚙️ **Parameters**:

- `name`, `binding`

📌 **Use Case**:

- Prefill form fields or populate model before rendering views.

```java
@PostMapping("/save")
public String save(@ModelAttribute User user) { ... }

@ModelAttribute("roles")
public List<String> populateRoles() { return List.of("Admin", "User"); }
```

---

#### 31\. `@InitBinder`

✅ **Purpose**:  
Customizes **data binding** and **validation** for web request parameters.

⚙️ **Parameters**:

- `value`: Names of attributes it applies to

📌 **Use Case**:

- Register custom property editors or formatters.

```java
@InitBinder
public void initBinder(WebDataBinder binder) {
    binder.registerCustomEditor(LocalDate.class, new CustomDateEditor(...));
}
```

---

#### 32\. `@ResponseStatus`

✅ **Purpose**:  
Sets a specific **HTTP status** for a method or exception class.

⚙️ **Parameters**:

- `value` (or `code`): HTTP status
- `reason`: Optional message (used in older versions)

📌 **Use Case**:

- Return a custom status without using `ResponseEntity`.

```java
@ResponseStatus(HttpStatus.CREATED)
@PostMapping("/create")
public void createUser(@RequestBody User user) { ... }
```

Or with custom exception:

```java
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException { }
```

---

#### 33\. `@ExceptionHandler` ✅ _(Already Covered)_

---

#### 34\. `@ControllerAdvice`

✅ **Purpose**:  
Defines a global exception handler or model binder across all controllers.

⚙️ **Parameters**:

- `basePackages`, `assignableTypes`, `annotations`

📌 **Use Case**:

- Centralized error handling or shared model/data population.

```java
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleNotFound(...) { ... }
}
```

---

#### 35\. `@RestControllerAdvice`

✅ **Purpose**:  
Combination of `@ControllerAdvice + @ResponseBody`.  
Applies to **REST APIs**.

⚙️ **Parameters**: Same as `@ControllerAdvice`

📌 **Use Case**:

- Return JSON error responses for REST APIs.

```java
@RestControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(BadRequestException.class)
    public ErrorResponse handleBadRequest(...) { ... }
}
```

---

### 🔹 **Validation / Binding Annotations**

#### 36\. `@Valid`

✅ **Purpose**:  
Triggers validation on **nested objects**, **method parameters**, or **controller request bodies**.

📌 **Use Case**:

- Used in controllers or service methods to validate DTOs or beans.

```java
@PostMapping("/register")
public ResponseEntity<?> register(@RequestBody @Valid UserDTO user) { ... }
```

---

#### 37\. `@Validated`

✅ **Purpose**:  
Same as `@Valid`, but also supports **validation groups** and works at **class level** (e.g., `@Service`, `@Controller`).

📌 **Use Case**:

- Group-based validations, class-level method validations.

```java
@Validated
@Service
public class MyService {
    public void process(@Validated(MyGroup.class) UserDTO user) { ... }
}
```

---

#### 38\. `@NotNull`

✅ **Purpose**:  
Field **must not be null**, but **can be empty** (for strings/collections).

📌 **Use Case**:

- Required fields.

```java
@NotNull
private String username;
```

---

#### 39\. `@NotBlank`

✅ **Purpose**:  
Field must be **non-null & contain at least one non-whitespace character**.

📌 **Use Case**:

- Useful for text inputs (e.g., name, password).

```java
@NotBlank
private String password;
```

---

#### 40\. `@NotEmpty`

✅ **Purpose**:  
Field must be **non-null and not empty** (`""` for strings, `[]` for collections).

📌 **Use Case**:

- Check non-empty inputs.

```java
@NotEmpty
private List<String> roles;
```

---

#### 41\. `@Min(value)`

✅ **Purpose**:  
Checks number is **greater than or equal to** the given `value`.

📌 **Use Case**:

- Validate age, quantity, IDs, etc.

```java
@Min(18)
private int age;
```

---

#### 42\. `@Max(value)`

✅ **Purpose**:  
Checks number is **less than or equal to** the given `value`.

📌 **Use Case**:

- Max limit validations (e.g., max quantity, year, etc.)

```java
@Max(2025)
private int year;
```

---

#### 43\. `@Size(min, max)`

✅ **Purpose**:  
Validates size/length of a **String, Collection, Array, or Map**.

📌 **Use Case**:

- Password length, collection size checks.

```java
@Size(min = 8, max = 20)
private String password;
```

---

#### 44\. `@Pattern(regexp)`

✅ **Purpose**:  
Field must match the given **regex pattern**.

📌 **Use Case**:

- Phone number, username, custom format validations.

```java
@Pattern(regexp = "^[a-zA-Z0-9_]+$")
private String username;
```

---

#### 45\. `@Email`

✅ **Purpose**:  
Checks that the value is a **valid email format**.

📌 **Use Case**:

- User input forms.

```java
@Email
private String email;
```

---

#### 46\. `@Positive`

✅ **Purpose**:  
Field must be a **positive number** (`> 0`).

```java
@Positive
private int quantity;
```

---

#### 47\. `@Negative`

✅ **Purpose**:  
Field must be a **negative number** (`< 0`).

```java
@Negative
private int balance;
```

---

#### 48\. `@AssertTrue`

✅ **Purpose**:  
Field must be `true`.

📌 **Use Case**:

- Terms and conditions, consent checkbox.

```java
@AssertTrue
private boolean agreedToTerms;
```

---

#### 49\. `@AssertFalse`

✅ **Purpose**:  
Field must be `false`.

```java
@AssertFalse
private boolean banned;
```

---

#### 50\. `@Past`

✅ **Purpose**:  
Date must be in the **past**.

📌 **Use Case**:

- Date of birth, history logs.

```java
@Past
private LocalDate dob;
```

---

#### 51\. `@Future`

✅ **Purpose**:  
Date must be in the **future**.

📌 **Use Case**:

- Event scheduling.

```java
@Future
private LocalDate eventDate;
```

---

#### 52\. `@Digits(integer, fraction)`

✅ **Purpose**:  
Ensures the number has a specific number of **integer and decimal digits**.

📌 **Use Case**:

- Decimal validation like prices, currency.

```java
@Digits(integer = 6, fraction = 2)
private BigDecimal price;
```

---

#### 53\. `@DecimalMin(value)`

✅ **Purpose**:  
Field must be **≥ value** (inclusive by default).

⚙️ Parameters: `value`, `inclusive = true|false`

```java
@DecimalMin(value = "0.1", inclusive = true)
private BigDecimal rating;
```

---

#### 54\. `@DecimalMax(value)`

✅ **Purpose**:  
Field must be **≤ value** (inclusive by default).

```java
@DecimalMax(value = "100.0", inclusive = true)
private BigDecimal score;
```

---

### 🔹 **JPA / Hibernate**

---

#### **55\. `@Column`**

- **Purpose**: Customizes the mapping between the entity attribute and the database column.
- **Parameters**:

  - `name`: Name of the DB column.
  - `nullable`: If `false`, column is `NOT NULL`.
  - `unique`: If `true`, column must be unique.
  - `length`: For `VARCHAR` length.
  - `columnDefinition`: Custom SQL definition.

- **Use Case**: When you need fine control over how a field maps to a column.
- **Example**:

  ```java
  @Column(name = "email", nullable = false, unique = true, length = 150)
  private String email;
  ```

---

#### **56\. `@JoinColumn`**

- **Purpose**: Specifies the foreign key column for associations like `@ManyToOne`, `@OneToOne`.
- **Parameters**:

  - `name`: Name of the FK column.
  - `referencedColumnName`: Column in the target entity (default is `id`).
  - `nullable`, `unique`, etc.

- **Use Case**: Customizing join column name or reference.
- **Example**:

  ```java
  @ManyToOne
  @JoinColumn(name = "department_id", referencedColumnName = "id")
  private Department department;
  ```

---

#### **57\. `@JoinTable`**

- **Purpose**: Defines a join table for many-to-many or bidirectional one-to-many mappings.
- **Parameters**:

  - `name`: Join table name.
  - `joinColumns`: Join column(s) in the owning entity.
  - `inverseJoinColumns`: Join column(s) in the inverse side.

- **Use Case**: Many-to-many or bidirectional mapping customization.
- **Example**:

  ```java
  @ManyToMany
  @JoinTable(
    name = "student_course",
    joinColumns = @JoinColumn(name = "student_id"),
    inverseJoinColumns = @JoinColumn(name = "course_id")
  )
  private Set<Course> courses;
  ```

---

#### **58\. `@OneToOne`**

- **Purpose**: Maps a one-to-one relationship.
- **Parameters**:

  - `mappedBy`, `cascade`, `fetch`, `optional`

- **Use Case**: When each entity has exactly one related entity.
- **Example**:

  ```java
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "profile_id")
  private UserProfile profile;
  ```

---

#### **59\. `@OneToMany`**

- **Purpose**: Maps a one-to-many relationship (parent-child).
- **Parameters**:

  - `mappedBy`, `cascade`, `fetch`

- **Use Case**: Parent with multiple children.
- **Example**:

  ```java
  @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
  private List<Employee> employees;
  ```

---

#### **60\. `@ManyToOne`**

- **Purpose**: Defines many-to-one relationship.
- **Use Case**: Many entities refer to one.
- **Example**:

  ```java
  @ManyToOne
  private Department department;
  ```

---

#### **61\. `@ManyToMany`**

- **Purpose**: Defines a many-to-many relationship.
- **Use Case**: Students ↔ Courses.
- **Example**:

  ```java
  @ManyToMany
  private Set<Course> courses;
  ```

---

#### **62\. `@OrderBy`**

- **Purpose**: Orders a collection using JPQL syntax.
- **Use Case**: Automatically order child entities.
- **Example**:

  ```java
  @OneToMany(mappedBy = "user")
  @OrderBy("createdAt DESC")
  private List<Post> posts;
  ```

---

#### **63\. `@OrderColumn`**

- **Purpose**: Maintains the order of elements in a list using a DB column.
- **Parameters**: `name` - column to store order.
- **Use Case**: When preserving list order matters.
- **Example**:

  ```java
  @OneToMany
  @OrderColumn(name = "order_index")
  private List<Task> tasks;
  ```

---

#### **64\. `@MapKey`**

- **Purpose**: Allows use of a Map as a collection and specifies the key.
- **Use Case**: Mapping key-value relationships.
- **Example**:

  ```java
  @OneToMany
  @MapKey(name = "type")
  private Map<String, Document> documents;
  ```

---

#### **65\. `@Embedded`**

- **Purpose**: Embeds a component/embeddable object.
- **Use Case**: Reuse group of fields (like Address).
- **Example**:

  ```java
  @Embedded
  private Address address;
  ```

---

#### **66\. `@Embeddable`**

- **Purpose**: Marks a class to be embedded.
- **Use Case**: Define reusable components.
- **Example**:

  ```java
  @Embeddable
  public class Address {
      private String city;
      private String state;
  }
  ```

---

#### **67\. `@MappedSuperclass`**

- **Purpose**: Superclass fields are mapped to the entity table but superclass is not a table.
- **Use Case**: Common fields in multiple entities.
- **Example**:

  ```java
  @MappedSuperclass
  public abstract class BaseEntity {
      @Id @GeneratedValue
      private Long id;
  }
  ```

---

#### **68\. `@Inheritance`**

- **Purpose**: Configures inheritance strategy.
- **Parameters**: `strategy` (SINGLE_TABLE, JOINED, TABLE_PER_CLASS)
- **Use Case**: Map class hierarchies.
- **Example**:

  ```java
  @Inheritance(strategy = InheritanceType.JOINED)
  public abstract class Payment { ... }
  ```

---

#### **69\. `@DiscriminatorColumn`**

- **Purpose**: Specifies column used to identify subclass type in SINGLE_TABLE.
- **Parameters**: `name`, `discriminatorType`
- **Use Case**: In SINGLE_TABLE inheritance.
- **Example**:

  ```java
  @DiscriminatorColumn(name = "payment_type", discriminatorType = DiscriminatorType.STRING)
  ```

---

#### **70\. `@DiscriminatorValue`**

- **Purpose**: Specifies the value for subclass.
- **Use Case**: Used in SINGLE_TABLE inheritance.
- **Example**:

  ```java
  @DiscriminatorValue("CARD")
  public class CardPayment extends Payment { ... }
  ```

---

#### **71\. `@Access`**

- **Purpose**: Specifies access type (FIELD or PROPERTY).
- **Parameters**: `AccessType.FIELD`, `AccessType.PROPERTY`
- **Use Case**: Change how Hibernate accesses data (fields vs getters).
- **Example**:

  ```java
  @Access(AccessType.PROPERTY)
  public String getName() { ... }
  ```

---

#### **72\. `@Transient`**

- **Purpose**: Field is not persisted.
- **Use Case**: Store temporary or calculated fields.
- **Example**:

  ```java
  @Transient
  private int age;
  ```

---

#### **73\. `@Version`**

- **Purpose**: Enables optimistic locking.
- **Use Case**: Handle concurrent updates.
- **Example**:

  ```java
  @Version
  private int version;
  ```

---

#### **74\. `@NamedQuery`**

- **Purpose**: Predefine a static query.
- **Parameters**: `name`, `query`
- **Use Case**: Reuse common JPQL queries.
- **Example**:

  ```java
  @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email")
  ```

---

#### **75\. `@NamedEntityGraph`**

- **Purpose**: Define fetch plans to avoid N+1 problem.
- **Parameters**: `name`, `attributeNodes`
- **Use Case**: Control eager vs lazy fetch with joins.
- **Example**:

  ```java
  @NamedEntityGraph(name = "User.detail", attributeNodes = @NamedAttributeNode("roles"))
  ```

---

#### **76\. `@SqlResultSetMapping`**

- **Purpose**: Maps native SQL query results to entity or custom DTO.
- **Use Case**: When using raw SQL.
- **Example**:

  ```java
  @SqlResultSetMapping(
    name = "UserMapping",
    entities = @EntityResult(entityClass = User.class)
  )
  ```

---

#### **77\. `@Converter`**

- **Purpose**: Converts custom types for persistence.
- **Parameters**: `autoApply`
- **Use Case**: Custom value conversion (e.g., Enums, encrypted fields).
- **Example**:

  ```java
  @Converter(autoApply = true)
  public class BooleanToStringConverter implements AttributeConverter<Boolean, String> {
      public String convertToDatabaseColumn(Boolean value) { return value ? "Y" : "N"; }
      public Boolean convertToEntityAttribute(String value) { return "Y".equals(value); }
  }
  ```

---

### 🔹 **Transactional / AOP**

---

#### **78\. `@Transactional`**

- **Purpose**: Manages transaction boundaries. Ensures a method (or class) runs within a database transaction.
- **Parameters**:

  - `propagation`: Transaction propagation type (e.g., `REQUIRED`, `REQUIRES_NEW`)
  - `isolation`: Isolation level (e.g., `READ_COMMITTED`, `SERIALIZABLE`)
  - `readOnly`: Hint that the transaction is read-only (`true/false`)
  - `rollbackFor`: Exception types that trigger rollback
  - `noRollbackFor`: Exceptions that won't trigger rollback
  - `timeout`: Timeout value (in seconds)

- **Use Case**: Managing database integrity for service methods.
- **Code Example**:

  ```java
  @Transactional(readOnly = true, timeout = 30)
  public List<User> getAllUsers() {
      return userRepository.findAll();
  }
  ```

---

#### **79\. `@EnableTransactionManagement`**

- **Purpose**: Enables Spring’s annotation-driven transaction management capability.
- **Parameters**:

  - `proxyTargetClass`: Whether to use CGLIB-based proxying (`true`) or JDK proxying (`false`)
  - `mode`: `AdviceMode.PROXY` (default) or `AdviceMode.ASPECTJ`

- **Use Case**: Activating transactional behavior with `@Transactional`
- **Code Example**:

  ```java
  @Configuration
  @EnableTransactionManagement
  public class AppConfig {
  }
  ```

---

#### **80\. `@Aspect`**

- **Purpose**: Marks a class as an aspect (AOP cross-cutting concern).
- **Use Case**: Declaring reusable cross-cutting concerns like logging, auditing.
- **Code Example**:

  ```java
  @Aspect
  @Component
  public class LoggingAspect {
      // Pointcut and Advices here
  }
  ```

---

#### **81\. `@Before`**

- **Purpose**: Executes advice _before_ the matched method execution.
- **Parameters**:

  - Pointcut expression

- **Use Case**: Logging, permission checks before method execution.
- **Code Example**:

  ```java
  @Before("execution(* com.app.service.*.*(..))")
  public void logBefore(JoinPoint joinPoint) {
      System.out.println("Before: " + joinPoint.getSignature());
  }
  ```

---

#### **82\. `@After`**

- **Purpose**: Executes advice _after_ method execution (whether it returns normally or throws an exception).
- **Use Case**: Cleanup tasks, resource closing.
- **Code Example**:

  ```java
  @After("execution(* com.app.service.*.*(..))")
  public void afterMethod(JoinPoint jp) {
      System.out.println("Method ended: " + jp.getSignature());
  }
  ```

---

#### **83\. `@Around`**

- **Purpose**: Executes advice _before and after_ the method execution; also can control method execution.
- **Use Case**: Performance monitoring, dynamic permission validation.
- **Code Example**:

  ```java
  @Around("execution(* com.app.service.*.*(..))")
  public Object profile(ProceedingJoinPoint pjp) throws Throwable {
      long start = System.currentTimeMillis();
      Object result = pjp.proceed();
      long elapsedTime = System.currentTimeMillis() - start;
      System.out.println("Method executed in: " + elapsedTime + " ms");
      return result;
  }
  ```

---

#### **84\. `@AfterReturning`**

- **Purpose**: Executes advice _after method returns successfully_.
- **Parameters**:

  - `pointcut`
  - `returning`: Name of variable to access return value

- **Use Case**: Logging method result, post-processing return values.
- **Code Example**:

  ```java
  @AfterReturning(pointcut = "execution(* com.app.service.UserService.get*(..))", returning = "result")
  public void logResult(Object result) {
      System.out.println("Returned value: " + result);
  }
  ```

---

#### **85\. `@AfterThrowing`**

- **Purpose**: Executes advice _after a method throws an exception_.
- **Parameters**:

  - `pointcut`
  - `throwing`: Name of the exception variable

- **Use Case**: Error logging, alerting.
- **Code Example**:

  ```java
  @AfterThrowing(pointcut = "execution(* com.app.service.*.*(..))", throwing = "ex")
  public void logException(Exception ex) {
      System.err.println("Exception occurred: " + ex.getMessage());
  }
  ```

---

#### **86\. `@Pointcut`**

- **Purpose**: Defines reusable pointcut expressions.
- **Use Case**: DRY principle for advice expressions.
- **Code Example**:

  ```java
  @Pointcut("execution(* com.app.service.*.*(..))")
  public void serviceLayer() {}

  @Before("serviceLayer()")
  public void logServiceCalls() {
      System.out.println("Service method called");
  }
  ```

---

### 🔹 **Spring Scheduling / Async**

#### **87\. `@EnableScheduling`**

- **Purpose**: Enables support for scheduled tasks using `@Scheduled`.
- **Use Case**: Activating the scheduling mechanism in Spring Boot applications.
- **Code Example**:

  ```java
  @Configuration
  @EnableScheduling
  public class SchedulerConfig {
  }
  ```

---

#### **88\. `@Scheduled`**

- **Purpose**: Declares a method to be scheduled to run periodically or at a fixed time.
- **Parameters**:

  - `fixedRate`: Interval between method invocations (in milliseconds).
  - `fixedDelay`: Delay between the end of the last invocation and the start of the next.
  - `initialDelay`: Delay before the first execution.
  - `cron`: Cron expression for complex schedules.
  - `zone`: Time zone for cron expressions.

- **Use Case**: Periodic tasks like report generation, cache refresh, batch jobs, etc.
- **Code Example**:

  ```java
  @Scheduled(fixedRate = 5000) // runs every 5 seconds
  public void runTask() {
      System.out.println("Running task: " + LocalDateTime.now());
  }

  @Scheduled(cron = "0 0 8 * * *", zone = "Asia/Kolkata") // Every day at 8 AM IST
  public void runEveryMorning() {
      // send daily email
  }
  ```

---

#### **89\. `@EnableAsync`**

- **Purpose**: Enables Spring's asynchronous method execution capability.
- **Use Case**: Activating `@Async` methods to run asynchronously (on a separate thread).
- **Code Example**:

  ```java
  @Configuration
  @EnableAsync
  public class AsyncConfig {
  }
  ```

---

#### **90\. `@Async`**

- **Purpose**: Marks a method to execute asynchronously (in a different thread).
- **Parameters**:

  - `value`: Name of the custom executor bean.

- **Use Case**: Background processing, non-blocking calls like sending emails, notifications, API calls.
- **Code Example**:

  ```java
  @Async
  public void sendEmail(String to) {
      // runs in a separate thread
      emailService.send(to);
  }

  @Async("customExecutor")
  public CompletableFuture<User> findUserAsync(String id) {
      return CompletableFuture.completedFuture(userRepository.findById(id));
  }
  ```

> ⚠️ Methods annotated with `@Async` must be public and called from outside the bean (not self-invoked).

---

### 🔹 **Spring Security Annotations**

#### **91\. `@EnableWebSecurity`**

- **Purpose**: Enables Spring Security’s web security support.
- **Parameters**:

  - `debug` (default: `false`) – Enables debug logs for security filters.

- **Use Case**: Applied on a configuration class to bootstrap Spring Security.
- **Code Example**:

  ```java
  @Configuration
  @EnableWebSecurity
  public class SecurityConfig extends WebSecurityConfigurerAdapter {
      // configure() methods
  }
  ```

---

#### **92\. `@EnableGlobalMethodSecurity`** (Pre-Spring Security 6.x)

- **Purpose**: Enables method-level security annotations like `@PreAuthorize`, `@Secured`, etc.
- **Parameters**:

  - `prePostEnabled = true`: Enables `@PreAuthorize`, `@PostAuthorize`.
  - `securedEnabled = true`: Enables `@Secured`.
  - `jsr250Enabled = true`: Enables `@RolesAllowed`.

- **Use Case**: Add to config class to secure service methods.
- **Code Example**:

  ```java
  @Configuration
  @EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
  public class MethodSecurityConfig {
  }
  ```

🧠 **Note**: In Spring Security 6+, use `@EnableMethodSecurity` instead.

---

#### **93\. `@PreAuthorize`**

- **Purpose**: Authorizes method execution _before_ invocation based on SpEL expression.
- **Parameters**:

  - SpEL condition (e.g., `hasRole('ADMIN')`, `#user.name == authentication.name`)

- **Use Case**: Fine-grained access control at method level.
- **Code Example**:

  ```java
  @PreAuthorize("hasRole('ADMIN')")
  public void deleteUser(Long id) { ... }
  ```

---

#### **94\. `@PostAuthorize`**

- **Purpose**: Authorizes method _after_ execution using return value.
- **Parameters**: SpEL expression using `returnObject`
- **Use Case**: Filter based on output (e.g., return object belongs to current user).
- **Code Example**:

  ```java
  @PostAuthorize("returnObject.owner == authentication.name")
  public Document getDocument(Long id) { ... }
  ```

---

#### **95\. `@PreFilter`**

- **Purpose**: Filters method argument collections _before_ method execution.
- **Parameters**:

  - `filterTarget`: Parameter to filter.
  - `value`: SpEL condition.

- **Use Case**: Filter incoming data based on security logic.
- **Code Example**:

  ```java
  @PreFilter(value = "filterObject.owner == authentication.name")
  public void processDocs(List<Document> docs) { ... }
  ```

---

#### **96\. `@PostFilter`**

- **Purpose**: Filters return value collection _after_ method execution.
- **Parameters**:

  - SpEL condition on `filterObject`.

- **Use Case**: Remove unauthorized items from returned list.
- **Code Example**:

  ```java
  @PostFilter("filterObject.owner == authentication.name")
  public List<Document> getAllDocs() { ... }
  ```

---

#### **97\. `@Secured`**

- **Purpose**: Restricts access to methods by role.
- **Parameters**: Array of roles (e.g., `"ROLE_ADMIN"`)
- **Use Case**: Legacy style method access control.
- **Code Example**:

  ```java
  @Secured("ROLE_ADMIN")
  public void secureAction() { ... }
  ```

---

#### **98\. `@RolesAllowed`**

- **Purpose**: JSR-250 annotation for role-based access.
- **Parameters**: Role list (e.g., `"ADMIN"`)
- **Use Case**: Declarative access control using Java EE standard.
- **Code Example**:

  ```java
  @RolesAllowed("ADMIN")
  public void restrictedMethod() { ... }
  ```

🧠 **Note**: Requires `@EnableGlobalMethodSecurity(jsr250Enabled = true)`.

---

#### **99\. `@AuthenticationPrincipal`**

- **Purpose**: Injects the current authenticated principal (usually `UserDetails`) into controller methods.
- **Parameters**:

  - `expression` (optional): SpEL to extract part of the principal.

- **Use Case**: Access user info directly in controller.
- **Code Example**:

  ```java
  @GetMapping("/profile")
  public UserProfile getProfile(@AuthenticationPrincipal UserDetails user) {
      return userService.getProfile(user.getUsername());
  }
  ```

---

#### ✅ Quick Tips & Gotchas:

| Annotation                 | Tips & Warnings                                                               |
| -------------------------- | ----------------------------------------------------------------------------- |
| `@PreAuthorize`            | Method must be public (private methods won't be intercepted).                 |
| `@Pre/PostFilter`          | Only works with collections, not arrays.                                      |
| `@AuthenticationPrincipal` | Cleaner than calling `SecurityContextHolder.getContext().getAuthentication()` |
| `@Secured`                 | Requires `"ROLE_"` prefix in role name.                                       |

---

### 🔹 **Spring Caching Annotations**

These annotations simplify caching logic and work seamlessly with providers like EhCache, Redis, or simple in-memory caches.

---

#### **100\. `@EnableCaching`**

- **Purpose**: Enables Spring’s annotation-driven cache management capability.
- **Parameters**: _(None)_
- **Use Case**: Add this to a `@Configuration` class to activate caching.
- **Code Example**:

  ```java
  @Configuration
  @EnableCaching
  public class CacheConfig {
      // Optionally configure cache manager here
  }
  ```

---

#### **101\. `@Cacheable`**

- **Purpose**: Marks a method whose result should be cached. On subsequent calls with the same parameters, the cached result is returned instead of executing the method.
- **Parameters**:

  - `value` or `cacheNames`: Name(s) of the cache.
  - `key`: SpEL to customize the cache key.
  - `condition`: SpEL to apply caching conditionally.
  - `unless`: SpEL to skip caching based on result.
  - `sync`: Enables synchronized cache access for concurrent calls.

- **Use Case**: Use for expensive read operations (DB/API).
- **Code Example**:

  ```java
  @Cacheable(value = "products", key = "#id", unless = "#result == null")
  public Product getProductById(Long id) {
      return productRepository.findById(id).orElse(null);
  }
  ```

---

#### **102\. `@CachePut`**

- **Purpose**: Updates (or inserts) the cache with the method’s result _without_ skipping execution.
- **Parameters**: Same as `@Cacheable`
- **Use Case**: Use when you want to **always execute** the method but also update the cache with the new result.
- **Code Example**:

  ```java
  @CachePut(value = "products", key = "#product.id")
  public Product updateProduct(Product product) {
      return productRepository.save(product);
  }
  ```

🧠 **Note**: Unlike `@Cacheable`, this **always runs** the method.

---

#### **103\. `@CacheEvict`**

- **Purpose**: Removes cache entries.
- **Parameters**:

  - `value`: Name of the cache.
  - `key`: Key to remove (optional).
  - `allEntries`: If `true`, clears the entire cache.
  - `beforeInvocation`: If `true`, eviction happens **before** method execution.

- **Use Case**: Use for **delete** or **update** operations.
- **Code Example**:

  ```java
  @CacheEvict(value = "products", key = "#id")
  public void deleteProduct(Long id) {
      productRepository.deleteById(id);
  }

  // Or clear all:
  @CacheEvict(value = "products", allEntries = true)
  public void clearCache() { }
  ```

---

#### ✅ Quick Tips:

| Annotation       | Behavior                                                               |
| ---------------- | ---------------------------------------------------------------------- |
| `@Cacheable`     | Skips method execution if key is in cache.                             |
| `@CachePut`      | Always executes method and updates cache with result.                  |
| `@CacheEvict`    | Clears cache entry or all entries optionally before/after method call. |
| `@EnableCaching` | Required to activate all caching annotations.                          |

---

### 🔹 **Miscellaneous / Testing / Utility**

#### **105\. `@Conditional`**

- **Purpose**: Registers a bean only if the specified condition (custom logic) is met.
- **Parameters**:

  - `value`: Class implementing `Condition` interface.

- **Use Case**: Custom logic to control bean registration.
- **Code Example**:

  ```java
  @Conditional(MyCondition.class)
  @Bean
  public MyService myService() {
      return new MyService();
  }
  ```

---

#### **106\. `@ConditionalOnProperty`**

- **Purpose**: Registers a bean only if a specific property is present and has the expected value.
- **Parameters**:

  - `prefix`, `name`, `havingValue`, `matchIfMissing`

- **Use Case**: Enable/disable beans via properties (like enabling features).
- **Code Example**:

  ```java
  @ConditionalOnProperty(name = "feature.enabled", havingValue = "true")
  @Bean
  public FeatureService featureService() {
      return new FeatureService();
  }
  ```

---

#### **107\. `@ConditionalOnClass`**

- **Purpose**: Registers a bean only if the specified class is present in the classpath.
- **Parameters**:

  - `value`: One or more class references.

- **Use Case**: Auto-configurations depending on optional libraries.
- **Code Example**:

  ```java
  @ConditionalOnClass(name = "com.example.SomeClass")
  public class MyAutoConfiguration {
      // only loaded if SomeClass is present
  }
  ```

---

#### **108\. `@ConditionalOnMissingBean`**

- **Purpose**: Registers a bean only if the specified bean is _not_ already present.
- **Parameters**:

  - `value` or `name`

- **Use Case**: Provide default beans that can be overridden.
- **Code Example**:

  ```java
  @ConditionalOnMissingBean(MyService.class)
  @Bean
  public MyService defaultMyService() {
      return new DefaultMyService();
  }
  ```

---

#### **109\. `@ConditionalOnBean`**

- **Purpose**: Registers a bean only if another specified bean exists.
- **Parameters**: `value`, `name`
- **Use Case**: Dependent configurations based on other beans.
- **Code Example**:

  ```java
  @ConditionalOnBean(DataSource.class)
  @Bean
  public JdbcTemplate jdbcTemplate(DataSource ds) {
      return new JdbcTemplate(ds);
  }
  ```

---

#### **110\. `@ConditionalOnExpression`**

- **Purpose**: Conditional bean registration using a SpEL expression.
- **Parameters**: `value` (SpEL expression)
- **Use Case**: Complex conditions using dynamic values.
- **Code Example**:

  ```java
  @ConditionalOnExpression("${feature.level} > 3")
  @Bean
  public AdvancedFeature advancedFeature() {
      return new AdvancedFeature();
  }
  ```

---

#### **111\. `@EnableAspectJAutoProxy`**

- **Purpose**: Enables support for handling aspects via proxy classes (AOP).
- **Parameters**:

  - `proxyTargetClass`: Use CGLIB proxy instead of JDK dynamic proxies.
  - `exposeProxy`: Makes proxy available via `AopContext.currentProxy()`.

- **Use Case**: Required for AOP to work (logging, transactions, etc.).
- **Code Example**:

  ```java
  @Configuration
  @EnableAspectJAutoProxy(proxyTargetClass = true)
  public class AppConfig { }
  ```

---

#### **112\. `@DirtiesContext`**

- **Purpose**: Indicates that the Spring test context should be reloaded after the test.
- **Parameters**:

  - `classMode`, `methodMode` (can specify per class or method)

- **Use Case**: Reset shared state after test that modifies beans.
- **Code Example**:

  ```java
  @Test
  @DirtiesContext
  public void testThatChangesContext() {
      // context will be cleaned afterward
  }
  ```

---

#### **113\. `@TestPropertySource`**

- **Purpose**: Adds property sources to Spring’s `Environment` for test classes.
- **Parameters**:

  - `locations` or `properties`

- **Use Case**: Load custom properties for testing.
- **Code Example**:

  ```java
  @SpringBootTest
  @TestPropertySource(properties = "my.key=value")
  public class MyTest { }
  ```

---

#### **114\. `@Sql`**

- **Purpose**: Executes SQL scripts before or after a test.
- **Parameters**:

  - `scripts`, `executionPhase` (BEFORE_TEST_METHOD, AFTER_TEST_METHOD)

- **Use Case**: Prepare DB state for integration testing.
- **Code Example**:

  ```java
  @Sql(scripts = "/test-data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
  public class UserRepositoryTest { }
  ```

---

#### **115\. `@SqlGroup`**

- **Purpose**: Container for repeating `@Sql` annotations.
- **Parameters**: `@Sql[]`
- **Use Case**: Multiple scripts before/after a test.
- **Code Example**:

  ```java
  @SqlGroup({
    @Sql(scripts = "/schema.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD),
    @Sql(scripts = "/data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
  })
  public class SomeTest { }
  ```

---

#### **116\. `@Rollback`**

- **Purpose**: Controls whether a test should roll back the transaction.
- **Parameters**: `value` (true/false)
- **Use Case**: Keep or discard DB changes made in test methods.
- **Code Example**:

  ```java
  @Test
  @Transactional
  @Rollback(false) // Changes will persist after test
  public void testWithCommit() {
      // test code
  }
  ```

---

---

---

---

# Experience-Wise Spring-Boot Interview Questions

## ✅ Less than 1 Year Experience

> _For freshers or those with up to 1 year of experience. Focus is on fundamental understanding._

1.  What is Spring Boot?
2.  What are the Features of Spring Boot?
3.  What are the advantages of using Spring Boot?
4.  Define the Key Components of Spring Boot.
5.  Why do we prefer Spring Boot over Spring?
6.  Explain the internal working of Spring Boot.
7.  What are the Spring Boot Starter Dependencies?
8.  How does a Spring application get started?
9.  What does the `@SpringBootApplication` annotation do internally?
10. What is Spring Initializr?

11. What are Spring Boot CLI and the most used CLI commands?

---

## 🧠 1 to 2 Years Experience

> _For those with some practical experience. Focus is on annotations, configuration, and behavior understanding._

1.  What are the basic Spring Boot Annotations?
2.  What is Spring Boot dependency management?
3.  Is it possible to change the port of the embedded Tomcat server in Spring Boot?
4.  What is the starter dependency of the Spring Boot module?
5.  What is the default port of Tomcat in Spring Boot?
6.  Can we disable the default web server in the Spring Boot application?
7.  How to disable a specific auto-configuration class?
8.  Can we create a non-web application in Spring Boot?
9.  Describe the flow of HTTPS requests through the Spring Boot application.
10. Explain `@RestController` annotation in Spring Boot.

11. Difference between `@Controller` and `@RestController`.

12. What is the difference between `@RequestMapping` and `@GetMapping`?

13. What are the differences between `@SpringBootApplication` and `@EnableAutoConfiguration` annotation?

14. What are Profiles in Spring?

15. Mention the differences between WAR and embedded containers.

---

## 🔧 2 to 3 Years Experience

> _Focuses on implementation, security, bean handling, logging, and design decisions._

1.  Purpose of Spring Boot’s `@EnableAutoConfiguration` annotation
2.  Relationship between `@SpringBootApplication` and `@EnableAutoConfiguration`
3.  Difference between `@Component`, `@Repository`, `@Service` annotations
4.  How Spring Boot supports asynchronous processing
5.  Significance of Spring Boot’s `@Conditional` annotations
6.  How Spring Boot handles logging
7.  CSRF protection in Spring Security and how to disable it
8.  Purpose of `SecurityContextHolder` in Spring Security
9.  Benefits of Spring Boot’s Actuator endpoints
10. How Spring Boot’s `@Value` annotation works

11. Spring Boot’s `WebClient` vs. `RestTemplate`

12. How Spring manages circular dependencies

13. Role of `@Primary`, `@Qualifier`, `@Profile` in bean selection

14. Difference between `@Bean` and `@Component`

15. Circuit Breaker and implementation in Spring Boot

16. Secure Spring Boot REST APIs using OAuth2 with Google

17. Purpose of `@DataJpaTest` in Spring Boot

18. What are `@ConfigurationProperties` in Spring Boot

19. How Spring Boot handles caching and caching annotations

20. Different scopes of Spring Beans

---

## 🧪 3 to 4 Years Experience

> _More advanced usage, configuration, and application introspection._

1.  What is Spring Boot Actuator?
2.  How to enable Actuator in the Spring Boot application?
3.  What is the purpose of using `@ComponentScan` in class files?
4.  What are the `@RequestMapping` and `@RestController` annotations used for?
5.  How to get the list of all the beans in your Spring Boot application?
6.  Can we check the environment properties in your Spring Boot application? Explain how.
7.  How to enable debugging logs in the Spring Boot application?
8.  What is Dependency Injection and its types?
9.  What is an IoC container?
10. What is the difference between Constructor and Setter Injection?

---

## 🚀 4+ Years Experience

> _Advanced questions focusing on microservices, optimization, custom implementations, and production readiness._

1.  Optimizing Spring Boot startup time in production
2.  Spring Boot’s `@ConfigurationProperties` with complex objects
3.  Distributed tracing challenges and implementation in microservices
4.  Implementing robust custom health check with Actuator
5.  Handling service discovery in microservices with Eureka
6.  Spring Boot’s `@Retryable` annotation for microservices reliability
7.  Implementing custom security policies with Spring Security
8.  Event-driven microservices with Kafka or RabbitMQ
9.  Handling versioning in Spring Boot APIs
10. Implementing multi-tenancy in Spring Boot applications

11. Creating a custom Spring Boot starter module

12. Managing external configurations across environments

13. Strategies for debugging Spring Boot in production

14. Implementing Spring Boot Security with OAuth 2.0 for microservices

15. Common performance bottlenecks and resolutions

16. Handling asynchronous processing with `@Async`

17. Implementing caching with `@Cacheable`

18. Configuring and managing Spring Boot logging in production

19. Implementing API Gateway with Spring Cloud Gateway

20. Handling transactions with `@Transactional`

21. Differences between `@RequestMapping`, `@GetMapping`, `@PostMapping`, etc.

22. Implementing file upload and download functionality

23. Using Spring Boot profiles for different environments

24. Implementing JWT-based authentication

25. Configuring Spring Boot with Docker for containerization

26. Implementing rate-limiting in Spring Boot

27. Implementing custom exception handler with `@ControllerAdvice`

28. Using `@Scheduled` annotation for background tasks

29. Implementing Spring Boot with NoSQL databases like MongoDB, Cassandra

30. Configuring Spring Boot with message queues like RabbitMQ, Kafka

---

## Answers of All the Questions Listed Above Experience-Wise

### ✅ Spring Boot Interview Questions (For Beginners – Less than 1 Year Experience)

---

#### 1\. What is Spring Boot?

Spring Boot is a framework that makes it easier to create Java applications quickly. It builds on top of the Spring Framework but simplifies it by providing:

- Default configurations
- Auto-setup for commonly used libraries
- Embedded servers
- Production-ready tools

**Analogy:** Think of it like a pre-cooked meal kit — you just add your ingredients (code), and it sets up the kitchen (environment) for you!

**Use Cases:** Web apps, microservices, REST APIs, and enterprise apps.

---

#### 2\. What are the Features of Spring Boot?

- **Auto-Configuration:** Automatically configures your application based on the libraries on the classpath.
- **Starters:** Pre-configured dependency bundles (e.g., `spring-boot-starter-web`).
- **Embedded Servers:** No need to deploy WARs — uses embedded Tomcat, Jetty, etc.
- **Spring Boot CLI:** Run and test apps from the terminal using Groovy.
- **Spring Boot Actuator:** Built-in endpoints to monitor and manage your application (`/health`, `/metrics`, etc.).

These features enable **faster, cleaner, and hassle-free development**.

---

#### 3\. What are the Advantages of Using Spring Boot?

- **Faster Development:** Minimal setup, lots of auto-configuration.
- **Simplified Configuration:** Little to no XML/Java config needed.
- **Embedded Servers:** Deploy as JAR files with embedded Tomcat/Jetty.
- **Reduced Boilerplate Code:** Focus more on business logic.
- **Microservices Friendly:** Perfect for cloud-native applications.
- **Vast Community Support:** Tons of documentation and community help.

---

#### 4\. Define the Key Components of Spring Boot

- **Starters:** Bundles of dependencies for different use-cases (`web`, `JPA`, `security`, etc.).
- **Auto-Configuration:** Enables Spring Boot to guess and configure things automatically.
- **Spring Boot CLI:** A Groovy-based command-line tool to build and run Spring apps quickly.
- **Actuator:** Provides endpoints to help monitor, analyze, and manage production-ready apps.
- **Spring Initializr:** A web-based tool to bootstrap Spring Boot projects.

---

#### 5\. Why Do We Prefer Spring Boot Over Spring?

- **No XML Configuration:** Everything is annotation-driven.
- **Auto Setup:** Auto-configures your app based on classpath.
- **Embedded Servers:** Eliminates the need for external servlet containers.
- **Starter POMs:** Include everything needed for specific features.
- **Less Boilerplate Code:** Faster development cycles.
- **Developer Productivity:** Spring Boot streamlines and accelerates development.

---

#### 6\. Explain the Internal Working of Spring Boot

Spring Boot does the following behind the scenes:

- **Classpath Scanning:** Scans your dependencies and identifies what’s required.
- **Auto-Configuration:** Applies relevant configurations (e.g., `DataSource`, `DispatcherServlet`).
- **Starter Dependencies:** Uses predefined starter packs for features.
- **Embedded Server Initialization:** Launches an embedded server like Tomcat.
- **Runs the App:** Uses `SpringApplication.run()` to bootstrap the app.

It’s designed to **“just work”** with minimal setup.

---

#### 7\. What are the Spring Boot Starter Dependencies?

Some popular Spring Boot starters include:

- `spring-boot-starter-web`: For building web apps with Spring MVC and embedded Tomcat
- `spring-boot-starter-data-jpa`: For integrating JPA and Hibernate
- `spring-boot-starter-security`: For adding authentication and authorization
- `spring-boot-starter-test`: For testing with JUnit, Mockito, etc.
- `spring-boot-starter-thymeleaf`: For server-side rendered views using Thymeleaf

**Think of starters as combo packs** that include all the libraries you need for specific tasks.

---

#### 8\. How Does a Spring Application Get Started?

1.  **Create a main class** with a `main()` method.
2.  **Add the `@SpringBootApplication` annotation** to enable auto-configuration and scanning.
3.  **Run using `SpringApplication.run()`**.

```java
@SpringBootApplication
public class MyApp {
    public static void main(String[] args) {
        SpringApplication.run(MyApp.class, args);
    }
}
```

Spring Boot sets up the entire application context, initializes beans, and starts the embedded server.

---

#### 9\. What Does the `@SpringBootApplication` Annotation Do Internally?

It’s a combination of:

- `@Configuration`: Marks the class as a configuration class.
- `@EnableAutoConfiguration`: Enables Spring Boot’s auto-configuration.
- `@ComponentScan`: Scans the package for components like controllers, services, and repositories.

**So basically**, it bootstraps your entire application in one go.

---

#### 10\. What is Spring Initializr?

Spring Initializr ([https://start.spring.io](https://start.spring.io)) is a web-based project generator.

You can:

- Choose your **build tool** (Maven/Gradle)
- Choose **Java version** and language
- Select **dependencies** (like web, JPA, security)
- Download a preconfigured **project zip**

**It’s like a Spring project wizard** — saves time and removes all the setup hassle.

---

#### 11\. What are Spring Boot CLI and the Most Used CLI Commands?

Spring Boot CLI (Command Line Interface) is a tool that allows you to run Spring apps and scripts quickly without an IDE.

**Common Commands:**

- `spring run app.groovy` – Runs a Groovy-based Spring Boot app
- `spring init --dependencies=web,data-jpa demo` – Creates a new Spring Boot project with given dependencies
- `spring test app.groovy` – Runs tests for your app
- `spring shell` – Opens an interactive shell for experimenting

**Useful for quick prototyping**, learning, and automating project creation.

---

### ✅ Well-Explained Answers for 1–2 Years of Experience

For developers with 1-2 years of experience, the focus shifts toward practical application, understanding annotations, configurations, and how Spring Boot behaves in real-world scenarios. The answers below provide clear explanations with examples, emphasizing key concepts without overwhelming with unnecessary depth.

---

#### 1\. What are the Basic Spring Boot Annotations?

Spring Boot uses annotations to simplify configuration and coding. Here are the most common ones:

- `@SpringBootApplication`: Combines `@Configuration`, `@EnableAutoConfiguration`, and `@ComponentScan` to set up your app.
- `@Controller`: Marks a class as a web controller to handle HTTP requests.
- `@RestController`: A specialized `@Controller` that returns data (e.g., JSON) directly, not views.
- `@RequestMapping`: Maps HTTP requests to methods (e.g., `/home`).
- `@Service`: Indicates a class handles business logic.
- `@Repository`: Marks a class as a data access layer (e.g., for database operations).
- `@Autowired`: Automatically injects dependencies into your code.

These annotations reduce boilerplate and make your code cleaner.

---

#### 2\. What is Spring Boot Dependency Management?

Spring Boot dependency management simplifies handling libraries in your project. It:

- Uses starters (e.g., `spring-boot-starter-web`) that bundle related dependencies (like Spring MVC, Tomcat).
- Automatically manages versions of these dependencies via the `spring-boot-dependencies` POM file, so you don’t need to specify versions manually.
- Allows overrides if you need a specific version (e.g., in `pom.xml`).

**Example (Maven):**

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

This pulls in everything needed for a web app, with compatible versions.

---

#### 3\. Is it Possible to Change the Port of the Embedded Tomcat Server in Spring Boot?

Yes, you can change the default port (8080) of the embedded Tomcat server easily:

**Via `application.properties`:**

```properties
server.port=8081
```

**Via Java code (less common):**

```java
@SpringBootApplication
public class MyApp {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(MyApp.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", "8081"));
        app.run(args);
    }
}
```

This flexibility lets you avoid port conflicts in development or production.

---

#### 4\. What is the Starter Dependency of the Spring Boot Module?

A "starter" dependency is a pre-packaged set of libraries that Spring Boot provides to simplify setup for specific features.

For example:

- `spring-boot-starter-web`: Includes Spring MVC, Tomcat, and JSON support for web apps.
- `spring-boot-starter-data-jpa`: Adds Hibernate and Spring Data for database access.
- `spring-boot-starter-security`: Provides Spring Security for authentication.

They’re defined in your `pom.xml` (Maven) or `build.gradle` (Gradle) and reduce manual dependency management.

**Example:**

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

---

#### 5\. What is the Default Port of Tomcat in Spring Boot?

The default port for the embedded Tomcat server in Spring Boot is **8080**. You can access your app at [http://localhost:8080](http://localhost:8080) unless you change it (e.g., via `server.port` in `application.properties`). This default makes it easy to get started without extra configuration.

---

#### 6\. Can We Disable the Default Web Server in the Spring Boot Application?

Yes, you can disable the default web server (e.g., Tomcat) to create a non-web app.

**In `application.properties`:**

```properties
spring.main.web-application-type=none
```

**Or in your main class:**

```java
@SpringBootApplication
public class MyApp {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(MyApp.class);
        app.setWebApplicationType(WebApplicationType.NONE);
        app.run(args);
    }
}
```

This is useful for batch jobs or console apps that don’t need a web server.

---

#### 7\. How to Disable a Specific Auto-Configuration Class?

Spring Boot auto-configures many features, but you can disable specific ones:

**Use the `exclude` attribute in `@SpringBootApplication`:**

```java
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MyApp {
    public static void main(String[] args) {
        SpringApplication.run(MyApp.class, args);
    }
}
```

**Or in `application.properties`:**

```properties
spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
```

This is handy if you want to customize a feature (e.g., database setup) manually.

---

#### 8\. Can We Create a Non-Web Application in Spring Boot?

Yes, Spring Boot isn’t just for web apps. To create a non-web app:

- Remove web-related starters (e.g., `spring-boot-starter-web`).
- Disable the web server:

```properties
spring.main.web-application-type=none
```

**Example for a console app:**

```java
@SpringBootApplication
public class MyApp {
    public static void main(String[] args) {
        SpringApplication.run(MyApp.class, args);
        System.out.println("Hello, non-web app!");
    }
}
```

This is great for batch processing or command-line tools.

---

#### 9\. Describe the Flow of HTTPS Requests Through the Spring Boot Application.

Here’s how an HTTPS request flows:

1.  **Client Sends Request**: A browser sends an HTTPS request (e.g., `https://localhost:8443/api`).
2.  **Embedded Server (Tomcat)**: Receives the request, decrypts it using SSL/TLS (if configured with a certificate).
3.  **DispatcherServlet**: Spring Boot’s central servlet routes the request to the right controller.
4.  **Controller**: A `@RestController` or `@Controller` method processes the request (e.g., fetches data).
5.  **Response**: The controller returns a response (e.g., JSON), which is encrypted and sent back via Tomcat.

**Example HTTPS setup:**

```properties
server.port=8443
server.ssl.key-store=classpath:keystore.jks
server.ssl.key-store-password=secret
```

---

#### 10\. Explain @RestController Annotation in Spring Boot.

`@RestController` is a Spring annotation that combines `@Controller` and `@ResponseBody`. It:

- Marks a class as a web controller.
- Automatically converts method return values (e.g., objects) to JSON or XML for HTTP responses.

**Example:**

```java
@RestController
public class MyController {
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, World!";
    }
}
```

Calling `/hello` returns `"Hello, World!"` as JSON. It’s perfect for REST APIs.

---

#### 11\. Difference Between @Controller and @RestController

**@Controller:**

- Used for traditional web apps that return views (e.g., HTML pages).
- Needs `@ResponseBody` to return data directly (e.g., JSON).

**@RestController:**

- Designed for REST APIs; always returns data (e.g., JSON) directly.
- Includes `@ResponseBody` by default.

**Example:**

```java
@Controller
public class ViewController {
    @GetMapping("/page")
    public String getPage() {
        return "index"; // Returns a view name
    }
}

@RestController
public class ApiController {
    @GetMapping("/data")
    public String getData() {
        return "Hello"; // Returns "Hello" as JSON
    }
}
```

---

#### 12\. What is the Difference Between @RequestMapping and @GetMapping?

**@RequestMapping:**

- General-purpose annotation for mapping any HTTP method (GET, POST, etc.).
- Requires specifying the method (e.g., `method = RequestMethod.GET`).

**@GetMapping:**

- Shortcut for `@RequestMapping` specifically for GET requests.
- Cleaner and more readable.

**Example:**

```java
@RequestMapping(value = "/test", method = RequestMethod.GET)
public String oldWay() {
    return "Test";
}

@GetMapping("/test")
public String newWay() {
    return "Test";
}
```

---

#### 13\. What are the Differences Between @SpringBootApplication and @EnableAutoConfiguration?

**@SpringBootApplication:**

- A combo annotation: `@Configuration`, `@EnableAutoConfiguration`, and `@ComponentScan`.
- Used on the main class to bootstrap the entire app.

**@EnableAutoConfiguration:**

- Only enables auto-configuration based on classpath dependencies.
- Doesn’t include scanning or configuration features.

Use `@SpringBootApplication` for simplicity; use `@EnableAutoConfiguration` if you need finer control.

---

#### 14\. What are Profiles in Spring?

Profiles in Spring let you define different configurations for different environments (e.g., dev, prod). You:

**Set a profile in `application.properties`:**

```properties
spring.profiles.active=dev
```

**Use profile-specific files (e.g., `application-dev.properties`):**

```properties
server.port=8081
```

**Or annotate beans:**

```java
@Profile("dev")
@Bean
public String devBean() {
    return "Dev Mode";
}
```

This keeps environment-specific settings separate.

---

#### 15\. Mention the Differences Between WAR and Embedded Containers

**WAR (Web Archive):**

- A packaged file (`.war`) deployed on an external server (e.g., Tomcat, JBoss).
- Requires manual server setup and deployment.
- Traditional approach for Spring apps.

**Embedded Containers:**

- Server (e.g., Tomcat) is bundled inside your Spring Boot app.
- Runs as a standalone `.jar` with `java -jar`.
- No external server needed; faster to start.

Spring Boot prefers embedded containers for simplicity and microservices.

---

### ✅ Well-Explained Answers for 2–3 Years of Experience

For developers with 2–3 years of experience, the focus is on deeper implementation details, security, bean management, and design decisions. The answers below are practical, concise, and include examples to align with this experience level.

---

#### 1\. Purpose of Spring Boot’s `@EnableAutoConfiguration` Annotation

`@EnableAutoConfiguration` tells Spring Boot to automatically configure your application based on the dependencies in your classpath. For example, if `spring-boot-starter-web` is present, it sets up a web server and Spring MVC. It uses conditional logic (via `@Conditional`) to decide what to configure, reducing manual setup.  
Example:

```java
@EnableAutoConfiguration
public class MyApp {
    public static void main(String[] args) {
        SpringApplication.run(MyApp.class, args);
    }
}
```

It’s a key part of Spring Boot’s “convention over configuration” philosophy.

---

#### 2\. Relationship Between `@SpringBootApplication` and `@EnableAutoConfiguration`

`@SpringBootApplication` is a convenience annotation that includes `@EnableAutoConfiguration`, along with `@Configuration` and `@ComponentScan`. Essentially:

- `@EnableAutoConfiguration` handles auto-configuration.
- `@SpringBootApplication` adds component scanning and bean definition capabilities.

You use `@SpringBootApplication` on your main class for a full setup, while `@EnableAutoConfiguration` is narrower, focusing only on auto-config.  
Example:

```java
@SpringBootApplication // Includes @EnableAutoConfiguration
public class MyApp {
    public static void main(String[] args) {
        SpringApplication.run(MyApp.class, args);
    }
}
```

---

#### 3\. Difference Between `@Component`, `@Repository`, `@Service` Annotations

These are all stereotypes for marking beans, but they have specific roles:

- `@Component`: General-purpose annotation for any Spring-managed bean.
- `@Repository`: Marks a data access layer bean (e.g., DAO); adds exception translation for persistence errors.
- `@Service`: Marks a business logic layer bean; indicates it holds service-level operations.

Example:

```java
@Component
class GenericBean {}

@Repository
class UserRepository {}

@Service
class UserService {}
```

They help Spring identify bean roles and apply appropriate behavior (e.g., persistence exception handling for `@Repository`).

---

#### 4\. How Spring Boot Supports Asynchronous Processing

Spring Boot supports async processing with the `@EnableAsync` annotation and `@Async` on methods:

- Add `@EnableAsync` to a configuration class.
- Mark methods with `@Async` to run them in a separate thread.

Example:

```java
@Configuration
@EnableAsync
public class AsyncConfig {}

@Service
public class MyService {
    @Async
    public CompletableFuture<String> doWork() {
        Thread.sleep(1000); // Simulate work
        return CompletableFuture.completedFuture("Done");
    }
}
```

Spring uses a `TaskExecutor` (default: `SimpleAsyncTaskExecutor`) to manage threads. You can customize it with a `ThreadPoolTaskExecutor`.

---

#### 5\. Significance of Spring Boot’s `@Conditional` Annotations

`@Conditional` annotations control whether a bean or configuration is created based on conditions.  
Examples:

- `@ConditionalOnClass`: Applies if a class is present (e.g., HikariCP for database config).
- `@ConditionalOnProperty`: Applies if a property exists or has a specific value.

Example:

```java
@Configuration
@ConditionalOnProperty(name = "feature.enabled", havingValue = "true")
public class FeatureConfig {
    @Bean
    public MyFeature myFeature() {
        return new MyFeature();
    }
}
```

This makes auto-configuration flexible and context-aware.

---

#### 6\. How Spring Boot Handles Logging

Spring Boot uses **SLF4J with Logback** as the default logging framework:

- Configured via `application.properties` (e.g., `logging.level.org.springframework=DEBUG`)
- Supports log levels (TRACE, DEBUG, INFO, etc.)
- Logs to console by default; can be redirected to files

Example:

```properties
logging.level.com.myapp=INFO
logging.file.name=app.log
```

You can also use other frameworks (e.g., Log4j2) by excluding Logback and adding the desired dependency.

---

#### 7\. CSRF Protection in Spring Security and How to Disable It

CSRF (Cross-Site Request Forgery) protection is enabled by default in Spring Security for state-changing requests (e.g., POST). It uses a token to validate requests.  
To disable it:

```java
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable(); // Disables CSRF
    }
}
```

> Disable it only for stateless APIs (e.g., REST with JWT), not form-based apps.

---

#### 8\. Purpose of `SecurityContextHolder` in Spring Security

`SecurityContextHolder` stores the current user’s security context (e.g., authentication details) in a thread-local variable.  
It provides access to the authenticated user via:

```java
Authentication auth = SecurityContextHolder.getContext().getAuthentication();
String username = auth.getName(); // Logged-in user
```

It’s central to Spring Security’s authentication and authorization flow.

---

#### 9\. Benefits of Spring Boot’s Actuator Endpoints

**Actuator** provides production-ready endpoints to monitor and manage your app:

- `/health`: Checks app status.
- `/metrics`: Exposes performance metrics.
- `/info`: Displays custom app info.

**Benefits**:

- Real-time monitoring
- Easy integration with tools like Prometheus
- Helps debug production issues

Enable it with `spring-boot-starter-actuator` and configure via `application.properties`:

```properties
management.endpoints.web.exposure.include=health,metrics
```

---

#### 10\. How Spring Boot’s `@Value` Annotation Works

`@Value` injects values from properties files, environment variables, or defaults into fields or parameters.  
Example:

```java
@Service
public class MyService {
    @Value("${app.name:DefaultApp}")
    private String appName; // From application.properties or default to "DefaultApp"
}
```

In `application.properties`:

```properties
app.name=MyApp
```

---

#### 11\. Spring Boot’s `WebClient` vs. `RestTemplate`

**RestTemplate**:

- Older, synchronous HTTP client.
- Simple but blocking; less suited for reactive apps.

```java
RestTemplate rest = new RestTemplate();
String result = rest.getForObject("https://api.example.com", String.class);
```

**WebClient**:

- Modern, non-blocking, reactive client (part of Spring WebFlux).
- Better for high-concurrency apps.

```java
WebClient client = WebClient.create();
String result = client.get().uri("https://api.example.com").retrieve().bodyToMono(String.class).block();
```

> Use WebClient for reactive or performance-critical apps; RestTemplate for simpler cases.

---

#### 12\. How Spring Manages Circular Dependencies

Spring resolves circular dependencies (e.g., Bean A needs Bean B, and B needs A) during bean creation:

- Uses setter injection or constructor injection with proxies.
- Creates a proxy for one bean, allowing the other to reference it before full initialization.

Example:

```java
@Component
public class A {
    @Autowired
    private B b;
}

@Component
public class B {
    @Autowired
    private A a;
}
```

Avoid tight coupling where possible; Spring handles it but it’s a design smell.

---

#### 13\. Role of `@Primary`, `@Qualifier`, `@Profile` in Bean Selection

- `@Primary`: Marks a bean as the default choice when multiple beans of the same type exist.
- `@Qualifier`: Specifies which bean to inject by name when multiple exist.
- `@Profile`: Activates a bean only for a specific profile (e.g., “dev”).

Example:

```java
@Bean @Primary
public DataSource primaryDs() { return new HikariDataSource(); }

@Bean @Qualifier("secondary")
public DataSource secondaryDs() { return new HikariDataSource(); }

@Bean @Profile("dev")
public String devBean() { return "Dev"; }
```

---

#### 14\. Difference Between `@Bean` and `@Component`

- `@Bean`: Used in `@Configuration` classes to manually define a bean; gives full control over creation.
- `@Component`: Automatically detected via component scanning; simpler for standard classes.

Example:

```java
@Configuration
public class Config {
    @Bean
    public MyBean myBean() { return new MyBean(); }
}

@Component
public class AutoBean {}
```

---

#### 15\. Circuit Breaker and Implementation in Spring Boot

A **Circuit Breaker** prevents cascading failures in distributed systems by stopping calls to a failing service.  
Implement it with **Resilience4j**:

1.  Add `spring-boot-starter-resilience4j`.

Example:

```java
@Service
public class MyService {
    @CircuitBreaker(name = "myService", fallbackMethod = "fallback")
    public String callApi() {
        // API call that might fail
    }

    public String fallback(Throwable t) {
        return "Fallback response";
    }
}
```

Configuration:

```properties
resilience4j.circuitbreaker.instances.myService.failure-rate-threshold=50
```

---

#### 16\. Secure Spring Boot REST APIs Using OAuth2 with Google

**Steps**:

1.  Add `spring-boot-starter-oauth2-client`.
2.  Configure in `application.properties`:

```properties
spring.security.oauth2.client.registration.google.client-id=YOUR_CLIENT_ID
spring.security.oauth2.client.registration.google.client-secret=YOUR_SECRET
spring.security.oauth2.client.registration.google.scope=openid,email,profile
```

Secure endpoints:

```java
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/api/**").authenticated()
            .and().oauth2Login();
    }
}
```

Access token via `OAuth2AuthenticationToken` in controllers.

---

#### 17\. Purpose of `@DataJpaTest` in Spring Boot

`@DataJpaTest` is for testing JPA repositories:

- Loads only JPA-related beans (not the full app context).
- Configures an in-memory database (e.g., H2).

Example:

```java
@DataJpaTest
class UserRepositoryTest {
    @Autowired
    private UserRepository repo;

    @Test
    void testFindById() {
        assertNotNull(repo.findById(1L));
    }
}
```

---

#### 18\. What are `@ConfigurationProperties` in Spring Boot

`@ConfigurationProperties` binds external properties to a Java object.

Example:

```java
@ConfigurationProperties(prefix = "app")
public class AppConfig {
    private String name;
    // Getters and setters
}
```

In `application.properties`:

```properties
app.name=MyApp
```

Enable with `@EnableConfigurationProperties(AppConfig.class)`.

---

#### 19\. How Spring Boot Handles Caching and Caching Annotations

Spring Boot supports caching with `@EnableCaching` and annotations:

- `@Cacheable`: Caches method results.
- `@CachePut`: Updates cache.
- `@CacheEvict`: Removes cache entries.

Example:

```java
@Service
@Cacheable("users")
public User getUser(int id) {
    return userRepository.findById(id);
}
```

Add `spring-boot-starter-cache` and a cache provider (e.g., Ehcache).

---

#### 20\. Different Scopes of Spring Beans

Spring beans have these scopes:

- `singleton`: One instance per context (default).
- `prototype`: New instance per request.
- `request`: One per HTTP request (web only).
- `session`: One per HTTP session (web only).
- `application`: One per `ServletContext` (web only).

Example:

```java
@Bean @Scope("prototype")
public MyBean myBean() { return new MyBean(); }
```

---

### 🧠 Well-Explained Answers for 3–4 Years of Experience

For developers with 3-4 years of experience, the focus shifts toward advanced configuration, introspection, and a deeper understanding of Spring Boot’s internals. These answers provide detailed explanations, practical examples, and insights into real-world usage, tailored to this experience level.

---

#### 1\. What is Spring Boot Actuator?

Spring Boot Actuator is a production-ready feature that provides endpoints to monitor and manage your application. It exposes information like:

- Health status (`/actuator/health`).
- Application metrics (`/actuator/metrics`).
- Environment details (`/actuator/env`).
- Bean info, logging levels, and more.

It’s invaluable for debugging, monitoring, and integrating with tools like **Prometheus** or **Grafana**. Actuator is part of Spring Boot’s “production-ready” philosophy, giving you visibility into your app’s runtime behavior.

---

#### 2\. How to Enable Actuator in the Spring Boot Application?

To enable Actuator:

#### Add the dependency in `pom.xml` (Maven):

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

#### Configure exposed endpoints in `application.properties`:

```properties
management.endpoints.web.exposure.include=health,metrics,info
management.endpoint.health.show-details=always
```

Start your app, and access endpoints like `http://localhost:8080/actuator/health`.  
By default, only `/health` and `/info` are exposed; customize exposure as needed for security.

---

#### 3\. What is the Purpose of Using `@ComponentScan` in Class Files?

`@ComponentScan` tells Spring to scan specific packages for classes annotated with `@Component`, `@Service`, `@Repository`, `@Controller`, etc., and register them as beans.

It’s useful when:

- Your beans are outside the main application package.
- You need to customize the scanning scope.

#### Example:

```java
@SpringBootApplication
@ComponentScan(basePackages = {"com.myapp.services", "com.myapp.controllers"})
public class MyApp {
    public static void main(String[] args) {
        SpringApplication.run(MyApp.class, args);
    }
}
```

Without it, Spring Boot scans only the package of the `@SpringBootApplication` class and its sub-packages.

---

#### 4\. What are the `@RequestMapping` and `@RestController` Annotations Used For?

#### `@RequestMapping`:

Maps HTTP requests to specific methods or classes. It supports all HTTP methods (GET, POST, etc.) and can specify paths, headers, or parameters.

##### Example:

```java
@RequestMapping(value = "/hello", method = RequestMethod.GET)
public String sayHello() {
    return "Hello!";
}
```

#### `@RestController`:

A specialized `@Controller` that marks a class as a RESTful controller, automatically serializing return values (e.g., to JSON) using `@ResponseBody`.

##### Example:

```java
@RestController
public class MyController {
    @RequestMapping("/greet")
    public String greet() {
        return "Hi!";
    }
}
```

Together, they define REST API endpoints.

---

#### 5\. How to Get the List of All the Beans in Your Spring Boot Application?

You can introspect the Spring context to list all beans:

#### Inject `ApplicationContext` and use `getBeanDefinitionNames()`:

```java
@SpringBootApplication
public class MyApp implements CommandLineRunner {
    @Autowired
    private ApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(MyApp.class, args);
    }

    @Override
    public void run(String... args) {
        String[] beanNames = context.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
    }
}
```

Alternatively, use Actuator’s `/actuator/beans` endpoint (enable with `management.endpoints.web.exposure.include=beans`).  
This is useful for debugging or understanding your app’s structure.

---

#### 6\. Can We Check the Environment Properties in Your Spring Boot Application? Explain How.

Yes, you can access environment properties via:

#### Injecting `Environment`:

```java
@Autowired
private Environment env;

public void printProperties() {
    System.out.println(env.getProperty("server.port"));
    // Access specific property
}
```

#### Using Actuator:

Enable `/actuator/env` to see all properties:

```properties
management.endpoints.web.exposure.include=env
```

#### Command Line:

Use `ConfigurableEnvironment` in `ApplicationContext`:

```java
@Autowired
private ConfigurableApplicationContext context;

public void showEnv() {
    ConfigurableEnvironment env = context.getEnvironment();
    System.out.println(env.getProperty("spring.datasource.url"));
}
```

This helps verify runtime configuration (e.g., from `application.properties` or system variables).

---

#### 7\. How to Enable Debugging Logs in the Spring Boot Application?

Spring Boot uses SLF4J with Logback by default. To enable debug logs:

#### In `application.properties`:

```properties
logging.level.root=DEBUG             # All logs
logging.level.org.springframework=DEBUG  # Spring-specific logs
```

#### Programmatically:

```java
import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;

@PostConstruct
public void init() {
    Logger root = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
    root.setLevel(Level.DEBUG);
}
```

#### Via Actuator:

Adjust log levels at runtime with `/actuator/loggers` (enable it first).  
Debug logs are verbose, so use them selectively for troubleshooting.

---

#### 8\. What is Dependency Injection and Its Types?

**Dependency Injection (DI)** is a design pattern where dependencies are provided to a class instead of the class creating them. Spring implements DI via its **IoC container**.

#### Types:

**Constructor Injection**: Dependencies passed via constructor.

```java
@Component
public class MyService {
    private final MyRepo repo;

    @Autowired
    public MyService(MyRepo repo) {
        this.repo = repo;
    }
}
```

**Setter Injection**: Dependencies set via setters.

```java
@Component
public class MyService {
    private MyRepo repo;

    @Autowired
    public void setRepo(MyRepo repo) {
        this.repo = repo;
    }
}
```

**Field Injection**: Dependencies injected directly into fields (less recommended).

```java
@Component
public class MyService {
    @Autowired
    private MyRepo repo;
}
```

> Constructor injection is preferred for **immutability** and **testability**.

---

#### 9\. What is an IoC Container?

The **Inversion of Control (IoC) Container** is Spring’s core mechanism for managing beans. It:

- Creates, configures, and wires objects (beans) based on annotations or configuration.
- Inverts control from the application code to the framework (you declare dependencies, Spring provides them).

#### Key components:

- `ApplicationContext`: The main IoC container interface.
- `BeanFactory`: A simpler predecessor.

##### Example:

```java
ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
MyService service = context.getBean(MyService.class);
```

It handles bean lifecycle, DI, and scope management.

---

#### 10\. What is the Difference Between Constructor and Setter Injection?

**Constructor Injection**:

- Dependencies are passed via the constructor.
- Ensures immutability (fields can be `final`).
- Better for mandatory dependencies.

##### Example:

```java
@Component
public class MyService {
    private final MyRepo repo;

    @Autowired
    public MyService(MyRepo repo) {
        this.repo = repo;
    }
}
```

**Setter Injection**:

- Dependencies are set via setter methods.
- Allows flexibility (dependencies can change at runtime).
- Better for optional dependencies.

##### Example:

```java
@Component
public class MyService {
    private MyRepo repo;

    @Autowired
    public void setRepo(MyRepo repo) {
        this.repo = repo;
    }
}
```

> Constructor is favored for **cleaner design**; setter is useful for **optional** or **circular** dependencies.

---

### 🧠 Well-Explained Answers for 4+ Years of Experience

#### 1\. Optimizing Spring Boot Startup Time in Production

Spring Boot’s startup time can be a bottleneck in production, especially for microservices. Optimization strategies include:

- **Reduce Component Scanning**: Limit `@ComponentScan` to specific packages instead of scanning everything.

  ```java
  @SpringBootApplication
  @ComponentScan(basePackages = "com.myapp.core")
  public class MyApp {}
  ```

- **Lazy Initialization**: Enable lazy bean loading with `spring.main.lazy-initialization=true` in `application.properties`. Be cautious of runtime delays for first requests.
- **AOT Compilation**: Use Spring Boot 3’s Ahead-of-Time (AOT) compilation with GraalVM to create native images, reducing startup time significantly.
- **Minimize Dependencies**: Avoid unnecessary starters or libraries; use tools like `mvn dependency:tree` to audit.
- **Profile-Specific Beans**: Use `@Profile` to load only necessary beans per environment.
- **Custom Context**: Pre-configure `ApplicationContext` with only required beans for specific use cases. In a microservices setup, shaving seconds off startup can improve deployment and scaling efficiency.

---

#### 2\. Spring Boot’s @ConfigurationProperties with Complex Objects

`@ConfigurationProperties` binds nested or complex properties to POJOs. Example:

```java
@ConfigurationProperties(prefix = "app.database")
public class DatabaseConfig {
    private String url;
    private Credentials credentials;

    // Getters, setters
    public static class Credentials {
        private String username;
        private String password;
        // Getters, setters
    }
}
```

In `application.yml`:

```yaml
app:
  database:
    url: jdbc:mysql://localhost:3306/db
    credentials:
      username: admin
      password: secret
```

Enable with:

```java
@Configuration
@EnableConfigurationProperties(DatabaseConfig.class)
public class AppConfig {}
```

- **Validation**: Add `@Validated` and JSR-303 annotations (e.g., `@NotNull`).
- **Type Safety**: Use `List<>` or `Map<>` for collections.
- **Best Practice**: Keep objects immutable with constructors and use Lombok (`@Data`).

---

#### 3\. Distributed Tracing Challenges and Implementation in Microservices

**Challenges**:

- Tracking requests across services.
- Latency attribution.
- Correlation ID propagation.

**Implementation**: Use Spring Cloud Sleuth and Zipkin:

Add dependencies:

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-sleuth</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-zipkin</artifactId>
</dependency>
```

Configure Zipkin server (e.g., `spring.zipkin.base-url=http://localhost:9411`).

- Sleuth auto-adds trace and span IDs to logs and HTTP headers.
- View traces in Zipkin UI.

**Considerations**:

- Sampling rate (`spring.sleuth.sampler.probability=1.0` for full tracing).
- Integrate with logging (`%X{traceId}` in log patterns).
- Use OpenTelemetry for broader compatibility.

---

#### 4\. Implementing Robust Custom Health Check with Actuator

Custom health checks extend Actuator’s `/actuator/health`:

```java
@Component
public class DatabaseHealthIndicator implements HealthIndicator {
    @Autowired
    private DataSource dataSource;

    @Override
    public Health health() {
        try (Connection conn = dataSource.getConnection()) {
            return Health.up().withDetail("database", "reachable").build();
        } catch (SQLException e) {
            return Health.down().withDetail("error", e.getMessage()).build();
        }
    }
}
```

- **Expose**: Enable via `management.endpoints.web.exposure.include=health`.
- **Details**: Add `management.endpoint.health.show-details=always`.
- **Aggregation**: Combine multiple indicators for a composite health status. This ensures production readiness by monitoring critical dependencies.

---

#### 5\. Handling Service Discovery in Microservices with Eureka

**Eureka** enables dynamic service registration and discovery.

**Add Eureka Server**:

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
</dependency>
```

```java
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer {}
```

**Configure Client**:

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
```

```properties
eureka.client.service-url.defaultZone=http://localhost:8761/eureka
spring.application.name=my-service
```

Use `DiscoveryClient` or `@LoadBalanced RestTemplate` to call services.  
**Benefits**: Auto-scaling, fault tolerance, and load balancing.

---

#### 6\. Spring Boot’s @Retryable Annotation for Microservices Reliability

`@Retryable` retries failed operations:

```java
@Service
public class MyService {
    @Retryable(value = {HttpServerErrorException.class}, maxAttempts = 3, backoff = @Backoff(delay = 1000))
    public String callExternalApi() {
        // API call that might fail
        return restTemplate.getForObject("http://external-api", String.class);
    }

    @Recover
    public String recover(HttpServerErrorException e) {
        return "Fallback response";
    }
}
```

- **Enable** with `@EnableRetry`.
- **Configure** retries, backoff, and exceptions.
- Use `@Recover` for fallback logic. Ideal for transient failures in microservices (e.g., network issues).

---

#### 7\. Implementing Custom Security Policies with Spring Security

Custom policies with Spring Security:

```java
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/admin/**").hasRole("ADMIN")
            .antMatchers("/user/**").hasAnyRole("USER", "ADMIN")
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .and()
            .exceptionHandling().accessDeniedHandler((req, res, ex) -> res.sendError(HttpStatus.FORBIDDEN.value()));
    }

    @Bean
    public UserDetailsService userDetailsService() {
        // Custom user lookup logic
        return username -> new User(username, "{noop}password", AuthorityUtils.createAuthorityList("ROLE_USER"));
    }
}
```

- **Customization**: Add custom `AuthenticationProvider` or `UserDetailsService`.
- **Filters**: Inject custom filters for advanced logic (e.g., IP whitelisting).

---

#### 8\. Event-Driven Microservices with Kafka or RabbitMQ

**Using Kafka with Spring Boot**:

**Add dependency**:

```xml
<dependency>
    <groupId>org.springframework.kafka</groupId>
    <artifactId>spring-kafka</artifactId>
</dependency>
```

**Configure**:

```properties
spring.kafka.bootstrap-servers=localhost:9092
spring.kafka.consumer.group-id=my-group
```

**Producer/Consumer**:

```java
@Service
public class KafkaService {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send(String message) {
        kafkaTemplate.send("my-topic", message);
    }

    @KafkaListener(topics = "my-topic")
    public void listen(String message) {
        System.out.println("Received: " + message);
    }
}
```

**RabbitMQ**: Similar setup with `spring-rabbit` and `@RabbitListener`.  
**Use Case**: Decouple services, handle high-throughput events.

---

#### 9\. Handling Versioning in Spring Boot APIs

**Versioning strategies**:

- **URI Versioning**:

  ```java
  @RestController
  @RequestMapping("/api/v1")
  public class ApiV1Controller {
      @GetMapping("/data")
      public String getData() { return "Version 1"; }
  }
  ```

- **Header Versioning**:

  ```java
  @GetMapping(value = "/data", headers = "X-API-Version=1")
  public String getV1Data() { return "Version 1"; }
  ```

- **Media Type Versioning**:

  ```java
  @GetMapping(value = "/data", produces = "application/vnd.myapp.v1+json")
  public String getV1() { return "Version 1"; }
  ```

**Best Practice**: Use URI versioning for simplicity; document with OpenAPI/Swagger.

---

#### 10\. Implementing Multi-Tenancy in Spring Boot Applications

**Multi-tenancy** separates data by tenant.

- **Database Per Tenant**:  
  Use `AbstractRoutingDataSource` to switch datasources:

  ```java
  public class TenantRoutingDataSource extends AbstractRoutingDataSource {
      @Override
      protected Object determineCurrentLookupKey() {
          return TenantContext.getTenantId(); // ThreadLocal tenant ID
      }
  }
  ```

- **Schema Per Tenant**:  
  Set schema dynamically in JPA:

  ```properties
  spring.jpa.properties.hibernate.default_schema={tenantId}
  ```

**Configure tenant resolution** (e.g., via header):

```java
@Component
public class TenantFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        String tenantId = ((HttpServletRequest) req).getHeader("X-Tenant-ID");
        TenantContext.setTenantId(tenantId);
        chain.doFilter(req, res);
    }
}
```

**Security**: Enforce tenant isolation in business logic.

---

#### 11\. Creating a Custom Spring Boot Starter Module

**Steps:**

**Create a library project:**

```xml
<groupId>com.myapp</groupId>
<artifactId>my-starter</artifactId>
```

**Define auto-configuration:**

```java
@Configuration
@ConditionalOnClass(MyService.class)
public class MyAutoConfiguration {
    @Bean
    public MyService myService() {
        return new MyService();
    }
}
```

**Register in META-INF/spring.factories:**

```
org.springframework.boot.autoconfigure.EnableAutoConfiguration=com.myapp.MyAutoConfiguration
```

**Publish to Maven; use in another project:**

```xml
<dependency>
    <groupId>com.myapp</groupId>
    <artifactId>my-starter</artifactId>
</dependency>
```

**Benefit:** Reusable, modular functionality.

---

#### 12\. Managing External Configurations Across Environments

**Use Spring Cloud Config:**

**Setup Config Server:**

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-config-server</artifactId>
</dependency>
```

```java
@EnableConfigServer
@SpringBootApplication
public class ConfigServer {}
```

**Store configs in Git:**  
`application-dev.yml`, `application-prod.yml`

**Client setup:**

```properties
spring.cloud.config.uri=http://localhost:8888
spring.profiles.active=dev
```

**Alternatives:** Vault, Kubernetes ConfigMaps.  
**Security:** Encrypt sensitive properties with `{cipher}`.

---

#### 13\. Strategies for Debugging Spring Boot in Production

- **Actuator:** Use `/actuator/loggers`, `/actuator/heapdump`, `/actuator/threaddump`.
- **Remote Debugging:** Enable JVM debug port `(-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005)` and connect via IDE.
- **Logging:** Increase verbosity dynamically with `/actuator/loggers`.
- **Distributed Tracing:** Use Sleuth/Zipkin to trace requests.
- **Metrics:** Monitor with Prometheus and Grafana via Actuator.
- **Best Practice:** Minimize downtime; use rolling deployments.

---

#### 14\. Implementing Spring Boot Security with OAuth 2.0 for Microservices

**Steps:**

**Add dependency:**

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-oauth2-resource-server</artifactId>
</dependency>
```

**Configure:**

```properties
spring.security.oauth2.resourceserver.jwt.issuer-uri=https://auth-server/.well-known/openid-configuration
```

**Secure endpoints:**

```java
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .anyRequest().authenticated()
            .and()
            .oauth2ResourceServer().jwt();
    }
}
```

**Token Validation:** Use JWKs endpoint from the issuer.  
**Scopes:** Restrict with `.access("#oauth2.hasScope('read')")`.

---

#### 15\. Common Performance Bottlenecks and Resolutions

- **Database Queries:** Optimize with indexes, caching (`@Cacheable`), or batching.
- **Bean Creation:** Use lazy initialization or reduce scope.
- **Thread Pool Exhaustion:** Tune `@Async` executor (`ThreadPoolTaskExecutor`).
- **Memory Leaks:** Profile with Actuator or VisualVM; avoid large object retention.
- **I/O Blocking:** Switch to WebClient for non-blocking calls.
- **Resolution:** Use metrics (`/actuator/metrics`) to identify and fix.

---

#### 16\. Handling Asynchronous Processing with @Async

**Enable with `@EnableAsync`:**

```java
@Service
public class MyService {
    @Async
    public CompletableFuture<String> process() {
        Thread.sleep(1000); // Simulate work
        return CompletableFuture.completedFuture("Done");
    }
}
```

**Custom Executor:**

```java
@Bean
public Executor taskExecutor() {
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(10);
    executor.setMaxPoolSize(20);
    return executor;
}
```

**Error Handling:** Use `AsyncUncaughtExceptionHandler`.

---

#### 17\. Implementing Caching with @Cacheable

**Enable with `@EnableCaching`:**

```java
@Service
public class MyService {
    @Cacheable(value = "users", key = "#id")
    public User getUser(int id) {
        return userRepository.findById(id); // Expensive call
    }

    @CacheEvict(value = "users", key = "#id")
    public void deleteUser(int id) {}
}
```

**Add** `spring-boot-starter-cache` **and a provider (e.g., Caffeine, Ehcache).**  
**Customization:** Configure cache manager for eviction policies.

---

#### 18\. Configuring and Managing Spring Boot Logging in Production

**Use Logback:**

```properties
logging.level.root=INFO
logging.level.com.myapp=DEBUG
logging.file.name=/var/log/myapp.log
logging.pattern.file=%d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n
```

- **Dynamic Changes:** Adjust via Actuator’s `/actuator/loggers`.
- **Centralized Logging:** Forward to ELK or Loki with `spring-boot-starter-logging`.

---

#### 19\. Implementing API Gateway with Spring Cloud Gateway

**Add dependency:**

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-gateway</artifactId>
</dependency>
```

**Configure routes:**

```yaml
spring:
  cloud:
    gateway:
      routes:
        - id: user-service
          uri: lb://user-service
          predicates:
            - Path=/users/**
```

- **Load Balancing:** Integrate with Eureka (`lb://`).
- **Filters:** Add rate-limiting, retries, or security.

---

#### 20\. Handling Transactions with @Transactional

```java
@Service
public class MyService {
    @Transactional(rollbackOn = Exception.class)
    public void saveData() {
        // Multiple DB operations
    }
}
```

- **Isolation:** Use `isolation = Isolation.SERIALIZABLE` for strict control.
- **Propagation:** Default is `REQUIRED`; adjust as needed (e.g., `NESTED`).

---

#### 21\. Differences Between @RequestMapping, @GetMapping, @PostMapping, etc.

- `@RequestMapping`: Generic, supports all HTTP methods.
- `@GetMapping`: Shortcut for GET requests.
- `@PostMapping`: Shortcut for POST requests. Example:

```java
@RequestMapping(value = "/data", method = RequestMethod.GET)
public String getData() {}

@GetMapping("/data")
public String getDataShorter() {}
```

---

#### 22\. Implementing File Upload and Download Functionality

**Upload:**

```java
@RestController
public class FileController {
    @PostMapping("/upload")
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file) {
        Files.write(Paths.get("uploads/" + file.getOriginalFilename()), file.getBytes());
        return ResponseEntity.ok("Uploaded");
    }
}
```

**Download:**

```java
@GetMapping("/download/{filename}")
public ResponseEntity<Resource> download(@PathVariable String filename) {
    File file = new File("uploads/" + filename);
    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
        .body(new FileSystemResource(file));
}
```

---

#### 23\. Using Spring Boot Profiles for Different Environments

```properties
spring.profiles.active=prod
```

**application-dev.properties:**

```properties
server.port=8081
```

**Activate programmatically:**

```java
SpringApplication app = new SpringApplication(MyApp.class);
app.setAdditionalProfiles("dev");
app.run(args);
```

---

#### 24\. Implementing JWT-Based Authentication

- Add `jjwt` dependency.
- Configure filter:

```java
public class JwtFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) {
        String token = req.getHeader("Authorization");
        // Validate JWT
        chain.doFilter(req, res);
    }
}
```

- Secure endpoints with Spring Security.

---

#### 25\. Configuring Spring Boot with Docker for Containerization

**Dockerfile:**

```dockerfile
FROM openjdk:17
COPY target/myapp.jar /app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
```

**Build and run:**

```bash
docker build -t myapp .
docker run -p 8080:8080 myapp
```

---

#### 26\. Implementing Rate-Limiting in Spring Boot

**Use Resilience4j:**

```java
@Service
public class MyService {
    @RateLimiter(name = "myRateLimiter")
    public String call() {
        return "Success";
    }
}
```

```properties
resilience4j.ratelimiter.instances.myRateLimiter.limit-for-period=10
resilience4j.ratelimiter.limit-refresh-period=1s
```

---

#### 27\. Implementing Custom Exception Handler with @ControllerAdvice

```java
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgument(Exception ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
```

---

#### 28\. Using @Scheduled Annotation for Background Tasks

```java
@Service
public class TaskService {
    @Scheduled(fixedRate = 60000) // Every minute
    public void runTask() {
        System.out.println("Task executed at " + new Date());
    }
}
```

- Enable with `@EnableScheduling`.

---

#### 29\. Implementing Spring Boot with NoSQL Databases like MongoDB, Cassandra

**For MongoDB:**

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-mongodb</artifactId>
</dependency>
```

```java
@Document
public class User {
    @Id
    private String id;
    private String name;
}
```

```properties
spring.data.mongodb.uri=mongodb://localhost:27017/mydb
```

---

#### 30\. Configuring Spring Boot with Message Queues like RabbitMQ, Kafka

**For RabbitMQ:**

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-amqp</artifactId>
</dependency>
```

```java
@Service
public class RabbitService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(String message) {
        rabbitTemplate.convertAndSend("my-queue", message);
    }

    @RabbitListener(queues = "my-queue")
    public void receive(String message) {
        System.out.println("Received: " + message);
    }
}
```

```properties
spring.rabbitmq.host=localhost
spring.rabbitmq.port=5672
```

---

## Additional Questions & Answers

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

---

### 1. Explain the Concept of Auto-Configuration in Spring Boot

Spring Boot's auto-configuration feature attempts to automatically configure your Spring application based on the jar dependencies you have added. For example, if you have `spring-boot-starter-web` in your classpath, Spring Boot will automatically configure web-related components such as a dispatcher servlet, a default error page, etc. **How it works:**

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

- **/actuator/health:** Shows application health information.

- **/actuator/info:** Displays arbitrary application info.

- **/actuator/metrics:** Shows various metrics of the application.

- **/actuator/env:** Shows environment properties.

- **/actuator/loggers:** Exposes loggers and their levels.

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
