package com.wrox.algorithms.queues;

import com.wrox.algorithms.lists.LinkedList;
import com.wrox.algorithms.lists.List;
import junit.framework.TestCase;

/**
 * Test cases for {@link RandomListQueue}.
 *
 */
public class RandomListQueueTest extends TestCase {
    private static final String VALUE_A = "A";
    private static final String VALUE_B = "B";
    private static final String VALUE_C = "C";

    private Queue _queue;

    protected void setUp() throws Exception {
        super.setUp();

        _queue = new RandomListQueue();
    }

    protected void tearDown() throws Exception {
        super.tearDown();

        _queue = null;
    }

    public void testAccessAnEmptyQueue() {
        assertEquals(0, _queue.size());
        assertTrue(_queue.isEmpty());

        try {
            _queue.dequeue();
            fail();
        } catch (EmptyQueueException e) {
            // expected
        }
    }

    public void testEnqueueDequeue() {
        _queue.enqueue(VALUE_B);
        _queue.enqueue(VALUE_A);
        _queue.enqueue(VALUE_C);

        assertEquals(3, _queue.size());
        assertFalse(_queue.isEmpty());

        List list = new LinkedList();
        while (!_queue.isEmpty()) {
            list.add(_queue.dequeue());
        }

        try {
            _queue.dequeue();
            fail();
        } catch (EmptyQueueException e) {
            // expected
        }

        assertTrue(list.contains(VALUE_A));
        assertTrue(list.contains(VALUE_B));
        assertTrue(list.contains(VALUE_C));
    }

    public void testClear() {
        _queue.enqueue(VALUE_A);
        _queue.enqueue(VALUE_B);
        _queue.enqueue(VALUE_C);

        assertFalse(_queue.isEmpty());

        _queue.clear();

        assertEquals(0, _queue.size());
        assertTrue(_queue.isEmpty());

        try {
            _queue.dequeue();
            fail();
        } catch (EmptyQueueException e) {
            // expected
        }
    }
}
