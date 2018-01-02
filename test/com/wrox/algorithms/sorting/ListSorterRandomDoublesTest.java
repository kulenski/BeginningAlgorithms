package com.wrox.algorithms.sorting;

import com.wrox.algorithms.lists.ArrayList;
import com.wrox.algorithms.lists.List;
import junit.framework.TestCase;

/**
 * An example answer to exercise 6-1.
 * Create a test to prove that the three basic sorting algorithms
 * can sort a randomly generated list of Double objects.
 *
 */
public class ListSorterRandomDoublesTest extends TestCase {
    private static final int TEST_SIZE = 1000;

    private final List _randomList = new ArrayList(TEST_SIZE);
    private final NaturalComparator _comparator = NaturalComparator.INSTANCE;

    protected void setUp() throws Exception {
        super.setUp();

        for (int i = 1; i < TEST_SIZE; ++i) {
            _randomList.add(new Double((TEST_SIZE * Math.random())));
        }
    }

    public void testsortingRandomDoublesWithBubblesort() {
        ListSorter listSorter = new BubblesortListSorter(_comparator);
        List result = listSorter.sort(_randomList);
        assertSorted(result);
    }

    public void testsortingRandomDoublesWithSelectionsort() {
        ListSorter listSorter = new SelectionSortListSorter(_comparator);
        List result = listSorter.sort(_randomList);
        assertSorted(result);
    }

    public void testsortingRandomDoublesWithInsertionsort() {
        ListSorter listSorter = new InsertionSortListSorter(_comparator);
        List result = listSorter.sort(_randomList);
        assertSorted(result);
    }

    private void assertSorted(List list) {
        for (int i = 1; i < list.size(); i++) {
            Object o = list.get(i);
            assertTrue(_comparator.compare(list.get(i - 1), list.get(i)) <= 0);
        }
    }
}
