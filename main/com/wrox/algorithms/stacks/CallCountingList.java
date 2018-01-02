package com.wrox.algorithms.stacks;

import com.wrox.algorithms.iteration.Iterator;
import com.wrox.algorithms.lists.List;

/**
 * A {@link List} that counts calls made to it.
 *
 * TODO: Move to sorting package.
 * TODO: Delete changed to return boolean!
 * TODO: Order of add changed changed!
 */
public class CallCountingList implements List {
    /** The underlying list. */
    private final List _list;

    private int _insertCount;
    private int _addCount;
    private int _deleteCount;
    private int _getCount;
    private int _setCount;

    /**
     * Constructor.
     *
     * @param list The underlying list.
     */
    public CallCountingList(List list) {
        assert list != null : "list can't be null";
        _list = list;
    }

    public void insert(int index, Object value) throws IndexOutOfBoundsException {
        ++_insertCount;
        _list.insert(index, value);
    }

    public void add(Object value) {
        ++_addCount;
        _list.add(value);
    }

    public Object delete(int index) throws IndexOutOfBoundsException {
        ++_deleteCount;
        return _list.delete(index);
    }

    public boolean delete(Object value) {
        ++_deleteCount;
        return _list.delete(value);
    }

    public Object get(int index) throws IndexOutOfBoundsException {
        ++_getCount;
        return _list.get(index);
    }

    public Object set(int index, Object value) throws IndexOutOfBoundsException {
        ++_setCount;
        return _list.set(index, value);
    }


    public void clear() {
        _list.clear();
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

    public Iterator iterator() {
        return _list.iterator();
    }

    public int size() {
        return _list.size();
    }

    public String toString() {
        return new StringBuffer("Call-counting List: ")
                .append("add: " + _addCount)
                .append(" insert: " + _insertCount)
                .append(" delete: " + _deleteCount)
                .append(" set: " + _setCount)
                .append(" get: " + _getCount).toString();
    }
}
