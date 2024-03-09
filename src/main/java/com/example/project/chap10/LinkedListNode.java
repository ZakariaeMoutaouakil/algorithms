package com.example.project.chap10;

public class LinkedListNode<T> {
    public LinkedListNode<T> prev;
    public LinkedListNode<T> next;
    public T data;

    public LinkedListNode(T data) {
        // Initialize a node of a doubly linked list with the given data
        this.prev = null;
        this.next = null;
        this.data = data;
    }

    @Override
    public String toString() {
        // Return data as a string
        return String.valueOf(data);
    }
}
