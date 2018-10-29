package test.recursion;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2018-10-29
 * Time: 08:59:23
 * Description:
 */
public class TestRecursion
{
    /**
     * 原始的递归n大于100000时堆栈溢出
     * @param n
     * @return
     */
    public double getTheResult(int n)
    {
        if (n == 1)
        {
            return 1.0;
        }
        else
        {
            return getTheResult(n - 1) * n;
        }
    }


    public double getTheResultTemp(int x,double y)
    {
        if (x ==1)
        {
            return y;
        }
        else
        {
            return getTheResultTemp(x-1,x*y);
        }
    }

    public double getTheResultReality(int x)
    {
        return getTheResultTemp(x,1);
    }



    public static void main(String[] args)
    {
//        double theResult = new TestRecursion().getTheResult(100000);
//
//        System.out.println(theResult);

        /**
         * 35794 is the max number for the stack be right.
         *
         * for the jdk1.8.0_121
         */
        double z = new TestRecursion().getTheResultReality(13794);
        System.out.println(z);
    }
}
