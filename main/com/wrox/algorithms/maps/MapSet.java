package com.wrox.algorithms.maps;

import com.wrox.algorithms.iteration.Iterator;
import com.wrox.algorithms.sets.Set;

/**
 * A {@link Set} that uses a {@link Map} as the underlying storage mechanism.
 *
 */
public class MapSet implements Set {
    /** Special value when adding to the underlying map. */
    private static final Object PRESENT = new Object();

    /** The underlying map. */
    private final Map _map;

    /**
     * Constructor.
     *
     * @param map The underlying map.
     */
    public MapSet(Map map) {
        assert map != null : "map can't be null";
        _map = map;
    }

    public boolean contains(Object value) {
        return _map.contains(value);
    }

    public boolean add(Object value) {
        return _map.set(value, PRESENT) == null;
    }

    public boolean delete(Object value) {
        return _map.delete(value) == PRESENT;
    }

    public Iterator iterator() {
        return new MapKeyIterator(_map.iterator());
    }

    public void clear() {
        _map.clear();
    }

    public int size() {
        return _map.size();
    }

    public boolean isEmpty() {
        return _map.isEmpty();
    }
}
