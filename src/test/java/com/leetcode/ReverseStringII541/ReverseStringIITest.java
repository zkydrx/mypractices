package com.leetcode.ReverseStringII541;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-02-03
 * Time: 21:42:47
 * Description:
 */
class ReverseStringIITest
{

    @BeforeEach
    void setUp()
    {
        System.out.println("Starting...");
    }

    @AfterEach
    void tearDown()
    {
        System.out.println("Ending...");
    }

    @Test
    void reverseStr()
    {
        ReverseStringII reverseStringII = new ReverseStringII();
        String abcdefg = reverseStringII.reverseStr("abcdefg", 2);
        System.out.println(abcdefg);
    }
}