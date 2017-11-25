package JavaBianCheng.Fibonacci;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-08-30
 * Time: 01:11
 * Description:
 * 编写一个计算前100位斐波那契数的函数。根据定义，斐波那契序列的前两位数字是0和1，随后的每个数字是前两个数字的和。
 * 例如，前10位斐波那契数为：0，1，1，2，3，5，8，13，21，34。
 */
public class Fibonacci
{
    /**
     * 输入一个正整数，返回该正整数位的斐波那契数列。
     * @param n
     * @return
     */
    public List getFibonacciForN(int n)
    {
        List resultList = new ArrayList();
        if(n == 1)
        {
            resultList.add(0);
            return resultList;
        }
        else if(n == 2)
        {
            resultList.add(0);
            resultList.add(1);
        }
        else
        {
            int [] array = new int[n];
            array[0] = 0;
            array[1] = 1;
            resultList.add(array[0]);
            resultList.add(array[1]);
            for(int i = 2; i < n; i++)
            {
                array[i] = array[i-1]+array[i-2];
                resultList.add(array[i]);
            }
            return resultList;
        }
        return resultList;
    }
}
