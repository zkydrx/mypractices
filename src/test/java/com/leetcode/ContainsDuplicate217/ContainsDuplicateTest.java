package com.leetcode.ContainsDuplicate217;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2018-04-22
 * Time: 23:46:35
 * Description:
 */
class ContainsDuplicateTest
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
    void containsDuplicate()
    {
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();

        int[] nums = {1,2,3,4,4,4,323,2,3,2};
        int[] nums1 = {1,2,3,4,5,6,7,8};

        boolean b = containsDuplicate.containsDuplicate(nums);
        boolean b1 = containsDuplicate.containsDuplicate(nums1);

        System.out.println(b);
        System.out.println(b1);
    }
}