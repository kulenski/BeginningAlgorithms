package com.wrox.algorithms.queues;

import com.wrox.algorithms.sorting.Comparator;

/**
 * Concrete tests for {@link SortedListPriorityQueue}.
 *
 */
public class SortedListPriorityQueueTest extends AbstractPriorityQueueTestCase {
    protected Queue createQueue(Comparator comparator) {
        return new SortedListPriorityQueue(comparator);
    }
}
