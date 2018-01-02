package com.wrox.algorithms.queues;

/**
 * Test cases for {@link com.wrox.algorithms.queues.PriorityQueueFifoQueue}.
 *
 */
public class PriorityQueueFifoQueueTest extends AbstractFifoQueueTestCase {
    protected Queue createFifoQueue() {
        return new PriorityQueueFifoQueue();
    }
}
