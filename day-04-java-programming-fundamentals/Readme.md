# Java programming language

## Overview

Java is a versatile, object-oriented programming language developed by Sun Microsystems (now owned by Oracle Corporation) in the mid-1990s. It was designed to be platform-independent, allowing developers to write code that could run on any device or operating system with a Java Virtual Machine (JVM) installed. This feature is achieved through the concept of "write once, run anywhere" (WORA), making Java a popular choice for developing applications ranging from enterprise software to web applications, mobile apps, and embedded systems.

Here are some key aspects and features of Java:

1. **Object-oriented**: Java is an object-oriented programming (OOP) language, which means it emphasizes the use of objects and classes to structure code. This makes it easier to manage and maintain complex applications by organizing code into reusable components.

2. **Platform independence**: Java programs are compiled into bytecode, which is executed by the JVM. This bytecode can run on any device or operating system that has a compatible JVM installed, making Java platform-independent.

3. **Automatic memory management**: Java manages memory automatically through a process called garbage collection. This frees developers from having to manually allocate and deallocate memory, reducing the risk of memory leaks and other memory-related errors.

4. **Robustness**: Java is designed to be robust and reliable, with features such as strong type checking, exception handling, and runtime checking to ensure the integrity of the code.

5. **Security**: Java has built-in security features that help protect against common security threats such as viruses and malware. The Java Security Manager allows developers to define security policies for their applications, restricting access to certain resources or operations.

6. **Rich standard library**: Java comes with a comprehensive standard library (Java API) that provides ready-to-use classes and methods for common tasks such as input/output, networking, data manipulation, and GUI development.

7. **Multi-threading support**: Java supports multi-threading, allowing developers to write concurrent programs that can perform multiple tasks simultaneously. This is essential for developing responsive and scalable applications, especially in the context of modern, multi-core processors.

8. **Community and ecosystem**: Java has a large and active community of developers, which means there are plenty of resources, libraries, frameworks, and tools available to help developers build and maintain Java applications efficiently.

## History and milestones

Java's history dates back to the early 1990s when it was conceived and developed by a team of engineers at Sun Microsystems, led by James Gosling. The primary motivation behind Java's creation was to address the challenges posed by the emerging trend of networked devices and the need for a platform-independent programming language.

Here's a brief history of Java and its major milestones:

1. **Origins and Development (1991-1995)**:

   - In 1991, the team at Sun Microsystems, including James Gosling, Mike Sheridan, and Patrick Naughton, began working on a project called "Oak," which aimed to develop a programming language for consumer electronic devices.
   - The language was later renamed "Java" in 1995. The name was chosen because of its association with coffee (a popular beverage at Sun Microsystems) and its similarity to the name "Oak."
   - Java was officially announced to the public in May 1995 at the SunWorld conference.

2. **Introduction of Java 1.0 (January 1996)**:

   - Java 1.0 was released in January 1996, marking the first official release of the language. It included key features such as the Java Virtual Machine (JVM), the Java Applet API for web browsers, and the core Java API.

3. **Expansion and Adoption (Late 1990s)**:

   - Throughout the late 1990s, Java gained significant popularity and adoption, particularly in the emerging field of web development. The ability to write platform-independent code and run Java applets within web browsers made it a preferred choice for building dynamic and interactive web content.

4. **Introduction of Java 2 Platform (December 1998)**:

   - Java 2 Platform, Standard Edition (J2SE), introduced significant enhancements and updates to the Java language and platform. It included new features such as Swing GUI toolkit, Collections framework, and the Java Naming and Directory Interface (JNDI).

5. **Introduction of Enterprise Edition and Micro Edition (2000s)**:

   - In the early 2000s, Sun Microsystems introduced Java 2 Platform, Enterprise Edition (J2EE) and Java 2 Platform, Micro Edition (J2ME), targeting enterprise server-side applications and mobile/embedded devices, respectively.
   - These editions expanded Java's reach into various domains, including enterprise software development, mobile applications, and embedded systems.

6. **Open Sourcing of Java (2006-2007)**:

   - In 2006, Sun Microsystems announced plans to open-source the Java platform under the GNU General Public License (GPL). This initiative led to the creation of the OpenJDK (Open Java Development Kit) project.
   - Java's open-sourcing helped foster collaboration and innovation within the Java community and paved the way for broader adoption of the language.

7. **Acquisition by Oracle Corporation (2010)**:

   - In 2010, Oracle Corporation acquired Sun Microsystems, becoming the new steward of the Java platform. Oracle continued to develop and support Java, releasing new versions and updates under the Oracle brand.

8. **Java 8 and Beyond (2014-Present)**:
   - Java 8, released in 2014, introduced significant language enhancements, including lambda expressions, the Stream API, and the java.time package for date and time manipulation.
   - Subsequent releases, such as Java 9 (introducing modules), Java 10 (local-variable type inference), Java 11 (Long-Term Support release), and Java 12-17 (with various improvements and features), continued to evolve the Java platform to meet the needs of modern software development.

## Writing, compiling and executing a simple Java program

To understand how a Java program works, let's consider a simple example:

```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```

Now, let's break down what happens when you compile and run this Java program:

1. **Compilation**:

   - You write the Java code in a text editor and save it with a `.java` extension, such as `HelloWorld.java`.
   - You use the Java compiler (`javac`) to compile the source code into bytecode. This bytecode is stored in a file with a `.class` extension, such as `HelloWorld.class`.

2. **Execution**:

   - To execute the compiled bytecode, you use the Java Virtual Machine (JVM).
   - When you run the program (`java HelloWorld`), the JVM loads the bytecode (`HelloWorld.class`) into memory and starts executing it.
   - The JVM locates the `main` method, which serves as the entry point of the program.
   - It creates a new execution stack (thread) for the `main` method.
   - The statements inside the `main` method are executed sequentially.

3. **Output**:
   - In this example, the `System.out.println()` statement prints "Hello, World!" to the standard output (usually the console).
   - The JVM manages the interaction with the underlying operating system to display the output.

From the JVM's point of view, here's what happens when the compiled code is run:

- **Class Loading**:

  - The JVM loads the necessary class files into memory, including the `HelloWorld` class.
  - It verifies the bytecode to ensure it follows the rules of the Java language and does not violate security constraints.

- **Bytecode Execution**:

  - The JVM interprets the bytecode instructions and executes them on the host system.
  - Optionally, the JVM may use Just-In-Time (JIT) compilation to translate frequently executed bytecode into native machine code for improved performance.

- **Memory Management**:

  - The JVM manages memory allocation and deallocation, including garbage collection to reclaim memory occupied by objects no longer in use.

- **Exception Handling**:

  - The JVM handles any exceptions that occur during program execution, either by catching and handling them within the program or propagating them to the calling code.

- **Resource Management**:

  - The JVM ensures proper management of system resources, such as file handles, network connections, and memory, to prevent resource leaks and conflicts.

- **Security Management**:
  - The JVM enforces security policies defined for the Java application, such as access control and sandboxing, to prevent malicious code from causing harm to the system.

## Packages in Java

In Java, packages are used to organize classes and interfaces into namespaces, providing a way to group related code together and avoid naming conflicts. A package is essentially a directory or folder structure within which Java classes can reside. Packages help in organizing large codebases, promoting modularity, and enhancing code readability and maintainability.

Here's how packages work and are used in Java:

1. **Package Declaration**:

   - At the beginning of a Java source file, you can declare the package to which the class belongs using the `package` keyword followed by the package name. For example:
     ```java
     package com.example.myproject;
     ```

2. **Directory Structure**:

   - Packages in Java map directly to directory structures in the file system. Each component of the package name corresponds to a subdirectory within the source folder.
   - For example, the package `com.example.myproject` would typically be located in a directory structure like `com/example/myproject`.

3. **Import Statements**:

   - To use classes or interfaces from other packages in your Java code, you need to import them using the `import` statement.
   - For example:
     ```java
     import com.example.otherpackage.OtherClass;
     ```

4. **Access Modifiers**:

   - Classes, interfaces, constructors, methods, and fields can have access modifiers (`public`, `protected`, `private`, or package-private) that specify their visibility to other classes and packages.
   - The default (package-private) access level means that the class or member is accessible only within its own package.

5. **Java Standard Library Packages**:

   - Java comes with a vast standard library organized into packages. For example, the `java.util` package contains utility classes and data structures, while `java.io` contains classes for input and output operations.

6. **Creating and Using Custom Packages**:

   - You can create your own packages to organize your code. Simply create directories corresponding to the package structure and place your Java files (`.java` files) inside those directories.
   - For example, if you want to create a package named `com.example.myproject`, you would create a directory structure like `com/example/myproject` and place your Java files in that directory.

7. **Package Naming Conventions**:

   - By convention, package names are written in lowercase letters to differentiate them from class names, which are typically written in CamelCase.
   - Package names often start with the reverse domain name of the organization, followed by additional sub-packages as needed.
   - For example, `com.example.myproject` might be a package for a project developed by Example.com.

8. **Package Visibility**:
   - Classes and members declared with package-private access can be accessed by other classes within the same package but are not visible outside the package.
   - This helps in encapsulating implementation details and providing a clean separation of concerns.

## Variables and data types

In Java, variables can be broadly classified into two types: primitives and references. Each type serves different purposes and has its own characteristics.

1. **Primitive Variables**:

   - Primitive variables hold simple, predefined data types, such as integers, floating-point numbers, characters, and boolean values. They store actual values rather than references to objects.
   - There are eight primitive data types in Java:
     - `byte`: 8-bit signed integer
     - `short`: 16-bit signed integer
     - `int`: 32-bit signed integer
     - `long`: 64-bit signed integer
     - `float`: 32-bit floating-point number
     - `double`: 64-bit floating-point number
     - `char`: 16-bit Unicode character
     - `boolean`: true or false value
   - Primitive variables are stored directly in memory, typically on the stack, and their values are accessed directly without indirection.
   - Examples of primitive variable declarations and assignments:
     ```java
     int age = 30;
     double salary = 50000.50;
     char grade = 'A';
     boolean isStudent = true;
     ```

2. **Reference Variables**:
   - Reference variables store references (memory addresses) to objects rather than the actual objects themselves. Objects in Java are instances of classes.
   - When an object is created using the `new` keyword, memory is allocated on the heap, and the reference variable holds the memory address where the object resides.
   - Reference variables allow you to work with complex data structures and create relationships between objects.
   - Examples of reference variable declarations:
     ```java
     String name; // Reference to a String object
     MyClass obj; // Reference to an object of class MyClass
     ```
   - To create an object and assign it to a reference variable:
     ```java
     MyClass obj = new MyClass();
     ```
   - In this example, `obj` is a reference variable that holds the memory address of the newly created `MyClass` object.
   - Reference variables are typically stored on the stack (holding the reference) while the actual object resides in the heap memory.

## Operators in Java

In Java, operators are symbols that perform operations on operands, which can be variables, literals, or expressions. Java supports a wide range of operators, which can be classified into several categories based on their functionality. Here are the different types of operators in Java:

1. **Arithmetic Operators**:

   - Arithmetic operators perform basic mathematical operations such as addition, subtraction, multiplication, division, and modulus.
   - `+` (addition)
   - `-` (subtraction)
   - `*` (multiplication)
   - `/` (division)
   - `%` (modulus, returns the remainder of a division)

2. **Assignment Operators**:

   - Assignment operators are used to assign values to variables.
   - `=` (simple assignment)
   - `+=` (addition assignment)
   - `-=` (subtraction assignment)
   - `*=` (multiplication assignment)
   - `/=` (division assignment)
   - `%=` (modulus assignment)
   - `<<=` (left shift assignment)
   - `>>=` (right shift assignment)
   - `&=` (bitwise AND assignment)
   - `|=` (bitwise OR assignment)
   - `^=` (bitwise XOR assignment)

3. **Comparison Operators**:

   - Comparison operators compare two operands and return a boolean value (`true` or `false`) based on the comparison result.
   - `==` (equality)
   - `!=` (inequality)
   - `<` (less than)
   - `>` (greater than)
   - `<=` (less than or equal to)
   - `>=` (greater than or equal to)

4. **Logical Operators**:

   - Logical operators perform logical operations on boolean operands and return a boolean result.
   - `&&` (logical AND)
   - `||` (logical OR)
   - `!` (logical NOT)

5. **Bitwise Operators**:

   - Bitwise operators perform bitwise operations on integer operands at the bit level.
   - `&` (bitwise AND)
   - `|` (bitwise OR)
   - `^` (bitwise XOR)
   - `~` (bitwise complement)
   - `<<` (left shift)
   - `>>` (right shift)
   - `>>>` (unsigned right shift)

6. **Unary Operators**:

   - Unary operators operate on a single operand.
   - `+` (unary plus)
   - `-` (unary minus)
   - `++` (increment)
   - `--` (decrement)
   - `!` (logical NOT)

7. **Conditional Operator (Ternary Operator)**:

   - The conditional operator (`? :`) is a ternary operator that evaluates a boolean expression and returns one of two values based on the result of the evaluation.

8. **Instanceof Operator**:

   - The `instanceof` operator is used to test whether an object is an instance of a particular class or interface.

9. **Type Cast Operator**:
   - The type cast operator (`(type)`) is used to explicitly convert a value from one data type to another.

## Conditional statements - if/else

Conditional statements, such as `if` and `else`, allow a program to make decisions based on certain conditions. These statements help control the flow of execution by executing specific blocks of code if certain conditions are met. Here's an explanation of how `if` and `else` statements work in Java with realistic examples:

### `if` Statement:

The `if` statement is used to execute a block of code if a specified condition evaluates to true. If the condition is false, the block of code inside the `if` statement is skipped.

```java
int age = 25;

if (age >= 18) {
    System.out.println("You are an adult.");
}
```

Explanation:

- In this example, the `if` statement checks if the variable `age` is greater than or equal to 18.
- If the condition (`age >= 18`) is true, the message "You are an adult." is printed to the console.
- Since the value of `age` (25) satisfies the condition, the message is printed.

### `if-else` Statement:

The `if-else` statement allows you to execute one block of code if a condition is true and another block if the condition is false.

```java
int temperature = 25;

if (temperature > 30) {
    System.out.println("It's hot outside.");
} else {
    System.out.println("It's not too hot outside.");
}
```

Explanation:

- In this example, the `if-else` statement checks if the variable `temperature` is greater than 30.
- If the condition (`temperature > 30`) is true, the message "It's hot outside." is printed.
- If the condition is false, the code inside the `else` block is executed, and the message "It's not too hot outside." is printed.

### Realistic Examples:

1. **User Authentication**:

   ```java
   String username = "user";
   String password = "password";

   if (inputUsername.equals(username) && inputPassword.equals(password)) {
       System.out.println("Login successful.");
   } else {
       System.out.println("Invalid username or password.");
   }
   ```

   - In this example, the `if` statement checks if the input username and password match the predefined values. If they match, the user is authenticated, and a success message is printed. Otherwise, an error message is displayed.

2. **Grade Calculation**:

   ```java
   int score = 85;

   if (score >= 90) {
       System.out.println("Grade: A");
   } else if (score >= 80) {
       System.out.println("Grade: B");
   } else if (score >= 70) {
       System.out.println("Grade: C");
   } else {
       System.out.println("Grade: F");
   }
   ```

   - In this example, the `if-else if-else` ladder checks the score and assigns a grade based on predefined ranges. Depending on the score, a corresponding grade is printed.

Conditional statements like `if` and `else` are essential for implementing logic in Java programs, allowing developers to create dynamic and responsive applications that respond to changing conditions and inputs.
