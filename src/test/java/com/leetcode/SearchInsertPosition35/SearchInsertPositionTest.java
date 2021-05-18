package com.leetcode.SearchInsertPosition35;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-02-13
 * Time: 21:16:11
 * Description:
 */
class SearchInsertPositionTest
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
    void searchInsert()
    {
        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();

        int[] nums = {1, 3, 5, 6};
        int[] nums1 = {1, 3, 5, 6};
        int i = searchInsertPosition.searchInsert(nums, 2);
        int i1 = searchInsertPosition.searchInsert(nums1, 5);


        System.out.println(i);
        System.out.println(i1);
    }
}