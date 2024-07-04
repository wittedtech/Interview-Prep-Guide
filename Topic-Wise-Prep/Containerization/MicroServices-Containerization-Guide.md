We will create two projects:
 
1. **Docker-based Project**
 
2. **Kubernetes-based Project**

### Project Structure 

Both projects will follow a similar microservices architecture, with the following components:
 
1. **API Gateway** : Handles routing and load balancing.
 
2. **Master Service** : Central service managing business logic.
 
3. **Discovery Server Service** : Uses Eureka for service discovery.
 
4. **Configuration Service** : Manages configuration across services.
 
5. **Controller Service** : Manages all controllers and contains HTML files written in Thymeleaf.
 
6. **REST Controller Service** : Manages REST controllers, services, and repositories.
 
7. **Entity Models Package** : Contains all the entity models.
 
8. **Authentication Service** : Manages user authentication and authorization.

### Docker-based Project 

We will containerize the application using Docker. Here are the steps:
 
1. **Setting Up the Project Structure**
 
2. **Creating the Services**
 
3. **Connecting Services**
 
4. **Implementing Docker**

### Kubernetes-based Project 

We will orchestrate the application using Kubernetes. Here are the steps:
 
1. **Setting Up the Project Structure**
 
2. **Creating the Services**
 
3. **Connecting Services**
 
4. **Implementing Kubernetes**

## Docker-based Project 

### Step 1: Setting Up the Project Structure 

Create a new Maven project with the following structure:


```lua
microservices-docker/
|-- api-gateway/
|-- master-service/
|-- discovery-server/
|-- config-server/
|-- controller-service/
|-- rest-controller-service/
|-- auth-service/
|-- entity-models/
|-- docker-compose.yml
```

### Step 2: Creating the Services 

#### 1. API Gateway 

Create a Spring Boot project for the API Gateway.
**pom.xml** :

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-gateway</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
```
**application.yml** :

```yaml
server:
  port: 8080

spring:
  application:
    name: api-gateway

eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/
```
**Main Application** :

```java
@SpringBootApplication
@EnableEurekaClient
public class ApiGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }
}
```

#### 2. Master Service 

Create a Spring Boot project for the Master Service.
**pom.xml** :

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
```
**application.yml** :

```yaml
server:
  port: 8081

spring:
  application:
    name: master-service

eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/
```
**Main Application** :

```java
@SpringBootApplication
@EnableEurekaClient
public class MasterServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(MasterServiceApplication.class, args);
    }
}
```

#### 3. Discovery Server Service 

Create a Spring Boot project for the Discovery Server Service.
**pom.xml** :

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
</dependency>
```
**application.yml** :

```yaml
server:
  port: 8761

spring:
  application:
    name: discovery-server

eureka:
  client:
    register-with-eureka: false
    fetch-registry: false

eureka:
  server:
    enable-self-preservation: false
```
**Main Application** :

```java
@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(DiscoveryServerApplication.class, args);
    }
}
```

#### 4. Configuration Service 

Create a Spring Boot project for the Configuration Service.
**pom.xml** :

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-config-server</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
```
**application.yml** :

```yaml
server:
  port: 8888

spring:
  application:
    name: config-server

eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/
```
**Main Application** :

```java
@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class ConfigServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}
```

#### 5. Controller Service 

Create a Spring Boot project for the Controller Service.
**pom.xml** :

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
```
**application.yml** :

```yaml
server:
  port: 8082

spring:
  application:
    name: controller-service

eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/
```
**Main Application** :

```java
@SpringBootApplication
@EnableEurekaClient
public class ControllerServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ControllerServiceApplication.class, args);
    }
}
```

#### 6. REST Controller Service 

Create a Spring Boot project for the REST Controller Service.
**pom.xml** :

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
    <groupId>com.oracle.database.jdbc</groupId>
    <artifactId>ojdbc8</artifactId>
    <scope>runtime</scope>
</dependency>
```
**application.yml** :

```yaml
server:
  port: 8083

spring:
  application:
    name: rest-controller-service

eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/
  
spring:
  datasource:
    url: jdbc:oracle:thin:@localhost:1521:orcl
    username: your-username
    password: your-password
    driver-class-name: oracle.jdbc.OracleDriver

spring:
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    database-platform: org.hibernate.dialect.Oracle12cDialect
```
**Main Application** :

```java
@SpringBootApplication
@EnableEurekaClient
public class RestControllerServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestControllerServiceApplication.class, args);
    }
}
```

#### 7. Authentication Service 

Create a Spring Boot project for the Authentication Service.
**pom.xml** :

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt</artifactId>
    <version>0.9.1</version>
</dependency>
```
**application.yml** :

```yaml
server:
  port: 8084

spring:
  application:
    name: auth-service

eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/
```
**Main Application** :

```java
@SpringBootApplication
@EnableEurekaClient
public class AuthServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthServiceApplication.class, args);
    }
}
```

#### 8. Entity Models Package 

Create a Java project to contain all the entity models.
**pom.xml** :

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
    <groupId>com.oracle.database.jdbc</groupId>
    <artifactId>ojdbc8</artifactId>
    <scope>runtime</scope>
</dependency>
```

### Step 3: Connecting Services 
Ensure all services are connected to the Eureka Discovery Server. Update the `application.yml` for each service to include the Eureka client configuration.
### Step 4: Implementing Docker 
Create Dockerfiles for each service and a `docker-compose.yml` file to manage the multi-container application.**Dockerfile (for each service)** :

```dockerfile
# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the executable jar file to the working directory
COPY target/*.jar app.jar

# Run the jar file
ENTRYPOINT ["java","-jar","app.jar"]
```
**docker-compose.yml** :

```yaml
version: '3'
services:
  discovery-server:
    build: ./discovery-server
    ports:
      - "8761:8761"

  config-server:
    build: ./config-server
    ports:
      - "8888:8888"
    depends_on:
      - discovery-server

  api-gateway:
    build: ./api-gateway
    ports:
      - "8080:8080"
    depends_on:
      - discovery-server

  master-service:
    build: ./master-service
    ports:
      - "8081:8081"
    depends_on:
      - discovery-server

  controller-service:
    build: ./controller-service
    ports:
      - "8082:8082"
    depends_on:
      - discovery-server

  rest-controller-service:
    build: ./rest-controller-service
    ports:
      - "8083:8083"
    depends_on:
      - discovery-server
      - oracle-db

  auth-service:
    build: ./auth-service
    ports:
      - "8084:8084"
    depends_on:
      - discovery-server

  oracle-db:
    image: oracleinanutshell/oracle-xe-11g
    ports:
      - "1521:1521"
    environment:
      - ORACLE_ALLOW_REMOTE=true
```

### Running the Docker-based Project 
 
1. **Build the Docker images** :

```bash
mvn clean package
docker-compose build
```
 
2. **Start the services** :

```bash
docker-compose up
```

## Kubernetes-based Project 

### Step 1: Setting Up the Project Structure 

Create a new Maven project with the same structure as the Docker-based project.

### Step 2: Creating the Services 

Repeat the same steps as for the Docker-based project to create each service.

### Step 3: Connecting Services 
Ensure all services are connected to the Eureka Discovery Server by updating the `application.yml` for each service.
### Step 4: Implementing Kubernetes 

Create Kubernetes deployment and service YAML files for each service.
**deployment.yml (for each service)** :

```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: <service-name>
spec:
  replicas: 1
  selector:
    matchLabels:
      app: <service-name>
  template:
    metadata:
      labels:
        app: <service-name>
    spec:
      containers:
      - name: <service-name>
        image: <docker-image>:latest
        ports:
        - containerPort: <service-port>
        env:
        - name: EUREKA_SERVER
          value: "http://discovery-server:8761/eureka/"
```
**service.yml (for each service)** :

```yaml
apiVersion: v1
kind: Service
metadata:
  name: <service-name>
spec:
  ports:
  - port: <service-port>
    targetPort: <service-port>
  selector:
    app: <service-name>
```
**kubernetes.yml** :

```yaml
apiVersion: v1
kind: Namespace
metadata:
  name: microservices

---

apiVersion: apps/v1
kind: Deployment
metadata:
  name: discovery-server
  namespace: microservices
spec:
  replicas: 1
  selector:
    matchLabels:
      app: discovery-server
  template:
    metadata:
      labels:
        app: discovery-server
    spec:
      containers:
      - name: discovery-server
        image: discovery-server:latest
        ports:
        - containerPort: 8761

---

apiVersion: v1
kind: Service
metadata:
  name: discovery-server
  namespace: microservices
spec:
  ports:
  - port: 8761
    targetPort: 8761
  selector:
    app: discovery-server

# Repeat the above Deployment and Service configuration for each microservice
```

### Running the Kubernetes-based Project 
 
1. **Build Docker images** :

```bash
mvn clean package
docker build -t <service-name>:latest .
```
 
2. **Apply Kubernetes configurations** :

```bash
kubectl apply -f kubernetes.yml
```

## Conclusion 

This guide provides a step-by-step approach to creating microservices architecture using Docker and Kubernetes with Java. Each service is containerized, connected via Eureka Discovery Server, and configured using Spring Boot. The Docker-based project uses Docker Compose to manage containers, while the Kubernetes-based project uses Kubernetes for orchestration (the automated configuring, coordinating, and managing of computer systems and software).
