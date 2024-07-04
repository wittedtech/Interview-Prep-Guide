### Coding Questions 
 
1. **Implement the Singleton pattern in Java.** 

```java
public class Singleton {
    private static volatile Singleton instance;

    private Singleton() {
        // private constructor to prevent instantiation
    }

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
 
2. **Write a program to demonstrate the Factory Method pattern.** 

```java
// Product interface
interface Product {
    void use();
}

// Concrete products
class ConcreteProductA implements Product {
    public void use() {
        System.out.println("Using Product A");
    }
}

class ConcreteProductB implements Product {
    public void use() {
        System.out.println("Using Product B");
    }
}

// Creator
abstract class Creator {
    public abstract Product createProduct();
}

// Concrete creators
class ConcreteCreatorA extends Creator {
    public Product createProduct() {
        return new ConcreteProductA();
    }
}

class ConcreteCreatorB extends Creator {
    public Product createProduct() {
        return new ConcreteProductB();
    }
}

public class FactoryMethodDemo {
    public static void main(String[] args) {
        Creator creatorA = new ConcreteCreatorA();
        Product productA = creatorA.createProduct();
        productA.use();

        Creator creatorB = new ConcreteCreatorB();
        Product productB = creatorB.createProduct();
        productB.use();
    }
}
```
 
3. **Design a system using the Abstract Factory pattern for creating different types of vehicles (car, bike, truck) with different factories for each type.** 

```java
// Abstract products
interface Car {
    void drive();
}

interface Bike {
    void ride();
}

interface Truck {
    void haul();
}

// Concrete products
class SedanCar implements Car {
    public void drive() {
        System.out.println("Driving a sedan car");
    }
}

class SportsCar implements Car {
    public void drive() {
        System.out.println("Driving a sports car");
    }
}

class MountainBike implements Bike {
    public void ride() {
        System.out.println("Riding a mountain bike");
    }
}

class RoadBike implements Bike {
    public void ride() {
        System.out.println("Riding a road bike");
    }
}

class PickupTruck implements Truck {
    public void haul() {
        System.out.println("Hauling with a pickup truck");
    }
}

class HeavyTruck implements Truck {
    public void haul() {
        System.out.println("Hauling with a heavy truck");
    }
}

// Abstract factory
interface VehicleFactory {
    Car createCar();
    Bike createBike();
    Truck createTruck();
}

// Concrete factories
class BasicVehicleFactory implements VehicleFactory {
    public Car createCar() {
        return new SedanCar();
    }

    public Bike createBike() {
        return new MountainBike();
    }

    public Truck createTruck() {
        return new PickupTruck();
    }
}

class LuxuryVehicleFactory implements VehicleFactory {
    public Car createCar() {
        return new SportsCar();
    }

    public Bike createBike() {
        return new RoadBike();
    }

    public Truck createTruck() {
        return new HeavyTruck();
    }
}

public class AbstractFactoryDemo {
    public static void main(String[] args) {
        VehicleFactory basicFactory = new BasicVehicleFactory();
        Car basicCar = basicFactory.createCar();
        Bike basicBike = basicFactory.createBike();
        Truck basicTruck = basicFactory.createTruck();

        basicCar.drive();
        basicBike.ride();
        basicTruck.haul();

        VehicleFactory luxuryFactory = new LuxuryVehicleFactory();
        Car luxuryCar = luxuryFactory.createCar();
        Bike luxuryBike = luxuryFactory.createBike();
        Truck luxuryTruck = luxuryFactory.createTruck();

        luxuryCar.drive();
        luxuryBike.ride();
        luxuryTruck.haul();
    }
}
```
 
4. **Implement the Builder pattern to create a complex object like a House with different attributes (rooms, doors, windows).** 

```java
class House {
    private int rooms;
    private int doors;
    private int windows;

    public static class Builder {
        private int rooms;
        private int doors;
        private int windows;

        public Builder setRooms(int rooms) {
            this.rooms = rooms;
            return this;
        }

        public Builder setDoors(int doors) {
            this.doors = doors;
            return this;
        }

        public Builder setWindows(int windows) {
            this.windows = windows;
            return this;
        }

        public House build() {
            return new House(this);
        }
    }

    private House(Builder builder) {
        this.rooms = builder.rooms;
        this.doors = builder.doors;
        this.windows = builder.windows;
    }

    @Override
    public String toString() {
        return "House [rooms=" + rooms + ", doors=" + doors + ", windows=" + windows + "]";
    }
}

public class BuilderPatternDemo {
    public static void main(String[] args) {
        House house = new House.Builder()
            .setRooms(4)
            .setDoors(2)
            .setWindows(8)
            .build();

        System.out.println(house);
    }
}
```
 
5. **Write a Java program to demonstrate the Adapter pattern by adapting a legacy system to a new interface.** 

```java
// Legacy system
class LegacyRectangle {
    public void draw(int x1, int y1, int x2, int y2) {
        System.out.println("Rectangle from (" + x1 + ", " + y1 + ") to (" + x2 + ", " + y2 + ")");
    }
}

// Target interface
interface Shape {
    void draw(int x, int y, int width, int height);
}

// Adapter
class RectangleAdapter implements Shape {
    private LegacyRectangle legacyRectangle;

    public RectangleAdapter(LegacyRectangle legacyRectangle) {
        this.legacyRectangle = legacyRectangle;
    }

    public void draw(int x, int y, int width, int height) {
        int x1 = x;
        int y1 = y;
        int x2 = x + width;
        int y2 = y + height;
        legacyRectangle.draw(x1, y1, x2, y2);
    }
}

public class AdapterPatternDemo {
    public static void main(String[] args) {
        LegacyRectangle legacyRectangle = new LegacyRectangle();
        Shape rectangle = new RectangleAdapter(legacyRectangle);
        rectangle.draw(10, 20, 30, 40);
    }
}
```
 
6. **Create a simple example of the Decorator pattern to add behavior to an existing object dynamically.** 

```java
// Component interface
interface Coffee {
    String getDescription();
    double getCost();
}

// Concrete component
class SimpleCoffee implements Coffee {
    public String getDescription() {
        return "Simple coffee";
    }

    public double getCost() {
        return 5.0;
    }
}

// Decorator
abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee coffee) {
        this.decoratedCoffee = coffee;
    }

    public String getDescription() {
        return decoratedCoffee.getDescription();
    }

    public double getCost() {
        return decoratedCoffee.getCost();
    }
}

// Concrete decorators
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    public String getDescription() {
        return decoratedCoffee.getDescription() + ", milk";
    }

    public double getCost() {
        return decoratedCoffee.getCost() + 1.0;
    }
}

class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    public String getDescription() {
        return decoratedCoffee.getDescription() + ", sugar";
    }

    public double getCost() {
        return decoratedCoffee.getCost() + 0.5;
    }
}

public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        System.out.println(coffee.getDescription() + " $" + coffee.getCost());

        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.getDescription() + " $" + coffee.getCost());

        coffee = new SugarDecorator(coffee);
        System.out.println(coffee.getDescription() + " $" + coffee.getCost());
    }
}
```
 
7. **Implement the Observer pattern in Java to demonstrate a simple event handling system.** 

```java
import java.util.ArrayList;
import java.util.List;

// Observer interface
interface Observer {
    void update(String message);
}

// Subject class
class Subject {
    private List<Observer> observers = new ArrayList<>();
    private String message;

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public void setMessage(String message) {
        this.message = message;
        notifyObservers();
    }
}

// Concrete observers
class ConcreteObserver1 implements Observer {
    public void update(String message) {
        System.out.println("Observer 1 received: " + message);
    }
}

class ConcreteObserver2 implements Observer {
    public void update(String message) {
        System.out.println("Observer 2 received: " + message);
    }
}

public class ObserverPatternDemo {
    public static void main(String[] args) {
        Subject subject = new Subject();

        Observer observer1 = new ConcreteObserver1();
        Observer observer2 = new ConcreteObserver2();

        subject.addObserver(observer1);
        subject.addObserver(observer2);

        subject.setMessage("Hello, Observers!");
    }
}
```
