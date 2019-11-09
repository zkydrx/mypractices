package com.zhihei.jdk8;

import java.util.function.Function;

/**
 * @author ZKY
 * @createTime 2019/7/4 23:16
 * @description Function
 */

public class FunctionTest
{
    public static void main(String[] args)
    {

        FunctionTest test = new FunctionTest();

        System.out.println(test.compute(1, value -> {
            return 2 * value;
        }));

        System.out.println(test.compute(2, value -> {
            return 5 + value;
        }));

        System.out.println(test.compute(2, value -> {
            return value * value;
        }));

        System.out.println(test.convert(2, value -> String.valueOf(value) + "hello world"));

        Function<Integer, Integer> function = value -> value * 2;
        System.out.println(test.compute(3, function));


    }

    //                                   入参      返参
    public int compute(int a, Function<Integer, Integer> function)
    {
        int result = function.apply(a);
        return result;
    }


    private String convert(int a, Function<Integer, String> function)
    {
        return function.apply(a);
    }


}
