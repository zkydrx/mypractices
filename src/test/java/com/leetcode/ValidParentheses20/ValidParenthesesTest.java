package com.leetcode.ValidParentheses20;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-02-23
 * Time: 20:59:25
 * Description:
 */
class ValidParenthesesTest
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
    void isValid()
    {
        ValidParentheses validParentheses = new ValidParentheses();

        boolean valid = validParentheses.isValid("[{]}");
        boolean valid1 = validParentheses.isValid("{}()[]");
        boolean valid2 = validParentheses.isValid("{}[[]](())");
        boolean valid3 = validParentheses.isValid("[()()(){}[][]]");
        boolean valid4 = validParentheses.isValid("(([]){})");


        System.out.println(valid);
        System.out.println(valid1);
        System.out.println(valid2);
        System.out.println(valid3);
        System.out.println(valid4);
    }
}