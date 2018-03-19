package com.leetcode.PascalsTriangleII119;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-19
 * Time: 22:59:35
 * Description:
 */
class PascalsTriangleIITest
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
    void getRow()
    {
        PascalsTriangleII pascalsTriangleII = new PascalsTriangleII();

        List<Integer> row = pascalsTriangleII.getRow(3);
        for (Integer integer : row)
        {
            System.out.print(integer+"\t");
        }


    }
}