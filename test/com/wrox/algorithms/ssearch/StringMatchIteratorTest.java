package com.wrox.algorithms.ssearch;

import com.wrox.algorithms.iteration.Iterator;
import com.wrox.algorithms.iteration.IteratorOutOfBoundsException;
import junit.framework.TestCase;

/**
 * Test cases for {@link StringMatchIterator}.
 *
 */
public class StringMatchIteratorTest extends TestCase {
    public void test() {
        String pattern = "abba";
        String text = "abbabbaabba";

        Iterator iterator = new StringMatchIterator(new BruteForceStringSearcher(pattern), text);

        iterator.first();
        assertFalse(iterator.isDone());
        StringMatch match = (StringMatch) iterator.current();
        assertNotNull(match);
        assertSame(pattern, match.getPattern());
        assertSame(text, match.getText());
        assertEquals(0, match.getIndex());

        iterator.next();
        assertFalse(iterator.isDone());
        match = (StringMatch) iterator.current();
        assertNotNull(match);
        assertSame(pattern, match.getPattern());
        assertSame(text, match.getText());
        assertEquals(3, match.getIndex());

        iterator.next();
        assertFalse(iterator.isDone());
        match = (StringMatch) iterator.current();
        assertNotNull(match);
        assertSame(pattern, match.getPattern());
        assertSame(text, match.getText());
        assertEquals(7, match.getIndex());

        iterator.next();
        assertTrue(iterator.isDone());

        try {
            iterator.current();
            fail();
        } catch (IteratorOutOfBoundsException e) {
            // expected
        }
    }
}
