package com.wrox.algorithms.stacks;

import com.wrox.algorithms.iteration.Iterator;
import com.wrox.algorithms.lists.List;

/**
 * A {@link List} that supports undo.
 *
 */
public class UndoableList implements List {
    /** The underlying list. */
    private final List _list;

    /** The stack of undo actions. */
    private final Stack _undoStack = new ListStack();

    /**
     * Constructor.
     *
     * @param list The underlying list.
     */
    public UndoableList(List list) {
        assert list != null : "list can't be null";
        _list = list;
    }

    public void insert(int index, Object value) throws IndexOutOfBoundsException {
        _list.insert(index, value);
        _undoStack.push(new UndoInsertAction(index));
    }

    public void add(Object value) {
        insert(size(), value);
    }

    public Object delete(int index) throws IndexOutOfBoundsException {
        Object value = _list.delete(index);
        _undoStack.push(new UndoDeleteAction(index, value));
        return value;
    }

    public boolean delete(Object value) {
        int index = indexOf(value);
        if (index == -1) {
            return false;
        }

        delete(index);
        return true;
    }

    public void clear() {
        _list.clear();
        _undoStack.clear();
    }

    public Object set(int index, Object value) throws IndexOutOfBoundsException {
        Object originalValue = _list.set(index, value);
        _undoStack.push(new UndoSetAction(index, originalValue));
        return originalValue;
    }

    /**
     * Determines if there are more actions to undo.
     *
     * @return <code>true</code> if there are more actions to undo; otherwise <code>false</code>.
     */
    public boolean canUndo() {
        return !_undoStack.isEmpty();
    }

    public Object get(int index) throws IndexOutOfBoundsException {
        return _list.get(index);
    }

    public Iterator iterator() {
        return _list.iterator();
    }

    public int indexOf(Object value) {
        return _list.indexOf(value);
    }

    public boolean contains(Object value) {
        return _list.contains(value);
    }

    public boolean isEmpty() {
        return _list.isEmpty();
    }

    public int size() {
        return _list.size();
    }

    /**
     * Undoes the next action (if any) on the stack.
     *
     * @throws EmptyStackException If there are no more actions to undo.
     */
    public void undo() throws EmptyStackException {
        ((UndoAction) _undoStack.pop()).execute();
    }

    /**
     * Generic interface for undo actions.
     */
    private static interface UndoAction {
        /**
         * Called to perform the undo.
         */
        public void execute();
    }

    /**
     * Undo the effect of an add.
     */
    private final class UndoInsertAction implements UndoAction {
        private final int _index;

        public UndoInsertAction(int index) {
            _index = index;
        }

        public void execute() {
            _list.delete(_index);
        }
    }

    /**
     * Undo the effect of a delete.
     */
    private final class UndoDeleteAction implements UndoAction {
        private final int _index;
        private final Object _value;

        public UndoDeleteAction(int index, Object value) {
            _index = index;
            _value = value;
        }

        public void execute() {
            _list.insert(_index, _value);
        }
    }

    /**
     * Undo the effect of a set.
     */
    private final class UndoSetAction implements UndoAction {
        private final int _index;
        private final Object _value;

        public UndoSetAction(int index, Object value) {
            _index = index;
            _value = value;
        }

        public void execute() {
            _list.set(_index, _value);
        }
    }
}
