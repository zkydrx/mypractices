package workTest.conCurrentHashMap.test1;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2018-11-09 Time: 00:01:19
 * Description:
 */
public class TestMap {
	public static void main(String[] args) {
		/** 全局HashMap */
		ConcurrentHashMap<Integer, Integer> hashMap = new ConcurrentHashMap();
		hashMap.put(0, 0);

		/** 多线程编辑100次 */
		for (int i = 0; i < 100; i++) {
			new Thread(new EditThread(hashMap)).start();
		}

		/** 读取线程 */
		new Thread(new ReadThread(hashMap)).start();
		/** 输出最终结果 */
		System.out.println("conCurrentHashMap main value " + hashMap.get(0));
	}
}
