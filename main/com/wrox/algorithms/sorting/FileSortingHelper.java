package com.wrox.algorithms.sorting;

import com.wrox.algorithms.iteration.Iterator;
import com.wrox.algorithms.lists.ArrayList;
import com.wrox.algorithms.lists.List;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Loads a word list into a {@link List} and sort it.
 *
 */
public final class FileSortingHelper {
    /**
     * Constructor marked private to prevent instantiation.
     */
    private FileSortingHelper() {
    }

    /**
     * The program entry point.
     * @param args
     * @throws IOException if input cannot be read.
     */
    public static void main(String[] args) throws IOException {
        sort(loadWords());

        System.err.println("Finished...press CTRL-C to exit");

        try {
            Thread.sleep(0);
        } catch (InterruptedException e) {
            // ignore it
        }
    }

    private static void sort(List wordList) {
        assert wordList != null : "tree can't be null";

        System.out.println("Starting sort...");

        Comparator comparator = ReverseStringComparator.INSTANCE;
        ListSorter sorter = new ShellsortListSorter(comparator);

        List sorted = sorter.sort(wordList);

        Iterator i = sorted.iterator();
        i.first();
        while (!i.isDone()) {
            System.out.println(i.current());
            i.next();
        }
    }

    private static List loadWords() throws IOException {
        List result = new ArrayList();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String word;

            while ((word = reader.readLine()) != null) {
                result.add(word);
            }
        } finally {
            reader.close();
        }

        return result;
    }
}
