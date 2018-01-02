package com.wrox.algorithms.sorting;

import com.wrox.algorithms.lists.List;
import com.wrox.algorithms.lists.ArrayList;

/**
 */
public class InPlaceInsertionSortListSorterTest extends AbstractListSorterTestCase {
    protected ListSorter createListSorter(Comparator comparator) {
        return new InPlaceInsertionSortListSorter(comparator);
    }

    public void testAlgorithmIsInPlace() {
        List data = new ArrayList(3);
        data.add("foo");
        data.add("bar");
        data.add("baz");

        ListSorter sorter = new InPlaceInsertionSortListSorter(NaturalComparator.INSTANCE);
        List result = sorter.sort(data);
        assertSame(data, result);
    }
}
