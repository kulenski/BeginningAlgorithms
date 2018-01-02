package com.wrox.algorithms.bsearch;

import com.wrox.algorithms.lists.ArrayList;
import com.wrox.algorithms.lists.List;
import com.wrox.algorithms.sorting.CallCountingComparator;
import com.wrox.algorithms.sorting.ListSorter;
import com.wrox.algorithms.sorting.MergesortListSorter;
import com.wrox.algorithms.sorting.NaturalComparator;
import com.wrox.algorithms.sorting.QuicksortListSorter;
import com.wrox.algorithms.sorting.ShellsortListSorter;
import junit.framework.TestCase;

/**
 * Compares the performance of binary insertion versus sorting.
 *
 */
public class BinaryInsertCallCountingTest extends TestCase {
    private static final int TEST_SIZE = 4091;

    private List _list;
    private CallCountingComparator _comparator;

    protected void setUp() throws Exception {
        super.setUp();

        _list = new ArrayList(TEST_SIZE);
        _comparator = new CallCountingComparator(NaturalComparator.INSTANCE);
    }

    public void testBinaryInsert() {
        ListInserter inserter = new ListInserter(new IterativeBinaryListSearcher(_comparator));

        for (int i = 0; i < TEST_SIZE; ++i) {
            inserter.insert(_list, new Integer((int) (TEST_SIZE * Math.random())));
        }

        reportCalls();
    }

    public void testMergeSort() {
        populateAndSort(new MergesortListSorter(_comparator));
    }

    public void testShellsort() {
        populateAndSort(new ShellsortListSorter(_comparator));
    }

    public void testQuicksort() {
        populateAndSort(new QuicksortListSorter(_comparator));
    }

    private void populateAndSort(ListSorter sorter) {
        for (int i = 0; i < TEST_SIZE; ++i) {
            _list.add(new Integer((int) (TEST_SIZE * Math.random())));
        }

        _list = sorter.sort(_list);

        reportCalls();
    }

    private void reportCalls() {
        System.out.println(getName() + ": " + _comparator.getCallCount() + " calls");
    }
}
