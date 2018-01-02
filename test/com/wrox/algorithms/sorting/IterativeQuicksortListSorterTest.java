package com.wrox.algorithms.sorting;

/**
 */
public class IterativeQuicksortListSorterTest extends AbstractListSorterTestCase {
    protected ListSorter createListSorter(Comparator comparator) {
        return new IterativeQuicksortListSorter(comparator);
    }
}
