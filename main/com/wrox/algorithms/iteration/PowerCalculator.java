package com.wrox.algorithms.iteration;

/**
 * Generic interface for calculating the value of one integer raised to the power of another.
 *
 */
public interface PowerCalculator {
    /**
     * Calculates the value of one integer raised to the power of another.
     *
     * @param base The base to be raised.
     * @param exponent The power to which the base will be raised.
     * @return The base raised to the exponent.
     */
    public int calculate(int base, int exponent);
}
