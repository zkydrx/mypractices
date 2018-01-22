package com.leetcode.HappyNumber202;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-01-21
 * Time: 23:28
 * Description:
 * 202. Happy Number
 * Write an algorithm to determine if a number is "happy".
 * <p>
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the
 * number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will
 * stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1
 * are happy numbers.
 * <p>
 * Example: 19 is a happy number
 * <p>
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * Credits:
 * Special thanks to @mithmatt and @ts for adding this problem and creating all test cases.
 */
public class HappyNumber
{
    public static void main(String[] args)
    {
        HappyNumber happyNumber = new HappyNumber();

        boolean happy = happyNumber.isHappy(19);
        boolean happy1 = happyNumber.isHappy(2);
        System.out.println(happy);
        System.out.println(happy1);

    }

    public boolean isHappy(int n)
    {
        int sum = 0;
        Set<Integer> set = new HashSet<>();
        while (n > 0)
        {
            int temp = n % 10;
            sum += temp * temp;
            n /= 10;


            if (n == 0 && sum != 1)
            {
                n = sum;
                sum = 0;
                set.add(n);
            }
            else if (n == 0 && sum == 1)
            {
                return true;
            }
            else if (set.contains(n))
            {
                return false;
            }
        }
        return true;
    }

}
