package com.wrox.algorithms.sorting;

/**
 */
public class IterativeMergesortListSorterTest extends AbstractListSorterTestCase {
    protected ListSorter createListSorter(Comparator comparator) {
        return new IterativeMergesortListSorter(comparator);
    }
}
