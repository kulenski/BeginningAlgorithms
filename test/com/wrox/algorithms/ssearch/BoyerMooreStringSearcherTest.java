package com.wrox.algorithms.ssearch;

/**
 * Concrete test class for {@link BoyerMooreStringSearcher}.
 *
 */
public class BoyerMooreStringSearcherTest extends AbstractStringSearcherTestCase {
    protected StringSearcher createSearcher(CharSequence pattern) {
        return new BoyerMooreStringSearcher(pattern);
    }

    public void testShiftsDontErroneouslyIgnoreMatches() {
        String text = "aababaa";
        String pattern = "baba";

        StringSearcher searcher = createSearcher(pattern);

        StringMatch match = searcher.search(text, 0);
        assertNotNull(match);
        assertEquals(text, match.getText());
        assertEquals(pattern, match.getPattern());
        assertEquals(2, match.getIndex());

        assertNull(searcher.search(text, match.getIndex() + 1));
    }
}
