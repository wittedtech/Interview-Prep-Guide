# Interview: Question & Answers - 2 Years (Exp.)

## Database Interview Questions & Answers:

**Database Questions:**

    1. **What is indexing and why to use indexing?**
        - Indexing is the process of adding a data structure to a database table to improve the speed of data retrieval operations. Indexes allow database systems to quickly locate rows in a table based on the values of one or more columns, reducing the need for full-table scans and improving query performance.

    2. **What is Sharding in Database?**
        - Sharding is a database partitioning technique where large databases are divided into smaller, more manageable parts called shards. Each shard contains a subset of the data and is hosted on a separate database server. Sharding helps distribute the workload and scale the database horizontally to handle large volumes of data and high throughput.

    3. **What is data normalization?**
        - Data normalization is the process of organizing data in a database to reduce redundancy and improve data integrity. It involves breaking down large tables into smaller, related tables and defining relationships between them using foreign keys. The goal of normalization is to eliminate data anomalies such as insertion, update, and deletion anomalies.

    4. **Write a query to find the second highest salary of the employee where multiple employees can have the same salary.**
        - Here's a SQL query to find the second-highest salary:
        ```sql
        SELECT DISTINCT Salary FROM Employee ORDER BY Salary DESC LIMIT 1 OFFSET 1;
        ```
