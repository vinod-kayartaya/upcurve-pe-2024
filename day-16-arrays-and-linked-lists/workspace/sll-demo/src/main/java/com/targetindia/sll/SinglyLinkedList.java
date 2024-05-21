package com.targetindia.sll;

import java.util.NoSuchElementException;

public class SinglyLinkedList {

    class ListNode {
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null; // this is the default behavior; no need to do this.
        }

    }

    ListNode head;
    int length;

    public void prepend(int data) {
        var newNode = new ListNode(data); // O(1)
        newNode.next = head; // O(1)
        head = newNode; // O(1)
        length++; // O(1)
    } // O(1)


    public void append(int data) {
        var newNode = new ListNode(data); // O(1)
        length++; // O(1)
        if (head == null) { // O(1)
            // list is empty; make the new node as the head
            head = newNode; // O(1)
            return; // O(1)
        }
        var curr = head;
        while (curr.next != null) { // O(n)
            curr = curr.next; // O(1)
        }

        curr.next = newNode;
    } // O(n)

    public void display() {
        var curr = head;
        System.out.print("HEAD -> ");
        while (curr != null) {
            System.out.print(curr.data);
            System.out.print(" -> ");
            curr = curr.next;
        }
        System.out.println("NULL");
    }

    public int size() {
        return this.length; // O(1)
    } // O(1)

    public int indexOf(int data) {
        int index = 0;
        for (var curr = head; curr != null; curr = curr.next) { // O(n)
            if (data == curr.data) {
                return index;
            }
            index++;
        }
        return -1;
    } // O(n)


    public int deleteFirst() throws NoSuchElementException {
        if (head == null) { // O(1)
            throw new NoSuchElementException("list is empty!"); // O(1)
        }

        length--;
        var curr = head; // O(1)
        head = head.next; // O(1)
        curr.next = null; // detach the node from the list (for gc) // O(1)
        return curr.data; // O(1)
    } // O(1)


    public void insert(int index, int data) throws IndexOutOfBoundsException {
        // todo: identify the worst case time complexity

        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        if (index == 0) {
            this.prepend(data);
            return;
        }

        if (index == length) {
            this.append(data);
            return;
        }

        var curr = head;
        for (int i = 0; i < index - 1; i++) {
            curr = curr.next;
        }
        var newNode = new ListNode(data);
        newNode.next = curr.next;
        curr.next = newNode;
        length++;
    }

    public int deleteAt(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        if (index == 0) {
            return this.deleteFirst();
        }

        var curr = head;
        for (int i = 0; i < index - 1; i++) {
            curr = curr.next;
        }

        var nodeToDelete = curr.next;
        curr.next = nodeToDelete.next;
        nodeToDelete.next = null;
        length--;
        return nodeToDelete.data;
    }

}
