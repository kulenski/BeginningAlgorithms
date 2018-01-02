package com.wrox.algorithms.queues;

/**
 * A generic interface for queues.
 *
 */
public interface Queue {
    /**
     * Stores a value in the queue. The size of the queue will increase by one.
     *
     * @param value The value to add.
     */
    public void enqueue(Object value);

    /**
     * Retrieves the value at the head of the queue. The size of the queue will decrease by one.
     *
     * @return The value at the head of the queue.
     * @throws EmptyQueueException If the queue is empty (<code>isEmpty() == true</code>).
     */
    public Object dequeue() throws EmptyQueueException;

    /**
     * Deletes all elements from the queue. The size of the queue will be reset to zero (0).
     */
    public void clear();

    /**
     * Obtains the number of elements in the queue.
     *
     * @return The number of elements in the queue.
     */
    public int size();

    /**
     * Determines if the queue is empty or not.
     *
     * @return <code>true</code> if the queue is empty (<code>size() == 0</code>); otherwise returns <code>false</code>.
     */
    public boolean isEmpty();
}
