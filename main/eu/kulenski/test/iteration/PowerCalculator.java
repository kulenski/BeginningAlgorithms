/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.kulenski.test.iteration;

/**
 *
 * @author kulenski
 */
public final class PowerCalculator {
    public static final PowerCalculator INSTANCE = new PowerCalculator();
    
    private PowerCalculator() {
        
    }
    
    public int calculate (int base, int exponent) {
        
        assert exponent >=0 : "expontent can't be < 0!";
        
        int result = 1;
        
        for (int i = 0; i < exponent; ++i ) {
            result *= base;
        }
        
        return result;
    }
}
