package com.example.project.chap10;

public class Stack<T> {
    private final T[] stack;
    private final int size;
    private int top; // index of the top element

    @SuppressWarnings("unchecked")
    public Stack(int n) {
        this.stack = (T[]) new Object[n];
        this.size = n;
        this.top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(T x) {
        if (top == size - 1) {
            throw new RuntimeException("Stack overflow");
        } else {
            top++;
            stack[top] = x;
        }
    }

    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack underflow");
        } else {
            T element = stack[top];
            top--;
            return element;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i <= top; i++) {
            sb.append(stack[i]).append(", ");
        }
        if (!isEmpty()) {
            sb.setLength(sb.length() - 2);
        }
        sb.append("]");
        return sb.toString();
    }
}