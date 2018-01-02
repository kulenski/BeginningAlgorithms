package com.wrox.algorithms.ssearch;

/**
 * A generic interface for string searching.
 *
 */
public interface StringSearcher {
    /**
     * Searches for a match.
     *
     * @param text The text within which to search.
     * @param from The position (0, 1, 2...) from which to start.
     * @return A match; or <code>null</code> if none found.
     */
    public StringMatch search(CharSequence text, int from);
}
