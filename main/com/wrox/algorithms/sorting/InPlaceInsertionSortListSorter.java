package com.wrox.algorithms.sorting;

import com.wrox.algorithms.lists.List;

/**
 * Sample solution to exercise 7-4.
 * A {@link com.wrox.algorithms.sorting.ListSorter} that uses an
 * in-place insertion sort algorithm.
 *
 */
public class InPlaceInsertionSortListSorter implements ListSorter {
    private final Comparator _comparator;

    /**
     * @param comparator the comparator to control the order of the sorted objects.
     */
    public InPlaceInsertionSortListSorter(Comparator comparator) {
        assert comparator != null : "comparator cannot be null";
        _comparator = comparator;
    }

    /**
     * Sorts a list using the inseriton sort algorithm.
     *
     * @param list The list to sort.
     * @return the input list with items in sorted order.
     */
    public List sort(List list) {
        assert list != null : "list cannot be null";

        for (int i = 1; i < list.size(); ++i) {
            Object value = list.get(i);
            int j;
            for (j = i; j > 0; --j) {
                Object previousValue = list.get(j - 1);
                if (_comparator.compare(value, previousValue) >= 0) {
                    break;
                }
                list.set(j, previousValue);
            }
            list.set(j, value);
        }

        return list;
    }
}
