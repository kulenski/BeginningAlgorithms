package com.wrox.algorithms.bsearch;

import com.wrox.algorithms.iteration.Iterator;
import com.wrox.algorithms.lists.ArrayList;
import com.wrox.algorithms.lists.List;
import com.wrox.algorithms.sorting.NaturalComparator;
import junit.framework.TestCase;

/**
 * Test cases for {@link ListInserter}.
 *
 */
public class ListInserterTest extends TestCase {
    private static final int TEST_SIZE = 1023;

    private ListInserter _inserter;
    private List _list;

    protected void setUp() throws Exception {
        super.setUp();

        _inserter = new ListInserter(new IterativeBinaryListSearcher(NaturalComparator.INSTANCE));
        _list = new ArrayList(TEST_SIZE);
    }

    public void testAscendingInOrderInsertion() {
        for (int i = 0; i < TEST_SIZE; ++i) {
            assertEquals(i, _inserter.insert(_list, new Integer(i)));
        }

        verify();
    }

    public void testDescendingInOrderInsertion() {
        for (int i = TEST_SIZE - 1; i >= 0; --i) {
            assertEquals(0, _inserter.insert(_list, new Integer(i)));
        }

        verify();
    }

    public void testRandomInsertion() {
        for (int i = 0; i < TEST_SIZE; ++i) {
            _inserter.insert(_list, new Integer((int) (TEST_SIZE * Math.random())));
        }

        verify();
    }

    private void verify() {
        int previousValue = Integer.MIN_VALUE;
        Iterator i = _list.iterator();

        for (i.first(); !i.isDone(); i.next()) {
            int currentValue = ((Integer) i.current()).intValue();
            assertTrue(currentValue >= previousValue);
            previousValue = currentValue;
        }
    }
}
