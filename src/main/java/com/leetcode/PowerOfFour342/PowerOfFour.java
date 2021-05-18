package com.leetcode.PowerOfFour342;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-01-30
 * Time: 00:39:59
 * Description:
 * 342. Power of Four
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 * <p>
 * Example:
 * Given num = 16, return true. Given num = 5, return false.
 * <p>
 * Follow up: Could you solve it without loops/recursion?
 * <p>
 * Credits:
 * Special thanks to @yukuairoy for adding this problem and creating all test cases.
 */
public class PowerOfFour
{
    public static void main(String[] args)
    {
        boolean powerOfFour = new PowerOfFour().isPowerOfFour(16);

        System.out.println(powerOfFour);

        System.out.println("中国人民");

    }

    public boolean isPowerOfFour(int num)
    {
        while (num > 1)
        {
            if (num % 4 == 0)
            {
                num /= 4;
            }
            else
            {
                break;
            }
        }

        return num == 1;
    }
}
