package com.leetcode.PlaindromeNumber9;

/**
 * Created with IntelliJ IDEA. User: Abbot Date: 2017-12-27 Time: 10:22
 * Description:
 * <p>
 * 9. Palindrome Number Determine whether an integer is a palindrome. Do this
 * without extra space.
 * <p>
 * click to show spoilers.
 * <p>
 * Some hints: Could negative integers be palindromes? (ie, -1)
 * <p>
 * If you are thinking of converting the integer to string, note the restriction
 * of using extra space.
 * <p>
 * You could also try reversing an integer. However, if you have solved the
 * problem "Reverse Integer", you know that the reversed integer might overflow.
 * How would you handle such case?
 * <p>
 * There is a more generic way of solving this problem.
 * <p>
 * <p>
 * This is about the plaindrome number's introduce.
 * https://en.wikipedia.org/wiki/Palindrome
 */
public class PlaindromeNumber {
	public static void main(String[] args) {
		PlaindromeNumber plaindromeNumber = new PlaindromeNumber();

		System.out.println(plaindromeNumber.isPalindrome(121));
		System.out.println(plaindromeNumber.isPalindrome(101));
		System.out.println(plaindromeNumber.isPalindrome(123));
		System.out.println(plaindromeNumber.isPalindrome(8998998));

	}

	public boolean isPalindrome(int x) {
		int tempX = x;
		int result = 0;
		boolean b = true;
		while (x > 0) {
			int temp = x % 10;
			result = result * 10 + temp;
			x /= 10;
		}
		if (result != tempX) {
			b = false;
		}
		return b;
	}

}
