package com.wrox.algorithms.bsearch;

import com.wrox.algorithms.sorting.Comparator;

/**
 * Test cases for {@link RecursiveBinaryListSearcher}.
 *
 */
public class RecursiveBinaryListSearcherTest extends AbstractListSearcherTestCase {
    protected ListSearcher createSearcher(Comparator comparator) {
        return new RecursiveBinaryListSearcher(comparator);
    }
}
