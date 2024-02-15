# ACCESS TO BBDD WITH MAVEN

New project build system Maven: 
 Create File pom.xml automatically
 Add dependecies from https://mvnrepository.com/artifact/com.mysql/mysql-connector-j/8.0.33

**Important: In case of error, try update file pom.**
Inside file pom, right button: Maven: Reload project.

## DAO Pattern (Data Access Object)
- Separate data access logic from business logic.
- The DAO provides methods necessary to insert, update, delete and query information.
- Linked to saving data from a very specific SQL database table.

## Repository Pattern
 - Abstract and encapsulate data access.
 - Provides business layer and data persistence layer.
 - The target persistence system doesn't matter much.

## CRUD (Create, Read, Update, Delete)
Implementation of the methods:
- findAll: Reading
- getById: Searching
- save: Creating, updating
- delete: Deleting

## ACID 
- Atomicity
- Consistency
- Isolation
- Durability

To test our code with principles ACID we have added a new columm UNIQUE in the ddbb called DNI
Everything will be done in a single transaction so a single connection will be made SINGELTON

## POOL
Set of database connections that are created and managed for reuse.
Database connections are quite expensive operations and as such should be kept to a minimum in all possible use cases (in extreme cases, simply avoided).


In this case we're going to use: Apache Commons DBCP


- setInitialSize(int): Sets the initial size of the connection pool.
- setMaxTotal(int): Sets the maximum size of connections that can be maintained.
- setMaxIdle(int): Sets the maximum number of inactive connections we can have.
- setMinIdle(int): Sets the minimum number of inactive connections we can have.
- setMaxWaitMillis(long): Sets the response time we would have to wait between each connection.

## SWING APP
Part of the code has a graphical interface (under comments) for its implementation and in 
this way interact with the end user

## JPA (DEVELOPING)
