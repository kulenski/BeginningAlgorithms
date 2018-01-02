package com.wrox.algorithms.ssearch;

/**
 * A {@link CharSequence} that decorates another to count the number of times {@link #charAt(int)} is called.
 *
 */
public class CallCountingCharSequence implements CharSequence {
    /** The underlying sequence. */
    private final CharSequence _charSequence;

    /** The number of times {@link #charAt(int)} is called. */
    private int _callCount;

    /**
     * Constructor.
     *
     * @param charSequence The underlying sequence.
     */
    public CallCountingCharSequence(CharSequence charSequence) {
        assert charSequence != null : "charSequence can't be null";
        _charSequence = charSequence;
    }

    /**
     * Obtains the number of times {@link #charAt(int)} has been called.
     *
     * @return The call count.
     */
    public int getCallCount() {
        return _callCount;
    }

    public int length() {
        return _charSequence.length();
    }

    public char charAt(int index) {
        ++_callCount;
        return _charSequence.charAt(index);
    }

    public CharSequence subSequence(int start, int end) {
        return _charSequence.subSequence(start, end);
    }
}
