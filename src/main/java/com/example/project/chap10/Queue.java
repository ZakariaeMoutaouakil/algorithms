package com.example.project.chap10;

public class Queue<T> {
    private final T[] array;
    private final int size;
    private int head;
    private int tail;

    @SuppressWarnings("unchecked")
    public Queue(int n) {
        array = (T[]) new Object[n + 1];
        size = n;
        head = 0;
        tail = 0;
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public void enqueue(T x) {
        if ((tail + 1) % size == head) {
            throw new IllegalStateException("Queue is full.");
        }
        array[tail] = x;
        tail = (tail + 1) % size;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty.");
        }
        T x = array[head];
        head = (head + 1) % size;
        return x;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        if (!isEmpty()) {
            if (head <= (tail - 1 + size) % size) {
                for (int i = head; i <= (tail - 1 + size) % size; i++) {
                    stringBuilder.append(array[i]).append(", ");
                }
            } else {
                for (int i = head; i < size; i++) {
                    stringBuilder.append(array[i]).append(", ");
                }
                for (int i = 0; i <= (tail - 1 + size) % size; i++) {
                    stringBuilder.append(array[i]).append(", ");
                }
            }
            stringBuilder.setLength(stringBuilder.length() - 2);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
