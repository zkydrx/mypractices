package knowledgeable.review201901.java.string;

import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-01-24
 * Time: 22:01:47
 * Description:
 */
public class TestStringHash
{
    @Test
    public void testStringHash()
    {
        String s = "123";
        System.out.println((int) '1');
        System.out.println((int) '2');
        System.out.println((int) '3');
        System.out.println(s.hashCode());
        System.out.println((((int) '1') * 31 + ((int) '2')) * 31 + (int) '3');
        System.out.println("(49*31+50)*31+51 = " + ((49 * 31 + 50) * 31 + 51));

    }
}
