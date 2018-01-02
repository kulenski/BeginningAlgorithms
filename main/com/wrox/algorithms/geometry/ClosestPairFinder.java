package com.wrox.algorithms.geometry;

import com.wrox.algorithms.sets.Set;

/**
 * Generic interface for closest pair of points algorithms.
 *
 */
public interface ClosestPairFinder {
    /**
     * Find the closest pair of {@link Point}s.
     *
     * @param points The set of points to consider.
     * @return The the closest pair of {@link Point}s.
     */
    public Set findClosestPair(Set points);
}
