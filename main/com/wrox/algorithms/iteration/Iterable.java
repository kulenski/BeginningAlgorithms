package com.wrox.algorithms.iteration;

/**
 * Generic interface for classes that provide an iterator.
 *
 */
public interface Iterable {
    /**
     * Obtains an iterator over all values.
     *
     * @return An iterator.
     */
    public Iterator iterator();
}
