package com.leetcode.FactorialTrailingZeroes172;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2018-04-04
 * Time: 10:12:54
 * Description:
 */
public class FactorialTrailingZeroesTest
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
    void trailingZeroes()
    {
        FactorialTrailingZeroes factorialTrailingZeroes = new FactorialTrailingZeroes();
        int i = factorialTrailingZeroes.trailingZeroes(30);

        System.out.println(i);
    }


}