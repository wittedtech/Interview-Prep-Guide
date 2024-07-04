### Scenario-Based Questions and Answers 
 
1. **How would you implement a logger system where different parts of your application can log messages without being tightly coupled to the logging mechanism?**

Use the Observer pattern to implement a logging system where different parts of the application can register as observers to log messages.


```java
public interface Logger {
    void log(String message);
}

public class ConsoleLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println(message);
    }
}

public class LogManager {
    private final List<Logger> loggers = new ArrayList<>();

    public void addLogger(Logger logger) {
        loggers.add(logger);
    }

    public void log(String message) {
        for (Logger logger : loggers) {
            logger.log(message);
        }
    }
}
```
 
2. **Design a document editor application that allows users to apply different formatting styles (like bold, italic, underline) to text dynamically.**

Use the Decorator pattern to dynamically add formatting to text.


```java
public interface Text {
    String getText();
}

public class PlainText implements Text {
    private final String text;

    public PlainText(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return text;
    }
}

public abstract class TextDecorator implements Text {
    protected final Text decoratedText;

    public TextDecorator(Text decoratedText) {
        this.decoratedText = decoratedText;
    }

    @Override
    public String getText() {
        return decoratedText.getText();
    }
}

public class BoldText extends TextDecorator {
    public BoldText(Text decoratedText) {
        super(decoratedText);
    }

    @Override
    public String getText() {
        return "<b>" + super.getText() + "</b>";
    }
}

public class ItalicText extends TextDecorator {
    public ItalicText(Text decoratedText) {
        super(decoratedText);
    }

    @Override
    public String getText() {
        return "<i>" + super.getText() + "</i>";
    }
}
```
 
3. **You need to build a GUI framework that supports adding, removing, and rendering nested components like panels, buttons, and text fields. Which design pattern(s) would you use and why?**

Use the Composite pattern to allow nested components and the Visitor pattern for rendering.


```java
public interface Component {
    void render();
}

public class Button implements Component {
    @Override
    public void render() {
        System.out.println("Render Button");
    }
}

public class Panel implements Component {
    private final List<Component> components = new ArrayList<>();

    public void addComponent(Component component) {
        components.add(component);
    }

    public void removeComponent(Component component) {
        components.remove(component);
    }

    @Override
    public void render() {
        System.out.println("Render Panel");
        for (Component component : components) {
            component.render();
        }
    }
}
```
 
4. **Imagine you are designing a notification system that can send alerts via email, SMS, and push notifications. How would you structure your classes using design patterns?**

Use the Strategy pattern to define different notification methods and the Factory Method pattern to create the appropriate notification object based on the type.


```java
public interface NotificationStrategy {
    void send(String message);
}

public class EmailNotification implements NotificationStrategy {
    @Override
    public void send(String message) {
        System.out.println("Send email: " + message);
    }
}

public class SMSNotification implements NotificationStrategy {
    @Override
    public void send(String message) {
        System.out.println("Send SMS: " + message);
    }
}

public class PushNotification implements NotificationStrategy {
    @Override
    public void send(String message) {
        System.out.println("Send push notification: " + message);
    }
}

public abstract class NotificationFactory {
    public abstract NotificationStrategy createNotification();
}

public class EmailNotificationFactory extends NotificationFactory {
    @Override
    public NotificationStrategy createNotification() {
        return new EmailNotification();
    }
}

public class SMSNotificationFactory extends NotificationFactory {
    @Override
    public NotificationStrategy createNotification() {
        return new SMSNotification();
    }
}

public class PushNotificationFactory extends NotificationFactory {
    @Override
    public NotificationStrategy createNotification() {
        return new PushNotification();
    }
}
```
 
5. **How would you implement a system that parses and interprets mathematical expressions like (3 + 5) * 2?**

Use the Interpreter pattern to represent the grammar of the expressions and evaluate them.


```java
public interface Expression {
    int interpret();
}

public class Number implements Expression {
    private final int number;

    public Number(int number) {
        this.number = number;
    }

    @Override
    public int interpret() {
        return number;
    }
}

public class Add implements Expression {
    private final Expression left;
    private final Expression right;

    public Add(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret() {
        return left.interpret() + right.interpret();
    }
}

public class Multiply implements Expression {
    private final Expression left;
    private final Expression right;

    public Multiply(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret() {
        return left.interpret() * right.interpret();
    }
}
```
 
6. **You are tasked with building a report generator that supports multiple formats (PDF, Excel, HTML). How would you design this system?**

Use the Abstract Factory pattern to create different report formats and the Template Method pattern for the common report generation steps.


```java
public interface Report {
    void generate(String data);
}

public class PDFReport implements Report {
    @Override
    public void generate(String data) {
        System.out.println("Generate PDF report with data: " + data);
    }
}

public class ExcelReport implements Report {
    @Override
    public void generate(String data) {
        System.out.println("Generate Excel report with data: " + data);
    }
}

public class HTMLReport implements Report {
    @Override
    public void generate(String data) {
        System.out.println("Generate HTML report with data: " + data);
    }
}

public abstract class ReportFactory {
    public abstract Report createReport();
}

public class PDFReportFactory extends ReportFactory {
    @Override
    public Report createReport() {
        return new PDFReport();
    }
}

public class ExcelReportFactory extends ReportFactory {
    @Override
    public Report createReport() {
        return new ExcelReport();
    }
}

public class HTMLReportFactory extends ReportFactory {
    @Override
    public Report createReport() {
        return new HTMLReport();
    }
}
```
 
7. **Design a vending machine that supports multiple payment methods (cash, credit card, mobile payment) and can dispense different products.**

Use the Strategy pattern for payment methods and the Factory Method pattern for creating products.


```java
public interface PaymentStrategy {
    void pay(int amount);
}

public class CashPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Paid with cash: " + amount);
    }
}

public class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Paid with credit card: " + amount);
    }
}

public class MobilePayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Paid with mobile payment: " + amount);
    }
}

public interface Product {
    void dispense();
}

public class Snack implements Product {
    @Override
    public void dispense() {
        System.out.println("Dispense snack");
    }
}

public class Drink implements Product {
    @Override
    public void dispense() {
        System.out.println("Dispense drink");
    }
}

public abstract class ProductFactory {
    public abstract Product createProduct();
}

public class SnackFactory extends ProductFactory {
    @Override
    public Product createProduct() {
        return new Snack();
    }
}

public class DrinkFactory extends ProductFactory {
    @Override
    public Product createProduct() {
        return new Drink();
    }
}

public class VendingMachine {
    private PaymentStrategy paymentStrategy;
    private ProductFactory productFactory;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void setProductFactory(ProductFactory productFactory) {
        this.productFactory = productFactory;
    }

    public void purchaseProduct(int amount) {
        paymentStrategy.pay(amount);
        Product product = productFactory.createProduct();
        product.dispense();
    }
}
```
 
8. **How would you create a file system structure that supports directories containing files and other directories?**

Use the Composite pattern to represent the file system structure.


```java
public interface FileSystemComponent {
    void display();
}

public class File implements FileSystemComponent {
    private final String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void display() {
        System.out.println("File: " + name);
    }
}

public class Directory implements FileSystemComponent {
    private final String name;
    private final List<FileSystemComponent> components = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    public void addComponent(FileSystemComponent component) {
        components.add(component);
    }

    public void removeComponent(FileSystemComponent component) {
        components.remove(component);
    }

    @Override
    public void display() {
        System.out.println("Directory: " + name);
        for (FileSystemComponent component : components) {
            component.display();
        }
    }
}
```
 
9. **Imagine you are developing a game where characters can equip different weapons and armor. How would you implement this using design patterns?**

Use the Strategy pattern for different weapons and armor, and the Decorator pattern for combining multiple items.


```java
public interface Weapon {
    void use();
}

public class Sword implements Weapon {
    @Override
    public void use() {
        System.out.println("Swing sword");
    }
}

public class Bow implements Weapon {
    @Override
    public void use() {
        System.out.println("Shoot arrow");
    }
}

public interface Armor {
    void wear();
}

public class Shield implements Armor {
    @Override
    public void wear() {
        System.out.println("Wear shield");
    }
}

public class Helmet implements Armor {
    @Override
    public void wear() {
        System.out.println("Wear helmet");
    }
}

public class Character {
    private Weapon weapon;
    private Armor armor;

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public void fight() {
        weapon.use();
        armor.wear();
    }
}
```
 
10. **How would you design a plugin architecture for a software application that allows new functionalities to be added without modifying the core application?**

Use the Plugin pattern, which is a variation of the Factory Method pattern. Create an interface for plugins and load them dynamically.


```java
public interface Plugin {
    void execute();
}

public class PluginManager {
    private final List<Plugin> plugins = new ArrayList<>();

    public void registerPlugin(Plugin plugin) {
        plugins.add(plugin);
    }

    public void executePlugins() {
        for (Plugin plugin : plugins) {
            plugin.execute();
        }
    }
}
```
 
11. **You need to create a scheduling system that supports different scheduling algorithms (e.g., FIFO, Round Robin, Priority). Which design patterns would you use and why?**

Use the Strategy pattern to define different scheduling algorithms and encapsulate them.


```java
public interface SchedulingStrategy {
    void schedule(List<Task> tasks);
}

public class FIFOScheduling implements SchedulingStrategy {
    @Override
    public void schedule(List<Task> tasks) {
        // FIFO scheduling logic
    }
}

public class RoundRobinScheduling implements SchedulingStrategy {
    @Override
    public void schedule(List<Task> tasks) {
        // Round Robin scheduling logic
    }
}

public class PriorityScheduling implements SchedulingStrategy {
    @Override
    public void schedule(List<Task> tasks) {
        // Priority scheduling logic
    }
}

public class Scheduler {
    private SchedulingStrategy strategy;

    public void setStrategy(SchedulingStrategy strategy) {
        this.strategy = strategy;
    }

    public void scheduleTasks(List<Task> tasks) {
        strategy.schedule(tasks);
    }
}
```
 
12. **Design an e-commerce system where products can have various types of discounts (e.g., percentage, fixed amount, buy one get one free). How would you structure this using design patterns?**

Use the Strategy pattern to define different discount types and apply them.


```java
public interface DiscountStrategy {
    double applyDiscount(double price);
}

public class PercentageDiscount implements DiscountStrategy {
    private final double percentage;

    public PercentageDiscount(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public double applyDiscount(double price) {
        return price * (1 - percentage / 100);
    }
}

public class FixedAmountDiscount implements DiscountStrategy {
    private final double amount;

    public FixedAmountDiscount(double amount) {
        this.amount = amount;
    }

    @Override
    public double applyDiscount(double price) {
        return price - amount;
    }
}

public class BuyOneGetOneFreeDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double price) {
        return price / 2; // Simplified for single item
    }
}

public class Product {
    private final double price;
    private DiscountStrategy discountStrategy;

    public Product(double price) {
        this.price = price;
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double getPrice() {
        return discountStrategy != null ? discountStrategy.applyDiscount(price) : price;
    }
}
```
 
13. **How would you implement a system for handling different types of user authentication (e.g., username/password, OAuth, biometrics) in a scalable way?**

Use the Strategy pattern for different authentication methods and the Factory Method pattern for creating authentication objects.


```java
public interface AuthenticationStrategy {
    boolean authenticate(String credentials);
}

public class UsernamePasswordAuthentication implements AuthenticationStrategy {
    @Override
    public boolean authenticate(String credentials) {
        // Username/password authentication logic
        return true;
    }
}

public class OAuthAuthentication implements AuthenticationStrategy {
    @Override
    public boolean authenticate(String credentials) {
        // OAuth authentication logic
        return true;
    }
}

public class BiometricAuthentication implements AuthenticationStrategy {
    @Override
    public boolean authenticate(String credentials) {
        // Biometric authentication logic
        return true;
    }
}

public abstract class AuthenticationFactory {
    public abstract AuthenticationStrategy createAuthentication();
}

public class UsernamePasswordFactory extends AuthenticationFactory {
    @Override
    public AuthenticationStrategy createAuthentication() {
        return new UsernamePasswordAuthentication();
    }
}

public class OAuthFactory extends AuthenticationFactory {
    @Override
    public AuthenticationStrategy createAuthentication() {
        return new OAuthAuthentication();
    }
}

public class BiometricFactory extends AuthenticationFactory {
    @Override
    public AuthenticationStrategy createAuthentication() {
        return new BiometricAuthentication();
    }
}
```
 
14. **You need to build a chat application that supports text, image, and video messages. How would you design this using design patterns?**

Use the Factory Method pattern for creating different message types and the Visitor pattern for handling them.


```java
public interface Message {
    void accept(MessageVisitor visitor);
}

public class TextMessage implements Message {
    private final String text;

    public TextMessage(String text) {
        this.text = text;
    }

    @Override
    public void accept(MessageVisitor visitor) {
        visitor.visit(this);
    }

    public String getText() {
        return text;
    }
}

public class ImageMessage implements Message {
    private final String imageUrl;

    public ImageMessage(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public void accept(MessageVisitor visitor) {
        visitor.visit(this);
    }

    public String getImageUrl() {
        return imageUrl;
    }
}

public class VideoMessage implements Message {
    private final String videoUrl;

    public VideoMessage(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    @Override
    public void accept(MessageVisitor visitor) {
        visitor.visit(this);
    }

    public String getVideoUrl() {
        return videoUrl;
    }
}

public interface MessageVisitor {
    void visit(TextMessage textMessage);
    void visit(ImageMessage imageMessage);
    void visit(VideoMessage videoMessage);
}

public class MessageProcessor implements MessageVisitor {
    @Override
    public void visit(TextMessage textMessage) {
        System.out.println("Processing text message: " + textMessage.getText());
    }

    @Override
    public void visit(ImageMessage imageMessage) {
        System.out.println("Processing image message: " + imageMessage.getImageUrl());
    }

    @Override
    public void visit(VideoMessage videoMessage) {
        System.out.println("Processing video message: " + videoMessage.getVideoUrl());
    }
}

public abstract class MessageFactory {
    public abstract Message createMessage(String content);
}

public class TextMessageFactory extends MessageFactory {
    @Override
    public Message createMessage(String content) {
        return new TextMessage(content);
    }
}

public class ImageMessageFactory extends MessageFactory {
    @Override
    public Message createMessage(String content) {
        return new ImageMessage(content);
    }
}

public class VideoMessageFactory extends MessageFactory {
    @Override
    public Message createMessage(String content) {
        return new VideoMessage(content);
    }
}
```
 
15. **Design a banking system where different types of accounts (e.g., savings, checking, loan) can be created, and each type of account has its own set of operations.**

Use the Factory Method pattern for creating different account types and the Strategy pattern for account operations.


```java
public interface Account {
    void performOperation();
}

public class SavingsAccount implements Account {
    @Override
    public void performOperation() {
        System.out.println("Perform savings account operation");
    }
}

public class CheckingAccount implements Account {
    @Override
    public void performOperation() {
        System.out.println("Perform checking account operation");
    }
}

public class LoanAccount implements Account {
    @Override
    public void performOperation() {
        System.out.println("Perform loan account operation");
    }
}

public abstract class AccountFactory {
    public abstract Account createAccount();
}

public class SavingsAccountFactory extends AccountFactory {
    @Override
    public Account createAccount() {
        return new SavingsAccount();
    }
}

public class CheckingAccountFactory extends AccountFactory {
    @Override
    public Account createAccount() {
        return new CheckingAccount();
    }
}

public class LoanAccountFactory extends AccountFactory {
    @Override
    public Account createAccount() {
        return new LoanAccount();
    }
}
```



 
16. **How would you implement a payment gateway that can interact with different payment processors (e.g., PayPal, Stripe, Square) using design patterns?**

Use the Strategy pattern to encapsulate different payment processors and the Factory Method pattern to create payment processor instances.


```java
public interface PaymentProcessor {
    void processPayment(double amount);
}

public class PayPalProcessor implements PaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment with PayPal: " + amount);
    }
}

public class StripeProcessor implements PaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment with Stripe: " + amount);
    }
}

public class SquareProcessor implements PaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment with Square: " + amount);
    }
}

public abstract class PaymentProcessorFactory {
    public abstract PaymentProcessor createProcessor();
}

public class PayPalFactory extends PaymentProcessorFactory {
    @Override
    public PaymentProcessor createProcessor() {
        return new PayPalProcessor();
    }
}

public class StripeFactory extends PaymentProcessorFactory {
    @Override
    public PaymentProcessor createProcessor() {
        return new StripeProcessor();
    }
}

public class SquareFactory extends PaymentProcessorFactory {
    @Override
    public PaymentProcessor createProcessor() {
        return new SquareProcessor();
    }
}
```
 
17. **Design a hotel booking system that allows users to search for available rooms, make reservations, and cancel bookings. Which design patterns would you use and why?**

Use the Facade pattern to simplify the interaction with the booking system, the Factory Method pattern to create reservations, and the Observer pattern to notify users of booking status changes.


```java
public interface Room {
    void book();
    void cancel();
}

public class SingleRoom implements Room {
    @Override
    public void book() {
        System.out.println("Single room booked");
    }

    @Override
    public void cancel() {
        System.out.println("Single room booking canceled");
    }
}

public class DoubleRoom implements Room {
    @Override
    public void book() {
        System.out.println("Double room booked");
    }

    @Override
    public void cancel() {
        System.out.println("Double room booking canceled");
    }
}

public abstract class RoomFactory {
    public abstract Room createRoom();
}

public class SingleRoomFactory extends RoomFactory {
    @Override
    public Room createRoom() {
        return new SingleRoom();
    }
}

public class DoubleRoomFactory extends RoomFactory {
    @Override
    public Room createRoom() {
        return new DoubleRoom();
    }
}

public class BookingSystemFacade {
    private final RoomFactory singleRoomFactory = new SingleRoomFactory();
    private final RoomFactory doubleRoomFactory = new DoubleRoomFactory();

    public void bookSingleRoom() {
        Room room = singleRoomFactory.createRoom();
        room.book();
    }

    public void bookDoubleRoom() {
        Room room = doubleRoomFactory.createRoom();
        room.book();
    }

    public void cancelSingleRoom() {
        Room room = singleRoomFactory.createRoom();
        room.cancel();
    }

    public void cancelDoubleRoom() {
        Room room = doubleRoomFactory.createRoom();
        room.cancel();
    }
}
```
 
18. **How would you implement a recommendation system that provides personalized recommendations based on user behavior using design patterns?**

Use the Strategy pattern for different recommendation algorithms and the Observer pattern to track user behavior.


```java
public interface RecommendationStrategy {
    List<String> recommend(List<String> items, String user);
}

public class CollaborativeFiltering implements RecommendationStrategy {
    @Override
    public List<String> recommend(List<String> items, String user) {
        // Collaborative filtering logic
        return new ArrayList<>();
    }
}

public class ContentBasedFiltering implements RecommendationStrategy {
    @Override
    public List<String> recommend(List<String> items, String user) {
        // Content-based filtering logic
        return new ArrayList<>();
    }
}

public class RecommendationSystem {
    private RecommendationStrategy strategy;

    public void setStrategy(RecommendationStrategy strategy) {
        this.strategy = strategy;
    }

    public List<String> getRecommendations(List<String> items, String user) {
        return strategy.recommend(items, user);
    }
}

public class UserBehaviorTracker {
    private final List<UserBehaviorObserver> observers = new ArrayList<>();

    public void addObserver(UserBehaviorObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(UserBehaviorObserver observer) {
        observers.remove(observer);
    }

    public void trackBehavior(String user, String behavior) {
        for (UserBehaviorObserver observer : observers) {
            observer.update(user, behavior);
        }
    }
}

public interface UserBehaviorObserver {
    void update(String user, String behavior);
}
```
 
19. **Imagine you are developing a social media application that supports different types of posts (e.g., text, image, video) and interactions (e.g., like, comment, share). How would you design this using design patterns?**

Use the Factory Method pattern to create different types of posts and the Observer pattern for interactions.


```java
public interface Post {
    void display();
}

public class TextPost implements Post {
    private final String text;

    public TextPost(String text) {
        this.text = text;
    }

    @Override
    public void display() {
        System.out.println("Text post: " + text);
    }
}

public class ImagePost implements Post {
    private final String imageUrl;

    public ImagePost(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public void display() {
        System.out.println("Image post: " + imageUrl);
    }
}

public class VideoPost implements Post {
    private final String videoUrl;

    public VideoPost(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    @Override
    public void display() {
        System.out.println("Video post: " + videoUrl);
    }
}

public abstract class PostFactory {
    public abstract Post createPost(String content);
}

public class TextPostFactory extends PostFactory {
    @Override
    public Post createPost(String content) {
        return new TextPost(content);
    }
}

public class ImagePostFactory extends PostFactory {
    @Override
    public Post createPost(String content) {
        return new ImagePost(content);
    }
}

public class VideoPostFactory extends PostFactory {
    @Override
    public Post createPost(String content) {
        return new VideoPost(content);
    }
}

public interface InteractionObserver {
    void update(String postId, String interaction);
}

public class Post {
    private final List<InteractionObserver> observers = new ArrayList<>();
    private final String id;

    public Post(String id) {
        this.id = id;
    }

    public void addObserver(InteractionObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(InteractionObserver observer) {
        observers.remove(observer);
    }

    public void interact(String interaction) {
        for (InteractionObserver observer : observers) {
            observer.update(id, interaction);
        }
    }
}
```
 
20. **You need to build a system that supports different ways of exporting data (e.g., CSV, XML, JSON). How would you design this using design patterns?**

Use the Strategy pattern to define different export strategies and the Factory Method pattern to create export objects.


```java
public interface ExportStrategy {
    void export(String data);
}

public class CSVExport implements ExportStrategy {
    @Override
    public void export(String data) {
        System.out.println("Exporting data as CSV: " + data);
    }
}

public class XMLExport implements ExportStrategy {
    @Override
    public void export(String data) {
        System.out.println("Exporting data as XML: " + data);
    }
}

public class JSONExport implements ExportStrategy {
    @Override
    public void export(String data) {
        System.out.println("Exporting data as JSON: " + data);
    }
}

public class DataExporter {
    private ExportStrategy strategy;

    public void setStrategy(ExportStrategy strategy) {
        this.strategy = strategy;
    }

    public void exportData(String data) {
        strategy.export(data);
    }
}
```
 
21. **How would you implement a resource pool (e.g., database connection pool) using design patterns?**

Use the Singleton pattern to ensure a single instance of the resource pool and the Object Pool pattern to manage the resources.


```java
public class Connection {
    // Represents a database connection
}

public class ConnectionPool {
    private static ConnectionPool instance;
    private final List<Connection> availableConnections = new ArrayList<>();
    private final List<Connection> usedConnections = new ArrayList<>();

    private ConnectionPool() {
        // Initialize the pool with connections
        for (int i = 0; i < 10; i++) {
            availableConnections.add(new Connection());
        }
    }

    public static ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }

    public synchronized Connection acquireConnection() {
        if (availableConnections.isEmpty()) {
            throw new RuntimeException("No available connections");
        }
        Connection connection = availableConnections.remove(availableConnections.size() - 1);
        usedConnections.add(connection);
        return connection;
    }

    public synchronized void releaseConnection(Connection connection) {
        usedConnections.remove(connection);
        availableConnections.add(connection);
    }
}
```
 
22. **Design an inventory management system that supports different types of inventory (e.g., perishable, non-perishable) and various inventory actions (e.g., add, remove, transfer). Which design patterns would you use and why?**

Use the Factory Method pattern for creating different types of inventory items and the Command pattern for inventory actions.


```java
public interface InventoryItem {
    void performAction();
}

public class PerishableItem implements InventoryItem {
    @Override
    public void performAction() {
        System.out.println("Handling perishable item");
    }
}

public class NonPerishableItem implements InventoryItem {
    @Override
    public void performAction() {
        System.out.println("Handling non-perishable item");
    }
}

public abstract class InventoryFactory {
    public abstract InventoryItem createItem();
}

public class PerishableFactory extends InventoryFactory {
    @Override
    public InventoryItem createItem() {
        return new PerishableItem();
    }
}

public class NonPerishableFactory extends InventoryFactory {
    @Override
    public InventoryItem createItem() {
        return new NonPerishableItem();
    }
}

public interface Command {
    void execute();
}

public class AddCommand implements Command {
    private final InventoryItem item;

    public AddCommand(InventoryItem item) {
        this.item = item;
    }

    @Override
    public void execute() {
        System.out.println("Adding item to inventory");
        item.performAction();
    }
}

public class RemoveCommand implements Command {
    private final InventoryItem item;

    public RemoveCommand(InventoryItem item) {
        this.item = item;
    }

    @Override
    public void execute() {
        System.out.println("Removing item from inventory");
        item.performAction();
    }
}

public class TransferCommand implements Command {
    private final InventoryItem item;

    public TransferCommand(InventoryItem item) {
        this.item = item;
    }

    @Override
    public void execute() {
        System.out.println("Transferring item in inventory");
        item.performAction();
    }
}
```
 
23. **Imagine you are developing a content management system (CMS) that supports various content types (e.g., articles, images, videos) and plugins. How would you structure this using design patterns?**

Use the Factory Method pattern for creating different content types and the Plugin pattern for managing plugins.


```java
public interface Content {
    void display();
}

public class Article implements Content {
    @Override
    public void display() {
        System.out.println("Displaying article");
    }
}

public class ImageContent implements Content {
    @Override
    public void display() {
        System.out.println("Displaying image");
    }
}

public class VideoContent implements Content {
    @Override
    public void display() {
        System.out.println("Displaying video");
    }
}

public abstract class ContentFactory {
    public abstract Content createContent();
}

public class ArticleFactory extends ContentFactory {
    @Override
    public Content createContent() {
        return new Article();
    }
}

public class ImageFactory extends ContentFactory {
    @Override
    public Content createContent() {
        return new ImageContent();
    }
}

public class VideoFactory extends ContentFactory {
    @Override
    public Content createContent() {
        return new VideoContent();
    }
}

public interface Plugin {
    void performAction();
}

public class SEOPlugin implements Plugin {
    @Override
    public void performAction() {
        System.out.println("Performing SEO action");
    }
}

public class SecurityPlugin implements Plugin {
    @Override
    public void performAction() {
        System.out.println("Performing security action");
    }
}

public class PluginManager {
    private final List<Plugin> plugins = new ArrayList<>();

    public void addPlugin(Plugin plugin) {
        plugins.add(plugin);
    }

    public void removePlugin(Plugin plugin) {
        plugins.remove(plugin);
    }

    public void executePlugins() {
        for (Plugin plugin : plugins) {
            plugin.performAction();
        }
    }
}
```
 
24. **How would you design a library management system that allows users to borrow and return books, and provides different ways to search for books (e.g., by title, author, genre)?**

Use the Factory Method pattern for creating different book types, the Observer pattern for tracking book availability, and the Strategy pattern for different search algorithms.


```java
public interface Book {
    void borrow();
    void returnBook();
}

public class FictionBook implements Book {
    @Override
    public void borrow() {
        System.out.println("Borrowing fiction book");
    }

    @Override
    public void returnBook() {
        System.out.println("Returning fiction book");
    }
}

public class NonFictionBook implements Book {
    @Override
    public void borrow() {
        System.out.println("Borrowing non-fiction book");
    }

    @Override
    public void returnBook() {
        System.out.println("Returning non-fiction book");
    }
}

public abstract class BookFactory {
    public abstract Book createBook();
}

public class FictionBookFactory extends BookFactory {
    @Override
    public Book createBook() {
        return new FictionBook();
    }
}

public class NonFictionBookFactory extends BookFactory {
    @Override
    public Book createBook() {
        return new NonFictionBook();
    }
}

public interface SearchStrategy {
    List<Book> search(List<Book> books, String query);
}

public class TitleSearch implements SearchStrategy {
    @Override
    public List<Book> search(List<Book> books, String query) {
        // Search by title logic
        return new ArrayList<>();
    }
}

public class AuthorSearch implements SearchStrategy {
    @Override
    public List<Book> search(List<Book> books, String query) {
        // Search by author logic
        return new ArrayList<>();
    }
}

public class GenreSearch implements SearchStrategy {
    @Override
    public List<Book> search(List<Book> books, String query) {
        // Search by genre logic
        return new ArrayList<>();
    }
}

public class LibrarySystem {
    private final List<Book> books = new ArrayList<>();
    private SearchStrategy searchStrategy;

    public void setSearchStrategy(SearchStrategy searchStrategy) {
        this.searchStrategy = searchStrategy;
    }

    public List<Book> searchBooks(String query) {
        return searchStrategy.search(books, query);
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void borrowBook(Book book) {
        book.borrow();
    }

    public void returnBook(Book book) {
        book.returnBook();
    }
}
```
 
25. **You need to create a weather monitoring system that collects data from different sensors (e.g., temperature, humidity, wind speed) and provides various types of alerts. How would you design this using design patterns?**

Use the Observer pattern to monitor sensor data and the Strategy pattern to define different alert strategies.


```java
public interface Sensor {
    void addObserver(SensorObserver observer);
    void removeObserver(SensorObserver observer);
    void notifyObservers();
}

public class TemperatureSensor implements Sensor {
    private final List<SensorObserver> observers = new ArrayList<>();
    private double temperature;

    @Override
    public void addObserver(SensorObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(SensorObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (SensorObserver observer : observers) {
            observer.update(temperature);
        }
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
        notifyObservers();
    }
}

public interface SensorObserver {
    void update(double data);
}

public class Alert implements SensorObserver {
    private final AlertStrategy strategy;

    public Alert(AlertStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void update(double data) {
        strategy.sendAlert(data);
    }
}

public interface AlertStrategy {
    void sendAlert(double data);
}

public class EmailAlertStrategy implements AlertStrategy {
    @Override
    public void sendAlert(double data) {
        System.out.println("Sending email alert: " + data);
    }
}

public class SMSAlertStrategy implements AlertStrategy {
    @Override
    public void sendAlert(double data) {
        System.out.println("Sending SMS alert: " + data);
    }
}
```
