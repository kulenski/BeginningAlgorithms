package com.wrox.algorithms.geometry;

/**
 * Test case for {@link com.wrox.algorithms.geometry.PlaneSweepOptimizedClosestPairFinder}.
 *
 */
public class PlaneSweepOptimizedClosestPairFinderTest extends AbstractClosestPairFinderTestCase {
    protected ClosestPairFinder createClosestPairFinder() {
        return PlaneSweepOptimizedClosestPairFinder.INSTANCE;
    }
}
