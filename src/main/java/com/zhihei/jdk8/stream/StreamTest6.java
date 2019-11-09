package com.zhihei.jdk8.stream;

import java.util.IntSummaryStatistics;
import java.util.UUID;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author ZKY
 * @createTime 2019/7/7 23:21
 * @description
 */

public class StreamTest6
{

    public static void main(String[] args)
    {
        //Supplier 无参返回一个值
        Stream<String> stream = Stream.generate(UUID.randomUUID()::toString);
        //system.out.println(stream.findFirst().get());
        stream.findFirst().ifPresent(System.out::println);

        //初始值1  累加2  后面limit不操作就变成无限流
        Stream.iterate(1, item -> item + 2).limit(6).forEach(System.out::println);

        System.out.println("----------------");

        System.out.println(Stream.iterate(1, item -> item + 2).limit(6).filter(item -> item > 2)//大于2的元素
                                 .mapToInt(i -> i * 2)//乘以2 这里不用map 避免自动装箱
                                 .skip(2)//跳过前2个元素
                                 .limit(2).peek(e -> System.out.println("limit 2: " + e))//查看流经管道中某个点的元素
                                 .sum());
        //.reduce(0, Integer::sum));

        System.out.println(Stream.iterate(1, item -> item + 3).limit(6).filter(item -> item > 2)//大于2的元素
                                 .mapToInt(i -> i * 2)//乘以2 这里不用map 避免自动装箱
                                 .skip(2)//跳过前2个元素
                                 .limit(2).peek(e -> System.out.println("limit 2: " + e))//查看流经管道中某个点的元素
                                 .min());//集合为空sum则为0  min和max 集合中可能为空 则返回的是OptionalInt[最小值]

        System.out.println("----------------");

        Stream.iterate(1, item -> item + 2).limit(6).filter(item -> item > 2)//大于2的元素
              .mapToInt(i -> i * 2)//乘以2 这里不用map 避免自动装箱
              .skip(2)//跳过前2个元素
              .limit(2).min().ifPresent(System.out::println);

        System.out.println("----------------");

        IntSummaryStatistics summaryStatistics = Stream.iterate(1, item -> item + 2).limit(6).filter(item -> item > 200)//大于2的元素
                                                       .mapToInt(i -> i * 2)//乘以2 这里不用map 避免自动装箱
                                                       .skip(2)//跳过前2个元素
                                                       .limit(2).summaryStatistics();//返回空的流
        System.out.println(summaryStatistics.getMax());//-2147483648
        System.out.println(summaryStatistics.getMin());//2147483647 //比最小值小溢出

        //stream.distinct 去重
        // 重复流使用操作时会报错
        //stream has already been operated upon or closed

        //规避错误
        IntStream stream1 = Stream.iterate(1, item -> item + 2).limit(6).filter(item -> item > 2)//大于2的元素
                                  .mapToInt(i -> i * 2)//乘以2 这里不用map 避免自动装箱
                                  .skip(2)//跳过前2个元素
                                  .limit(2);

        System.out.println(stream1);
        IntStream stream2 = stream1.filter(item -> item > 2);
        System.out.println(stream2);
        IntStream stream3 = stream2.distinct();
        System.out.println(stream3);
    }
}
