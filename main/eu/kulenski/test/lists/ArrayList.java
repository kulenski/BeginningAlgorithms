/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.kulenski.test.lists;

import com.wrox.algorithms.iteration.Iterator;

/**
 *
 * @author kulenski
 */
public class ArrayList implements List {
    
    private static final int DEFAULT_INITIAL_CAPACITY = 8;
    private Object[] _list;
    private int _size;
    private int _initialCapacity;
    
    public ArrayList() {
        this(DEFAULT_INITIAL_CAPACITY);
    }
    
    public ArrayList(int initialCapacity) {
        assert initialCapacity > 0 : "Capacity must be greater than 0!";
        
        _initialCapacity = initialCapacity;
        _list = new Object[initialCapacity];
    }

    @Override
    public void insert(int index, Object value) throws IndexOutOfBoundException {
        assert value != null : "Value cannot be null!";
        
        if (index < 0 || index > _size) {
            throw new IndexOutOfBoundException();
        }
        
        ensureCapacity(_size + 1);
        
        System.arraycopy(_list, index, _list, index + 1, _size - index);
        _list[index] = value;
        ++_size;
    }

    @Override
    public void add(int index, Object value) {
        insert(_size, value);
    }

    @Override
    public Object delete(int index) throws IndexOutOfBoundException {
       checkOutOfBounds(index);
       
       Object value = _list[index];
       int copyFromIndex = index + 1;
       if(copyFromIndex < _size) {
           System.arraycopy(_list, copyFromIndex, _list, 
                   index, _size - copyFromIndex);
       }
       _list[--_size] = null;
       
       reduceCapacityIfNecessary();
       
       return value;
    }

    @Override
    public boolean delete(Object value) {
        int index = indexOf(value);
        if(index > -1) {
            delete(index);
            return true;
        }
        
        return false;
    }

    @Override
    public void clear() {
        _list = new Object[_initialCapacity];
        _size = 0;
    }

    @Override
    public Object set(int index, Object value) throws IndexOutOfBoundsException {
        assert value != null : "value cannot be null!";
        
        checkOutOfBounds(index);
        
        Object oldValue = _list[index];
        _list[index] = value;
        return oldValue;
    }

    @Override
    public Object get(int index) throws IndexOutOfBoundException {
        checkOutOfBounds(index);
        return _list[index];
    }

    @Override
    public int indexOf(Object value) {
        assert value != null : "value cannot be null!";
        
        for(int i = 0; i<_size; ++i) {
            if(value.equals(_list[i])) {
                return i;
            }
        }
        
        return -1;
    }

    @Override
    public boolean contains(Object value) {
        return indexOf(value) >= 0;
    }

    @Override
    public int size() {
        return _size;
    }

    @Override
    public boolean isEmpty() {
        return _size == 0 ;
    }

    @Override
    public Iterator iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void ensureCapacity(int capacity) {
        assert capacity > 0 : "capacity must be greater than 0!";
        
        if(_list.length < capacity) {
            Object[] copy = new Object[capacity + capacity/2];
            System.arraycopy(_list, 0, copy, 0, _size);
            _list = copy;
        } 
    }
    
    private void reduceCapacityIfNecessary() {
        if(_size < _list.length/2) {
            Object[] copy = new Object[_size + _size/2];
            System.arraycopy(_list, 0, copy, 0, _size);
            _list = copy;
        }
    }
    
    private void checkOutOfBounds(int index) {
        if (isOutOfBounds(index)) {
            throw new IndexOutOfBoundsException();
        }
    }
    
    private boolean isOutOfBounds(int index) {
        return index < 0 || index >= _size;
    }
    
}
