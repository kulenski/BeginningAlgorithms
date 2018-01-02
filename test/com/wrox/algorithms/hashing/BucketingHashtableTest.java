package com.wrox.algorithms.hashing;

/**
 * Test cases for {@link BucketingHashtable}.
 *
 */
public class BucketingHashtableTest extends AbstractHashtableTestCase {
    protected Hashtable createTable(int capacity) {
        return new BucketingHashtable(capacity, 0.75f);
    }
}
