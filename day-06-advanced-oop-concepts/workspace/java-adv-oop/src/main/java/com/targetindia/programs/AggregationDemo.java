package com.targetindia.programs;

import com.targetindia.model.Department;
import com.targetindia.model.Employee;

public class AggregationDemo {
    public static void main(String[] args) {
        Department accounting = new Department();
        accounting.setId(1012);
        accounting.setName("Accounting");
        accounting.setLocation("Bangalore");

        Employee emp1 = new Employee(102, "Ajay", 98000);
        emp1.setDepartment(accounting);

        Employee emp2 = new Employee();
        emp2.setId(221);
        emp2.setName("Manoj");
        emp2.setSalary(78999);
        emp2.setDepartment(accounting);

        System.out.println(emp1);
        System.out.println(emp2);
    }
}
