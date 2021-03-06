package com.wrox.algorithms.sets;

import com.wrox.algorithms.hashing.HashtableIterator;
import com.wrox.algorithms.iteration.ArrayIterator;
import com.wrox.algorithms.iteration.Iterator;

/**
 * A {@link Set} that uses a hash table.
 *
 */
public class HashSet implements Set {
    /** The default initial number of buckets. */
    public static final int DEFAULT_CAPACITY = 17;

    /** The default threshold load factor after which resizing occurs. */
    public static final float DEFAULT_LOAD_FACTOR = 0.75f;

    /** The initial number of buckets. */
    private final int _initialCapacity;

    /** The threshold load factor after which resizing occurs. */
    private final float _loadFactor;

    /** The buckets for holding values. */
    private ListSet[] _buckets;

    /** The number of values in the table. */
    private int _size;

    /**
     * Default constructor. Assumes an initial capacity of <code>17</code> and a load factor of <code>0.75f</code>.
     */
    public HashSet() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    /**
     * Constructor. Assumes a load factor of <code>0.75f</code>.
     * @param initialCapacity The initial number of buckets.
     */
    public HashSet(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }

    /**
     * Constructor.
     *
     * @param initialCapacity The initial number of buckets.
     * @param loadFactor The threshold load factor after which resizing occurs.
     */
    public HashSet(int initialCapacity, float loadFactor) {
        assert initialCapacity > 0 : "initialCapacity can't be < 1";
        assert loadFactor > 0 : "loadFactor can't be <= 0";

        _initialCapacity = initialCapacity;
        _loadFactor = loadFactor;
        clear();
    }

    public boolean contains(Object value) {
        ListSet bucket = _buckets[bucketIndexFor(value)];
        return bucket != null && bucket.contains(value);
    }

    public boolean add(Object value) {
        ListSet bucket = bucketFor(value);

        if (bucket.add(value)) {
            ++_size;
            maintainLoad();
            return true;
        }

        return false;
    }

    public boolean delete(Object value) {
        int bucketIndex = bucketIndexFor(value);
        ListSet bucket = _buckets[bucketIndex];
        if (bucket != null && bucket.delete(value)) {
            --_size;
            if (bucket.isEmpty()) {
                _buckets[bucketIndex] = null;
            }
            return true;
        }

        return false;
    }

    public Iterator iterator() {
        return new HashtableIterator(new ArrayIterator(_buckets));
    }

    public void clear() {
        _buckets = new ListSet[_initialCapacity];
        _size = 0;
    }

    public int size() {
        return _size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Obtains a bucket for a specified value.
     *
     * @param value The value for which a bucket is required.
     * @return The bucket.
     */
    private ListSet bucketFor(Object value) {
        int bucketIndex = bucketIndexFor(value);

        ListSet bucket = _buckets[bucketIndex];
        if (bucket == null) {
            bucket = new ListSet();
            _buckets[bucketIndex] = bucket;
        }

        return bucket;
    }

    /**
     * Obtains the index to the bucket appropriate for a specified value.
     *
     * @param value The value for which the index is desired.
     * @return The bucket index.
     */
    private int bucketIndexFor(Object value) {
        assert value != null : "value can't be null";
        return Math.abs(value.hashCode() % _buckets.length);
    }

    /**
     * Resizes the table to satisfy the load factor requirements.
     */
    private void maintainLoad() {
        if (loadFactorExceeded()) {
            resize();
        }
    }

    /**
     * Determines if the load factor threshold has been exceeded.
     *
     * @return <code>true</code> if the threshold has been exceeded; otherwise <code>false</code>.
     */
    private boolean loadFactorExceeded() {
        return size() > _buckets.length * _loadFactor;
    }

    /**
     * Re-sizes the table.
     */
    private void resize() {
        HashSet copy = new HashSet(_buckets.length * 2, _loadFactor);

        for (int i = 0; i < _buckets.length; ++i) {
            if (_buckets[i] != null) {
                copy.addAll(_buckets[i].iterator());
            }
        }

        _buckets = copy._buckets;
    }

    /**
     * Adds all values from a bucket into the table.
     *
     * @param values The values.
     */
    private void addAll(Iterator values) {
        assert values != null : "values can't be null";

        for (values.first(); !values.isDone(); values.next()) {
            add(values.current());
        }
    }
}
