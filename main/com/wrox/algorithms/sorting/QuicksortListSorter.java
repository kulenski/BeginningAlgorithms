package com.wrox.algorithms.sorting;

import com.wrox.algorithms.lists.List;

/**
 * A {@link com.wrox.algorithms.sorting.ListSorter} that uses an quicksort algorithm.
 *
 */
public class QuicksortListSorter implements ListSorter {
    /** The comparator to control the order of the sorted objects. */
    private final Comparator _comparator;

    /**
     * @param comparator the comparator to control the order of the sorted objects.
     */
    public QuicksortListSorter(Comparator comparator) {
        assert comparator != null : "comparator cannot be null";
        _comparator = comparator;
    }

    /**
     * Sorts a list using the quicksort algorithm.
     *
     * @param list The list to sort.
     * @return the original List in sorted order.
     */
    public List sort(List list) {
        assert list != null : "list cannot be null";

        quicksort(list, 0, list.size() - 1);

        return list;
    }

    private void quicksort(List list, int startIndex, int endIndex) {
        if (startIndex < 0 || endIndex >= list.size()) {
            return;
        }
        if (endIndex <= startIndex) {
            return;
        }

        Object value = list.get(endIndex);

        int partition = partition(list, value, startIndex, endIndex - 1);
        if (_comparator.compare(list.get(partition), value) < 0) {
            ++partition;
        }

        swap(list, partition, endIndex);

        quicksort(list, startIndex, partition - 1);
        quicksort(list, partition + 1, endIndex);
    }

    private int partition(List list, Object value, int leftIndex, int rightIndex) {
        int left = leftIndex;
        int right = rightIndex;

        while (left < right) {
            if (_comparator.compare(list.get(left), value) < 0) {
                ++left;
                continue;
            }

            if (_comparator.compare(list.get(right), value) >= 0) {
                --right;
                continue;
            }

            swap(list, left, right);
            ++left;
        }

        return left;
    }

    private void swap(List list, int left, int right) {
        if (left == right) {
            return;
        }
        Object temp = list.get(left);
        list.set(left, list.get(right));
        list.set(right, temp);
    }
}
