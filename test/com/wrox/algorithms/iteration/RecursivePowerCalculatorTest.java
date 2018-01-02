package com.wrox.algorithms.iteration;

/**
 * Test cases for {@link RecursivePowerCalculator}.
 * 
 */
public class RecursivePowerCalculatorTest extends AbstractPowerCalculatorTestCase {
    protected PowerCalculator createCalculator() {
        return RecursivePowerCalculator.INSTANCE;
    }
}
