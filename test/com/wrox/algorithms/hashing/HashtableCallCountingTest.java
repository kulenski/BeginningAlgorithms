package com.wrox.algorithms.hashing;

import junit.framework.TestCase;

/**
 * Compare the performance of linear probing versus bucketing.
 *
 */
public class HashtableCallCountingTest extends TestCase {
    private static final int TEST_SIZE = 1000;
    private static final int INITIAL_CAPACITY = 17;

    private int _counter;
    private Hashtable _hashtable;

    public void testLinearProbingWithResizing() {
        _hashtable = new LinearProbingHashtable(INITIAL_CAPACITY);
        runAll();
    }

    public void testLinearProbingNoResizing() {
        _hashtable = new LinearProbingHashtable(TEST_SIZE);
        runAll();
    }

    public void testBucketsLoadFactor100Percent() {
        _hashtable = new BucketingHashtable(INITIAL_CAPACITY, 1.0f);
        runAll();
    }

    public void testBucketsLoadFactor75Percent() {
        _hashtable = new BucketingHashtable(INITIAL_CAPACITY, 0.75f);
        runAll();
    }

    public void testBuckets50Percent() {
        _hashtable = new BucketingHashtable(INITIAL_CAPACITY, 0.50f);
        runAll();
    }

    public void testBuckets25Percent() {
        _hashtable = new BucketingHashtable(INITIAL_CAPACITY, 0.25f);
        runAll();
    }

    public void testBuckets150Percent() {
        _hashtable = new BucketingHashtable(INITIAL_CAPACITY, 1.50f);
        runAll();
    }

    public void testBuckets200Percent() {
        _hashtable = new BucketingHashtable(INITIAL_CAPACITY, 2.0f);
        runAll();
    }

    private void runAll() {
        runAdd();
        runContains();
    }

    private void runAdd() {
        _counter = 0;
        for (int i = 0; i < TEST_SIZE; ++i) {
            _hashtable.add(new Value(i));
        }
        reportCalls("add");
    }

    private void runContains() {
        _counter = 0;
        for (int i = 0; i < TEST_SIZE; ++i) {
            _hashtable.contains(new Value(i));
        }
        reportCalls("contains");
    }

    private void reportCalls(String method) {
        System.out.println(getName() + "(" + method + "): " + _counter + " calls");
    }

    private final class Value {
        private final String _value;

        public Value(int value) {
            _value = String.valueOf(Math.random() * TEST_SIZE);
        }

        public int hashCode() {
            return _value.hashCode();
        }

        public boolean equals(Object object) {
            ++_counter;
            return object != null && _value.equals(((Value) object)._value);
        }
    }
}
