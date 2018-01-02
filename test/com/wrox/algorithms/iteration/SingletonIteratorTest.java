package com.wrox.algorithms.iteration;

import junit.framework.TestCase;

/**
 * Test cases for {@link SingletonIterator}.
 *
 */
public class SingletonIteratorTest extends TestCase {
    public void testForwardsIteration() {
        String value = "X";
        SingletonIterator iterator = new SingletonIterator(value);

        iterator.first();
        assertFalse(iterator.isDone());
        assertSame(value, iterator.current());

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
        String value = "X";
        SingletonIterator iterator = new SingletonIterator(value);

        iterator.last();
        assertFalse(iterator.isDone());
        assertSame(value, iterator.current());

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
