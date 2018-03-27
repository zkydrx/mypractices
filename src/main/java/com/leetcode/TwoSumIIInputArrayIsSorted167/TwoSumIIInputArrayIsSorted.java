package com.leetcode.TwoSumIIInputArrayIsSorted167;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-27
 * Time: 23:59:57
 * Description:
 * 167. Two Sum II - Input array is sorted
 * <p>
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a
 * specific target number.
 * <p>
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1
 * must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 * <p>
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * <p>
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */
public class TwoSumIIInputArrayIsSorted
{
    /**
     * This method was  Time Limit Exceeded
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target)
    {
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < numbers.length - 1; i++)
        {
            for (int i1 = i + 1; i1 < numbers.length; i1++)
            {
                if (numbers[i] + numbers[i1] == target)
                {
                    index1 = i + 1;
                    index2 = i1 + 1;
                }
            }
        }

        int[] result = new int[2];
        result[0] = index1;
        result[1] = index2;
        return result;
    }

    /**
     * The method was test Passed.
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSumOne(int[] numbers,int target)
    {
        if(numbers == null||numbers.length == 0)
        {
            return null;
        }

        int i = 0;
        int j = numbers.length-1;
        while (i < j)
        {
            int x = numbers[i]+numbers[j];
            if(x < target)
            {
                ++i;
            }
            else if( x > target)
            {
                --j;
            }
            else
            {
                return new int[]{i+1,j+1};
            }
        }
        return null;
    }

}
