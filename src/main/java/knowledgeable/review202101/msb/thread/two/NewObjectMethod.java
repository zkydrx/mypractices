package knowledgeable.review202101.msb.thread.two;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2021-01-30 Time: 14:37:47
 * Description: 该代码验证volatile线程的可见性。
 */
public class NewObjectMethod {
	private static volatile boolean flag = true;

	public static void main(String[] args) throws InterruptedException {
		/**
		 * 汇编码如下，汇编码的查看方式是使用view的 Show ByteCode With JclassLib 0 new #2
		 * <java/lang/Object> 3 dup 4 invokespecial #1 <java/lang/Object.<init>> 7
		 * astore_1 8 return
		 */
		Object object = new Object();

		new Thread(() -> {
			while (flag) {

			}
			System.out.println("end");
		}, "threadName").start();
		Thread.sleep(1000);
		flag = false;

	}
}
