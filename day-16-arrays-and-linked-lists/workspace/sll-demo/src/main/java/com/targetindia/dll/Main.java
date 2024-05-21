package com.targetindia.dll;


import com.targetindia.utils.KeyboardUtil;

import java.util.NoSuchElementException;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        DoublyLinkedList list = new DoublyLinkedList();

        // let's populate the list with some initial values
        Stream.of(19, 49, 13, 59, 333, 283, 293, 100).forEach(list::append);

        the_loop:
        while (true) {
            list.displayForward();
            list.displayBackward();

            System.out.println("\n*** Main Menu ***");
            System.out.println("0. Exit");
            System.out.println("1. Prepend");
            System.out.println("2. Append");
            System.out.println("3. Size");
            // todo: assignment tasks
            System.out.println("4. Search");
            System.out.println("5. Delete the first element");
            System.out.println("6. Delete the last element");
            System.out.println("7. Insert data at a given index");
            System.out.println("8. Delete data at a given index");

            int choice;

            try {
                choice = KeyboardUtil.getInt("Enter your choice: ");
            } catch (Exception e) {
                choice = -1;
            }

            switch (choice) {
                case 0:
                    System.out.println("Exiting...");
                    break the_loop;
                case 1:
                case 2:
                    try {
                        int data = KeyboardUtil.getInt("Enter data: ");
                        if (choice == 1) {
                            list.prepend(data);
                        } else if (choice == 2) {
                            list.append(data);
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid data type");
                    }
                    break;
                case 3:
                    System.out.println("Size = " + list.size());
                    break;
                case 5:
                    try {
                        int deleteData = list.deleteFirst();
                        System.out.println("Deleted data = " + deleteData);
                    } catch (NoSuchElementException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }


        }
    }
}
