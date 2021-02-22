package knowledgeable.review201901.java.string;

import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-01-14
 * Time: 22:55:44
 * Description:
 * String 的拼接方法以及性能
 */
public class TestStringAppend
{
    @Test
    public void testPlus()
    {
        long timestart = System.currentTimeMillis();
        String a = "a";
        String b = "b";
        String c = null;
        for (int i = 0; i < 100000; i++)
        {
            c = a + b;
        }

        long timeEnd = System.currentTimeMillis() - timestart;
        System.out.println("Plus spend time(ms):" + timeEnd);
    }

    @Test
    public void testConcat()
    {
        long timestart = System.currentTimeMillis();
        String a = "a";
        String b = "b";
        for (int i = 0; i < 100000; i++)
        {
            a.concat(b);
        }
        long timeEnd = System.currentTimeMillis() - timestart;
        System.out.println("Concat spend time(ms):" + timeEnd);
    }

    @Test
    public void testAppend()
    {
        long timestart = System.currentTimeMillis();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("a");
        stringBuffer.append("b");
        for (int i = 0; i < 100000; i++)
        {
            stringBuffer.append("a").append("b");
        }
        long timeEnd = System.currentTimeMillis() - timestart;
        System.out.println("Append spend time(ms):" + timeEnd);
    }
}
