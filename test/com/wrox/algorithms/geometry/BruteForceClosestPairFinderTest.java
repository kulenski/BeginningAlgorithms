package com.wrox.algorithms.geometry;

/**
 * Test case for {@link com.wrox.algorithms.geometry.BruteForceClosestPairFinder}.
 *
 */
public class BruteForceClosestPairFinderTest extends AbstractClosestPairFinderTestCase {
    protected ClosestPairFinder createClosestPairFinder() {
        return BruteForceClosestPairFinder.INSTANCE;
    }
}
