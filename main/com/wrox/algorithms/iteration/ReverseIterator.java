package com.wrox.algorithms.iteration;

/**
 * An {@link Iterator} that reverses the iteration direction of another.
 *
 */
public class ReverseIterator implements Iterator {
    /** The underlying iterator. */
    private final Iterator _iterator;

    /**
     * Constructor.
     *
     * @param iterator The underlying iterator.
     */
    public ReverseIterator(Iterator iterator) {
        assert iterator != null : "iterator can't be null";
        _iterator = iterator;
    }

    public void first() {
        _iterator.last();
    }

    public void last() {
        _iterator.first();
    }

    public boolean isDone() {
        return _iterator.isDone();
    }

    public void next() {
        _iterator.previous();
    }

    public void previous() {
        _iterator.next();
    }

    public Object current() throws IteratorOutOfBoundsException {
        return _iterator.current();
    }
}
