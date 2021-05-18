package com.leetcode.ContainsDuplicateII219;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2018-04-24
 * Time: 21:55:01
 * Description:
 */
class ContainsDuplicateIITest
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
    void containsNearbyDuplicate()
    {
        ContainsDuplicateII containsDuplicateII = new ContainsDuplicateII();

        int[] nums = {1, 2, 3, 4, 5, 6, 7, 3, 4, 5, 6};

        boolean b = containsDuplicateII.containsNearbyDuplicate(nums, 5);

        System.out.println(b);
    }
}