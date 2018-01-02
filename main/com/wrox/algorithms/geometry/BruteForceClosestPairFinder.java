package com.wrox.algorithms.geometry;

import com.wrox.algorithms.iteration.Iterator;
import com.wrox.algorithms.lists.ArrayList;
import com.wrox.algorithms.lists.List;
import com.wrox.algorithms.sets.ListSet;
import com.wrox.algorithms.sets.Set;
import com.wrox.algorithms.bsearch.ListInserter;
import com.wrox.algorithms.bsearch.IterativeBinaryListSearcher;

/**
 * Implementation of a brute force algorithm for finding the closest pair among a set of points.
 *
 */
public final class BruteForceClosestPairFinder implements ClosestPairFinder {
    /** The single instance of this class. */
    public static final BruteForceClosestPairFinder INSTANCE = new BruteForceClosestPairFinder();

    /** Inserter to use for sorting points into a list. */
    private static final ListInserter INSERTER = new ListInserter(
            new IterativeBinaryListSearcher(XYPointComparator.INSTANCE));

    /**
     * Constructor marked private to prevent instantiation.
     */
    private BruteForceClosestPairFinder() {
    }

    public Set findClosestPair(Set points) {
        assert points != null : "points can't be null";

        if (points.size() < 2) {
            return null;
        }

        List list = sortPoints(points);

        Point p = null;
        Point q = null;
        double distance = Double.MAX_VALUE;

        for (int i = 0; i < list.size(); ++i) {
            Point r = (Point) list.get(i);
            for (int j = 0; j < list.size(); ++j) {
                Point s = (Point) list.get(j);
                if (r != s && r.distance(s) < distance) {
                    distance = r.distance(s);
                    p = r;
                    q = s;
                }
            }
        }

        return createPointPair(p, q);
    }

    private static List sortPoints(Set points) {
        assert points != null : "points can't be null";

        List list = new ArrayList(points.size());

        Iterator i = points.iterator();
        for (i.first(); !i.isDone(); i.next()) {
            INSERTER.insert(list, i.current());
        }

        return list;
    }

    private Set createPointPair(Point p, Point q) {
        Set result = new ListSet();
        result.add(p);
        result.add(q);
        return result;
    }
}
