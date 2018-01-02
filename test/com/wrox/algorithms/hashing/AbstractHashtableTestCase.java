package com.wrox.algorithms.hashing;

import junit.framework.TestCase;

/**
 * Abstract base class for testing {@link Hashtable} implementations.
 *
 */
public abstract class AbstractHashtableTestCase extends TestCase {
    private static final int TEST_SIZE = 1000;

    private Hashtable _hashtable;

    protected void setUp() throws Exception {
        super.setUp();

        _hashtable = createTable(TEST_SIZE);

        for (int i = 0; i < TEST_SIZE; ++i) {
            _hashtable.add(String.valueOf(i));
        }
    }

    protected abstract Hashtable createTable(int capacity);

    public void testAddingTheSameValuesDoesntChangeTheSize() {
        assertEquals(TEST_SIZE, _hashtable.size());

        for (int i = 0; i < TEST_SIZE; ++i) {
            _hashtable.add(String.valueOf(i));
            assertEquals(TEST_SIZE, _hashtable.size());
        }
    }

    public void testContains() {
        for (int i = 0; i < TEST_SIZE; ++i) {
            assertTrue(_hashtable.contains(String.valueOf(i)));
        }
    }

    public void testDoesntContain() {
        for (int i = 0; i < TEST_SIZE; ++i) {
            assertFalse(_hashtable.contains(String.valueOf(i + TEST_SIZE)));
        }
    }
}
