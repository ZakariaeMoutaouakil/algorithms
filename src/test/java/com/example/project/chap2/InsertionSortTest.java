package com.example.project.chap2;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InsertionSortTest {

    @Test
    public void testSort() {
        // Arrange
        Comparator<Integer> comparator = Comparator.reverseOrder();
        InsertionSort<Integer> insertionSort = new InsertionSort<>(comparator);
        Integer[] array = {3, 7, 2, 1, 6, 5, 4};
        Integer[] expected = {7, 6, 5, 4, 3, 2, 1}; // Sorted in descending order

        // Act
        insertionSort.sort(array);

        // Assert
        assertThat(array).containsExactly(expected);
    }

    @Test
    public void testSortWithEmptyArray() {
        // Arrange
        Comparator<Integer> comparator = Comparator.naturalOrder();
        InsertionSort<Integer> insertionSort = new InsertionSort<>(comparator);
        Integer[] array = {};
        Integer[] expected = {}; // Empty array remains unchanged

        // Act
        insertionSort.sort(array);

        // Assert
        assertThat(array).containsExactly(expected);
    }

    @Test
    public void testSortWithSortedArray() {
        // Arrange
        Comparator<Integer> comparator = Comparator.naturalOrder();
        InsertionSort<Integer> insertionSort = new InsertionSort<>(comparator);
        Integer[] array = {1, 2, 3, 4, 5, 6, 7};
        Integer[] expected = {1, 2, 3, 4, 5, 6, 7}; // Sorted array remains unchanged

        // Act
        insertionSort.sort(array);

        // Assert
        assertThat(array).containsExactly(expected);
    }

    @Test
    public void testInsertionSort() {
        // Repeating terms.
        Comparator<Integer> comparator = Comparator.naturalOrder();
        InsertionSort<Integer> insertionSort = new InsertionSort<>(comparator);
        Integer[] list1 = {11, 1, 51, 1, 5, 3};
        insertionSort.sort(list1);
        assertArrayEquals(list1, new Integer[]{1, 1, 3, 5, 11, 51});

        // Empty list should return empty list.
        Integer[] list2 = {};
        insertionSort.sort(list2);
        assertArrayEquals(list2, new Integer[]{});

        // Negative number.
        Integer[] list3 = {1, 1, -5, 6};
        insertionSort.sort(list3);
        assertArrayEquals(list3, new Integer[]{-5, 1, 1, 6});

        // Float and int.
        Comparator<Double> comparator2 = Comparator.naturalOrder();
        InsertionSort<Double> insertionSort2 = new InsertionSort<>(comparator2);
        Double[] array1 = {11.0, -4.0, 20.0, 15.0, 13.5, -20.0};
        insertionSort2.sort(array1);
        assertArrayEquals(array1, new Double[]{-20.0, -4.0, 11.0, 13.5, 15.0, 20.0});

        // Already sorted array.
        Integer[] array2 = new Integer[50];
        for (int i = 0; i < array2.length; i++) {
            array2[i] = i;
        }
        insertionSort.sort(array2);
        assertArrayEquals(array2, new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49});

        // Array in reversed sorted order.
        Integer[] array3 = new Integer[50];
        for (int i = 0; i < array3.length; i++) {
            array3[i] = 50 - i;
        }
        insertionSort.sort(array3);
        assertArrayEquals(array3, new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50});

        // Large array.
        Integer[] array4 = new Integer[1000];
        for (int i = 0; i < array4.length; i++) {
            array4[i] = (int) (Math.random() * 10000) - 5000;
        }
        insertionSort.sort(array4);
        for (int i = 1; i < array4.length; i++) {
            assertTrue(array4[i - 1] <= array4[i]);
        }
    }
}

