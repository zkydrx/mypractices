package fromeFaceBook.JavaProgramming;

/**
 * Created with IntelliJ IDEA. User: Abbot Date: 2017-09-11 Time: 19:15
 * Description:
 */
public class HowMuch {
	public static void main(String[] args) {
		int value = 3, sum = 6 + --value;
		/**
		 * --3 + ++1/9++ *2++ + ++8%2--;
		 */
		int data = --value + ++value / sum++ * value++ + ++sum % value--;
		System.out.println(data);
	}
}
