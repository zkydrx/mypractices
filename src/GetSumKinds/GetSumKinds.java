package GetSumKinds;

import org.junit.jupiter.api.Test;

/**
 * Created by ZKY on 2017-06-15 20:31.
 * 给定n个不同的正整数，整数k（k < = n）以及一个目标数字。
 * <p>
 * 在这n个数里面找出K个数，使得这K个数的和等于目标数字，求问有多少种方案？
 * 样例
 * 给出[1,2,3,4]，k=2， target=5，[1,4] and [2,3]是2个符合要求的方案
 */
public class GetSumKinds
{
    public int kSum(int A[], int k, int target)
    {
        // write your code here
        int len = A.length;

        int[][][] dp = new int[len + 1][k + 1][target + 1];

        for (int i = 0; i < len; ++i)
        {
            if (A[i] <= target)
            {
                for (int j = i + 1; j <= len; ++j)
                {
                    dp[j][1][A[i]] = 1;
                }

            }

        }

        for (int i = 1; i <= len; ++i)
        {
            for (int j = 2; j <= k && j <= i; ++j)
            {
                for (int s = 1; s <= target; ++s)
                {
                    dp[i][j][s] = dp[i - 1][j][s] + (s > A[i - 1] ? dp[i - 1][j - 1][s - A[i - 1]] : 0);
                }
            }

        }
        return dp[len][k][target];
    }

    @Test
    public void testKSum()
    {
        int[] a = {1, 2, 3, 4};
        int[] b = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 11, 12, 13, 14, 15, 16, 17, 18, 19};
        int i = kSum(a, 2, 5);
        int j = kSum(b, 4, 19);
        System.out.println(i);
        System.out.println(j);
    }

}
