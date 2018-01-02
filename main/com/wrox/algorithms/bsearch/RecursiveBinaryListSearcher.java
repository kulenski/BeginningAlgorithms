package com.wrox.algorithms.bsearch;

import com.wrox.algorithms.lists.List;
import com.wrox.algorithms.sorting.Comparator;

/**
 * A {@link ListSearcher} that uses recursion.
 *
 */
public class RecursiveBinaryListSearcher implements ListSearcher {
    /** The strategy to use for key comparison. */
    private final Comparator _comparator;

    /**
     * Constructor.
     *
     * @param comparator The strategy to use for value comparison.
     */
    public RecursiveBinaryListSearcher(Comparator comparator) {
        assert comparator != null : "comparator can't be null";
        _comparator = comparator;
    }

    public int search(List list, Object value) {
        assert list != null : "list can't be null";

        return search(list, value, 0, list.size() - 1);
    }

    private int search(List list, Object value, int lowerIndex, int upperIndex) {
        assert list != null : "list can't be null";

        if (lowerIndex > upperIndex) {
            return -(lowerIndex + 1);
        }

        int index = lowerIndex + (upperIndex - lowerIndex) / 2;

        int cmp = _comparator.compare(value, list.get(index));

        if (cmp < 0) {
            index = search(list, value, lowerIndex, index - 1);
        } else if (cmp > 0) {
            index = search(list, value, index + 1, upperIndex);
        }

        return index;
    }
}
