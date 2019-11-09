package com.zhihei.jdk8.stream;

import java.util.stream.IntStream;

/**
 * @author ZKY
 * @createTime 2019/7/8 0:43
 * @description
 */

public class StreamTest8
{

    public static void main(String[] args)
    {

        //IntStream.iterate(0, i -> (i + 1) % 2).distinct().limit(6).forEach(System.out::println);//程序未停止

        //distinct先于limit执行 程序一直在生成数据 则distinct一直在去重 虽然这里逻辑只返回0，1 但程序不知道
        IntStream.iterate(0, i -> (i + 1) % 2).limit(6).distinct().forEach(System.out::println);

    }
}
