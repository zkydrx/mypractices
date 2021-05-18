package com.leetcode.SearchInsertPosition35;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-02-13
 * Time: 21:00:57
 * Description:
 * <p>
 * 35. Search Insert Position
 * <p>
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where
 * it would be if it were inserted in order.
 * <p>
 * You may assume no duplicates in the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,3,5,6], 5
 * Output: 2
 * Example 2:
 * <p>
 * Input: [1,3,5,6], 2
 * Output: 1
 * Example 3:
 * <p>
 * Input: [1,3,5,6], 7
 * Output: 4
 * Example 1:
 * <p>
 * Input: [1,3,5,6], 0
 * Output: 0
 */
public class SearchInsertPosition
{
    public int searchInsert(int[] nums, int target)
    {
        int res = -1;

        boolean boo = false;
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] == target)
            {
                res = i;
                break;
            }
        }
        if (res == -1)
        {
            boo = true;
        }

        if (boo)
        {

            int[] arr1 = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++)
            {
                arr1[i] = nums[i];
            }

            arr1[nums.length] = target;

            Arrays.sort(arr1);

            for (int i = 0; i < arr1.length; i++)
            {
                if (arr1[i] == target)
                {
                    res = i;
                }
            }

        }
        return res;
    }
}
