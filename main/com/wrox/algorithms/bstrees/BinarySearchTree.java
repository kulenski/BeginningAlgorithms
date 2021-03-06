package com.wrox.algorithms.bstrees;

import com.wrox.algorithms.sorting.Comparator;

/**
 * A binary search tree that performs no balancing.
 *
 */
public class BinarySearchTree {
    /** The strategy to use for value comparison. */
    private final Comparator _comparator;

    /** The root node; or <code>null</code> if the tree is empty. */
    private Node _root;

    /**
     * Constructor.
     *
     * @param comparator The strategy to use for value comparison.
     */
    public BinarySearchTree(Comparator comparator) {
        assert comparator != null : "comparator can't be null";
        _comparator = comparator;
    }

    /**
     * Searches for a value in the tree.
     *
     * @param value The value for which to search.
     * @return The node; or <code>null</code> if not found.
     */
    public Node search(Object value) {
        assert value != null : "value can't be null";

        Node node = _root;

        while (node != null) {
            int cmp = _comparator.compare(value, node.getValue());
            if (cmp == 0) {
               break;
            }

            node = cmp < 0 ? node.getSmaller() : node.getLarger();
        }

        return node;
    }

    /**
     * Insert a value in the tree.
     *
     * @param value The value to insert.
     * @return The inserted node.
     */
    public Node insert(Object value) {
        Node parent = null;
        Node node = _root;
        int cmp = 0;

        while (node != null) {
            parent = node;
            cmp = _comparator.compare(value, node.getValue());
            node = cmp <= 0 ? node.getSmaller() : node.getLarger();
        }

        Node inserted = new Node(value);
        inserted.setParent(parent);

        if (parent == null) {
            _root = inserted;
        } else if (cmp < 0) {
            parent.setSmaller(inserted);
        } else {
            parent.setLarger(inserted);
        }

        return inserted;
    }

    /**
     * Deletes a value from the tree.
     *
     * @param value The value to delete.
     * @return The deleted node; or <code>null</code> if not found.
     */
    public Node delete(Object value) {
        Node node = search(value);
        if (node == null) {
            return null;
        }

        Node deleted = node.getSmaller() != null && node.getLarger() != null ? node.successor() : node;
        assert deleted != null : "deleted can't be null";

        Node replacement = deleted.getSmaller() != null ? deleted.getSmaller() : deleted.getLarger();
        if (replacement != null) {
            replacement.setParent(deleted.getParent());
        }

        if (deleted == _root) {
            _root = replacement;
        } else if (deleted.isSmaller()) {
            deleted.getParent().setSmaller(replacement);
        } else {
            deleted.getParent().setLarger(replacement);
        }

        if (deleted != node) {
            Object deletedValue = node.getValue();
            node.setValue(deleted.getValue());
            deleted.setValue(deletedValue);
        }

        return deleted;
    }

    /**
     * Obtains the root node.
     *
     * @return The root node; or <code>null</code> if the tree is empty.
     */
    public Node getRoot() {
        return _root;
    }
}
