package com.wrox.algorithms.maps;

import com.wrox.algorithms.sets.AbstractSetTestCase;
import com.wrox.algorithms.sets.Set;

/**
 * Test cases for {@link MapSet} using a {@link TreeMap} as underlying storage mechanism.
 *
 */
public class TreeMapSetTest extends AbstractSetTestCase {
    protected Set createSet() {
        return new MapSet(new TreeMap());
    }
}
