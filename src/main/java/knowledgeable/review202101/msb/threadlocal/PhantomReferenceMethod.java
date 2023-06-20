package knowledgeable.review202101.msb.threadlocal;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2021-01-29 Time: 20:59:31
 * Description: 虚幻引用，作用：管理直接内存 放到一个队列里，无法获取，在被回收的时候，给一个信号，通知管理直接内存。 nio，netty.
 */
public class PhantomReferenceMethod {
	private static final List<Object> LIST = new LinkedList<>();
	private static final ReferenceQueue<M> QUEUE = new ReferenceQueue<>();

	public static void main(String[] args) {
		PhantomReference<M> phantomReference = new PhantomReference<>(new M(), QUEUE);
		System.out.println(phantomReference.get());
		new Thread(() -> {
			while (true) {
				LIST.add(new byte[1024 * 1024]);
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println(phantomReference.get());
			}
		}, "a").start();

		new Thread(() -> {
			while (true) {
				Reference<? extends M> poll = QUEUE.poll();
				if (poll != null) {
					System.out.println("---虚引用对象被JVM回收了-----" + poll);
				}
			}
		}).start();

		try {
			Thread.sleep(500);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
