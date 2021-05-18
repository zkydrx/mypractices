package workTest.Bigdecimal;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2018-12-04
 * Time: 13:59:09
 * Description:
 */
public class BigdecimalTest
{
    public static void main(String[] args)
    {
        BigDecimal bigDecimal = BigDecimal.valueOf(0.335234);
        BigDecimal bigDecimal1 = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println(bigDecimal1);
    }
}
