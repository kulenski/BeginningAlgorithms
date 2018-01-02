package com.wrox.algorithms.sorting;

/**
 * A {@link Comparator} that compares objects that have a natural sort order, ie. implement {@link Comparable}.
 *
 */
public final class NaturalComparator implements Comparator {
    /** The single, publicly accessible, instance of the comparator. */
    public static final NaturalComparator INSTANCE = new NaturalComparator();

    /**
     * Constructor marked private to prevent instantiation.
     */
    private NaturalComparator() {
    }

    public int compare(Object left, Object right) throws ClassCastException {
        assert left != null : "left can't be null";
        assert right != null : "right can't be null";

        return ((Comparable) left).compareTo(right);
    }
}
