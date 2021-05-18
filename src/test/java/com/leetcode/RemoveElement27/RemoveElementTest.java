package com.leetcode.RemoveElement27;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-02-26
 * Time: 22:57:34
 * Description:
 */
class RemoveElementTest
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
    void removeElement()
    {
        RemoveElement removeElement = new RemoveElement();

        int[] nums = {2, 3, 3, 2};
        int i = removeElement.removeElement(nums, 3);

        System.out.println(i);

    }
}