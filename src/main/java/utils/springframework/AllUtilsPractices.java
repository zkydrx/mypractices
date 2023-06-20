package utils.springframework;

import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.util.AlternativeJdkIdGenerator;
import org.springframework.util.Base64Utils;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2018-08-08 Time: 20:24:21
 * Description:
 */
public class AllUtilsPractices {
	@Test
	public void testBeanUtils() {
		Car car = new Car();
		car.setName("Audi");
		car.setWeight(BigDecimal.valueOf(3000L));
		car.setHeight(BigDecimal.valueOf(1.5));
		car.setPrice(BigDecimal.valueOf(200000));
		car.setTradeMark("Audi");
		Person person = new Person();
		BeanUtils.copyProperties(car, person);
		System.out.println(person.toString());
	}

	@Test
	public void testAlternativeJdkIdGenerator() {

		AlternativeJdkIdGenerator alternativeJdkIdGenerator = new AlternativeJdkIdGenerator();
		UUID uuid = alternativeJdkIdGenerator.generateId();

		/**
		 * 0333f5e7-aa4f-635f-9f53-fd652153414e
		 */
		System.out.println(uuid);

	}

	@Test
	public void testBase64Utils() {
		byte[] encode = Base64Utils.encode(new String("123").getBytes());

		System.out.println(encode);

		byte[] decode = Base64Utils.decode(encode);

		System.out.println(decode);

		String s = Base64Utils.encodeToString(new String("123").getBytes());

		System.out.println(s);
		byte[] bytes = Base64Utils.decodeFromString(s);

		System.out.println(bytes);
	}

}
