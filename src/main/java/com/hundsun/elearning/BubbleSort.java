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
        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < array.length - i - 1; j++)
            {
                if (array[j] > array[j + 1])
                {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    public static void main(String[] args)
    {
        Integer[] array = {2, 8, 3, 1, 7, 5, 10, 4, 9, 6};

        Integer[] integers = bubbleSort(array);
        Integer[] integers1 = bubbleSortOne(array);

        for (Integer integer : integers)
        {
            System.out.println(integer);
        }
        for (Integer integer : integers1)
        {
            System.out.println(integer);
        }
    }

    /**
     * 练习
     * @param arr
     * @return
     */
    public static Integer[] bubbleSortOne(Integer[] arr)
    {

        int temp;
        for (int i = 1; i < arr.length; i++)
        {
            for (int j = 0; j < arr.length - i - 1; j++)
            {
                if (arr[j] > arr[j + 1])
                {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
}
