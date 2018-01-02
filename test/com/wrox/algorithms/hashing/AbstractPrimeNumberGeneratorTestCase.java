package com.wrox.algorithms.hashing;

import junit.framework.TestCase;

/**
 * Abstract base class for tesing implementations of {@link PrimeNumberGenerator}.
 *
 */
public abstract class AbstractPrimeNumberGeneratorTestCase extends TestCase {
    private PrimeNumberGenerator _generator;

    protected void setUp() throws Exception {
        super.setUp();

        _generator = createGenerator();
    }

    protected abstract PrimeNumberGenerator createGenerator();

    public void test() {
        assertEquals(2, _generator.generate(2));
        assertEquals(3, _generator.generate(3));
        assertEquals(5, _generator.generate(4));
        assertEquals(5, _generator.generate(5));
        assertEquals(7, _generator.generate(6));
        assertEquals(7, _generator.generate(7));
        assertEquals(11, _generator.generate(8));
        assertEquals(11, _generator.generate(9));
        assertEquals(11, _generator.generate(10));
        assertEquals(11, _generator.generate(11));
        assertEquals(101, _generator.generate(100));
        assertEquals(101, _generator.generate(101));
        assertEquals(4099, _generator.generate(4096));
        assertEquals(4099, _generator.generate(4097));
        assertEquals(4099, _generator.generate(4098));
        assertEquals(4099, _generator.generate(4099));
        assertEquals(65537, _generator.generate(65535));
        assertEquals(65537, _generator.generate(65536));
        assertEquals(65537, _generator.generate(65537));
    }
}
