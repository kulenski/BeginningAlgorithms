package com.wrox.algorithms.bsearch;

import com.wrox.algorithms.sorting.Comparator;

/**
 * Test cases for {@link LinearListSearcher}.
 *
 */
public class LinearListSearcherTest extends AbstractListSearcherTestCase {
    protected ListSearcher createSearcher(Comparator comparator) {
        return new LinearListSearcher(comparator);
    }
}
