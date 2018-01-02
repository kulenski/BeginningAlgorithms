package com.wrox.algorithms.stacks;

import com.wrox.algorithms.queues.EmptyQueueException;
import com.wrox.algorithms.queues.HeapOrderedListPriorityQueue;
import com.wrox.algorithms.sorting.Comparator;

/**
 * A {@link Stack} that uses a priority queue.
 *
 */
public class PriorityQueueStack extends HeapOrderedListPriorityQueue implements Stack {
    /** The comparator to use. */
    private final static Comparator COMPARATOR = new StackItemComparator();

    /** the item counter */
    private long _count = 0;

    public PriorityQueueStack() {
        super(COMPARATOR);
    }

    public void enqueue(Object value) {
        super.enqueue(new StackItem(++_count, value));
    }

    public Object dequeue() throws EmptyQueueException {
        return ((StackItem) super.dequeue()).getValue();
    }

    public void push(Object value) {
        enqueue(value);
    }

    public Object pop() throws EmptyStackException {
        try {
            return dequeue();
        } catch (EmptyQueueException e) {
            throw new EmptyStackException();
        }
    }

    public Object peek() throws EmptyStackException {
        Object result = pop();
        push(result);
        return result;
    }

    private static final class StackItem {
        private final long _key;
        private final Object _value;

        public StackItem(long key, Object value) {
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

    private static final class StackItemComparator implements Comparator {
        public int compare(Object left, Object right) throws ClassCastException {
            StackItem si1 = (StackItem) left;
            StackItem si2 = (StackItem) right;

            return (int) (si1.getKey() - si2.getKey());
        }
    }
}
