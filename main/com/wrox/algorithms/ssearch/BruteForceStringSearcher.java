package com.wrox.algorithms.ssearch;

/**
 * A {@link StringSearcher} that uses a brute-force algorithm.
 *
 */
public class BruteForceStringSearcher implements StringSearcher {
    /** The pattern for which to search. */
    private final CharSequence _pattern;

    /**
     * Constructor.
     *
     * @param pattern The pattern for which to search.
     */
    public BruteForceStringSearcher(CharSequence pattern) {
        assert pattern != null : "pattern can't be null";
        assert pattern.length() > 0 : "pattern can't be empty";

        _pattern = pattern;
    }

    public StringMatch search(CharSequence text, int from) {
        assert text != null : "text can't be null";
        assert from >= 0 : "from can't be < 0";

        int s = from;

        while (s <= text.length() - _pattern.length()) {
            int i = 0;

            while (i < _pattern.length() && _pattern.charAt(i) == text.charAt(s + i)) {
                ++i;
            }

            if (i == _pattern.length()) {
                return new StringMatch(_pattern, text, s);
            }

            ++s;
        }

        return null;
    }
}
