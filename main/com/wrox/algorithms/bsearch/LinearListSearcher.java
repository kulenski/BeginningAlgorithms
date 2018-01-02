package com.wrox.algorithms.bsearch;

import com.wrox.algorithms.iteration.Iterator;
import com.wrox.algorithms.lists.List;
import com.wrox.algorithms.sorting.Comparator;

/**
 * A {@link ListSearcher} that performs a linear scan.
 *
 */
public class LinearListSearcher implements ListSearcher {
    /** The strategy to use for key comparison. */
    private final Comparator _comparator;

    /**
     * Constructor.
     *
     * @param comparator The strategy to use for key comparison.
     */
    public LinearListSearcher(Comparator comparator) {
        assert comparator != null : "comparator can't be null";
        _comparator = comparator;
    }

    public int search(List list, Object value) {
        assert list != null : "list can't be null";

        int index = 0;
        Iterator i = list.iterator();

        for (i.first(); !i.isDone(); i.next()) {
            int cmp = _comparator.compare(value, i.current());
            if (cmp == 0) {
                return index;
            } else if (cmp < 0) {
                break;
            }

            ++index;
        }

        return -(index + 1);
    }
}
