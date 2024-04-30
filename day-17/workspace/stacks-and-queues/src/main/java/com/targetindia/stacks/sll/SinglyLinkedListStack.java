package com.targetindia.stacks.sll;

import com.targetindia.stacks.Stack;

import java.util.NoSuchElementException;

public class SinglyLinkedListStack<T> implements Stack<T> {

    class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null; // no need to do this; defaults to `null`
        }
    }

    private Node top; // = null by default

    @Override
    public void push(T item) {
        Node newNode = new Node(item); // O(1)
        newNode.next = top; // O(1)
        top = newNode; // O(1)
    } // O(1)

    @Override
    public T peek() {
        if (top == null) { // O(1)
            throw new NoSuchElementException("Stack is empty!"); // O(1)
        }

        return top.data; // O(1)
    } // O(1)

    @Override
    public T pop() {
        if (top == null) { // O(1)
            throw new NoSuchElementException("Stack is empty!"); // O(1)
        }
        var curr = top; // O(1)
        top = top.next; // O(1)
        curr.next = null; // not needed

        return curr.data; // O(1)
    } // O(1)

    @Override
    public boolean isEmpty() {
        return top == null; // O(1)
    } // O(1)

    @Override
    public String toString() {

        if (top == null) { // O(1)
            return "[]"; // O(1)
        }

        StringBuilder sb = new StringBuilder(); // O(1)
        sb.append("Top --> "); // O(M)
        Node curr;
        for (curr = top; curr.next != null; curr = curr.next) { // O(N)
            sb.append(curr.data); // O(M)
            sb.append(", "); // O(M)
        }
        sb.append(curr.data); // O(M)
        sb.append(" --> End"); // O(M)
        return sb.toString(); // O(1)
    } // O(N)
}
