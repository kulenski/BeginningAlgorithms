package com.wrox.algorithms.queues;

import com.wrox.algorithms.lists.LinkedList;
import com.wrox.algorithms.lists.List;

/**
 * A First-In-First-Out (FIFO) {@link Queue} that uses a {@link List} internally.
 *
 */
public class ListFifoQueue implements Queue {
    /** The underlying list. */
    private final List _list;

    /**
     * Default constructor. Uses a {@link LinkedList} as the underlying list.
     */
    public ListFifoQueue() {
        this(new LinkedList());
    }

    /**
     * Constructor.
     *
     * @param list The underlying list.
     */
    public ListFifoQueue(List list) {
        _list = list;
    }

    public void enqueue(Object value) {
        _list.add(value);
    }

    public Object dequeue() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        return _list.delete(0);
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
