package com.wrox.algorithms.iteration;

/**
 * An {@link Iterator} that filters the results according to some {@link Predicate}.
 *
 */
public class FilterIterator implements Iterator {
    /** The underlying iterator. */
    private final Iterator _iterator;

    /** The filter to apply. */
    private final Predicate _predicate;

    /**
     * Constructor.
     *
     * @param iterator The underlying iterator.
     * @param predicate The filter to apply.
     */
    public FilterIterator(Iterator iterator, Predicate predicate) {
        assert iterator != null : "iterator can't be null";
        assert predicate != null : "predicate can't be null";
        _iterator = iterator;
        _predicate = predicate;
    }

    public void first() {
        _iterator.first();
        filterForwards();
    }

    public void last() {
        _iterator.last();
        filterBackwards();
    }

    public boolean isDone() {
        return _iterator.isDone();
    }

    public void next() {
        _iterator.next();
        filterForwards();
    }

    public void previous() {
        _iterator.previous();
        filterBackwards();
    }

    public Object current() throws IteratorOutOfBoundsException {
        return _iterator.current();
    }

    /**
     * Applies the filter, calling {@link Iterator#next()} on the underlying iterator until either a match is found; or
     * the iterator is done.
     */
    private void filterForwards() {
        while (!_iterator.isDone() && !_predicate.evaluate(_iterator.current())) {
            _iterator.next();
        }
    }

    /**
     * Applies the filter, calling {@link Iterator#previous()} on the underlying iterator until either a match is found;
     * or the iterator is done.
     */
    private void filterBackwards() {
        while (!_iterator.isDone() && !_predicate.evaluate(_iterator.current())) {
            _iterator.previous();
        }
    }
}
