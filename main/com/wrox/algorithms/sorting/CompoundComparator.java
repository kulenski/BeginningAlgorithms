package com.wrox.algorithms.sorting;

import com.wrox.algorithms.iteration.Iterator;
import com.wrox.algorithms.lists.ArrayList;
import com.wrox.algorithms.lists.List;

/**
 * A {@link Comparator} that combines other {@link Comparator}s to produce a compund result.
 *
 */
public class CompoundComparator implements Comparator {
    /** The underlying comparators. */
    private final List _comparators = new ArrayList();

    /**
     * Adds a comparator to the end of the collection.
     *
     * @param comparator The comparator to add.
     */
    public void addComparator(Comparator comparator) {
        assert comparator != null : "comparator can't be null";
        assert comparator != this : "can't add comparator to itself";

        _comparators.add(comparator);
    }

    public int compare(Object left, Object right) throws ClassCastException {
        int result = 0;
        Iterator i = _comparators.iterator();

        for (i.first(); !i.isDone(); i.next()) {
            result = ((Comparator) i.current()).compare(left, right);
            if (result != 0) {
                break;
            }
        }

        return result;
    }
}
