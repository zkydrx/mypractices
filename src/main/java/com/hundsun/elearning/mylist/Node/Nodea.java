package com.hundsun.elearning.mylist.Node;

/**
 * 链表
 */
public class Nodea {
	private int data;
	public Nodea next;

	public Nodea(int data, Nodea next) {
		this.data = data;
		this.next = next;
	}

	public Nodea() {
	}

	public Nodea(int data) {
		this.data = data;
	}
}
