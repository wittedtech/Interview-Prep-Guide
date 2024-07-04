
### Java Design Pattern Guide 

#### What is a Design Pattern? 

Design patterns are proven solutions to common problems encountered in software design. They provide templates for how to solve a problem in a way that has been effective in the past, promoting code reuse and efficiency.

#### Classification of Design Patterns 
 
1. **Creational Patterns**  - Deal with object creation mechanisms, trying to create objects in a manner suitable to the situation. 
  - **Singleton** : Ensures a class has only one instance and provides a global point of access to it. 
    - **Example** : `java.lang.Runtime.getRuntime()` 
      - **Explanation** : The `Runtime` class uses a private constructor and a static method to ensure that only one instance of the class is created, providing a global point of access to that instance.
 
  - **Factory Method** : Defines an interface for creating an object but allows subclasses to alter the type of objects that will be created. 
    - **Example** : `java.util.Calendar.getInstance()` 
      - **Explanation** : The `getInstance` method in the `Calendar` class allows different types of calendar objects to be created without specifying the exact class, promoting flexibility.
 
  - **Abstract Factory** : Provides an interface for creating families of related or dependent objects without specifying their concrete classes. 
    - **Example** : `javax.xml.parsers.DocumentBuilderFactory` 
      - **Explanation** : The `DocumentBuilderFactory` provides an interface to create a family of related objects (parsers) without needing to specify their concrete classes.
 
  - **Builder** : Separates the construction of a complex object from its representation, allowing the same construction process to create various representations. 
    - **Example** : `java.lang.StringBuilder` 
      - **Explanation** : The `StringBuilder` class allows for the construction of a `String` object piece by piece, which can be more efficient and flexible compared to creating strings directly.
 
  - **Prototype** : Creates new objects by copying an existing object, known as the prototype. 
    - **Example** : `java.lang.Object.clone()` 
      - **Explanation** : The `clone` method in `Object` class allows for the creation of a new instance by copying the state of an existing instance, following the prototype pattern.
 
2. **Structural Patterns**  - Deal with object composition, providing ways to compose objects to form larger structures. 
  - **Adapter** : Allows incompatible interfaces to work together by wrapping an existing class with a new interface. 
    - **Example** : `java.util.Arrays.asList()` 
      - **Explanation** : The `asList` method adapts an array to the `List` interface, allowing array elements to be accessed as a list.
 
  - **Bridge** : Decouples an abstraction from its implementation, allowing the two to vary independently. 
    - **Example** : `java.sql.DriverManager` 
      - **Explanation** : The `DriverManager` acts as an interface for database drivers, decoupling the database connection logic from the specific driver implementation.
 
  - **Composite** : Composes objects into tree structures to represent part-whole hierarchies, allowing clients to treat individual objects and compositions of objects uniformly. 
    - **Example** : `javax.swing.JComponent` 
      - **Explanation** : The `JComponent` class can contain other components, forming a tree structure that can be treated uniformly, whether it’s a single component or a complex composite of components.
 
  - **Decorator** : Adds additional responsibilities to an object dynamically, providing a flexible alternative to subclassing for extending functionality. 
    - **Example** : `java.io.BufferedReader` 
      - **Explanation** : The `BufferedReader` class decorates a `Reader` object, adding buffering capabilities to improve performance without changing the underlying `Reader` interface.
 
  - **Facade** : Provides a simplified interface to a complex subsystem. 
    - **Example** : `javax.faces.context.FacesContext` 
      - **Explanation** : The `FacesContext` class provides a simplified interface to the complex underlying JavaServer Faces (JSF) subsystem, making it easier to interact with.
 
  - **Flyweight** : Reduces the cost of creating and manipulating a large number of similar objects by sharing common parts of the object state. 
    - **Example** : `java.lang.Integer.valueOf(int)` 
      - **Explanation** : The `valueOf` method caches and reuses frequently used `Integer` objects, reducing memory usage by sharing common instances.
 
  - **Proxy** : Provides a surrogate or placeholder for another object to control access to it. 
    - **Example** : `java.lang.reflect.Proxy` 
      - **Explanation** : The `Proxy` class provides a dynamic proxy instance that controls access to the underlying object, allowing for additional functionality like logging or access control.
 
3. **Behavioral Patterns**  - Deal with object interaction and responsibility, focusing on how objects communicate with each other. 
  - **Chain of Responsibility** : Passes a request along a chain of handlers, allowing each handler to either process the request or pass it to the next handler in the chain. 
    - **Example** : `java.util.logging.Logger.log()` 
      - **Explanation** : The `Logger` class allows logging requests to be passed along a chain of log handlers, each with the opportunity to process the log message.
 
  - **Command** : Encapsulates a request as an object, thereby allowing parameterization of clients with queues, requests, and operations. 
    - **Example** : `java.lang.Runnable` 
      - **Explanation** : The `Runnable` interface encapsulates a command that can be executed, queued, and passed around, providing flexibility in executing actions.
 
  - **Interpreter** : Defines a grammatical representation for a language and provides an interpreter to deal with this grammar. 
    - **Example** : `java.util.regex.Pattern` 
      - **Explanation** : The `Pattern` class interprets regular expression patterns, providing a way to match strings against these patterns.
 
  - **Iterator** : Provides a way to access elements of a collection sequentially without exposing its underlying representation. 
    - **Example** : `java.util.Iterator` 
      - **Explanation** : The `Iterator` interface provides a standard way to traverse a collection without exposing its underlying implementation.
 
  - **Mediator** : Defines an object that encapsulates how a set of objects interact, promoting loose coupling by keeping objects from referring to each other explicitly. 
    - **Example** : `java.util.Timer` 
      - **Explanation** : The `Timer` class manages the interaction between timer tasks and the thread scheduling them, centralizing control and promoting loose coupling.
 
  - **Memento** : Captures and externalizes an object's internal state, allowing the object to be restored to this state later without violating encapsulation. 
    - **Example** : `java.io.Serializable` 
      - **Explanation** : The `Serializable` interface allows an object's state to be saved and restored, preserving its state across different instances.
 
  - **Observer** : Defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically. 
    - **Example** : `java.util.Observer` 
      - **Explanation** : The `Observer` interface allows objects to register as listeners and be notified of state changes in observable objects, promoting a reactive approach.
 
  - **State** : Allows an object to alter its behavior when its internal state changes, appearing as if the object changed its class. 
    - **Example** : `java.util.Scanner` 
      - **Explanation** : The `Scanner` class changes its behavior based on its internal state, such as the delimiter it uses to parse input.
 
  - **Strategy** : Defines a family of algorithms, encapsulates each one, and makes them interchangeable, allowing the algorithm to vary independently from clients that use it. 
    - **Example** : `java.util.Comparator` 
      - **Explanation** : The `Comparator` interface allows different comparison strategies to be defined and used interchangeably, promoting flexible sorting mechanisms.
 
  - **Template Method** : Defines the skeleton of an algorithm in a method, deferring some steps to subclasses without changing the algorithm's structure. 
    - **Example** : `java.util.AbstractList` 
      - **Explanation** : The `AbstractList` class provides a template method for list operations, allowing subclasses to implement specific details without altering the overall algorithm.
 
  - **Visitor** : Represents an operation to be performed on the elements of an object structure, allowing the definition of a new operation without changing the classes of the elements on which it operates. 
    - **Example** : `javax.lang.model.element.ElementVisitor` 
      - **Explanation** : The `ElementVisitor` interface defines operations to be performed on elements of a program's abstract syntax tree (AST), allowing new operations to be added without changing the element classes.

This guide provides a high-level overview of the various design patterns in Java, offering a starting point for further exploration and implementation.
