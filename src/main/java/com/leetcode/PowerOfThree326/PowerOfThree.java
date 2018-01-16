package com.leetcode.PowerOfThree326;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-01-16
 * Time: 23:13
 * Description:
 * 326. Power of Three
 * Given an integer, write a function to determine if it is a power of three.
 * <p>
 * Follow up:
 * Could you do it without using any loop / recursion?
 */
public class PowerOfThree
{
    public static void main(String[] args)
    {
        boolean powerOfThree = new PowerOfThree().isPowerOfThree(9);

        System.out.println(powerOfThree);
    }

    public boolean isPowerOfThree(int n)
    {

        if (n != 0)
        {
            while (n % 3 == 0)
            {
                n /= 3;
            }
        }
        return n == 1;

    }
}
