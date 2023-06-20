package com.leetcode.ContainsDuplicateII219;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2018-04-24 Time: 21:34:01
 * Description: 219. Contains Duplicate II
 * <p>
 * Given an array of integers and an integer k, find out whether there are two
 * distinct indices i and j in the array such that nums[i] = nums[j] and the
 * absolute difference between i and j is at most k.
 */
public class ContainsDuplicateII {
	public boolean containsNearbyDuplicate(int[] nums, int k) {

		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				int pre = map.get(nums[i]);
				if (i - pre <= k) {
					return true;
				}
			}

			map.put(nums[i], i);
		}

		return false;
	}
}
