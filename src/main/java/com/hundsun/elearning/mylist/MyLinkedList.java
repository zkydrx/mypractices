package com.hundsun.elearning.mylist;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @ProjectName: mypractices
 * @Package: com.hundsun.elearning.mylist
 * @ClassName: MyList
 * @Author: hspcadmin
 * @Description: 我的链表
 * @Date: 2022-05-28 23:56
 * @Version: 1.0
 */
public class MyLinkedList
{
    /**
     * 静态内部类
     */
    static class Node
    {
        public Integer data;
        public Node next;

        public Node()
        {
        }

        public Node(int data)
        {
            this.data = data;
        }

        public Node(int data, Node next)
        {
            this.data = data;
            this.next = next;
        }
    }

    private Node head;

    /**
     * 链表尾部插入新节点
     *
     * @param data
     */
    public void add(int data)
    {
        Node newNode = new Node(data);
        if (head == null)
        {
            head = newNode;
            newNode.next = head;
        }
        else
        {
            Node temp = head;
            while (temp.next != head)
            {
                temp = temp.next;
            }
            /**
             * 把尾部的节点指向新的节点
             */
            temp.next = newNode;
            newNode.next = head;
        }
        sortNode();
    }

    public void display()
    {
        Node node = head;
        while (true)
        {
            System.out.println(node.data);
            if (node.next == head)
            {
                break;
            }
            node = node.next;
        }
    }

    /**
     * 针对节点进行排序，按降序排序。
     */
    public void sortNode()
    {
        ArrayList<Integer> arrayList = new ArrayList();
        Node node = head;
        while (true)
        {
            arrayList.add(node.data);
            if (node.next == head)
            {
                break;
            }
            node = node.next;
        }
        arrayList.sort(Comparator.comparing(Integer::intValue).reversed());
        Node node1 = head;
        for (Integer integer : arrayList)
        {
            node1.data = integer;
            node1 = node1.next;
        }
        return;
    }

    /**
     * 从尾节点开始删除
     */
    public Node remove(Object object)
    {
        Node temp = head;
        Node relNode = null;
        while (temp.next != head)
        {
            if (temp.next.data.equals(object))
            {
                System.out.println("删除的节点是：" + temp.next.data);
                relNode = temp.next;
                temp.next = temp.next.next;
            }
            else
            {
                temp = temp.next;
            }
        }
        return relNode;
    }
}
