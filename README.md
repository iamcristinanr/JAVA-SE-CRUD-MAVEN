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

