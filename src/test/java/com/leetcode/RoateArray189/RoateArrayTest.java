package com.leetcode.RoateArray189;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created with IntelliJ IDEA.
 * Author: zhouky
 * Date: 2018/4/10
 * Time: 15:11:58
 * Description:
 */
class RoateArrayTest
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
    void rotate()
    {
        RoateArray roateArray = new RoateArray();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        roateArray.rotate(nums, 3);
        for (int num : nums)
        {
            System.out.print(num + "\t");

        }
        System.out.println();
    }
}