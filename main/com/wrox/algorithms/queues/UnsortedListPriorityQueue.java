package com.wrox.algorithms.queues;

import com.wrox.algorithms.lists.LinkedList;
import com.wrox.algorithms.lists.List;
import com.wrox.algorithms.sorting.Comparator;

/**
 * A Priority {@link Queue} that uses an unordered {@link List} internally.
 *
 */
public class UnsortedListPriorityQueue implements Queue {
    /** The underlying list. */
    private final List _list;

    /** The comparator to determine priority. */
    private final Comparator _comparator;

    /**
     * Constructor. Uses a {@link LinkedList} as the underlying list.
     *
     * @param comparator The comparator to determine priority.
     */
    public UnsortedListPriorityQueue(Comparator comparator) {
        assert comparator != null : "comparator cannot be null";
        _comparator = comparator;
        _list = new LinkedList();
    }

    public void enqueue(Object value) {
        _list.add(value);
    }

    public Object dequeue() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        return _list.delete(getIndexOfLargestElement());
    }

    private int getIndexOfLargestElement() {
        int result = 0;

        for (int i = 1; i < _list.size(); ++i) {
            if (_comparator.compare(_list.get(i), _list.get(result)) > 0) {
                result = i;
            }
        }

        return result;
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
