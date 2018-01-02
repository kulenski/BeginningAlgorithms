package com.wrox.algorithms.queues;

import com.wrox.algorithms.lists.LinkedList;
import com.wrox.algorithms.lists.List;

/**
 * A {@link Queue} that uses a {@link List} internally and retrieves values in random order.
 *
 */
public class RandomListQueue implements Queue {
    /** The underlying list. */
    private final List _list;

    /**
     * Default constructor. Uses a {@link LinkedList} as the underlying list.
     */
    public RandomListQueue() {
        this(new LinkedList());
    }

    /**
     * Constructor.
     *
     * @param list The underlying list.
     */
    public RandomListQueue(List list) {
        _list = list;
    }

    public void enqueue(Object value) {
        _list.add(value);
    }

    public Object dequeue() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        return _list.delete((int) (Math.random() * size()));
    }

    public void clear() {
        _list.clear();
    }

    public int size() {
        return _list.size();
    }

    public boolean isEmpty() {
        return _list.isEmpty();
    }
}
