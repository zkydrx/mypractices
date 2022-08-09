package com.hundsun.elearning.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 轮询调度算法(Round - Robin Scheduling)
 */
public class RoundRobinScheduling
{

    public static void main(String[] args)
    {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        list.add("10");
        list.add("11");
        int n = list.size();
        int i = n - 1;
        for (int step = 0; step <= 100; step++)
        {
            i = getRoundRobinScheduling(i, n);
            System.out.println("N[" + i + "]=" + list.get(i));
        }
    }

    /**
     * 调度算法核心
     * 传入调用id的序号i,以及服务器总台数n，返回结果就是需要调用的服务器序号
     * @param i
     * @param n
     * @return
     */
    private static int getRoundRobinScheduling(int i, int n)
    {
        int j;
        do
        {
            j = (i + 1) % n;
            i = j;
        }
        while (j != i);
        return i;
    }

}

