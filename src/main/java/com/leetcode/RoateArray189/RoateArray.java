package com.leetcode.RoateArray189;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2018-04-09
 * Time: 23:56:32
 * Description:
 * 189. Rotate Array
 * <p>
 * Rotate an array of n elements to the right by k steps.
 * <p>
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * <p>
 * Note:
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * <p>
 * [show hint]
 * <p>
 * Related problem: Reverse Words in a String II
 * <p>
 * Credits:
 * Special thanks to @Freezen for adding this problem and creating all test cases.
 *
 */
public class RoateArray
{

    public void rotate(int[] nums, int k)
    {
        if(k > nums.length)
        {
            k = k%nums.length;
        }
        int [] result = new int[nums.length];
        for (int i = 0; i < k; i++)
        {
            result[i] = nums[nums.length-k+i];
        }

        int j = 0;
        for (int i = k; i < nums.length ; i++)
        {
            result[i] = nums[j];
            j++;
        }
        System.arraycopy(result,0,nums,0,nums.length);
    }
}
