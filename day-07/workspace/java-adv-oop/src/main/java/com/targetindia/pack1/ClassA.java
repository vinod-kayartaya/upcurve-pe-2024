package com.targetindia.pack1;

public class ClassA {
    private void privateFunction(){
        System.out.println("privateFunction() called");
    }
    void packageFunction(){
        System.out.println("packageFunction() called");
    }
    protected void protectedFunction(){
        System.out.println("protectedFunction() called");
    }
    public void publicFunction(){
        System.out.println("publicFunction() called");
    }

    // inside this very class, we can access any of these methods
    public static void main(String[] args) {
        ClassA ca = new ClassA();
        ca.privateFunction();
        ca.packageFunction();
        ca.protectedFunction();
        ca.publicFunction();
    }
}
