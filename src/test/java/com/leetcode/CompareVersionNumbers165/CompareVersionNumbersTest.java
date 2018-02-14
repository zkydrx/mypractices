package com.leetcode.CompareVersionNumbers165;

import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-02-14
 * Time: 22:29:27
 * Description:
 */
class CompareVersionNumbersTest
{

    @Test
    void compareVersion()
    {
        CompareVersionNumbers compareVersionNumbers = new CompareVersionNumbers();

        int i = compareVersionNumbers.compareVersion("2.3", "3.4");

        System.out.println(i);
    }
}