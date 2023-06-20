package knowledgeable.review201901.java.volatileTest;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2019-01-09 Time: 12:42:33
 * Description:
 */
public class VolatileExample {
	private static volatile int counter = 0;

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					for (int i = 0; i < 10000; i++) {
						counter++;
					}
				}
			});
			thread.start();
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(counter);
	}
}
