package com.wrox.algorithms.stacks;

import com.wrox.algorithms.queues.Queue;

/**
 * A generic interface for stacks.
 *
 */
public interface Stack extends Queue {
    /**
     * Adds a value to the top of the stack. The size of the stack will increase by one.
     *
     * @param value The value to push.
     */
    public void push(Object value);

    /**
     * Removes and returns the value at the top of the stack. The size of the stack will decrease by one.
     *
     * @return The value at the top of the stack.
     * @throws EmptyStackException If the stack is empty (<code>isEmpty() == true</code>).
     */
    public Object pop() throws EmptyStackException;

    /**
     * Returns but does not delete the value at the top of the stack. The size of the stack remains unchanged.
     *
     * @return The value at the top of the stack.
     * @throws EmptyStackException If the stack is empty (<code>isEmpty() == true</code>).
     */
    public Object peek() throws EmptyStackException;

    /**
     * Deletes all elements from the stack. The size of the stack will be reset to zero (0).
     */
    public void clear();

    /**
     * Obtains the number of elements in the stack.
     *
     * @return The number of elements in the stack.
     */
    public int size();

    /**
     * Determines if the stack is empty or not.
     *
     * @return <code>true</code> if the list is empty (<code>size() == 0</code>); otherwise returns <code>false</code>.
     */
    public boolean isEmpty();
}
