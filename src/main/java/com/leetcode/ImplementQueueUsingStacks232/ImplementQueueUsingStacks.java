package com.leetcode.ImplementQueueUsingStacks232;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2018-04-27 Time: 21:06:43
 * Description: 232. Implement Queue using Stacks
 * <p>
 * Implement the following operations of a queue using stacks.
 * <p>
 * push(x) -- Push element x to the back of queue. pop() -- Removes the element
 * from in front of queue. peek() -- Get the front element. empty() -- Return
 * whether the queue is empty. Notes: You must use only standard operations of a
 * stack -- which means only push to top, peek/pop from top, size, and is empty
 * operations are valid. Depending on your language, stack may not be supported
 * natively. You may simulate a stack by using a list or deque (double-ended
 * queue), as long as you use only standard operations of a stack. You may
 * assume that all operations are valid (for example, no pop or peek operations
 * will be called on an empty queue).
 */
public class ImplementQueueUsingStacks {
	private Stack<Integer> temp;
	private Stack<Integer> value;
	private int front;

	/**
	 * Initialize your data structure here.
	 */
	public ImplementQueueUsingStacks() {
		temp = new Stack<>();
		value = new Stack<>();
	}

	/**
	 * Push element x to the back of queue.
	 */
	public void push(int x) {
		if (value.isEmpty()) {
			value.push(x);
		} else {
			while (!value.isEmpty()) {
				temp.push(value.pop());
			}
			value.push(x);
			while (!temp.isEmpty()) {
				value.push(temp.pop());
			}
		}
	}

	/**
	 * Removes the element from in front of queue and returns that element.
	 */
	public int pop() {
		return value.pop();
	}

	/**
	 * Get the front element.
	 */
	public int peek() {
		return value.peek();
	}

	/**
	 * Returns whether the queue is empty.
	 */
	public boolean empty() {
		return value.isEmpty();
	}
}
