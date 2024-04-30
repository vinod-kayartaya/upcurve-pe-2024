package com.targetindia.queues;

import com.targetindia.stacks.sll.SinglyLinkedListStack;

import java.util.NoSuchElementException;

public class LinkedListQueue<T> implements Queue<T> {

    class Node {
        Node prev;
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
            this.prev = null; // not needed
            this.next = null; // not needed
        }
    }

    private Node head; // = null
    private Node tail; // = null
    private int size = 0;

    @Override
    public void enqueue(T value) {
        Node newNode = new Node(value); // O(1)
        if (isEmpty()) { // O(1)
            head = newNode; // O(1)
        } else {
            tail.next = newNode; // O(1)
            newNode.prev = tail; // O(1)
        }
        tail = newNode; // O(1)
        size++; // O(1)
    } // O(1)

    @Override
    public T peek() throws NoSuchElementException {
        if (isEmpty()) { // O(1)
            throw new NoSuchElementException("Queue is empty; nothing to peek"); // O(1)
        }

        return head.data; // O(1)
    } // O(1)

    @Override
    public T dequeue() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty; nothing to peek");
        } // O(1)
        size--; // O(1)
        var curr = head; // O(1)
        if (head == tail) { // exactly 1 element in the queue
            head = tail = null; // O(1)
        } else {
            head = curr.next; // O(1)
            head.prev = null; // O(1)
            curr.next = null; // O(1)
        }
        return curr.data; // O(1)
    }

    @Override
    public boolean isEmpty() {
        return head == null && tail == null; // O(1)
    } // O(1)

    @Override
    public int size() {
        return this.size; // O(1)
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "Head <-> Tail";
        }

        StringBuilder sb = new StringBuilder(); // O(1)
        sb.append("Head <-> "); // O(M)
        Node curr;
        for (curr = head; curr != null; curr = curr.next) { // O(N)
            sb.append(curr.data); // O(M)
            sb.append(" <-> "); // O(M)
        }
        sb.append("Tail"); // O(M)
        return sb.toString(); // O(1)
    } // O(N)
}
