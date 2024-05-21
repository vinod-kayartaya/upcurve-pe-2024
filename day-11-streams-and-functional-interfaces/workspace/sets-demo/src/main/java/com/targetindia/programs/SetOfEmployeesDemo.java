package com.targetindia.programs;

import com.targetindia.model.Employee;

import java.util.Set;
import java.util.TreeSet;

public class SetOfEmployeesDemo {
    public static void main(String[] args) {
        Set<Employee> emps;

        emps = new TreeSet<>();


        Employee emp4 = new Employee(8907, "Harish Raj", 78000.0);
        emps.add(emp4);

        Employee emp5 = new Employee(5362, "Kumar Vinay", 87600.0);
        emps.add(emp5);

        emps.add(new Employee(8392, "Uday", 42873));
        emps.add(new Employee(8392, "Ramesh", 42873));
        emps.add(new Employee(6671, "James", 78100));
        emps.add(new Employee(2121, "Albert", 67101));
        emps.add(new Employee(2121, "Albert", 67101));
        emps.add(new Employee(8912, "Albert", 65000));
        emps.add(new Employee(8912, "Albert", 50000));
        emps.add(new Employee(8899, "Albert", 50000));
        emps.add(new Employee(6671, "James", 78100));
        emps.add(new Employee(8765, "James", 78100));
        emps.add(new Employee(5678, "James", 78100));

        Employee emp1 = new Employee(1122, "Ravi Kumar", 45900.0);
        emps.add(emp1);

        Employee emp2 = new Employee(1122, "Ravi Kumar", 45900.0);
        emps.add(emp2);

        Employee emp3 = new Employee(1122, "Ravi Kumar", 45900.0);
        emps.add(emp3);


        System.out.printf("there are %d employees in emps\n", emps.size());
        for(var e: emps){
            System.out.println(e);
        }
    }
}
