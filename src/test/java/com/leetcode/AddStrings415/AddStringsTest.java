package com.leetcode.AddStrings415;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-02-10
 * Time: 00:48:56
 * Description:
 */
class AddStringsTest
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
    void addStrings()
    {
        AddStrings addStrings = new AddStrings();

        String s = addStrings.addStrings("100000",
                "20000");

        System.out.println(s);
    }

    @Test
    void addStringsOne()
    {
        AddStrings addStrings = new AddStrings();
        String s = addStrings.addStringsOne("1111", "22222");

        System.out.println(s);
    }


}