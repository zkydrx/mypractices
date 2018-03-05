package com.leetcode.ClimbingStairs70;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-04
 * Time: 20:20:39
 * Description:
 */
class ClimbingStairTest
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
    void climbStairs()
    {
        ClimbingStair climbingStair = new ClimbingStair();

        int i = climbingStair.climbStairs(4);

        System.out.println(i);
    }
}