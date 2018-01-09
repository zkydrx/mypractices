package com.leetcode.Sqrt69;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2018-01-09
 * Time: 17:21
 * Description:
 * <p>
 * 69. Sqrt(x)
 * Implement int sqrt(int x).
 * <p>
 * Compute and return the square root of x.
 * <p>
 * x is guaranteed to be a non-negative integer.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: 4
 * Output: 2
 * Example 2:
 * <p>
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since we want to return an integer, the decimal part will
 */
public class ImplementSqrt
{
    public static void main(String[] args)
    {
        int i = new ImplementSqrt().mySqrt(8);

        System.out.println(i);
    }

    public int mySqrt(int x)
    {
        double sqrt = Math.sqrt(x);

        return (int) sqrt;
    }
}
