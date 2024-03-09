package com.example.project.chap10;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements Iterable<T> {
    private LinkedListNode<T> head;

    public LinkedList() {
        head = null;
    }

    public LinkedList(LinkedListNode<T> head) {
        this.head = head;
    }

    public LinkedListNode<T> search(Object k) {
        LinkedListNode<T> x = head;
        while (x != null && !x.data.equals(k)) x = x.next;
        return x;
    }

    public LinkedListNode<T> insert(T data, LinkedListNode<T> y) {
        LinkedListNode<T> x = new LinkedListNode<>(data);
        x.next = y.next;
        x.prev = y;
        if (y.next != null) y.next.prev = x;
        y.next = x;
        return x;
    }

    public LinkedListNode<T> prepend(T data) {
        LinkedListNode<T> x = new LinkedListNode<>(data);
        x.next = head;
        if (head != null) head.prev = x;
        head = x;
        return x;
    }

    public void delete(LinkedListNode<T> x) {
        if (x.prev != null) x.prev.next = x.next;
        else head = x.next;
        if (x.next != null) x.next.prev = x.prev;
    }

    public void deleteAll() {
        head = null;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator<>(head);
    }

    public LinkedList<T> copy() {
        LinkedList<T> c = new LinkedList<>();
        LinkedListNode<T> x = head;
        LinkedListNode<T> last = null;
        while (x != null) {
            if (last == null) last = c.prepend(x.data);
            else last = c.insert(x.data, last);
            x = x.next;
        }
        return c;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        LinkedListNode<T> x = head;
        while (x != null) {
            sb.append(x.data);
            if (x.next != null) sb.append(", ");
            x = x.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public static class LinkedListIterator<T> implements Iterator<T> {
        private LinkedListNode<T> current;

        public LinkedListIterator(LinkedListNode<T> head) {
            current = head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            T data = current.data;
            current = current.next;
            return data;
        }
    }
}

