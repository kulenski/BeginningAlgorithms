package com.wrox.algorithms.hashing;

/**
 * Test cases for {@link SimplePrimeNumberGenerator}.
 * 
 */
public class SimplePrimeNumberGeneratorTest extends AbstractPrimeNumberGeneratorTestCase {
    protected PrimeNumberGenerator createGenerator() {
        return SimplePrimeNumberGenerator.INSTANCE;
    }
}
