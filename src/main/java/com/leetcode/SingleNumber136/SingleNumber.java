package com.leetcode.SingleNumber136;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-02-04
 * Time: 21:12:23
 * Description:
 * 136. Single Number
 * <p>
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * <p>
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class SingleNumber
{
    /**
     * 无法通过验证。如果超20000提示java code to large.
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums)
    {
        Arrays.sort(nums);
        int result = 0;
        if (nums.length > 1)
        {
            for (int i = 0; i < nums.length - 1; i++)
            {
                if (i % 2 == 0)
                {
                    if (nums[i] == nums[i + 1])
                    {
                        continue;
                    }
                    else
                    {
                        result = nums[i];
                        break;
                    }

                }
            }
        }
        else if (nums.length == 1)
        {
            result = nums[0];
        }

        return result;
    }

    public int getSingleNumber(int num1, int num2)
    {
        int result = 0;
        if (num1 != num2)
        {
            result = num1;

        }

        return result;
    }


    /**
     * Perfect
     * @param nums
     * @return
     */
    public int singleNumberOne(int [] nums)
    {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++)
        {
            result = result ^ nums[i];
        }

        return result;
    }
}
