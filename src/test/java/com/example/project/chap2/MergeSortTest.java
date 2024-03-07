package com.example.project.chap2;
import org.junit.jupiter.api.Test;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Comparator;
import static org.assertj.core.api.Assertions.assertThat;

class MergeSortTest {

    @Test
    void mergeSort_mergesTwoSortedArraysIntoOne() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // Given
        MergeSort<Integer> mergeSort = new MergeSort<Integer>(Comparator.naturalOrder());
        Integer[] A = {1, 3, 5, 2, 4, 6};
        Integer[] expected = {1, 2, 3, 4, 5, 6};
        Method mergeMethod = MergeSort.class.getDeclaredMethod("merge", Object[].class, int.class, int.class, int.class);
        mergeMethod.setAccessible(true);

        // When
        mergeMethod.invoke(mergeSort, A, 0, 2, 5);

        // Then
        assertThat(A).isEqualTo(expected);
    }

    @Test
    void mergeSort_sortsAnArray() {
        // Given
        MergeSort<Integer> mergeSort = new MergeSort<Integer>(Comparator.naturalOrder());
        Integer[] A = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        Integer[] expected = {1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9};

        // When
        mergeSort.sort(A);

        // Then
        assertThat(A).isEqualTo(expected);
    }
}


