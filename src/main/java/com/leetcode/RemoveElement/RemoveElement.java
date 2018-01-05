package com.leetcode.RemoveElement;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2018-01-05
 * Time: 12:36
 * Description:
 * <p>
 * 27. Remove Element
 * <p>
 * Given an array and a value, remove all instances of that value in-place and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1)
 * extra memory.
 * <p>
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * <p>
 * Example:
 * <p>
 * Given nums = [3,2,2,3], val = 3,
 * <p>
 * Your function should return length = 2, with the first two elements of nums being 2.
 */
public class RemoveElement
{
    public static void main(String[] args)
    {
        RemoveElement removeElement = new RemoveElement();

        int[] num = new int[]{3, 2, 2, 3};
        int i = removeElement.removeElement(num, 3);

        System.out.println(i);
    }

    public int removeElement(int[] nums, int val)
    {
        int count = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] == val)
            {
                count++;
            }
        }
        Set set =new HashSet();
        for (int num : nums)
        {
            set.add(num);
        }



        return count;
    }
}
