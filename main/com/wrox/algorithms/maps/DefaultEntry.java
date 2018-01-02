package com.wrox.algorithms.maps;

/**
 * A default implementation of {@link Map.Entry}.
 *
 */
public class DefaultEntry implements Map.Entry {
    private final Object _key;
    private Object _value;

    /**
     * Constructor.
     *
     * @param key The key.
     * @param value The value.
     */
    public DefaultEntry(Object key, Object value) {
        assert key != null : "key can't be null";
        _key = key;
        setValue(value);
    }

    public Object getKey() {
        return _key;
    }

    /**
     * Sets the value.
     *
     * @param value The new value.
     * @return The old value.
     */
    public Object setValue(Object value) {
        Object oldValue = _value;
        _value = value;
        return oldValue;
    }

    public Object getValue() {
        return _value;
    }

    public int hashCode() {
        return _key.hashCode() ^ _value.hashCode();
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        DefaultEntry other = (DefaultEntry) object;

        return _key.equals(other._key) && _value.equals(other._value);
    }

    public String toString() {
        return _key + " = " + _value;
    }
}
