package com.targetindia.tests;

import org.junit.jupiter.api.*;

class LifeCycleDemo {

    @BeforeAll
    static void thisExecutesOnlyOnceBefore(){
        System.out.println("before the execution of any test case..");
    }

    @AfterAll
    static void thisExecutesOnlyOnceAfter(){
        System.out.println("after the execution of any test case..");
    }

    @BeforeEach
    void setUp(){
        System.out.println("doing test initialization...");
    }

    @AfterEach
    void tearDown(){
        System.out.println("doing clean up after a test case...");
    }

    @Test
    void test1(){
        System.out.println("test case 1 executed");
    }
    @Test
    void test2(){
        System.out.println("test case 2 executed");
    }
    @Test
    void test3(){
        System.out.println("test case 3 executed");
    }

}
