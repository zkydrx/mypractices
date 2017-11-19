package fromeFaceBook.JavaProgramming.Mathematics;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-11-19
 * Time: 23:53
 * Description:
 */
public class HowTheY
{
    public static void main(String[] args)
    {
        int y = 0;
        while ( y < 14)
        {
            y++;
            for (int i = 0; i < 4; i++)
            {
                y += i;
            }

        }
        System.out.println(y);
    }
}
