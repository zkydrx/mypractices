package com.zhihei.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author ZKY
 * @createTime 2019/7/6 0:55
 * @description 谓语
 */

public class PredicateTest2
{
    public static void main(String[] args)
    {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        PredicateTest2 predicateTest2 = new PredicateTest2();
        //打印所有偶数
        predicateTest2.conditionFilter(list, item -> item % 2 == 0);
        System.out.println("-------------");
        //打印所有奇数
        predicateTest2.conditionFilter(list, item -> item % 2 != 0);
        System.out.println("-------------");
        //打印所有
        predicateTest2.conditionFilter(list, item -> true);
        System.out.println("-------------");
        //不打印所有
        predicateTest2.conditionFilter(list, item -> false);
        System.out.println("-------------");

        //大于5且是偶数
        predicateTest2.conditionFilter2(list, item -> item > 5, item -> item % 2 == 0);

        System.out.println("-------------");

        //大于5且是偶数 取反 1234579
        predicateTest2.conditionFilter3(list, item -> item > 5, item -> item % 2 == 0);

        System.out.println("-------------");

        //predicateTest2.isEquest("test") 返回Predicate
        System.out.println(predicateTest2.isEquest("test").test("test"));

        System.out.println(predicateTest2.isEquest(1).test("1"));

    }

    /**
     * 过滤器
     *
     * @param list
     * @param predicate
     */
    public void conditionFilter(List<Integer> list, Predicate<Integer> predicate)
    {
        list.forEach(integer -> {
            if (predicate.test(integer))
            {
                System.out.println(integer);
            }
        });
    }

    public void conditionFilter2(List<Integer> list, Predicate<Integer> predicate, Predicate<Integer> predicate2)
    {
        //串联
        list.forEach(integer -> {
            if (predicate.and(predicate2).test(integer))
            {
                System.out.println(integer);
            }
        });
    }

    public void conditionFilter3(List<Integer> list, Predicate<Integer> predicate, Predicate<Integer> predicate2)
    {
        //串联取反
        list.forEach(integer -> {
            if (predicate.and(predicate2).negate().test(integer))
            {
                System.out.println(integer);
            }
        });
    }

    public Predicate<String> isEquest(Object object)
    {
        return Predicate.isEqual(object);

    }
}

