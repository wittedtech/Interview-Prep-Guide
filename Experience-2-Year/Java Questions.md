# **Interview: Question & Answers - 2 Years (Exp.)**

## **Java - Spring Boot Developer Interview Questions:**

    1. **What is Stringpool?**

    - The String pool is a special area in the Java memory heap where String literals are stored. When you create a String object using double quotes, Java checks the pool to see if an identical String already exists. If it does, it returns a reference to that instance, otherwise, it creates a new String object in the pool.

    1. **What is Bean Factory?**

    - Bean Factory is the original container in Spring that provides support for Dependency Injection (DI). It's responsible for creating, managing, and wiring beans together based on the configuration metadata provided.

    1. **What is a bucket?**

    - In the context of data structures, a bucket refers to a unit of storage used to hold items. For example, in HashMap, a bucket holds key-value pairs.

    1. **Difference between HashMap and HashTable?**

    - HashMap is not synchronized and allows null values, while HashTable is synchronized and does not allow null keys or values. HashMap is preferred for non-thread-safe applications, while HashTable is thread-safe but slower due to synchronization.

    1. **Difference between ConcurrentHashMap and HashMap?**

    - ConcurrentHashMap is a thread-safe version of HashMap, optimized for concurrent operations. It allows multiple threads to read and write without causing a ConcurrentModificationException.

    1. **How to annotate a method as asynchronous?**

    - In Spring, you can use the `@Async` annotation on a method to mark it as asynchronous. This allows the method to be executed asynchronously in a separate thread pool.

    1. **How to create an asynchronous method?**

    - An asynchronous method can be created by annotating it with `@Async` and configuring a thread pool in the Spring configuration.

    1. **Filter ArrayList using Java 8?**

    - You can filter an ArrayList using Java 8 Streams and Lambda expressions. For example:
        ```java
        List<String> filteredList = list.stream()
                                        .filter(s -> s.startsWith("prefix"))
                                        .collect(Collectors.toList());
        ```

    1. **Difference between RestController and Controller?**

    - `@RestController` is a specialized version of `@Controller` that includes the `@ResponseBody` annotation by default on all mapping methods. It's commonly used in RESTful web services to return JSON/XML responses directly.

    1.  **How to consume any third-party REST API in our application?**

        - Third-party REST APIs can be consumed using libraries like RestTemplate or WebClient in Spring. You make HTTP requests to the API endpoints and process the responses accordingly.

    2.  **Swap values of two variables without using a third variable?**

        - You can swap values without a third variable using arithmetic operations or bitwise XOR. For example:

        ```java
        a = a + b;
        b = a - b;
        a = a - b;
        ```

    3.  **Reverse a string without using a third variable?**

        - You can reverse a string without using a third variable by swapping characters directly in the char array. For example:

        ```java
        char[] chars = str.toCharArray();
        for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
            chars[i] = (char) (chars[i] ^ chars[j]);
            chars[j] = (char) (chars[i] ^ chars[j]);
            chars[i] = (char) (chars[i] ^ chars[j]);
        }
        String reversed = new String(chars);
        ```

    4.  **Caching techniques?**

        - Caching techniques involve storing frequently accessed data in memory to improve performance. Common caching techniques include in-memory caching using libraries like Ehcache or Guava Cache, database query caching, and HTTP caching.

    5.  **Messaging techniques: Kafka?**

        - Kafka is a distributed streaming platform that is used for building real-time data pipelines and streaming applications. It uses a publish-subscribe messaging model where producers publish messages to topics, and consumers subscribe to those topics to receive messages.

    6.  **Functional interface in Java?**

        - A functional interface in Java is an interface that contains only one abstract method. It can have multiple default or static methods, but it must have only one abstract method. Functional interfaces are used to enable functional programming concepts like lambda expressions and method references.

    7.  **Java 8 Concepts?**

        - Java 8 introduced several important features including lambda expressions, the Stream API, default methods in interfaces, the Optional class, and the java.time package for date and time manipulation.

    8.  **Markable Interface?**

        - A markable interface in Java is an interface that doesn't declare any methods. It is used to signify something about the objects that implement it. Examples include Serializable and Cloneable interfaces.

    9.  **Default Interface and its types?**

        - Default methods were introduced in Java 8 to allow interfaces to have concrete methods. These methods have a default implementation in the interface itself, which can be overridden by implementing classes. There are two types of default methods: Instance methods and Static methods.

    10. **Monolithic Architecture Explain?**

        - Monolithic architecture is a traditional software architecture where all components of an application are interconnected and deployed as a single unit. In a monolithic architecture, the entire application is built, deployed, and scaled together. It can be easier to develop and test initially but can become complex and difficult to maintain as the application grows.

    11. **What is RESTful and RESTless APIs?**

        - RESTful APIs (Representational State Transfer) adhere to the principles of REST architecture, using standard HTTP methods (GET, POST, PUT, DELETE) and following resource-based URLs. They are stateless and utilize hypermedia links for navigation. RESTless APIs do not strictly adhere to REST principles and may use other communication protocols or lack resource-based URLs.

    12. **What is flatMap?**

        - In Java 8 Streams, flatMap is a method that applies a function to each element in the stream and then flattens the results into a single stream. It's commonly used when dealing with nested collections or when you want to transform each element into multiple elements.

    13. **Difference between StringBuffer and StringBuilder?**

        - StringBuffer is synchronized and thread-safe, making it suitable for use in multi-threaded environments. StringBuilder is not synchronized, which makes it faster but not suitable for concurrent operations.

    14. **Explain microservices architecture?**

        - Microservices architecture is an architectural style where an application is composed of small, independent services that communicate over well-defined APIs. Each service is responsible for a specific business function and can be developed, deployed, and scaled independently.

    15. **Different types of encryption and decryption used in Spring Boot application?**

        - Spring Boot applications commonly use encryption and decryption techniques such as symmetric key encryption (AES), asymmetric key encryption (RSA), and hashing algorithms (SHA-256, MD5). These techniques are used to secure sensitive data such as passwords, API keys, and personal information.

    16. **Hibernate architecture and JPA. Complete explanation and architecture?**

        - Hibernate is an Object-Relational Mapping (ORM) framework for Java that provides a mapping between Java objects and database tables. It abstracts away the complexities of JDBC and SQL queries, allowing developers to work with objects instead of database tables. Java Persistence API (JPA) is a specification for managing relational data in Java applications. It provides a set of interfaces and annotations for ORM frameworks like Hibernate to implement.

    17. **Basics of JUnit. Different Annotations and their working in JUnit?**

        - JUnit is a unit testing framework for Java. It provides annotations like `@Test` to mark test methods, `@Before` and `@After` to run setup and teardown methods before and after each test, `@BeforeClass` and `@AfterClass` to run setup and teardown methods once before and after all tests in a class, and `@Ignore` to ignore tests temporarily.

    18. **@AfterTest and @BeforeTest Annotation?**

        - There's no `@AfterTest` and `@BeforeTest` annotation in JUnit. It might be a typo. The correct annotations are `@After` and `@Before`.

    19. **@Configuration annotation?**

        - `@Configuration` is used in Spring to indicate that a class declares one or more `@Bean` methods and may be processed by the Spring container to generate bean definitions and service requests for those beans.

    20. **How do REST APIs Communicate?**

        - REST APIs communicate over the HTTP protocol using standard HTTP methods like GET, POST, PUT, DELETE. Clients make requests to specific endpoints (URLs) with appropriate HTTP methods, and servers respond with data formatted in JSON, XML, or other formats.

    21. **Scenario-Based Question:**
        Suppose I have millions of data in my database and I want to interact with that data in the database as well as display that data in the frontend. How to achieve this using microservices architecture and how Rest Api will help in this scenario. Detailed Structure.

        - In this scenario, a microservices architecture can be employed to handle the large amount of data efficiently. Here's a high-level structure:
        - **Microservices Setup:**
            - Divide the application into smaller services based on business functionalities, such as user service, data service, and frontend service.
            - Each microservice is responsible for a specific task and has its own database.
            - Use asynchronous communication between microservices to prevent bottlenecks.
        - **Data Service:**
            - This microservice handles interactions with the database where millions of data are stored.
            - It exposes RESTful APIs to perform CRUD operations on the data.
            - Utilize database sharding and indexing for efficient data retrieval and manipulation.
        - **Frontend Service:**
            - This microservice handles the frontend presentation layer and user interactions.
            - It consumes data from the data service via RESTful APIs.
            - Implements caching mechanisms to reduce the load on the data service and improve frontend performance.
        - **Communication:**
            - RESTful APIs are used for communication between microservices.
            - Each microservice communicates with others asynchronously, reducing coupling and improving scalability.
        - **Scaling:**
            - Each microservice can be scaled independently based on its workload.
            - Horizontal scaling can be achieved by deploying multiple instances of each microservice behind a load balancer.
        - **Monitoring and Management:**
            - Use tools like Spring Boot Actuator and monitoring solutions to monitor the performance and health of microservices.
            - Implement circuit breakers and retries to handle failures gracefully.

    22. **Count repeated words in a string?**

        - You can count repeated words in a string by splitting the string into words, then using a HashMap to store the count of each word. For example:

        ```java
        String[] words = str.split("\\s+");
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        ```

    23. **Concept of Autoboxing and unboxing?**

        - Autoboxing is the automatic conversion of primitive data types to their corresponding wrapper objects. Unboxing is the automatic conversion of wrapper objects to their corresponding primitive data types. This allows primitive and wrapper types to be used interchangeably in certain contexts.

    24. **What is encapsulation and how it is achieved?**

        - Encapsulation is the concept of bundling data (attributes) and methods (behavior) that operate on the data into a single unit known as a class. It helps in hiding the internal state of an object and only exposing the necessary functionality through methods. Encapsulation is achieved by declaring the instance variables of a class as private and providing public getter and setter methods to access and modify them.

    25. **Difference between abstract class and interface?**

        - An abstract class can have both abstract and concrete methods, while an interface can only have abstract methods. A class can extend only one abstract class but implement multiple interfaces. Abstract classes can have constructors, while interfaces cannot. Abstract classes can have instance variables, while interfaces cannot.

    26. **How to create multiple threads?**

        - There are two main ways to create multiple threads in Java:
        1. Extending the Thread class.
        2. Implementing the Runnable interface.

    27. **What is multithreading?**

        - Multithreading is the ability of a CPU (or a single core in a multi-core processor) to provide multiple threads of execution concurrently. It allows programs to perform multiple tasks simultaneously by running different parts of the code concurrently.

    28. **Methods used to create multiple threads?**

        - As mentioned earlier, methods to create multiple threads in Java include extending the Thread class and implementing the Runnable interface.

    29. **Functional Interface in Java 8?**

        - A functional interface in Java 8 is an interface that contains only one abstract method. It can have multiple default or static methods, but it must have only one abstract method. Functional interfaces are used to enable functional programming concepts like lambda expressions and method references.

    30. **What are the suppliers in Java 8?**

        - In Java 8, Supplier is a functional interface that represents a supplier of results. It does not take any argument but produces a result. It is typically used to generate or supply values lazily.

    31. **What is supplier, consumer, predicate, and function in Java 8?**

        - In Java 8, Supplier, Consumer, Predicate, and Function are functional interfaces representing different types of operations:
        - Supplier: Represents a supplier of results.
        - Consumer: Represents an operation that accepts a single input argument and returns no result.
        - Predicate: Represents a predicate (boolean-valued function) of one argument.
        - Function: Represents a function that accepts one argument and produces a result.

    32. **What do you mean by synchronous in Java?**

        - Synchronous in Java refers to the execution of tasks in a sequential order, where each task must wait for the previous task to complete before executing. It is the default mode of execution where tasks are executed one after another in a single thread.

    33. **What is the use of API Gateway?**

        - API Gateway is a server that acts as an entry point for client requests to access backend services. It provides functionalities such as routing, authentication, authorization, rate limiting, and monitoring. API Gateway simplifies the client-server communication by centralizing the management of APIs and providing a unified interface for clients.

    34. **Why do we use API Gateway?**

        - API Gateway is used for several reasons:
        - **Centralized Management**: It provides a single entry point for client requests, allowing for centralized management of APIs.
        - **Security**: API Gateway can handle authentication and authorization, ensuring that only authorized clients can access the backend services.
        - **Routing**: It can route requests to the appropriate backend services based on the request URL or other criteria.
        - **Rate Limiting**: API Gateway can enforce rate limits to prevent abuse or excessive usage of backend resources.
        - **Monitoring and Analytics**: It provides monitoring and analytics capabilities to track API usage, performance, and errors.
        - **Versioning**: API Gateway can manage multiple versions of APIs and route requests to the appropriate version.
        - **Load Balancing**: It can distribute incoming requests across multiple instances of backend services to ensure scalability and high availability.

    35. **What is a discovery server and why do we use that?**

        - A discovery server, often used in microservices architecture, is a component responsible for registering and discovering the locations of services in the system. It allows services to dynamically find and communicate with each other without hardcoding their locations. Discovery servers facilitate the scalability, flexibility, and resilience of microservices by enabling dynamic service registration and discovery in distributed environments.

    36. **What is a load balancer?**

        - A load balancer is a device or software component that distributes incoming network traffic across multiple servers or resources to ensure optimal utilization, reliability, and availability. It helps to prevent any single server from becoming overwhelmed by distributing the workload evenly among multiple servers, thereby improving performance and preventing server downtime.

    37. **What do you mean by horizontal and vertical scaling?**

        - Horizontal scaling, also known as scaling out, involves adding more machines or instances to distribute the load across multiple resources. Vertical scaling, also known as scaling up, involves increasing the capacity of existing machines or instances by adding more resources such as CPU, memory, or storage.

    38. **Concept of hashing and what is the internal working of HashMap?**

        - Hashing is the process of converting data (keys) into a fixed-size value or hash code. In HashMap, hash codes are used to determine the index (bucket) where key-value pairs are stored. The internal working of HashMap involves using an array of linked lists (buckets), where each bucket holds a linked list of key-value pairs. When inserting or retrieving elements, HashMap calculates the hash code of the key and uses it to determine the bucket where the key-value pair should be stored or retrieved.

    39. **What are the wrapper classes?**

        - Wrapper classes are classes in Java that represent primitive data types as objects. They provide a way to work with primitive data types in object-oriented contexts. Examples include Integer, Double, Boolean, etc.

    40. **What does Functional interface return? Does it return something or not?**

        - Functional interfaces in Java can have methods that return values or methods that return void (no value). The key requirement is that the interface must have only one abstract method (SAM - Single Abstract Method). Functional interfaces can have default or static methods as well.

    41. **What is a profiler in Spring Boot?**

        - A profiler in Spring Boot is a tool used to monitor and analyze the performance of an application. It helps developers identify performance bottlenecks, memory leaks, and inefficient code. Spring Boot provides integration with various profilers like VisualVM, YourKit, and JProfiler for performance monitoring and analysis.

    42. **What is the difference between Spring framework and Spring Boot framework?**

        - Spring framework is a comprehensive framework for building enterprise Java applications. It provides features like Dependency Injection, Aspect-Oriented Programming, and transaction management. Spring Boot, on the other hand, is an opinionated framework built on top of the Spring framework that simplifies the setup and development of Spring applications. It provides auto-configuration, embedded servers, and production-ready features out of the box.

    43. **What is the difference between Spring Boot and Spring Cloud frameworks?**

        - Spring Boot is a framework for building standalone Spring-based applications with minimal configuration, focusing on simplicity and convention over configuration. Spring Cloud, on the other hand, is a set of tools and frameworks built on top of Spring Boot for building distributed systems and microservices architectures. Spring Cloud provides features like service discovery, configuration management, circuit breakers, and distributed tracing.

    44. **How do microservices communicate with each other? Internal Working and Steps to do so?**
        - Microservices communicate with each other through lightweight protocols like HTTP/HTTPS, messaging queues (e.g., RabbitMQ, Kafka), or RPC (Remote Procedure Call) mechanisms. The steps to enable communication between microservices typically involve:
        1. Service Registration: Each microservice registers itself with a service registry or discovery server upon startup.
        2. Service Discovery: When a microservice needs to communicate with another microservice, it queries the service registry to obtain the network location (host and port) of the target service.
        3. Communication: Once the location is obtained, the microservice can communicate with the target service using the appropriate communication protocol and exchange messages or data as needed.
