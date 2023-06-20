package GuessNumber;

/**
 * Created by ZKY on 2017-08-21 01:18. 2.Num.570寻找丢失的数II
 * <p>
 * 给一个由 1 - n 的整数随机组成的一个字符串序列，其中丢失了一个整数，请找到它。
 * <p>
 * 注意事项
 * <p>
 * n <= 30
 * <p>
 * 您在真实的面试中是否遇到过这个题？ Yes 样例 给出 n = 20, str = 19201234567891011121314151618
 * <p>
 * 丢失的数是 17 ，返回这个数。
 * <p>
 * 思路：难点在于给的是字符串而不是数组，对于字符串中的连续两个字符，需要判断是一个数字还是两个数字 看到标签深度优先搜索才想到用深度优先搜索。 注意特殊情况
 * num==0和找到之后不能再继续找下去，所以 ans！=0的时候就直接break
 */
public class GuessNumberGameII {
	public class Solution {
		/**
		 * @param n
		 *            an integer
		 * @param str
		 *            a string with number from 1-n in random order and miss one number
		 * @return an integer
		 */
		int ans;

		public int findMissing2(int n, String str) {
			// Write your code here
			if (str == null || str.length() == 0) {
				return n;
			}
			boolean[] flag = new boolean[n + 1];
			findHelper(flag, n, 0, 0, str);
			return ans;
		}

		public void findHelper(boolean[] flag, int n, int sum, int index, String str) {
			if (index == str.length()) {
				ans = (n + 1) * n / 2 - sum;
				return;
			}
			// 连续的两位字符，判断哪个满足条件
			for (int i = 1; i <= 2; i++) {
				int num = Integer.parseInt(str.substring(index, index + i));
				if (num == 0) {
					break;
				}
				if (num <= n && !flag[num]) {
					flag[num] = true;
					findHelper(flag, n, sum + num, index + 1 + i - 1, str);
					flag[num] = false;
				}
				// 在最后一个字符位置就不需要遍历两字符的情况了 + 找到之后就不需要继续找
				if (index == str.length() - 1 || ans != 0) {
					break;
				}
			}
		}
	}
}
