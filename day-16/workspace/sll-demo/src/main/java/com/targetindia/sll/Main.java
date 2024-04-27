package com.targetindia.sll;

import com.targetindia.utils.KeyboardUtil;

import java.util.NoSuchElementException;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        SinglyLinkedList list = new SinglyLinkedList();

        // let's populate the list with some initial values
        Stream.of(19, 49, 13, 59, 333, 283, 293, 100).forEach(list::append);

        the_loop:
        while (true) {
            list.display();
            System.out.println("\n*** Main Menu ***");
            System.out.println("0. Exit");
            System.out.println("1. Prepend");
            System.out.println("2. Append");
            System.out.println("3. Size");
            System.out.println("4. Search");
            System.out.println("5. Delete the first element");
            System.out.println("6. Insert data at a given index");
            System.out.println("7. Delete data at a given index");

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
                case 4:
                case 6:
                    try {
                        int data = KeyboardUtil.getInt("Enter data: ");
                        if (choice == 1) {
                            list.prepend(data);
                        } else if (choice == 2) {
                            list.append(data);
                        } else if (choice == 4) {
                            var index = list.indexOf(data);
                            if (index == -1) {
                                System.out.println("Data not found!");
                            } else {
                                System.out.println("Data found at index " + index);
                            }
                        } else if (choice == 6) {
                            int index = KeyboardUtil.getInt("Enter index: ");
                            list.insert(index, data);
                        }
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Invalid index for insertion");
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
                case 7:
                    try {
                        int index = KeyboardUtil.getInt("Enter index: ");
                        int deleteData = list.deleteAt(index);
                        System.out.println("Deleted data = " + deleteData);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Invalid index for deletion");
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }


        }
    }
}


