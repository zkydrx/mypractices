package knowledgeable.review201901.designPatterns.Singleton;

/**
 * Created with IntelliJ IDEA. Author: Abbot Date: 2018-03-19 Time: 17:13:59
 * Description: 1.懒汉式，线程不安全
 */
public class SingletonOne {
	private static SingletonOne instalce;

	private SingletonOne() {
	}

	public static SingletonOne getInstance() {
		if (instalce == null) {
			instalce = new SingletonOne();
		}
		return instalce;
	}

	public void testPrint() {
		System.out.println("SingletonOne 懒汉式，线程不安全");
	}
}
