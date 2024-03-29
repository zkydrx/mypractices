package com.design.mode.iterator;

/**
 * The interface to create concrete iterator When create iterator, we can use
 * Shape Method pattern
 */
public interface Aggregate {
	public Iterator CreateIterator();
}