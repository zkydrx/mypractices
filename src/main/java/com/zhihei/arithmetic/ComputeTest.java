package com.zhihei.arithmetic;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-11-13
 * Time: 18:57:22
 * Description:
 */
public class ComputeTest
{
    /**
     * Java实现约瑟夫环：50个人围成一圈数数，从1开始报数，数到3的人退出，求最后剩下的人的编号
     * 利用可变数组ArrayList实现。
     * 算法思想：将所有人的报数放到链表内；利用链表，将链表表头挨个移除，
     * 并放到表的后面，在放第三个元素的时候，直接删除掉
     * （如果有要求，可以删除的同时打印该元素，该元素即为出队人的编号）。
     * <p>
     * 约瑟夫环：已知n个人(以编号1，2，3...n分别表示)围坐在一张圆桌周围。
     * 从编号为k的人开始报数，数到m的那个人出列;他的下一个人又从1开始报数，
     * 数到m的那个人又出列;依此规律重复下去，直到圆桌周围的人全部出列。
     * 通过list把留下的元素放到列表的最后边，然后删除首个元素也就是满足条件的元素，
     * 直到列表只剩下一个元素停止循环。
     * 这个是最简单的办法。目前我所知道的。
     *
     * @param n 人的总数
     * @param m 出列的标记（可以大于n)
     */
    public void josephRing(int n, int m)
    {

        List<Integer> integers = new ArrayList<>();
        for (int i = 1; i <= n; i++)
        {
            integers.add(i);
        }
        int count = 1;
        while (integers.size() > 1)
        {
            for (int j = 0; j < m - 1; j++)
            {
                integers.add(integers.remove(0));
            }

            /**
             * 打印出第几次删除了什么元素
             */
            System.out.println("第 " + (count++) + " 次删除的元素是:" + integers.remove(0));
            System.out.println(integers.toString());
        }
    }

    @Test
    public void testJosephRing()
    {
        josephRing(50, 3);
    }

    private static void queue(int total, int num)
    {
        // TODO Auto-generated method stub
        //定义一个数组，true表示没有出列的，false表示已经出队列的
        boolean[] arr = new boolean[total];
        Arrays.fill(arr, true);
        //移动变量，如1 2 3
        int next = 0;
        //数组下标
        int index = 0;
        //剩下的人数
        int remain = total;
        //如果剩下的人为1时，停止报数
        while (remain > 1)
        {
            for (index = 0; index < total; index++)
            {
                if (arr[index] == true)
                {
                    next++; //自增到规定的出列数num
                    if (next == num)
                    {
                        arr[index] = false;
                        remain--;
                        System.out.println("依次出列的人数为：" + (index + 1));
                        next = 0; //当数到规定的数是，从0开始数
                    }
                }
            }
        }
        for (int i = 0; i < total; i++)
        {
            if (arr[i] == true)
            {
                System.out.println("最后剩下的人是：" + (i + 1));
                break;
            }
        }
    }

    @Test
    public void testArr()
    {
        queue(50, 3);
    }
}
