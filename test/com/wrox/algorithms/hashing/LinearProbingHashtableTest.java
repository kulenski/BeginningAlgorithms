package com.wrox.algorithms.hashing;

/**
 * Test cases for {@link LinearProbingHashtable}.
 * 
 */
public class LinearProbingHashtableTest extends AbstractHashtableTestCase {
    protected Hashtable createTable(int capacity) {
        return new LinearProbingHashtable(capacity);
    }
}
