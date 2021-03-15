package sort.method;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2021-03-15
 * Time: 19:42:17
 * Description:
 * 选择排序算法
 */
public class SelectionSort
{
    public static void main(String[] args)
    {
        Long time = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++)
        {
            selectSort();
        }
        System.out.println("計算1000000次耗時：" + (System.currentTimeMillis() - time));


    }

    private static void selectSort()
    {
        Integer[] arr = {1, 3, 2, 4, 6, 7, 5, 9, 8, 11, 10};

        for (int i = 0; i < arr.length; i++)
        {
            Integer minArea = i;
            for (int i1 = i + 1; i1 < arr.length; i1++)
            {
                if (arr[i1] < arr[minArea])
                {
                    minArea = i1;
                }
            }
            swapValue(arr, i, minArea);
        }
    }

    private static void swapValue(Integer[] arr, int i, Integer minArea)
    {
        Integer temp = arr[i];
        arr[i] = arr[minArea];
        arr[minArea] = temp;
    }
}
