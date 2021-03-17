package com.leetcode.other.BST;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2021-03-17
 * Time: 12:38:56
 * Description:
 * 已知一个搜索二叉树的后续遍历数组posArr,
 * 请根据posArr，重建出整棵树，返回新建树的头结点。
 */
public class ByteDanceMethod
{
    public class Node
    {
        public int value;
        public Node left;
        public Node right;

        public Node(int v)
        {
            value = v;
        }
    }

    public Node posArrayToBST1(int[] posArr)
    {
        return process1(posArr, 0, posArr.length - 1);
    }

    public Node posArrayToBST2(int[] posArr)
    {
        return process3(posArr, 0, posArr.length - 1);
    }

    private Node process1(int[] posArr, int L, int R)
    {
        /**
         * 如果左下标大于右下标，递归结束。
         */
        if (L > R)
        {
            return null;
        }
        /**
         * 由于是后续遍历，所以节点头是数组的最后一个元素。也就是posArr[R]
         */
        Node head = new Node(posArr[R]);
        if (L == R)
        {
            return head;
        }
        int M = L - 1;
        for (int i = 0; i < R; i++)
        {
            if (posArr[i] < posArr[R])
            {
                M = i;
            }
        }
        head.left = process1(posArr, L, M);
        head.right = process1(posArr, M + 1, R - 1);
        return head;
    }

    private Node process2(int[] posArr, int L, int R)
    {
        /**
         * 由于是后续遍历，所以节点头是数组的最后一个元素。也就是posArr[R]
         */
        Node head = new Node(posArr[R]);
        if (L == R)
        {
            return head;
        }
        int M = -1;
        for (int i = 0; i < R; i++)
        {
            if (posArr[i] < posArr[R])
            {
                M = i;
            }
        }

        /**
         * 全部是右孩子
         */
        if (M == -1)
        {
            head.right = process2(posArr, L, R - 1);
        }
        else if (M == R - 1)
        {
            head.left = process2(posArr, L, M);
        }
        else
        {
            head.left = process2(posArr, L, M);
            head.right = process2(posArr, M + 1, R - 1);
        }
        return head;
    }

    private Node process3(int[] posArr, int L, int R)
    {
        /**
         * 如果左下标大于右下标，递归结束。
         */
        if (L > R)
        {
            return null;
        }
        /**
         * 由于是后续遍历，所以节点头是数组的最后一个元素。也就是posArr[R]
         */
        Node head = new Node(posArr[R]);
        if (L == R)
        {
            return head;
        }
        int M = L - 1;
        int left = L;
        int right = R - 1;
        /**
         * 二分法查找M效率更高。
         */
        while (left <= right)
        {
            int mid = left + ((right - left) >> 1);
            if (posArr[mid] < posArr[R])
            {
                M = mid;
                left = mid + 1;
            }
            else
            {
                right = mid - 1;
            }
        }
        head.left = process3(posArr, L, M);
        head.right = process3(posArr, M + 1, R - 1);
        return head;
    }


    /**
     * 以下的一些方法都是为了测试而写的。
     *
     * @param min
     * @param max
     * @param N
     * @return
     */
    public Node generateRandomBST(int min, int max, int N)
    {
        if (min > max)
        {
            return null;
        }
        return createTree(min, max, 1, N);
    }

    private Node createTree(int min, int max, int level, int N)
    {

        if (min > max || level > N)
        {
            return null;
        }
        Node head = new Node(random(min, max));
        head.left = createTree(min, head.value - 1, level + 1, N);
        head.right = createTree(head.value + 1, max, level + 1, N);
        return head;
    }

    private int random(int min, int max)
    {
        return (int) (Math.random() * (max - min + 1)) + min;
    }


    public int[] getBstPosArr(Node head)
    {
        ArrayList<Integer> posList = new ArrayList<>();
        pos(head, posList);
        int[] ans = new int[posList.size()];
        for (int i = 0; i < ans.length; i++)
        {
            ans[i] = posList.get(i);
        }
        return ans;
    }

    private void pos(Node head, ArrayList<Integer> posList)
    {
        if (head != null)
        {
            pos(head.left, posList);
            pos(head.right, posList);
            posList.add(head.value);
        }
    }


    public boolean isSameValueStructure(Node head1, Node head2)
    {
        if (head1 == null && head2 != null)
        {
            return false;
        }
        if (head1 != null && head2 == null)
        {
            return false;
        }
        if (head1 == null && head2 == null)
        {
            return true;
        }

        return head1.value == head2.value && isSameValueStructure(head1.left, head2.left) && isSameValueStructure(head1.right, head2.right);
    }


    public void printTree(Node head)
    {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    private void printInOrder(Node head, int height, String to, int len)
    {
        if (head == null)
        {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) >> 1;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    private String getSpace(int lenR)
    {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < lenR; i++)
        {
            buf.append(space);
        }
        return buf.toString();
    }


    @Test
    public void test()
    {
        int[] arr = new int[21];
        for (int i = 0; i < 100000; i++)
        {
            int random = random(10, 20);
            arr[random]++;
        }
        for (int i = 0; i < arr.length; i++)
        {
            System.out.println(i + "=====" + arr[i]);
        }
    }

    @Test
    public void test1()
    {
        int min = 0;
        int max = 12;
        int level = 4;
        Node head = generateRandomBST(min, max, level);
        int[] bstPosArr = getBstPosArr(head);
        printTree(head);
        printTree(posArrayToBST1(bstPosArr));
        printTree(posArrayToBST2(bstPosArr));
        System.out.println(isSameValueStructure(head, posArrayToBST1(bstPosArr)));
        System.out.println(isSameValueStructure(head, posArrayToBST2(bstPosArr)));

        int times = 5000000;
        System.out.println("test begin,test times:" + times);
        for (int i = 0; i < times; i++)
        {
            head = generateRandomBST(min, max, level);
            bstPosArr = getBstPosArr(head);
            if (!isSameValueStructure(head, posArrayToBST1(bstPosArr)) || !isSameValueStructure(head, posArrayToBST2(bstPosArr)))
            {
                System.out.println("Oops!");
            }
        }
        System.out.println("test finsh!");
    }
}
