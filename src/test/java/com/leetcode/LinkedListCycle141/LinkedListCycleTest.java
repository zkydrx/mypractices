package com.leetcode.LinkedListCycle141;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-23
 * Time: 09:15:55
 * Description:
 */
class LinkedListCycleTest
{

    @BeforeEach
    void setUp()
    {
        System.out.println("String...");
    }

    @AfterEach
    void tearDown()
    {
        System.out.println("Ending...");
    }

    @Test
    void hasCycle()
    {
        LinkedListCycle linkedListCycle = new LinkedListCycle();

        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next = new ListNode(2);


        boolean b = linkedListCycle.hasCycle(listNode);
        System.out.println(b);
    }
}