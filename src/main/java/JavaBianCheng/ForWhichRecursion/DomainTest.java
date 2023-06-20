package JavaBianCheng.ForWhichRecursion;

import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA. User: Abbot Date: 2017-08-29 Time: 16:44
 * Description:
 */
class DomainTest {
	Domain domain = new Domain();
	public int[] a = {1, 2, 3, 4, 5, 6};

	@Test
	public void testFor() {

		long sumByFor = domain.getSumByFor(a);
		System.out.println("sumByFor: " + sumByFor);
	}

	@Test
	public void testWhile() {
		long sumByWhile = domain.getSumByWhile(a);
		System.out.println("sumByWhile: " + sumByWhile);
	}

	@Test
	public void testRecursion() {
		long sumByrecursion = domain.getSumByrecursion(a, a.length);
		System.out.println("sumByrecursion: " + sumByrecursion);
	}
}