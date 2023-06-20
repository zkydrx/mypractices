package com.zjtyd.tms.BigDecimalTest;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created with IntelliJ IDEA. User: Abbot Date: 2017-10-12 Time: 15:00
 * Description: BigDecimal's compute
 * <p>
 * <p>
 * static BigDecimal ONE − The value 1, with a scale of 0.
 * <p>
 * static int ROUND_CEILING − Rounding mode to round towards positive infinity.
 * <p>
 * static int ROUND_DOWN − Rounding mode to round towards zero.
 * <p>
 * static int ROUND_FLOOR − Rounding mode to round towards negative infinity.
 * <p>
 * static int ROUND_HALF_DOWN − Rounding mode to round towards "nearest
 * neighbor" unless both neighbors are equidistant, in which case round down.
 * <p>
 * static int ROUND_HALF_EVEN − Rounding mode to round towards the "nearest
 * neighbor" unless both neighbors are equidistant, in which case, round towards
 * the even neighbor.
 * <p>
 * static int ROUND_HALF_UP − Rounding mode to round towards "nearest neighbor"
 * unless both neighbors are equidistant, in which case round up.
 * <p>
 * static int ROUND_UNNECESSARY − Rounding mode to assert that the requested
 * operation has an exact result, hence no rounding is necessary.
 * <p>
 * static int ROUND_UP − Rounding mode to round away from zero.
 * <p>
 * static BigDecimal TEN − The value 10, with a scale of 0.
 * <p>
 * static BigDecimal ZERO − The value 0, with a scale of 0.
 */
public class BigdecimalTest1 {
	@Test
	public void testOne() {
		BigDecimal bg1;
		BigDecimal bg2;
		BigDecimal bg3;
		bg1 = new BigDecimal("16");
		bg2 = new BigDecimal("9");
		bg3 = bg1.divide(bg2, 3, BigDecimal.ROUND_DOWN);
		String str = "Division result is " + bg3;
		System.out.println("" + Math.scalb(2, 1));
		System.out.println("Division result is " + bg1.divide(bg2, 1, RoundingMode.CEILING) + "\tCEILING");
		System.out.println("Division result is " + bg1.divide(bg2, 2, BigDecimal.ROUND_DOWN) + "\tROUND_DOWN");
		System.out.println("Division result is " + bg1.divide(bg2, 3, BigDecimal.ROUND_FLOOR) + "\tROUND_FLOOR");
		System.out
				.println("Division result is " + bg1.divide(bg2, 4, BigDecimal.ROUND_HALF_DOWN) + "\tROUND_HALF_DOWN");

	}
}
