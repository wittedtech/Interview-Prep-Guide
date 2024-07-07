### Tricky Questions and Answers 
 
1. **Can you implement a thread-safe Singleton pattern in Java?**


```java
public class Singleton {
    private static volatile Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
```

This implementation uses double-checked locking to ensure that the Singleton instance is created only once and is thread-safe.
 
2. **What are the potential pitfalls of using the Singleton pattern and how can you avoid them?**
 
- **Pitfalls** : 
  - **Global state** : Singleton acts as a global variable, leading to tight coupling and making the code hard to test.
 
  - **Concurrency issues** : Without proper synchronization, it can lead to multiple instances being created.
 
  - **Difficulty in subclassing** : Extending Singleton classes can be challenging.
 
- **Avoidance** :
  - Use dependency injection to manage singletons.

  - Ensure proper synchronization.

  - Consider using an enum type for a simpler thread-safe singleton implementation.
 
3. **How does the Double-Checked Locking idiom work in the context of Singleton?**

Double-Checked Locking reduces the overhead of acquiring a lock by first checking the Singleton instance without synchronization. If the instance is null, synchronization is used to initialize it, ensuring thread safety with minimal performance impact.


```java
public class Singleton {
    private static volatile Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
```
 
4. **Explain how you would ensure a class is not cloned using the Prototype pattern.**
Override the `clone` method and throw a `CloneNotSupportedException`.

```java
public class Prototype implements Cloneable {
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
```
 
5. **How can you prevent a class from being instantiated using the Factory Method pattern?**

Make the constructor of the class protected or private, forcing instantiation through the factory method.


```java
public class Product {
    protected Product() {}

    public static Product createProduct() {
        return new Product();
    }
}
```
 
6. **What are the consequences of using the Composite pattern for a large structure?**
 
- **Increased complexity** : Managing a large number of components can be complex.
 
- **Memory usage** : The recursive nature can lead to high memory usage.
 
- **Performance** : Operations on the entire structure can be slow.

These can be mitigated by optimizing the design and managing resources carefully.
 
7. **How would you handle circular dependencies when using the Observer pattern?**

Use weak references to avoid memory leaks and ensure that observers are properly deregistered when no longer needed.


```java
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class Subject {
    private List<WeakReference<Observer>> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(new WeakReference<>(observer));
    }

    public void notifyObservers() {
        for (WeakReference<Observer> ref : observers) {
            Observer observer = ref.get();
            if (observer != null) {
                observer.update();
            }
        }
    }
}
```
 
8. **What are the trade-offs between using the Strategy pattern vs. the State pattern?**
 
- **Strategy pattern** : Allows swapping algorithms or behaviors dynamically without modifying the context class, promoting flexibility and reuse.
 
- **State pattern** : Encapsulates state-specific behavior and transitions, making it ideal for state-dependent behavior.

Trade-offs include complexity, as the State pattern can result in a large number of classes, while the Strategy pattern may require additional logic to manage strategies.
 
9. **How can you make a Decorator pattern implementation thread-safe?**

Ensure that the component and decorators are immutable, or synchronize access to the shared state to prevent race conditions.


```java
public class SynchronizedDecorator implements Component {
    private final Component component;

    public SynchronizedDecorator(Component component) {
        this.component = component;
    }

    @Override
    public synchronized void operation() {
        component.operation();
    }
}
```
 
10. **Describe a situation where the Facade pattern might introduce performance issues.**

The Facade pattern can introduce performance issues if it adds an additional layer of abstraction that results in redundant or unnecessary processing, or if it hides performance-critical details that could be optimized at a lower level.
 
11. **Explain how the Flyweight pattern can lead to memory leaks and how to mitigate them.**

The Flyweight pattern can lead to memory leaks if shared objects are not properly managed or if they reference other objects that prevent garbage collection. Mitigation strategies include using weak references and ensuring that shared objects are properly released when no longer needed.


```java
public class FlyweightFactory {
    private final Map<String, WeakReference<Flyweight>> flyweights = new HashMap<>();

    public Flyweight getFlyweight(String key) {
        WeakReference<Flyweight> ref = flyweights.get(key);
        Flyweight flyweight = (ref != null) ? ref.get() : null;

        if (flyweight == null) {
            flyweight = new ConcreteFlyweight(key);
            flyweights.put(key, new WeakReference<>(flyweight));
        }
        return flyweight;
    }
}
```
 
12. **How would you design a system that needs to support undo and redo operations using design patterns?**
Use the Command pattern to encapsulate operations. Each command implements an `execute` and `undo` method. Maintain stacks for executed commands and undone commands to support undo and redo operations.

```java
public interface Command {
    void execute();
    void undo();
}

public class InsertCommand implements Command {
    private TextEditor editor;
    private String text;

    public InsertCommand(TextEditor editor, String text) {
        this.editor = editor;
        this.text = text;
    }

    @Override
    public void execute() {
        editor.insert(text);
    }

    @Override
    public void undo() {
        editor.delete(text.length());
    }
}

public class TextEditor {
    private StringBuilder text = new StringBuilder();
    private Stack<Command> commandStack = new Stack<>();
    private Stack<Command> undoStack = new Stack<>();

    public void insert(String text) {
        this.text.append(text);
    }

    public void delete(int length) {
        this.text.delete(this.text.length() - length, this.text.length());
    }

    public void executeCommand(Command command) {
        command.execute();
        commandStack.push(command);
        undoStack.clear();
    }

    public void undo() {
        if (!commandStack.isEmpty()) {
            Command command = commandStack.pop();
            command.undo();
            undoStack.push(command);
        }
    }

    public void redo() {
        if (!undoStack.isEmpty()) {
            Command command = undoStack.pop();
            command.execute();
            commandStack.push(command);
        }
    }

    @Override
    public String toString() {
        return text.toString();
    }
}
```
 
13. **What is the difference between Command pattern and Strategy pattern?**
 
- **Command pattern** : Encapsulates a request as an object, allowing parameterization of clients with queues, logs, and operations.
 
- **Strategy pattern** : Defines a family of algorithms, encapsulates each one, and makes them interchangeable.

The key difference is that Command represents actions and invocations, while Strategy focuses on algorithm selection.
 
14. **Can you combine the use of Adapter and Facade patterns in a single application? Explain how.**

Yes, you can combine Adapter and Facade patterns. The Adapter pattern can be used to convert the interface of a class into another interface that a client expects, while the Facade pattern provides a simplified interface to a complex subsystem. The Adapter can be used within the Facade to adapt components to the required interface.


```java
public class Facade {
    private SubsystemA subsystemA;
    private SubsystemB subsystemB;
    private Adapter adapter;

    public Facade() {
        subsystemA = new SubsystemA();
        subsystemB = new SubsystemB();
        adapter = new Adapter(new LegacySubsystem());
    }

    public void operation() {
        subsystemA.operationA();
        subsystemB.operationB();
        adapter.operation();
    }
}
```
 
15. **Describe how you would use the Visitor pattern to add new operations to an existing object structure without changing its classes.**

The Visitor pattern lets you define a new operation without changing the classes of the elements on which it operates. Each element accepts a visitor object and calls its visit method.


```java
public interface Visitor {
    void visit(ElementA elementA);
    void visit(ElementB elementB);
}

public interface Element {
    void accept(Visitor visitor);
}

public class ElementA implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

public class ElementB implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

public class ConcreteVisitor implements Visitor {
    @Override
    public void visit(ElementA elementA) {
        // Operation for ElementA
    }

    @Override
    public void visit(ElementB elementB) {
        // Operation for ElementB
    }
}
```
 
16. **How do you ensure proper resource management when using the Prototype pattern?**
Ensure that the `clone` method properly copies resource handles and does not share mutable resources between clones. Implement cleanup mechanisms to release resources when they are no longer needed. 
17. **What is the impact of using the Bridge pattern on performance?**

The Bridge pattern can introduce a level of indirection, which may slightly impact performance. However, it also promotes separation of concerns and flexibility, which can lead to better-maintained and more efficient code overall.
 
18. **How would you implement lazy loading using design patterns?**

Lazy loading can be implemented using the Proxy pattern. The proxy controls access to the real object, creating it only when necessary.


```java
public class RealSubject implements Subject {
    public RealSubject() {
        // Expensive initialization
    }

    @Override
    public void request() {
        // Operation
    }
}

public class Proxy implements Subject {
    private RealSubject realSubject;

    @Override
    public void request() {
        if (realSubject == null) {
            realSubject = new RealSubject();
        }
        realSubject.request();
    }
}
```
 
19. **How can the Singleton pattern be misused in a multi-threaded environment?**

If not properly synchronized, multiple threads could create separate instances of the Singleton. Additionally, using Singleton for mutable shared state can lead to race conditions and inconsistent data.
 
20. **How would you handle adding new states to a system implemented using the State pattern without modifying existing code?**

Use a configuration or registry to dynamically add new state classes. This allows the state machine to be extended without modifying existing code.
 
21. **What are the limitations of the Template Method pattern?**
 
- **Inflexibility** : Requires subclasses to override steps of the algorithm, which can be rigid.
 
- **Inheritance hierarchy** : Can lead to deep inheritance hierarchies.
 
22. **How can you optimize the performance of the Observer pattern in a large-scale system?**
 
- **Batch notifications** : Group multiple updates into a single notification.
 
- **Filtering** : Allow observers to specify interest in specific events.
 
- **Asynchronous updates** : Use asynchronous mechanisms to notify observers.
 
23. **Can the Factory Method pattern be used in a system where objects need to be created based on multiple criteria? How?**

Yes, by implementing multiple factory methods or a factory method with parameters to handle different creation criteria.


```java
public abstract class Creator {
    public abstract Product createProduct(String criteria);
}

public class ConcreteCreator extends Creator {
    @Override
    public Product createProduct(String criteria) {
        switch (criteria) {
            case "typeA": return new ProductA();
            case "typeB": return new ProductB();
            default: throw new IllegalArgumentException("Unknown criteria");
        }
    }
}
```
 
24. **Explain how you would implement a cache system using the Flyweight pattern.**

The Flyweight pattern can be used to share common parts of object state. In a cache system, the intrinsic state of cached objects can be shared to reduce memory usage.


```java
public class Flyweight {
    private final String sharedState;

    public Flyweight(String sharedState) {
        this.sharedState = sharedState;
    }

    public void operation(String uniqueState) {
        // Use sharedState and uniqueState
    }
}

public class FlyweightFactory {
    private final Map<String, Flyweight> cache = new HashMap<>();

    public Flyweight getFlyweight(String key) {
        return cache.computeIfAbsent(key, Flyweight::new);
    }
}
```
 
25. **How would you use the Proxy pattern to implement access control in a system?**

The Proxy pattern can be used to control access to an object by implementing the same interface and adding access control logic before delegating to the real object.


```java
public interface Service {
    void operation();
}

public class RealService implements Service {
    @Override
    public void operation() {
        // Actual operation
    }
}

public class AccessControlProxy implements Service {
    private final RealService realService;
    private final User user;

    public AccessControlProxy(RealService realService, User user) {
        this.realService = realService;
        this.user = user;
    }

    @Override
    public void operation() {
        if (user.hasAccess()) {
            realService.operation();
        } else {
            throw new SecurityException("Access denied");
        }
    }
}
```
