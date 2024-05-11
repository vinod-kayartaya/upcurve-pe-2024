package com.targetindia.search;

import com.targetindia.model.Customer;
import com.targetindia.utils.KeyboardUtil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Customer[] customers = Customer.getCustomers();
        Arrays.sort(customers, (c1, c2) -> Integer.compare(c1.id(), c2.id()));

        while (true) {
            System.out.println("*** Main Menu ***");
            System.out.println("0. Exit");
            System.out.println("1. Display customers");
            System.out.println("2. Linear search");
            System.out.println("3. Binary search");
            System.out.println("4. Jump search");
            System.out.println("5. Fibonacci search");
            int choice = KeyboardUtil.getInt("Enter your choice: ");

            if (choice == 0) {
                System.out.println("Exiting...");
                break;
            }
            if (choice < 1 || choice > 5) {
                System.out.println("Invalid choice. Please try again");
                continue;
            }


            if (choice == 1) {
                for (var c : customers) {
                    System.out.println(c);
                }
                continue;
            }

            int id = KeyboardUtil.getInt("Enter customer id to search: ");
            int index = -1;

            if (choice == 2) {
                index = linearSearch(customers, id);
            } else if (choice == 3) {
                index = binarySearch(customers, id);
            } else if (choice == 4) {
                index = jumpSearch(customers, id);
            } else {
                System.out.println("Not yet implemented");
                continue;
            }


            if (index == -1) {
                System.out.println("No customer found with id " + id);
            } else {
                var c = customers[index];
                System.out.printf("Customer data found at index %d:\n", index);
                System.out.println("Name    : " + c.name());
                System.out.println("City    : " + c.city());
                System.out.println("Email   : " + c.email());
                System.out.println("Phone   : " + c.phone());
            }
            System.out.println();
        }
    }

    private static int linearSearch(Customer[] customers, int id) {
        for (int index = 0; index < customers.length; index++) { // O(n)
            if (customers[index].id() == id) { // O(1)
                return index; // O(1)
            }
        }

        return -1; // O(1)
    } // O(n)


    private static int binarySearch(Customer[] customers, int id) {
        // prerequisite for this search --> customers is in ascending order of their ids
        int low = 0;
        int high = customers.length - 1;

        if (customers[low].id() == id) {
            return 0;
        }
        if (customers[high].id() == id) {
            return high;
        }
        if (id < customers[low].id() || id > customers[high].id()) {
            return -1;
        }

        int pass = 0;
        while (low <= high) {
            pass++;
            int mid = (low + high) / 2;
            if (id == customers[mid].id()) {
                // found the element
                System.out.println("pass=" + pass);
                return mid;
            } else if (id < customers[mid].id()) {
                // the target element may exist on the left side of `mid`
                high = mid - 1;
            } else {
                // the target element may exist on the right side of `mid`
                low = mid + 1;
            }
        }
        System.out.println("pass=" + pass);
        return -1;
    }

    private static int jumpSearch(Customer[] customers, int id) {

        int blockSize = (int) Math.sqrt(customers.length);
        int prev = 0;
        int curr = blockSize;
        int loopCount = 0;

        while (curr < customers.length && customers[curr].id() <= id) {
            prev = curr;
            curr += blockSize;
            loopCount++;
        }

        for (int i = prev; i < Math.min(curr, customers.length); i++) {
            loopCount++;
            if (customers[i].id() == id) {
                System.out.println("loopCount is " + loopCount);
                return i;
            }
        }

        System.out.println("loopCount is " + loopCount);
        return -1;
    }

}
