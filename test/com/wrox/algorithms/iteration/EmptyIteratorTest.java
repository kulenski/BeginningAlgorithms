package com.wrox.algorithms.iteration;

import junit.framework.TestCase;

/**
 * Test cases for {@link EmptyIterator}.
 *
 */
public class EmptyIteratorTest extends TestCase {
    public void testForwardsIteration() {
        EmptyIterator iterator = EmptyIterator.INSTANCE;

        assertTrue(iterator.isDone());

        iterator.first();
        assertTrue(iterator.isDone());
        try {
            iterator.current();
            fail();
        } catch (IteratorOutOfBoundsException e) {
            // expected
        }

        iterator.next();
        assertTrue(iterator.isDone());
        try {
            iterator.current();
            fail();
        } catch (IteratorOutOfBoundsException e) {
            // expected
        }
    }

    public void testBackwardsIteration() {
        EmptyIterator iterator = EmptyIterator.INSTANCE;

        assertTrue(iterator.isDone());

        iterator.last();
        assertTrue(iterator.isDone());
        try {
            iterator.current();
            fail();
        } catch (IteratorOutOfBoundsException e) {
            // expected
        }

        iterator.previous();
        assertTrue(iterator.isDone());
        try {
            iterator.current();
            fail();
        } catch (IteratorOutOfBoundsException e) {
            // expected
        }
    }
}
