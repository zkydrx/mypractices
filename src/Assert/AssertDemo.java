package Assert;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-09-15
 * Time: 01:56
 * Description:
 * 断言
 */
public class AssertDemo
{
    public static double initDemo(double i)
    {
//        assert i > 0:i;
        return Math.sqrt(i);
    }
    public static void main(String[] args)
    {
        double v = initDemo(-10);

        System.out.println(v);
    }
}
