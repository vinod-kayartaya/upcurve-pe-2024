package com.targetindia.model;

import com.targetindia.exceptions.InvalidIdException;
import com.targetindia.exceptions.InvalidSalaryException;

public class Employee {
    private int id;
    private String name;
    private double salary;
    private Gender gender = Gender.MALE;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id < 0) {
            throw new InvalidIdException("id must be >=0");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary < 40000 || salary > 1000000) {
            throw new InvalidSalaryException("salary must be between ₹40,000/- and ₹10,00,000/-");
        }
        this.salary = salary;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", gender=" + gender +
                '}';
    }
}
