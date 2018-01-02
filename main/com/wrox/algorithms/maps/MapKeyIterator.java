package com.wrox.algorithms.maps;

import com.wrox.algorithms.iteration.Iterator;
import com.wrox.algorithms.iteration.IteratorOutOfBoundsException;

/**
 * An iterator over all the keys in a {@link Map}.
 *
 */
public class MapKeyIterator implements Iterator {
    /** The underlying iterator over the map entries. */
    private final Iterator _entries;

    /**
     * Constructor.
     *
     * @param entries The underlying iterator over the map entries.
     */
    public MapKeyIterator(Iterator entries) {
        assert entries != null : "entries can't be null";
        _entries = entries;
    }

    public void first() {
        _entries.first();
    }

    public void last() {
        _entries.last();
    }

    public boolean isDone() {
        return _entries.isDone();
    }

    public void next() {
        _entries.next();
    }

    public void previous() {
        _entries.previous();
    }

    public Object current() throws IteratorOutOfBoundsException {
        return ((Map.Entry) _entries.current()).getKey();
    }
}
