package com.leetcode.MissingNumber268;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA. Author: Abbot Date: 2018-01-28 Time: 22:32:35
 * Description: Given an array containing n distinct numbers taken from 0, 1, 2,
 * ..., n, find the one that is missing from the array.
 * <p>
 * Example 1
 * <p>
 * Input: [3,0,1] Output: 2 Example 2
 * <p>
 * Input: [9,6,4,2,3,5,7,0,1] Output: 8
 * <p>
 * Note: Your algorithm should run in linear runtime complexity. Could you
 * implement it using only constant extra space complexity?
 * <p>
 * Credits: Special thanks to @jianchao.li.fighter for adding this problem and
 * creating all test cases.
 */
public class MissingNumber {
	public static void main(String[] args) {
		int[] num = {1};
		int[] num1 = {1, 2};
		int[] num2 = {0};
		int[] num3 = {0, 1};
		int i = new MissingNumber().missingNumber(num3);

		System.out.println(i);
	}

	public int missingNumber(int[] nums) {
		int result = 0;
		Arrays.sort(nums);
		int[] temp = new int[nums.length + 1];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = i;
		}

		for (int i = 0; i < nums.length; i++) {

			/**
			 * the only one digit [0],[1]
			 */
			if (nums.length == 1) {
				if (nums[0] == 0) {
					result = 1;
					break;
				}
				if (nums[0] == 1) {
					result = 0;
					break;
				}
			} else {
				/**
				 * the first digit [1,2,3] [0,1,2,3]
				 */
				if (i == 0) {
					if (nums[i] != temp[i]) {
						result = 0;
						break;
					} else {
						continue;
					}

				} else {
					/**
					 * medium digit [0,1,3,4] [0,1,2,3,4]
					 */
					if (nums[i] != temp[i]) {
						result = temp[i];
						break;
					}
					/**
					 * the last digit. forexample: [0,1,2,3] [0,1,2,3,4]
					 */
					if (i == nums.length - 1 && nums[i] == temp[i]) {
						result = temp[temp.length - 1];
					}
				}

			}
		}

		return result;
	}
}
