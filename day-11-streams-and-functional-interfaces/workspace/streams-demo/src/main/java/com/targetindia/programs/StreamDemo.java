package com.targetindia.programs;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(29, 10, 5, 92, 299, 19, 93, 82, 84, 12, 29, 19, 5, 10);

        // from the source list, filter and print only even numbers
        numbers.stream() // Stream<Integer>
                .filter(n -> n % 2 == 0) // Stream<Integer>
                .forEach(n -> System.out.println(n));

        // from the source, filter odd numbers, square them, and get them into a new list
        var oddNumbers = numbers.stream()
                .distinct()
                .filter(n -> n % 2 == 1)
                .map(n -> n * n)
                .collect(Collectors.toList());

        System.out.println(numbers);
        System.out.println(oddNumbers);


        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(20, 2, 30),
                Arrays.asList(10, 20),
                Arrays.asList(40, 20, 2, 30),
                Arrays.asList(1, 2, 2),
                Arrays.asList(4, 5, 6),
                Arrays.asList(20, 2, 30, 8),
                Arrays.asList(2, 30)
        );

        List<List<Integer>> listOf3Elems = listOfLists
                .stream()
                .filter(list -> list.size() <= 3)
                .collect(Collectors.toList());

        System.out.println("--------");
        for (var list : listOf3Elems) {
            System.out.println(list);
        }
        System.out.println("--------");

        String[] names = {
                "vinod", "anil", "vinay", "vijay", "shyam", "sudhir", "naveen"
        };

        var viNames = Stream.of(names) // Arrays.stream(names)
                .filter(name -> name.startsWith("vi"))
                .map(name -> name.toUpperCase())
                .collect(Collectors.toList());

        System.out.println(Arrays.toString(names));
        System.out.println(viNames);


    }
}
