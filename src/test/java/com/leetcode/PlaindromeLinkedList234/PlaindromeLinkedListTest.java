package com.leetcode.PlaindromeLinkedList234;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2018-04-30
 * Time: 21:07:57
 * Description:
 */
class PlaindromeLinkedListTest
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
    void isPalindrome()
    {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(2);
        listNode.next.next.next = new ListNode(1);
        listNode.next.next.next.next = new ListNode(1);
        PlaindromeLinkedList plaindromeLinkedList = new PlaindromeLinkedList();
        boolean palindrome = plaindromeLinkedList.isPalindrome(listNode);

        System.out.println(palindrome);
    }
}