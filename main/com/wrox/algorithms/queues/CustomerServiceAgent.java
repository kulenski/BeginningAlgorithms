package com.wrox.algorithms.queues;

/**
 * Services {@link Call}s by pulling them off a {@link Queue}.
 *
 */
public class CustomerServiceAgent implements Runnable {
    /** Indicates it's time for the agent to finish. */
    public static final Call GO_HOME = new Call(-1, 0);

    /** The id of the agent. */
    private final int _id;

    /** The queue from which to pull calls. */
    private final Queue _calls;

    /**
     * Constructor.
     *
     * @param id The id of the agent.
     * @param calls The queue from which to pull calls.
     */
    public CustomerServiceAgent(int id, Queue calls) {
        assert calls != null : "calls can't be null";
        _id = id;
        _calls = calls;
    }

    public void run() {
        System.out.println(this + " clocked on");

        while (true) {
            System.out.println(this + " waiting");

            Call call = (Call) _calls.dequeue();
            System.out.println(this + " answering " + call);

            if (call == GO_HOME) {
                break;
            }

            call.answer();
        }

        System.out.println(this + " going home");
    }

    public String toString() {
        return "Agent " + _id;
    }
}
