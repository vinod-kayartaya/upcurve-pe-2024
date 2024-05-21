package com.targetindia.programs;

import com.targetindia.model.Department;
import com.targetindia.model.Salesperson;

public class InheritanceDemo {
    public static void main(String[] args) {

        var dept = new Department(3831, "Sales", "Mumbai");

        Salesperson sp1 = new Salesperson(); // memory allocated is for the variables in Salesperson and Employee
        // i.e, sp1 refers to an object with these member fields:
        // id, name, salary, department, salesTarget, commissionPercent
        sp1.setId(282);
        sp1.setName("Rohini");
        sp1.setSalary(59000);
        sp1.setSalesTarget(2000000);
        sp1.setCommissionPercent(0.05);
        sp1.setDepartment(dept);

        Salesperson sp2 = new Salesperson(381, "Ramesh", 45000, 2000000, 0.04);
        sp2.setDepartment(dept);

        // System.out.println(sp1);
        // System.out.println(sp2);
        sp1.print();
        System.out.println();
        sp2.print();
    }
}
