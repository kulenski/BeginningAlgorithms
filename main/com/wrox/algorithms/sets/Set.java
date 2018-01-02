package com.wrox.algorithms.sets;

import com.wrox.algorithms.iteration.Iterable;

/**
 * Generic interface for sets.
 *
 */
public interface Set extends Iterable {
    /**
     * Determines if a value exists in the set.
     *
     * @param value The value for which to search.
     * @return <code>true</code> if found; otherwise <code>false</code>.
     */
    public boolean contains(Object value);

    /**
     * Adds a value to the set.
     *
     * @param value The value to add.
     * @return <code>true</code> if added; otherwise <code>false</code> if already existed.
     */
    public boolean add(Object value);

    /**
     * Removes a value from the set.
     *
     * @param value The value to delete.
     * @return <code>true</code> if removed; otherwise <code>false</code> if not found.
     */
    public boolean delete(Object value);

    /**
     * Deletes all values from the set. The size of the set will be reset to zero (0).
     */
    public void clear();

    /**
     * Obtains the size of the set.
     *
     * @return The number of values in the set.
     */
    public int size();

    /**
     * Determines if the set is empty or not.
     *
     * @return <code>true</code> if the set is empty (<code>size() == 0</code>); otherwise returns <code>false</code>.
     */
    public boolean isEmpty();
}
