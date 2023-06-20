package knowledgeable.review202101.msb.synchronize;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2021-02-01 Time: 17:11:31
 * Description: lock coarsending (锁粗化的例子)
 * 由于StringBuffer是线程安全的，而在while的循环中进行append()时，不停地加锁与解锁。
 * jvm发现这种情况是，会直接把锁加在while循环上，直到整个操作完成。这就是锁粗化
 */
public class LockCoarsendingMethod {
	public String test(String str) {
		int i = 0;
		StringBuffer stringBuffer = new StringBuffer();
		while (i < 100) {
			stringBuffer.append(str);
			i++;
		}
		return stringBuffer.toString();
	}
}
