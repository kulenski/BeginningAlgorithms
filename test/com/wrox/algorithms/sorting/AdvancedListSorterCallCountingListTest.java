package com.wrox.algorithms.sorting;

import com.wrox.algorithms.lists.ArrayList;
import com.wrox.algorithms.lists.List;
import com.wrox.algorithms.stacks.CallCountingList;
import junit.framework.TestCase;

/**
 * A sample answer to exercise 7-3.
 * This program counts how many objects are moved during sorting.
 *
 */
public class AdvancedListSorterCallCountingListTest extends TestCase {
    private static final int TEST_SIZE = 1000;

    private final List _sortedArrayList = new ArrayList(TEST_SIZE);
    private final List _reverseArrayList = new ArrayList(TEST_SIZE);
    private final List _randomArrayList = new ArrayList(TEST_SIZE);

    private Comparator _comparator = NaturalComparator.INSTANCE;

    protected void setUp() throws Exception {
        super.setUp();

        for (int i = 1; i < TEST_SIZE; ++i) {
            _sortedArrayList.add(new Integer(i));
        }

        for (int i = TEST_SIZE; i > 0; --i) {
            _reverseArrayList.add(new Integer(i));
        }

        for (int i = 1; i < TEST_SIZE; ++i) {
            _randomArrayList.add(new Integer((int)(TEST_SIZE * Math.random())));
        }
    }

    public void testWorstCaseQuicksort() {
        List list = new CallCountingList(_reverseArrayList);
        new QuicksortListSorter(_comparator).sort(list);
        reportCalls(list);
    }

    public void testWorstCaseShellSort() {
        List list = new CallCountingList(_reverseArrayList);
        new ShellsortListSorter(_comparator).sort(list);
        reportCalls(list);
    }

    public void testBestCaseQuicksort() {
        List list = new CallCountingList(_sortedArrayList);
        new QuicksortListSorter(_comparator).sort(list);
        reportCalls(list);
    }

    public void testBestCaseShellSort() {
        List list = new CallCountingList(_sortedArrayList);
        new ShellsortListSorter(_comparator).sort(list);
        reportCalls(list);
    }

    public void testAverageCaseQuicksort() {
        List list = new CallCountingList(_randomArrayList);
        new QuicksortListSorter(_comparator).sort(list);
        reportCalls(list);
    }

    public void testAverageCaseShellSort() {
        List list = new CallCountingList(_randomArrayList);
        new ShellsortListSorter(_comparator).sort(list);
        reportCalls(list);
    }

    private void reportCalls(List list) {
        System.out.println(getName() + ": " + list);
    }
}
