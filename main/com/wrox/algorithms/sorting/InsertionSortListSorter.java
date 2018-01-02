package com.wrox.algorithms.sorting;

import com.wrox.algorithms.lists.List;
import com.wrox.algorithms.lists.LinkedList;
import com.wrox.algorithms.iteration.Iterator;

/**
 * A {@link ListSorter} that uses an insertion sort algorithm.
 *
 */
public class InsertionSortListSorter implements ListSorter {
    private final Comparator _comparator;

    /**
     * @param comparator the comparator to control the order of the sorted objects.
     */
    public InsertionSortListSorter(Comparator comparator) {
        assert comparator != null : "comparator cannot be null";
        _comparator = comparator;
    }

    /**
     * Sorts a list using the inseriton sort algorithm.
     *
     * @param list The list to sort.
     * @return a new List containing the objects from the original List in sorted order.
     */
    public List sort(List list) {
        assert list != null : "list cannot be null";

        final List result = new LinkedList();

        sort(list, result);

        return result;
    }

    void sort(List list, final List result) {
        assert list != null : "list can't be null";
        assert result != null : "result can't be null";

        Iterator it = list.iterator();

        for (it.first(); !it.isDone(); it.next()) {
            int slot = result.size();
            while (slot > 0) {
                if (_comparator.compare(it.current(), result.get(slot - 1)) >= 0) {
                    break;
                }
                --slot;
            }
            result.insert(slot, it.current());
        }
    }
}
