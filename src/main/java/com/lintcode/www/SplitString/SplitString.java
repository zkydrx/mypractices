package com.lintcode.www.SplitString;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA. User: Abbot Date: 2017-09-21 Time: 16:28
 * Description: Give a string, you can choose to split the string after one
 * character or two adjacent characters, and make the string to be composed of
 * only one character or two characters. Output all possible results. 样例 Given
 * the string "123" return [["1","2","3"],["12","3"],["1","23"]] 改功能还没有完成。
 */
public class SplitString {
	public static void main(String[] args) {
		SplitString s = new SplitString();
		List<List<String>> lists = s.splitString("123");
		System.out.println(lists);
	}

	/**
	 * "1234567890"
	 *
	 * @param s
	 * @return
	 */
	public List<List<String>> splitString(String s) {
		List<List<String>> lists = new ArrayList<>();
		List<String> list;
		System.out.println("length:" + s.length());
		for (int i = 2; i < s.length() + 1; i++) {
			String[] split = s.split("", i);
			list = new ArrayList<>();
			for (int i1 = 0; i1 < split.length; i1++) {
				list.add(split[i1]);
			}
			System.out.println(list);
			lists.add(list);
		}
		return lists;
	}
}
