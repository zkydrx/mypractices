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
 * <p>
 * <p>
 * 这道题会给一个长度为n的数组，这个数组里面包含1-n的数字，数字的分布并不均匀，数字可以出现0-n次
 * <p>
 * 所以这个数组中可能并不完全包含1-n中的所有数字，现在需要你在常数时间和不用额外空间的情况下找出那些数字没有出现过
 * <p>
 * 解题思想是，遍历两轮：
 * 1、第一轮将每个数字对应的那个位置的数字变成负值（因为所有数都是正的，这么做不影响后续）
 * 2、第二轮，统计那些没有变成负值的，这些就是没有出现过的数
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
