# Core Java Interview Questions

## Questions and Answers

1. **How does `substring()` inside `String` work?**
   - `substring(int beginIndex, int endIndex)` extracts a portion of the string from `beginIndex` (inclusive) to `endIndex` (exclusive). It returns a new `String` object without modifying the original. Internally, it creates a new string referencing the same character array with adjusted offset and length (in older Java versions) or copies the relevant portion (Java 7+). Time complexity is O(1) for creation but may involve copying in newer versions.

2. **What is a `ClassLoader`?**
   - A `ClassLoader` is a Java component responsible for dynamically loading classes into the JVM at runtime. It reads class files (bytecode) and converts them into `Class` objects. It follows a delegation model: Bootstrap → Extension → Application ClassLoader. Developers can create custom `ClassLoader`s for specific loading needs (e.g., loading classes from a network).

3. **How is the creation of a `String` using `new()` different from a literal?**
   - **Literal (`String s = "hello";`)**: Creates a string in the String Pool (a part of the heap). If the same literal exists, it reuses the object, saving memory.
   - **Using `new` (`String s = new String("hello");`)**: Creates a new `String` object on the heap outside the pool, even if the literal exists in the pool. It’s less memory-efficient and not recommended unless explicitly needed. Use `intern()` to force pooling.

4. **Difference between `Executor.submit()` and `Executor.execute()`?**
   - **`execute(Runnable)`**: Submits a `Runnable` task for execution without returning a result. No feedback on task completion or exceptions (unless caught manually).
   - **`submit(Runnable/Callable)`**: Returns a `Future` object to track task status, retrieve results (for `Callable`), or handle exceptions. More flexible for managing asynchronous tasks.

5. **What is the Java Memory Model (JMM)?**
   - The JMM defines how threads interact with memory in Java, ensuring consistent behavior for visibility and ordering of operations. It specifies rules for:
     - **Visibility**: Changes by one thread are visible to others (e.g., `volatile` variables).
     - **Ordering**: Ensures happens-before relationships (e.g., synchronized blocks, volatile reads/writes).
     - **Atomicity**: Guarantees certain operations (e.g., reference assignments) are indivisible.
   - It balances performance and thread safety.

6. **How to make a class immutable? What purpose does it solve?**
   - **Steps to make a class immutable**:
     1. Declare the class `final` to prevent subclassing.
     2. Make all fields `private` and `final`.
     3. Don’t provide setters or methods that modify fields.
     4. Ensure constructor initializes all fields (deep copy if needed).
     5. Return deep copies of mutable objects in getters.
     6. Ensure thread-safe initialization (e.g., `final` fields are safe).
   - **Purpose**: Immutability ensures thread safety, simplifies reasoning about code, prevents unintended modifications, and supports reliable caching (e.g., in `HashMap` keys).

7. **Can you use `HashMap` in a multi-threaded environment? What can be the problem?**
   - **Usage**: `HashMap` is not thread-safe. Concurrent modifications can lead to issues like:
     - **Data corruption**: Inconsistent internal state (e.g., during resize).
     - **Infinite loops**: Race conditions during updates.
     - **Lost updates**: One thread’s changes may overwrite another’s.
   - **Solutions**: Use `ConcurrentHashMap`, `Collections.synchronizedMap()`, or external synchronization, depending on the use case.

8. **Critical section code for Singleton?**
   ```java
   public class Singleton {
       private static volatile Singleton instance;
       private Singleton() {}
       
       public static Singleton getInstance() {
           if (instance == null) { // First check (no synchronization)
               synchronized (Singleton.class) { // Critical section
                   if (instance == null) { // Double-checked locking
                       instance = new Singleton();
                   }
               }
           }
           return instance;
       }
   }
   ```

9. **What is Singleton? Is it better to make the whole method synchronized or only the critical section?**
   - **Singleton**: A design pattern ensuring a class has only one instance and provides a global access point. Used for resource management (e.g., database connections).
   - **Whole method vs. critical section**:
     - **Whole method synchronized**: Simpler but slower, as every call to `getInstance()` acquires a lock, even when the instance exists.
     - **Critical section (double-checked locking)**: More efficient, as synchronization occurs only during initialization. Preferred for performance in multi-threaded environments.

10. **How to avoid deadlock in Java?**
    - **Avoid nested locks**: Minimize acquiring multiple locks; if needed, always acquire them in the same order across threads.
    - **Use timeouts**: Use `tryLock()` in `Lock` interfaces to avoid indefinite waiting.
    - **Minimize lock scope**: Hold locks for the shortest time possible.
    - **Use thread-safe collections**: Prefer `ConcurrentHashMap` over synchronized `HashMap`.
    - **Avoid blocking calls**: Prefer non-blocking algorithms or timeouts.
    - **Thread scheduling**: Use thread pools (`ExecutorService`) to control thread interactions.

11. **How to avoid serialization in a child class if the base class implements `Serializable`?**
    - A child class inherits `Serializable` if the parent implements it. To prevent serialization:
      - Override `writeObject()` and `readObject()` to throw `NotSerializableException`.
      ```java
      private void writeObject(ObjectOutputStream out) throws IOException {
          throw new NotSerializableException("This class is not serializable");
      }
      private void readObject(ObjectInputStream in) throws IOException {
          throw new NotSerializableException("This class is not serializable");
      }
      ```
    - Alternatively, use `transient` for fields you don’t want serialized, but this doesn’t fully prevent serialization.

12. **What is `ConcurrentHashMap` in Java, and how is it implemented?**
    - **`ConcurrentHashMap`**: A thread-safe implementation of `Map` that allows concurrent reads and writes without external synchronization. It achieves this via:
      - **Segmentation (Java 7)**: Divides the map into segments, each with its own lock.
      - **Node-based locking (Java 8+)**: Uses fine-grained locks on individual buckets and CAS (Compare-And-Swap) for updates.
    - **Features**: High concurrency, no `NullPointerException` for null keys/values, supports atomic operations (e.g., `compute`).
    - **Implementation**: It’s part of Java’s `java.util.concurrent` package. Use it directly for thread-safe map operations.

13. **Fail-Fast vs. Fail-Safe Iterator with examples**:
    - **Fail-Fast**: Throws `ConcurrentModificationException` if the collection is modified during iteration (e.g., `ArrayList`, `HashMap`).
      ```java
      List<String> list = new ArrayList<>(Arrays.asList("a", "b"));
      Iterator<String> it = list.iterator();
      list.add("c"); // Modifies list
      it.next(); // Throws ConcurrentModificationException
      ```
    - **Fail-Safe**: Allows modifications during iteration by working on a copy or supporting concurrent changes (e.g., `CopyOnWriteArrayList`, `ConcurrentHashMap`).
      ```java
      CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>(Arrays.asList("a", "b"));
      Iterator<String> it = list.iterator();
      list.add("c"); // Modifies list
      it.next(); // No exception, works on snapshot
      ```

14. **Difference between Checked and Unchecked Exception?**
    - **Checked Exception**: Must be declared or handled (e.g., `IOException`, `SQLException`). Checked at compile-time. Used for recoverable conditions.
    - **Unchecked Exception**: Subclasses of `RuntimeException` (e.g., `NullPointerException`, `IllegalArgumentException`). Not checked at compile-time. Used for programming errors or unrecoverable conditions.

15. **Difference between Factory and Abstract Factory Pattern?**
    - **Factory Pattern**: A single factory class creates objects of a single type (e.g., a `CarFactory` creates `Car` objects).
      ```java
      interface Car { void drive(); }
      class CarFactory {
          public Car createCar() {
              return new Sedan();
          }
      }
      ```
    - **Abstract Factory Pattern**: A factory of factories creates families of related objects (e.g., a `VehicleFactory` creates `Car` and `Bike` objects).
      ```java
      interface VehicleFactory {
          Car createCar();
          Bike createBike();
      }
      ```

16. **What is a Marker Interface?**
    - A marker interface is an empty interface (no methods) used to tag classes for specific behavior (e.g., `Serializable`, `Cloneable`). The JVM or libraries check for these interfaces to enable functionality (e.g., serialization for `Serializable` classes).

17. **When does the `finally` block not get executed?**
    - A `finally` block doesn’t execute if:
      - The JVM exits (e.g., `System.exit(0)`).
      - The thread is interrupted or killed.
      - An uncaught exception or error (e.g., `OutOfMemoryError`) crashes the program before `finally`.
      - The `try` block enters an infinite loop or deadlocks.

18. **How does Garbage Collection in Java work?**
    - Java’s Garbage Collector (GC) reclaims memory from objects no longer reachable. Key steps:
      - **Marking**: Identifies reachable objects from roots (e.g., stack, static fields).
      - **Sweeping**: Frees memory of unreachable objects.
      - **Compaction** (optional): Moves live objects to reduce fragmentation.
    - Uses generational GC (Young/Old generations) with algorithms like G1, CMS, or Parallel GC. Developers can’t force GC but can suggest it via `System.gc()`.

19. **Difference between `ClassNotFoundException` vs. `NoClassDefFoundError`?**
    - **`ClassNotFoundException`**: A checked exception thrown when a class is not found at runtime via `Class.forName()` or `ClassLoader.loadClass()`. Caused by missing class files in the classpath.
    - **`NoClassDefFoundError`**: An error thrown when a class was available at compile-time but missing at runtime (e.g., due to classpath issues or failed static initialization).

20. **How to break Singleton?**
    - A Singleton can be broken via:
      - **Reflection**: Access the private constructor to create new instances.
        ```java
        Constructor<Singleton> constructor = Singleton.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        Singleton newInstance = constructor.newInstance();
        ```
      - **Serialization**: If `Serializable`, deserialization creates a new instance unless `readResolve()` is implemented.
      - **Cloning**: If `Cloneable`, `clone()` creates a new instance.
      - **Multiple ClassLoaders**: Different `ClassLoader`s can load separate Singleton instances.
    - **Prevention**: Use `enum` for Singleton, implement `readResolve()`, check for cloning, and restrict reflection access.

---
