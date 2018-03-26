package com.leetcode.IntersectionOfTwoLinkedLists160;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-26
 * Time: 13:34:47
 * Description:
 */
class IntersectionOfTwoLinkedListsTest
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
    void getIntersectionNode()
    {
        IntersectionOfTwoLinkedLists intersection = new IntersectionOfTwoLinkedLists();
        ListNode listNode1= new ListNode(1);
        listNode1.next = new ListNode(2);
        listNode1.next.next=new ListNode(3);
        listNode1.next.next.next=new ListNode(4);
        ListNode listNode2 = new ListNode(5);
        listNode2.next = new ListNode(3);
        listNode2.next.next = new ListNode(4);
        ListNode intersectionNode = intersection.getIntersectionNode(listNode1, listNode2);

        while (intersectionNode != null)
        {
            System.out.println(intersectionNode.val);
            intersectionNode = intersectionNode.next;
        }
    }
}