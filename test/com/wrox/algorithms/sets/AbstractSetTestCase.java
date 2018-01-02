package com.wrox.algorithms.sets;

import com.wrox.algorithms.iteration.Iterator;
import com.wrox.algorithms.iteration.IteratorOutOfBoundsException;
import com.wrox.algorithms.iteration.ReverseIterator;
import com.wrox.algorithms.lists.LinkedList;
import com.wrox.algorithms.lists.List;
import junit.framework.TestCase;

/**
 * Abstract base class for testing implementations of {@link Set}.
 *
 */
public abstract class AbstractSetTestCase extends TestCase {
    private static final Object A = "a";
    private static final Object B = "b";
    private static final Object C = "c";
    private static final Object D = "d";
    private static final Object E = "e";
    private static final Object F = "f";

    private Set _set;

    protected void setUp() throws Exception {
        _set = createSet();

        _set.add(C);
        _set.add(A);
        _set.add(B);
        _set.add(D);
    }

    protected abstract Set createSet();

    public void testContainsExisting() {
        assertTrue(_set.contains(A));
        assertTrue(_set.contains(B));
        assertTrue(_set.contains(C));
        assertTrue(_set.contains(D));
    }

    public void testContainsNonExisting() {
        assertFalse(_set.contains(E));
        assertFalse(_set.contains(F));
    }

    public void testAddNewValue() {
        assertEquals(4, _set.size());

        assertTrue(_set.add(E));
        assertTrue(_set.contains(E));
        assertEquals(5, _set.size());

        assertTrue(_set.add(F));
        assertTrue(_set.contains(F));
        assertEquals(6, _set.size());
    }

    public void testAddExistingValueHasNoEffect() {
        assertEquals(4, _set.size());
        assertFalse(_set.add(C));
        assertEquals(4, _set.size());
    }

    public void testDeleteExisting() {
        assertTrue(_set.delete(B));
        assertFalse(_set.contains(B));
        assertEquals(3, _set.size());

        assertTrue(_set.delete(A));
        assertFalse(_set.contains(A));
        assertEquals(2, _set.size());

        assertTrue(_set.delete(C));
        assertFalse(_set.contains(C));
        assertEquals(1, _set.size());

        assertTrue(_set.delete(D));
        assertFalse(_set.contains(D));
        assertEquals(0, _set.size());
    }

    public void testDeleteNonExisting() {
        assertEquals(4, _set.size());
        assertFalse(_set.delete(E));
        assertEquals(4, _set.size());
        assertFalse(_set.delete(F));
        assertEquals(4, _set.size());
    }

    public void testClear() {
        assertEquals(4, _set.size());
        assertFalse(_set.isEmpty());

        _set.clear();

        assertEquals(0, _set.size());
        assertTrue(_set.isEmpty());

        assertFalse(_set.contains(A));
        assertFalse(_set.contains(B));
        assertFalse(_set.contains(C));
        assertFalse(_set.contains(D));
    }

    public void testIteratorForwards() {
        checkIterator(_set.iterator());
    }

    public void testIteratorBackwards() {
        checkIterator(new ReverseIterator(_set.iterator()));
    }

    private void checkIterator(Iterator i) {
        List values = new LinkedList();

        for (i.first(); !i.isDone(); i.next()) {
            values.add(i.current());
        }

        try {
            i.current();
            fail();
        } catch (IteratorOutOfBoundsException e) {
            // expected
        }

        assertEquals(4, values.size());
        assertTrue(values.contains(A));
        assertTrue(values.contains(B));
        assertTrue(values.contains(C));
        assertTrue(values.contains(D));
    }
}
