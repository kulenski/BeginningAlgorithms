package com.wrox.algorithms.hashing;

/**
 * A deterministic {@link PrimeNumberGenerator} that uses successive division to test for primality.
 *
 */
public final class SimplePrimeNumberGenerator implements PrimeNumberGenerator {
    /** The single instance of the class. */
    public static final SimplePrimeNumberGenerator INSTANCE = new SimplePrimeNumberGenerator();

    /**
     * Constructor makred private to prevent instantiation.
     */
    private SimplePrimeNumberGenerator() {
    }

    public int generate(int candidate) {
        int prime = candidate;

        while (!isPrime(prime)) {
            ++prime;
        }

        return prime;
    }

    /**
     * Determines if a number is prime by checking the remainder after division.
     *
     * @param candidate The candidate prime.
     * @return <code>true</code> if the candidate is prime; otherwise <code>false</code>.
     */
    private boolean isPrime(int candidate) {
        for (int i = candidate / 2; i >= 2; --i) {
            if (candidate % i == 0) {
                return false;
            }
        }
        return true;
    }
}
