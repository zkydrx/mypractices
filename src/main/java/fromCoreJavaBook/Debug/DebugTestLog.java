package fromCoreJavaBook.Debug;

import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA. User: Abbot Date: 2017-09-29 Time: 00:59
 * Description: About Logger.
 */
public class DebugTestLog {
	public static void main(String[] args) {
		int a = 1;
		System.out.println("*************************");
		Logger.getGlobal().info("this" + a);
		System.out.println("*************************");

	}
}
