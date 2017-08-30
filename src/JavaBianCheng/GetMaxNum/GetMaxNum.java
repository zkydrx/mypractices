package JavaBianCheng.GetMaxNum;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-08-30
 * Time: 01:31
 * Description:
 * 编写一个能将给定非负整数列表中的数字排列成最大数字的函数。例如，给定[50，2，1,9]，最大数字为95021。
 */
public class GetMaxNum
{
    /**
     * 待完成...
     * @param a
     * @return
     */
    public long getMaxNum(char[] a)
    {

        List<Integer> permutation = permutation(a, 0, a.length - 1);
        for (int i = 0; i < permutation.size(); i++)
        {
//            for(int j = 0; j < permutation.size(); j++)
//            {
//
//            }
            System.out.println(permutation.get(i));
        }
        return 0L;
    }


    public List permutation(char[] s, int from, int to)
    {
        List resultList = new ArrayList();
        if (to <= 1)
            return null;
        if (from == to)
        {
            resultList.add(s);
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
        return resultList;
    }

    public static void swap(char[] s, int i, int j)
    {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    public static void swapNum(List<Integer> a, int i, int j)
    {
        int temp =a.get(i);
        a.set(i,a.get(j));
        a.set(j,temp);
    }
}
