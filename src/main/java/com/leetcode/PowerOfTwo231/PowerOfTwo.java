package com.leetcode.PowerOfTwo231;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-01-18
 * Time: 16:51
 * Description:
 * <p>
 * 231. Power of Two
 * Given an integer, write a function to determine if it is a power of two.
 */
public class PowerOfTwo
{
    public static void main(String[] args)
    {
        PowerOfTwo powerOfTwo = new PowerOfTwo();

        boolean powerOfTwo1 = powerOfTwo.isPowerOfTwo(8);

        System.out.println(powerOfTwo1);
    }

    public boolean isPowerOfTwo(int n)
    {
        if (n != 0)
        {
            while (n % 2 == 0)
            {
                n /= 2;
            }
        }
        return n == 1;
    }
}
