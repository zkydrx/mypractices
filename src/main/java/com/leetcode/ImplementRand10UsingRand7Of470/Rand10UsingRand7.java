package com.leetcode.ImplementRand10UsingRand7Of470;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2021-03-16
 * Time: 19:50:00
 * Description:
 * 470. 用 Rand7() 实现 Rand10()
 * 已有方法 rand7 可生成 1 到 7 范围内的均匀随机整数，试写一个方法 rand10 生成 1 到 10 范围内的均匀随机整数。
 * <p>
 * 不要使用系统的 Math.random() 方法。
 */
public class Rand10UsingRand7
{
    public int a()
    {
        return (int) (Math.random() * 7) + 1;
    }

    public int b()
    {
        int temp = 0;
        int result = 0;
        do
        {
            temp = a();
            result = temp % 2;
        }
        while (temp == 7);
        return result;
    }

    public int c()
    {
        int result;
        do
        {
            result = (b() << 3) + (b() << 2) + (b() << 1) + (b() << 0);
        }
        while (result == 15 || result == 14 || result == 13 || result == 12 || result == 11 || result == 10);
        return result + 1;
    }


    @Test
    public void test()
    {
        int[] arr = new int[11];
        for (int i = 0; i < 1000000000; i++)
        {
            int ans = c();
            arr[ans]++;
        }
        for (int i = 0; i < arr.length; i++)
        {
            System.out.println(i + "===" + arr[i]);
        }
    }
}
