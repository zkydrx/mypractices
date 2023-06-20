package com.leetcode.IntersectionOfTwoLinkedLists160;

/**
 * Created with IntelliJ IDEA. Author: Abbot Date: 2018-03-25 Time: 23:51:21
 * Description:
 * <p>
 * 160. Intersection of Two Linked Lists
 * <p>
 * Write a program to find the node at which the intersection of two singly
 * linked lists begins.
 * <p>
 * <p>
 * For example, the following two linked lists:
 * <p>
 * A: a1 → a2 ↘ c1 → c2 → c3 ↗ B: b1 → b2 → b3 begin to intersect at node c1.
 * <p>
 * <p>
 * Notes:
 * <p>
 * If the two linked lists have no intersection at all, return null. The linked
 * lists must retain their original structure after the function returns. You
 * may assume there are no cycles anywhere in the entire linked structure. Your
 * code should preferably run in O(n) time and use only O(1) memory. Credits:
 * Special thanks to @stellari for adding this problem and creating all test
 * cases.
 */
public class IntersectionOfTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int len1 = 0;
		int len2 = 0;
		ListNode p1 = headA;
		ListNode p2 = headB;
		if (p1 == null || p2 == null) {
			return null;
		}
		while (p1 != null) {
			len1++;
			p1 = p1.next;
		}
		while (p2 != null) {
			len2++;
			p2 = p2.next;
		}

		int diff = 0;
		p1 = headA;
		p2 = headB;
		if (len1 > len2) {
			diff = len1 - len2;
			int i = 0;
			while (i < diff) {
				p1 = p1.next;
				i++;
			}
		} else {
			diff = len2 - len1;
			int i = 0;
			while (i < diff) {
				p2 = p2.next;
				i++;
			}
		}

		while (p1 != null && p2 != null) {
			if (p1.val == p2.val) {

				return p1;
			} else {

			}
			p1 = p1.next;
			p2 = p2.next;
		}

		return null;
	}

}
