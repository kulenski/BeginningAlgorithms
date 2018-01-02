package com.wrox.algorithms.iteration;

/**
 * A {@link Predicate} that performs a boolean AND (&&) of two other predicates.
 *
 */
public final class AndPredicate implements Predicate {
    /** The left-hand argument. */
    private final Predicate _left;

    /** The right-hand argument. */
    private final Predicate _right;

    /**
     * Constructor.
     *
     * @param left The left-hand argument.
     * @param right The righ-hand argument.
     */
    public AndPredicate(Predicate left, Predicate right) {
        assert left != null : "left can't be null";
        assert right != null : "right can't be null";

        _left = left;
        _right = right;
    }

    public boolean evaluate(Object object) {
        return _left.evaluate(object) && _right.evaluate(object);
    }
}
