package workTest.hashMap.test1;

import java.util.Map;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2018-11-09 Time: 00:00:42
 * Description:
 */
public class ReadThread implements Runnable {

	Map<Integer, Integer> hashMap;

	public ReadThread(Map<Integer, Integer> hashMap) {
		this.hashMap = hashMap;
	}

	@Override
	public void run() {
		System.out.println("value " + hashMap.get(0));
	}
}
