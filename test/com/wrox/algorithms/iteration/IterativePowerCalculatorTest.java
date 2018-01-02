package com.wrox.algorithms.iteration;

/**
 * Test cases for {@link IterativePowerCalculator}.
 * 
 */
public class IterativePowerCalculatorTest extends AbstractPowerCalculatorTestCase {
    protected PowerCalculator createCalculator() {
        return IterativePowerCalculator.INSTANCE;
    }
}
