package com.wrox.algorithms.sorting;

import com.wrox.algorithms.lists.List;

/**
 * A {@link ListSorter} that uses a selection sort algorithm.
 *
 */
public class SelectionSortListSorter implements ListSorter {
    private final Comparator _comparator;

    /**
     * @param comparator the comparator to control the order of the sorted objects.
     */
    public SelectionSortListSorter(Comparator comparator) {
        assert comparator != null : "comparator cannot be null";
        _comparator = comparator;
    }

    /**
     * Sorts a list using the selection sort algorithm.
     *
     * @param list The list to sort.
     * @return the same list that is passed in is returned.
     */
    public List sort(List list) {
        assert list != null : "list cannot be null";

        int size = list.size();

        for (int slot = 0; slot < size - 1; ++slot) {
            int smallest = slot;
            for (int check = slot + 1; check < size; ++check) {
                if (_comparator.compare(list.get(check), list.get(smallest)) < 0) {
                    smallest = check;
                }
            }
            swap(list, smallest, slot);
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
        if (left == right) {
            return;
        }
        Object temp = list.get(left);
        list.set(left, list.get(right));
        list.set(right, temp);
    }
}
