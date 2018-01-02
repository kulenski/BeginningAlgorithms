package com.wrox.algorithms.sorting;

/**
 * A {@link com.wrox.algorithms.sorting.Comparator} that compares strings in reverse.
 *
 */
public final class ReverseStringComparator implements Comparator {
    /** The single, publicly accessible, instance of the comparator. */
    public static final ReverseStringComparator INSTANCE = new ReverseStringComparator();

    /**
     * Constructor marked private to prevent instantiation.
     */
    private ReverseStringComparator() {
    }

    public int compare(Object left, Object right) throws ClassCastException {
        assert left != null : "left can't be null";
        assert right != null : "right can't be null";

        return reverse((String) left).compareTo(reverse((String) right));
    }

    private String reverse(String s) {
        StringBuffer result = new StringBuffer();

        for (int i = 0; i < s.length(); ++i) {
            result.append(s.charAt(s.length() - 1 - i));
        }

        return result.toString();
    }
}
