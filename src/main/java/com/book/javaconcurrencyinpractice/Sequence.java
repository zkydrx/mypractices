package com.book.javaconcurrencyinpractice;


import com.book.javaconcurrencyinpractice.annotations.GuardedBy;
import com.book.javaconcurrencyinpractice.annotations.ThreadSafe;

/**
 * Sequence
 *
 * @author Brian Goetz and Tim Peierls
 */

@ThreadSafe
public class Sequence {
    @GuardedBy("this") private int nextValue;

    public synchronized int getNext() {
        return nextValue++;
    }
}
