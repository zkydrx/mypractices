package com.leetcode.RemoveDuplicatesFromSortedList83;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-05
 * Time: 23:31:49
 * Description:
 * <p>
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * <p>
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 */
public class RemoveDuplicatesFromSortedList
{
    public ListNode deleteDuplicates(ListNode head)
    {


        if(head == null)
        {
            return head;
        }

        ListNode p = head;
        ListNode q = head.next;
        while (q != null)
        {
            if (q.val == p.val)
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
        return head;
    }
}
