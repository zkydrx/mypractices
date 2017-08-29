package JavaBianCheng.ForWhichRecursion;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-08-29
 * Time: 16:26
 * Description:
 * 使用for循环、while循环和递归写出3个函数来计算给定数列的总和。
 */
public class Domain
{
    private int[] a ={1,2,3,4,5,6,7,8,9,10};

    /**
     * for()循环实现
     * @param a
     * @return
     */
    public long getSumByFor(int[] a)
    {
        long sum =0L;
        for (int i = 0; i < a.length; i++)
        {
            sum+=a[i];
        }
        return sum;
    }

    /**
     * while()循环实现
     * @param a
     * @return
     */
    public long getSumByWhile(int[] a)
    {
        long sum = 0;
        int i = 0;
        while(i < a.length)
        {
            sum += a[i];
            i++;
        }
        return sum;
    }


    /**
     * 递归实现
     * n 为数组的长度
     * @param a
     * @param n
     * @return
     */
    public long getSumByrecursion(int [] a,int n)
    {
        if(n == 0)
        {
            return 0;
        }
        else
        {
           return getSumByrecursion(a,n-1)+a[n-1];
        }

        /**
         * 三目运算符
         * 效果跟上面的if()else()一样。
         */
        //        return n==0?0:getSumByrecursion(a,n-1)+a[n-1];

    }


}
