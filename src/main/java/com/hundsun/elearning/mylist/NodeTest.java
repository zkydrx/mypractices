package com.hundsun.elearning.mylist;

import com.hundsun.elearning.mylist.Node.Nodea;
import org.junit.Test;

public class NodeTest
{
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
            while (temp.next != null && temp.next.next != null)
            {
                temp = temp.next;
            }
            if(temp.next == null)
            {
                head = null;
            }
            else
            {
                temp.next = null;
            }
        }
    }


    /**
     * print reverse the element.
     */
    public void printReverse()
    {

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

    @Test
    public void removeLastTest()
    {
        NodeTest nodeTest = new NodeTest();
        nodeTest.add(1);
        nodeTest.add(2);
        nodeTest.add(3);
        nodeTest.add(4);
        System.out.println("原始长度："+nodeTest.nodeLength());
        nodeTest.removeLast();
        System.out.println("第一次删除后长度："+nodeTest.nodeLength());
        nodeTest.removeLast();
        System.out.println("第二次删除后长度："+nodeTest.nodeLength());
        nodeTest.removeLast();
        System.out.println("第三次删除后长度："+nodeTest.nodeLength());
        nodeTest.removeLast();
        System.out.println("第四次删除后长度："+nodeTest.nodeLength());

    }


}
