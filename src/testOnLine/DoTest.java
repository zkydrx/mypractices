package testOnLine;

import org.junit.jupiter.api.Test;


/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-10-18
 * Time: 17:05
 * Description:
 */
public class DoTest
{
    @Test
    public void test()
    {
        A a = new A();
        B b = new B();
        a.s(b);
        b = null; /* Line 5 */
        a = null;  /* Line 6 */
        System.out.println("start completed"); /* Line 7 */
    }

    @Test
    public void test1()
    {
        int i = 4,j = 2;
        leftShift(4,2);
        System.out.println(i);
    }

    public static void  leftShift(int i,int j)
    {
        i <<=j;
    }

    @Test
    public void test2()
    {
        System.out.println("f[0] = "+f[0]);
    }

    private static float[] f = new float[2];

}
