package com.leetcode.FactorialTrailingZeroes172;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2018-04-04
 * Time: 09:52:59
 * Description:
 * 172. Factorial Trailing Zeroes
 * Given an integer n, return the number of trailing zeroes in n!.
 * <p>
 * Note: Your solution should be in logarithmic time complexity.
 * <p>
 * Credits:
 * Special thanks to @ts for adding this problem and creating all test cases.
 */
public class FactorialTrailingZeroes
{
    public int trailingZeroes(int n)
    {
        if(n < 0)
        {
            return  -1;
        }
        int count = 0;
        for (long i = 5; n/i >=1 ; i*=5)
        {
            count+=n/i;
        }

        return count;
    }
}
