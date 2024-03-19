package com.targetindia.programs;

import com.targetindia.model.Person;

public class UsingPersonObject {
    public static void main(String[] args) {
        Person p1;

        p1 = new Person();

        p1.setFirstname("Vinod");
        p1.setLastname("Kumar");
        p1.setEmail("vinod@vinod.co");
        p1.setPhone("9731424784");

        Person p2 = new Person("Shyam", "Sundar");
        Person p3 = new Person("John", "Doe", "john.doe@xmpl.com", "838373732");


        System.out.println("Person information: ");
        System.out.printf("Name  : %s %s\n", p1.getFirstname(), p1.getLastname());
        System.out.printf("Email : %s\n", p1.getEmail());
        System.out.printf("Phone : %s\n", p1.getPhone());

        System.out.println("p1 is: " + p1);
        System.out.println("p2 is: " + p2);
        System.out.println("p3 is: " + p3);

    }
}
