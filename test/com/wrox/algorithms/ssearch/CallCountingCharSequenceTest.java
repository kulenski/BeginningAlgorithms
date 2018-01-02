package com.wrox.algorithms.ssearch;

import junit.framework.TestCase;

/**
 * Test cases for {@link CallCountingCharSequence}.
 *
 */
public class CallCountingCharSequenceTest extends TestCase {
    public void test() {
        String text = "Hello, World";
        CallCountingCharSequence sequence = new CallCountingCharSequence(text);

        assertEquals(0, sequence.getCallCount());
        assertEquals(text.length(), sequence.length());

        for (int i = text.length() - 1; i >= 0; --i) {
            assertEquals(text.charAt(i), sequence.charAt(i));
        }

        for (int i = text.length() - 1; i >= 0; --i) {
            assertEquals(text.charAt(i), sequence.charAt(i));
        }

        assertEquals(text.length() * 2, sequence.getCallCount());
    }
}
