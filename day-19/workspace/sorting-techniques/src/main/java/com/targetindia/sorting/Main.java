package com.targetindia.sorting;

import com.targetindia.utils.KeyboardUtil;

import java.util.Arrays;
import java.util.Random;

// Assignment tasks for day 19
// TODO: Implement which ever sorting techniques possible on a linked list
public class Main {

    public static void main(String[] args) {
        // declare and initialize an array with random values
        int[] array = new int[10];
        Random r = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt(100);
        }

        int choice;
        the_loop:
        while (true) {
            // display the array content (unsorted)
            System.out.println("Array content: " + Arrays.toString(array));

            System.out.println("\n*** Main Menu ***");
            System.out.println("0. Exit");
            System.out.println("1. Re-initialize the array");
            System.out.println("2. Bubble sort");
            System.out.println("3. Selection sort");
            System.out.println("4. Insertion sort");
            System.out.println("5. Merge sort");

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
                    for (int i = 0; i < array.length; i++) {
                        array[i] = r.nextInt(100);
                    }
                    break;
                case 2:
                    bubbleSort(array);
                    break;
                case 3:
                    selectionSort(array);
                    break;
                case 4:
                    insertionSort(array);
                case 5:
                    mergeSort(array);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    public static void bubbleSort(int[] array) {
        int len = array.length;
        for (int i = 0; i < len - 1; i++) {
            // System.out.println("Array --> " + Arrays.toString(array));
            for (int j = 0; j < len - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    var tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        // System.out.println("Array --> " + Arrays.toString(array));

//        for (int i = 0; i < len; i++) {
//            System.out.println("Array --> " + Arrays.toString(array));
//            for (int j = len - 1; j > i; j--) {
//                if (array[j] < array[j - 1]) {
//                    var tmp = array[j];
//                    array[j] = array[j - 1];
//                    array[j - 1] = tmp;
//                }
//            }
//        }
//        System.out.println("Array --> " + Arrays.toString(array));
    }


    public static void selectionSort(int[] array) {
        int len = array.length;

        for (int i = 0; i < len - 1; i++) {
            var minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex == i) continue; // there is no need to do swapping

            var tmp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = tmp;
        }
    }

    public static void insertionSort(int[] array) {
        var len = array.length;

        for (int i = 1; i < len; i++) {
            var key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }


    public static void mergeSort(int[] array) {
        if (array.length > 1) { // terminal condition for recursion
            var mid = array.length / 2;
            int[] left = new int[mid];
            int[] right = new int[array.length - mid];
            System.arraycopy(array, 0, left, 0, mid);
            System.arraycopy(array, mid, right, 0, array.length - mid);


            mergeSort(left);
            mergeSort(right);

            // System.out.println(Arrays.toString(left));
            // System.out.println(Arrays.toString(right));

            int i = 0; // index for `left`
            int j = 0; // index for `right`
            int k = 0; // index for `array`, to which `left` and `right` are going to be merged
            while (i < left.length && j < right.length) {
                if (left[i] < right[j]) {
                    array[k++] = left[i++];
                } else {
                    array[k++] = right[j++];
                }
            }

            while (i < left.length) {
                array[k++] = left[i++];
            }
            while (j < right.length) {
                array[k++] = right[j++];
            }
            // System.out.println(Arrays.toString(array));

        }
    }

}
