# Common Interview Questions :

## JAVA :

1. **What is Java?**
   - Java is a platform independent, object-oriented programming language.
   - Use to develop secure scalable and efficient enterprise applications.

- **NOTE :** Java is not fully object oriented programming language as it supports primitive data types such as int, byte, long, shorts, etc; which are not objects.

2. **What are the main features of Java?**

   1. `Simple and Easy to learn :` Because of it's similarity with C++, C## and other programming langugae .
   2. `Platform Independent :` _write once, run anywhere_ concept which means write and compile code into _bytecode, as `.class`_ file and then run that file in any machine which has JVM(Java Virtual Machine) in it.
   3. `Object-Oriented :` Not Pure but Java is fully object-oriented, emphasizing the use of classes and objects.
   4. `Robust and Secure :` Robust because it includes features like automatic garbage collection, exception handling, and strong memory management, reduces the chances of system crashes.
      Secure because it doesn't promote use of explicit pointers as like C and others, also provide secure run time environment, do not promotes and use third party untrusted libraries unlike python and others.
   5. `Multithreading :` supports exceution of multiple thread with in a program, helps in utilizing system resources properly and efficiently and also enhance performce and responsiveness.
   6. `Distributed Computing :` well-suited for distributed computing, because of **Remote Method Invocation(RMI)** and **Application Programming Interface(API)** for socket programming.
   7. `Dynamic and Extensible :` it's the nature of java because of it developers can modify the code during runtime and this nature makes java extensible for scalable and adaptable software.

3. **What is the JVM?**

   - JVM is an abstract machine responsible for compiling and executing java or any other programming language compiled in Java bytecodes.
   - JVM is a kind of interpretor b/w java rogramming language and the underlying hardware.
   - JVM is the part of Java Runtime Environment(JRE).
   - JVM is the reason why java is platform independent.
     ![JVM Components](https://www.scientecheasy.com/wp-content/uploads/2021/03/java-jvm-architecture.png)

4. **What are JDK and JRE?**

   - Java Development Kit(JDK) is a complete kit of tools and required jars for java programming and application development.
   - JDK consists Java Runtime Environment(JRE) and also other development tools such as Java Debugger, JavaDoc, compilers, etc.
   - JRE is the part of JDK and they both are platform dependent, i.e. you require different jdk and jre for different systems.
   - JRE doesn't consist any development tools like debugger, compiler instead JRE consists various supporting file and class libraries for JVM to help run the program.
   - JDK = Development Tools + JRE
     JRE = Libraries for Running the Application (Dependecies JAR, Integration libraries like JDBC(Java Database Connectivity), JNDI(Java Naming and Directory Interface), RMI (Remote Method Invocation) and many more...) + JVM
     JVM = only the runtime environment to execute the java bytecode.

5. **What are Java’s access specifiers?**

   - `public :` declaration is visibl everywhere.
   - `private :` Declaration are visible only within class.
   - `protected :` declaration are visible within the package and all subclasses.
   - `default :` Declaration is only visible within the package (also known as - package private).

   **NOTE :**

   1. You cannot set the access modifier of getters methods because getter are used to get private variables wherever required.
   2. We cannot declare classes and interfaces private in Java. However, the nested classes can be declared private.
   3. We cannot declare classes or interfaces protected in Java.

6. **What is garbage collection in Java?**

   - Destroying unused objects and cleaning the memory space to ensure smooth execution and preventing abnormal program termination due to OutOfMemmoryErrors, java has a functionality known as garabage collection.
   - Unlike C/C++ where the program is responsible for construction and destruction of object and most of the programmers don't destruct the objects which causes more memory consumption and sometimes no memory lefts for further execution and this lead to abnormal program behaviour.
   - To ignore this issue Garbage Collection comes in handy as of when a program execution starts in JVM , objects gets created in the heap and after sometime when some of the objects are no longer needed garbage collector collects thos objects and free up the heap memory to be utilised during further execution of the program.
   - Types of Activities in Java Garbage Collection
     Two types of garbage collection activity usually happen in Java. These are:

     **Minor or incremental Garbage Collection:** It is said to have occurred when unreachable objects in the young generation heap memory are removed.
     **Major or Full Garbage Collection:** It is said to have occurred when the objects that survived the minor garbage collection are copied into the old generation or permanent generation heap memory are removed. When compared to the young generation, garbage collection happens less frequently in the old generation.

   - Garbage Collector (GC) is invoked/called by JVM , Whenever an object becomes eligible for gc and by eleigible mostly i mean an unreachable object, still its not necessary that gc will instatntly collect that object, it will be destroyed whenever JVM will call the gc but if we want to call garbage collector manually we can do so with two different methods and they both are equally capable :

   1. `System.gc()` method : System clas contain static method gc() to manually call garbage collector.
   2. `Runtime.getRuntime.gc()` method : Runtime class allows us to interface the JVM in which the application is running and but using its gc() method we can request JVM to call garbage collector.
      **NOTE :** - Both the methods are equally effective and by using these two methods it not guaranteed that garbage collector will run for sure.

   - **Grabage Collector** internally callls `finalize()` method present in Object class just before destroying any objects from the heap finalize() method is called on that object to perform a final cleanup process and after that garbage collector destroys that object. `finalize()` runs only once per object.
     **NOTE :**

     1. finalize() method is called by Garbage Collector not by JVM.
     2. ```java
            // empty implementation.
           protected void finalize() throws Throwable

           // it is recommmended to override finalize() method to dispose system resources and perform other cleanup properly.
        ```

     3. If an uncaught exception is thrown by the finalize() method, the exception is ignored, and the finalization of that object terminates.

7. **What is the finalize() method?**

   - `finalize() :` this method is present in Object class and has an empty implementation. finalize() is called by Garbage Collector on the object which is going to be collected to perform necessary cleanup process before garabge collector collects and destroy that object . Clean up process such as closing connection, removing eventlisteners, releasing resources.
   - Recommended to override `finalize()` method to write our custom cleanup and call super.finalize() inside override method to call the Object class finalize to finally complete the cleanup process.

8. **What are the types of memory areas allocated by JVM?**

   - The memory in the JVM is divided in to 5 different parts:

     1. `Class(Method) Area` : This area is the memory block that holds all the class code, variable code(static variable, runtime constant), method code, and the constructor of java program. Store class level data of every class.
     2. `Heap` : This memory block is the place where objects are created and stored. heam memory allocated memory for class interfaces and array(arrays are objets). It is used to allocate memory to objcts at run time.

     ```
     NOTE : Static Methods and Variables were previous stored in Class Area (Till Java 8). But, in current versions of Java static variables and methods are stored in Heap Memory.
     ```

     3. `Stack` : Stack is responsible for holding execution data and result which are required for dynamic linking. Let's understand it clearly : Every thread has its own private JVM stack, created at same time as the thread. It is used to store data and partial results which will be required when returning value for methods and performing dynamic linking.
        Java Stack Stores frames and frames are created for mthod every time method is invoked and destroyed when invocation completes.
     4. `Program Counter Register` : Program Counter(PC) Register is associated with every thread and stores information/data of the their own thread. Stores the address of the current instruction being executed by the thread.
        - In Case of Non-native methods(Method written in JAVA) : Stores the address of the current bytecode instruction being executed.
        - In Case of Native Methods(Method written in another language like C/C++) : PC Register has undefined value.
     5. `Native Method Stack` : This is also a per-thread data area but unlike JVM stack it is designed to support execution of native methods because natice methods are not compiled in java bytecode so PC Register value becomes undefined i.e. we need Native Metod Stack.

9. **What is the difference between an interface and an abstract class?**

   - `Interface :` Interface only contains abstract methods, Interface supports multiple inheritence(i.e. a clas can implement multiple interfaces). Inteefaces can not be instantiated. Interface supports absolute abstraction. Interfaces are implicitly abstract. Interfaces can have only abstract methods. Interface can only extend another Java Interface. By default Variable are final and methods are public inside interfaces. Interfaces are implemented by using keyword `implements`.
   - `Abstract Class` : Abstract class doesn't support absolute abstraction. Can extend another java clasd and implements multiple interfaces. Abstract Classes also can not be instantiated but can be invoked if main() exists. Abstract classes are not implicitly abstract we need to define abstract class by using `abstract` keyword before class name. Abstract classes variable may be non-final as well and methods can have access specifier same as normal classes. Abstract classes can be used by extending them using `extends` keyword.

   ![Difference b/w Interface and Abstract Class](https://i.sstatic.net/pghvG.jpg)

10. **How do ArrayList, LinkedList, HashMap, HashSet, TreeMap, and TreeSet differ?**

    - `ArrayList` and `LinkedList` both are the implementation of list interface.
      1. **ArrayList** is better for random access of elements as it follow indexing based access.
      2. **LinkedList** is better for insertion and deletion process as it carries pointer/address/refrence of elements and only updates the pointer for the new location no resizing of data structure is done in the background as like array.
    - `HashMap`, `HashSet` `TreeMap` and `TreeSet` these are the implementation of Map and Set interfaces.

      1. **HashMap** and **HashSet** are better for quick access and insertion operation because of hashing technique.
      2. **TreeMap** and **TreeSet** are better for sorting and maintning order because their respective sorting techniques.

    - When to Use Each
      1. Use **ArrayList** when elements are accessed by index and the size of the collection is known in advance.
      2. Use **LinkedList** when elements are frequently inserted or deleted at specific positions.
      3. Use **HashMap** when elements are accessed by key and quick access time is important.
      4. Use **HashSet** when elements are unique and quick access time is important.
      5. Use **TreeMap** when elements need to be sorted and quick access time is important.
      6. Use **TreeSet** when elements need to be sorted and quick access time is important.

11. **How does the HashMap work internally?**

    - Hashmap is a data structure in java which stores data in the form of key-value pairs and provides faster access and retrieval of values.
    - It uses the technique of **Hash Function** to calculate the **hash** of the key and according to that hash it decides in which index the key-value pair will be stored in the array.
    - Array used in HashMap to store key-value pair is known as **bucket-array**. Each index in the array is a bucket and every bucket can hold multiple key-value pairs.
    - In case when two or more keys has the same Hash and they gets assigned to the same index to be stored this is k/a **Collision** and to solve collision HashMap has the technique named as **Chaining**.
    - In **Chaining**, each bucket in the array is a linkedlist of key-value pairs whose hash are same . This allows hashmap to store multiple key-value pair in the same array index.
    - `PUT` and `GET` operation in hashmap are the two major operations
      1. **put(key,value)** this method is used to store the key value in HashMap. this operation first calculates the Hash code for the key using Hash Function and use the hash code to determine the index and if teh index is already occupied then it handles the coliision by adding new key-value pair in the linkedlist at that index.
      2. **get(key)** this method is used to get the value associated with the key, same as put it also calculates the Hash of the key and identify the index to check for the value and if the index hash multiple key-values stored then it check the complete linkedlist of that index and uses `equals()` method to fetch the exact key.
    - HashMap are not thread safe by default but can be made thread safe using `synchronized` block or a lock.

- **SUMMARY :**
  HashMap in java use it’s inner class Node<K,V> for storing mappings. HashMap works on hashing algorithm and uses hashCode() and equals() method on key for get and put operations. HashMap use singly linked list to store elements, these are called bins or buckets. When we call put method, hashCode of key is used to determine the bucket that will be used to store the mapping. Once bucket is identified, hashCode is used to check if there is already a key with same hashCode or not. If there is an existing key with same hashCode, then equals() method is used on key. If equals returns true, then value is overwritten, otherwise a new mapping is made to this singly linked list bucket. If there is no key with same hashCode then mapping is inserted into the bucket. For HashMap get operation, again key hashCode is used to determine the bucket to look for the value. After bucket is identified, entries are traversed to find out the Entry using hashCode and equals method. If match is found, value is returned otherwise null is returned. There are much more things involved such as hashing algorithm to get the bucket for the key, rehashing of mappings etc. But for our working, just remember that HashMap operations work on Key and good implementation of hashCode and equals method is required to avoid unwanted behaviour. Below image shows the explanation of get and put operations.

12. **What are the differences between fail-fast and fail-safe iterators?**
13. What is multithreading in Java?
14. What are the different ways to create a thread in Java?
15. What is synchronization in Java?
16. What is a deadlock in Java?
17. What are thread-safe collections in Java?
18. What are threads, and how are they different from processes?
19. Explain synchronized, volatile, wait(), notify(), and notifyAll().
20. What are thread pools, and how do you create them using the ExecutorService?
21. What are checked and unchecked exceptions?
22. How does the try-catch-finally block work?
23. What is the difference between throw and throws?
24. Explain the Java memory model.
25. What is garbage collection, and how does it work?
26. What are strong, weak, soft, and phantom references?
27. Explain lambda expressions and functional interfaces in Java 8.
28. What are streams in Java 8, and how do you use them?
29. How do Optional and the new date/time API work in Java 8?
30. What are the Singleton, Factory, Builder, and Observer design patterns?
31. When would you use Dependency Injection?
32. Explain the JVM architecture.
33. What are the different types of class loaders?
34. How does the Just-In-Time (JIT) compiler work?
35. What are the differences between Java IO and NIO?
36. Explain the use of buffers and channels in NIO.
37. How do you implement serialization and deserialization in Java?
38. What are the different types of references in Java?
39. How does the Java Stream API work, and what are its benefits?
40. What is the difference between an interface and an abstract class?
