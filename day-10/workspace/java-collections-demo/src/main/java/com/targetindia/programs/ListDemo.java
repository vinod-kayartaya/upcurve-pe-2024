package com.targetindia.programs;

import com.targetindia.model.Person;

import java.util.*;

public class ListDemo {

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Shyam", 51, 5.11));
        people.add(new Person("Ramesh", 45, 5.7));
        people.add(new Person("Shyam", 51, 5.11));
        people.add(new Person("Shyam", 51, 5.11));

        for(var p: people){
            System.out.println(p);
        }
    }
    public static void main1(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(123);
        numbers.add(303);
        numbers.add(303);
        numbers.add(100);
        numbers.add(200);
        numbers.add(303);
        numbers.add(560);
        numbers.add(0, 999);

        var tens = Arrays.asList(10, 20, 30, 40);
        numbers.addAll(tens);
        numbers.addAll(3, tens);

        var index = numbers.indexOf(1000);
        System.out.println(numbers);
        System.out.printf("100 is at index %s of numbers list\n", index);
        var elem = numbers.get(10);
        System.out.printf("at index 10 of numbers %d exists\n", elem);
    }
}
