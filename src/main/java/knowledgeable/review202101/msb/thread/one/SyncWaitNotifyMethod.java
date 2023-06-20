package knowledgeable.review202101.msb.thread.one;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2021-01-29 Time: 17:31:45
 * Description: 线程A打印数字，线程B打印字母，两个线程交替打印。1A2B3C4D...
 */
public class SyncWaitNotifyMethod {

	final static Object object = new Object();

	public static void main(String[] args) {
		char[] num = {'1', '2', '3', '4', '5', '6', '7', '8'};
		char[] chars = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};

		new Thread(() -> {
			synchronized (object) {
				for (char c : num) {
					System.out.print(c);
					object.notify();
					try {
						object.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
				object.notify();
			}
		}, "t1").start();

		new Thread(() -> {
			synchronized (object) {
				for (char c : chars) {
					System.out.print(c);
					object.notify();
					try {
						object.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
				object.notify();
			}
		}, "t2").start();
	}
}
