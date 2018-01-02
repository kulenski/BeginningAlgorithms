package com.wrox.algorithms.hashing;

import com.wrox.algorithms.iteration.EmptyIterator;
import com.wrox.algorithms.iteration.Iterable;
import com.wrox.algorithms.iteration.Iterator;
import com.wrox.algorithms.iteration.IteratorOutOfBoundsException;

/**
 */
public class HashtableIterator implements Iterator {
    private final Iterator _buckets;
    private Iterator _values = EmptyIterator.INSTANCE;

    public HashtableIterator(Iterator buckets) {
        assert buckets != null : "buckets can't be null";
        _buckets = buckets;
    }

    public void first() {
        _buckets.first();
        _values = EmptyIterator.INSTANCE;
        next();
    }

    public void last() {
        _buckets.last();
        _values = EmptyIterator.INSTANCE;
        previous();
    }

    public boolean isDone() {
        return _values.isDone() && _buckets.isDone();
    }

    public void next() {
        for (_values.next(); _values.isDone() && !_buckets.isDone(); _buckets.next()) {
            Iterable bucket = (Iterable) _buckets.current();
            if (bucket != null) {
                _values = bucket.iterator();
                _values.first();
            }
        }
    }

    public void previous() {
        for (_values.previous(); _values.isDone() && !_buckets.isDone(); _buckets.previous()) {
            Iterable bucket = (Iterable) _buckets.current();
            if (bucket != null) {
                _values = bucket.iterator();
                _values.last();
            }
        }
    }

    public Object current() throws IteratorOutOfBoundsException {
        if (isDone()) {
            throw new IteratorOutOfBoundsException();
        }
        return _values.current();
    }
}
