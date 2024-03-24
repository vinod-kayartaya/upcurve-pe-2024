package com.targetindia.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor // for a better practice
public class Employee {
    private int id;
    private String name;
    private double salary;

    // aggregation HAS-A
    private Department department;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public void print(){
        System.out.printf("ID                : %d\n", getId());
        System.out.printf("Name              : %s\n", getName());
        System.out.printf("Salary            : %.2f\n", getSalary());
        System.out.printf("Department        : %s\n", getDepartment());
    }
}
