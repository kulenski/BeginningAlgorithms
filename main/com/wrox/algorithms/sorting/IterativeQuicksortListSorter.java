package com.wrox.algorithms.sorting;

import com.wrox.algorithms.lists.List;
import com.wrox.algorithms.stacks.Stack;
import com.wrox.algorithms.stacks.ListStack;

/**
 * Sample solution to exercise 7-2.
 * A {@link ListSorter} that uses an quicksort algorithm in iterative form.
 *
 */
public class IterativeQuicksortListSorter implements ListSorter {
    /** The comparator to control the order of the sorted objects. */
    private final Comparator _comparator;

    /**
     * @param comparator the comparator to control the order of the sorted objects.
     */
    public IterativeQuicksortListSorter(Comparator comparator) {
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

        quicksort(list);

        return list;
    }

    private void quicksort(List list) {
        Stack jobStack = new ListStack();

        jobStack.push(new Range(0, list.size() - 1));

        while (!jobStack.isEmpty()) {
            Range range = (Range) jobStack.pop();
            if (range.size() <= 1) {
                continue;
            }

            int startIndex = range.getStartIndex();
            int endIndex = range.getEndIndex();

            Object value = list.get(endIndex);

            int partition = partition(list, value, startIndex, endIndex - 1);
            if (_comparator.compare(list.get(partition), value) < 0) {
                ++partition;
            }

            swap(list, partition, endIndex);

            jobStack.push(new Range(startIndex, partition - 1));
            jobStack.push(new Range(partition + 1, endIndex));
        }
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

    private static final class Range {
        private final int _startIndex;
        private final int _endIndex;

        public Range(int startIndex, int endIndex) {
            _startIndex = startIndex;
            _endIndex = endIndex;
        }

        public int size() {
            return _endIndex - _startIndex + 1;
        }

        public int getStartIndex() {
            return _startIndex;
        }

        public int getEndIndex() {
            return _endIndex;
        }
    }
}
