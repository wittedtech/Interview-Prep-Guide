**Designing a Least Recently Used (LRU) cache is a common interview question (Asked in Citi Bank)**

## Understand Concept, Design, and implementation :

- An LRU cache evicts the least recently used items first when it reaches its capacity. Here’s how we can approach this problem:

- **Main Concepts:**

  **Cache Operations:** The cache should support two primary operations:

  `get(key):` Return the value of the key if it exists in the cache, otherwise return -1.
  `put(key, value):` Insert or update the value of the key. If the cache reaches its capacity, it should invalidate the least recently used item.

  **Data Structures:**

  `HashMap`: For O(1) access to cache items by key.  
  `Doubly Linked List`: To keep track of the usage order of cache items. The most recently used items are moved to the front, and the least recently used items are at the end.

  **Class Structure**

  - **LRU Cache Class**

  This class will contain the core logic of the LRU cache.

  **Attributes:**

  `capacity:` The maximum number of items the cache can hold.
  map: A HashMap that maps keys to nodes in the doubly linked list.
  head and tail: Nodes to represent the boundaries of the doubly linked list.

  **Methods:**

  `get(int key):` Retrieves an item from the cache.
  `put(int key, int value):` Adds or updates an item in the cache.
  `Helper` methods for managing the doubly linked list:
  `addNode(Node node):` Adds a new node right after the head.
  `removeNode(Node node):` Removes an existing node from the list.
  `moveToHead(Node node):` Moves an existing node to the head.
  `popTail():` Removes the node at the tail and returns it.

  **Node Class**

  This class represents each node in the doubly linked list.

  **Attributes:**

  `key:` The key of the cache item.
  `value:` The value of the cache item.
  `prev:` Pointer to the previous node.
  `next:` Pointer to the next node.

- **Designing Concept :**
  Let's design and implement a Least Recently Used (LRU) cache in Java. An LRU cache is a data structure that stores a fixed number of key-value pairs and evicts the least recently used item when the cache reaches its capacity.

  We can implement the LRU cache using a combination of a HashMap for fast key-value lookups and a doubly linked list to keep track of the access order of the elements.

  Here's the basic outline of our LRU cache implementation:

  1. Define a `Node` class to represent individual elements in the doubly linked list. Each node will store a key-value pair.
  2. Define a `LRUCache` class that contains the HashMap for fast lookups and the doubly linked list to maintain the access order.
  3. Implement methods to perform operations such as `get` (retrieve value for a given key), `put` (insert or update a key-value pair), and `evict` (remove the least recently used item when the cache is full).

- **Implementation Solution :**

  ```java
  import java.util.HashMap;

  class Node {
      int key;
      int value;
      Node prev;
      Node next;

      public Node(int key, int value) {
          this.key = key;
          this.value = value;
      }
  }

  public class LRUCache {
      private HashMap<Integer, Node> map;
      private Node head;
      private Node tail;
      private int capacity;

      public LRUCache(int capacity) {
          this.capacity = capacity;
          map = new HashMap<>();
          head = new Node(-1, -1); // Dummy head node
          tail = new Node(-1, -1); // Dummy tail node
          head.next = tail;
          tail.prev = head;
      }

      public int get(int key) {
          if (!map.containsKey(key))
              return -1;

          Node node = map.get(key);
          moveToHead(node); // Move accessed node to the head
          return node.value;
      }

      public void put(int key, int value) {
          if (map.containsKey(key)) {
              Node node = map.get(key);
              node.value = value; // Update value
              moveToHead(node);   // Move accessed node to the head
          } else {
              if (map.size() == capacity) {
                  evict(); // Remove least recently used item if capacity is reached
              }

              Node newNode = new Node(key, value);
              addToHead(newNode);
              map.put(key, newNode);
          }
      }

      private void moveToHead(Node node) {
          removeNode(node);
          addToHead(node);
      }

      private void removeNode(Node node) {
          node.prev.next = node.next;
          node.next.prev = node.prev;
      }

      private void addToHead(Node node) {
          node.next = head.next;
          node.prev = head;
          head.next.prev = node;
          head.next = node;
      }

      private void evict() {
          Node leastUsed = tail.prev;
          removeNode(leastUsed);
          map.remove(leastUsed.key);
      }

      public static void main(String[] args) {
          LRUCache cache = new LRUCache(2); // Create an LRU cache with capacity 2
          cache.put(1, 1);
          cache.put(2, 2);
          System.out.println(cache.get(1)); // Output: 1 (1 is present in the cache)
          cache.put(3, 3); // evicts key 2
          System.out.println(cache.get(2)); // Output: -1 (2 is not present in the cache)
          cache.put(4, 4); // evicts key 1
          System.out.println(cache.get(1)); // Output: -1 (1 is not present in the cache)
          System.out.println(cache.get(3)); // Output: 3 (3 is present in the cache)
          System.out.println(cache.get(4)); // Output: 4 (4 is present in the cache)
      }
  }
  ```
