package com.wrox.algorithms.sorting;

/**
 */
public class BubblesortListSorterTest extends AbstractListSorterTestCase {
    protected ListSorter createListSorter(Comparator comparator) {
        return new BubblesortListSorter(comparator);
    }
}
