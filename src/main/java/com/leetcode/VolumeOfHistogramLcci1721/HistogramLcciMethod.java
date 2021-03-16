package com.leetcode.VolumeOfHistogramLcci1721;


import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2021-03-16
 * Time: 14:05:18
 * Description:
 * 题目地址：https://leetcode-cn.com/problems/volume-of-histogram-lcci/
 * 面试题 17.21. 直方图的水量
 * 给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。
 * <p>
 * <p>
 * <p>
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的直方图，在这种情况下，可以接 6 个单位的水（蓝色部分表示水）。 感谢 Marcos 贡献此图。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */
public class HistogramLcciMethod
{
    /**
     * 方法1.找出直方图两侧的最大值，然后取比较小的那个减去该直方图的值即可获得该直方图能装水的数量，
     * 依次循环找到所有的直方图能装水的数量累加起来即可完成任务。时间复杂度O(N^2)
     */
    @Test
    public void test1()
    {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int water = 0;
        for (int i = 1; i < arr.length - 1; i++)
        {
            Integer theLeftMaxNumber = getTheMaxNumber(arr, i);
            Integer theRightMaxNumber = getTheRightMaxNumber(arr, i);
            water += (Math.min(theLeftMaxNumber, theRightMaxNumber) - arr[i]) >= 0 ? (Math.min(theLeftMaxNumber, theRightMaxNumber) - arr[i]) : 0;
        }
    }

    private Integer getTheRightMaxNumber(int[] arr, int i)
    {
        Integer theRightMaxNumber = 0;
        for (int i1 = i + 1; i1 < arr.length; i1++)
        {
            if (arr[i1] > theRightMaxNumber)
            {
                theRightMaxNumber = arr[i1];
            }
        }
        return theRightMaxNumber;
    }

    private Integer getTheMaxNumber(int[] arr, int i)
    {
        Integer theLeftMaxNumber = 0;
        for (int i1 = 0; i1 < i; i1++)
        {
            if (arr[i1] > theLeftMaxNumber)
            {
                theLeftMaxNumber = arr[i1];
            }
        }
        return theLeftMaxNumber;
    }

    /**
     * 方法2.通过预处理数组
     * 通过一次循环，生成左数组（递增数组，里面的每一位都是原数组下标坐标最大的数字。）
     * 通过一次循环，生成右数组（递减数组，里面的每一个数字都是原数组下标右边最大的数字.)
     */
    @Test
    public void test2()
    {
        int water = 0;
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] leftArr = new int[arr.length];
        int[] rightArr = new int[arr.length];
        leftArr[0] = arr[0];
        rightArr[arr.length - 1] = arr[arr.length - 1];
        for (int i = 1; i < arr.length; i++)
        {
            if (arr[i] > leftArr[i - 1])
            {
                leftArr[i] = arr[i];
            }
            else
            {
                leftArr[i] = leftArr[i - 1];
            }
        }
        for (int i = arr.length - 2; i >= 0; i--)
        {
            if (arr[i] > rightArr[i + 1])
            {
                rightArr[i] = arr[i];
            }
            else
            {
                rightArr[i] = rightArr[i + 1];
            }
        }


        for (int i = 0; i < arr.length; i++)
        {
            water += (Math.min(leftArr[i], rightArr[i]) - arr[i]) > 0 ? (Math.min(leftArr[i], rightArr[i]) - arr[i]) : 0;
        }
    }


    /**
     * 方法3：双指针最优解。
     * 左指针从1开始中间移动
     * 右指针从倒数第二位向中间移动
     * 左右指针相遇结束整个遍历。
     */
    @Test
    public void test3()
    {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int N = arr.length;
        int leftMaxNumber = arr[0];
        int rithtMaxNumber = arr[N - 1];
        int leftPoint = 1;
        int rithtPoint = N - 2;
        int water = 0;
        while (leftPoint <= rithtPoint)
        {
            if (leftMaxNumber > rithtMaxNumber)
            {
                water += Math.max(0, rithtMaxNumber - arr[rithtPoint]);
                rithtMaxNumber = Math.max(rithtMaxNumber, arr[rithtPoint--]);
            }
            else
            {
                water += Math.max(0, leftMaxNumber - arr[leftPoint]);
                leftMaxNumber = Math.max(leftMaxNumber, arr[leftPoint++]);
            }
        }

    }


    /**
     * 方法4：测试方法1,2,3的速度
     */
    @Test
    public void test4()
    {
        Long time = System.currentTimeMillis();
        for (long i = 0; i < 1000000000; i++)
        {
            test1();
        }
        Long time1 = System.currentTimeMillis();
        ;
        System.out.println("方法1耗时：" + (time1 - time));

        for (long i = 0; i < 1000000000; i++)
        {
            test2();
        }
        Long time2 = System.currentTimeMillis();
        ;
        System.out.println("方法2耗时：" + (time2 - time1));
        for (long i = 0; i < 1000000000; i++)
        {
            test3();
        }
        Long time3 = System.currentTimeMillis();
        ;
        System.out.println("方法3耗时：" + (time3 - time2));
    }
}
