package com.wrox.algorithms.geometry;

import junit.framework.TestCase;

/**
 * Test cases for {@link XYPointComparator}.
 *
 */
public class XYPointComparatorTest extends TestCase {
    private final XYPointComparator _comparator = XYPointComparator.INSTANCE;

    public void testEqualPointsCompareCorrectly() {
        Point p = new Point(4, 4);
        Point q = new Point(4, 4);

        assertEquals(0, _comparator.compare(p, q));
        assertEquals(0, _comparator.compare(p, p));
    }

    public void testXCoordinateIsPrimaryKey() {
        Point p = new Point(-1, 4);
        Point q = new Point(0, 4);
        Point r = new Point(1, 4);

        assertEquals(-1, _comparator.compare(p, q));
        assertEquals(-1, _comparator.compare(p, r));
        assertEquals(-1, _comparator.compare(q, r));

        assertEquals(1, _comparator.compare(q, p));
        assertEquals(1, _comparator.compare(r, p));
        assertEquals(1, _comparator.compare(r, q));
    }

    public void testYCoordinateIsSecondaryKey() {
        Point p = new Point(4, -1);
        Point q = new Point(4, 0);
        Point r = new Point(4, 1);

        assertEquals(-1, _comparator.compare(p, q));
        assertEquals(-1, _comparator.compare(p, r));
        assertEquals(-1, _comparator.compare(q, r));

        assertEquals(1, _comparator.compare(q, p));
        assertEquals(1, _comparator.compare(r, p));
        assertEquals(1, _comparator.compare(r, q));
    }
}
