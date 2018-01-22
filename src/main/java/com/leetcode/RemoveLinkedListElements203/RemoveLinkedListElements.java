package com.leetcode.RemoveLinkedListElements203;


/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-01-22
 * Time: 13:41
 * Description:
 * 203. Remove Linked List Elements
 * Remove all elements from a linked list of integers that have value val.
 * <p>
 * Example
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 * <p>
 * Credits:
 * Special thanks to @mithmatt for adding this problem and creating all test cases.
 */
public class RemoveLinkedListElements
{
    public ListNode removeElements(ListNode head, int val)
    {
        if (head == null)
        {
            return null;
        }
        ListNode p = head;
        ListNode q = head.next;
        while (q != null)
        {
            if (q.val == val)
            {
                p.next = q.next;
                q = q.next;
            }
            else
            {
                p = p.next;
                q = q.next;
            }

        }
        if (head.val == val)
        {
            head = head.next;
        }
        return head;
    }
}
