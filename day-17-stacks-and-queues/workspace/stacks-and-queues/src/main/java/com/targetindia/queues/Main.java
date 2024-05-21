package com.targetindia.queues;

import com.targetindia.utils.KeyboardUtil;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {

        Queue<String> queue = new LinkedListQueue<>();

        int choice;
        while (true) {
            System.out.println("Queue content: " + queue);

            System.out.println("*** Main Menu ***");
            System.out.println("0. Exit");
            System.out.println("1. Enqueue");
            System.out.println("2. Peek");
            System.out.println("3. Dequeue");
            System.out.println("4. Size");

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
                var data = KeyboardUtil.getString("Enter data to enqueue: ");
                queue.enqueue(data);
            } else if (choice == 2) {
                try {
                    System.out.println("First element in the queue is: " + queue.peek());
                } catch (NoSuchElementException e) {
                    System.out.println("Queue is empty, nothing to peek!");
                }
            } else if (choice == 3) {
                if (queue.isEmpty()) {
                    System.out.println("Queue is empty!");
                } else {
                    var removedData = queue.dequeue();
                    System.out.println("Removed data is " + removedData);
                }
            }
            else if(choice==4){
                System.out.println("Size of the queue is " + queue.size());
            }
            else {
                System.out.println("Invalid choice. Please try again.");
            }

        }
    }
}
