package com.wrox.algorithms.queues;

import com.wrox.algorithms.sorting.Comparator;
import com.wrox.algorithms.sorting.ReverseComparator;

/**
 * A minimum-oriented Priority {@link com.wrox.algorithms.queues.Queue} that uses a
 * heap-ordered {@link com.wrox.algorithms.lists.List} internally.
 *
 */
public class MinimumOrientedHeapOrderedListPriorityQueue
        extends HeapOrderedListPriorityQueue {
    public MinimumOrientedHeapOrderedListPriorityQueue(Comparator comparator) {
        super(new ReverseComparator(comparator));
    }
}
