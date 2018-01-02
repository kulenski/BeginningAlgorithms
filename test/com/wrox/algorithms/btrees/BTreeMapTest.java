package com.wrox.algorithms.btrees;

import com.wrox.algorithms.maps.AbstractMapTestCase;
import com.wrox.algorithms.maps.Map;
import com.wrox.algorithms.sorting.NaturalComparator;

/**
 * Test cases for {@link BTreeMap}.
 *
 */
public class BTreeMapTest extends AbstractMapTestCase {
    protected Map createMap() {
        return new BTreeMap(NaturalComparator.INSTANCE, 2);
    }
}
