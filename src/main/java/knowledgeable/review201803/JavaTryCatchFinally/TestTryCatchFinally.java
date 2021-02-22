package knowledgeable.review201803.JavaTryCatchFinally;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-26
 * Time: 22:54:14
 * Description:
 */
public class TestTryCatchFinally
{
    public static void main(String[] args)
    {
        int i = testTryCatchFinally();
        System.out.println("-------------------");
        System.out.println(i);
    }

    public static int testTryCatchFinally()
    {
        try
        {
            System.out.println("try");
            return 2;
        }
        catch (Exception e)
        {
            System.out.println("catch");
            return 0;
        }
        finally
        {
            System.out.println("finally");
        }
    }
}
