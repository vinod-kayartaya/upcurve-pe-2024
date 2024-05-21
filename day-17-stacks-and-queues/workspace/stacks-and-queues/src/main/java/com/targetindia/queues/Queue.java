package com.targetindia.queues;

import java.util.NoSuchElementException;

public interface Queue<T> {
    public void enqueue(T value);

    public T peek() throws NoSuchElementException;

    public T dequeue() throws NoSuchElementException;

    public boolean isEmpty();

    public int size();

}
