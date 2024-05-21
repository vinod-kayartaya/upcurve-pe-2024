package com.targetindia.programs;

import com.targetindia.exceptions.InvalidIdException;
import com.targetindia.exceptions.InvalidSalaryException;
import com.targetindia.model.Employee;

public class CustomExceptionDemo {
    public static void main(String[] args) {

        Employee emp;
        emp = new Employee();

        try {
            emp.setId(-1223);
            emp.setName("Kishore Kumar");
            emp.setSalary(9850);
        }
        catch (InvalidIdException e){
            System.out.println("Invalid value for id");
        }
        catch (InvalidSalaryException e){
            System.out.println("Invalid value for salary");
        }

        System.out.println(emp);
    }
}
