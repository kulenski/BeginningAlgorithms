package com.wrox.algorithms.stacks;

import junit.framework.TestCase;

/**
 * Abstract base class for testing implementations of {@link Stack}.
 *
 */
public abstract class AbstractStackTestCase extends TestCase {
    protected static final Object VALUE_A = "A";
    protected static final Object VALUE_B = "B";
    protected static final Object VALUE_C = "C";

    protected abstract Stack createStack();

    public void testPushAndPop() {
        Stack stack = createStack();

        stack.push(VALUE_B);
        stack.push(VALUE_A);
        stack.push(VALUE_C);

        assertEquals(3, stack.size());
        assertFalse(stack.isEmpty());

        assertSame(VALUE_C, stack.pop());
        assertEquals(2, stack.size());
        assertFalse(stack.isEmpty());

        assertSame(VALUE_A, stack.pop());
        assertEquals(1, stack.size());
        assertFalse(stack.isEmpty());

        assertSame(VALUE_B, stack.pop());
        assertEquals(0, stack.size());
        assertTrue(stack.isEmpty());
    }

    public void testCantPopFromAnEmptyStack() {
        Stack stack = createStack();

        assertEquals(0, stack.size());
        assertTrue(stack.isEmpty());

        try {
            stack.pop();
            fail();
        } catch (EmptyStackException e) {
            // expected
        }
    }

    public void testPeek() {
        Stack stack = createStack();

        stack.push(VALUE_C);
        stack.push(VALUE_A);
        assertEquals(2, stack.size());

        assertSame(VALUE_A, stack.peek());
        assertEquals(2, stack.size());
    }

    public void testCantPeekIntoAnEmptyStack() {
        Stack stack = createStack();

        assertEquals(0, stack.size());
        assertTrue(stack.isEmpty());

        try {
            stack.peek();
            fail();
        } catch (EmptyStackException e) {
            // expected
        }
    }

    public void testClear() {
        Stack stack = createStack();

        stack.push(VALUE_A);
        stack.push(VALUE_B);
        stack.push(VALUE_C);

        assertFalse(stack.isEmpty());

        stack.clear();

        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());

        try {
            stack.pop();
            fail();
        } catch (EmptyStackException e) {
            // expected
        }
    }
}
