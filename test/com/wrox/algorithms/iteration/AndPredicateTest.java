package com.wrox.algorithms.iteration;

import junit.framework.TestCase;

/**
 * Test cases for {@link AndPredicate}.
 *
 */
public class AndPredicateTest extends TestCase {
    public void testTrueAndTrueIsTrue() {
        Predicate predicate = new AndPredicate(FixedPredicate.TRUE, FixedPredicate.TRUE);

        assertTrue(predicate.evaluate(this));
    }

    public void testTrueAndFalseIsFalse() {
        Predicate predicate = new AndPredicate(FixedPredicate.TRUE, FixedPredicate.FALSE);

        assertFalse(predicate.evaluate(this));
    }

    public void testFalseAndTrueIsFalse() {
        Predicate predicate = new AndPredicate(FixedPredicate.FALSE, FixedPredicate.TRUE);

        assertFalse(predicate.evaluate(this));
    }

    public void testFalseAndFalseIsFalse() {
        Predicate predicate = new AndPredicate(FixedPredicate.FALSE, FixedPredicate.FALSE);

        assertFalse(predicate.evaluate(this));
    }

    private static final class FixedPredicate implements Predicate {
        public static final Predicate TRUE = new FixedPredicate(true);
        public static final Predicate FALSE = new FixedPredicate(false);

        private final boolean _result;

        private FixedPredicate(boolean result) {
            _result = result;
        }

        public boolean evaluate(Object object) {
            return _result;
        }
    }
}
