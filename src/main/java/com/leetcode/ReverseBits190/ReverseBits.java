package com.leetcode.ReverseBits190;

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
        for (int i = 0; i < 16; i++)
        {
            n = swapBits(n, i, 32 - i - 1);

        }
        return n;
    }

    public int swapBits(int n, int i, int j)
    {
        int a = (n >> i) & 1;
        int b = (n >> j) & 1;
        if ((a ^ b) != 0)
        {
            return n ^= (1 << i) | (1 << j);
        }
        return n;
    }
}
