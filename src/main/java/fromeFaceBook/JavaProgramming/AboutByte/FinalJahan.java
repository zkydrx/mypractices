package fromeFaceBook.JavaProgramming.AboutByte;

/**
 * Created with IntelliJ IDEA. User: Abbot Date: 2017-12-08 Time: 23:39
 * Description:
 */
public class FinalJahan {
	public static void main(String[] args) {
		final byte J = 64, A = 64;
		/**
		 * 这种表示方法由于J 和 A 都是静态变量等于直接定义一个byte的变量=128由于byte.由于byte类型
		 * 的范围时候-128~127所以要在这里面才可以。 final byte sum = J + A;
		 */
		final byte sum = (byte) (J + A);

		byte x = 1;
		byte y = 2;
		/**
		 * byte z = x + y 由于x和y都是byte的变量。但是x+y的结果就是整型结果，而定义的byte变量所以将整形转为byte
		 * 型会损失精度。故上面的写法会报损失精度的错误。
		 */
		byte z = (byte) (x + y);
		System.out.println("Your result is " + sum);

		if (sum == 128) {
			System.out.println("you prosperous");
		} else {
			System.out.println("Sorry! you not prosperous");
		}

		byte max_byte = Byte.MAX_VALUE;
		byte min_byte = Byte.MIN_VALUE;
		short max_short = Short.MAX_VALUE;
		short min_short = Short.MIN_VALUE;
		int max_int = Integer.MAX_VALUE;
		int min_int = Integer.MIN_VALUE;
		long max_long = Long.MAX_VALUE;
		long min_long = Long.MIN_VALUE;
		float max_float = Float.MAX_VALUE;
		float min_float = Float.MIN_VALUE;
		double max_double = Double.MAX_VALUE;
		double min_double = Double.MIN_VALUE;
		char max_char = Character.MAX_VALUE;
		char min_char = Character.MIN_VALUE;

		System.out.println("max_byte:" + max_byte);
		System.out.println("max_short:" + max_short);
		System.out.println("max_int:" + max_int);
		System.out.println("max_long:" + max_long);
		System.out.println("max_float:" + max_float);
		System.out.println("max_double:" + max_double);
		System.out.println("max_char:" + max_char);

		System.out.println("min_byte:" + min_byte);
		System.out.println("min_short:" + min_short);
		System.out.println("min_int:" + min_int);
		System.out.println("min_long:" + min_long);
		System.out.println("min_float:" + min_float);
		System.out.println("min_double:" + min_double);
		System.out.println("min_char:" + min_char);

	}
}
