package wanMeiPingFang;

/**
 * Created by ZKY on 2017-08-20 01:06.
 * <p>
 * <p>
 * 给一个正整数 n, 找到若干个完全平方数(比如1, 4, 9, ... )使得他们的和等于 n。你需要让平方数的个数最少。
 * 样例
 * 给出 n = 12, 返回 3 因为 12 = 4 + 4 + 4。
 * 给出 n = 13, 返回 2 因为 13 = 4 + 9。
 */
public class PerfectPow
{

    /**
     * 把每一个数换成是平方数和的个数。
     * @param n
     * @return
     */
    public int numSquares(int n)
    {
        int[] dp = new int[n + 1];
        for (int i = 0; i < n + 1; ++i)
        {
            dp[i] = i;
        }
        for (int i = 0; i < n + 1; ++i)
        {
            for (int j = 2; j <= Math.sqrt(i); ++j)
            {
                if (j * j == i)
                {
                    dp[i] = 1;
                    break;
                }
                /**
                 * 所有的精髓都在这个表达式中。简约，精巧。
                 */
                dp[i] = Math.min(dp[i], 1 + dp[i - j * j]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args)
    {
        PerfectPow perfectPow = new PerfectPow();
        int i = perfectPow.numSquares(10);
        System.out.println(i);
    }
}
