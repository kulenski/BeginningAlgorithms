/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.kulenski.test.iteration;

import junit.framework.TestCase;

/**
 *
 * @author kulenski
 */
public class PowerCalculatorTest extends TestCase {
    
    public void testAnythingToThePowerOfZeroIsOne() {
        PowerCalculator calc = PowerCalculator.INSTANCE;
        
        assertEquals(1,calc.calculate(1, 0));
        assertEquals(1,calc.calculate(3, 0));
        assertEquals(1,calc.calculate(5, 0));
        assertEquals(1,calc.calculate(7, 0));
    }
    
    
    public void testPowerOfOneIsSelf() {
        PowerCalculator calc = PowerCalculator.INSTANCE;
        
        assertEquals(3,calc.calculate(3, 1));
        assertEquals(5,calc.calculate(5, 1));
        assertEquals(9,calc.calculate(9, 1));
        assertEquals(27,calc.calculate(27, 1));
    }
    
    public void testArbitrary() {
        
        PowerCalculator calc = PowerCalculator.INSTANCE;
        
        assertEquals(4,calc.calculate(2, 2));
        assertEquals(9,calc.calculate(3, 2));
        assertEquals(25,calc.calculate(5, 2));
        assertEquals(64,calc.calculate(4, 3));
        assertEquals(27,calc.calculate(3, 3));
        assertEquals(10000,calc.calculate(10, 4));
    }
}
