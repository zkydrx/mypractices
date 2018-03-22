package com.leetcode.ValidPlaindrome125;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-22
 * Time: 10:39:19
 * Description:
 */
class ValidPlaindromeTest
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
    void isPalindrome()
    {
        ValidPlaindrome validPlaindrome = new ValidPlaindrome();

        boolean abcdeft = validPlaindrome.isPalindrome("a.");
        boolean palindromeTwo = validPlaindrome.isPalindromeTwo("a.");

        System.out.println(abcdeft);
        System.out.println(palindromeTwo);
    }
}