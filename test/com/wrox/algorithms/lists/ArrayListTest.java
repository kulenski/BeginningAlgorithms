package com.wrox.algorithms.lists;

/**
 * Concrete tests for {@link ArrayList}.
 *
 */
public class ArrayListTest extends AbstractListTestCase {
    protected List createList() {
        return new ArrayList();
    }

    public void testResizeBeyondInitialCapacity() {
        List list = new ArrayList(1);

        list.add(VALUE_A);
        list.add(VALUE_A);
        list.add(VALUE_A);

        assertEquals(3, list.size());

        assertSame(VALUE_A, list.get(0));
        assertSame(VALUE_A, list.get(1));
        assertSame(VALUE_A, list.get(2));
    }

    public void testDeleteFromFirstElementOfListAtFullCapacity() {
        List list = new ArrayList(3);

        list.add(VALUE_A);
        list.add(VALUE_B);
        list.add(VALUE_C);

        list.delete(0);
    }

    public void testDeleteFromLastElementInArray() {
        List list = new ArrayList(1);

        list.add(VALUE_A);

        list.delete(0);
    }
}
