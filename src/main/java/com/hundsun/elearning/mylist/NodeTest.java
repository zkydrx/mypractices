package com.hundsun.elearning.mylist;

import org.junit.Test;

public class NodeTest
{
    static class Nodea
    {
        private int data;
        private Nodea next;

        public Nodea(int data, Nodea next)
        {
            this.data = data;
            this.next = next;
        }

        public Nodea()
        {
        }

        public Nodea(int data)
        {
            this.data = data;
        }
    }

    private Nodea head;

    /**
     * 获取单链表的节点个数
     *
     * @return
     */
    public int nodeLength()
    {
        int length = 0;
        Nodea node = head;
        if (node == null)
        {
            length = 0;
        }
        while (node != null)
        {
            length++;
            node = node.next;
        }
        return length;
    }


    public void add(int data)
    {
        Nodea newNode = new Nodea(data);
        if (head == null)
        {
            head = newNode;
        }
        else
        {
            Nodea nodeTemp = head;
            while (nodeTemp.next != null)
            {
                nodeTemp = nodeTemp.next;
            }
            nodeTemp.next = newNode;
        }
    }


    /**
     * remote the last item
     */
    public void removeLast()
    {
        if (head == null)
        {
            head = null;
        }
        else
        {
            Nodea temp = head;
            while (temp.next.next != null)
            {
                temp = temp.next;
            }
            temp.next = null;
        }
    }


    @Test
    public void addTest()
    {
        NodeTest nodeTest = new NodeTest();
        nodeTest.add(1);
        nodeTest.add(2);
        nodeTest.add(3);
        nodeTest.add(4);
        System.out.println(nodeTest.nodeLength());
    }

}
