package workTest;

import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.util.Date;


/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * DateTest: 2018-11-12
 * Time: 15:28:25
 * Description:
 */
public class DateTest
{
    @Test
    public void testTimestamp()
    {
        Date date = new Date();
        /**
         * 2018-11-12 15:39:12.133
         */
        System.out.println(new Timestamp(date.getTime()));

    }
}
