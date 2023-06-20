package com.lintcode.www.GuessNumberGame;

/**
 * Created with IntelliJ IDEA. User: Abbot Date: 2017-10-03 Time: 19:33
 * Description:
 * <p>
 * We are playing the Guess Game. The game is as follows:
 * <p>
 * I pick a number from 1 to n. You have to guess which number I picked.
 * <p>
 * Every time you guess wrong, I'll tell you whether the number is higher or
 * lower.
 * <p>
 * You call a pre-defined API guess(int num) which returns 3 possible results
 * (-1, 1, or 0):
 * <p>
 * <p>
 * Example n = 10, I pick 4 (but you don't know)
 * <p>
 * Return 4. Correct !
 */
public class Solution extends GuessGameImpl {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int s = solution.guessNumber(34);
		System.out.println(s);
		System.out.println(16 >> 2);
	}

	public int guessNumber(int n) {
		int L = 1;
		int R = n;
		while (L <= R) {
			/**
			 * 二分法的变相使用。 最小值加上最大值与最小值差的一半。
			 */
			int mid = L + ((R - L) >> 1);
			int guess = guess(mid);
			/**
			 * 如果这个值跟给出的数相等。那么直接返回该数。
			 */
			if (guess == 0) {
				return mid;
			}
			/**
			 * 如果该数比猜的数小返回1.
			 */
			else if (guess == 1) {
				L = mid + 1;
			}
			/**
			 * 如果该数比猜的数大返回-1.
			 */
			else {
				R = mid - 1;
			}
		}
		return L;
	}
}
