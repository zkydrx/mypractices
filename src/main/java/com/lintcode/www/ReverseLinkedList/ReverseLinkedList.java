package com.lintcode.www.ReverseLinkedList;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-12-24
 * Time: 19:12
 * Description:
 * 35. Reverse Linked List
 * Reverse a linked list.
 * <p>
 * Have you met this question in a real interview? Yes
 * Example
 * For linked list 1->2->3, the reversed linked list is 3->2->1
 */
public class ReverseLinkedList
{
    public LinkedList<String> reverseLinkedList(LinkedList<String> linkedList)
    {
        LinkedList<String> linkedList1 = new LinkedList<>();
        for (int i = linkedList.size()-1; i >= 0; i--)
        {
            linkedList1.add(linkedList.get(i));
        }

        return linkedList1;
    }

    public static void main(String[] args)
    {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        LinkedList<String> linkedList1 = new ReverseLinkedList().reverseLinkedList(linkedList);

        System.out.println(linkedList1.toString());
    }
}
