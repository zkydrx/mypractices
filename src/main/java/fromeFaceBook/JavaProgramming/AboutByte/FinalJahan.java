package fromeFaceBook.JavaProgramming.AboutByte;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-12-08
 * Time: 23:39
 * Description:
 */
public class FinalJahan
{
    public static void main(String[] args)
    {
        final byte J = 64, A = 64;
        /**
         * 这种表示方法由于J 和 A 都是静态变量等于直接定义一个byte的变量=128由于byte.由于byte类型
         * 的范围时候-128~127所以要在这里面才可以。
         * final byte sum = J + A;
         */
        final byte sum = (byte) (J + A);


        byte x = 1;
        byte y = 2;
        /**
         * byte z = x + y
         * 由于x和y都是byte的变量。但是x+y的结果就是整型结果，而定义的byte变量所以将整形转为byte
         * 型会损失精度。故上面的写法会报损失精度的错误。
         */
        byte z = (byte) (x + y);
        System.out.println("Your result is " + sum);

        if (sum == 128)
        {
            System.out.println("you prosperous");
        }
        else
        {
            System.out.println("Sorry! you not prosperous");
        }
    }
}
