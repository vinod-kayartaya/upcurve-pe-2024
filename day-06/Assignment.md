# Target UpCurve PE 2024

## Assignment for Day 6

### Classes, inheritance and polymorphism

Create the classes `Person`, `Student`, and `Staff` as shown in the _UML_ diagram below:

![](https://raw.githubusercontent.com/kayartaya-vinod/2019_07_SAPIENT_BOOTCAMP/master/JavaWorkspace/Assignments/images/ExerciseOOP_PersonAndSubclasses.png)

In the `main()` function of a Program class, create an array of `Person` references with the initialisation shown below:

```java
Person[] people = {
	new Student("Shyam", "Bangalore, Karnataka", "Java fundamentals", 2010, 4500.0),
	new Staff("Anand", "Bangalore, Karnataka", "Delhi Public school", 35000.0),
	new Staff("Umesh", "Bangalore, Karnataka", "National Public school", 42000.0),
	new Student("Suresh", "Hassan, Karnataka", "Java fundamentals", 2012, 4750.0),
	new Student("Kiran", "Vasco, Goa", "ReactJS", 2017, 12500.0)
};

```

Print the details of all `Person` objects (using the `toString()`).

---

### Classes, inheritance and polymorphism

Create the classes `Shape`, `Circle`, `Rectangle`, and `Square` as shown in the _UML_ diagram below:

![](https://raw.githubusercontent.com/kayartaya-vinod/2019_07_SAPIENT_BOOTCAMP/master/JavaWorkspace/Assignments/images/ExerciseOOP_ShapeAndSubclasses.png)

The `toString` function of the above classes should return text as given below:

| Classname | Sample return value from toString()                                                                                                          |
| --------- | -------------------------------------------------------------------------------------------------------------------------------------------- |
| Shape     | A Shape with color of xxx and filled/Not filled                                                                                              |
| Circle    | A Circle with radius=xxx, which is a subclass of yyy (where yyy is the output of the toString() method from the superclass)                  |
| Rectangle | A Rectangle with width=xxx and length=zzz, which is a subclass of yyy (where yyy is the output of the toString() method from the superclass) |
| Square    | A Square with side=xxx, which is a subclass of yyy (where yyy is the output of the toString() method from the superclass)                    |

In the `main()` method of a Program class, create an array of 10 `Shape` references containing a mixture of `Circle`, `Rectangle` and `Square` objects of different dimensions. Using a loop, print the `perimeter` and `area` for all of them.
