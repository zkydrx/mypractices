package com.lintcode.www.GuessNumber;

import java.util.Random;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA. User: Abbot Date: 2017-09-14 Time: 09:14
 * Description: 猜数字的游戏，以前的时候用c语言写过一个，当时还在某个公司实习。
 */
public class GuessNumber {
	public void guessTheNubmer() {
		System.out.println("I have already gived a number");
		Random random = new Random(1000);
		double random1 = Math.random();
		int i = (int) (random1 * 1000 + 1);
		System.out.println(i);
		System.out.println("Please input a number of 1 - 1000.");
		Scanner scanner = new Scanner(System.in);
		int i1 = scanner.nextInt();
		while (i != i1) {
			if (i > i1) {
				System.out.println("The number is shortter.");
			} else {
				System.out.println("The number is bigger.");
			}
			System.out.println("Please input the number of you guess it ");
			i1 = scanner.nextInt();
		}
		System.out.println("Congratulations to you and you are successful!");

	}

	public static void main(String[] args) {
		GuessNumber guessNumber = new GuessNumber();
		guessNumber.guessTheNubmer();
	}
}
