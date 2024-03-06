package com.example.project;

import java.util.Comparator;

abstract public class AbstractSortingAlgorithm<T> implements SortingAlgorithm<T> {
	protected final Comparator<T> comparator;

	protected AbstractSortingAlgorithm(Comparator<T> comparator) {
		this.comparator = comparator;
	}
}
