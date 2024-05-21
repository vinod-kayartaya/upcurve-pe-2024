package com.targetindia.pack2;

import com.targetindia.pack1.ClassA;

public class ClassC {
    public static void main(String[] args) {
        ClassA ca = new ClassA();
        // ca.privateFunction(); // private members are accessible only inside the same class
        // ca.packageFunction(); // package level members can be accessed from any class only if they are in the same package
        // ca.protectedFunction();
        ca.publicFunction();
    }
}
