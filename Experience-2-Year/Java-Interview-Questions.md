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

   - **Fail-Fast** iterators are those who iterates over the main collection instead of a copy collection. They consumes less memory space because they do not need to create a copy of collection. In these iterators if you modify the main collection (i.e. add, remove, or sort elements) it will throw an `ConcurrentModificationException` and abort the operation as soon as they get this exception.
      **Example :** ArrayList, List, Map etc. (Collection provided by `java.util.Collection.*` package are all Fail-Fast).
   - **Fail-Safe** iterators ar e those who iterates over the clone/copy of the collection instead of main collection. They consumes more memory space as they have to create a copy of collection. These type of iterators try to avoid any kind of failure and they do not throw any exception even if the main collection is modified.
      **Example :** copyOnWriteArrayList, copyOnWriteArraySet (Collections provides by `java.util.Concurrent.*` packages are all Fail-Safe).
   - **NOTE :** 
      1. If we remove/add the element using the remove() or add() of iterator instead of collection, then in that case no exception will opccur. It is because the remove/add methods of iterators call the remove/add method of collection internally, and also it reasigns the expectedModCount to new modCount value.
      2. There is no such thing as Fail-Safe iterator in java documentation instead of this it is k/a `Non-Fail-Fast` iterators.
      3. **Fail-Safe** will not reflect the latest state of the collection.


13. **What is multithreading in Java?**

   - Multithreading in java is an act of executing a processes using virtual processing entities independent of each other. These entities are k/a `Threads.` Running multiple threads concurrently is `multithreading.`

14. **What are the different ways to create a thread in Java?**

   - There are two ways to create a thread in java :
      1. `By extending Thread class :` First create a class that extends Thread and overrides the run() method. Now thread can be created by creating the object of our newly created class and calling the run() method.
      2. `By implenting Runnable interface :` Thread class must implement the runnable interface and the thread class must override the run() method.


15. **What is synchronization in Java?**

   - Synchronization in java is the capability to control access of multiple threads over a shared resources. Synchronization allows only one thread at a particular time to complete a given task entirely. Synchronization saves the systems to approach race condition.
   - In simple words, Synchronization is a way to ensure that only one thread can access a shared resource at a time.
   - We can achieve thread synchronization in java by using `synchronized` keyword and :
      1. `By Using Synchronized Method :` an method is synchronized using synchronized keyword.
         ```java
         public class Counter { 
            private static int count = 0; 
            public static synchronized void increment() {
                count++; 
            } 
            public static int getCount() { 
               return count; 
            } 
         }
         ```
      2. `By Using Synchronized Block :` an code block synchronized inside a method.
         ```java
         class Table{      
            void printTable(int n){    
               synchronized(this){//synchronized block    
                  for(int i=1;i<=5;i++){    
                     System.out.println(n*i);    
                     try{    
                     Thread.sleep(400);    
                     }catch(Exception e){System.out.println(e);}    
                  }    
               }    
            }//end of the method    
         }    
         ```
      3. `By Using Static Synchronization :` 
         ```java
         public class GirlFriend {
            public static synchronized void sing() {
               try {
                     for (int i = 1; i <= 10; ++i) {
                        System.out.println("lullaby");
                        Thread.sleep(100);
                     }
               } catch (Exception e) {
               }
            }
            }

            public static synchronized void count() {
               try {
                     for (int i = 1; i <= 10; ++i) {
                        System.out.println(i);
                        Thread.sleep(100);
                     }
               } catch (Exception e) {
               }
            }
         }
         ```

   - _In summary, static synchronization is used to synchronize access to static methods, which are methods that belong to a class rather than an instance of the class. It ensures that only one thread can execute a static synchronized method at a time, regardless of the objects involved. This is different from synchronized methods or synchronized blocks, which lock on the instance of the class or a specific object, respectively._

16. **What is a deadlock in Java?**

   - Deadlock is a situation when two or more computer programs/threads are sharing the same resources and wait for each other to release the lock from the resource and due to this the programs/threads block each other and this situation or blockage of threads for indefinite time period is k/a Deadlock.

17. **What are thread-safe collections in Java?**

   - Collections those are designed to use by multiple threads without using external synchronization are thread-safe collections.
   - List of all the by default thread-safe collections : 
      1. `ConcurrentHashMap:` This is a thread-safe version of the HashMap class. It uses a lock striping mechanism to improve performance and scalability.
      2. `CopyOnWriteArrayList:` This is a thread-safe version of the ArrayList class. It creates a new array for each modification, ensuring that iterators do not throw ConcurrentModificationException.
      3. `CopyOnWriteArraySet:` This is a thread-safe version of the HashSet class. It uses the same copy-on-write mechanism as CopyOnWriteArrayList to ensure thread safety.
      4. `ConcurrentLinkedQueue:` This is a thread-safe version of the Queue interface. It uses a compare-and-swap mechanism to ensure that operations are atomic and do not throw ConcurrentModificationException.
      5. `ConcurrentSkipListMap:` This is a thread-safe version of the Map interface. It uses a compare-and-swap mechanism to ensure that operations are atomic and do not throw ConcurrentModificationException.
      6. `ConcurrentSkipListSet:` This is a thread-safe version of the Set interface. It uses a compare-and-swap mechanism to ensure that operations are atomic and do not throw ConcurrentModificationException.
      7. `Vector:` This is a legacy thread-safe collection that is synchronized at the object level. It is less efficient than other thread-safe collections due to the overhead of synchronization.
      8. `Hashtable:` This is another legacy thread-safe collection that is synchronized at the object level. It is less efficient than other thread-safe collections due to the overhead of synchronization.

18. **What are threads, and how are they different from processes?**

   - Process is execution of a program with its own memory space and address and managed by operating system.
   - Thread is the part of process every process has at least one thread present and that thread share the same memory of the process. Threads are lightweight processes(i.e. Process divided in multiple sub process/thread) and threads can be ,managed indivisually by the scheduler. 
   - Creating a new thread requires fewer resources than creating a process.


19. **Explain synchronized, volatile, wait(), notify(), and notifyAll().**

   - `synchronized :` 
      - **Purpose :** Ensures only one thread executes the block of code at a time.
      - **Usage :** used with `synchronized` keyword to lock an object and ensure thread safety.
      - **Example :**
         ```java
         public class Girlfriend{
            public synchronized void sing(){
               // code to be executed
            }
         }
         ```
   - `volatile :`
      - **Purpose :** Ensures that changes to a variable are immediately visible to all threads.
      - **Usage :** used with `volatile` keyword to declare a variable that should be updated immediately.
      - **Example :**
         ```java
         public class Employee{
            public volatile int count = 0;
            public void incrementCount(){
               count++;
            }
         }
         ```
   - `wait() :`
      - **Purpose :** Cause a thread to wait until another thread notifies it.
      - **Usage :** used to pause a thread until specific condition is met.
      - **Example :**
         ```java
         public class PrintDemo{
            private final Object lock = new Object();
            public void printCount(){
               // defining a synchronized block
               synchronized(lock){
                  for(int i=0; i<5; i++>){
                     System.out.println("Counter :"+i);
                     try{
                        lock.wait(); // invoked the wait method to make lock thread wait until another thread notifies.
                     }catch(InterruptedException e){
                        System.out.println("Thread Interrupted.");
                     }
                  }
               }
            }
         }
         ```
   - `notify() :`
      - **Purpose :** Wakes up a thread that is waiting on a specific object.
      - **Usage :** Used to notify a thread that is waiting on a specific object.
      - **Example :**
         ```java
         public class PrintDemo{
            private final Object lock = new Object();
            public void printCount(){
               // defining a synchronized block
               synchronized(lock){
                  for(int i=0; i<5; i++>){
                     System.out.println("Counter :"+i);
                     try{
                        lock.notify(); // invoked the notify method to make waiting thread continue its task.
                     }catch(InterruptedException e){
                        System.out.println("Thread Interrupted.");
                     }
                  }
               }
            }
         }
         ```
   - `notifyAll() :`
      - **Purpose :** Wakes up all the threads that are waiting on a specific object.
      - **Usage :** Used to notify all the threads waiting on a specific object.
      - **Example :**
         ```java
         public class PrintDemo{
            private final Object lock = new Object();
            public void printCount(){
               // defining a synchronized block
               synchronized(lock){
                  for(int i=0; i<5; i++>){
                     System.out.println("Counter :"+i);
                     try{
                        lock.notifyAll(); // invoked the notifyAll method to make all the lock threads continue their task.
                     }catch(InterruptedException e){
                        System.out.println("Thread Interrupted.");
                     }
                  }
               }
            }
         }
         ```
   - *These concepts are important for ensuring thread safety and synchronization in java.*

      

20. **What are thread pools, and how do you create them using the ExecutorService?**

   - A thread pool is a collection of thread that can be used to perform a set of task concurrently. For this we have an Executor Framework provided by java in the `java.util.concurrent.*` package ; inside this package their is an `ExecutorService` interface that defines a set of methods fo rmanaging the lifecycle of threads in a thread pool.
   - By using ExecutorService, we can create, execute, and manage threads without having to manage their lifecycle manually. `java.util.concurrent.` package provides us two main Classes to manage thread pool `ExecutorService` and `Executors`.
   - `Executors` class provides lots of factory methods that can create different types of Executors. Some of the most commonly used Executors are :
      1. `newSingleThreadExecutor() :` The newSingleThreadExecutor() method creates an Executor that uses a single worker thread to execute tasks. This type of Executor is useful when we want to ensure that tasks are executed in the order in which they are submitted.
      ```java
         ExecutorService executor = Executors.newSingleThreadExecutor();
         executor.submit(() -> {
            System.out.println("Task 1");
         });
         executor.submit(() -> {
            System.out.println("Task 2");
         });
         executor.shutdown();
      ```
      ```html
      Task 1
      Task 2
      ```

      2. `newFixedThreadPoolExecutor() :` The newFixedThreadPool() method creates an Executor that uses a fixed number of worker threads to execute tasks. This type of Executor is useful when we want to limit the number of threads that are used to execute tasks.
      ```java
      ExecutorService executor = Executors.newFixedThreadPool(3);
      for (int i = 0; i < 5; i++) {
         executor.submit(() -> {
            System.out.println("Task " + Thread.currentThread().getName());
         });
      }
      executor.shutdown();
      ```
      ``` html
      Task pool-1-thread-2
      Task pool-1-thread-3
      Task pool-1-thread-1
      Task pool-1-thread-3
      Task pool-1-thread-1
      ```
      - When you submit a task to a fixed-size thread pool, and all threads are busy executing other tasks, the task is added to the queue of pending tasks. The pending tasks will wait in the queue until a thread becomes available to execute them. 
      - If the queue becomes full and there are no available threads to execute tasks, the Executor will reject the task submission with a RejectedExecutionException. The rejection policy can be configured to throw an exception, block the calling thread, or discard the task, depending on the implementation of the Executor.
      
      3. `newCachedThreadPool() :` This type of thread pool is suitable for executing short-lived asynchronous tasks that do not have a fixed rate of arrival. It is also useful when the number of threads needed to handle the workload is not known in advance, as the thread pool will dynamically adjust the number of threads to handle the workload.

      ```java
      ExecutorService executor = Executors.newCachedThreadPool();
      for (int i = 0; i < 5; i++) {
         executor.submit(() -> {
            System.out.println("Task " + Thread.currentThread().getName());
         });
      }
      executor.shutdown();
      ```
      ```html
      Task pool-1-thread-3
      Task pool-1-thread-1
      Task pool-1-thread-2
      Task pool-1-thread-4
      Task pool-1-thread-5
      ```

      - The CachedThreadPoolExecutor uses a keep-alive time to determine when to remove idle threads. If a thread is idle for the specified keep-alive time, it is removed from the thread pool.

      4. `newScheduledThreadPool() :` This executor is used to schedule a task to run after a certain delay, or to run repeatedly at a fixed interval. This is useful for tasks that need to be run periodically or on a schedule.

      ```java
      ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
      // Schedule a task to run after 3 seconds
      executor.schedule(() -> System.out.println("Task executed after 3 seconds"), 3, TimeUnit.SECONDS);
      // Schedule a task to run repeatedly every 1 second
      executor.scheduleAtFixedRate(() -> System.out.println("Task executed every 1 second"), 0, 1, TimeUnit.SECONDS);
      ```
      ```html
      Task executed every 1 second
      Task executed every 1 second
      Task executed every 1 second
      Task executed after 3 seconds
      Task executed every 1 second
      Task executed every 1 second
      Task executed every 1 second
      Task executed every 1 second
      Task executed every 1 second
      Task executed every 1 second
      Task executed every 1 second
      Task executed every 1 second
      Task executed every 1 second
      Task executed every 1 second
      Task executed every 1 second
      .
      .
      . 
      ```

   - **newSingleThreadExecutor()** vs **newFixedThreadPool(1)**
      Main difference between the two is the type of queue used. `newSingleThreadExecutor()` uses an unbounded queue, while `Executors.newFixedThreadPool(1)` uses a fixed-size queue. If the application submits many tasks to the thread pool, the unbounded queue of `newSingleThreadExecutor()` can lead to out-of-memory errors, while the fixed-size queue of `Executors.newFixedThreadPool(1)` prevents the number of queued tasks from exceeding a certain limit.
   - **Future**
      In cases where you don’t want to wait for the result to be available, you can use the `submit()` method of the `Executor` interface to submit the `Callable` and obtain a `Future` object that represents the result of the computation.

      You can then use this `Future` object to check if the computation is complete or not using the `isDone()` method. If the computation is not complete, you can perform other tasks, and later retrieve the result of the computation using the `get()` method of the `Future` object.

      If you don’t want to wait for the result, you can simply discard the `Future` object without calling the `get()` method.

      ```java
      import java.util.concurrent.*;
      public class FutureExample {
         public static void main(String[] args) throws Exception {
            ExecutorService executor = Executors.newFixedThreadPool(2);
            Future<Integer> future = executor.submit(new Callable<Integer>() {
                  public Integer call() throws Exception {
                     Thread.sleep(5000);
                     return 42;
                  }
            });
            System.out.println("Other tasks running...");
            int result = future.get();
            System.out.println("Computation result: " + result);
            executor.shutdown();
         }
      }
      ```

   - **Cancelling a submitted Task**
      The `Future` interface returned by the `submit()` method has a `cancel()` method that can be used to cancel a task.

      ```java
      ExecutorService executor = Executors.newSingleThreadExecutor();

      Future<Integer> futureTask = executor.submit(() -> {
         // Simulate a long-running task
         Thread.sleep(5000);
         return 42;
      });

      // Try to cancel the task after 2 seconds
      boolean cancelled = futureTask.cancel(true);
      if (cancelled) {
         System.out.println("Task cancelled successfully.");
      } else {
         System.out.println("Task could not be cancelled.");
      }

      executor.shutdown();
      ```
      ```html
      Task cancelled successfully.
      ```

      The `cancel()` method takes a *boolean* argument that specifies whether the task should be interrupted *if it has already started running*. If the task has *not started running*, it will simply be *removed from the Executor's task queue*.

               
21. **What are checked and unchecked exceptions?**

   - **Checked Exceptions :**
      1. Checked exceptions are exceptions that must be either handled or declared in a method's `throws` clause.
      2. Checked Execptions are handled using `try-catch` block or by declaring them in a method's throws clause.
      3. Chceked Exceptions are caught at compile time.
      4. **Example :** IOException, FileNotFoundException, SQLException etc.

   - **Unchecked Exceptions :**
      1. Unchecked Exceptions are exceptions that are not checked by compiler and do not need to declared in method's throws clause.
      2. Unchecked Exceptions are also handled using `try-catch` block but they do not need to be declared in a method's throws clause.
      3. Unchecked Exception are caught by JVM at Runtime.
      4. **Example :** ArithmeticException, ArrayIndexOutOfBoundsException, NullPointerException etc.
   ```java 
   // Checked Exception Example
   public class CheckedException {
      public void readFile() throws FileNotFoundException {
         String fileName = "file does not exist";
         File file = new File(fileName);
         FileInputStream stream = new FileInputStream(file);
      }
   }

   // Unchecked Exception Example
   public class UncheckedException {
      public void divide() {
         int x = 0;
         int y = 10;
         int z = y / x;
      }
   }
   ```
   **Note :** Checked exceptions are typically used to handle logical errors in the program, while unchecked exceptions are used to handle runtime errors that are often caused by programming errors.


22. **How does the try-catch-finally block work?**

   - **try block :** The `try` block contains the code that may thorw and exception and if an exception occurs the rest of the try block is skipped and the control transfers to the attched `catch` block. In case no Execption is thrown `catch` block is skipped and the if there is any `finally` block attached the control will be transfered to that block.
   - **catch() block :** The `catch` block is used to handle the exception that might be thrown in the `try` block. cathc block takes the name of Exception it can handle as the parmeter and then if an exception occurs and matched the exceptions present in catch block parameter then the catch block is executed. In case the Exception can not be handled by the catch block, the default exception handling mechanism is invoked, and the program terminates abnormally.
   - **finally block :** The `finally` block is used to execute important code, such as closing connections or resources, no matter if the exception occurs or not. The finally block is always executed, whether an execption is handled or not; unless the program exits abruptly(e.g. by calling `System.exit()` or due to a fatal error). If an exception occur in `try` block and is handled by `catch` block then the `finally` block gets executed after the catch block.
   
   ```java
   try {
    // code that might throw an exception
    int result = 10 / 0;
      System.out.println("Inside try block");
   } catch (ArithmeticException e) {
      System.out.println("Exception caught in catch block");
   } finally {
      System.out.println("finally block executed");
   }
   System.out.println("Outside try-catch-finally clause");
   ```
   
   
23. **What is the difference between throw and throws?**

   - The `throw` keyword is used inside a method; and `throws` keyword is used in the method signature. 
   - The `throw` keyword throws an exception explicitly but the `throws` keyword decalres that the method might throw an exception.
   - `throw` keyword throws and instance of Exception class but `throws` define that the method will throw which of the exception class.
   - **Example :** 
      1. **throw :**
         ```java
         try {
         // code that might throw an exception
         int result = 10 / 0;
         throw new ArithmeticException();
         } catch (ArithmeticException e) {
            System.out.println("Exception caught in catch block");
         }
         ```
      2. **throws :**
         ```java
         public void withdraw(double amount) throws InsufficientBalanceException {
            if (balance < withdrawAmount) {
               throw new InsufficientBalanceException("You have insufficient balance");
            }
         }
         ```


24. **Explain the Java memory model.**

   - Java Memory Model(JMM) supervise/control **how threads in java interact with memory**. It ensures that **changes made by one thread visible to all others, providing a framework for safe multi-threading**. It also ensures proper synchronization using constructs(a block of code that initializes) like `synchronized` **blocks**, `volatile`. **and memory barriers.** 
   - JMM is responsible for preventing data races(i.e. threads accessing shared resource without suffiecient protection, leading to abnormal behaviour.) and ensures consistent behavior in multi-threaded Java program.

   - JMM has two main parts :
      1. # **THREAD STACK**
         - Each thread running has it's own stack and is k/a thread stack.
         - used to store Local varibales for primitive(int,long,double, etc.) types.
         - These thread stacks are not visible to other threads even if they are running the same piece of code.
         - they will create their own seperate copies of local variables for that code in their own thread stack.
         # Creation of Thread Stack :
         1. When thread is started, JRE creates a new empty thread stack for that thread.
         2. When thread calls any `methodA()`, JRE pushes a new Frame(Stack Frame- Data Structure used to store state of the method being executred.) onto thread stack. This frame stores the call stack and local variables for the methodA().
         3. When `method A()` call any other `method B()`,, JRE pushes another frame onto the thread stack to store the call stack and local varibales for the methodB().
         4. When methodB() returns, JRE pops the frame for methodB() off the thread stack. When methodA() returns, JRE pops the frame of it off the thread stack.

         # KEY FEATURES:
         1. **Dynamic Growth and Shrinkage :** Stack Memory grows and shrinks as new method are called and returned respectively as their new stack frame is created and removed respectively.
         2. **Limited Lifetime :** Varibales declared in the stack exists as long as the method that created them is running, once finish complete frace and local variable are deallocated.
         3. **Automatic Allocation and Deallocation:** Stack memory is automaticall allocated when method is called and deallocated when method finishes executing.
         4. **StackOverflowError :** if the stack becomes full due to excessive method calls(e.g. recursion without any base case), java throws `StackOverflowError`.
         5. **FAST ACCESS :** Stack memory offers fast access compared to Heap Memory because of its working mechanism i.e. Last-In First-Out(LIFO).
         6. **Thread Safety :** Each thread's, ,ethod and local variables are isolated with each other because they operates in their own stack.

      2. **HEAP MEMORY**
         - Heap is a separate meory area that contains all the objects created in a Java application, regardless of which thread created them.
         - This includes objects of primitive types(e.g. Integer, Long). 
         - Every object created is stored in heap, no matter if an object was created and assigned to a local variable or created as a member varible of another object.

         # Key Features : 
            1. **OutOfMemoryError :**
               - When heap space is full and become insufficient to allocate new objects, java throws and *OutOfMemoryError.*
               - Giving a real life example : loading a large dataset into memory or when there's a memory leak.
               ```java
               public class OutOfMemoryExample {
                  public static void main(String[] args) {
                     try {
                           // Attempt to create a very large array to fill up heap space
                           int[] bigArray = new int[Integer.MAX_VALUE];
                     } catch (OutOfMemoryError e) {
                           System.err.println("OutOfMemoryError: " + e.getMessage());
                     }
                  }
               }
               ```
            2. **Heap Memory Access is Slower Than Stack Memory :**
               - Heap Memory is slower because it involves dynamic memory allocation and deallocation manages by the Garbage Collector(GC).
               - Stack Memory acces is faster because it simply involves pushing and popping elements from the stack.

            3. **Heap Memory is not thread-safe :**
               - Heap memory is not inherently thread-safe, meaning that when multiple threads access and modify shared objects in the heap concurrently, it can lead to data races and inconsistent states.
               - Proper synchronization mechanisms like synchronized blocks, locks, or using thread-safe data structures from the java.util.concurrent package should be used to make heap-based data structures thread-safe.
            4. Object and their Member Variables, Static class Variables all are stores on the heap and can be accessed by all other threads.
               
   
25. **What is garbage collection, and how does it work?**
   - Garbage Collection is a memory recovery feature built into programming language such as C# and Java. A GC enables programming language includes one or more garbage collectors (GC engines) that automatically free up memory space taht has been alloocated to objects no longer needed by the program. Garbage Collector are used to allocated space in the Heap memory dynamically. Garbage collectors helps prevent meory leak and ensure memory used by program remain efficient and organized.
   - ### Working Of Garabage Collection :
      1. **Reference Counting :** Each object is created in the program is assigned a reference(where the object is connected) count. whenever any refrence gets connected with the object reference count is increased by one and when reference is removed or goes out of scope the count is decreased by one. if the count reaches Zero, then the object is considered garbage, eligible for garbage collection and can be freed.
      2. **Mark-and-Sweep Algorithm :** This algorithm works in two major phases-
            **Marking :** The GC traverse through the graph of objects and mark each objects if they are reachable by the roots(thread, static fields, local variables, and CPU registers).
            **Sweeping :** After marking each and every object, GC sweeps all the objects that are not marked reachable in the marking phase.
      3. **Generational Garbage Collection :** Heap memory have two types of generational space, `Young Generation` to store newly created young objects and `Old(Tenured) Generation` to store objects surpassed their maximum survival cycle according to `-XX:MaxTenuring Threshold` and are considered as old objects.
         `Young Generation` consists different spaces for objects; `Eden Space` to store fresh newly created objects, `Survivor 1` and `Survivor 2` to store objects survived when Eden Space gets full and `Minor GC` kicks in and collects the dead objects(objects unreachable) and move live objects(objects still reachable) in the survivor space and increase their survivor count by 1 and free up the Eden space to again store the newly created objects, again when it get full minor GC kicks in and collects all the dead objects from Eden Space and Survivor Space and Move the live objects from eden space and previously left objects in survivor space to another survivor space and increase their survivor count by 1 again and this process continues, when any objects reaches its `MaxTenuring Threshold` i.e. 6 and minor GC kicks in it complete its regular process and move objects to Old generation whose survivor count is equal to 6.
         - Why this process of moving Old Generation important is to avoid `Full GC` because its an evil situation and because of Generational Collection we try to avoid this situation upto certain extent. Whenever Old Generation space gets full it requires full GC and full GC requires to stop the application further its process gets completed i.e. why minor GC running is more frequent than Full GC.
      4. **Memory Compaction :** Memories are divided in fragments to and fragments gets utilised to store the object or resources in random fragments because of the fragmentation sometime even when there is free space we are not able to utilise it properly to avoid this situation we have a technique named as `Compaction ` i.e. the process of bringing all the occupied fragments together and leaving empty fragments together. 
      After the Garbage Collection, Garbage Collectore compacts the memory by moving all the reachable objects to a contiguous block, freeing up memory space and reducing fragmentation.
      5. **Object Identification :** Objects are identified as garbage when their refernce count becomes 0 and this happens when the object is no longer needed, becomes unreachable, or goes outof scope.
      6. **Object Reclamation :** The garbage collector reclaims the memory space by occupied by the garbage objects by cleaning up the garbage objects and allocate the space for future object creation. This process ensures that the memory used by the program remains efficient and organized.


26. **What are strong, weak, soft, and phantom references?**
   - **Strong References :** These are the defualt references used to prevent garabage collection to clean the object from the memory. All other references allows the object to be garbage collected in different scenerios. `String str = "abc"` creates string reference to the String object.
   - **Weak References :** These references do not prevent the object from being collected by the Garbage Collector as soon as the object becomes weakly reachable (only accessible by the weak references), it can be removed by the garabage collector from the memory. These refernces are commonly used for caching and canonicalizing mapping.
   - **Soft References :** These references are similar to weak references but they are cleared less aggressively by the garabage collector. Objects with soft references are only clear when the JVM is running low on memory. Soft references are useful for imp-lementing memory-sensitive cahces.
   - **Phantom References :** These are the weakest type of references and they do not prevent the object from being collected by the GC and also they do provide a way to access the object. Phantom references are enqueued with a ReferenceQueue after an object has been collected. they are useful for scheduling post-mortem cleanup actions and detecting when an object has been garbage collected.

27. **Explain lambda expressions and functional interfaces in Java 8.**

   - **Lambda Expression :** Lambda expression are the annonymous functions use to implement functional interfaces(interfaces with a single abstract method). Lambda expressions are used to reduce boilerplate code and make the code more concise and readable.
      Lambda Expressions mainly concists of three parts :
      - **Parameter List :** list of parameters that the lambda expressions accepts and are enclosed with parantheses '()'.
      - **Arrow Operator :** An arrow operator ' -> ' to separate parameter list from the lambda body.
      - **Lambda Body :** Lambda body is the code that is executed when the lambda expression is invoked. It Can be a single statement or a block of statements.
   ```java
   int square = (int x) -> x*x ;
   ```

   - **Functional Interfaces :** Functional interfaces only have a single abstract method. This means the interface implementation will only represent one behaviour. `Runnable` , `Callable` , `Comparator` , and `Function` are the example of functional interfaces.
   ```java
   @FunctionalInterface
   public interface SquareRoot {
      double findSquareRoot(int n);
   }
   ```

28. **What are streams in Java 8, and how do you use them?**
   - Stream is the concept introduced in java 8, provides a way to process collections of objects in a functional style and is a part of Java collection framework. They allow to process sequences of elements in a functional style, providing a powerful and efficient way to perform operations on collection of data.
   - **Key Characteristics of Streams:**
      1. **Sequence of Elements:** STream represents sequences of elements froma source(data whose stream is created) such as collection, an array, or an I/O channel.
      2. **Functional in Nature:** Stream supports Functional-style operations, making extensive use of lambda expressions.
      3. **Pipelined Processing:** Stream operations can be chained together to form a pipeline. Intermediate operations are lazy and are not executed until a terminal operation is invoked.
      4. **Parallelizable:** Streams can be processed in parallel without having to explicitly manage thread creation and synchronization.
   - **Types of Stream Operations:**
      1. **Intermediate Operations:** These operations transform a stream into another stream and are lazy, meaning they are not executed until a terminal operation is called. Example include `map()`, `filter()`, `distinct()`, `sorted()`, and `limit()`.
      2. **Terminal Opertaions:** These operations produce a result or side-effect and are executed once on the entire stream pipeline. Example include `forEach()`, `collect()`, `reduce()`, `count()`, and `anyMatch()`.
   - ```java
      import java.util.Arrays;
      import java.util.List;
      import java.util.stream.Collectors;

      public class StreamExample {
         public static void main(String[] args) {
            List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");

            // Using stream to filter, map, and collect
            List<String> filteredNames = names.stream()
                                                .filter(name -> name.length() > 3)
                                                .map(String::toUpperCase)
                                                .sorted()
                                                .collect(Collectors.toList());

            // Printing the result
            filteredNames.forEach(System.out::println);
         }
      }
      // In this example, we filter the names with length greater than 3, convert them to uppercase, sort them, and then collect the result into a list which is printed out.
      ```

29. **How do Optional and the new date/time API work in Java 8?**
   - **Optional Class:**
      Optional class is a container object used to contain non-null values. it is primarily intended to represent the absence and presence of a value and to avoid `NullPointerException`.
     - **Key Methods Of Optional:**
        1. **Creating an Optional:**
           - `Optional.of(value)`: Creates an Optional with a non-null value.
           - `Optional.ofNullable(value)`: Creates an Optional that may contain a null value.
           - `Optional.empty()`: Creates an empty Optional.
           - ```java
              Optional<String> nonEmptyOptional = Optional.of("Hello");
              Optional<String> nullableOptional = Optional.ofNullable(null);
              Optional<String> emptyOptional = Optional.empty();
              ```
        2. **Checking For Value Presence:**
           - `isPresent()`: Returns true if the value is present.
           - `ifPresent(Consumer<? super T> consumer)`: Executes the given consumer if a value is present.
           - ```java
              if (nonEmptyOptional.isPresent()) {
                 System.out.println(nonEmptyOptional.get());
              }

              nullableOptional.ifPresent(value -> System.out.println(value));
              ```

        3. **Retrieving the Value:**
           - `get()`: Returns the value if present, otherwise throws NoSuchElementException.
           - `orElse(T other)`: Returns the value if present, otherwise returns other.
           - `orElseGet(Supplier<? extends T> other)`: Returns the value if present, otherwise invokes the supplier and returns its result.
           - `orElseThrow(Supplier<? extends X> exceptionSupplier)`: Returns the value if present, otherwise throws an exception created by the supplier.
           - ```java
              String value = nullableOptional.orElse("default");
              String valueFromSupplier = nullableOptional.orElseGet(() -> "default from supplier");
              String valueOrException = nullableOptional.orElseThrow(() -> new IllegalArgumentException("No value present"));
              ```
   - **New Date/Time API :**  
      The new date/time API in Java 8, found in the java.time package, offers a comprehensive and consistent approach to handling dates and times. It is designed to overcome the limitations of the old java.util.Date and java.util.Calendar classes.

      - **Key Classes in java.time:**
         1. **LocalDate, LocalTime, LocalDateTime:**
            - `LocalDate`: Represents a date (year, month, day) without time and timezone.
            - `LocalTime`: Represents a time (hours, minutes, seconds, nanoseconds) without date and timezone.
            - `LocalDateTime`: Represents both date and time without timezone.
            - ```java
               LocalDate date = LocalDate.now();
               LocalTime time = LocalTime.now();
               LocalDateTime dateTime = LocalDateTime.now();

               LocalDate specificDate = LocalDate.of(2024, 6, 13);
               LocalTime specificTime = LocalTime.of(14, 30);
               LocalDateTime specificDateTime = LocalDateTime.of(2024, 6, 13, 14, 30);
               ```
         2. **ZonedDateTime:**
            - Represents a date and time with a timezone.
            - ```java
               ZonedDateTime zonedDateTime = ZonedDateTime.now();
               ZonedDateTime specificZonedDateTime = ZonedDateTime.of(2024, 6, 13, 14, 30, 0, 0, ZoneId.of("UTC"));
               ```
         3. **Period and Duration:**
            - `Period`: Represents a date-based amount of time (years, months, days).
            - `Duration`: Represents a time-based amount of time (hours, minutes, seconds, nanoseconds).
            - ```java
               Period period = Period.ofDays(10);
               Duration duration = Duration.ofHours(5);
               ```
         4. **Formatting and Parsing:**
            - The DateTimeFormatter class is used to format and parse date-time objects.
            - ```java
               DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
               String formattedDateTime = specificDateTime.format(formatter);
               LocalDateTime parsedDateTime = LocalDateTime.parse("13-06-2024 14:30", formatter);
               ```
         



30. **What are the Singleton, Factory, Builder, and Observer design patterns?**
   - 
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
