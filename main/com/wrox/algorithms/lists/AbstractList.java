package com.wrox.algorithms.lists;

import com.wrox.algorithms.iteration.Iterator;

/**
 * Convenience base class for {@link List} implementations.
 *
 */
public abstract class AbstractList implements List {
    public String toString() {
        StringBuffer buffer = new StringBuffer();

        buffer.append('[');

        if (!isEmpty()) {
            Iterator i = iterator();
            for (i.first(); !i.isDone(); i.next()) {
                buffer.append(i.current()).append(", ");
            }

            buffer.setLength(buffer.length() - 2);
        }

        buffer.append(']');

        return buffer.toString();
    }

    public int hashCode() {
        int hashCode = 0;

        Iterator i = iterator();
        for (i.first(); !i.isDone(); i.next()) {
            hashCode ^= i.current().hashCode();
        }

        return hashCode;
    }

    public boolean equals(Object object) {
        return object instanceof List ? equals((List) object) : false;
    }

    public boolean equals(List other) {
        if (other == null || size() != other.size()) {
            return false;
        }

        Iterator i = iterator();
        Iterator j = other.iterator();
        for (i.first(), j.first(); !i.isDone() && !j.isDone(); i.next(), j.next()) {
            if (!i.current().equals(j.current())) {
                break;
            }
        }

        return i.isDone() && j.isDone();
    }
}
