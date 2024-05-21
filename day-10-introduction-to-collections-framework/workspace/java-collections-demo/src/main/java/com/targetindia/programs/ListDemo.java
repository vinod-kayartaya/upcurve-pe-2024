package com.targetindia.programs;

import com.targetindia.model.Person;

import java.util.*;

public class ListDemo {

    static class PersonAgeComparator implements  Comparator<Person>{
        @Override
        public int compare(Person p1, Person p2) {
            return Integer.compare(p1.age(), p2.age());
        }
    }

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Shyam", 51, 5.11));
        people.add(new Person("Ramesh", 45, 5.07));
        people.add(new Person("Vinay", 46, 6.01));
        people.add(new Person("Rohit", 42, 5.08));

        System.out.println("before sorting:");
        for(var p: people){
            System.out.println(p);
        }

        Comparator<Person> cmp = new PersonAgeComparator();
        Collections.sort(people, cmp);

        System.out.println("after sorting:");
        for(var p: people){
            System.out.println(p);
        }

        cmp = new Comparator<Person>(){
            public int compare(Person p1, Person p2) {
                return Double.compare(p1.height(), p2.height());
            }
        };
        Collections.sort(people, cmp);

        System.out.println("after sorting:");
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
