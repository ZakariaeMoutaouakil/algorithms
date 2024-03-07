package com.example.project.chap7;


import com.example.project.AbstractSortingAlgorithm;

import java.util.Comparator;

public class QuickSort<T> extends AbstractSortingAlgorithm<T> {
    public QuickSort() {
        super();
    }

    public QuickSort(Comparator<T> comparator) {
        super(comparator);
    }

    static <T> int partition(T[] A, int p, int r, Comparator<T> comparator) {
        T x = A[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (comparator.compare(A[j], x) <= 0) {
                i++;
                T temp = A[j];
                A[j] = A[i];
                A[i] = temp;
            }
        }
        T temp = A[i + 1];
        A[i + 1] = A[r];
        A[r] = temp;
        return i + 1;
    }

    static <T> void sort(T[] A, int p, int r, Comparator<T> comparator) {
        if (p < r) {
            int q = partition(A, p, r, comparator);
            sort(A, p, q - 1, comparator);
            sort(A, q + 1, r, comparator);
        }
    }

    @Override
    public void sort(T[] A) {
        sort(A, 0, A.length - 1, this.comparator);
    }
}
