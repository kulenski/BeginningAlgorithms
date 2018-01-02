package com.wrox.algorithms.queues;

/**
 * A simple thread-safe {@link Queue}.
 *
 * TODO: Test.
 */
public class SynchronizedQueue implements Queue {
    /** The lock object to use for synchronisation. */
    private final Object _mutex = new Object();

    /** The underlying queue. */
    private final Queue _queue;

    /**
     * Constructor.
     *
     * @param queue The underlying Queue.
     */
    public SynchronizedQueue(Queue queue) {
        assert queue != null : "queue can't be null";
        _queue = queue;
    }

    public void enqueue(Object value) {
        synchronized (_mutex) {
            _queue.enqueue(value);
        }
    }

    public Object dequeue() throws EmptyQueueException {
        synchronized (_mutex) {
            return _queue.dequeue();
        }
    }

    public void clear() {
        synchronized (_mutex) {
            _queue.clear();
        }
    }

    public int size() {
        synchronized (_mutex) {
            return _queue.size();
        }
    }

    public boolean isEmpty() {
        synchronized (_mutex) {
            return _queue.isEmpty();
        }
    }
}
