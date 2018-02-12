package com.leetcode.FindAllNumbersDisappearedInAnArray448;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-02-12
 * Time: 19:10:54
 * Description:
 * <p>
 * 448. Find All Numbers Disappeared in an Array
 * <p>
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * <p>
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * <p>
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra
 * space.
 * <p>
 * Example:
 * <p>
 * Input:
 * [4,3,2,7,8,2,3,1]
 * <p>
 * Output:
 * [5,6]
 */
public class FindAllNumbersDisappearedInAnArray
{
    public List<Integer> findDisappearedNumbers(int[] nums)
    {
        List<Integer> ret = new ArrayList<Integer>();

        for (int i = 0; i < nums.length; i++)
        {
            int val = Math.abs(nums[i]) - 1;
            if (nums[val] > 0)
            {
                nums[val] = -nums[val];
            }
        }

        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] > 0)
            {
                ret.add(i + 1);
            }
        }
        return ret;
    }
}
