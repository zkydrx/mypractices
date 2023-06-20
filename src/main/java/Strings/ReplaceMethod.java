package Strings;

/**
 * Created with IntelliJ IDEA. User: Abbot Date: 2017-11-16 Time: 15:13
 * Description:
 */
public class ReplaceMethod {
	public static void main(String[] args) {
		String test = "杭州市";
		/**
		 * replaceAll() and replace() all complete the change.
		 *
		 * it is the result: replaceAll:杭州 replace:杭州
		 */
		String changedTest = test.replaceAll("市", "");
		String testReplace = test.replace("市", "");

		System.out.println("replaceAll:" + changedTest);
		System.out.println("replace:" + testReplace);

	}
}
