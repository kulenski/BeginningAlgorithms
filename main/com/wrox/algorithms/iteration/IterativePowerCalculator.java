package com.wrox.algorithms.iteration;

/**
 * A {@link PowerCalculator} that uses iteration.
 *
 */
public final class IterativePowerCalculator implements PowerCalculator {
    /** The single, publicly accessible, instance of the comparator. */
    public static final IterativePowerCalculator INSTANCE = new IterativePowerCalculator();

    /**
     * Constructor marked private to prevent instantiation.
     */
    private IterativePowerCalculator() {
    }

    public int calculate(int base, int exponent) {
        assert exponent >= 0 : "exponent can't be < 0";

        int result = 1;

        for (int i = 0; i < exponent; ++i) {
            result *= base;
        }

        return result;
    }
}
