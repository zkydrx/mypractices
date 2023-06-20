package com.lintcode.www.LinkedListTable;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA. User: Abbot Date: 2017-09-14 Time: 17:09
 * Description:
 */
class LinkedListTableTest {
	@BeforeEach
	void setUp() {
		System.out.println("start");
	}

	@AfterEach
	void tearDown() {
		System.out.println("end");
	}

	/**
	 * 1->2->3->3->4->5->3,
	 */
	@Test
	void removeElements() {
		ListNode listNode = new ListNode(1);
		listNode.next = new ListNode(2);
		listNode.next.next = new ListNode(3);
		listNode.next.next.next = new ListNode(3);
		listNode.next.next.next.next = new ListNode(4);
		listNode.next.next.next.next.next = new ListNode(5);
		listNode.next.next.next.next.next.next = new ListNode(3);

		LinkedListTable linkedListTable = new LinkedListTable();
		ListNode listNode1 = linkedListTable.removeElements(listNode, 3);

		System.out.println(listNode1);

	}

}