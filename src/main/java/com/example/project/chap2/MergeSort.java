package com.example.project.chap2;


import com.example.project.AbstractSortingAlgorithm;

import java.util.Comparator;

public class MergeSort<T> extends AbstractSortingAlgorithm<T> {
    public MergeSort() {
        super();
    }

    public MergeSort(Comparator<T> comparator) {
        super(comparator);
    }

    private void merge(T[] A, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;

        // Create temporary arrays
        T[] left = (T[]) new Object[n1];
        T[] right = (T[]) new Object[n2];

        // Copy data to temporary arrays
        System.arraycopy(A, p, left, 0, n1);
        System.arraycopy(A, q + 1, right, 0, n2);

        // Merge the temporary arrays

        // Initial indexes of first and second sub-arrays
        int i = 0, j = 0;

        // Initial index of merged subarray
        int k = p;
        while (i < n1 && j < n2) {
            if (comparator.compare(left[i], right[j]) <= 0) {
                A[k++] = left[i++];
            } else {
                A[k++] = right[j++];
            }
        }

        // Copy remaining elements of left[] if any
        while (i < n1) {
            A[k++] = left[i++];
        }

        // Copy remaining elements of right[] if any
        while (j < n2) {
            A[k++] = right[j++];
        }
    }

    private void mergeSort(T[] A, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(A, p, q);
            mergeSort(A, q + 1, r);
            merge(A, p, q, r);
        }
    }

    @Override
    public void sort(T[] A) {
        mergeSort(A, 0, A.length - 1);
    }
}