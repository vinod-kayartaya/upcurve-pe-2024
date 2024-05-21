package com.targetindia.programs;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class ReadFromKeyboard {

    public static void main1(String[] args) throws Exception{
        System.out.println("enter your name: ");
        int ch = System.in.read();
        System.out.println("You entered: ");
        System.out.println((char)ch);
    }

    public static void main2(String[] args)  throws Exception{
        byte[] bytes = new byte[25];
        System.out.println(Arrays.toString(bytes));
        System.out.println("enter your name: ");
        System.in.read(bytes);
        System.out.println("you entered: ");
        System.out.println(Arrays.toString(bytes));
        String name = new String(bytes).trim();
        System.out.printf("**%s**\n", name);
    }

    public static void main3(String[] args) throws Exception{
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(reader);
        System.out.println("enter your name: ");
        String name = in.readLine();
        System.out.println("hello, " + name + "!");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name;
        int age;
        double height;

        System.out.printf("enter your age: ");
        age = sc.nextInt(); // "20\n"
        System.out.printf("enter your height: ");
        sc = new Scanner(System.in);
        height = sc.nextDouble(); // "5.1\n"
        System.out.printf("enter your name: ");
        // sc.nextLine(); // skip till \n
        sc = new Scanner(System.in);
        name = sc.nextLine();

        System.out.printf("'%s' (aged about %d years) is %.2f ft. tall\n", name, age, height);
    }
}
