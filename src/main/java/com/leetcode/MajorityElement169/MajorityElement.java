package com.leetcode.MajorityElement169;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: zky
 * Date: 3/31/18
 * Time: 9:10 PM
 * Description:
 * <p>
 * 169. Majority Element
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊
 * n/2 ⌋ times.
 * <p>
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * <p>
 * Credits:
 * Special thanks to @ts for adding this problem and creating all test cases.
 */
public class MajorityElement
{
    public int majorityElement(int[] nums)
    {
        if (nums.length == 1)
        {
            return nums[0];
        }
        int n = nums.length;
        Arrays.sort(nums);
        int prev = nums[0];
        /**
         * init the element's number.
         */
        int count = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] == prev)
            {
                count++;
                if (count > n / 2)
                {
                    return prev;
                }
            }
            else
            {
                /**
                 * reset the count's value and the prev's value.
                 */
                count = 1;
                prev = nums[i];
            }
        }

        return 0;
    }
}
