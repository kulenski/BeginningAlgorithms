package com.wrox.algorithms.wmatch;

/**
 * Generic interface for encoding strings according to various Soundex algorithms.
 *
 */
public interface PhoneticEncoder {
    /**
     * Encodes a string.
     *
     * @param string The string to encode.
     * @return The encoded value.
     */
    public String encode(CharSequence string);
}
