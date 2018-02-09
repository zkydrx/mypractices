package com.leetcode.FirstUniqueCharacterInAString387;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-02-09
 * Time: 23:48:53
 * Description:
 */
class FirstUniqueCharacterInAStringTest
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
    void firstUniqChar()
    {
        FirstUniqueCharacterInAString firstUniqueCharacterInAString = new FirstUniqueCharacterInAString();

        int leetcode = firstUniqueCharacterInAString.firstUniqChar("leetcode");

        System.out.println(leetcode);
        int loveleetcode = firstUniqueCharacterInAString.firstUniqChar("loveleetcode");

        System.out.println(loveleetcode);
    }
}