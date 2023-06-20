package com.lintcode.www.SquareNumbers;

/**
 * Created with IntelliJ IDEA. User: Abbot Date: 2017-10-03 Time: 14:59
 * Description: Given a integer c, your task is to decide whether there're two
 * integers a and b such that a^2 + b^2 = c. Example Given n = 5 Return true //
 * 1 * 1 + 2 * 2 = 5
 * <p>
 * Given n = -5 Return false
 */
public class SquareNumbers {
	public static void main(String[] args) {
		SquareNumbers squareNumbers = new SquareNumbers();
		boolean b = squareNumbers.checkSumOfSquareNumbers(5);
		System.out.println(b);
		System.out.println(Math.sqrt(4));
	}

	/**
	 * 方法一：时间复杂度较方法二小。
	 *
	 * @param num
	 * @return
	 */
	public boolean checkSumOfSquareNumbers(int num) {
		/**
		 * 这个方法的时间复杂度比刚才那个小很多。
		 */
		for (int i = 0; i <= Math.sqrt(num); i++) {
			int tem = num - i * i;
			if (checkTheNumber(tem)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Judge the number is a square number or not.
	 *
	 * @param num
	 * @return
	 */
	public boolean checkTheNumber(int num) {
		for (int i = 0; i <= Math.sqrt(num); i++) {
			if (num == i * i) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 方法二：时间复杂度较大。
	 *
	 * @param num
	 * @return
	 */
	public boolean checkSumOfSquareNumbers1(int num) {
		/**
		 * 时间复杂度太大。
		 */
		for (int i = 0; i <= Math.sqrt(num); i++) {
			for (int j = 0; j <= Math.sqrt(num); j++) {
				if (num == Math.pow(i, 2) + Math.pow(j, 2)) {
					return true;
				}
			}
		}
		return false;
	}
}
