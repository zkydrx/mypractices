package fromalibaba;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-11-29
 * Time: 11:08
 * Description:
 * come from alibaba's java develop book
 * 【推荐】使用索引访问用String 的split 方法得到的数组时，需做最后一个分隔符后有无
 * 内容的检查，否则会有抛IndexOutOfBoundsException 的风险。
 */
public class SplitToArray
{
    public static void main(String[] args)
    {
        String str = "a,b,c,d,,";
        String[] split = str.split(",");

        System.out.println(split.length);
    }
}
