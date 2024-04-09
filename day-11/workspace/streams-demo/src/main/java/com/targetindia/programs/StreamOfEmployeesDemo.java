package com.targetindia.programs;

import com.targetindia.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class StreamOfEmployeesDemo {

    static Employee findById(List<Employee> employees, int id) {
        return employees.stream()
                .filter(emp -> emp.id() == id)
                .findFirst()
                .orElse(null);
    }

    public static void main(String[] args) {

        List<Employee> emps = new ArrayList<>();
        emps.add(new Employee(123, "Vinay", 35000));
        emps.add(new Employee(879, "Rajesh", 55000));
        emps.add(new Employee(276, "Kiran", 39000));
        emps.add(new Employee(637, "Kishore", 45000));
        emps.add(new Employee(782, "Anil", 42000));

        var result = findById(emps, 276);
        System.out.println(result);

        System.out.println("==================");

        // print all the employee names
        emps                                        // List<Employee>
                .stream()                           // Stream<Employee>
                .map(emp -> emp.name())             // Stream<String>
                .map(name -> name.toUpperCase())    // Stream<String>
                .forEach(name -> System.out.println(name));

        System.out.println("---------");
        // print all the employee names
        emps                                        // List<Employee>
                .stream()                           // Stream<Employee>
                .filter(emp -> emp.salary() <= 40000)// Stream<Employee>
                .map(Employee::name)                // Stream<String>
                .map(String::toUpperCase)           // Stream<String>
                .forEach(System.out::println);
        System.out.println("---------");

        emps
                .stream()
                .filter(emp -> emp.salary() >= 40000)
                // .peek(System.out::println)
                .forEach(StreamOfEmployeesDemo::printEmp);
    }

    static void printEmp(Employee emp) {
        System.out.printf("%s --> Rs.%.2f\n", emp.name(), emp.salary());
    }
}
