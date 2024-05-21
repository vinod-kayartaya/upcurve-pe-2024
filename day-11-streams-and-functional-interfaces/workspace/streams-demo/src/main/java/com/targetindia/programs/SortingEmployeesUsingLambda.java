package com.targetindia.programs;

import com.targetindia.model.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingEmployeesUsingLambda {
    public static void main(String[] args) {
        List<Employee> emps = new ArrayList<>();
        emps.add(new Employee(123, "Vinay", 35000));
        emps.add(new Employee(879, "Rajesh", 55000));
        emps.add(new Employee(276, "Kiran", 39000));
        emps.add(new Employee(637, "Kishore", 45000));
        emps.add(new Employee(782, "Anil", 42000));

        System.out.println("ordered based on ids (default):");
        Collections.sort(emps);
        for (var e : emps) {
            System.out.println(e);
        }

        System.out.println("ordered based on names:");
        Collections.sort(emps, (e1, e2) -> e1.name().compareTo(e2.name()));
        for (var e : emps) {
            System.out.println(e);
        }

        System.out.println("ordered based on salaries:");
        Collections.sort(emps, (e1, e2) -> Double.compare(e1.salary(), e2.salary()));
        for (var e : emps) {
            System.out.println(e);
        }
    }
}
