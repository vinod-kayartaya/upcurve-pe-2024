package com.targetindia.pack2;

import com.targetindia.pack1.ClassA;

public class ClassD extends ClassA {

    void test(){
        // privateFunction(); // although inherited, cannot be accessed
        // packageFunction(); // although inherited, cannot be accessed because the package is different
        protectedFunction(); // can be accessed in a child class only from a member function of the child class
        publicFunction();
    }

    public static void main(String[] args) {
        ClassA ca = new ClassA();
        // ca.privateFunction();
        // ca.packageFunction();
        // ca.protectedFunction();
        ca.publicFunction();
    }
}
