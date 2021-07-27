package com.leetcode.AddTwoNumbers2;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * 2. Add Two Numbers
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add
 * the two numbers and return the sum as a linked list.
 * Example 1:
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * Example 2:
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * Example 3:
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 * Constraints:
 *
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have leading zeros.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * @ProductName: Hundsun HEP
 * @ProjectName: mypractices
 * @Package: com.leetcode.AddTwoNumbers2
 * @Description: note
 * @Author: zky
 * @CreateDate: 2021/7/28 0:40
 * @UpdateUser: zky
 * @UpdateDate: 2021/7/28 0:40
 * @UpdateRemark: The modified content
 * @DATE: 2021-07-28 00:40
 * @SINCE:
 * @Version: 1.0
 * <p>
 * Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved
 **/
@Slf4j
public class AddTwoNumbersMethod
{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null)
        {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null)
            {
                p = p.next;
            }
            if (q != null)
            {
                q = q.next;
            }
        }
        if (carry > 0)
        {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }


    @Test
    public void testAddTwoNumbers()
    {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(7);

        ListNode listNode = addTwoNumbers(l1, l2);
        log.info("l1:{}",l1.toString());
        log.info("l2:{}",l2.toString());
        log.info("result:{}",listNode.toString());

    }
}
