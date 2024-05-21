package com.targetindia.stacks.arrays;

import com.targetindia.stacks.Stack;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayStack<T> implements Stack<T> {

    private int capacity = 5;
    private Object[] elements;
    private int top = -1;

    public ArrayStack() {
        elements = new Object[capacity]; // O(1)
    } // O(1)

    public ArrayStack(int capacity) {
        this.capacity = capacity; // O(1)
        elements = new Object[capacity]; // O(1)
    } // O(1)

    @Override
    public void push(T item) {
        if (top == capacity - 1) { // O(1)
            grow();  // O(n)
        }
        top++; // O(1)
        elements[top] = item; // O(1)
    } // O(n) <-- worst case time complexity

    private void grow() {
        // make room for new elements or increase (usually double) the capacity
        capacity *= 2; // O(1)
        Object[] newElements = new Object[capacity]; // O(1)
        // copy values from `elements` to `newElements`
        for (int i = 0; i < elements.length; i++) { // O(n)
            newElements[i] = elements[i]; // O(1)
        }
        // using the builtin native function
        // System.arraycopy(elements, 0, newElements, 0, elements.length);
        elements = newElements; // O(1)
    } // O(n)

    @Override
    public T peek() {
        if (top == -1) { // O(1)
            throw new NoSuchElementException("Stack is empty!"); // O(1)
        }
        return (T) elements[top]; // O(1)
    } // O(1)

    @Override
    public T pop() {
        if (top == -1) { // O(1)
            throw new NoSuchElementException("Stack is empty!"); // O(1)
        }
        var data = elements[top]; // O(1)
        elements[top] = null; // O(1)
        top--; // O(1)
        return (T) data; // O(1)
    } // O(1)

    @Override
    public boolean isEmpty() {
        return top == -1; // O(1)
    } // O(1)

    @Override
    public String toString() {
        if (top == -1) { // O(1)
            return "[]"; // O(1)
        }

        StringBuilder sb = new StringBuilder(); // O(1)
        sb.append("["); // O(M)
        for (int i = 0; i < top; i++) { // O(N)
            sb.append(elements[i]); // O(M)
            sb.append(", "); // O(M)
        }
        sb.append(elements[top]); // O(M)
        sb.append("]"); // O(M)
        return sb.toString(); // O(1)
    } // O(N)
}
