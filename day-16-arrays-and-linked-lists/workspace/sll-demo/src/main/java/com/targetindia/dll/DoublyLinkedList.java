package com.targetindia.dll;

import com.targetindia.sll.SinglyLinkedList;

import java.util.NoSuchElementException;

public class DoublyLinkedList {


    class ListNode {
        ListNode prev;
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.prev = null; // this is the default behavior; no need to do this.
            this.next = null; // this is the default behavior; no need to do this.
        }

    }

    private ListNode head;
    private ListNode tail;
    private int length;


    public int size() {
        return length;
    }

    public void prepend(int data) {
        length++;
        var newNode = new ListNode(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void append(int data) {
        length++;
        var newNode = new ListNode(data);
        if (head == null) { // or tail==null
            head = tail = newNode;
            return;
        }

        newNode.prev = tail;
        tail = tail.next = newNode;
    }

    public void displayForward() {
        var curr = head;
        System.out.print("HEAD <-> ");
        while (curr != null) {
            System.out.print(curr.data);
            System.out.print(" <-> ");
            curr = curr.next;
        }
        System.out.println("TAIL");
    }


    public void displayBackward() {
        var curr = tail;
        System.out.print("TAIL <-> ");
        while (curr != null) {
            System.out.print(curr.data);
            System.out.print(" <-> ");
            curr = curr.prev;
        }
        System.out.println("HEAD");
    }

    public int deleteFirst() throws NoSuchElementException {
        if (head == null) { // or tail==null
            throw new NoSuchElementException("List is empty!");
        }

        length--;

        if (head == tail) {
            // only element in the list
            int data = head.data;
            head = tail = null;
            return data;
        }

        var nodeToDelete = head;
        head = head.next;
        head.prev = null;
        nodeToDelete.next = null;
        return nodeToDelete.data;
    }
}
