package com.targetindia.programs;

import com.targetindia.model.IGreet;

public class LambdaFunctionDemo {

    static void doGreet(IGreet greet) {
        System.out.println("greet is an instanceof clas " + greet.getClass().getName());
        greet.hello();
    }

    public static void main(String[] args) {

        IGreet g = new IGreet() {
            @Override
            public void hello() {
                System.out.println("hello, world!");
            }

        };

        doGreet(g);


        // version 2
        doGreet(new IGreet() {
            @Override
            public void hello() {
                System.out.println("hello, anonymous object!");
            }

        });

        // version 3
        doGreet(() -> {
            System.out.println("hello, lambda!");
        });

        // version 4
        doGreet(() -> System.out.println("hello, lambda again!"));
    }
}
