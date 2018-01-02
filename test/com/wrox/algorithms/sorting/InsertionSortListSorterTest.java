package com.wrox.algorithms.sorting;

/**
 */
public class InsertionSortListSorterTest extends AbstractListSorterTestCase {
    protected ListSorter createListSorter(Comparator comparator) {
        return new InsertionSortListSorter(comparator);
    }
}
