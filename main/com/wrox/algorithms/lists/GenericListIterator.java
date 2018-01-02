package com.wrox.algorithms.lists;

import com.wrox.algorithms.iteration.Iterator;
import com.wrox.algorithms.iteration.IteratorOutOfBoundsException;

/**
 * An {@link Iterator} that will work for any {@link List}.
 *
 */
public class GenericListIterator implements Iterator {
    /** The list over which iteration will be performed. */
    private final List _list;

    /** The current position within the list. */
    private int _current = -1;

    /**
     * Constructor.
     *
     * @param list The list over which iteration will be performed.
     */
    public GenericListIterator(List list) {
        assert list != null : "list can't be null";
        _list = list;
    }

    public void first() {
        _current = 0;
    }

    public void last() {
        _current = _list.size() - 1;
    }

    public boolean isDone() {
        return _current < 0 || _current >= _list.size();
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
        return _list.get(_current);
    }
}
