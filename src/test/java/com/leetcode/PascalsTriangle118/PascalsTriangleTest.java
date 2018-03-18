package com.leetcode.PascalsTriangle118;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-19
 * Time: 00:33:07
 * Description:
 */
class PascalsTriangleTest
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
    void generate()
    {
        PascalsTriangle pascalsTriangle = new PascalsTriangle();

        List<List<Integer>> generate = pascalsTriangle.generate(5);

        for (List<Integer> list : generate)
        {
            for (Integer integer : list)
            {
                System.out.print(integer+"\t");
            }
            System.out.println();
        }
    }
}