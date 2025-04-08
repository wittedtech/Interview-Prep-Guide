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
