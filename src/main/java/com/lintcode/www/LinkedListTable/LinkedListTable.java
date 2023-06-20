package com.lintcode.www.LinkedListTable;

/**
 * Created with IntelliJ IDEA. User: Abbot Date: 2017-09-14 Time: 16:58
 * Description: 删除链表中等于给定值val的所有节点。 样例 给出链表 1->2->3->3->4->5->3, 和 val = 3,
 * 你需要返回删除3之后的链表：1->2->4->5。
 */
public class LinkedListTable {
	public ListNode removeElements(ListNode head, int val) {
		if (head == null) {
			return head;
		}
		ListNode p = head;
		ListNode q = head.next;
		while (q != null) {
			if (q.val == val) {
				p.next = q.next;
				q = q.next;
			} else {
				p = p.next;
				q = q.next;

			}
		}

		if (head.val == val) {
			head = head.next;
		}
		return head;
	}
}