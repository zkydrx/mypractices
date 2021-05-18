package com.leetcode.FindAllNumbersDisappearedInAnArray448;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-02-12
 * Time: 19:38:36
 * Description:
 */
class FindAllNumbersDisappearedInAnArrayTest
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
    void findDisappearedNumbers()
    {
        FindAllNumbersDisappearedInAnArray findAllNumbersDisappearedInAArray = new FindAllNumbersDisappearedInAnArray();

        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> disappearedNumbers = findAllNumbersDisappearedInAArray.findDisappearedNumbers(nums);

        for (int i = 0; i < disappearedNumbers.size(); i++)
        {
            System.out.println(disappearedNumbers.get(i));
        }
    }
}