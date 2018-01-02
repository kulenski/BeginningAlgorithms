package com.wrox.algorithms.bsearch;

import com.wrox.algorithms.lists.List;

/**
 * A generic interface for searching a {@link List}.
 *
 */
public interface ListSearcher {
    /**
     * Searches a list for a specified key.
     *
     * @param list The to search.
     * @param value The value for which to search.
     * @return The position (0, 1, 2...) of the value if found; otherwise <code>-(insertion point + 1)</code>.
     */
    public int search(List list, Object value);
}
