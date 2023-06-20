package workTest.hashMap.test2;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2018-11-09 Time: 00:18:23
 * Description:
 */
public class DoMain {
	public static void main(String[] args) {
		HashMap<Integer, Integer> hashMap = new HashMap();

		for (int i = 0; i < 1000; i++) {
			hashMap.put(i, i);
		}

		new Thread(new AddThread(hashMap)).start();

		new Thread(new RemoveThread(hashMap)).start();

		new Thread(new IteratorThread(hashMap)).start();
	}
}
