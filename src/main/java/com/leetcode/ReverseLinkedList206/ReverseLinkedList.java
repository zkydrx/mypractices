package com.leetcode.ReverseLinkedList206;

/**
 * Created with IntelliJ IDEA. Author: Abbot Date: 2018-01-25 Time: 22:40:27
 * Description: 206. Reverse Linked List
 * <p>
 * Reverse a singly linked list.
 * <p>
 * click to show more hints.
 * <p>
 * Hint: A linked list can be reversed either iteratively or recursively. Could
 * you implement both?
 */
public class ReverseLinkedList {
	static ListNode head;

	public static void main(String[] args) {
		ListNode listNode = new ListNode(1);
		listNode.next = new ListNode(2);
		listNode.next.next = new ListNode(3);
		listNode.next.next.next = new ListNode(4);
		ListNode listNode1 = new ReverseLinkedList().reverseList(listNode);

		new ReverseLinkedList().printListNode(listNode1);
	}

	public ListNode reverseList(ListNode head) {
		ListNode prev = null;

		ListNode current = head;

		ListNode next = null;

		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}

		head = prev;
		return head;
	}

	public void printListNode(ListNode listNode) {
		while (listNode != null) {
			System.out.print(listNode.data + "\t");
			listNode = listNode.next;
		}
	}

	static class ListNode {
		int data;
		ListNode next;

		ListNode(int x) {
			data = x;
			next = null;
		}
	}
}
