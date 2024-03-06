package com.example.project.chap7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class QuickSortTest {
    private Comparator<Integer> comparator;

    @BeforeEach
    public void setUp() {
        comparator = Comparator.naturalOrder();
    }

    @Test
    public void testPartition() {
        Integer[] array = {2, 8, 7, 1, 3, 5, 6, 4};
        int pivotIndex = QuickSort.partition(array, 0, array.length - 1, comparator);
        Integer[] expected = {2, 1, 3, 4, 7, 5, 6, 8};
        assertArrayEquals(expected, array);
        // Ensure the pivot index is at the correct position
        assert pivotIndex == 3;
    }

    @Test
    public void testSort() {
        Integer[] array = {3, 7, 2, 1, 6, 5, 4};
        QuickSort.sort(array, 0, array.length - 1, comparator);
        Integer[] expected = {1, 2, 3, 4, 5, 6, 7};
        assertArrayEquals(expected, array);
    }

    @Test
    public void testSortWithEmptyArray() {
        Integer[] array = {};
        QuickSort.sort(array, 0, array.length - 1, comparator);
        Integer[] expected = {};
        assertArrayEquals(expected, array);
    }

    @Test
    public void testSortWithSortedArray() {
        Integer[] array = {1, 2, 3, 4, 5, 6, 7};
        QuickSort.sort(array, 0, array.length - 1, comparator);
        Integer[] expected = {1, 2, 3, 4, 5, 6, 7};
        assertArrayEquals(expected, array);
    }

    @Test
    public void testSortWithReverseSortedArray() {
        Integer[] array = {7, 6, 5, 4, 3, 2, 1};
        QuickSort.sort(array, 0, array.length - 1, comparator);
        Integer[] expected = {1, 2, 3, 4, 5, 6, 7};
        assertArrayEquals(expected, array);
    }

    @Test
    public void testSortWithRandomArray() {
        Integer[] array = {7, 2, 5, 1, 6, 3, 4};
        QuickSort.sort(array, 0, array.length - 1, comparator);
        Integer[] expected = {1, 2, 3, 4, 5, 6, 7};
        assertArrayEquals(expected, array);
    }

    @Test
    public void testSortWithDuplicateValues() {
        Integer[] array = {3, 7, 2, 1, 6, 5, 4, 3};
        QuickSort.sort(array, 0, array.length - 1, comparator);
        Integer[] expected = {1, 2, 3, 3, 4, 5, 6, 7};
        assertArrayEquals(expected, array);
    }

    @Test
    public void testSortWithNullElements() {
        Integer[] array = {3, null, 2, null, 6, 5, 4};
        QuickSort.sort(array, 0, array.length - 1, Comparator.nullsFirst(comparator));
        Integer[] expected = {null, null, 2, 3, 4, 5, 6};
        assertArrayEquals(expected, array);
    }

    @Test
    public void testQuickSort() {
        Integer[] list1 = {11, 1, 51, 1, 5, 3};
        Integer[] list1test = Arrays.copyOf(list1, list1.length);
        QuickSort<Integer> quickSort = new QuickSort<Integer>(Comparator.naturalOrder());
        quickSort.sort(list1);
        assertArrayEquals(list1, Arrays.stream(list1test).sorted().toArray());

        Integer[] list2 = {};
        quickSort.sort(list2);
        assertArrayEquals(list2, new Integer[]{});

        Integer[] list3 = {1, 1, -5, 6};
        Integer[] list3test = Arrays.copyOf(list3, list3.length);
        quickSort.sort(list3);
        assertArrayEquals(list3, Arrays.stream(list3test).sorted().toArray());

        Integer[] array2 = new Integer[50];
        for (int i = 0; i < array2.length; i++) {
            array2[i] = i;
        }
        Integer[] array2test = Arrays.copyOf(array2, array2.length);
        quickSort.sort(array2);
        assertArrayEquals(array2, Arrays.stream(array2test).sorted().toArray());

        Integer[] array3 = new Integer[10];
        for (int i = 0; i < array3.length; i++) {
            array3[i] = (array3.length - i) * 5;
        }
        Integer[] array3test = Arrays.copyOf(array3, array3.length);
        quickSort.sort(array3);
        assertArrayEquals(array3, Arrays.stream(array3test).sorted().toArray());

        Integer[] array4 = new Integer[1000];
        for (int i = 0; i < array4.length; i++) {
            array4[i] = (int) (Math.random() * 10000) - 5000;
        }
        Integer[] array4test = Arrays.copyOf(array4, array4.length);
        quickSort.sort(array4);
        assertArrayEquals(array4, Arrays.stream(array4test).sorted().toArray());
    }
}
