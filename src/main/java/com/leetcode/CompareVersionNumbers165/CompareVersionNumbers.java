package com.leetcode.CompareVersionNumbers165;

/**
 * Created with IntelliJ IDEA. Author: Abbot Date: 2018-02-14 Time: 22:26:42
 * Description:
 * <p>
 * 165. Compare Version Numbers
 * <p>
 * ompare two version numbers version1 and version2. If version1 > version2
 * return 1, if version1 < version2 return -1, otherwise return 0.
 * <p>
 * You may assume that the version strings are non-empty and contain only digits
 * and the . character. The . character does not represent a decimal point and
 * is used to separate number sequences. For instance, 2.5 is not "two and a
 * half" or "half way to version three", it is the fifth second-level revision
 * of the second first-level revision.
 * <p>
 * Here is an example of version numbers ordering:
 * <p>
 * 0.1 < 1.1 < 1.2 < 13.37 Credits: Special thanks to @ts for adding this
 * problem and creating all test cases.
 */
public class CompareVersionNumbers {
	public int compareVersion(String version1, String version2) {
		double v = Double.parseDouble(version1);

		double v1 = Double.parseDouble(version2);

		int res = 0;
		if (v > v1) {
			res = 1;
		} else if (v < v1) {
			res = -1;
		}
		return res;
	}

}
