package com.wrox.algorithms.sorting;

import com.wrox.algorithms.iteration.Iterator;
import com.wrox.algorithms.lists.ArrayList;
import com.wrox.algorithms.lists.List;
import com.wrox.algorithms.queues.HeapOrderedListPriorityQueue;
import com.wrox.algorithms.queues.Queue;

/**
 * Sample solution for exercise 8-3.
 * A {@link com.wrox.algorithms.sorting.ListSorter} that uses a priority queue internally.
 *
 */
public class PriorityQueueListSorter implements ListSorter {
    private final Comparator _comparator;

    /**
     * @param comparator the comparator to control the order of the sorted objects.
     */
    public PriorityQueueListSorter(Comparator comparator) {
        assert comparator != null : "comparator cannot be null";
        _comparator = comparator;
    }

    /**
     * Sorts a list using a priority queue.
     *
     * @param list The list to sort.
     * @return a new list containing the items in sorted order.
     */
    public List sort(List list) {
        assert list != null : "list cannot be null";

        Queue queue = createPriorityQueue(list);

        List result = new ArrayList(list.size());

        while (!queue.isEmpty()) {
            result.add(queue.dequeue());
        }

        return result;
    }

    private Queue createPriorityQueue(List list) {
        Comparator comparator = new ReverseComparator(_comparator);
        Queue queue = new HeapOrderedListPriorityQueue(comparator);

        Iterator i = list.iterator();
        i.first();
        while (!i.isDone()) {
            queue.enqueue(i.current());
            i.next();
        }

        return queue;
    }
}
