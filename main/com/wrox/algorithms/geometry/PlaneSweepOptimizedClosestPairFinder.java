package com.wrox.algorithms.geometry;

import com.wrox.algorithms.bsearch.IterativeBinaryListSearcher;
import com.wrox.algorithms.bsearch.ListInserter;
import com.wrox.algorithms.iteration.Iterator;
import com.wrox.algorithms.lists.ArrayList;
import com.wrox.algorithms.lists.List;
import com.wrox.algorithms.sets.ListSet;
import com.wrox.algorithms.sets.Set;

/**
 * Implementation of the Plane Sweep algorithm for finding the closest pair among a set of points.
 *
 */
public final class PlaneSweepOptimizedClosestPairFinder implements ClosestPairFinder {
    /** The single instance of this class. */
    public static final PlaneSweepOptimizedClosestPairFinder INSTANCE = new PlaneSweepOptimizedClosestPairFinder();

    /** Inserter to use for sorting points into a list. */
    private static final ListInserter INSERTER = new ListInserter(
            new IterativeBinaryListSearcher(XYPointComparator.INSTANCE));

    /**
     * Constructor marked private to prevent instantiation.
     */
    private PlaneSweepOptimizedClosestPairFinder() {
    }

    public Set findClosestPair(Set points) {
        assert points != null : "points can't be null";

        if (points.size() < 2) {
            return null;
        }

        List sortedPoints = sortPoints(points);

        Point p = (Point) sortedPoints.get(0);
        Point q = (Point) sortedPoints.get(1);

        return findClosestPair(p, q, sortedPoints);
    }

    private Set findClosestPair(Point p, Point q, List sortedPoints) {
        Set result = createPointPair(p, q);
        double distance = p.distance(q);
        int dragPoint = 0;

        for (int i = 2; i < sortedPoints.size(); ++i) {
            Point r = (Point) sortedPoints.get(i);
            double sweepX = r.getX();
            double dragX = sweepX - distance;

            while (((Point) sortedPoints.get(dragPoint)).getX() < dragX) {
                ++dragPoint;
            }

            for (int j = dragPoint; j < i; ++j) {
                Point test = (Point) sortedPoints.get(j);
                if (Math.abs(r.getY() - test.getY()) > distance) {
                    continue;
                }
                double checkDistance = r.distance(test);
                if (checkDistance < distance) {
                    distance = checkDistance;
                    result = createPointPair(r, test);
                }
            }
        }

        return result;
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
