package knowledgeable.review201901.spring.aop;

import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2019-01-13 Time: 17:30:03
 * Description:
 */
@Component
public class AddCalculator implements Calculator {

	@Override
	public double getResult(double a, double b) {
		System.out.println("a+b = " + (a + b));
		return a + b;
	}
}
