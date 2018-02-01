package com.leetcode.MinimumIndexSumOfTwoLists599;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-02-02
 * Time: 00:51:56
 * Description:
 */
class MinimumIndexSumOfTwoListsTest
{

    @BeforeEach
    void setUp()
    {
        System.out.println("Starting...");
    }

    @AfterEach
    void tearDown()
    {
        System.out.println("Ending...");
    }

    @Test
    void findRestaurant()
    {
        String[] strings1= {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] strings2= {"KFC", "Shogun", "Burger King"};
        String[] restaurant = new MinimumIndexSumOfTwoLists().findRestaurant(strings1, strings2);

        System.out.println(Arrays.toString(restaurant));

    }
}