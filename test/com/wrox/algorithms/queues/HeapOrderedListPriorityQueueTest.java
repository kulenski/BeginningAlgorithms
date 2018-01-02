package com.wrox.algorithms.queues;

import com.wrox.algorithms.sorting.Comparator;

/**
 * Concrete tests for {@link com.wrox.algorithms.queues.HeapOrderedListPriorityQueue}.
 *
 */
public class HeapOrderedListPriorityQueueTest extends AbstractPriorityQueueTestCase {
    protected Queue createQueue(Comparator comparator) {
        return new HeapOrderedListPriorityQueue(comparator);
    }
}
