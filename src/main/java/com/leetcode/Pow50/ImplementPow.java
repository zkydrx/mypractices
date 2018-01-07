package com.leetcode.Pow50;

/**
 * Created with IntelliJ IDEA.
 * User: zky
 * Date: 1/7/18
 * Time: 11:46 PM
 * Description:
 * 50. Pow(x, n)
 * <p>
 * Implement pow(x, n).
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: 2.00000, 10
 * Output: 1024.00000
 * Example 2:
 * <p>
 * Input: 2.10000, 3
 * Output: 9.26100
 */
public class ImplementPow
{
    public double myPow(double x, int n)
    {
        double result = 1.0;
        for (int i = 0; i < n; i++)
        {
            result *= x;
        }

        return result;
    }

    public static void main(String[] args)
    {
        ImplementPow implementPow = new ImplementPow();

        double v = implementPow.myPow(2, 3);
        System.out.println(v);
    }
}
