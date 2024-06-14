- **Asked in Roche Holding AG (Pharmaceutical Company)**
  - Role : Java Developer 1 Yr. Exp.

1. **Question :** Implement a thread-safe Singleton class in Java using the double-checked locking.

**Solution:** To create a thread-safe Singleton class using double-checked locking in Java, we have to follow below steps:

- Declare a private static volatile instance variable.
- Define a private constructor to prevent instantiation from outside the class.
- Implement a public static method that returns the Singleton instance, using double-checked locking.

Implementation:

```java
public class Singleton {
// Volatile keyword ensures that changes to the uniqueInstance variable are visible to all threads.
    private static volatile Singleton uniqueInstance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (uniqueInstance == null) { // First check (without locking)
            synchronized (Singleton.class) {
                if (uniqueInstance == null) { // Second check (with locking)
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
}
```

2. 𝐇𝐨𝐰 𝐭𝐨 𝐩𝐫𝐞𝐯𝐞𝐧𝐭 𝐒𝐢𝐧𝐠𝐥𝐞𝐭𝐨𝐧 𝐏𝐚𝐭𝐭𝐞𝐫𝐧 𝐟𝐫𝐨𝐦 𝐂𝐥𝐨𝐧𝐢𝐧𝐠 - (𝐀𝐬𝐤𝐞𝐝 𝐢𝐧 𝐃𝐞𝐥𝐨𝐢𝐭𝐭𝐞)  
   **Solution :** Singleton Design pattern ensures that there is only one instance of a class created in the application. This is achieved by making the constructor private and providing a public static method to access the instance.

   Singleton design pattern is broken when the class implements the Cloneable interface. This is because the clone() method can be used to create multiple instances of the class, which violates the singleton design pattern. To handle this, we can override clone() method and throw an exception from clone method that is 𝐂𝐥𝐨𝐧𝐞𝐍𝐨𝐭𝐒𝐮𝐩𝐩𝐨𝐫𝐭𝐞𝐝𝐄𝐱𝐜𝐞𝐩𝐭𝐢𝐨𝐧. Now, whenever user will try to create clone of singleton object, it will throw an exception and hence our class remains singleton.

   ```java
   public class Singleton {

       private static Singleton instance;

       private Singleton() {
       }

       public static synchronized Singleton getInstance() {
           if (instance == null) {
               instance = new Singleton();
           }
           return instance;
       }

       @Override
       protected Object clone() throws CloneNotSupportedException {
           throw new CloneNotSupportedException("Cloning is not allowed.");
       }
   }
   ```

   We can also return the same instance from the clone method instead of throwing exception.
