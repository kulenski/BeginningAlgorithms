package com.wrox.algorithms.stacks;

import com.wrox.algorithms.lists.LinkedList;
import com.wrox.algorithms.lists.List;
import com.wrox.algorithms.queues.EmptyQueueException;

/**
 * A {@link Stack} that uses a {@link List} internally.
 *
 */
public class ListStack implements Stack {
    /** The underlying list. */
    private final List _list = new LinkedList();

    public void push(Object value) {
        _list.add(value);
    }

    public Object pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return _list.delete(_list.size() - 1);
    }

    public Object peek() throws EmptyStackException {
        Object result = pop();
        push(result);
        return result;
    }

    public void enqueue(Object value) {
        push(value);
    }

    public Object dequeue() throws EmptyQueueException {
        try {
            return pop();
        } catch (EmptyStackException e) {
            throw new EmptyQueueException();
        }
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
