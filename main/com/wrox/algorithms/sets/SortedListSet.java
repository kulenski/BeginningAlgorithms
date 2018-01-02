package com.wrox.algorithms.sets;

import com.wrox.algorithms.bsearch.IterativeBinaryListSearcher;
import com.wrox.algorithms.bsearch.ListSearcher;
import com.wrox.algorithms.iteration.Iterator;
import com.wrox.algorithms.lists.ArrayList;
import com.wrox.algorithms.lists.List;
import com.wrox.algorithms.sorting.Comparator;
import com.wrox.algorithms.sorting.NaturalComparator;

/**
 * A {@link Set} that uses a {@link List} as the underlying storage mechanism and a {@link ListSearcher} to keep the
 * values in sorted order.
 *
 */
public class SortedListSet implements Set {
    /** The underlying list of sorted values. */
    private final List _values = new ArrayList();

    /** The list searcher to use. */
    private final ListSearcher _searcher;

    /**
     * Default constructor. Assumes all values implement {@link Comparable}.
     */
    public SortedListSet() {
        this(NaturalComparator.INSTANCE);
    }

    /**
     * Constructor.
     *
     * @param comparator The strategy to use for value comparison.
     */
    public SortedListSet(Comparator comparator) {
        _searcher = new IterativeBinaryListSearcher(comparator);
    }

    public boolean contains(Object value) {
        return indexOf(value) >= 0;
    }

    public boolean add(Object value) {
        int index = indexOf(value);
        if (index < 0) {
            _values.insert(-(index + 1), value);
            return true;
        }

        _values.set(index, value);
        return false;
    }

    public boolean delete(Object value) {
        int index = indexOf(value);
        if (index >= 0) {
            _values.delete(index);
            return true;
        }

        return false;
    }

    public Iterator iterator() {
        return _values.iterator();
    }

    public void clear() {
        _values.clear();
    }

    public int size() {
        return _values.size();
    }

    public boolean isEmpty() {
        return _values.isEmpty();
    }

    /**
     * Searches a list for a specified value.
     *
     * @param value The value for which to search.
     * @return The position (0, 1, 2...) of the value if found; otherwise <code>-(insertion point + 1)</code>.
     */
    private int indexOf(Object value) {
        return _searcher.search(_values, value);
    }
}
