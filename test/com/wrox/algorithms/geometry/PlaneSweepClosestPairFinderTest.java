package com.wrox.algorithms.geometry;

/**
 * Test case for {@link PlaneSweepClosestPairFinder}.
 *
 */
public class PlaneSweepClosestPairFinderTest extends AbstractClosestPairFinderTestCase {
    protected ClosestPairFinder createClosestPairFinder() {
        return PlaneSweepClosestPairFinder.INSTANCE;
    }
}
