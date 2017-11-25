【思路-Java】
采用动态规划实现。用 dp[i] 数组存储第 i 个数的完美平方数。递推式为：dp[i] = Math.max(dp[j] + dp[i-j], dp[i]，认为 i 的完全平方数是从和为 i 的两个完全平方数 dp[j] 和 dp[i-j]之和，然后从中取最小。

原版

    public class Solution {  
         public int numSquares(int n) {  
             int[] dp = new int[n+1];  
             Arrays.fill(dp, Integer.MAX_VALUE);  
             dp[1] = 1;  
             for(int i = 1; i <= n; i++) {  
                 int sqr = (int)Math.sqrt(i);  
                 if(sqr * sqr == i) dp[i] = 1;  //如果 i 本身是个平方数，就将 dp[i] 置1  
                 else {  
                     for(int j = 1; j <= i/2; j++) {  
                         dp[i] = Math.min(dp[j] + dp[i-j], dp[i]);  //从0开始遍历所有和为 i 的 dp，使得 dp[i]取最小  
                     }  
                 }  
             }  
             return dp[n];  
         }  
     }
600 / 600 test cases passed. Runtime: 1109 ms  Your runtime beats 2.15% of javasubmissions.

可以看到上面的时间复杂度太高了，为此需要新的思路
【思路】
依然采用动态规划。我们仔细思考

如图所示，红色部分表示平方数，所有的完美平方数都可以看做一个普通数加上一个完美平方数，那么递推式就变为了：dp[i + j * j] = Math.min(dp[i] + 1, dp[i + j * j])，
显然这种方案减少了不少计算量：

升级版
    
    public class Solution {  
        public int numSquares(int n) {  
            int[] dp = new int[n+1];  
            Arrays.fill(dp, Integer.MAX_VALUE);  
            for(int i = 0; i * i <= n; i++)   
                dp[i * i] = 1;  
            for(int i = 1; i <= n; i++) {  //选定第一个数为 i  
                for(int j = 1; i + j * j <= n; j++) {  //选定另一个数为 j*j  
                    dp[i + j * j] = Math.min(dp[i] + 1, dp[i + j * j]);  //从小到大查找  
                }  
            }  
            return dp[n];  
        }  
    }  

600 / 600 test cases passed. Runtime: 71 ms  Your runtime beats 47.67% of javasubmissions.