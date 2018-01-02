package com.wrox.algorithms.sorting;

/**
 */
public class PriorityQueueListSorterTest extends AbstractListSorterTestCase {
    protected ListSorter createListSorter(Comparator comparator) {
        return new PriorityQueueListSorter(comparator);
    }
}
