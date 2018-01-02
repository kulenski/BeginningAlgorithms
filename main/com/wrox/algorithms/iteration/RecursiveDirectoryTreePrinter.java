package com.wrox.algorithms.iteration;

import java.io.File;

/**
 * Simple class to print out the contents of a directory tree.
 *
 */
public final class RecursiveDirectoryTreePrinter {
    /** The number of spaces to indent each recursion. */
    private static final String SPACES = "  ";

    /**
     * Constructor marked private to prevent instantiation.
     */
    private RecursiveDirectoryTreePrinter() {
    }

    /**
     * Program mainline.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        assert args != null : "args can't be null";

        if (args.length != 1) {
            System.err.println("Usage: RecursiveDirectoryTreePrinter <dir>");
            System.exit(-1);
        }

        System.out.println("Recursively printing directory tree for: " + args[0]);
        print(new File(args[0]), "");
    }

    /**
     * Prints a list of files/directories with the given indentation.
     *
     * @param files The files/directories to print.
     * @param indent The amount of indentation.
     */
    private static void print(Iterator files, String indent) {
        assert files != null : "files can't be null";

        for (files.first(); !files.isDone(); files.next()) {
            print((File) files.current(), indent);
        }
    }

    /**
     * Prints a file or directory with the given indentation.
     *
     * @param file  The file or directory to print.
     * @param indent The amount of indentation.
     */
    private static void print(File file, String indent) {
        assert file != null : "file can't be null";
        assert indent != null : "indent can't be null";

        System.out.print(indent);
        System.out.println(file.getName());

        if (file.isDirectory()) {
            print(new ArrayIterator(file.listFiles()), indent + SPACES);
        }
    }
}
