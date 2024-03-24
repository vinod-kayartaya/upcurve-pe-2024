package com.targetindia.model;

public class Person {
    private String name;
    private int age;
    private double height;

    public Person() {
        // having this no-arg constructor is always considered as a best practice
        // aka default constructor (since it resembles the one given by the compiler
        // when we didn't have any constructor)
    }

    public Person(String name, int age, double height) {
        setName(name);
        setAge(age);
        setHeight(height);
    }

    // writable property or mutator
    public void setName(String name) {
        name = name.trim();
        if (name.length() < 3 || name.length() > 15) {
            throw new RuntimeException("name must be between 3 and 15 letters.");
        }
        this.name = name;
    }

    // readable property or accessor
    public String getName() {
        return name;
    }

    public void setAge(int age) {
        if (age < 1 || age > 120) {
            throw new RuntimeException("age must be between 1 and 120 years.");
        }
        this.age = age;
    }

    public int getAge() {
        return age;
    }


    public void setHeight(double height) {
        if (height <= 0 || height > 9) {
            throw new RuntimeException("height must be > 0 and <= 9");
        }
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    // generally we do not create these functions/methods
    public void setFields(String name, int age){
        setName(name);
        setAge(age);
    }

    public void setFields(String name, int age, double height){
        setName(name);
        setAge(age);
        setHeight(height);
    }



    public void print() {
        System.out.printf("Name   : \"%s\"\n", name);
        System.out.printf("Age    : %d years\n", age);
        System.out.printf("Height : %.2f\n", height);
        System.out.println();
    }


}
