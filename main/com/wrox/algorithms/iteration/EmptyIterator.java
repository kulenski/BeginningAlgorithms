package com.wrox.algorithms.iteration;

/**
 * An {@link Iterator} where {@link #isDone()} always returns <code>true</code>.
 *
 */
public final class EmptyIterator implements Iterator {
    /** The single, publicly accessible, instance of the comparator. */
    public static final EmptyIterator INSTANCE = new EmptyIterator();

    /**
     * Constructor marked private to prevent instantiation.
     */
    private EmptyIterator() {
        // Nothing to do
    }

    public void first() {
        // Nothing to do
    }

    public void last() {
        // Nothing to do
    }

    public boolean isDone() {
        // We're always done!
        return true;
    }

    public void next() {
        // Nothing to do
    }

    public void previous() {
        // Nothing to do
    }

    public Object current() throws IteratorOutOfBoundsException {
        throw new IteratorOutOfBoundsException();
    }
}
