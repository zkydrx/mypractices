package com.leetcode.ReverseBits190;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2018-04-11
 * Time: 20:32:53
 * Description:
 */
class ReverseBitsTest
{

    @BeforeEach
    void setUp()
    {
        System.out.println("String...");
    }

    @AfterEach
    void tearDown()
    {
        System.out.println("Ending...");
    }

    @Test
    void reverseBits()
    {
        ReverseBits reverseBits = new ReverseBits();

        int i = reverseBits.reverseBits(43261596);

        System.out.println(i);
    }

    @Test
    void swapBits()
    {
    }
}