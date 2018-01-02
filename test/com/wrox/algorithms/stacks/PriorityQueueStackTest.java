package com.wrox.algorithms.stacks;

/**
 * Concrete tests for {@link com.wrox.algorithms.stacks.Stack}
 * implemented using a priority queue..
 *
 */
public class PriorityQueueStackTest extends AbstractStackTestCase {
    protected Stack createStack() {
        return new PriorityQueueStack();
    }
}
