package com.leetcode.StudentAttendanceRecordI551;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-02-11
 * Time: 19:41:33
 * Description:
 */
class StudentAttendanceRecordITest
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
    void checkRecord()
    {
        StudentAttendanceRecordI studentAttendanceRecordI = new StudentAttendanceRecordI();
        boolean ppallp = studentAttendanceRecordI.checkRecord("PPALLP");

        System.out.println(ppallp);

        boolean ppalll = studentAttendanceRecordI.checkRecord("PPALLL");

        System.out.println(ppalll);
    }
}