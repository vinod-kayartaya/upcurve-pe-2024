package com.targetindia.programs;

import java.util.*;

public class SetDemo {

    public static void main(String[] args) {
        Set<Integer> numbers = new TreeSet<>();
        numbers.add(123);
        numbers.add(123);
        numbers.add(25);
        numbers.add(999);
        numbers.add(123);
        numbers.add(890);
        numbers.add(123);
        numbers.add(890);
        numbers.add(10);
        numbers.add(78);
        numbers.remove(123);
        var list = Arrays.asList(9, 9, 20, 19, 40, 20);
        numbers.addAll(list); // list is also a Collection
        System.out.printf("numbers contains %d integers\n", numbers.size());
        System.out.printf("numbers are : %s\n", numbers.toString());

        System.out.println("accessing elements using an iterator:");
        var itr = numbers.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

        // enhanced for loop (can loop over any Iterable object)
        // aka for-each loop
        System.out.println("accessing elements using the enhanced for loop:");
        for(var n: numbers){
            System.out.println(n);
        }
    }
}
