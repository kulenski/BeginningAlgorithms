package com.wrox.algorithms.geometry;

import com.wrox.algorithms.sorting.Comparator;

/**
 * A {@link Comparator} that orders {@link Point} objects based on their x coordinates, followed by their y coordinates.
 *
 */
public final class XYPointComparator implements Comparator {
    /** The single instance of the class. */
    public static final XYPointComparator INSTANCE = new XYPointComparator();

    /**
     * Constructor marked private to prevent instantiation.
     */
    private XYPointComparator() {
    }

    public int compare(Object left, Object right) throws ClassCastException {
        return compare((Point) left, (Point) right);
    }

    public int compare(Point p, Point q) throws ClassCastException {
        assert p != null : "p can't be null";
        assert q != null : "q can't be null";

        int result = new Double(p.getX()).compareTo(new Double(q.getX()));
        if (result != 0) {
            return result;
        }
        return new Double(p.getY()).compareTo(new Double(q.getY()));
    }
}
