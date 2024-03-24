package com.targetindia.programs;

import com.targetindia.model.Person;

public class EncapsulationDemo {

    public static void main(String[] args) {
        Person p1, p2, p3;

        p1 = new Person(); // call to the default constructor (given by compiler)
        p1.setName("    Vinod    ");
        p1.setAge(50);
        p1.setHeight(5.8);

        p2 = new Person();
        p2.setFields("Shyam", 51, 5.11); // not a java convention

        p3 = new Person("Murali", 57, 5.9); // convention

        p1.print();
        p2.print();
        p3.print();

    }
}
