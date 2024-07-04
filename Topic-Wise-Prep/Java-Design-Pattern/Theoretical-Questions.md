
### Interview Questions on Design Patterns 

### Theoretical Questions 
 
1. **What is a design pattern and why are they useful in software development?** 
A design pattern is a general, reusable solution to a commonly occurring problem within a given context in software design. Design patterns are useful because they:
  - Provide tested, proven development paradigms.

  - Facilitate code reuse and reduce redundancy.

  - Improve communication among developers.

  - Enhance code maintainability and flexibility.

  - Help avoid common pitfalls and design issues.
 
2. **Explain the difference between creational, structural, and behavioral design patterns.**  
  - **Creational patterns** : Deal with object creation mechanisms, trying to create objects in a manner suitable to the situation. Examples include Singleton, Factory Method, and Abstract Factory.
 
  - **Structural patterns** : Deal with object composition or the structure of classes and objects. Examples include Adapter, Composite, and Proxy.
 
  - **Behavioral patterns** : Deal with object interaction and responsibility delegation. Examples include Observer, Strategy, and Command.
 
3. **What are the main benefits of using design patterns?** 
  - Provide tested, proven development paradigms.

  - Facilitate code reuse and reduce redundancy.

  - Improve communication among developers.

  - Enhance code maintainability and flexibility.

  - Help avoid common pitfalls and design issues.
 
4. **Describe the Singleton pattern and its use cases.** 
The Singleton pattern ensures a class has only one instance and provides a global point of access to it. Use cases include logging, configuration settings, and database connections where a single instance is needed to coordinate actions.
 
5. **Explain the Factory Method pattern and provide an example of where it might be used.** 
The Factory Method pattern defines an interface for creating an object but allows subclasses to alter the type of objects that will be created. It is used when a class cannot anticipate the type of objects it needs to create, or when a class wants its subclasses to specify the objects to be created.**Example** : A document editor might use a factory method to create different types of documents (e.g., text documents, spreadsheets) without knowing the exact class of the document it needs to create.
 
6. **What is the Abstract Factory pattern and how does it differ from the Factory Method pattern?** 
The Abstract Factory pattern provides an interface for creating families of related or dependent objects without specifying their concrete classes. It differs from the Factory Method pattern in that it returns a factory of classes. Each factory created can produce objects related to a single theme.**Example** : A GUI toolkit might use the Abstract Factory to create UI components for different operating systems, ensuring that all components (buttons, windows, etc.) are consistent for the OS.
 
7. **How does the Builder pattern help in object creation?** 
The Builder pattern separates the construction of a complex object from its representation so that the same construction process can create different representations. It is useful for constructing complex objects with many parts, ensuring that the object is constructed step by step in a controlled manner.**Example** : Building a complex `House` object with attributes like rooms, doors, and windows can be done using the Builder pattern.
 
8. **What is the Prototype pattern and when would you use it?** 
The Prototype pattern is used to create new objects by copying an existing object, known as the prototype. This pattern is used when creating an object is costly or complex.**Example** : If creating an object requires a lot of computational resources, you can create a prototype and clone it whenever you need a new object.
 
9. **Describe the Adapter pattern and provide a real-world example.** 
The Adapter pattern allows incompatible interfaces to work together by converting the interface of a class into another interface that the client expects.**Real-world example** : A power adapter that allows a device with a two-pin plug to be connected to a three-pin socket.
 
10. **What problem does the Bridge pattern solve?** 
The Bridge pattern decouples an abstraction from its implementation so that the two can vary independently. This pattern is used to avoid a permanent binding between an abstraction and its implementation.**Example** : Separating the code that handles UI from the code that handles data to allow different UI frameworks to be used with the same data handling code.
 
11. **Explain the Composite pattern and how it is useful in building complex structures.** 
The Composite pattern allows you to compose objects into tree structures to represent part-whole hierarchies. This pattern lets clients treat individual objects and compositions of objects uniformly.**Example** : In a graphical application, shapes can be treated uniformly whether they are simple shapes like circles or complex compositions of shapes.
 
12. **How does the Decorator pattern differ from the Proxy pattern?**  
  - **Decorator pattern** : Adds additional responsibilities to an object dynamically. Decorators provide a flexible alternative to subclassing for extending functionality.
 
  - **Proxy pattern** : Provides a surrogate or placeholder for another object to control access to it. Proxies can add functionality like lazy initialization, access control, logging, etc.
**Example of Decorator** : Adding behavior to a graphical component to support scrolling.
**Example of Proxy** : A network proxy that manages access to a remote server.
 
13. **What is the Facade pattern and how does it simplify interaction with complex systems?** 
The Facade pattern provides a simplified interface to a complex subsystem. It hides the complexities of the subsystem from the client and provides an easier interface to interact with the subsystem.**Example** : A facade in a library management system might provide simple methods for borrowing and returning books, hiding the complex interactions with the book database and user management systems.
 
14. **Describe the Flyweight pattern and its benefits.** 
The Flyweight pattern reduces the memory footprint by sharing as much data as possible with similar objects. It is useful when many objects must be created, but the cost of creating them is high due to memory usage.**Example** : A text editor might use flyweights for character objects, sharing common data like font and style to reduce memory usage.
 
15. **Explain the Proxy pattern with an example.** 
The Proxy pattern provides a surrogate or placeholder for another object to control access to it.**Example** : A virtual proxy for an image that loads the image only when it is needed, thus delaying the cost of loading the image until it is actually used.
 
16. **What is the Chain of Responsibility pattern and when would you use it?** 
The Chain of Responsibility pattern allows a request to pass along a chain of handlers. Each handler can process the request or pass it to the next handler in the chain.**Example** : In a support system, a request might pass through multiple levels of support staff until it is resolved.
 
17. **Describe the Command pattern and its use cases.** 
The Command pattern encapsulates a request as an object, thereby allowing for parameterization of clients with different requests, queuing of requests, and logging of request operations. It decouples the object that invokes the operation from the one that knows how to perform it.**Example** : In a text editor, commands like copy, paste, and undo can be implemented using the Command pattern to allow for easy extension and undo/redo functionality.
 
18. **What is the Interpreter pattern?** 
The Interpreter pattern defines a grammatical representation for a language and an interpreter to interpret the sentences of the language. This pattern is used for parsing languages.**Example** : SQL query interpreters that parse and execute SQL queries.
 
19. **Explain the Iterator pattern and its advantages.** 
The Iterator pattern provides a way to access the elements of an aggregate object sequentially without exposing its underlying representation. It allows clients to traverse a collection without knowing its structure.**Advantages** :
  - Simplifies the client code by hiding the collection's implementation.

  - Allows different traversal methods for the same collection.

  - Supports iteration in a uniform manner for different types of collections.
 
20. **What is the Mediator pattern and how does it improve communication between objects?** 
The Mediator pattern defines an object that encapsulates how a set of objects interact. It promotes loose coupling by keeping objects from referring to each other explicitly, allowing their interaction to be varied independently.**Example** : A chat room system where the mediator (chat room) manages the communication between users without them knowing each other.
 
21. **Describe the Memento pattern and its typical use cases.** 
The Memento pattern captures and externalizes an object's internal state without violating encapsulation, allowing the object to be restored to this state later.**Use cases** :
  - Implementing undo mechanisms in applications.

  - Saving the state of an object to revert to it later.
 
22. **How does the Observer pattern work? Provide an example.** 
The Observer pattern defines a one-to-many relationship between objects, where one object (the subject) notifies multiple observers of any state changes. It is used when changes to one object need to be reflected in other objects without tightly coupling them.**Example** : In a news application, the subject (news feed) can notify observers (subscribers) whenever a new article is published.
 
23. **What is the State pattern and how does it change an object’s behavior?** 
The State pattern allows an object to alter its behavior when its internal state changes. The object will appear to change its class.**Example** : A TCP connection object can be in different states like established, listening, and closed, with different behaviors in each state.
 
24. **Explain the Strategy pattern with an example.** 
The Strategy pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable. It allows the algorithm to vary independently from clients that use it.**Example** : A payment system might use the Strategy pattern to choose between different payment methods (e.g., credit card, PayPal) at runtime.
 
25. **Describe the Template Method pattern and its typical use cases.** 
The Template Method pattern defines the skeleton of an algorithm in a method, deferring some steps to subclasses. It allows subclasses to redefine certain steps of an algorithm without changing the algorithm’s structure.**Use cases** :
  - Implementing algorithms where the invariant parts are defined in the base class and variant parts are implemented in derived classes.

  - Creating frameworks where users can extend specific behavior.
 
26. **What is the Visitor pattern and how does it enable adding new operations to objects?** 
The Visitor pattern allows you to add further operations to objects without having to modify them. It separates an algorithm from the object structure on which it operates, allowing you to define new operations independently.**Example** : An object structure representing a computer (CPU, hard drive, memory) can use the Visitor pattern to perform operations like displaying details or calculating the total price without changing the classes of the computer components.
