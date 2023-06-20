package knowledgeable.review201901.java.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2019-02-21 Time: 20:15:46
 * Description:
 */
public class LockDemo1 {
	AtomicInteger i = new AtomicInteger(0);

	public void add() {
		i.incrementAndGet();// +1操作
	}

	public static void main(String[] args) throws InterruptedException {
		LockDemo1 lockDemo = new LockDemo1();
		for (int i = 0; i < 2; i++) {

			new Thread(() -> {
				for (int j = 0; j < 10000; j++) {
					lockDemo.add();
				}
			}).start();
		}
		Thread.sleep(2000L);
		System.out.println(lockDemo.i);
	}
}
