package sudden;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA. User: Abbot Date: 2017-12-14 Time: 09:55
 * Description: 一个基于java的简易计算器 输入要计算的数字给出结果。 第一版我们只计算两个数各种计算
 */
public class MyCompute {
	/**
	 * 两个数的混合运算
	 *
	 * @return
	 */
	public Double getTwoNumberResult() {
		while (true) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Please input the first number:");
			double v = scanner.nextDouble();
			System.out.println("Please input the second number:");
			double v1 = scanner.nextDouble();

			System.out.println("Please input the method:");
			String next = scanner.next();

			Double result = 0.0;

			switch (next) {
				case "+" :
					result = v + v1;
					break;
				case "-" :
					result = v - v1;
					break;
				case "*" :
					result = v * v1;
					break;
				case "/" :
					result = v / v1;
					break;
				case "^" :
					result = Math.pow(v, v1);
					break;
				case "%" :
					result = v % v1;
					break;
				default :
					break;
			}
			return result;
		}
	}

	public static void main(String[] args) {
		MyCompute myCompute = new MyCompute();
		while (true) {
			Double twoNumberResult = myCompute.getTwoNumberResult();

			System.out.println(twoNumberResult);
		}

	}

}
