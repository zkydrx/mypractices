package com.leetcode.RemoveDuplicatesFromSortedArray26;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-02-25
 * Time: 22:16:10
 * Description:
 */
class RemoveDuplicatesFromSortedArrayTest
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
    void removeDuplicates()
    {
        RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArray();
        int[] nums = {1,1,2};
        int i = removeDuplicatesFromSortedArray.removeDuplicates(nums);
        int i1 = removeDuplicatesFromSortedArray.removeDuplicatesOne(nums);

        System.out.println(i);
        System.out.println(i1);
    }
}