package com.wrox.algorithms.sorting;

import com.wrox.algorithms.iteration.Iterator;
import com.wrox.algorithms.lists.ArrayList;
import com.wrox.algorithms.lists.List;

/**
 * A {@link ListSorter} that uses an mergesort algorithm.
 *
 */
public class MergesortListSorter implements ListSorter {
    /** The comparator to control the order of the sorted objects. */
    private final Comparator _comparator;

    /**
     * @param comparator the comparator to control the order of the sorted objects.
     */
    public MergesortListSorter(Comparator comparator) {
        assert comparator != null : "comparator cannot be null";
        _comparator = comparator;
    }

    /**
     * Sorts a list using the mergesort algorithm.
     *
     * @param list The list to sort.
     * @return A new List containing the items from the original List in sorted order.
     */
    public List sort(List list) {
        assert list != null : "list cannot be null";

        return mergesort(list, 0, list.size() - 1);
    }

    private List mergesort(List list, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            List result = new ArrayList();
            result.add(list.get(startIndex));
            return result;
        }

        int splitIndex = startIndex + (endIndex - startIndex) / 2;

        List left = mergesort(list, startIndex, splitIndex);
        List right = mergesort(list, splitIndex + 1, endIndex);

        return merge(left, right);
    }

    private List merge(List left, List right) {
        List result = new ArrayList();

        Iterator l = left.iterator();
        Iterator r = right.iterator();

        l.first();
        r.first();

        while (!(l.isDone() && r.isDone())) {
            if (l.isDone()) {
                result.add(r.current());
                r.next();
            } else if (r.isDone()) {
                result.add(l.current());
                l.next();
            } else if (_comparator.compare(l.current(), r.current()) <= 0) {
                result.add(l.current());
                l.next();
            } else {
                result.add(r.current());
                r.next();
            }
        }

        return result;
    }
}
