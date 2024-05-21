# Mapping associations and querying

## Entity relationships: One-to-Many, Many-to-One

Entity relationships are a crucial aspect of JPA, allowing you to model complex data structures and associations between entities. Two common types of relationships are One-to-Many and Many-to-One. Let's explore these relationships:

### One-to-Many Relationship:
In a One-to-Many relationship, one entity instance is associated with multiple instances of another entity. For example, one department may have multiple employees.

#### Example:
Consider an example where one Department entity is associated with multiple Employee entities:

```java
@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;

    // Getters and setters
}
```

```java
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    // Getters and setters
}
```

In this example, the Department entity has a One-to-Many relationship with the Employee entity. Each department can have multiple employees. The `@OneToMany` annotation on the `employees` field in the Department class specifies the inverse side of the relationship, and the `mappedBy` attribute refers to the corresponding field in the Employee class.

### Many-to-One Relationship:
In a Many-to-One relationship, multiple instances of one entity are associated with a single instance of another entity. For example, multiple employees may belong to the same department.

#### Example:
Using the same entities as above, here's how you define a Many-to-One relationship:

```java
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    // Getters and setters
}
```

```java
@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    // Getters and setters
}
```

In this example, the Employee entity has a Many-to-One relationship with the Department entity. Each employee belongs to one department. The `@ManyToOne` annotation on the `department` field in the Employee class establishes the Many-to-One relationship, and the `@JoinColumn` annotation specifies the foreign key column in the database table.

## Using JPQL (Java Persistence Query Language)

Java Persistence Query Language (JPQL) is a query language used to perform database queries in JPA applications. It is similar to SQL but operates on entities instead of database tables. JPQL queries are portable across different JPA providers, making them ideal for building database-independent applications. Let's explore how to use JPQL for various database operations:

### 1. Selecting Entities:
You can use JPQL to retrieve entities from the database based on certain criteria. For example, to select all employees whose first name is "John":

```java
TypedQuery<Employee> query = entityManager.createQuery(
    "SELECT e FROM Employee e WHERE e.firstName = :firstName", Employee.class);
query.setParameter("firstName", "John");
List<Employee> employees = query.getResultList();
```

### 2. Joining Entities:
JPQL supports entity joins to query data from multiple related entities. For example, to select employees along with their departments:

```java
TypedQuery<Employee> query = entityManager.createQuery(
    "SELECT e FROM Employee e JOIN e.department d WHERE d.name = :departmentName", Employee.class);
query.setParameter("departmentName", "IT");
List<Employee> employees = query.getResultList();
```

### 3. Aggregating Data:
You can use JPQL to perform aggregate functions such as COUNT, SUM, AVG, MIN, and MAX. For example, to count the total number of employees:

```java
TypedQuery<Long> query = entityManager.createQuery(
    "SELECT COUNT(e) FROM Employee e", Long.class);
Long employeeCount = query.getSingleResult();
```

### 4. Updating Entities:
JPQL also allows updating entities in the database. For example, to update the salary of all employees in the IT department:

```java
entityManager.getTransaction().begin();
Query query = entityManager.createQuery(
    "UPDATE Employee e SET e.salary = :newSalary WHERE e.department.name = :departmentName");
query.setParameter("newSalary", 5000);
query.setParameter("departmentName", "IT");
int updatedCount = query.executeUpdate();
entityManager.getTransaction().commit();
```

### 5. Deleting Entities:
You can use JPQL to delete entities from the database. For example, to delete all employees whose last name is "Doe":

```java
entityManager.getTransaction().begin();
Query query = entityManager.createQuery(
    "DELETE FROM Employee e WHERE e.lastName = :lastName");
query.setParameter("lastName", "Doe");
int deletedCount = query.executeUpdate();
entityManager.getTransaction().commit();
```

### Named Queries:
You can define named queries in entity classes or XML configuration files and then refer to them using their names in the application code. For example, to define a named query in an entity class:

```java
@Entity
@Table(name = "employees")
@NamedQuery(name = "Employee.findByFirstName", query = "SELECT e FROM Employee e WHERE e.firstName = :firstName")
public class Employee {
    // Entity properties and methods
}
```

And then use it in your application code:

```java
TypedQuery<Employee> query = entityManager.createNamedQuery("Employee.findByFirstName", Employee.class);
query.setParameter("firstName", "John");
List<Employee> employees = query.getResultList();
```

JPQL provides a powerful and flexible way to interact with entities in JPA applications, allowing you to perform complex database operations with ease.

## Advanced querying with JPQL and Criteria API

Advanced querying in JPA can be achieved through JPQL (Java Persistence Query Language) and the Criteria API. Both approaches offer powerful features for constructing queries dynamically and performing complex operations. Let's explore each of them:

### 1. JPQL (Java Persistence Query Language):
JPQL is a SQL-like query language specifically designed to operate on JPA entities. It allows you to construct queries using entity names and attributes rather than database tables and columns.

#### Example:
```java
TypedQuery<Employee> query = entityManager.createQuery(
    "SELECT e FROM Employee e WHERE e.department.name = :departmentName", Employee.class);
query.setParameter("departmentName", "IT");
List<Employee> employees = query.getResultList();
```

### 2. Criteria API:
The Criteria API provides a type-safe way to build queries dynamically using Java code. It allows you to construct query criteria using methods and predicates rather than strings.

#### Example:
```java
CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
Root<Employee> root = criteriaQuery.from(Employee.class);
criteriaQuery.select(root)
    .where(criteriaBuilder.equal(root.get("department").get("name"), "IT"));
TypedQuery<Employee> query = entityManager.createQuery(criteriaQuery);
List<Employee> employees = query.getResultList();
```

### Comparison:
- **JPQL**:
  - Uses string-based queries.
  - Queries are written as strings, which can be less type-safe and more error-prone.
  - Provides more flexibility in complex queries and supports features such as joins, subqueries, and aggregate functions.
  - Easier to read and write for simple queries.

- **Criteria API**:
  - Provides a type-safe way to build queries using Java code.
  - Queries are constructed using method calls, making them less error-prone and easier to refactor.
  - Suitable for building dynamic queries at runtime based on varying criteria.
  - More verbose compared to JPQL, especially for simple queries.

### Advanced Querying:
Both JPQL and Criteria API can be used for advanced querying, including:
- Joins between entities.
- Subqueries and nested queries.
- Aggregate functions (COUNT, SUM, AVG, etc.).
- Grouping and sorting.
- Pagination and result set limiting.

### Example of Advanced Querying with Criteria API:
```java
CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);
Root<Employee> employeeRoot = criteriaQuery.from(Employee.class);
Join<Employee, Department> departmentJoin = employeeRoot.join("department");
criteriaQuery.multiselect(
        employeeRoot.get("firstName"),
        employeeRoot.get("lastName"),
        departmentJoin.get("name"))
    .where(criteriaBuilder.equal(departmentJoin.get("name"), "IT"))
    .orderBy(criteriaBuilder.asc(employeeRoot.get("lastName")));
TypedQuery<Object[]> query = entityManager.createQuery(criteriaQuery);
List<Object[]> results = query.getResultList();
```

This query retrieves the first name, last name, and department name of employees in the IT department, sorted by last name.

Both JPQL and Criteria API offer powerful querying capabilities, and the choice between them often depends on factors such as personal preference, complexity of the query, and maintainability of the code.

## Named queries and dynamic queries

Named queries and dynamic queries are two common approaches for constructing and executing queries in JPA applications. Named queries are predefined queries defined in entity classes or XML configuration files, while dynamic queries are constructed at runtime based on varying criteria.

### Named Queries:
Named queries are statically defined queries with a name associated with them. They are typically defined in entity classes or XML configuration files and can be referenced by their names in the application code.

#### Example (Named Query in Entity Class):
```java
@Entity
@Table(name = "employees")
@NamedQuery(
    name = "Employee.findByDepartment",
    query = "SELECT e FROM Employee e WHERE e.department = :department"
)
public class Employee {
    // Entity properties and methods
}
```

#### Example (Using Named Query in Application Code):
```java
TypedQuery<Employee> query = entityManager.createNamedQuery("Employee.findByDepartment", Employee.class);
query.setParameter("department", someDepartment);
List<Employee> employees = query.getResultList();
```

### Dynamic Queries:
Dynamic queries are constructed at runtime based on varying criteria, allowing for more flexibility in querying. They are typically built using JPQL (Java Persistence Query Language) or the Criteria API.

#### Example (Dynamic JPQL Query):
```java
String jpql = "SELECT e FROM Employee e WHERE 1=1";
if (filterByDepartment) {
    jpql += " AND e.department = :department";
}
if (filterBySalary) {
    jpql += " AND e.salary > :minSalary";
}

TypedQuery<Employee> query = entityManager.createQuery(jpql, Employee.class);
if (filterByDepartment) {
    query.setParameter("department", someDepartment);
}
if (filterBySalary) {
    query.setParameter("minSalary", minSalary);
}

List<Employee> employees = query.getResultList();
```

#### Example (Dynamic Criteria Query):
```java
CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
Root<Employee> root = criteriaQuery.from(Employee.class);
List<Predicate> predicates = new ArrayList<>();

if (filterByDepartment) {
    predicates.add(criteriaBuilder.equal(root.get("department"), someDepartment));
}
if (filterBySalary) {
    predicates.add(criteriaBuilder.gt(root.get("salary"), minSalary));
}

criteriaQuery.where(predicates.toArray(new Predicate[0]));
TypedQuery<Employee> query = entityManager.createQuery(criteriaQuery);
List<Employee> employees = query.getResultList();
```

### Comparison:
- **Named Queries**:
  - Predefined queries with static definitions.
  - Better suited for commonly used queries.
  - Provides better performance as the query is compiled and cached.
- **Dynamic Queries**:
  - Constructed at runtime based on varying criteria.
  - Offers more flexibility in querying but may result in more verbose code.
  - Suitable for scenarios where query criteria change dynamically.

### Considerations:
- Named queries are suitable for commonly used and static queries, while dynamic queries are better for scenarios where query criteria vary.
- Dynamic queries using JPQL are more flexible but may result in complex string manipulation.
- Dynamic queries using the Criteria API offer type-safety and are more readable but may be more verbose.
- Choose the appropriate approach based on the specific requirements and maintainability of the codebase.
