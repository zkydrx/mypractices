package com.leetcode.ImplementRand10UsingRand7Of470;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2021-03-17
 * Time: 00:02:38
 * Description:
 * <p>
 * <p>
 * 有一个随机数发生器，以概率P产生0，概率(1-P)产生1，请问能否利用这个随机数发生器，
 * 构造出新的发生器，以1/2的概率产生0和1。请写明结论及推理过程。
 * (扩展题）
 * 思路：
 * 调用两次函数产生以下结果：
 * 00-->p*p--->此种情况无限循环。
 * 01-->p*(1-p)
 * 11-->(1-p)*(1-p)--->此种情况无限循环。
 * 10--> (1-p)*P
 */
public class RandomZeroAndOne
{
    /**
     * 一个随机函数以0.88的概率返回0以0.12的概率返回1
     *
     * @return
     */
    public int a()
    {
        return Math.random() < 0.88 ? 0 : 1;
    }

    public int b()
    {
        int result;
        do
        {
            result = a();
        }
        while (result == a());
        return result;
    }

    @Test
    public void test()
    {
        int[] arr = new int[2];
        for (int i = 0; i < 10000000; i++)
        {
            int b = b();
            arr[b]++;
        }
        System.out.println("arr[0]==" + arr[0] + "\narr[1]==" + arr[1]);
    }
}
