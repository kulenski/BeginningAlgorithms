package com.wrox.algorithms.bsearch;

import com.wrox.algorithms.lists.List;

/**
 * Uses a {@link ListSearcher} to insertion values into a {@link List} in sorted order.
 *
 */
public class ListInserter {
    /** The list searcher to use. */
    private final ListSearcher _searcher;

    /**
     * Constructor.
     *
     * @param searcher
     */
    public ListInserter(ListSearcher searcher) {
        assert searcher != null : "searcher can't be null";
        _searcher = searcher;
    }

    /**
     * Inserts a value into a list in sorted order.
     *
     * @param list The list into which the value will be inserted.
     * @param value The value to add.
     * @return Th eposition (0, 1, 2...) at which the value ws inserted.
     */
    public int insert(List list, Object value) {
        assert list != null : "list can't be null";

        int index = _searcher.search(list, value);

        if (index < 0) {
            index = -(index + 1);
        }

        list.insert(index, value);

        return index;
    }
}
