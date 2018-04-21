package com.leetcode.IsomorphicStrings205;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2018-04-22
 * Time: 01:09:52
 * Description:
 */
class IsomorphicStringsTest
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
    void isIsomorphic()
    {
        IsomorphicStrings isomorphicStrings = new IsomorphicStrings();

        boolean isomorphic = isomorphicStrings.isIsomorphic("add", "foo");
//        boolean isomorphic1 = isomorphicStrings.isIsomorphic("aa", "ab");
        System.out.println(isomorphic);
//        System.out.println(isomorphic1);
    }
}