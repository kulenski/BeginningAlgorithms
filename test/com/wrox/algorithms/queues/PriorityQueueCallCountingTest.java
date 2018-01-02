package com.wrox.algorithms.queues;

import com.wrox.algorithms.iteration.Iterator;
import com.wrox.algorithms.lists.ArrayList;
import com.wrox.algorithms.lists.List;
import com.wrox.algorithms.sorting.CallCountingComparator;
import com.wrox.algorithms.sorting.NaturalComparator;
import junit.framework.TestCase;

/**
 * A test case to drive the various priority queue implementations
 * in order to compare their efficiency.
 *
 */
public class PriorityQueueCallCountingTest extends TestCase {
    private static final int TEST_SIZE = 1000;

    private final List _sortedList = new ArrayList(TEST_SIZE);
    private final List _reverseList = new ArrayList(TEST_SIZE);
    private final List _randomList = new ArrayList(TEST_SIZE);

    private CallCountingComparator _comparator;

    protected void setUp() throws Exception {
        super.setUp();
        _comparator = new CallCountingComparator(NaturalComparator.INSTANCE);

        for (int i = 1; i < TEST_SIZE; ++i) {
            _sortedList.add(new Integer(i));
        }

        for (int i = TEST_SIZE; i > 0; --i) {
            _reverseList.add(new Integer(i));
        }

        for (int i = 1; i < TEST_SIZE; ++i) {
            _randomList.add(new Integer((int)(TEST_SIZE * Math.random())));
        }
    }

    public void testWorstCaseUnsortedList() {
        runScenario(new UnsortedListPriorityQueue(_comparator), _reverseList);
    }

    public void testWorstCaseSortedList() {
        runScenario(new SortedListPriorityQueue(_comparator), _reverseList);
    }

    public void testWorstCaseHeapOrderedList() {
        runScenario(new HeapOrderedListPriorityQueue(_comparator), _reverseList);
    }

    public void testBestCaseUnsortedList() {
        runScenario(new UnsortedListPriorityQueue(_comparator), _sortedList);
    }

    public void testBestCaseSortedList() {
        runScenario(new SortedListPriorityQueue(_comparator), _sortedList);
    }

    public void testBestCaseHeapOrderedList() {
        runScenario(new HeapOrderedListPriorityQueue(_comparator), _sortedList);
    }

    public void testAverageCaseUnsortedList() {
        runScenario(new UnsortedListPriorityQueue(_comparator), _randomList);
    }

    public void testAverageCaseSortedList() {
        runScenario(new SortedListPriorityQueue(_comparator), _randomList);
    }

    public void testAverageCaseHeapOrderedList() {
        runScenario(new HeapOrderedListPriorityQueue(_comparator), _randomList);
    }

    private void runScenario(Queue queue, List input) {
        int i = 0;
        Iterator iterator = input.iterator();
        iterator.first();
        while (!iterator.isDone()) {
            ++i;
            queue.enqueue(iterator.current());
            if (i % 100 == 0) {
                for (int j = 0; j < 25; ++ j) {
                    queue.dequeue();
                }
            }
            iterator.next();
        }

        while (!queue.isEmpty()) {
            queue.dequeue();
        }
        reportCalls();
    }

    private void reportCalls() {
        int callCount = _comparator.getCallCount();
        System.out.println(getName() + ": " + callCount + " calls");
    }
}
