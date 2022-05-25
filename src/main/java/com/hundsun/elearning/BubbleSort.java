package com.hundsun.elearning;

/**
 * @ProjectName: mypractices
 * @Package: com.hundsun.elearning
 * @ClassName: BubbleSort
 * @Author: hspcadmin
 * @Description: 冒泡排序算法
 * @Date: 2022-05-25 20:19
 * @Version: 1.0
 */
public class BubbleSort
{
    public static Integer[] bubbleSort(Integer[] array)
    {
        for (int j = 1; j < array.length; j++)
        {
            for (int i = 0; i < array.length - j; i++)
            {
                if (array[i] > array[i + 1])
                {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }
        return array;
    }

    public static void main(String[] args)
    {
        Integer[] array = {2, 8, 3, 1, 7, 5, 10, 4, 9, 6};

        Integer[] integers = bubbleSort(array);

        for (Integer integer : integers)
        {
            System.out.println(integer);
        }
    }
}
