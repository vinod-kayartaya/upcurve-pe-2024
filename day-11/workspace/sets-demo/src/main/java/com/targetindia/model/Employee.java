package com.targetindia.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Comparable<Employee> {
    private int id;
    private String name;
    private double salary;

    @Override
    public int compareTo(Employee that) {
        if(this.id==that.id){
            return 0; // duplicate employees
        }

        var result =  this.name.compareTo(that.name);
        if(result!=0) return result;

        if(this.salary < that.salary){
            return -1;
        }
        return 1;
    }
}
