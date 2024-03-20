# Java programming language

## Conditional statements - switch/case

Conditional statements in Java can also be implemented using the `switch` statement, which provides an alternative way to control the flow of execution based on the value of an expression. The `switch` statement evaluates the expression and executes the code block associated with a matching case label. Here's how `switch` statements work with realistic examples:

### `switch` Statement:

The `switch` statement evaluates an expression and compares its value against a list of possible case labels. If a case label matches the value of the expression, the corresponding block of code is executed.

```java
int dayOfWeek = 3;
String dayName;

switch (dayOfWeek) {
    case 1:
        dayName = "Monday";
        break;
    case 2:
        dayName = "Tuesday";
        break;
    case 3:
        dayName = "Wednesday";
        break;
    case 4:
        dayName = "Thursday";
        break;
    case 5:
        dayName = "Friday";
        break;
    case 6:
        dayName = "Saturday";
        break;
    case 7:
        dayName = "Sunday";
        break;
    default:
        dayName = "Invalid day";
        break;
}

System.out.println("Today is " + dayName);
```

Explanation:

- In this example, the `switch` statement evaluates the value of the variable `dayOfWeek`.
- The `case` labels represent possible values of `dayOfWeek`, from 1 to 7 (representing Monday to Sunday).
- If the value of `dayOfWeek` matches one of the case labels, the corresponding `dayName` is assigned.
- The `break` statement is used to terminate the `switch` block and prevent fall-through to subsequent cases.
- If no case matches the value of `dayOfWeek`, the `default` case is executed.
- Finally, the value of `dayName` is printed to the console.

1. **Menu Selection**:

   ```java
   int choice = 2;
   String menuItem;

   switch (choice) {
       case 1:
           menuItem = "Pizza";
           break;
       case 2:
           menuItem = "Burger";
           break;
       case 3:
           menuItem = "Salad";
           break;
       default:
           menuItem = "Invalid choice";
           break;
   }

   System.out.println("You selected: " + menuItem);
   ```

   - In this example, the `switch` statement determines the selected menu item based on the value of `choice`. Depending on the value of `choice`, the corresponding menu item is assigned to `menuItem`.

2. **Season Identification**:

   ```java
   int month = 9;
   String season;

   switch (month) {
       case 12:
       case 1:
       case 2:
           season = "Winter";
           break;
       case 3:
       case 4:
       case 5:
           season = "Spring";
           break;
       case 6:
       case 7:
       case 8:
           season = "Summer";
           break;
       case 9:
       case 10:
       case 11:
           season = "Fall";
           break;
       default:
           season = "Invalid month";
           break;
   }

   System.out.println("The current season is: " + season);
   ```

   - In this example, the `switch` statement identifies the season based on the value of `month`. The `case` labels group months into seasons, and the corresponding season is assigned to the `season` variable.

`switch` statements offer a concise and structured way to handle multiple conditions based on the value of an expression. They are particularly useful when dealing with a large number of possible values or when multiple conditions need to be grouped together.

## Loops (for/while/do-while)

Loops are control structures in programming languages that allow you to execute a block of code repeatedly based on certain conditions. They help automate repetitive tasks and enable efficient iteration over data structures. In Java, there are several types of loops: `for`, `while`, `do-while`, and enhanced `for` loop. Let's explore each of them in detail with examples:

### 1. `for` Loop:

The `for` loop is used when you know the number of iterations in advance.

Syntax:

```java
for (initialization; condition; update) {
    // code to be executed
}
```

Example:

```java
for (int i = 1; i <= 5; i++) {
    System.out.println("Iteration: " + i);
}
```

Explanation:

- In this example, the loop initializes the variable `i` to 1, executes the loop body as long as `i` is less than or equal to 5, and increments `i` by 1 after each iteration.
- The loop prints "Iteration: 1", "Iteration: 2", ..., "Iteration: 5" to the console.

### 2. `while` Loop:

The `while` loop is used when you don't know the number of iterations in advance, and the loop continues as long as the condition is true.

Syntax:

```java
while (condition) {
    // code to be executed
}
```

Example:

```java
int count = 1;
while (count <= 5) {
    System.out.println("Count: " + count);
    count++;
}
```

Explanation:

- In this example, the loop continues as long as `count` is less than or equal to 5.
- The loop prints "Count: 1", "Count: 2", ..., "Count: 5" to the console.

### 3. `do-while` Loop:

The `do-while` loop is similar to the `while` loop, but it always executes the loop body at least once before checking the condition.

Syntax:

```java
do {
    // code to be executed
} while (condition);
```

Example:

```java
int num = 1;
do {
    System.out.println("Number: " + num);
    num++;
} while (num <= 5);
```

Explanation:

- In this example, the loop prints "Number: 1", "Number: 2", ..., "Number: 5" to the console.
- Even if the condition `num <= 5` is false initially, the loop body executes at least once.

### 4. Enhanced `for` Loop (for-each Loop):

The enhanced `for` loop is used to iterate over elements in an array or collection sequentially without using an explicit loop counter.

Syntax:

```java
for (type element : array/collection) {
    // code to be executed
}
```

Example (Array):

```java
int[] numbers = {1, 2, 3, 4, 5};
for (int num : numbers) {
    System.out.println("Number: " + num);
}
```

Explanation:

- In this example, the loop iterates over each element in the `numbers` array and prints its value to the console.

Example (Collection):

```java
List<String> fruits = Arrays.asList("Apple", "Banana", "Orange");
for (String fruit : fruits) {
    System.out.println("Fruit: " + fruit);
}
```

- In this example, the loop iterates over each element in the `fruits` collection and prints its value to the console.

Loops are fundamental constructs in programming and are used extensively to iterate over data, perform calculations, and control the flow of execution. By understanding the different types of loops and their syntax, you can write more efficient and concise code to accomplish various tasks in Java.

## Common lifecycle phases (goals) of Maven

- clean --> deletes the `target` folder and its content
- compile --> compiles java files in src/main/java folder
- test-compile --> compiles java files in src/test/java folder
- test --> runs the unit tests from src/test/java folder
- package --> creates JAR file from your compiled files
- install --> installs the current maven artifact in local repository
- deploy --> used for publishing this artifact to maven central

## Different types of class you may write:

- program --> class with a `public static void main(String[] args)` method
- entity/model/domain --> a class that represents information (book, person, employee, student, flight, etc)
- service --> class that contain domain (or business) specific logics (`transferFunds` functionality in a banking application)
- dao/repository --> class that contain logic to store/retrieve/udpdate/delete data on a secondary storage (such as file or rdbms or no-sql databases)
- exception --> a class that represents an erroneous situation
- utitlities --> helper methods (usually static) (for example, KeyboardUtil, DbUtil, Math, ...)

# Object-Oriented Programming (OOP) in Java

## Principles of Object-Oriented Programming (OOP) in Java

Object-Oriented Programming (OOP) is a programming paradigm that revolves around the concept of "objects", which can contain data and code to manipulate that data. Java, as a widely-used object-oriented programming language, embodies several fundamental principles that guide the design and implementation of software. These principles are encapsulation, inheritance, polymorphism, and abstraction.

### 1. Encapsulation:

Encapsulation refers to the bundling of data (attributes) and methods (functions) that operate on the data into a single unit called an object. It hides the internal state of an object from the outside world and only exposes a limited interface through which the object can be accessed and manipulated. This helps in achieving data security, code reusability, and modularity.

**Example:**

```java
public class Car {
    private String brand;
    private int year;

    // Getter and setter methods
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
```

### 2. Inheritance:

Inheritance is a mechanism that allows a class (subclass or derived class) to inherit properties and behavior from another class (superclass or base class). It promotes code reuse and establishes a hierarchical relationship between classes. The subclass can extend the functionality of the superclass by adding new methods or overriding existing ones.

**Example:**

```java
public class Animal {
    public void sound() {
        System.out.println("Animal makes a sound");
    }
}

public class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("Dog barks");
    }
}
```

### 3. Polymorphism:

Polymorphism allows objects of different classes to be treated as objects of a common superclass. It enables methods to behave differently based on the object that invokes them. There are two types of polymorphism: compile-time (method overloading) and runtime (method overriding).

**Example:**

```java
public class Shape {
    public void draw() {
        System.out.println("Drawing a shape");
    }
}

public class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }
}

public class Square extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a square");
    }
}
```

### 4. Abstraction:

Abstraction focuses on hiding the complex implementation details and showing only the essential features of an object. It allows programmers to work at a higher level of abstraction without worrying about the internal complexities. Abstract classes and interfaces are used to achieve abstraction in Java.

**Example:**

```java
public abstract class Shape {
    public abstract void draw();
}

public class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }
}

public class Square extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a square");
    }
}
```

Understanding and applying these principles of OOP in Java facilitate the creation of efficient, modular, and maintainable software systems. Each principle serves a specific purpose in software design and plays a crucial role in developing robust and scalable applications.

## Classes and Objects in Java

In Java, classes and objects are fundamental concepts of object-oriented programming (OOP). They form the building blocks of Java programs, encapsulating data and behavior into reusable components. Let's delve into each of these concepts in detail:

### Classes:

1. **Definition**:

   - A class in Java is a blueprint or template for creating objects. It defines the attributes (data) and methods (behavior) that objects of the class will have.

2. **Syntax**:

   ```java
   public class ClassName {
       // Fields (attributes)
       dataType fieldName1;
       dataType fieldName2;

       // Methods
       returnType methodName1(parameterList) {
           // Method body
       }

       returnType methodName2(parameterList) {
           // Method body
       }
       // Other members
   }
   ```

3. **Example**:

   ```java
   public class Car {
       // Fields
       private String brand;
       private int year;

       // Constructor
       public Car(String brand, int year) {
           this.brand = brand;
           this.year = year;
       }

       // Methods
       public String getBrand() {
           return brand;
       }

       public int getYear() {
           return year;
       }
   }
   ```

4. **Fields (Attributes)**:

   - Fields represent the state of an object. They store data associated with objects of the class.

5. **Methods**:

   - Methods define the behavior of objects. They encapsulate the operations that can be performed on the object's data.

6. **Constructor**:
   - Constructors are special methods used for initializing objects. They are invoked automatically when an object is created.

### Objects:

1. **Definition**:

   - An object is an instance of a class. It represents a real-world entity and encapsulates both data and behavior.

2. **Syntax**:

   ```java
   ClassName objectName = new ClassName();
   ```

3. **Example**:

   ```java
   Car myCar = new Car("Toyota", 2022);
   ```

4. **Instantiation**:

   - The `new` keyword is used to create objects of a class. It allocates memory for the object and calls the constructor to initialize its state.

5. **Accessing Members**:

   - Members (fields and methods) of an object are accessed using the dot (`.`) operator.

6. **Instance Variables**:
   - Each object has its own set of instance variables (fields) that store unique data.

### Key Points:

- Classes provide a blueprint for creating objects with shared characteristics and behaviors.
- Objects are instances of classes and represent specific entities in the real world.
- Classes encapsulate data and behavior, promoting code reusability and modularity.
- Objects have unique states determined by their instance variables.
- Interaction between objects is achieved by invoking methods on objects.

In Java, the concept of classes and objects forms the foundation of OOP, enabling developers to model complex systems effectively and build scalable, maintainable software solutions. Understanding how to define classes, create objects, and interact with them is essential for Java programmers.

## Constructors and Method Overloading in Java

In Java, constructors and method overloading are essential features that contribute to the flexibility and robustness of object-oriented programming. They allow developers to initialize objects and define multiple methods with the same name but different parameter lists, respectively. Let's explore each of these concepts in detail:

### Constructors:

1. **Definition**:

   - A constructor in Java is a special type of method that is invoked when an object of a class is created. It is used to initialize the state of the object, typically setting initial values for its instance variables.

2. **Syntax**:

   ```java
   public class ClassName {
       // Constructor
       public ClassName(parameterList) {
           // Constructor body
       }
   }
   ```

3. **Example**:

   ```java
   public class Car {
       private String brand;
       private int year;

       // Constructor
       public Car(String brand, int year) {
           this.brand = brand;
           this.year = year;
       }
   }
   ```

4. **Types**:

   - **Default Constructor**: If no constructor is defined in a class, Java provides a default constructor with no parameters.
   - **Parameterized Constructor**: Allows passing initial values to initialize the object's state.

5. **Purpose**:
   - Constructors ensure that newly created objects are properly initialized before they are used.
   - They help in achieving encapsulation by initializing the internal state of objects.

### Method Overloading:

1. **Definition**:

   - Method overloading in Java allows a class to have multiple methods with the same name but different parameter lists. The compiler determines which method to execute based on the number and types of arguments passed to it.

2. **Syntax**:

   ```java
   public returnType methodName(type1 param1) {
       // Method body
   }

   public returnType methodName(type1 param1, type2 param2) {
       // Method body
   }
   ```

3. **Example**:

   ```java
   public class Calculator {
       public int add(int num1, int num2) {
           return num1 + num2;
       }

       public double add(double num1, double num2) {
           return num1 + num2;
       }
   }
   ```

4. **Key Points**:
   - Method overloading enables developers to define methods that perform similar tasks but with different parameter types or numbers.
   - Return type alone is not sufficient to differentiate overloaded methods.
   - Overloaded methods can have different access modifiers, return types, and exceptions.

### Constructor Overloading:

1. **Definition**:

   - Constructor overloading refers to having multiple constructors within a class, each with a different parameter list. It allows objects to be initialized in different ways.

2. **Example**:

   ```java
   public class Person {
       private String name;
       private int age;

       // Constructor 1
       public Person(String name) {
           this.name = name;
       }

       // Constructor 2
       public Person(String name, int age) {
           this.name = name;
           this.age = age;
       }
   }
   ```

3. **Purpose**:
   - Constructor overloading provides flexibility in object initialization by allowing different combinations of parameters.
   - It promotes code reusability and simplifies object creation.

In Java, constructors and method overloading are powerful features that enhance the flexibility and usability of classes. Constructors ensure proper initialization of objects, while method overloading enables developers to create more intuitive and versatile APIs. Understanding and effectively using these concepts are essential for writing clean and maintainable Java code.

## Inheritance and Method Overriding in Java

In Java, inheritance is a powerful mechanism that allows a class to inherit properties and behaviors (methods) from another class, known as the superclass or base class. Method overriding is a feature of inheritance that enables a subclass to provide a specific implementation of a method that is already defined in its superclass. Let's delve deeper into each of these concepts:

### Inheritance:

1. **Definition**:

   - Inheritance is a mechanism by which a class can acquire properties (fields) and behaviors (methods) of another class. The class that inherits is called a subclass or derived class, while the class being inherited from is called a superclass or base class.

2. **Syntax**:

   ```java
   class Superclass {
       // Members
   }

   class Subclass extends Superclass {
       // Members
   }
   ```

3. **Example**:

   ```java
   class Animal {
       void eat() {
           System.out.println("Animal is eating");
       }
   }

   class Dog extends Animal {
       // Dog inherits the eat() method from Animal
   }
   ```

4. **Purpose**:
   - Inheritance promotes code reusability by allowing subclasses to reuse code defined in their superclasses.
   - It establishes a hierarchical relationship among classes, enabling specialization and generalization.

### Method Overriding:

1. **Definition**:

   - Method overriding is a feature of inheritance that allows a subclass to provide its own implementation of a method that is already defined in its superclass. The overridden method must have the same name, return type, and parameters as the method in the superclass.

2. **Syntax**:

   ```java
   class Superclass {
       void display() {
           // Method implementation
       }
   }

   class Subclass extends Superclass {
       @Override
       void display() {
           // Overridden method implementation
       }
   }
   ```

3. **Example**:

   ```java
   class Animal {
       void makeSound() {
           System.out.println("Animal makes a sound");
       }
   }

   class Dog extends Animal {
       @Override
       void makeSound() {
           System.out.println("Dog barks");
       }
   }
   ```

4. **Key Points**:
   - Method overriding is used to provide a specific implementation of a method in a subclass to meet its specific requirements.
   - The `@Override` annotation is optional but recommended for clarity. It indicates that a method is being overridden from the superclass.
   - The overridden method must have the same signature (name, return type, and parameters) as the method in the superclass.

### Inheritance and Method Overriding in Action:

1. **Example**:

   ```java
   public class Main {
       public static void main(String[] args) {
           Animal animal = new Dog(); // Upcasting
           animal.makeSound(); // Output: "Dog barks"
       }
   }
   ```

2. **Explanation**:
   - In this example, an instance of `Dog` is assigned to a reference variable of type `Animal`, demonstrating polymorphism.
   - Despite the reference being of type `Animal`, the overridden method `makeSound()` from the `Dog` class is invoked at runtime.

In conclusion, inheritance and method overriding are fundamental concepts in Java that facilitate code reuse, extensibility, and polymorphism. By leveraging these features effectively, developers can design and implement flexible and maintainable object-oriented solutions.

## Access Modifiers in Java

Access modifiers in Java are keywords used to control the visibility and accessibility of classes, methods, and fields in a program. They specify the level of access that other classes or components have to the members of a class. Java provides four types of access modifiers:

1. **Public**:

   - The `public` access modifier makes members accessible from any other class, regardless of the package they belong to.
   - Public members can be accessed from anywhere in the program.
   - Example:
     ```java
     public class MyClass {
         public int publicField;

         public void publicMethod() {
             // Method implementation
         }
     }
     ```

2. **Private**:

   - The `private` access modifier restricts access to members within the same class.
   - Private members are not accessible from outside the class, including subclasses.
   - Example:
     ```java
     public class MyClass {
         private int privateField;

         private void privateMethod() {
             // Method implementation
         }
     }
     ```

3. **Protected**:

   - The `protected` access modifier allows access to members within the same package or subclasses.
   - Protected members are accessible within the same package and subclasses, even if they are in different packages.
   - Example:
     ```java
     public class MyClass {
         protected int protectedField;

         protected void protectedMethod() {
             // Method implementation
         }
     }
     ```

4. **Default (Package-private)**:
   - If no access modifier is specified, the default access modifier (also known as package-private) is applied.
   - Members with default access are accessible only within the same package.
   - They are not accessible outside the package or by subclasses in other packages.
   - Example:
     ```java
     class MyClass {
         int defaultField;

         void defaultMethod() {
             // Method implementation
         }
     }
     ```

### Guidelines for Choosing Access Modifiers:

- **Encapsulation**: Encapsulate fields by making them private and provide public methods to access and modify them, ensuring data integrity.
- **Information Hiding**: Hide internal implementation details by making sensitive methods or fields private.
- **Flexibility**: Use protected access when you want subclasses to have access to certain members, but restrict access to other classes.
- **Avoid Overexposure**: Limit access to only what is necessary to reduce dependencies and improve maintainability.

Understanding access modifiers is crucial for designing well-structured and secure Java applications. By choosing appropriate access levels, developers can control the visibility and accessibility of their code, promoting encapsulation, modularity, and code reuse.
