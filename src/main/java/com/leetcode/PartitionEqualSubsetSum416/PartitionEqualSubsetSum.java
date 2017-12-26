package com.leetcode.PartitionEqualSubsetSum416;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-12-25
 * Time: 10:05
 * Description:
 * 416. Partition Equal Subset Sum
 * <p>
 * Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets
 * such that the sum of elements in both subsets is equal.
 * <p>
 * Note:
 * Each of the array element will not exceed 100.
 * The array size will not exceed 200.
 * Example 1:
 * <p>
 * Input: [1, 5, 11, 5]
 * <p>
 * Output: true
 * <p>
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * Example 2:
 * <p>
 * Input: [1, 2, 3, 5]
 * <p>
 * Output: false
 * <p>
 * Explanation: The array cannot be partitioned into equal sum subsets.
 * Seen this question in a real interview before?
 */
public class PartitionEqualSubsetSum
{
    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args)
    {
        boolean b = new PartitionEqualSubsetSum().canPartition(new int[]{1, 5, 11, 5});
        boolean b1 = new PartitionEqualSubsetSum().canPartition(new int[]{1, 2, 3, 5});
        boolean b2 = new PartitionEqualSubsetSum().canPartition(new int[]{1, 2, 5});
        boolean b3 = new PartitionEqualSubsetSum().canPartition(new int[]{1, 1});
        System.out.println(b);
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
        new PartitionEqualSubsetSum().backPack(new int[]{1, 5, 11, 5, 3, 3, 5, 1, 4, 23, 22, 1});
    }

    /**
     * 那个这个数组的所有和一定是个偶数才能满足条件。
     * 这样问题就简单很多。
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums)
    {
        long sum = 0;
        boolean b = true;
        for (int i = 0; i < nums.length; i++)
        {
            sum += nums[i];
        }
        long temp = sum / 2;

        if (sum % 2 == 0)
        {
            int count = 0;
            for (int i = 0; i < nums.length; i++)
            {
                /**
                 * 问题是不一定有一个数单独分为一组。
                 * 也就是说每组数的个数不能确定。
                 */
                if (nums[i] == temp)
                {
                    count++;
                }
            }
            if (count != 1 && count != 2)
            {
                b = false;
            }
        }
        else
        {
            b = false;
        }
        return b;
    }


    /**
     * 背包问题（动态规划)
     * 有bug,对于{3,3,3,4,5}
     * 无法给出正确解答。
     *
     * @param nums
     */
    public void backPack(int[] nums)
    {
        Arrays.sort(nums);

        int[] b = new int[nums.length];
        int[] c = new int[nums.length];

        int[] d = new int[nums.length];
        int emp = 0;
        int dmp = 0;
        int count = 0;
        b[0] = nums[nums.length - 1];
        c[0] = nums[nums.length - 2];
        for (int i = 0; i < nums.length - 2; i++)
        {
            emp += b[i];
            dmp += c[i];
            if (emp > dmp)
            {
                c[i + 1] = nums[i];
            }
            else
            {
                b[i + 1] = nums[i];
            }
        }

        for (int i = 0; i < b.length; i++)
        {
            if (b[i] == 0)
            {
                count++;
            }
            else
            {
                d[i] = b[i];
                System.out.println(d[i]);
            }
        }
    }

}
