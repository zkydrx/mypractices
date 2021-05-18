package com.leetcode.AddBinary67;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-02
 * Time: 10:30:53
 * Description:
 */
class AddBinaryTest
{

    AddBinary addBinary = new AddBinary();

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
    void addBinary()
    {
        //        String s = addBinary.addBinary("0", "0");
        //        System.out.println(s);
        String s1 = addBinary.addBinary("1111", "1");

        System.out.println(s1);
        String s = addBinary.addBinaryOne("11", "1111");

        System.out.println(s);
    }

    @Test
    void binToInteger()
    {
        int i = addBinary.binToInteger("111");

        System.out.println(i);
    }

    @Test
    void integerToBinString()
    {
        String s = addBinary.integerToBinString(23);

        System.out.println(s);
    }
}