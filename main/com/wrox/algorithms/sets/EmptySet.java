package com.wrox.algorithms.sets;

import com.wrox.algorithms.iteration.EmptyIterator;
import com.wrox.algorithms.iteration.Iterator;

/**
 * A {@link Set} that is always empty.
 *
 */
public final class EmptySet implements Set {
    /** The single instance of the class. */
    public static final EmptySet INSTANCE = new EmptySet();

    /**
     * Constructor marked private to prevent instantiation.
     */
    private EmptySet() {
    }

    public boolean contains(Object value) {
        return false;
    }

    public boolean add(Object value) {
        throw new UnsupportedOperationException();
    }

    public boolean delete(Object value) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
    }

    public int size() {
        return 0;
    }

    public boolean isEmpty() {
        return true;
    }

    public Iterator iterator() {
        return EmptyIterator.INSTANCE;
    }
}
