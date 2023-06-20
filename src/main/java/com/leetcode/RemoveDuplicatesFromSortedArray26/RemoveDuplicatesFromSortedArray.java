package com.leetcode.RemoveDuplicatesFromSortedArray26;

import java.util.*;

/**
 * Created with IntelliJ IDEA. Author: Abbot Date: 2018-02-25 Time: 21:59:46
 * Description: 26. Remove Duplicates from Sorted Array
 * <p>
 * <p>
 * Given a sorted array, remove the duplicates in-place such that each element
 * appear only once and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying
 * the input array in-place with O(1) extra memory.
 * <p>
 * Example:
 * <p>
 * Given nums = [1,1,2],
 * <p>
 * Your function should return length = 2, with the first two elements of nums
 * being 1 and 2 respectively. It doesn't matter what you leave beyond the new
 * length.
 */
public class RemoveDuplicatesFromSortedArray {
	/***
	 * the Array of nums was not right.
	 * 
	 * @param nums
	 * @return
	 */
	public int removeDuplicates(int[] nums) {
		Set<Integer> set = new HashSet<>();
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}
		for (Integer integer : set) {
			list.add(integer);
		}
		nums = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			nums[i] = list.get(i);
		}
		Arrays.sort(nums);
		return list.size();
	}

	/**
	 * Method two
	 *
	 * @param nums
	 * @return
	 */
	public int removeDuplicatesOne(int[] nums) {
		if (nums.length < 2) {
			return nums.length;
		}
		int j = 0;
		int i = 1;

		while (i < nums.length) {
			if (nums[i] == nums[j]) {
				i++;
			} else {
				j++;
				nums[j] = nums[i];
				i++;
			}
		}

		return j + 1;
	}

	/**
	 * Only return the number of the elements and the array not changed.
	 *
	 * @param nums
	 * @return
	 */
	public int removeDuplicatesTwo(int[] nums) {
		int count = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == nums[i + 1])
				;
			{
				count++;
			}
		}

		return nums.length - count;
	}

}
