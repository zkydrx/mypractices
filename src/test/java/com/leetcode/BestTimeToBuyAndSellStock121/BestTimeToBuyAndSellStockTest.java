package com.leetcode.BestTimeToBuyAndSellStock121;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-20
 * Time: 08:59:23
 * Description:
 */
class BestTimeToBuyAndSellStockTest
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
    void maxProfit()
    {
        BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();

        int[] nums = {7, 6, 4, 3, 1};
        int i = bestTimeToBuyAndSellStock.maxProfit(nums);

        System.out.println(i);
    }
}