/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.kulenski.test.lists;
import com.wrox.algorithms.iteration.Iterable;

/**
 *
 * @author kulenski
 */
public interface List extends Iterable {
    
    public void insert(int index, Object value)
            throws IndexOutOfBoundException;
    public void add(int index, Object value);
    public Object delete(int index) throws IndexOutOfBoundException;
    public boolean delete(Object value);
    public void clear();
    public Object set(int index, Object value)
            throws IndexOutOfBoundsException;
    public Object get(int index) throws IndexOutOfBoundException;
    public int indexOf(Object value);
    public boolean contains(Object value);
    public int size();
    public boolean isEmpty();
}
