package com.wrox.algorithms.iteration;

/**
 * A {@link PowerCalculator} that uses recursion.
 *
 */
public final class RecursivePowerCalculator implements PowerCalculator {
    /** The single, publicly accessible, instance of the comparator. */
    public static final RecursivePowerCalculator INSTANCE = new RecursivePowerCalculator();

    /**
     * Constructor marked private to prevent instantiation.
     */
    private RecursivePowerCalculator() {
    }

    public int calculate(int base, int exponent) {
        assert exponent >= 0 : "exponent can't be < 0";

        return exponent > 0 ? base * calculate(base, exponent - 1) : 1;
    }
}
