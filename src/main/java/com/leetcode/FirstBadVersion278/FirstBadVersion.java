package com.leetcode.FirstBadVersion278;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-01-18
 * Time: 16:34
 * Description:
 * <p>
 * 278. First Bad Version
 * <p>
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version
 * is developed based on the previous version, all the versions after a bad version are also bad.
 * <p>
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 * <p>
 * You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number
 * of calls to the API.
 * <p>
 * Credits:
 * Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
 */
public class FirstBadVersion
{
    public int findFirstBadVersion(int n)
    {

        int min = 0;
        int max = n;
        int mid;
        /**
         *
         */
        while (max > min)
        {
            mid = min + (max - min) / 2;
            if (isBadVersion(mid))
            {
                max = mid;
            }
            else
            {
                min = mid + 1;
            }
        }
        return max;
    }

    /**
     * this is a example.
     *
     * @param mid
     * @return
     */
    private boolean isBadVersion(int mid)
    {
        return false;
    }
}
