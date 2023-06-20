package com.leetcode.LengthOfLastWord58;

/**
 * Created with IntelliJ IDEA. Author: Abbot Date: 2018-01-22 Time: 12:17
 * Description:
 * <p>
 * 58. Length of Last Word Given a string s consists of upper/lower-case
 * alphabets and empty space characters ' ', return the length of last word in
 * the string.
 * <p>
 * If the last word does not exist, return 0.
 * <p>
 * Note: A word is defined as a character sequence consists of non-space
 * characters only.
 * <p>
 * Example:
 * <p>
 * Input: "Hello World" Output: 5
 */
public class LengthOfLastWord {
	public static void main(String[] args) {
		LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();
		int hello_world = lengthOfLastWord.lengthOfLastWord("Hello World");

		int hello = lengthOfLastWord.lengthOfLastWord("helo");
		System.out.println(hello_world);
		System.out.println(hello);
		String trim = "a ".trim();

		System.out.println("*" + trim + "*");
	}

	/**
	 * method one
	 *
	 * @param s
	 * @return
	 */
	public int lengthOfLastWord(String s) {
		int lenth = 0;
		String trim = s.trim();
		for (int i = 0; i < trim.length(); i++) {
			if (trim.charAt(i) == ' ') {
				lenth = 0;
			} else {
				lenth++;
			}

		}
		return lenth;
	}

	/**
	 * method two
	 *
	 * @param s
	 * @return
	 */
	public int lengthOfLastWordTwo(String s) {
		int length = 0;
		boolean char_flag = false;
		/**
		 * Once the first character from last is encountered, set char_flag to true.
		 */
		for (int i = s.length() - 1; i >= 0; i--) {
			if (Character.isLetter(s.charAt(i))) {
				length++;
				char_flag = true;
			}
			/**
			 * when the first space after the characters (from the last) is
			 * encountered,return the length of the last word.
			 */
			else {
				if (char_flag = true) {
					return length;
				}
			}
		}

		return length;
	}
}
