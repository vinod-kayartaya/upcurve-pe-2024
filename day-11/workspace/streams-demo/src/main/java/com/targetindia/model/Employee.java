package com.targetindia.model;

public record Employee(int id, String name, double salary) implements Comparable<Employee> {

    // provides  natural ordering system for Employee objects
    @Override
    public int compareTo(Employee other) {
        return this.id - other.id;
    }
}
