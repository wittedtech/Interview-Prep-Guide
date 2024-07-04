# Load Balancing and Load Balancing Algorithms

## Load Balancing
- It is the process of distributing network or application traffic across a number of servers to ensure no single server bears too much load.
- It is used to increase the availability and reliability of the system.
- It is used to distribute the load evenly across the servers.
  

  
## Load Balancing Algorithms

1. **Round Robin**
----
 - It sends each new request to the next server in the List/Line, and then goes back to the first server after the last server has been used.
 - Distributes requests sequentially to servers in a circular manner.
 - It is simple and easy to implement.
 - It can be useful when the servers have different capabilities.
 - It can be useful when the servers have different capabilities.

 **Useful When:**
 - servers have similar capabilities and want to spread the load evenly.

2. **Least Connections**
----
- It sends new requests to the server handling the fewest tasks right now.
- Distributes requests to the server with the least number of connections.

**Useful When:**
- servers have different processing speeds or some tasks take longer than others.
- servers have different capabilities and want to distribute the load based on the capabilities of the servers.

3. **IP Hash**
----
- It always sends requests from the same client/user to the same server.
- Distributes requests to the server based on the IP address of the client.

**Useful When:**
- Users need to stay connected to teh same server for their entire session; like in online shopping.

4. **Weighted Round Robin**
----
- It gives more work to stronger servers and less work to weaker servers; but still follows the circular rotation like round robin algorithm.
- Distributes requests to the server based on the weight of the server.

**Useful When:**
- System has mix of powerful and less powerful servers and want to distribute work according to server capability.


5. **Weighted Least Connections**
----
- It considers both how busy each server is and how strong it is when assigning a new tasks/requests.
- Distributes requests to the server based on the weight(no. of connections active at the time) of the server.

**Useful When:**
- we have servers with different strengths and want to balance their workload efficiently.

6. **Least Response Time:**
----
- It chooses the server that's both quick to respond and not too busy.

**Useful When:**
- Speed is crucial, and we want to provide the fastest possible service to users.

7. **Random**
----
- It picks a server at random for each new request.

**Useful When:**
- We want a simple way to distribute tasks and servers are all similar in capability.
- We want to distribute the load randomly to avoid any specific server getting overloaded.

8. **Least Bandwidth**
----
- It sends new tasks to the server using the least amount of internet capacity at the moment.

**Useful When:**
- Main concern is network traffic, and we want to avoid overloading any single server's connection.