package com.leetcode.NumberOf1Bits191;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-01-27
 * Time: 22:42:42
 * Description:
 * 191. Number of 1 Bits
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the
 * Hamming weight).
 * <p>
 * For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function
 * should return 3.
 * <p>
 * Credits:
 * Special thanks to @ts for adding this problem and creating all test cases.
 */
public class NumberOf1Bits
{
    public static void main(String[] args)
    {
        int i = new NumberOf1Bits().hammingWeight(3);
        System.out.println(i);
    }

    //    public int hammingWeight(int n)
    //    {
    //        int count = 0;
    //        while (n > 0)
    //        {
    //            count += n & 1;
    //            n >>= 1;
    //        }
    //        return count;
    //    }
    //
    //    public int hammingWeightOne(int n)
    //    {
    //        int count = 0;
    //        while (n > 0)
    //        {
    //            n &=(n-1);
    //            count++;
    //        }
    //        return count;
    //    }


    public int hammingWeight(int n)
    {
        int count = 0;
        for (int i = 1; i < 33; i++)
        {
            if (getBit(n, i) == true)
            {
                count++;
            }
        }
        return count;
    }

    public boolean getBit(int n, int i)
    {
        return (n & (1 << i)) != 0;
    }
}
