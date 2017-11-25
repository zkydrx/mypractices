package fromeFaceBook.HandingException;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-10-03
 * Time: 20:28
 * Description:
 */
public class MyException
{
    public static void main(String[] args)
    {
        int x = 0;
        int y = 4;
        try
        {
            System.out.println("a");
            y = y / x;
            System.out.println("b");
        }
        catch (ArithmeticException ae)
        {
            System.out.println("c");
        }
        finally
        {
            System.out.println("d");
        }
    }
}
