package com.wrox.algorithms.sorting;

/**
 */
public class HybridQuicksortListSorterTest extends AbstractListSorterTestCase {
    protected ListSorter createListSorter(Comparator comparator) {
        return new HybridQuicksortListSorter(comparator);
    }
}
