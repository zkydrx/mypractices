package com.leetcode.MergeSortedArray88;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-07
 * Time: 09:26:26
 * Description:
 */
class MergeSortedArrayTest
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
    void merge()
    {
        MergeSortedArray mergeSortedArray = new MergeSortedArray();

        int[] nums1 = {1, 2, 3, 5, 7, 0, 0, 0, 0, 0, 0, 0};
        int[] nums2 = {2, 3, 6, 7, 8, 9, 10};
        mergeSortedArray.merge(nums1, 5, nums2, 7);
        for (int i : nums1)
        {
            System.out.println(i);
        }
    }
}