package com.wrox.algorithms.bsearch;

import com.wrox.algorithms.lists.ArrayList;
import com.wrox.algorithms.lists.List;
import com.wrox.algorithms.sorting.CallCountingComparator;
import com.wrox.algorithms.sorting.NaturalComparator;
import junit.framework.TestCase;

/**
 * Compares the performance of binary searching versus linear searching.
 *
 */
public class BinarySearchCallCountingTest extends TestCase {
    private static final int TEST_SIZE = 1021;

    private List _sortedList;
    private CallCountingComparator _comparator;

    protected void setUp() throws Exception {
        super.setUp();

        _sortedList = new ArrayList(TEST_SIZE);

        for (int i = 0; i < TEST_SIZE; ++i) {
            _sortedList.add(new Integer(i));
        }

        _comparator = new CallCountingComparator(NaturalComparator.INSTANCE);
    }

    public void testRecursiveBinarySearch() {
        performInOrderSearch(new RecursiveBinaryListSearcher(_comparator));
    }

    public void testIterativeBinarySearch() {
        performInOrderSearch(new IterativeBinaryListSearcher(_comparator));
    }

    public void testLinearSearch() {
        performInOrderSearch(new LinearListSearcher(_comparator));
    }

    public void testRandomRecursiveBinarySearch() {
        performRandomSearch(new RecursiveBinaryListSearcher(_comparator));
    }

    public void testRandomIterativeBinarySearch() {
        performRandomSearch(new IterativeBinaryListSearcher(_comparator));
    }

    public void testRandomLinearSearch() {
        performRandomSearch(new LinearListSearcher(_comparator));
    }

    private void performInOrderSearch(ListSearcher searcher) {
        for (int i = 0; i < TEST_SIZE; ++i) {
            searcher.search(_sortedList, new Integer(i));
        }

        reportCalls();
    }

    private void performRandomSearch(ListSearcher searcher) {
        for (int i = 0; i < TEST_SIZE; ++i) {
            searcher.search(_sortedList, new Integer((int) (TEST_SIZE * Math.random())));
        }

        reportCalls();
    }

    private void reportCalls() {
        System.out.println(getName() + ": " + _comparator.getCallCount() + " calls");
    }
}
