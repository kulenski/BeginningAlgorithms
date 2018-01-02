package com.wrox.algorithms.stacks;

import com.wrox.algorithms.lists.AbstractListTestCase;
import com.wrox.algorithms.lists.ArrayList;
import com.wrox.algorithms.lists.List;

/**
 * Tests for {@link UndoableList}.
 *
 */
public class UndoableListTest extends AbstractListTestCase {
    protected List createList() {
        return new UndoableList(new ArrayList());
    }

    public void testUndoInsert() {
        UndoableList list = new UndoableList(new ArrayList());

        assertFalse(list.canUndo());

        list.insert(0, VALUE_A);
        assertTrue(list.canUndo());

        list.undo();
        assertEquals(0, list.size());
        assertFalse(list.canUndo());
    }

    public void testUndoAdd() {
        UndoableList list = new UndoableList(new ArrayList());

        assertFalse(list.canUndo());

        list.add(VALUE_A);
        assertTrue(list.canUndo());

        list.undo();
        assertEquals(0, list.size());
        assertFalse(list.canUndo());
    }

    public void testUndoDeleteByPosition() {
        UndoableList list = new UndoableList(new ArrayList(new Object[]{VALUE_A, VALUE_B}));

        assertFalse(list.canUndo());

        assertSame(VALUE_B, list.delete(1));
        assertTrue(list.canUndo());

        list.undo();
        assertEquals(2, list.size());
        assertSame(VALUE_A, list.get(0));
        assertSame(VALUE_B, list.get(1));
        assertFalse(list.canUndo());
    }

    public void testUndoDeleteByValue() {
        UndoableList list = new UndoableList(new ArrayList(new Object[] {VALUE_A, VALUE_B}));

        assertFalse(list.canUndo());

        assertTrue(list.delete(VALUE_B));
        assertTrue(list.canUndo());

        list.undo();
        assertEquals(2, list.size());
        assertSame(VALUE_A, list.get(0));
        assertSame(VALUE_B, list.get(1));
        assertFalse(list.canUndo());
    }

    public void testUndoSet() {
        UndoableList list = new UndoableList(new ArrayList(new Object[] {VALUE_A}));

        assertFalse(list.canUndo());

        assertSame(VALUE_A, list.set(0, VALUE_B));
        assertTrue(list.canUndo());

        list.undo();
        assertEquals(1, list.size());
        assertSame(VALUE_A, list.get(0));
        assertFalse(list.canUndo());
    }

    public void testUndoMultiple() {
        UndoableList list = new UndoableList(new ArrayList());

        assertFalse(list.canUndo());

        list.add(VALUE_A);
        list.add(VALUE_B);

        list.undo();
        assertEquals(1, list.size());
        assertSame(VALUE_A, list.get(0));
        assertTrue(list.canUndo());

        list.delete(0);

        list.undo();
        assertEquals(1, list.size());
        assertSame(VALUE_A, list.get(0));
        assertTrue(list.canUndo());

        list.undo();
        assertEquals(0, list.size());
        assertFalse(list.canUndo());
    }

    public void testCantUndoEmptyList() {
        UndoableList list = new UndoableList(new ArrayList());

        assertFalse(list.canUndo());

        try {
            list.undo();
            fail();
        } catch (EmptyStackException e) {
            // expected
        }
    }

    public void testClearResetsUndoStack() {
        UndoableList list = new UndoableList(new ArrayList());

        assertFalse(list.canUndo());

        list.add(VALUE_A);
        assertTrue(list.canUndo());

        list.clear();
        assertFalse(list.canUndo());
    }
}
