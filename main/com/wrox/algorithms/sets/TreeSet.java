package com.wrox.algorithms.sets;

import com.wrox.algorithms.iteration.Iterator;
import com.wrox.algorithms.iteration.IteratorOutOfBoundsException;
import com.wrox.algorithms.sorting.Comparator;
import com.wrox.algorithms.sorting.NaturalComparator;

/**
 * A {@link Set} that uses a binary search tree.
 *
 */
public class TreeSet implements Set {
    /** The strategy to use for value comparison. */
    private final Comparator _comparator;

    /** The root node; or <code>null</code> if the tree is empty. */
    private Node _root;

    /** The number of values in the set. */
    private int _size;

    /**
     * Default constructor. Assumes values implement {@link Comparable}.
     */
    public TreeSet() {
        this(NaturalComparator.INSTANCE);
    }

    /**
     * Constructor.
     *
     * @param comparator The strategy to use for value comparison.
     */
    public TreeSet(Comparator comparator) {
        assert comparator != null : "comparator can't be null";
        _comparator = comparator;
    }

    public boolean contains(Object value) {
        return search(value) != null;
    }

    public boolean add(Object value) {
        Node parent = null;
        Node node = _root;
        int cmp = 0;

        while (node != null) {
            parent = node;
            cmp = _comparator.compare(value, node.getValue());
            if (cmp == 0) {
                return false;
            }

            node = cmp < 0 ? node.getSmaller() : node.getLarger();
        }

        Node inserted = new Node(parent, value);

        if (parent == null) {
            _root = inserted;
        } else if (cmp < 0) {
            parent.setSmaller(inserted);
        } else {
            parent.setLarger(inserted);
        }

        ++_size;
        return true;
    }

    public boolean delete(Object value) {
        Node node = search(value);
        if (node == null) {
            return false;
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

        --_size;
        return true;
    }

    public Iterator iterator() {
        return new ValueIterator();
    }

    public void clear() {
        _root = null;
        _size = 0;
    }

    public int size() {
        return _size;
    }

    public boolean isEmpty() {
        return _root == null;
    }

    /**
     * Searches for a value in the tree.
     *
     * @param value The value for which to search.
     * @return The node; or <code>null</code> if not found.
     */
    private Node search(Object value) {
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
     * A node in the tree.
     */
    private static final class Node {
        /** The value. */
        private Object _value;

        /** The parent; or <code>null</code>. */
        private Node _parent;

        /** The smaller child; or <code>null</code>. */
        private Node _smaller;

        /** The larger child; or <code>null</code>. */
        private Node _larger;

        /**
         * Constructor. Sets the smaller and larger nodes to <code>null</code>.
         *
         * @param parent The parent.
         * @param value The contained value.
         */
        public Node(Node parent, Object value) {
            setParent(parent);
            setValue(value);
        }

        /**
         * Obtains the value.
         *
         * @return The value.
         */
        public Object getValue() {
            return _value;
        }

        /**
         * Sets the value.
         *
         * @param value The value.
         */
        public void setValue(Object value) {
            assert value != null : "value can't be null";
            _value = value;
        }

        /**
         * Obtains the parent.
         *
         * @return the parent; or <code>null</code>.
         */
        public Node getParent() {
            return _parent;
        }

        /**
         * Sets the parent.
         *
         * @param parent The parent; or <code>null</code>.
         */
        public void setParent(Node parent) {
            _parent = parent;
        }

        /**
         * Obtains the smaller child.
         *
         * @return The smaller child; or <code>null</code>.
         */
        public Node getSmaller() {
            return _smaller;
        }

        /**
         * Sets the smaller child. Updates the new smaller child to reflect that this is now its parent. Also updates
         * any exisiting smaller child to reflect that this is no longer its parent.
         *
         * @param node The new smaller child.
         */
        public void setSmaller(Node node) {
            assert node != getLarger() : "smaller can't be the same as larger";
            _smaller = node;
        }

        /**
         * Obtains the larger child.
         *
         * @return the larger child; or <code>null</code>.
         */
        public Node getLarger() {
            return _larger;
        }


        /**
         * Sets the larger node. Updates the new larger node to reflect that this is now its parent. Also updates any
         * exisiting larger node to reflect that this is no longer its parent.
         *
         * @param node The new larger child.
         */
        public void setLarger(Node node) {
            assert node != getSmaller() : "larger can't be the same as smaller";
            _larger = node;
        }

        /**
         * Determines if this is the smaller child of its parent.
         *
         * @return <code>true</code> if this is the smaller child of it's parent; otherwise <code>false</code>.
         */
        public boolean isSmaller() {
            return getParent() != null && this == getParent().getSmaller();
        }

        /**
         * Determines if this is the larger child of its parent.
         *
         * @return <code>true</code> if this is the larger child of it's parent; otherwise <code>false</code>.
         */
        public boolean isLarger() {
            return getParent() != null && this == getParent().getLarger();
        }

        /**
         * Obtains the node with the smallest value starting from this.
         *
         * @return The minimum.
         */
        public Node minimum() {
            Node node = this;

            while (node.getSmaller() != null) {
                node = node.getSmaller();
            }

            return node;
        }

        /**
         * Obtains the node with the largest value starting from this.
         *
         * @return The maximum.
         */
        public Node maximum() {
            Node node = this;

            while (node.getLarger() != null) {
                node = node.getLarger();
            }

            return node;
        }

        /**
         * Obtains the node with the next largest value starting from this.
         *
         * @return The successor; or <code>null</code>.
         */
        public Node successor() {
            if (getLarger() != null) {
                return getLarger().minimum();
            }

            Node node = this;

            while (node.isLarger()) {
                node = node.getParent();
            }

            return node.getParent();
        }

        /**
         * Obtains the node with the next smallest value starting from this.
         *
         * @return The predecessor; or <code>null</code>.
         */
        public Node predecessor() {
            if (getSmaller() != null) {
                return getSmaller().maximum();
            }

            Node node = this;

            while (node.isSmaller()) {
                node = node.getParent();
            }

            return node.getParent();
        }
    }

    /**
     * An {@link Iterator} over the values in the set.
     */
    private final class ValueIterator implements Iterator {
        /** The current node; or <code>null</code>. */
        private Node _current;

        public void first() {
            _current = _root != null ? _root.minimum() : null;
        }

        public void last() {
            _current = _root != null ? _root.maximum() : null;
        }

        public boolean isDone() {
            return _current == null;
        }

        public void next() {
            if (!isDone()) {
                _current = _current.successor();
            }
        }

        public void previous() {
            if (!isDone()) {
                _current = _current.predecessor();
            }
        }

        public Object current() throws IteratorOutOfBoundsException {
            if (isDone()) {
                throw new IteratorOutOfBoundsException();
            }
            return _current.getValue();
        }

    }
}
