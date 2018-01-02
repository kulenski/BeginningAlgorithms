package com.wrox.algorithms.ssearch;

/**
 * Concrete test class for {@link BruteForceStringSearcher}.
 *
 */
public class BruteForceStringSearcherTest extends AbstractStringSearcherTestCase {
    protected StringSearcher createSearcher(CharSequence pattern) {
        return new BruteForceStringSearcher(pattern);
    }
}
