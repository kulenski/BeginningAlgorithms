package com.wrox.algorithms.sorting;

import com.wrox.algorithms.lists.ArrayList;
import com.wrox.algorithms.lists.List;
import com.wrox.algorithms.stacks.CallCountingList;
import junit.framework.TestCase;

/**
 * A sample answer to exercise 6-4.
 * This program counts how many objects are moved during sorting.
 *
 */
public class ListSorterCallCountingListTest extends TestCase {
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

    public void testWorstCaseBubblesort() {
        List list = new CallCountingList(_reverseArrayList);
        new BubblesortListSorter(_comparator).sort(list);
        reportCalls(list);
    }

    public void testWorstCaseSelectionSort() {
        List list = new CallCountingList(_reverseArrayList);
        new SelectionSortListSorter(_comparator).sort(list);
        reportCalls(list);
    }

    public void testWorstCaseInsertionSort() {
        List list = _reverseArrayList;
        List result = new CallCountingList(new ArrayList());
        new InsertionSortListSorter(_comparator).sort(list, result);
        reportCalls(result);
    }

    public void testBestCaseBubblesort() {
        List list = new CallCountingList(_sortedArrayList);
        new BubblesortListSorter(_comparator).sort(list);
        reportCalls(list);
    }

    public void testBestCaseSelectionSort() {
        List list = new CallCountingList(_sortedArrayList);
        new SelectionSortListSorter(_comparator).sort(list);
        reportCalls(list);
    }

    public void testBestCaseInsertionSort() {
        List list = _sortedArrayList;
        List result = new CallCountingList(new ArrayList());
        new InsertionSortListSorter(_comparator).sort(list, result);
        reportCalls(result);
    }

    public void testAverageCaseBubblesort() {
        List list = new CallCountingList(_randomArrayList);
        new BubblesortListSorter(_comparator).sort(list);
        reportCalls(list);
    }

    public void testAverageCaseSelectionSort() {
        List list = new CallCountingList(_randomArrayList);
        new SelectionSortListSorter(_comparator).sort(list);
        reportCalls(list);
    }

    public void testAverageCaseInsertionSort() {
        List list = _randomArrayList;
        List result = new CallCountingList(new ArrayList());
        new InsertionSortListSorter(_comparator).sort(list, result);
        reportCalls(result);
    }

    private void reportCalls(List list) {
        System.out.println(getName() + ": " + list);
    }
}
