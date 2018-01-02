package com.wrox.algorithms.sorting;

/**
 */
public class QuicksortListSorterTest extends AbstractListSorterTestCase {
    protected ListSorter createListSorter(Comparator comparator) {
        return new QuicksortListSorter(comparator);
    }
}
