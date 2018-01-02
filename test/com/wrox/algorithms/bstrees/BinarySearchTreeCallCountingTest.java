package com.wrox.algorithms.bstrees;

import com.wrox.algorithms.lists.ArrayList;
import com.wrox.algorithms.lists.List;
import com.wrox.algorithms.sorting.CallCountingComparator;
import com.wrox.algorithms.sorting.NaturalComparator;
import junit.framework.TestCase;

/**
 */
public class BinarySearchTreeCallCountingTest extends TestCase {
    private static final int TEST_SIZE = 1000;

    private CallCountingComparator _comparator;
    private BinarySearchTree _tree;

    protected void setUp() throws Exception {
        super.setUp();

        _comparator = new CallCountingComparator(NaturalComparator.INSTANCE);
        _tree = new BinarySearchTree(_comparator);
    }

    public void testRandomInsertion() {
        for (int i = 0; i < TEST_SIZE; ++i) {
            _tree.insert(new Integer((int) (Math.random() * TEST_SIZE)));
        }

        reportCalls();
    }

    public void testInOrderInsertion() {
        for (int i = 0; i < TEST_SIZE; ++i) {
            _tree.insert(new Integer(i));
        }

        reportCalls();
    }

    public void testPreOrderInsertion() {
        List list = new ArrayList(TEST_SIZE);

        for (int i = 0; i < TEST_SIZE; ++i) {
            list.add(new Integer(i));
        }

        preOrderInsert(list, 0, list.size() - 1);

        reportCalls();
    }

    private void preOrderInsert(List list, int lowerIndex, int upperIndex) {
        if (lowerIndex > upperIndex) {
            return;
        }

        int index = lowerIndex + (upperIndex - lowerIndex) / 2;

        _tree.insert(list.get(index));
        preOrderInsert(list, lowerIndex, index - 1);
        preOrderInsert(list, index + 1, upperIndex);
    }

    private void reportCalls() {
        System.out.println(getName() + ": " + _comparator.getCallCount() + " calls");
    }
}
