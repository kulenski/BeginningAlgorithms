package com.wrox.algorithms.sorting;

/**
 * A {@link com.wrox.algorithms.sorting.Comparator} that compares Strings in
 * a case-insensitive manner.
 *
 */
public final class CaseInsensitiveStringComparator implements Comparator {
    public int compare(Object left, Object right) throws ClassCastException {
        assert left != null : "left can't be null";
        assert right != null : "right can't be null";

        String leftLower = ((String) left).toLowerCase();
        String rightLower = ((String) right).toLowerCase();
        return leftLower.compareTo(rightLower);
    }
}
