package com.leetcode.PlusOne66;

/**
 * Created with IntelliJ IDEA. Author: Abbot Date: 2018-02-28 Time: 23:55:58
 * Description: 66. Plus One
 * <p>
 * Given a non-negative integer represented as a non-empty array of digits, plus
 * one to the integer.
 * <p>
 * You may assume the integer do not contain any leading zero, except the number
 * 0 itself.
 * <p>
 * The digits are stored such that the most significant digit is at the head of
 * the list.
 */
public class PlusOne {
	public int[] plusOne(int[] digits) {
		int length = digits.length;
		int[] temp = new int[length];
		for (int i = 0; i < digits.length; i++) {
			temp[i] = digits[i];
		}

		if (length > 1) {

			if (allDigitAreNine(digits)) {
				int[] nums = new int[digits.length + 1];
				nums[0] = 1;
				return nums;
			}

			if (temp[length - 1] == 9) {
				for (int i = length - 1; i > 0; i--) {
					if (digits[i] == 9) {
						temp[i] = 0;
						if (digits[i - 1] == 9) {
							temp[i - 1] = 0;
						} else if (digits[i - 1] < 9) {
							temp[i - 1]++;

							break;
						}
					}
				}
			}

			else if (digits[length - 1] < 9) {
				temp[length - 1]++;
			}

		}

		if (length == 1 && digits[0] == 9) {
			int[] num = new int[2];
			num[0] = 1;
			num[1] = 0;
			return num;
		}

		if (length == 1 && digits[0] < 9) {
			temp[0] = temp[0] + 1;
		}

		return temp;
	}

	public boolean allDigitAreNine(int[] nums) {
		boolean b = true;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 9) {
				b = false;
				break;
			}
		}

		return b;
	}

	/**
	 * method two.
	 *
	 * @param nums
	 * @return
	 */
	public int[] plusoneMethodTwo(int[] nums) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int num : nums) {
			stringBuilder.append(num);
		}

		int i = Integer.parseInt(stringBuilder.toString());

		i++;

		int numDigit = getNumDigit(i);
		int[] num = new int[numDigit];
		int[] arrays = getArrays(num, i);

		return arrays;

	}

	/**
	 * get a number of digits.
	 *
	 * @param num
	 * @return
	 */
	public int getNumDigit(int num) {
		int count = 0;
		while (num > 0) {
			int temp = num % 10;
			count++;
			num /= 10;
		}
		return count;
	}

	/**
	 * Put a number's digit into a array.
	 *
	 * @param arr
	 * @param n
	 * @return
	 */
	public int[] getArrays(int[] arr, int n) {
		int numDigit = getNumDigit(n);

		while (n > 0) {
			int temp = n % 10;
			arr[--numDigit] = temp;
			n /= 10;
		}
		return arr;
	}

}
