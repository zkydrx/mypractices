package com.leetcode.ContainsDuplicate217;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2018-04-22
 * Time: 23:31:25
 * Description:
 * <p>
 * 217. Contains Duplicate
 * <p>
 * Given an array of integers, find if the array contains any duplicates. Your function should return true if any
 * value appears at least twice in the array, and it should return false if every element is distinct.
 */
public class ContainsDuplicate
{
    public boolean containsDuplicate(int[] nums)
    {
        if(nums==null||nums.length==0||nums.length==1)
        {
            return false;
        }
        Arrays.sort(nums);

        for (int i = 0; i < nums.length-1; i++)
        {
            if(nums[i]==nums[i+1])
            {
                return true;
            }
        }

        return false;
    }
}
