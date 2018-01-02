package com.wrox.algorithms.sorting;

import com.wrox.algorithms.lists.List;

/**
 * A {@link ListSorter} that uses a bubble-sort algorithm.
 *
 */
public class BubblesortListSorter implements ListSorter {
    private final Comparator _comparator;

    /**
     * @param comparator the comparator to control the order of the sorted objects.
     */
    public BubblesortListSorter(Comparator comparator) {
        assert comparator != null : "comparator cannot be null";
        _comparator = comparator;
    }

    /**
     * Sorts a list using the bubblesort algorithm.
     *
     * @param list The list to sort.
     * @return the same list that is passed in is returned.
     */
    public List sort(List list) {
        assert list != null : "list cannot be null";

        int size = list.size();

        for (int pass = 1; pass < size; ++pass) {
            for (int left = 0; left < (size - pass); ++left) {
                int right = left + 1;
                if (_comparator.compare(list.get(left), list.get(right)) > 0) {
                    swap(list, left, right);
                }
            }
        }

        return list;
    }

    /**
     * Swaps two elements in a list.
     *
     * @param list The list on which to operate.
     * @param left The left element.
     * @param right The right element.
     */
    private void swap(List list, int left, int right) {
        Object temp = list.get(left);
        list.set(left, list.get(right));
        list.set(right, temp);
    }
}
