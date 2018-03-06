package com.leetcode.RemoveDuplicatesFromSortedList83;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-06
 * Time: 08:59:40
 * Description:
 */
class RemoveDuplicatesFromSortedListTest
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
    void deleteDuplicates()
    {
        RemoveDuplicatesFromSortedList removeDuplicatesFromSortedList = new RemoveDuplicatesFromSortedList();

        ListNode listNode = new ListNode(1);
         listNode.next = new ListNode(1);
         listNode.next.next = new ListNode(2);
         listNode.next.next.next=new ListNode(3);
         listNode.next.next.next.next = new ListNode(3);

        ListNode listNode5 = removeDuplicatesFromSortedList.deleteDuplicates(listNode);

        while (listNode5 != null)
        {
            System.out.println(listNode5.val);
            listNode5 = listNode5.next;
        }

    }
}