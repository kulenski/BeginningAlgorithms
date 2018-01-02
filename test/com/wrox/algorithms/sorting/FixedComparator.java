package com.wrox.algorithms.sorting;

/**
 * A {@link Comparator} that always returns the same result irrespective of the arguments.
 * 
 */
public class FixedComparator implements Comparator {
    private final int _result;

    /**
     * Constructor.
     * @param result The result ro return from {@link #compare(Object, Object)}.
     */
    public FixedComparator(int result) {
        _result = result;
    }

    public int compare(Object left, Object right) throws ClassCastException {
        return _result;
    }
}
