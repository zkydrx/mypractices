package com.leetcode.PartitionEqualSubsetSum416;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-12-26
 * Time: 16:04
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
public class PartitionEqualsSubSetSumFromInternet
{

    /**
     * A utility function that returns true if there is a
     * subset of arr[] with sun equal to given sum
     * This is a recursion.
     */
    static boolean isSubsetSum(int arr[], int n, int sum)
    {
        // Base Cases
        if (sum == 0)
        {
            return true;
        }
        if (n == 0 && sum != 0)
        {
            return false;
        }

        // If last element is greater than sum, then ignore it
        if (arr[n - 1] > sum)
        {
            return isSubsetSum(arr, n - 1, sum);
        }

        /* else, check if sum can be obtained by any of
           the following
        (a) including the last element
        (b) excluding the last element
        */
        return isSubsetSum(arr, n - 1, sum) || isSubsetSum(arr, n - 1, sum - arr[n - 1]);
    }

    /**
     * Returns true if arr[] can be partitioned in two
     * subsets of equal sum, otherwise false
     *
     * @param arr

     * @return
     */
    public static boolean findPartition(int arr[])
    {
        // Calculate sum of the elements in array
        int sum = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++)
        {
            sum += arr[i];
        }

        // If sum is odd, there cannot be two subsets
        // with equal sum
        if (sum % 2 != 0)
        {
            return false;
        }

        // Find if there is subset with sum equal to half
        // of total sum
        return isSubsetSum(arr, n, sum / 2);
    }

    /**
     * Driver function to check for above function
     */
    public static void main(String[] args)
    {

        int arr[] = {3, 3, 3, 4, 5};
        int n = arr.length;
        if (findPartition(arr, n) == true)
        {
            System.out.println(true);
            System.out.println("Can be divided into two subsets of equal sum");
        }
        else
        {
            System.out.println(false);
            System.out.println("Can not be divided into two subsets of equal sum");
        }
    }


}
