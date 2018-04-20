package com.leetcode.HouseRobber198;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2018-04-20
 * Time: 21:53:34
 * Description:
 */
class HouseRobberTest
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
    void rob()
    {
        HouseRobber houseRobber = new HouseRobber();
        int [] nums = {50,1,1,50};
        int rob = houseRobber.rob(nums);

        System.out.println(rob);
    }
}