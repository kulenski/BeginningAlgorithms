package com.wrox.algorithms.maps;

import com.wrox.algorithms.iteration.Iterator;
import com.wrox.algorithms.lists.LinkedList;
import com.wrox.algorithms.lists.List;

/**
 * A {@link Map} that uses a {@link LinkedList}.
 *
 */
public class ListMap implements Map {
    /** The underlying list of entries. */
    private final List _entries = new LinkedList();

    public Object get(Object key) {
        DefaultEntry entry = entryFor(key);
        return entry != null ? entry.getValue() : null;
    }

    public Object set(Object key, Object value) {
        DefaultEntry entry = entryFor(key);
        if (entry != null) {
            return entry.setValue(value);
        }

        _entries.add(new DefaultEntry(key, value));
        return null;
    }

    public Object delete(Object key) {
        DefaultEntry entry = entryFor(key);
        if (entry == null) {
            return null;
        }

        _entries.delete(entry);
        return entry.getValue();
    }

    public boolean contains(Object key) {
        return entryFor(key) != null;
    }

    public void clear() {
        _entries.clear();
    }

    public int size() {
        return _entries.size();
    }

    public boolean isEmpty() {
        return _entries.isEmpty();
    }

    public Iterator iterator() {
        return _entries.iterator();
    }

    /**
     * Obtains the entry (if any) for a specified key.
     *
     * @param key The key for which an entry is required.
     * @return The entry; or <code>null</code> if the key was not found.
     */
    private DefaultEntry entryFor(Object key) {
        Iterator i = iterator();
        for (i.first(); !i.isDone(); i.next()) {
            DefaultEntry entry = (DefaultEntry) i.current();
            if (entry.getKey().equals(key)) {
                return entry;
            }
        }

        return null;
    }
}
