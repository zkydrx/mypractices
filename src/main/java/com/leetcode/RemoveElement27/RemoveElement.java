package com.leetcode.RemoveElement27;

/**
 * Created with IntelliJ IDEA. User: Abbot Date: 2018-01-05 Time: 12:36
 * Description:
 * <p>
 * 27. Remove Element
 * <p>
 * Given an array and a value, remove all instances of that value in-place and
 * return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying
 * the input array in-place with O(1) extra memory.
 * <p>
 * The order of elements can be changed. It doesn't matter what you leave beyond
 * the new length.
 * <p>
 * Example:
 * <p>
 * Given nums = [3,2,2,3], val = 3,
 * <p>
 * Your function should return length = 2, with the first two elements of nums
 * being 2.
 */
public class RemoveElement {

	public int removeElement(int[] nums, int val) {

		int i = 0;
		int j = 0;
		while (j < nums.length) {
			if (nums[j] != val) {
				nums[i] = nums[j];
				i++;
			}

			j++;
		}

		return i;
	}
}
