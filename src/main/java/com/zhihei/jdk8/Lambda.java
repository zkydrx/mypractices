package com.zhihei.jdk8;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-11-07
 * Time: 22:57:18
 * Description:
 */
public class Lambda
{
    @Test
    public void test1()
    {
        // Arrays.asList("a", "b", "c").forEach(System.out::println);
        // Arrays.asList("a", "b", "c").forEach((String e) -> System.out.println(e));
        // Arrays.asList("a", "b", "c").forEach(e -> {
        //     System.out.println(e);
        // });

        // Arrays.asList("a", "b", "c").forEach((String e) -> System.out.print(e+","));

        Arrays.asList("b", "a", "d").sort(Comparator.naturalOrder());

        Arrays.asList("b","d","a").sort((e1,e2)->e1.compareTo(e2));
        Arrays.asList("b","d","a").sort((e1,e2)-> e2.compareTo(e1));
        Arrays.asList("b","d","a").sort((e1,e2)-> {return e1.compareTo(e2);});

        Arrays.asList("a", "f", "c","m","b").sort(String::compareTo);
    }

    /**
     * 字符串排序对比测试
     */
    @Test
    public void test2()
    {
        List names = Arrays.asList("tom","jobs","linux");
        Collections.sort(names, new Comparator<String>()
        {
            @Override
            public int compare(String o1, String o2)
            {
                return o2.compareTo(o1);
            }
        });
        System.out.println(Arrays.toString(names.toArray()));
    }

    /**
     * 字符串排序对比测试
     * lambda表达式版
     */
    @Test
    public void test3()
    {
        List names = Arrays.asList("tom","jobs","linux");
        Collections.sort(names, Comparator.naturalOrder());
        System.out.println("1.正序："+Arrays.toString(names.toArray()));
        Collections.sort(names,(String a,String b)-> {return a.compareTo(b);});
        System.out.println("2.正序："+Arrays.toString(names.toArray()));
        Collections.sort(names,(String a,String b)-> a.compareTo(b));
        System.out.println("3.正序："+Arrays.toString(names.toArray()));

    }

}
