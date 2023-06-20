package com.leetcode.LargestNumberAtLeastTwiceOfOthers747;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA. Author: Abbot Date: 2018-01-14 Time: 02:12
 * Description:
 * <p>
 * 747. Largest Number At Least Twice of Others
 * <p>
 * In a given integer array nums, there is always exactly one largest element.
 * <p>
 * Find whether the largest element in the array is at least twice as much as
 * every other number in the array.
 * <p>
 * If it is, return the index of the largest element, otherwise return -1.
 * <p>
 * Example 1: Input: nums = [3, 6, 1, 0] Output: 1 Explanation: 6 is the largest
 * integer, and for every other number in the array x, 6 is more than twice as
 * big as x. The index of value 6 is 1, so we return 1. Example 2: Input: nums =
 * [1, 2, 3, 4] Output: -1 Explanation: 4 isn't at least as big as twice the
 * value of 3, so we return -1. Note: nums will have a length in the range [1,
 * 50]. Every nums[i] will be an integer in the range [0, 99].
 */
public class LargestNumberAtLeastTwiceOfOthers {
	public static void main(String[] args) {
		int[] num = {1, 2, 3, 4};
		int[] num1 = {3, 2, 0, 6};
		int[] num2 = {0, 0, 0, 1};
		int[] num3 = {1};

		LargestNumberAtLeastTwiceOfOthers largestNumberAtLeastTwiceOfOthers = new LargestNumberAtLeastTwiceOfOthers();
		int i = largestNumberAtLeastTwiceOfOthers.dominantIndex(num);
		int i1 = largestNumberAtLeastTwiceOfOthers.dominantIndex(num1);
		int i2 = largestNumberAtLeastTwiceOfOthers.dominantIndex(num2);
		int i3 = largestNumberAtLeastTwiceOfOthers.dominantIndex(num3);
		System.out.println(i);
		System.out.println(i1);
		System.out.println(i2);
		System.out.println(i3);
	}

	public static int getIndexofArray(int[] temp, int num) {
		int result = 0;
		for (int i = 0; i < temp.length; i++) {
			if (num == temp[i]) {
				result = i;
				break;
			}
		}

		return result;
	}

	public int dominantIndex(int[] nums) {
		int[] temp = new int[nums.length];

		for (int i = 0; i < nums.length; i++) {
			temp[i] = nums[i];
		}

		Arrays.sort(nums);
		int b = 0;
		if (nums.length >= 2) {
			if (nums[nums.length - 2] != 0) {
				if (nums[nums.length - 1] / nums[nums.length - 2] >= 2) {
					b = getIndexofArray(temp, nums[nums.length - 1]);
				} else {
					b = -1;
				}
			} else {
				b = getIndexofArray(temp, nums[nums.length - 1]);
			}

		} else if (nums.length == 1) {
			b = 0;
		} else {
			b = -1;
		}

		return b;
	}

}
