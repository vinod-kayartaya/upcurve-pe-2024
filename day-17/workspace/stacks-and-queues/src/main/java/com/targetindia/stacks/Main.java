package com.targetindia.stacks;

import com.targetindia.stacks.sll.SinglyLinkedListStack;
import com.targetindia.utils.KeyboardUtil;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class Main {

    public static void main(String[] args) {

        Stack<Integer> stack = new SinglyLinkedListStack<>();

        int choice;
        while (true) {
            // System.out.println("Stack content: " + (stack.isEmpty() ? "[]" : stack));
            System.out.println("Stack content: " + stack);

            System.out.println("*** Main Menu ***");
            System.out.println("0. Exit");
            System.out.println("1. Push");
            System.out.println("2. Peek");
            System.out.println("3. Pop");
            try {
                choice = KeyboardUtil.getInt("Enter your choice: ");
            } catch (InputMismatchException e) {
                choice = -1;
            }

            if (choice == 0) {
                System.out.println("Exiting...");
                break;
            }

            if (choice == 1) {
                try {
                    var data = KeyboardUtil.getInt("Enter data to push: ");
                    stack.push(data);
                } catch (InputMismatchException e) {
                    System.out.println("Invalid data type. Try only with integers.");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else if (choice == 2) {
                try {
                    System.out.println("Top of the stack contains: " + stack.peek());
                } catch (NoSuchElementException e) {
                    System.out.println("Stack is empty, nothing to peek!");
                }
            } else if (choice == 3) {
                if (stack.isEmpty()) {
                    System.out.println("Stack is empty!");
                } else {
                    var poppedData = stack.pop();
                    System.out.println("Popped data is " + poppedData);
                }
            } else {
                System.out.println("Invalid choice. Please try again.");
            }

        }
    }
}
