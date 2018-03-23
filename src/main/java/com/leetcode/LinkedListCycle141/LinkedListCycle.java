package com.leetcode.LinkedListCycle141;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-23
 * Time: 09:05:57
 * Description:
 * 141. Linked List Cycle
 * Given a linked list, determine if it has a cycle in it.
 * <p>
 * Follow up:
 * Can you solve it without using extra space?
 */
public class LinkedListCycle
{
    public boolean hasCycle(ListNode head)
    {
        if (head == null || head.next == null)
        {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast.next != null && fast.next.next != null)
        {
            if (slow == fast)
            {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow == fast;
    }
}
