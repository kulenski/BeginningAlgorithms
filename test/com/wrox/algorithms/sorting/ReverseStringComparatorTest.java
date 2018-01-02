package com.wrox.algorithms.sorting;

import junit.framework.TestCase;

/**
 * Test cases for {@link com.wrox.algorithms.sorting.ReverseStringComparator}.
 *
 */
public class ReverseStringComparatorTest extends TestCase {
    private ReverseStringComparator _comparator = ReverseStringComparator.INSTANCE;

    public void testComparatorSortsAccordingToReversedString() {
        assertEquals(0, _comparator.compare("abc", "abc"));
        assertEquals(0, _comparator.compare("", ""));

        assertTrue(0 < _comparator.compare("abc", "cba"));
        assertTrue(0 < _comparator.compare("abc", "qbb"));

        assertTrue(0 > _comparator.compare("abc", "abd"));
        assertTrue(0 > _comparator.compare("abc", "bbc"));
    }
}
