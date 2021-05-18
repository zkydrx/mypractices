package com.leetcode.MaximumSubarray53;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-02-28
 * Time: 00:23:54
 * Description:
 * <p>
 * 53. Maximum Subarray
 * <p>
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * <p>
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 * <p>
 * click to show more practice.
 */
public class MaximumSubarray
{
    public int maxSubArray(int[] nums)
    {
        int size = nums.length;
        int max_so_far = Integer.MIN_VALUE;
        int max_ending_here = 0;
        for (int i = 0; i < size; i++)
        {
            max_ending_here = max_ending_here + nums[i];
            if (max_so_far < max_ending_here)
            {
                max_so_far = max_ending_here;
            }
            if (max_ending_here < 0)
            {
                max_ending_here = 0;
            }

        }
        return max_so_far;
    }
}
