package com.wrox.algorithms.sorting;

/**
 * A {@link Comparator} that count the calls made to {@link #compare(Object, Object)}.
 *
 */
public final class CallCountingComparator implements Comparator {
    /** The comparator to delegate to while counting calls. */
    private final Comparator _comparator;

    /** The number of calls made to this objects {@link #compare(Object, Object)} method. */
    private int _callCount;

    /**
     * Constructor.
     * @param comparator the comparator to delegate to while counting calls.
     */
    public CallCountingComparator(Comparator comparator) {
        assert comparator != null : "comparator cannot be null";

        _comparator = comparator;
        _callCount = 0;
    }

    /**
     * Delegates to the {@link Comparator} being wrapped.
     * @param left the left operand.
     * @param right the right operand.
     * @return the result from the wrapped object.
     */
    public int compare(Object left, Object right) throws ClassCastException {
        ++_callCount;
        return _comparator.compare(left, right);
    }

    /**
     * @return the number of calls made to this objects {@link #compare(Object, Object)} method.
     */
    public int getCallCount() {
        return _callCount;
    }
}
