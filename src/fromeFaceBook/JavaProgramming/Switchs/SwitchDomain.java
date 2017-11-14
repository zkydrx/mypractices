package fromeFaceBook.JavaProgramming.Switchs;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-11-14
 * Time: 23:32
 * Description:
 */
public class SwitchDomain
{
    public static void main(String[] args)
    {
        int x = 2;
        switch (x)
        {
            case 1:
                x += 2;
                break;
            case 2:
                x++;
            case 3:
                x += 4;
            default:
                x += 2;
        }

        System.out.println(x);
    }
}
