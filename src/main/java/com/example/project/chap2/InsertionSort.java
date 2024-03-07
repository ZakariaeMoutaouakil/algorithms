package com.example.project.chap2;


import com.example.project.AbstractSortingAlgorithm;

import java.util.Comparator;

public class InsertionSort<T> extends AbstractSortingAlgorithm<T> {
    public InsertionSort() {
        super();
    }

    public InsertionSort(Comparator<T> comparator) {
        super(comparator);
    }

    @Override
    public void sort(T[] A) {
        for (int i = 1; i < A.length; i++) {
            T key = A[i];
            int j = i - 1;
            while (j >= 0 && (comparator.compare(A[j], key) > 0)) {
                A[j + 1] = A[j];
                j--;
            }
            A[j + 1] = key;
        }
    }
}
