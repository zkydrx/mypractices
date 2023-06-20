package knowledgeable.review201901.designPatterns.Singleton;

/**
 * Created with IntelliJ IDEA. Author: Abbot Date: 2018-03-19 Time: 17:21:23
 * Description: 饿汉式
 */
public class SingletonThree {
	private static SingletonThree instance = new SingletonThree();

	private SingletonThree() {
	}

	public static SingletonThree getInstance() {
		return instance;
	}

	public void testPrint() {
		System.out.println("SingletonThree 恶汉式");
	}
}
