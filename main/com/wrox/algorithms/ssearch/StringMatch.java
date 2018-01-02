package com.wrox.algorithms.ssearch;

/**
 * Represents a pattern match within some text.
 *
 */
public class StringMatch {
    /** The pattern that was searched for. */
    private final CharSequence _pattern;

    /** The text containing the match. */
    private final CharSequence _text;

    /** The position (0, 1, 2...) within the text at which tha pattern ocurred. */
    private final int _index;

    /**
     * Constructor.
     *
     * @param pattern The pattern that was searched for.
     * @param text The text containing the match.
     * @param index The position (0, 1, 2...) within the text at which tha pattern ocurred.
     */
    public StringMatch(CharSequence pattern, CharSequence text, int index) {
        assert text != null : "text can't be null";
        assert pattern != null : "pattern can't be null";
        assert index >= 0 : "index can't be < 0";

        _text = text;
        _pattern = pattern;
        _index = index;
    }

    public CharSequence getPattern() {
        return _pattern;
    }

    public CharSequence getText() {
        return _text;
    }

    public int getIndex() {
        return _index;
    }
}
