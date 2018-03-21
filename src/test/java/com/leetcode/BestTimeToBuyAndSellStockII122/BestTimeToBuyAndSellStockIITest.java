package com.leetcode.BestTimeToBuyAndSellStockII122;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-21
 * Time: 09:27:43
 * Description:
 */
class BestTimeToBuyAndSellStockIITest
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
        BestTimeToBuyAndSellStockII bestTimeToBuyAndSellStockII = new BestTimeToBuyAndSellStockII();

        int[] num = {1,4,6,3,7,9,4,6,9};
        int i = bestTimeToBuyAndSellStockII.maxProfit(num);

        System.out.println(i);
    }
}