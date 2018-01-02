package com.wrox.algorithms.sorting;

import com.wrox.algorithms.lists.List;

/**
 * Generic interface for list sorting algorithms.
 *
 */
public interface ListSorter {
    /**
     * Sorts a list according to the underlying algorithm.
     *
     * @param list The list to sort.
     * @return The sorted List. May or may not be a new list.
     */
    public List sort(List list);
}
