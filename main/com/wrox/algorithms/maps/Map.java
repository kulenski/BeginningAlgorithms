package com.wrox.algorithms.maps;

import com.wrox.algorithms.iteration.Iterable;

/**
 * A generic interface for maps.
 *
 */
public interface Map extends Iterable {
    /**
     * Obtains the value for a given key.
     *
     * @param key The key for which the value should be obtained.
     * @return The value; or <code>null</code> if none.
     */
    public Object get(Object key);

    /**
     * Adds/replaces a key/value pair in the map.
     *
     * @param key The key to set.
     * @param value The value to set.
     * @return The old value; or <code>null</code> if none.
     */
    public Object set(Object key, Object value);

    /**
     * Removes a key/value pair from the map.
     *
     * @param key The key to delete.
     * @return The associated value; or <code>null</code> if the key didn't exist.
     */
    public Object delete(Object key);

    /**
     * Determines if a key exists in the map.
     *
     * @param key The key for which to search.
     * @return <code>true</code> if found; otherwise <code>false</code>.
     */
    public boolean contains(Object key);

    /**
     * Deletes all entries from the map. The size of the map will be reset to zero (0).
     */
    public void clear();

    /**
     * Obtains the size of the map.
     *
     * @return The number of values in the map.
     */
    public int size();

    /**
     * Determines if the map is empty or not.
     *
     * @return <code>true</code> if the map is empty (<code>size() == 0</code>); otherwise returns <code>false</code>.
     */
    public boolean isEmpty();

    /**
     * A key/value pair.
     */
    public static interface Entry {
        /**
         * Obtains the key.
         *
         * @return The key.
         */
        public Object getKey();

        /**
         * Obtains the value.
         *
         * @return The value.
         */
        public Object getValue();
    }
}
