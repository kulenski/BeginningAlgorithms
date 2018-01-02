package com.wrox.algorithms.queues;

/**
 * Test cases for {@link ListFifoQueue}.
 *
 */
public class ListFifoQueueTest extends AbstractFifoQueueTestCase {
    protected Queue createFifoQueue() {
        return new ListFifoQueue();
    }
}
