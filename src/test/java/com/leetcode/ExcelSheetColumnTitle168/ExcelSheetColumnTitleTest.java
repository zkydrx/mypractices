package com.leetcode.ExcelSheetColumnTitle168;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-29
 * Time: 09:44:52
 * Description:
 */
class ExcelSheetColumnTitleTest
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
    void convertToTitle()
    {
        ExcelSheetColumnTitle excelSheetColumnTitle = new ExcelSheetColumnTitle();

        String s = excelSheetColumnTitle.convertToTitle(3);
        String s1 = excelSheetColumnTitle.convertToTitle(27);

        System.out.println(s);
        System.out.println(s1);
    }
}