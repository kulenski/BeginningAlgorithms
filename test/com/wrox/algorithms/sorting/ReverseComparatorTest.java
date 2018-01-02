package com.wrox.algorithms.sorting;

import junit.framework.TestCase;

/**
 * Test cases for {@link ReverseComparator}.
 * 
 */
public class ReverseComparatorTest extends TestCase {
    public void testLessThanBecomesGreaterThan() {
        ReverseComparator comparator = new ReverseComparator(NaturalComparator.INSTANCE);

        assertTrue(comparator.compare("A", "B") > 0);
    }

    public void testGreaterThanBecomesLessThan() {
        ReverseComparator comparator = new ReverseComparator(NaturalComparator.INSTANCE);

        assertTrue(comparator.compare("B", "A") < 0);
    }

    public void testEqualsRemainsUnchanged() {
        ReverseComparator comparator = new ReverseComparator(NaturalComparator.INSTANCE);

        assertTrue(comparator.compare("A", "A") == 0);
    }
}
