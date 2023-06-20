package knowledgeable.review202101.msb.threadlocal;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2021-01-29 Time: 20:30:28
 * Description:
 */
public class M {
	@Override
	protected void finalize() {
		System.out.println("finalize");
	}
}
