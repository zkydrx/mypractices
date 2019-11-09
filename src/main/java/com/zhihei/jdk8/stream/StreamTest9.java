package com.zhihei.jdk8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author ZKY
 * @createTime 2019/7/8 22:53
 * @description 串行流和并行流
 */

public class StreamTest9
{

    public static void main(String[] args)
    {
        List<String> list = new ArrayList<>(5000000);
        for (int i = 0; i < 5000000; i++)
        {
            list.add(UUID.randomUUID().toString());
        }
        System.out.println("开始排序====");
        long startTime = System.nanoTime();
        //串行
        //list.stream().sorted().count(); 4秒左右

        //并行
        list.parallelStream().sorted().count();//1.8秒左右

        long endTime = System.nanoTime();
        //纳秒转换为毫秒
        long millis = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
        System.out.println("排序耗时：" + millis);


    }
}
