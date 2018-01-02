package com.wrox.algorithms.hashing;

/**
 * A generic interface for prime number generators.
 *
 */
public interface PrimeNumberGenerator {
    /**
     * Generates a prime number equal to or greater than a specified starting number.
     *
     * @param candidate The number from which to start.
     * @return A prime number >= candidate.
     */
    public int generate(int candidate);
}
