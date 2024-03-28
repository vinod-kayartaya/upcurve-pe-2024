package com.targetindia.pack1;

public class ClassB {
    public static void main(String[] args) {
        ClassA ca = new ClassA();
        // ca.privateFunction(); // private members are accessible only inside the same class
        ca.packageFunction();
        ca.protectedFunction();
        ca.publicFunction();
    }
}
