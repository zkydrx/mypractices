package workTest.conCurrentHashMap.test2;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2018-11-09 Time: 00:18:23
 * Description:
 */
public class DoMain {
	public static void main(String[] args) {
		ConcurrentHashMap<Integer, Integer> hashMap = new ConcurrentHashMap();

		for (int i = 0; i < 1000; i++) {
			hashMap.put(i, i);
		}

		new Thread(new AddThread(hashMap)).start();

		new Thread(new RemoveThread(hashMap)).start();

		new Thread(new IteratorThread(hashMap)).start();
	}
}
