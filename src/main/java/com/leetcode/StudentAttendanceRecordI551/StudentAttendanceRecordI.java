package com.leetcode.StudentAttendanceRecordI551;

/**
 * Created with IntelliJ IDEA. Author: Abbot Date: 2018-02-11 Time: 19:37:32
 * Description:
 * <p>
 * 551. Student Attendance Record I You are given a string representing an
 * attendance record for a student. The record only contains the following three
 * characters: 'A' : Absent. 'L' : Late. 'P' : Present. A student could be
 * rewarded if his attendance record doesn't contain more than one 'A' (absent)
 * or more than two continuous 'L' (late).
 * <p>
 * You need to return whether the student could be rewarded according to his
 * attendance record.
 * <p>
 * Example 1: Input: "PPALLP" Output: True Example 2: Input: "PPALLL" Output:
 * False
 */
public class StudentAttendanceRecordI {
	public boolean checkRecord(String s) {
		return !s.matches(".*LLL.*|.*A.*A.*");
	}
}
