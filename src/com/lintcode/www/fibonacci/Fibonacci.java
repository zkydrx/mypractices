package com.lintcode.www.fibonacci;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-09-13
 * Time: 21:53
 * Description:
 * 查找斐波纳契数列中第 N 个数。
 * <p>
 * 所谓的斐波纳契数列是指：
 * <p>
 * 前2个数是 0 和 1 。
 * 第 i 个数是第 i-1 个数和第i-2 个数的和。
 * 斐波纳契数列的前10个数字是：
 * <p>
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34 ...
 */
public class Fibonacci
{
    public int getFibonacci(int i)
    {
        int f1 = 0;
        int f2 = 1;
        int temp = 0;
        for (int j = 0; j < i; j++)
        {
            temp = f1;
            f1 = f1 + f2;
            f2 = temp;
        }
        return f1;
    }

    public static void main(String[] args)
    {
        Fibonacci f = new Fibonacci();
        System.out.println(f.getFibonacci(0));
        System.out.println(f.getFibonacci(1));
        System.out.println(f.getFibonacci(2));
        System.out.println(f.getFibonacci(3));
        System.out.println(f.getFibonacci(4));
        System.out.println(f.getFibonacci(5));
    }
}
