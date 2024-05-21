# Unit testing using JUnit

## Introduction to Unit testing

Unit testing is a fundamental practice in software development where individual units or components of a software application are tested in isolation to ensure they function correctly. The primary goal of unit testing is to validate that each unit of the software performs as expected.

Here's a breakdown of key points regarding unit testing:

1. **Purpose**: Unit testing helps to verify the correctness of small, isolated units of code such as functions, methods, or classes. By testing each unit in isolation, developers can ensure that the code behaves as intended and catches any defects early in the development process.

2. **Isolation**: Unit tests should be isolated from external dependencies such as databases, networks, or other services. This is achieved through the use of test doubles such as mocks, stubs, or fakes to simulate the behavior of these dependencies. Isolation ensures that a failing test indicates a problem within the unit under test, rather than in its dependencies.

3. **Framework**: JUnit is one of the most popular unit testing frameworks for Java. It provides a simple and powerful way to write and execute unit tests. JUnit offers annotations for defining test methods, assertions for verifying expected outcomes, and runners for executing tests.

4. **Test Anatomy**: A typical unit test consists of three main phases: setup, exercise, and verify (also known as arrange, act, and assert). In the setup phase, any necessary preconditions or dependencies are prepared. The exercise phase involves calling the method or function being tested with specific inputs. Finally, in the verify phase, assertions are used to check that the expected behavior occurred.

Now, let's illustrate these points with a simple Java example using JUnit:

```java
import static org.junit.Assert.*;
import org.junit.Test;

public class MyMathTest {

    @Test
    public void testAdd() {
        // Setup
        MyMath math = new MyMath();

        // Exercise
        int result = math.add(3, 5);

        // Verify
        assertEquals(8, result);
    }
}
```

In this example:

- We have a `MyMath` class with a method `add` that adds two integers.
- The `MyMathTest` class contains a test method `testAdd`, annotated with `@Test`, indicating it is a test case.
- Within the test method, we:
  - Setup an instance of `MyMath`.
  - Exercise the `add` method with inputs 3 and 5.
  - Verify that the result is equal to 8 using the `assertEquals` assertion.

This is a basic example, but it demonstrates the structure and principles of unit testing using JUnit.

## Introduction to JUnit

JUnit is a popular open-source framework for writing and running unit tests in Java. It provides annotations, assertions, and other utilities to simplify the process of creating and executing tests. Here's a detailed explanation of JUnit:

1. **Purpose**: JUnit is designed to support unit testing, which is a crucial aspect of test-driven development (TDD) and agile software development methodologies. Unit testing involves testing individual units or components of a software application in isolation to ensure they behave as expected.

2. **Features**:

   - **Annotations**: JUnit uses annotations to define test methods, setup and teardown methods, and more. Annotations such as `@Test`, `@Before`, `@After`, `@BeforeClass`, and `@AfterClass` are commonly used.
   - **Assertions**: JUnit provides a set of assertion methods to verify expected outcomes. These include methods like `assertEquals`, `assertTrue`, `assertFalse`, `assertNotNull`, and more.
   - **Runners**: JUnit supports different test runners for executing tests. The default runner is `BlockJUnit4ClassRunner`, but there are others like `Parameterized` for running parameterized tests.
   - **Parameterized Tests**: JUnit allows parameterized tests where you can run the same test logic with multiple sets of data.
   - **Assertions for Exceptions**: JUnit provides annotations like `@Test(expected)` and `@Rule` for asserting that methods throw expected exceptions.
   - **Timeouts**: You can specify a maximum time limit for a test to execute using the `@Test(timeout)` annotation.
   - **Suites**: JUnit supports test suites, which allow you to group multiple test classes and run them together.

3. **Example**:

   Here's a simple example demonstrating the usage of JUnit:

   ```java
   import static org.junit.Assert.*;
   import org.junit.Test;

   public class MyMathTest {

       @Test
       public void testAdd() {
           MyMath math = new MyMath();
           int result = math.add(3, 5);
           assertEquals(8, result);
       }

       @Test
       public void testDivide() {
           MyMath math = new MyMath();
           double result = math.divide(10, 2);
           assertEquals(5.0, result, 0.0001);
       }
   }
   ```

   In this example:

   - We have a `MyMath` class with methods `add` and `divide`.
   - The `MyMathTest` class contains two test methods, `testAdd` and `testDivide`, annotated with `@Test`.
   - Within each test method, we create an instance of `MyMath`, call the respective method, and use assertion methods like `assertEquals` to verify the expected results.

JUnit makes it easy to write and run tests, ensuring the reliability and correctness of your Java code.

## Seting up JUnit testing

Setting up JUnit 5.x for testing in a Java project involves a few steps:

1. **Add JUnit Dependency**: First, you need to include the JUnit 5.x dependency in your project. If you're using Maven, you can add the following dependency to your `pom.xml` file:

```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-api</artifactId>
    <version>5.8.2</version> <!-- Replace with the latest version -->
    <scope>test</scope>
</dependency>
```

If you're using Gradle, add the following to your `build.gradle` file:

```groovy
testImplementation 'org.junit.jupiter:junit-jupiter-api:5.8.2' // Replace with the latest version
```

2. **Add JUnit Platform Launcher**: If you're using JUnit 5.x with an IDE like IntelliJ IDEA or Eclipse, you typically don't need to explicitly add the JUnit Platform Launcher. However, if you're using the command line or another build tool, you might need to include the launcher as a dependency:

```xml
<dependency>
    <groupId>org.junit.platform</groupId>
    <artifactId>junit-platform-launcher</artifactId>
    <version>1.8.2</version> <!-- Replace with the latest version -->
    <scope>test</scope>
</dependency>
```

For Gradle:

```groovy
testImplementation 'org.junit.platform:junit-platform-launcher:1.8.2' // Replace with the latest version
```

3. **Write Tests**: Now you can write your tests using JUnit 5.x. Here's a simple example:

```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyMathTest {

    @Test
    public void testAdd() {
        MyMath math = new MyMath();
        int result = math.add(3, 5);
        assertEquals(8, result);
    }
}
```

4. **Run Tests**: You can run your JUnit tests using your IDE's test runner or by using a build tool like Maven or Gradle. Most IDEs provide built-in support for running JUnit tests.

5. **(Optional) Add JUnit Jupiter Engine**: If you're writing JUnit 5.x tests that require annotations like `@BeforeEach`, `@AfterEach`, etc., you need to include the JUnit Jupiter Engine as a dependency:

```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-engine</artifactId>
    <version>5.8.2</version> <!-- Replace with the latest version -->
    <scope>test</scope>
</dependency>
```

For Gradle:

```groovy
testImplementation 'org.junit.jupiter:junit-jupiter-engine:5.8.2' // Replace with the latest version
```

That's it! You've now set up JUnit 5.x for testing in your Java project. You can start writing and running tests to ensure the correctness of your code.

## Testcases and assertionsIn unit testing with JUnit, test cases are the individual methods within a test class that verify specific behavior or functionality of the code being tested. Assertions are statements within these test cases that check whether the actual result matches the expected result. Let's delve into each of these concepts:

### Test Cases:

Test cases are methods annotated with `@Test` in JUnit. These methods contain the logic to exercise a specific piece of functionality in your code and verify its correctness. Here's how you can define a test case:

```java
import org.junit.jupiter.api.Test;

public class MyMathTest {

    @Test
    public void testAddition() {
        // Test logic goes here
    }
}
```

### Assertions:

Assertions are used within test cases to validate the expected behavior of the code under test. JUnit provides a rich set of assertion methods to cover various scenarios. Some commonly used assertion methods include `assertEquals`, `assertTrue`, `assertFalse`, `assertNull`, `assertNotNull`, `assertSame`, `assertNotSame`, etc.

Here's how you can use assertions within a test case:

```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MyMathTest {

    @Test
    public void testAddition() {
        int result = MyMath.add(2, 3);
        assertEquals(5, result); // Verify that result is equal to 5
    }
}
```

In this example:

- `assertEquals` verifies that the actual value returned by `MyMath.add(2, 3)` is equal to 5.
- If the assertion fails (i.e., the actual value doesn't match the expected value), the test case fails, and a relevant error message is displayed.

### Example with Multiple Assertions:

You can have multiple assertions within a single test case to check different aspects of the code under test. For example:

```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MyMathTest {

    @Test
    public void testAddition() {
        int result = MyMath.add(2, 3);
        assertEquals(5, result); // Verify addition result
        assertTrue(result > 0);   // Verify result is positive
    }
}
```

In this example:

- We're using both `assertEquals` and `assertTrue` to verify different properties of the result returned by `MyMath.add(2, 3)`.
- If any assertion fails, the test case fails, providing specific information about which assertion failed and why.

These are the fundamental concepts of test cases and assertions in JUnit. By writing meaningful test cases with appropriate assertions, you can ensure the correctness and robustness of your code.

## Lifecycle hooks

In JUnit, lifecycle hooks are methods annotated with specific annotations that define the setup and teardown behavior for test cases or test suites. These hooks allow you to perform common initialization and cleanup tasks before and after test execution. JUnit provides several annotations to define these lifecycle hooks:

### 1. `@BeforeAll` and `@AfterAll`:

These annotations are used to define methods that run once before and after all test cases in a test class, respectively. These methods must be static and can be used for setup and cleanup tasks that are common to all test cases in the class.

Example:

```java
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

public class MyTestClass {

    @BeforeAll
    static void setUpBeforeAll() {
        // Perform setup tasks before all test cases
    }

    @AfterAll
    static void tearDownAfterAll() {
        // Perform cleanup tasks after all test cases
    }

    @Test
    void test1() {
        // Test case 1
    }

    @Test
    void test2() {
        // Test case 2
    }
}
```

### 2. `@BeforeEach` and `@AfterEach`:

These annotations are used to define methods that run before and after each test case in a test class, respectively. These methods can be used for setup and cleanup tasks that are specific to each individual test case.

Example:

```java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class MyTestClass {

    @BeforeEach
    void setUpBeforeEach() {
        // Perform setup tasks before each test case
    }

    @AfterEach
    void tearDownAfterEach() {
        // Perform cleanup tasks after each test case
    }

    @Test
    void test1() {
        // Test case 1
    }

    @Test
    void test2() {
        // Test case 2
    }
}
```

### 3. Execution Order:

- `@BeforeAll` methods run before any `@BeforeEach` methods and before any test case in the test class.
- `@BeforeEach` methods run before each test case.
- Test cases run in the order they are defined in the test class.
- `@AfterEach` methods run after each test case.
- `@AfterAll` methods run after all test cases in the test class and after any `@AfterEach` methods.

These lifecycle hooks provide flexibility in setting up and tearing down the test environment, ensuring that tests are executed in a consistent and controlled manner.

## Parameterized tests

Parameterized tests in JUnit allow you to run the same test logic with multiple sets of data. This is useful when you want to verify that a piece of code behaves correctly across different input values. JUnit 5 provides a convenient way to create parameterized tests using the `@ParameterizedTest` annotation along with a method that provides the test arguments.

Here's how you can create parameterized tests in JUnit 5:

```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MyMathTest {

    @ParameterizedTest
    @CsvSource({ "1, 2, 3", "2, 3, 5", "0, 0, 0" }) // Define input-output pairs
    void testAddition(int a, int b, int expected) {
        MyMath math = new MyMath();
        int result = math.add(a, b);
        assertEquals(expected, result); // Verify result with expected value
    }
}
```

In this example:

- We have a `MyMath` class with an `add` method that adds two integers.
- The `MyMathTest` class contains a parameterized test method `testAddition`.
- The `@ParameterizedTest` annotation indicates that this method will be executed multiple times with different arguments.
- The `@CsvSource` annotation provides the input-output pairs in CSV format. Each row represents a set of arguments for a single execution of the test method.
- Inside the test method, we perform the addition operation using the provided arguments and then use `assertEquals` to verify that the result matches the expected value.

When you run this test class, JUnit will execute the `testAddition` method multiple times, once for each row in the CSV source, and report any failures separately for each set of arguments.

### Additional Parameterized Sources:

In addition to `@CsvSource`, JUnit 5 provides other parameterized sources like `@ValueSource`, `@EnumSource`, `@MethodSource`, `@CsvFileSource`, etc., which you can use depending on your specific requirements. These sources allow you to provide test arguments from different types of data sources, such as arrays, enums, methods, files, etc.

Parameterized tests are a powerful feature of JUnit that can help you write concise and expressive tests for code that needs to be validated against multiple input values.

## Online resources

Here are some online resources where you can learn more about JUnit, including topics like unit testing, assertions, lifecycle hooks, and parameterized tests:

1. **JUnit 5 User Guide**:

   - Official documentation for JUnit 5, covering everything from getting started to advanced features: [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)

2. **Baeldung JUnit 5 Tutorial**:

   - Baeldung offers comprehensive tutorials on JUnit 5, including parameterized tests, assertions, lifecycle hooks, and more: [JUnit 5 Tutorial](https://www.baeldung.com/junit-5)

3. **Vogella JUnit Tutorial**:

   - Vogella provides a detailed tutorial on JUnit 5, covering various features and best practices: [JUnit 5 Tutorial](https://www.vogella.com/tutorials/JUnit/article.html)

4. **JUnit 5 GitHub Repository**:

   - Explore the official GitHub repository for JUnit 5, where you can find the source code, issues, and discussions related to the framework: [JUnit 5 GitHub](https://github.com/junit-team/junit5)

5. **JUnit Cookbook by Kent Beck**:

   - Kent Beck, one of the pioneers of TDD, offers a collection of recipes for writing effective tests with JUnit: [JUnit Cookbook](http://junit.org/junit5/docs/current/user-guide/#writing-tests)

6. **JUnit 5 in Action by Petar Tahchiev, Felipe Leme, et al.**:

   - This book provides practical guidance and examples for using JUnit 5 effectively in your projects: [JUnit 5 in Action](https://www.manning.com/books/junit-5-in-action)

7. **Stack Overflow**:
   - Stack Overflow is a great platform to find answers to specific questions related to JUnit. You can browse existing questions or ask your own: [Stack Overflow JUnit Tag](https://stackoverflow.com/questions/tagged/junit)

These resources should provide you with a solid foundation and additional insights into unit testing with JUnit. Happy learning!
