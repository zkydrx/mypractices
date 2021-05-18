package com.leetcode.MergeTwoSortedLists21;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-02-24
 * Time: 22:04:36
 * Description:
 */
class MergeTwoSortedListsTest
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
    void mergeTwoLists()
    {
        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();

        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        ListNode node1 = new ListNode(2);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(5);

        ListNode node2 = mergeTwoSortedLists.mergeTwoLists(node, node1);

        while (node2 != null)
        {
            System.out.println(node2.val);
            node2 = node2.next;
        }
    }
}