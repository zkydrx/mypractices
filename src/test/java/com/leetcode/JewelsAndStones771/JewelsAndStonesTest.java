package com.leetcode.JewelsAndStones771;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-02-06
 * Time: 00:42:06
 * Description:
 */
class JewelsAndStonesTest
{

    @BeforeEach
    void setUp()
    {
    }

    @AfterEach
    void tearDown()
    {
    }

    @Test
    void numJewelsInStones()
    {
        JewelsAndStones jewelsAndStones = new JewelsAndStones();

        int i = jewelsAndStones.numJewelsInStones("aA", "AAabdc");

        System.out.println(i);
    }
}