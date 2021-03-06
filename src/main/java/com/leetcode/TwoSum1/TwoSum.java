package com.leetcode.TwoSum1;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-12-25
 * Time: 09:32
 * Description:
 * 1. Two Sum
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * Seen this question in a real interview before?  YesNo
 */
public class TwoSum
{
    public static void main(String[] args)
    {
        int[] ints = new TwoSum().twoSum(new int[]{3,2,4}, 6);

        System.out.println(Arrays.toString(ints));
    }

    /**
     * 计算给定数组中两个数的和，使他们的结果等于给定的值。并返回这两个数的位置。
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target)
    {
        int[] result = new int[2];
        here:
        for (int i = 0; i < nums.length; i++)
        {
            for (int i1 = 0; i1 < nums.length; i1++)
            {
                if (i != i1)
                {
                    int temp = nums[i] + nums[i1];
                    if (temp == target)
                    {
                        int max = Math.max(i, i1);
                        int min = Math.min(i, i1);
                        result[0] = min;
                        result[1] = max;
                        break here;
                    }

                }
            }
        }
        return result;
    }
}

