package com.targetindia.programs;

import java.util.Arrays;

public class CommandLineArgumentsDemo {

    public static void main(String[] args) {
        System.out.printf("Got %d arguments\n", args.length);
        System.out.println(Arrays.toString(args));
    }
}
