package com.wrox.algorithms.iteration;

/**
 * Generic interface for specifying filter criteria.
 * 
 */
public interface Predicate {
    /**
     * Determines if the predicate holds for a specified object.
     *
     * @param object The object to evaluate.
     * @return <code>true</code> if the predicate holds; otherwise <code>false</code>.
     */
    public boolean evaluate(Object object);
}
