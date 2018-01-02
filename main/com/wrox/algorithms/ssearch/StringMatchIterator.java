package com.wrox.algorithms.ssearch;

import com.wrox.algorithms.iteration.Iterator;
import com.wrox.algorithms.iteration.IteratorOutOfBoundsException;

/**
 * An {@link Iterator} over a {@link StringSearcher}. Successfull calls to {@link #current} will return a
 * {@link StringMatch}.
 *
 */
public class StringMatchIterator implements Iterator {
    /** The underlying searcher to use. */
    private final StringSearcher _searcher;

    /** The text to search. */
    private final CharSequence _text;

    /** The current match; or <code>null</code> if none. */
    private StringMatch _current;

    /**
     * Constructor.
     *
     * @param searcher The underlying searcher to use.
     */
    public StringMatchIterator(StringSearcher searcher, CharSequence text) {
        assert searcher != null : "searcher can't be null";
        assert text != null : "text can't be null";

        _searcher = searcher;
        _text = text;
    }

    public void first() {
        _current = _searcher.search(_text, 0);
    }

    public void last() {
        throw new UnsupportedOperationException();
    }

    public boolean isDone() {
        return _current == null;
    }

    public void next() {
        if (!isDone()) {
            _current = _searcher.search(_text, _current.getIndex() + 1);
        }
    }

    public void previous() {
        throw new UnsupportedOperationException();
    }

    public Object current() throws IteratorOutOfBoundsException {
        if (isDone()) {
            throw new IteratorOutOfBoundsException();
        }
        return _current;
    }
}
