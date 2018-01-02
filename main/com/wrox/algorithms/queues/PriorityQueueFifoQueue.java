package com.wrox.algorithms.queues;

import com.wrox.algorithms.sorting.Comparator;

/**
 * Sample solution for exercise 8-2.
 * A First-In-First-Out (FIFO) {@link com.wrox.algorithms.queues.Queue}
 * that uses a priority {@link com.wrox.algorithms.queues.Queue} internally.
 *
 */
public class PriorityQueueFifoQueue extends HeapOrderedListPriorityQueue {
    private static final Comparator COMPARATOR = new QueueItemComparator();

    /** the item counter */
    private long _count = Long.MAX_VALUE;

    public PriorityQueueFifoQueue() {
        super(COMPARATOR);
    }

    public void enqueue(Object value) {
        super.enqueue(new QueueItem(--_count, value));
    }

    public Object dequeue() throws EmptyQueueException {
        return ((QueueItem) super.dequeue()).getValue();
    }

    private static final class QueueItem {
        private final long _key;
        private final Object _value;

        public QueueItem(long key, Object value) {
            _key = key;
            _value = value;
        }

        public long getKey() {
            return _key;
        }

        public Object getValue() {
            return _value;
        }
    }

    private static final class QueueItemComparator implements Comparator {
        public int compare(Object left, Object right) throws ClassCastException {
            QueueItem si1 = (QueueItem) left;
            QueueItem si2 = (QueueItem) right;

            return (int) (si1.getKey() - si2.getKey());
        }
    }
}
