package com.targetindia.stacks;

import com.targetindia.stacks.arrays.ArrayStack;

public interface Stack<T> {
    public void push(T item);

    public T peek();

    public T pop();

    public boolean isEmpty();

}
