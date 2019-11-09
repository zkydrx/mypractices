package com.zhihei.jdk8;

import java.util.Optional;

/**
 * @author ZKY
 * @createTime 2019/7/6 11:27
 * @description
 */

public class OptionalTest
{

    public static void main(String[] args)
    {

        Optional<String> optional = Optional.of("hello");//这里值为null时 在构造时会直接抛出NPE

        Optional<String> optional1 = Optional.empty();

        //        if (optional.isPresent())
        //            System.out.println(optional.get());

        //采用函数风格
        optional.ifPresent(item -> System.out.println(item));

        System.out.println("---------------");

        //为空 则取默认值
        System.out.println(optional.orElse("world"));

        System.out.println("---------------");

        System.out.println(optional1.orElseGet(() -> "nihao"));
    }
}
