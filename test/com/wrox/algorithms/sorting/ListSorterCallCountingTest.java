package com.wrox.algorithms.sorting;

import com.wrox.algorithms.lists.ArrayList;
import com.wrox.algorithms.lists.List;
import junit.framework.TestCase;

/**
 * A test case to drive the various {@link ListSorter} implementations
 * in order to compare their efficiency.
 *
 */
public class ListSorterCallCountingTest extends TestCase {
    private static final int TEST_SIZE = 1000;

    private final List _sortedArrayList = new ArrayList(TEST_SIZE);
    private final List _reverseArrayList = new ArrayList(TEST_SIZE);
    private final List _randomArrayList = new ArrayList(TEST_SIZE);

    private CallCountingComparator _comparator;

    protected void setUp() throws Exception {
        super.setUp();
        _comparator = new CallCountingComparator(NaturalComparator.INSTANCE);

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

    public void testWorstCaseBubblesort() {
        new BubblesortListSorter(_comparator).sort(_reverseArrayList);
        reportCalls();
    }

    public void testWorstCaseSelectionSort() {
        new SelectionSortListSorter(_comparator).sort(_reverseArrayList);
        reportCalls();
    }

    public void testWorstCaseInsertionSort() {
        new InsertionSortListSorter(_comparator).sort(_reverseArrayList);
        reportCalls();
    }

    public void testWorstCaseShellsort() {
        new ShellsortListSorter(_comparator).sort(_reverseArrayList);
        reportCalls();
    }

    public void testWorstCaseQuicksort() {
        new QuicksortListSorter(_comparator).sort(_reverseArrayList);
        reportCalls();
    }

    public void testWorstCaseMergesort() {
        new MergesortListSorter(_comparator).sort(_reverseArrayList);
        reportCalls();
    }

    public void testBestCaseBubblesort() {
        new BubblesortListSorter(_comparator).sort(_sortedArrayList);
        reportCalls();
    }

    public void testBestCaseSelectionSort() {
        new SelectionSortListSorter(_comparator).sort(_sortedArrayList);
        reportCalls();
    }

    public void testBestCaseInsertionSort() {
        new InsertionSortListSorter(_comparator).sort(_sortedArrayList);
        reportCalls();
    }

    public void testBestCaseShellsort() {
        new ShellsortListSorter(_comparator).sort(_sortedArrayList);
        reportCalls();
    }

    public void testBestCaseQuicksort() {
        new QuicksortListSorter(_comparator).sort(_sortedArrayList);
        reportCalls();
    }

    public void testBestCaseMergesort() {
        new MergesortListSorter(_comparator).sort(_sortedArrayList);
        reportCalls();
    }

    public void testAverageCaseBubblesort() {
        new BubblesortListSorter(_comparator).sort(_randomArrayList);
        reportCalls();
    }

    public void testAverageCaseSelectionSort() {
        new SelectionSortListSorter(_comparator).sort(_randomArrayList);
        reportCalls();
    }

    public void testAverageCaseInsertionSort() {
        new InsertionSortListSorter(_comparator).sort(_randomArrayList);
        reportCalls();
    }

    public void testAverageCaseShellsort() {
        new ShellsortListSorter(_comparator).sort(_randomArrayList);
        reportCalls();
    }

    public void testAverageCaseQuicksort() {
        new QuicksortListSorter(_comparator).sort(_randomArrayList);
        reportCalls();
    }

    public void testAverageCaseMergeSort() {
        new MergesortListSorter(_comparator).sort(_randomArrayList);
        reportCalls();
    }

    private void reportCalls() {
        System.out.println(getName() + ": " + _comparator.getCallCount() + " calls");
    }
}
