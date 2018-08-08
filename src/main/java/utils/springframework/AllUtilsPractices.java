package utils.springframework;

import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2018-08-08
 * Time: 20:24:21
 * Description:
 */
public class AllUtilsPractices
{
    @Test
    public void testBeanUtils()
    {
        Car car = new Car();
        car.setName("Audi");
        car.setHeight(BigDecimal.valueOf(3000L));
        car.setHeight(BigDecimal.valueOf(1.5));
        car.setPrice(BigDecimal.valueOf(200000));
        car.setTradeMark("Audi");
        Person person = new Person();
        BeanUtils.copyProperties(car,person);
        System.out.println(person.toString());
    }
}
