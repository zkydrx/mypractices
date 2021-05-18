package com.leetcode.TwoSumIIInputArrayIsSorted167;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-28
 * Time: 00:18:57
 * Description:
 */
class TwoSumIIInputArrayIsSortedTest
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
    void twoSum()
    {
        TwoSumIIInputArrayIsSorted twoSumIIInputArrayIsSorted = new TwoSumIIInputArrayIsSorted();
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        int[] ints = twoSumIIInputArrayIsSorted.twoSum(a, 7);

        for (int anInt : ints)
        {
            System.out.print(anInt + "\t");
        }
        System.out.println();
    }

    @Test
    void twoSumOne()
    {
        TwoSumIIInputArrayIsSorted twoSumIIInputArrayIsSorted = new TwoSumIIInputArrayIsSorted();
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        int[] ints = twoSumIIInputArrayIsSorted.twoSumOne(a, 7);

        for (int anInt : ints)
        {
            System.out.print(anInt + "\t");
        }
        System.out.println();
    }
}