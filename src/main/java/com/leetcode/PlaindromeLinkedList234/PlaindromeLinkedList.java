package com.leetcode.PlaindromeLinkedList234;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2018-04-28
 * Time: 23:21:46
 * Description:
 * <p>
 * 234. Palindrome Linked List
 * <p>
 * Given a singly linked list, determine if it is a palindrome.
 * <p>
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 */
public class PlaindromeLinkedList
{
    public boolean isPalindrome(ListNode head)
    {
        if (head == null)
        {
            return true;
        }
        ListNode p = head;
        ListNode prev = new ListNode(head.val);
        while (p.next != null)
        {
            ListNode temp = new ListNode(p.next.val);
            temp.next = prev;
            prev = temp;
            p = p.next;

        }
        ListNode p1 = head;
        ListNode p2 = prev;
        while (p1 != null)
        {
            if (p1 != null)
            {
                if (p1.val != p2.val)

                {
                    return false;
                }
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        return true;
    }
}
