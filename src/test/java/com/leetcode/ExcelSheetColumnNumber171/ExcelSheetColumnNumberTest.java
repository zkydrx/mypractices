package com.leetcode.ExcelSheetColumnNumber171;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created with IntelliJ IDEA.
 * User: zky
 * Date: 2018-04-01
 * Time: 23:52:51
 * Description:
 */
class ExcelSheetColumnNumberTest
{

    @BeforeEach
    void setUp()
    {
        System.out.println("String...");
    }

    @AfterEach
    void tearDown()
    {
        System.out.println("endding...");
    }

    @Test
    void titleToNumber()
    {
        ExcelSheetColumnNumber excelSheetColumnNumber = new ExcelSheetColumnNumber();

        int aab = excelSheetColumnNumber.titleToNumber("AA");

        System.out.println(aab);
    }
}