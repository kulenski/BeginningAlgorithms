package com.wrox.algorithms.iteration;

/**
 * Iterator based on that defined in Design Patterns (Gamma et. al).
 *
 */
public interface Iterator {
    /**
     * (Re)positions the iterator to the first item.
     *
     * @throws UnsupportedOperationException if not implemented.
     */
    public void first();

    /**
     * (Re)positions the iterator to the last item.
     *
     * @throws UnsupportedOperationException if not implemented.
     */
    public void last();

    /**
     * Checks to see if the iterator refers to an item.
     *
     * @return <code>true</code> if the end has been reached; otherwise <code>false</code>.
     */
    public boolean isDone();

    /**
     * Positions to the next item.
     *
     * @throws UnsupportedOperationException if not implemented.
     */
    public void next();

    /**
     * Positions to the previous item.
     *
     * @throws UnsupportedOperationException if not implemented.
     */
    public void previous();

    /**
     * Obtains the value of the current item.
     *
     * @return The value of the current item.
     * @throws IteratorOutOfBoundsException if there is no current item.
     */
    public Object current() throws IteratorOutOfBoundsException;
}
