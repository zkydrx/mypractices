package JavaBianCheng.GetMaxNum;

import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-08-30
 * Time: 02:05
 * Description:
 * 获取一个列表的全排列
 */
public class AllSort
{

    public static void permutation(char[] s, int from, int to)
    {
        if (to <= 1)
            return;
        if (from == to)
        {
            System.out.println(s);
        } else
        {
            /**
             * 这个循环好好理解理解。
             */
            for (int i = from; i <= to; i++)
            {
                swap(s, i, from);
                permutation(s, from + 1, to);
                swap(s, from, i);
            }
        }
    }

    public static void swap(char[] s, int i, int j)
    {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }


    @Test
    public void testAllSort()
    {
        char[] x1 = {'a', 'b', 'c', 'd'};
        permutation(x1, 0, 3);
    }
}
