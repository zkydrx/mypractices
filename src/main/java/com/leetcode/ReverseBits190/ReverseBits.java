package com.leetcode.ReverseBits190;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2018-04-11
 * Time: 20:22:30
 * Description:
 * 190. Reverse Bits
 * Reverse bits of a given 32 bits unsigned integer.
 * <p>
 * For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192
 * (represented in binary as 00111001011110000010100101000000).
 * <p>
 * Follow up:
 * If this function is called many times, how would you optimize it?
 * <p>
 * Related problem: Reverse Integer
 * <p>
 * Credits:
 * Special thanks to @ts for adding this problem and creating all test cases.
 */
public class ReverseBits
{
    // you need treat n as an unsigned value
    public int reverseBits(int n)
    {
        int rev = 0;
        for (int i = 0; i < 32 && n != 0; ++i)
        {
            rev |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return rev;
    }

    @Test
    public void test()
    {
        int i = reverseBits(15);
        System.out.println(i);
    }

}
