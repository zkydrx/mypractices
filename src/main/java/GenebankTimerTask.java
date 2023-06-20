import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by ZKY on 2017-06-02 4:43 PM. 定时器
 */
public class GenebankTimerTask {
	public static void main(String[] args) {
		Timer timer = new Timer();
		GenBankTask genBankTask = new GenBankTask();
		timer.schedule(genBankTask, 1000, 2000);
	}

	static class GenBankTask extends TimerTask {
		@Override
		public void run() {
			System.out.println("Hello World!");
		}
	}

}
