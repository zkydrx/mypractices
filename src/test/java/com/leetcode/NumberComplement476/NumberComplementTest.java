package com.leetcode.NumberComplement476;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-02-11
 * Time: 19:12:48
 * Description:
 */
class NumberComplementTest
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
    void findComplement()
    {
        NumberComplement numberComplement = new NumberComplement();

        int complement = numberComplement.findComplement(5);

        System.out.println(complement);

        int i = Integer.highestOneBit(5);

        System.out.println(i);

        int i1 = Integer.highestOneBit(3);

        System.out.println(i1);
    }
}