package com.leetcode.MaximumSubarray53;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-02-28
 * Time: 08:59:32
 * Description:
 */
class MaximumSubarrayTest
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
    void maxSubArray()
    {
        MaximumSubarray maximumSubarray = new MaximumSubarray();

        int[] nums = {-2, -3, 4, -1, -2, 1, 5, -3};
        int i = maximumSubarray.maxSubArray(nums);

        System.out.println(i);
    }
}