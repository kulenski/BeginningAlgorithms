package com.wrox.algorithms.queues;

import com.wrox.algorithms.lists.LinkedList;
import com.wrox.algorithms.lists.List;
import com.wrox.algorithms.sorting.Comparator;

/**
 * A Priority {@link Queue} that uses a sorted {@link List} internally.
 *
 */
public class SortedListPriorityQueue implements Queue {
    /** The underlying list. */
    private final List _list;

    /** The comparator to determine priority. */
    private final Comparator _comparator;

    /**
     * Constructor. Uses a {@link LinkedList} as the underlying list.
     *
     * @param comparator The comparator to determine priority.
     */
    public SortedListPriorityQueue(Comparator comparator) {
        assert comparator != null : "comparator cannot be null";
        _comparator = comparator;
        _list = new LinkedList();
    }

    // TODO: This will perform like a dog as it uses a linked list! Consider using an iterator instead.
    // TODO: Or at least an ArrayList.
    public void enqueue(Object value) {
        int pos = _list.size();
        while (pos > 0 && _comparator.compare(_list.get(pos - 1), value) > 0) {
            --pos;
        }
        _list.insert(pos, value);
    }

    public Object dequeue() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        return _list.delete(_list.size() - 1);
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
