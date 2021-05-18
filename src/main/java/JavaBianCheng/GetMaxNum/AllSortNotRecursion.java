package JavaBianCheng.GetMaxNum;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-08-30
 * Time: 09:31
 * Description:
 */
public class AllSortNotRecursion
{

    public void runNoRecursionOfPermutation(int[] a)
    {

        Arrays.sort(a);// 对数组排序
        while (true)
        {
            printArray(a);// 输出一个排列
            int i;// 从后向前，记录一对顺序值中的小值下标
            int j;// 从后向前，记录比i大的第一个数
            for (i = a.length - 2; i >= 0; i--)
            {
                //找到第一个顺序的位置，比如1243，i便是1
                if (a[i] < a[i + 1])
                {
                    break;
                }
                else if (a[i] >= a[i + 1] && i == 0)
                {
                    // 说明是最大逆序数退出函数，其实就是变成了一个最大的逆序数，如4321
                    //表示此时已经将全部组合输出完毕了
                    return;
                }
            }
            //找到第一个比i位置数大的元素，这里注意后面的逆序中最后一个元素是最小的
            for (j = a.length - 1; j > i; j--)
            {
                if (a[j] > a[i])// 找到j跳出
                    break;
            }
            swap(a, i, j);// 交换i，j
            reverse(a, i + 1, a.length - 1);// 翻转
        }
    }

    public void swap(int[] a, int i, int j)
    {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public void reverse(int[] a, int i, int j)
    {
        while (i < j)
        {
            swap(a, i++, j--);
        }
    }

    public void printArray(int[] a)
    {
        for (int i = 0; i < a.length; i++)
        {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        AllSortNotRecursion robot = new AllSortNotRecursion();
        int[] a = {1, 2, 3};
        robot.runNoRecursionOfPermutation(a);
    }


}
