package com.wrox.algorithms.lists;

import com.wrox.algorithms.iteration.EmptyIterator;
import com.wrox.algorithms.iteration.Iterator;

/**
 * A {@link List} that is always empty.
 *
 */
public final class EmptyList implements List {
    /** The single instance of the class. */
    public static final EmptyList INSTANCE = new EmptyList();

    /**
     * Constructor marked private to prevent instantiation.
     */
    private EmptyList() {
    }

    public void insert(int index, Object value) throws IndexOutOfBoundsException {
        throw new UnsupportedOperationException();
    }

    public void add(Object value) {
        throw new UnsupportedOperationException();
    }

    public Object delete(int index) throws IndexOutOfBoundsException {
        throw new UnsupportedOperationException();
    }

    public boolean delete(Object value) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
    }

    public Object set(int index, Object value) throws IndexOutOfBoundsException {
        throw new UnsupportedOperationException();
    }

    public Object get(int index) throws IndexOutOfBoundsException {
        throw new UnsupportedOperationException();
    }

    public int indexOf(Object value) {
        return -1;
    }

    public boolean contains(Object value) {
        return false;
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
