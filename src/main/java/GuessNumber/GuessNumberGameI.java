package GuessNumber;

/**
 * Created by ZKY on 2017-08-21 01:30.
 * 1. Num.196 寻找缺失的数
 * <p>
 * 给出一个包含 0 .. N 中 N 个数的序列，找出0 .. N 中没有出现在序列中的那个数。
 * <p>
 * 注意事项
 * <p>
 * 可以改变序列中数的位置。
 * <p>
 * 您在真实的面试中是否遇到过这个题？
 * Yes
 * 样例
 * N = 4 且序列为 [0, 1, 3] 时，缺失的数为2。
 * <p>
 * 1.可以1~n-1求和再减去数组中数字的总和,差值即为缺失的数,但是容易造成溢出.
 * <p>
 * 2.利用异或的性质
 * <p>
 * K^k = 0;
 * 0^k = k;
 * 将所有数两两异或则丢失的那个数就会是异或的结果
 */
public class GuessNumberGameI
{
    public class Solution
    {
        /**
         * @param nums: an array of integers
         * @return: an integer
         */
        public int findMissing(int[] nums)
        {
            // write your code here
            if (nums == null || nums.length == 0)
            {
                return 0;
            }
            int ans = 0;
            for (int i = 0; i < nums.length; i++)
            {
                ans = ans ^ nums[i] ^ i;
            }
            ans = ans ^ (nums.length);
            return ans;
        }
    }
}
