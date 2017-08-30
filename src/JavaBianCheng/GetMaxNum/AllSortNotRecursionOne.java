package JavaBianCheng.GetMaxNum;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-08-30
 * Time: 10:07
 * Description:
 */
public class AllSortNotRecursionOne
{

    //方法2：字典序排列
    /*
     * 参数arrayA：给定字符串的字符数组
     * 函数功能：输出字符串数组的所有字符的字典序全排列
     */
    public void dictionaryArrange(char[] arrayA)
    {
        System.out.println(String.valueOf(arrayA));
        while (allArrange(arrayA))
            System.out.println(String.valueOf(arrayA));
    }

    //判断当前数组arrayA序列是否可以进行字典序排列，如可以则进行排列并返回true，否则返回false
    public boolean allArrange(char[] arrayA)
    {
        int i;
        for (i = arrayA.length - 2; (i >= 0) && arrayA[i] > arrayA[i + 1]; --i)
            ;
        if (i < 0)
            return false;
        int k;
        for (k = arrayA.length - 1; (k > i) && arrayA[i] >= arrayA[k]; --k)
            ;
        swap(arrayA, i, k);
        reverseArray(arrayA, i + 1, arrayA.length - 1);
        return true;
    }

    //将数组中a[m]到a[n]一段元素反序排列
    public void reverseArray(char[] arrayN, int m, int n)
    {
        while (m < n)
        {
            char temp = arrayN[m];
            arrayN[m++] = arrayN[n];
            arrayN[n--] = temp;
        }
    }

    //交换数组m位置和n位置上的值
    public void swap(char[] arrayA, int m, int n)
    {
        char temp = arrayA[m];
        arrayA[m] = arrayA[n];
        arrayA[n] = temp;
    }

    public static void main(String[] args)
    {
        AllSortNotRecursionOne test = new AllSortNotRecursionOne();
        String A = "abc";
        char[] arrayA = A.toCharArray();
        test.dictionaryArrange(arrayA);
    }

}
