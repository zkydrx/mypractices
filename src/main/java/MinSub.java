import java.util.*;

/**
 * Created by ZKY on 2017-05-25 9:17 PM.
 *
 * 给定两个整数数组（第一个是数组 A，第二个是数组 B），
 * 在数组 A 中取 A[i]，数组 B 中取 B[j]，A[i]
 * 和 B[j]两者的差越小越好(|A[i] - B[j]|)。
 * 返回最小差。
 * 样例
 给定数组 A = [3,4,6,7]， B = [2,3,8,9]，返回 0。
 */
public class MinSub
{
    public int smallestDifference(int[] A, int[] B)
    {
        // write your code here
        Set<Integer> list = new HashSet<>();
        for (int i = 0; i < A.length; i++)
        {
            for (int j = 0; j < B.length; j++)
            {
                int jueDuizhi = getJueDuizhi(A[i], B[j]);
                list.add(jueDuizhi);
            }
        }

        int[] array = new int[list.size()];
        Iterator iterator = list.iterator();
        int i1 =0;
        while (iterator.hasNext())
        {
            array[i1] = (int) iterator.next();
            i1++;
        }



        /**
         * 用于接得到的最小值
         */
        int te1 = 0;
        /**
         * 用一趟排序找出最小值
         */
        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < array.length; j++)
            {
                if(array[i] > array[j])
                {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
            te1 = array[0];
            break;
        }



//        /**
//         * 冒泡排序算法,最小的绝对值就是数组的最后一位。array[array.length -1]
//         */
//
//        for(int i = 0; i < array.length -1; i++)
//        {
//            for(int j = 0; j < array.length - 1 - i; j++)
//            {
//                if(array[j] < array[j+1])
//                {
//                    int temp = array[j];
//                    array[j] = array[j+1];
//                    array[j+1] = temp;
//                }
//            }
//        }
        return te1;
    }

    /**
     * 获取两个数差的绝对值
     * @param a
     * @param b
     * @return
     */
    public static int getJueDuizhi(int a, int b)
    {
        if (a - b > 0)
        {
            return a - b;
        } else
        {
            return b - a;
        }
    }

    public static void main(String[] args)
    {
        MinSub minSub = new MinSub();
        int i = minSub.smallestDifference(new int[]{3}, new int[]{10,8,16,19,6});
        System.out.println(i);
    }
}
