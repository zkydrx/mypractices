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
 * <p>
 * <p>
 * 该解法时间复杂度太大
 * 0.0
 * my method use time:5206
 * 0.0
 * Math.pow() time:0
 * <p>
 * Process finished with exit code 0
 */
public class ImplementPow
{
    public double myPow(double x, int n)
    {
        double result = 1.0;
        if (n < 0)
        {
            int temp = -n;
            for (int i = 0; i < temp; i++)
            {
                result *= x;
            }

            result = 1.0 / result;
        }
        else
        {
            for (int i = 0; i < n; i++)
            {
                result *= x;
            }

        }

        return result;
    }

    public static void main(String[] args)
    {
        ImplementPow implementPow = new ImplementPow();

        long l = System.currentTimeMillis();
        double v = implementPow.myPow(0.00001, 2147483647);
        l = System.currentTimeMillis() - l;
        System.out.println(v);
        System.out.println("my method use time:" + l);

        l = System.currentTimeMillis();
        double pow = Math.pow(0.00001, 2147483647);

        System.out.println(pow);
        l = System.currentTimeMillis() - l;
        System.out.println("Math.pow() time:" + l);
        Math.sqrt(123);
    }
}
