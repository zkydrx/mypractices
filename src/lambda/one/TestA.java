package lambda.one;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-08-31
 * Time: 01:04
 * Description:
 */
public class TestA
{
    /**
     * 用lambda表达式实现Runnable
     */
    @Test
    public void testOne()
    {
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                System.out.println("Before Java8,too much code for too little to do");
            }
        }).start();

        new Thread(() -> System.out.println("In Java8,Lambda expression rocks!!")).start();
    }

    /**
     * 使用Java 8 lambda表达式进行事件处理
     */
    @Test
    public void testTwo()
    {
        JButton show = new JButton("Show");
        /**
         * java8 以前
         */
        show.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("Event handing without lamdba expression is boring");
            }
        });

        /**
         * java8 以后
         */
        show.addActionListener((e) -> {
            System.out.println("Light, Camera, Action !! Lambda expressions Rocks");
        });
    }


    /**
     * 使用lambda表达式对列表进行迭代
     */
    @Test
    public void testThree()
    {

        List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        /**
         * java8 以前
         */
        for (Object feature : features)
        {
            System.out.println(feature);
        }

        System.out.println("==============================================================");
        /**
         * java8 以后
         */
        features.forEach(n -> System.out.println(n));
        System.out.println("==============================================================");

        /**
         * 使用java8的方法引用更方便，方法引用由：双冒号操作符标示，
         * 看起来像C++的作用于解析运算符
         */
        features.forEach(System.out::println);
    }

    /**
     * 使用lambda表达式和函数式接口Predicate
     */
    @Test
    public void testFour()
    {
        List<String> laguages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");


        System.out.println("Languages with starts with J");
        List<String> stringList = laguages.stream().filter((str) -> str.startsWith("J")).collect(Collectors.toList());
        System.out.println(stringList);
        List<String> a = laguages.stream().filter((str) -> str.endsWith("a")).collect(Collectors.toList());
        System.out.println(a);
        System.out.println("Print contain 'Ha': ");
        List<String> p = laguages.stream()
                                 .filter((str) -> str.contains("Ha"))
                                 .collect(Collectors.toList());
        System.out.println(p);
        System.out.println("Print all languages: ");
        List<String> collect = laguages.stream().collect(Collectors.toList());
        System.out.println(collect);

        System.out.println("Print no languages: ");
        List<String> collect1 = laguages.stream().filter((str) -> false).collect(Collectors.toList());
        System.out.println(collect1);

        System.out.println("Print language whoes length greater than 4: ");
        List<String> collect2 = laguages.stream().filter((str) -> str.length() > 4).collect(Collectors.toList());
        System.out.println(collect2);



    }

    public static void filter(List<String> names, Predicate condition)
    {
//        names.stream().filter((name) -> (condition.test(name))).forEach((name) -> {
//            System.out.println(name + " ");
//        });
        for(String name: names)
        {
            if(condition.test(name))
            {
                System.out.println(name+ " ");
            }
        }
    }

    /**
     * Java 8中使用lambda表达式的Map和Reduce示例
     */
    @Test
    public void testSix()
    {

        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);

        /**
         * 不使用lambda表达式为每个订单加上12%的税
         */
        for (Integer cost : costBeforeTax)
        {
            double price = cost + .12 * cost;
            System.out.println(price);
        }

        System.out.println("*************************************************************");
        /**
         * 使用lambda表达式
         */
        costBeforeTax.stream().map((cost) -> cost + .12 * cost).forEach(System.out::println);
    }

    /**
     * Java 8中使用lambda表达式的Map和Reduce示例
     */
    @Test
    public void testSixBranch()
    {
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        /**
         * 老方法
         */
        double total = 0;
        for (Integer cost : costBeforeTax)
        {
            double price = cost + .12 * cost;
            total += price;
        }
        System.out.println("Total: " + total);


        /**
         * lamdba方法
         */
        double bill = costBeforeTax.stream().map((cost) -> cost + .12 * cost).reduce((sum, cost) -> sum + cost).get();
        System.out.println("Total: " + bill);

    }

    /**
     * 通过过滤创建一个String列表
     */
    @Test
    public void testEight()
    {
        String[] str = {"zky", "drx", "z", "k", "y", "d", "r", "x", "zk", "yes", "Hear", "Oh"};
        List<String> strList = Arrays.asList(str);
        List<String> filtered = strList.stream().filter(x -> x.length() > 0).collect(Collectors.toList());
        System.out.println(filtered);
    }


    /**
     * 对列表的每个元素应用函数
     */
    @Test
    public void testNine()
    {
        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K", "Canada");
        String G7Countries = G7.stream().map(x -> x.toUpperCase()).collect((Collectors.joining(",")));
        System.out.println(G7Countries);

    }

    /**
     * 复制不同的值，创建一个子列表
     */
    @Test
    public void testTen()
    {
        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> distinct = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        System.out.printf("Original List: %s, Square Without duplicates : %s %n", numbers, distinct);
    }

    /**
     * 计算集合元素的最大值、最小值、总和以及平均值
     */
    @Test
    public void testEvelen()
    {
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("Highest prime number in List : " + stats.getMax());
        System.out.println("Lowest prime number in List : " + stats.getMin());
        System.out.println("Sum of all prime numbers : " + stats.getSum());
        System.out.println("Average of all prime numbers : " + stats.getAverage());
        System.out.println("The list of size : " + stats.getCount());
    }

}
