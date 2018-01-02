package com.wrox.algorithms.iteration;

/**
 * An {@link Iterator} over the contents of an array.
 *
 */
public class ArrayIterator implements Iterator {
    /** The array to iterator over. */
    private final Object[] _array;

    /** The position(0, 1, 2...) of the first element. */
    private final int _first;

    /* The position (0, 1, 2...) of the last element. */
    private final int _last;

    /** The position (0, 1, 2...) of the current element in the array. */
    private int _current = -1;

    /**
     * Constructor.
     *
     * @param array The array to iterate over.
     */
    public ArrayIterator(Object[] array) {
        assert array != null : "array can't be null";
        _array = array;
        _first = 0;
        _last = array.length - 1;
    }

    /**
     * Constructor.
     *
     * @param array The array to iterator over.
     * @param start The position (0, 1, 2...) of the element from which to begin iterating.
     * @param length The number of elements to iterator over.
     */
    public ArrayIterator(Object[] array, int start, int length) {
        assert array != null : "array can't be null";
        assert start >= 0 : "start can't be < 0";
        assert start < array.length : "start can't be > array.length";
        assert length >= 0 : "length can't be < 0";

        _array = array;
        _first = start;
        _last = start + length - 1;

        assert _last < array.length : "start + length can't be > array.length";
    }

    public void first() {
        _current = _first;
    }

    public void last() {
        _current = _last;
    }

    public boolean isDone() {
        return _current < _first || _current > _last;
    }

    public void next() {
        ++_current;
    }

    public void previous() {
        --_current;
    }

    public Object current() throws IteratorOutOfBoundsException {
        if (isDone()) {
            throw new IteratorOutOfBoundsException();
        }
        return _array[_current];
    }
}
