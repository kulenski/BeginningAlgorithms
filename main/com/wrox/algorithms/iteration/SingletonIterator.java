package com.wrox.algorithms.iteration;

/**
 * An {@link Iterator} over a single value.
 *
 */
public class SingletonIterator implements Iterator {
    /** The single value. */
    private final Object _value;

    /** Indicates if we have finished iterating. */
    private boolean _done;

    /**
     * Constructor.
     *
     * @param value The single value over which to iterate.
     */
    public SingletonIterator(Object value) {
        assert value != null : "value can't be null";
        _value = value;
    }

    public void first() {
        _done = false;
    }

    public void last() {
        _done = false;
    }

    public boolean isDone() {
        return _done;
    }

    public void next() {
        _done = true;
    }

    public void previous() {
        _done = true;
    }

    public Object current() throws IteratorOutOfBoundsException {
        if (isDone()) {
            throw new IteratorOutOfBoundsException();
        }
        return _value;
    }
}
