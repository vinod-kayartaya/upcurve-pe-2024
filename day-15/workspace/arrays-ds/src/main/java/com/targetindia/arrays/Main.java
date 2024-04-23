package com.targetindia.arrays;

import com.targetindia.utils.KeyboardUtil;

import java.util.Arrays;

class Array {

    private int[] numbers;
    private int size = 0;
    private int capacity = 5;

    public Array() {
        numbers = new int[capacity];
    }

    public void append(int data) {
        if (size == capacity) { // O(1)
            capacity *= 2; // O(1)
            var newNumbers = new int[capacity]; // O(1)
            for (int i = 0; i < size; i++) { // O(n)
                newNumbers[i] = numbers[i]; // O(1)
            }
            numbers = newNumbers; // O(1) // old object will be garbage collected eventually
        }
        numbers[size++] = data; // O(1)
    } // O(n) --> Linear time complexity

    public void display() {
        StringBuffer sb = new StringBuffer(); // O(1)
        sb.append("[");
        for (int i = 0; i < size; i++) { // O(n)
            sb.append(numbers[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        System.out.println("Array (raw): " + Arrays.toString(numbers)); // O(n)
        System.out.println("Array content: " + sb);
    } // O(n) --> Linear time complexity

    public void prepend(int data) {
        capacity++;
        var newNumbers = new int[capacity];
        newNumbers[0] = data;
        for (int i = 0; i < size; i++) {
            newNumbers[i + 1] = numbers[i];
        } // O(n)
        numbers = newNumbers;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (size == 0) {
            throw new RuntimeException("Empty array; nothing to delete");
        }
        if (index < 0 || index >= size) {
            throw new RuntimeException("Invalid index. Must be >=0 and <" + size);
        }

        int[] newNumbers = new int[capacity];
        for (int i = 0; i < index; i++) {
            newNumbers[i] = numbers[i];
        }
        for (int i = index + 1; i < size; i++) {
            newNumbers[i - 1] = numbers[i];
        }
        numbers = newNumbers;
        size--;
    }
}


public class Main {

    static Array array = new Array();


    public static void main(String[] args) {
        for (int i : Arrays.asList(19, 40, 29, 58, 55, 38, 31)) {
            array.append(i);
        }

        int choice;
        int data;
        int index;

        do {
            array.display();
            System.out.println("*** Main Menu ***");
            System.out.println("0. Exit");
            System.out.println("1. Append");
            System.out.println("2. Prepend");
            System.out.println("3. Delete at a given index");
            // Assignment tasks:
            System.out.println("4. Delete a given value");
            System.out.println("5. Insert at a given index");
            System.out.println("6. Reverse");
            System.out.println("7. Rotate"); // first element is removed and appended to the end
            choice = KeyboardUtil.getInt("Enter your choice: ");

            switch (choice) {
                case 0:
                    System.out.println("exiting...");
                    break;
                case 1:
                    data = KeyboardUtil.getInt("Enter data to append: ");
                    array.append(data);
                    break;
                case 2:
                    data = KeyboardUtil.getInt("Enter data to prepend: ");
                    array.prepend(data);
                    break;
                case 3:
                    index = KeyboardUtil.getInt("Enter index to delete value at: ");
                    try {
                        array.deleteAtIndex(index);
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }


        } while (choice != 0);
    }
}
