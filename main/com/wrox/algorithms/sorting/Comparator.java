package com.wrox.algorithms.sorting;

/**
 * A generice interface for comparing two object for order.
 *
 */
public interface Comparator {
    /**
     * Compares two objects for order.
     *
     * @param left The object on the 'left' of the comparison.
     * @param right The object on the 'right' of the comparison.
     * @return &lt;0, 0, &gt;0 if left&lt;right, left == right or left&gt;right respectively.
     * @throws ClassCastException if the type of either object prevents them from being compared.
     */
    public int compare(Object left, Object right) throws ClassCastException;
}
