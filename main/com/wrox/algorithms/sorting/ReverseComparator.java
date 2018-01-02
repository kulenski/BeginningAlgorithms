package com.wrox.algorithms.sorting;

/**
 * A {@link Comparator} that reverses the order of another, underlying, {@link Comparator}. Useful for sorting in
 * reverse order without needing to create two {@link Comparator}s for each type.
 *
 */
public class ReverseComparator implements Comparator {
    /** The underlying comparator. */
    private final Comparator _comparator;

    /**
     * Constructor.
     *
     * @param comparator The underlying comparator.
     */
    public ReverseComparator(Comparator comparator) {
        assert comparator != null : "comparator can't be null";
        _comparator = comparator;
    }

    public int compare(Object left, Object right) throws ClassCastException {
        return _comparator.compare(right, left);
    }
}
