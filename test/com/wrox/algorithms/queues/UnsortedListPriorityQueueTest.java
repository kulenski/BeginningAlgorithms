package com.wrox.algorithms.queues;

import com.wrox.algorithms.sorting.Comparator;

/**
 * Concrete tests for {@link com.wrox.algorithms.queues.UnsortedListPriorityQueue}.
 *
 */
public class UnsortedListPriorityQueueTest extends AbstractPriorityQueueTestCase {
    protected Queue createQueue(Comparator comparator) {
        return new UnsortedListPriorityQueue(comparator);
    }
}
