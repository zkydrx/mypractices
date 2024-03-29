package com.leetcode.MergeSortedArray88;

/**
 * Created with IntelliJ IDEA. Author: Abbot Date: 2018-03-06 Time: 09:19:59
 * Description: 88. Merge Sorted Array
 * <p>
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as
 * one sorted array.
 * <p>
 * Note: You may assume that nums1 has enough space (size that is greater or
 * equal to m + n) to hold additional elements from nums2. The number of
 * elements initialized in nums1 and nums2 are m and n respectively.
 */
public class MergeSortedArray {
	/**
	 * @param nums1:
	 *            sorted integer array A which has m elements, but size of A is m+n
	 * @param nums2:
	 *            sorted integer array B which has n elements
	 * @return: void
	 */
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		while (m > 0 && n > 0) {
			if (nums1[m - 1] > nums2[n - 1]) {
				nums1[m + n - 1] = nums1[m - 1];
				m--;
			} else {
				nums1[m + n - 1] = nums2[n - 1];
				n--;
			}
		}

		while (n > 0) {
			nums1[m + n - 1] = nums2[n - 1];
			n--;
		}
	}
}

class Solution {
	/**
	 * @param A:
	 *            sorted integer array A which has m elements, but size of A is m+n
	 * @param B:
	 *            sorted integer array B which has n elements
	 * @return: void
	 */
	public void mergeSortedArray(int[] A, int m, int[] B, int n) {
		int i = m - 1, j = n - 1, index = m + n - 1;
		while (i >= 0 && j >= 0) {
			if (A[i] > B[j]) {
				A[index--] = A[i--];
			} else {
				A[index--] = B[j--];
			}
		}
		while (i >= 0) {
			A[index--] = A[i--];
		}
		while (j >= 0) {
			A[index--] = B[j--];
		}
	}
}