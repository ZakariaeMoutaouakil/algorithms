package com.example.project.chap10;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DLLSentinel<T> implements Iterable<T> {
    private final LinkedListNode<T> sentinel;

    public DLLSentinel() {
        // Initialize the sentinel of a circular doubly linked list with a sentinel
        this.sentinel = new LinkedListNode<>(null); // holds null as data
        this.sentinel.next = this.sentinel; // the sentinel points to itself in an empty list
        this.sentinel.prev = this.sentinel;
    }

    public LinkedListNode<T> search(Object k) {
        // Search a circular doubly linked list with a sentinel for a node with key k
        LinkedListNode<T> x = this.sentinel.next;
        while (x != this.sentinel && !x.data.equals(k)) x = x.next;
        return x != this.sentinel ? x : null;
    }

    public LinkedListNode<T> insert(T data, LinkedListNode<T> y) {
        // Insert a node with data after node y. Return the new node
        LinkedListNode<T> x = new LinkedListNode<>(data);
        x.next = y.next;
        x.prev = y;
        y.next.prev = x;
        y.next = x;
        return x;
    }

    public LinkedListNode<T> prepend(T data) {
        // Insert a node with data as the head of a circular doubly linked list with a sentinel. Return the new node
        return insert(data, this.sentinel);
    }

    public LinkedListNode<T> append(T data) {
        // Append a node with data to the tail of a circular doubly linked list with a sentinel. Return the new node
        return insert(data, this.sentinel.prev);
    }

    public void delete(LinkedListNode<T> x) {
        // Remove a node x from the circular doubly linked list with a sentinel
        if (x == this.sentinel) throw new RuntimeException("Cannot delete sentinel.");
        x.prev.next = x.next;
        x.next.prev = x.prev;
    }


    public void deleteAll() {
        // Delete all nodes in a circular doubly linked list with a sentinel
        this.sentinel.next = this.sentinel;
        this.sentinel.prev = this.sentinel;
    }

    public DLLSentinel<T> copy() {
        // Return a copy of this circular doubly linked list with a sentinel
        DLLSentinel<T> c = new DLLSentinel<>();
        LinkedListNode<T> x = this.sentinel.next;
        while (x != this.sentinel) {
            c.append(x.data);
            x = x.next;
        }
        return c;
    }

    @Override
    public Iterator<T> iterator() {
        // Iterator from the head of a circular doubly linked list with a sentinel
        return new Iterator<>() {
            LinkedListNode<T> current = sentinel.next;

            @Override
            public boolean hasNext() {
                return current != sentinel;
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    @Override
    public String toString() {
        // Return this circular doubly linked list with a sentinel formatted as a list
        StringBuilder sb = new StringBuilder("[");
        LinkedListNode<T> x = this.sentinel.next;
        while (x != this.sentinel) {
            sb.append(x.data).append(", ");
            x = x.next;
        }
        if (sb.length() > 1) sb.setLength(sb.length() - 2); // Remove trailing comma and space
        sb.append("]");
        return sb.toString();
    }
}
