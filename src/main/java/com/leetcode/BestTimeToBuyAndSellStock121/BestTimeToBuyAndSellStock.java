package com.leetcode.BestTimeToBuyAndSellStock121;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-20
 * Time: 08:55:34
 * Description:
 * <p>
 * <p>
 * 121. Best Time to Buy and Sell Stock
 * <p>
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
 * design an algorithm to find the maximum profit.
 * <p>
 * Example 1:
 * Input: [7, 1, 5, 3, 6, 4]
 * Output: 5
 * <p>
 * max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
 * Example 2:
 * Input: [7, 6, 4, 3, 1]
 * Output: 0
 * <p>
 * In this case, no transaction is done, i.e. max profit = 0.
 *
 * 大概意思：
 * 给你一个股票的每天价格数组prices，你在只能进行一次操作（即一次买入和一次卖出）的限制下，求最大的收益。
 * 比如每天的价格为[7, 1, 5, 3, 6, 4]，那么最大收益就是1的时候买入，6的时候卖出，
 * 这样就能得到最大收益5
 */
public class BestTimeToBuyAndSellStock
{
    public int maxProfit(int[] prices)
    {
        if(prices == null || prices.length <=1)
        {
            return 0;
        }

        int min = prices[0];
        int res = 0;
        for (int i = 0; i < prices.length; i++)
        {
            res = Math.max(res,prices[i]-min);
            min = Math.min(min,prices[i]);
        }

        return res;
    }
}
