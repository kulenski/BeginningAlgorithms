package com.wrox.algorithms.stacks;

/**
 * Concrete tests for {@link ListStack}.
 *
 */
public class ListStackTest extends AbstractStackTestCase {
    protected Stack createStack() {
        return new ListStack();
    }
}
