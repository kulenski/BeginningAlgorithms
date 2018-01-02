package com.wrox.algorithms.iteration;

import junit.framework.TestCase;

/**
 * Abstract base class for testing implementations of {@link PowerCalculator}.
 *
 */
public abstract class AbstractPowerCalculatorTestCase extends TestCase {
    protected abstract PowerCalculator createCalculator();

    public void testAnythingRaisedToThePowerOfZeroIsOne() {
        PowerCalculator calculator = createCalculator();

        assertEquals(1, calculator.calculate(0, 0));
        assertEquals(1, calculator.calculate(1, 0));
        assertEquals(1, calculator.calculate(27, 0));
        assertEquals(1, calculator.calculate(143, 0));
    }

    public void testAnythingRaisedToThePowerOfOneIsItself() {
        PowerCalculator calculator = createCalculator();

        assertEquals(0, calculator.calculate(0, 1));
        assertEquals(1, calculator.calculate(1, 1));
        assertEquals(27, calculator.calculate(27, 1));
        assertEquals(143, calculator.calculate(143, 1));
    }

    public void testSquare() {
        PowerCalculator calculator = createCalculator();

        assertEquals(0, calculator.calculate(0, 2));
        assertEquals(1, calculator.calculate(1, 2));
        assertEquals(4, calculator.calculate(2, 2));
        assertEquals(9, calculator.calculate(3, 2));
        assertEquals(16, calculator.calculate(4, 2));
    }

    public void testCube() {
        PowerCalculator calculator = createCalculator();

        assertEquals(0, calculator.calculate(0, 3));
        assertEquals(1, calculator.calculate(1, 3));
        assertEquals(8, calculator.calculate(2, 3));
        assertEquals(27, calculator.calculate(3, 3));
    }
}
