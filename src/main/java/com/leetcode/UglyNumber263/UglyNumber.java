package com.leetcode.UglyNumber263;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-01-22
 * Time: 15:55
 * Description:
 * 263. Ugly Number
 * <p>
 * Write a program to check whether a given number is an ugly number.
 * <p>
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is
 * not ugly since it includes another prime factor 7.
 * <p>
 * Note that 1 is typically treated as an ugly number.
 * <p>
 * Credits:
 * Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
 */
public class UglyNumber
{
    public static void main(String[] args)
    {
        boolean ugly = new UglyNumber().isUgly(12345);

        System.out.println(ugly);
    }

    public boolean isUgly(int num)
    {
        if (num > 0)
        {
            while (num % 2 == 0)
            {
                num /= 2;
            }
            while (num % 3 == 0)
            {
                num /= 3;
            }
            while (num % 5 == 0)
            {
                num /= 5;
            }
        }
        return num == 1;
    }
}
