package com.wrox.algorithms.queues;

/**
 * Represents a telephone call.
 *
 */
public class Call {
    /** The id of the call. */
    private final int _id;

    /** The duration for the call. */
    private final int _duration;

    /** The time at which this call was started. */
    private final long _startTime;

    /**
     * Constructor.
     *
     * @param id The id of the call.
     * @param duration The duration for the call.
     */
    public Call(int id, int duration) {
        assert duration >= 0 : "duration can't be < 0";

        _id = id;
        _duration = duration;
        _startTime = System.currentTimeMillis();
    }

    /**
     * Answers the call.
     */
    public void answer() {
        System.out.println(this + " answered; waited " + (System.currentTimeMillis() - _startTime) + " milliseconds");

        try {
            Thread.sleep(_duration);
        } catch (InterruptedException e) {
            // Ignore
        }
    }

    public String toString() {
        return "Call " + _id;
    }
}
