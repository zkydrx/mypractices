package com.leetcode.PlusOne66;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-01
 * Time: 11:52:39
 * Description:
 */
class PlusOneTest
{

    @BeforeEach
    void setUp()
    {
        System.out.println("String...");
    }

    @AfterEach
    void tearDown()
    {
        System.out.println("Ending...");
    }

    @Test
    void plusOne()
    {
        PlusOne plusOne = new PlusOne();

        int[] nums = {1, 2, 3, 9};
        int[] nums1 = {3, 5, 9, 9};
        int[] nums2 = {3, 3, 8, 8};
        int[] nums3 = {1, 0};
        int[] nums4 = {0};
        int[] nums5 = {9, 9, 9, 9};
        int[] nums6 = {1, 1, 9, 9};

        int[] ints = plusOne.plusOne(nums);
        int[] ints1 = plusOne.plusOne(nums1);
        int[] ints2 = plusOne.plusOne(nums2);
        int[] ints3 = plusOne.plusOne(nums3);
        int[] ints4 = plusOne.plusOne(nums4);
        int[] ints5 = plusOne.plusOne(nums5);
        int[] ints6 = plusOne.plusOne(nums6);

        System.out.println(getNums(ints));
        System.out.println(getNums(ints1));
        System.out.println(getNums(ints2));
        System.out.println(getNums(ints3));
        System.out.println(getNums(ints4));
        System.out.println(getNums(ints5));
        System.out.println(getNums(ints6));

        System.out.println("****************************");
        int[] ints7 = plusOne.plusoneMethodTwo(nums);
        int[] ints8 = plusOne.plusoneMethodTwo(nums1);
        int[] ints9 = plusOne.plusoneMethodTwo(nums2);
        int[] ints10 = plusOne.plusoneMethodTwo(nums3);
        int[] ints11 = plusOne.plusoneMethodTwo(nums4);
        int[] ints12 = plusOne.plusoneMethodTwo(nums5);
        int[] ints13 = plusOne.plusoneMethodTwo(nums6);

        System.out.println(getNums(ints7));
        System.out.println(getNums(ints8));
        System.out.println(getNums(ints9));
        System.out.println(getNums(ints10));
        System.out.println(getNums(ints11));
        System.out.println(getNums(ints12));
        System.out.println(getNums(ints13));
    }

    public String getNums(int[] nums)
    {
        StringBuilder stringBuilder = new StringBuilder();
        for (int num : nums)
        {
            stringBuilder.append(num);
        }

        return stringBuilder.toString();
    }
}