package com.leetcode.ClimbingStairs70;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-02
 * Time: 15:58:30
 * Description:
 * <p>
 * 322. Climbing Stairs
 * <p>
 * <p>
 * <p>
 * You are climbing a stair case. It takes n steps to reach to the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Note: Given n will be a positive integer.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: 2
 * Output:  2
 * Explanation:  There are two ways to climb to the top.
 * <p>
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 * <p>
 * Input: 3
 * Output:  3
 * Explanation:  There are three ways to climb to the top.
 * <p>
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */
public class ClimbingStair
{
    public int climbStairs(int n)
    {
        if (n <= 1)
        {
            return n;
        }
        int prev = 1;
        int cur = 1;
        /**
         * 费氏数列
         * n = 1， result = 1
         * n = 2, result = 1+1 (爬1阶两次 + 一次爬2阶)
         * n = 3, result = 1+2 (前面两个case相加)
         * n = 4, result = 3+2 (前面两个case相加)
         * f(n) = f(n-1) + f(n-2)
         */
        for (int i = 2; i <= n; i++)
        {
            int temp = cur;
            cur = cur + prev;
            prev = temp;
        }
        return cur;
    }
}
