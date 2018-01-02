package com.wrox.algorithms.geometry;

import com.wrox.algorithms.sets.ListSet;
import com.wrox.algorithms.sets.Set;
import junit.framework.TestCase;

/**
 * Abstract nase class for testing implementations of {@link ClosestPairFinder}.
 *
 */
public abstract class AbstractClosestPairFinderTestCase extends TestCase {
    /**
     * Test cases for specific algorithms should implement this factory
     * method to instantiate the given algorithm implementation.
     * @return the algorithm implementation.
     */
    protected abstract ClosestPairFinder createClosestPairFinder();

    public void testEmptySetOfPoints() {
        ClosestPairFinder finder = createClosestPairFinder();
        assertNull(finder.findClosestPair(new ListSet()));
    }

    public void testASinglePointReturnsNull() {
        ClosestPairFinder finder = createClosestPairFinder();

        Set points = new ListSet();
        points.add(new Point(1, 1));

        assertNull(finder.findClosestPair(points));
    }

    public void testASinglePairOfPoints() {
        ClosestPairFinder finder = createClosestPairFinder();

        Set points = new ListSet();
        Point p = new Point(1, 1);
        Point q = new Point(2, 4);

        points.add(p);
        points.add(q);

        Set pair = finder.findClosestPair(points);

        assertNotNull(pair);
        assertEquals(2, pair.size());
        assertTrue(pair.contains(p));
        assertTrue(pair.contains(q));
    }

    public void testThreePointsEquallySpacedApart() {
        ClosestPairFinder finder = createClosestPairFinder();

        Set points = new ListSet();
        Point p = new Point(1, 0);
        Point q = new Point(1, 4);
        Point r = new Point(1, -4);

        points.add(p);
        points.add(q);
        points.add(r);

        Set pair = finder.findClosestPair(points);

        assertNotNull(pair);
        assertEquals(2, pair.size());
        assertTrue(pair.contains(p));
        assertTrue(pair.contains(r));
    }

    public void testLargeSetOfPointsWithTwoEqualShortestPairs() {
        ClosestPairFinder finder = createClosestPairFinder();

        Set points = new ListSet();

        points.add(new Point(0, 0));
        points.add(new Point(4, -2));
        points.add(new Point(2, 7));
        points.add(new Point(3, 7));
        points.add(new Point(-1, -5));
        points.add(new Point(-5, 3));
        points.add(new Point(-5, 4));
        points.add(new Point(-0, -9));
        points.add(new Point(-2, -2));

        Set pair = finder.findClosestPair(points);

        assertNotNull(pair);
        assertEquals(2, pair.size());
        assertTrue(pair.contains(new Point(-5, 3)));
        assertTrue(pair.contains(new Point(-5, 4)));
    }
}
