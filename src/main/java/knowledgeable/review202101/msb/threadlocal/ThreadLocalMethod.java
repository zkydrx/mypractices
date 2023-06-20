package knowledgeable.review202101.msb.threadlocal;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2021-01-29 Time: 21:20:23
 * Description: ThreadLocal 使用场景：spring @transaction的处理，mybatis关于分页的处理
 */
public class ThreadLocalMethod {
	static ThreadLocal<Person> threadLocal = new ThreadLocal();

	public static void main(String[] args) {
		new Thread(() -> {
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(threadLocal.get());
		}, "threadName").start();

		new Thread(() -> {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (Exception e) {
				e.printStackTrace();
			}
			threadLocal.set(new Person());
		}, "threadName").start();
	}

	static class Person {
		String name = "zhangsan";
	}
}
