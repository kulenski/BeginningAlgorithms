package com.wrox.algorithms.queues;

/**
 * Exercises a {@link CallCenter} by randomly generating {@link Call}s.
 *
 */
public class CallGenerator {
    /** The call centre. */
    private final CallCenter _callCenter;

    /** The number of calls to generate. */
    private final int _numberOfCalls;

    /** The maximum duration for a call. */
    private final int _maxCallDuration;

    /** The maximum duration between calls. */
    private final int _maxCallInterval;

    /**
     * Constructor.
     *
     * @param callCenter The call center to use.
     * @param numberOfCalls The number of calls to generate.
     * @param maxCallDuration The maximum The maximum duration for a call.
     * @param maxCallInterval The maximum duration between calls.
     */
    public CallGenerator(CallCenter callCenter, int numberOfCalls, int maxCallDuration, int maxCallInterval) {
        assert callCenter != null : "callCenter can't be null";
        assert numberOfCalls > 0 : "numberOfCalls can't be < 1";
        assert maxCallDuration > 0 : "maxCallDuration can't be < 1";
        assert maxCallInterval > 0 : "maxCallInterval can't be < 1";

        _callCenter = callCenter;
        _numberOfCalls = numberOfCalls;
        _maxCallDuration = maxCallDuration;
        _maxCallInterval = maxCallInterval;
    }

    /**
     * Generates calls with a random duration.
     */
    public void generateCalls() {
        for (int i = 0; i < _numberOfCalls; ++i) {
            sleep();
            _callCenter.accept(new Call(i, (int) (Math.random() * _maxCallDuration)));
        }
    }

    /**
     * Sleeps for a random duration.
     */
    private void sleep() {
        try {
            Thread.sleep((int) (Math.random() * _maxCallInterval));
        } catch (InterruptedException e) {
            // Ignore
        }
    }
}
