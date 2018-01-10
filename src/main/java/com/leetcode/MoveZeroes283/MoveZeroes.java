package com.leetcode.MoveZeroes283;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2018-01-10
 * Time: 20:39
 * Description:
 * <p>
 * 283. Move Zeroes
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the
 * non-zero elements.
 * <p>
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 * <p>
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 * Credits:
 * Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
 */
public class MoveZeroes
{
    public static void main(String[] args)
    {
        MoveZeroes moveZeroes = new MoveZeroes();

        int[] nums = new int[]{0, 1, 0, 3, 12};
        moveZeroes.moveZeroes(nums);
    }

    public void moveZeroes(int[] nums)
    {
        int[] num1 = new int[nums.length];
        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] == 0)
            {
                list.add(0);
            }
            else
            {
                list1.add(nums[i]);
            }
        }
        list1.addAll(list);

        System.out.println(Arrays.toString(list1.toArray()));
    }

}
