package com.wrox.algorithms.bsearch;

import com.wrox.algorithms.sorting.Comparator;

/**
 * Test cases for {@link IterativeBinaryListSearcher}.
 *
 */
public class IterativeBinaryListSearcherTest extends AbstractListSearcherTestCase {
    protected ListSearcher createSearcher(Comparator comparator) {
        return new IterativeBinaryListSearcher(comparator);
    }
}
