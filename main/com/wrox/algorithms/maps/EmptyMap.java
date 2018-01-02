package com.wrox.algorithms.maps;

import com.wrox.algorithms.iteration.EmptyIterator;
import com.wrox.algorithms.iteration.Iterator;

/**
 * A {@link Map} that is always empty.
 *
 */
public final class EmptyMap implements Map {
    /** The single instance of the class. */
    public static final EmptyMap INSTANCE = new EmptyMap();

    /**
     * Constructor marked private to prevent instantiation.
     */
    private EmptyMap() {
    }

    public Object get(Object key) {
        return null;
    }

    public Object set(Object key, Object value) {
        throw new UnsupportedOperationException();
    }

    public Object delete(Object key) {
        throw new UnsupportedOperationException();
    }

    public boolean contains(Object key) {
        return false;
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
