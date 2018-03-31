package com.leetcode.MajorityElement169;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created with IntelliJ IDEA.
 * User: zky
 * Date: 2018-03-31
 * Time: 21:39:43
 * Description:
 */
class MajorityElementTest
{

    @BeforeEach
    void setUp()
    {
        System.out.println("String...");
    }

    @AfterEach
    void tearDown()
    {
        System.out.println("endding...");
    }

    @Test
    void majorityElement()
    {
        MajorityElement majorityElement = new MajorityElement();
        int [] nums = {3,2,3};
        int i = majorityElement.majorityElement(nums);

        System.out.println(i);
    }
}