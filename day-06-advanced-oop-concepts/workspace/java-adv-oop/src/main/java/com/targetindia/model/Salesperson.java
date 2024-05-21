package com.targetindia.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@NoArgsConstructor // good practice
public class Salesperson extends Employee{
    private double salesTarget;
    private double commissionPercent;

    public Salesperson(int id, String name, double salary, double salesTarget, double commissionPercent) {
        super(id, name, salary); // invoke the superclass constructor
        this.salesTarget = salesTarget;
        this.commissionPercent = commissionPercent;
    }

    public void print(){
        super.print();
        System.out.printf("Sales target      : $ %.2f\n", salesTarget);
        System.out.printf("Commission        : %.2f%%\n", commissionPercent);
    }
}
