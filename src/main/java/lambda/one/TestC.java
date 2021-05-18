package lambda.one;

import org.junit.jupiter.api.Test;

import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;


/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-08-31
 * Time: 16:41
 * Description:
 */
public class TestC
{
    @Test
    public void test1()
    {
        Runnable run = () -> System.out.println("Hello World");
        run.run();

        ActionListener listener = event -> System.out.println("button checked");//2

        Runnable multiLine = () -> {
            System.out.println("Hello");
            System.out.println("World");
        };
        multiLine.run();
        BinaryOperator<Long> add = (Long x, Long y) -> y;
        Long apply = add.apply(3L, 2L);
        System.out.println(apply);

        BinaryOperator<Long> addImplicit = (x, y) -> x + y;
        Long apply1 = addImplicit.apply(3L, 34L);
        System.out.println(apply1);
    }

    /**
     * 选出以数字开头的字符串。
     */
    @Test
    public void test2()
    {
        List<String> list = Arrays.asList("lone", "zky", "one", "1x", "2y", "3z", "Application", "artifacts", "lanuch", "eclipse");
        /**
         * Before java8
         */
        for (String s : list)
        {
            if (Character.isDigit(s.charAt(0)))
            {
                System.out.println(s);
            }
        }

        /**
         * After java8
         */
        list.stream()//1.得到容器的stream.
            .filter(str -> Character.isDigit(str.charAt(0)))//2.选出以数字开头的字符串。
            .forEach(str -> System.out.println(str));//3.输出字符串。

    }


    /**
     * 选出不是数字开头的字符串，并将其转为大写，将结果放到集合当中
     */
    @Test
    public void test3()
    {
        List<String> list = Arrays.asList("lone", "1zky", "three", "4Four");

        Set<String> collect = list.stream()//1.得到容器的stream。
                                  .filter(str -> !Character.isDigit(str.charAt(0)))//2. 筛选出不以数字开头的字符串
                                  .map(String::toUpperCase)//3.将选出的字符串的首字母转为大写
                                  .collect(Collectors.toSet());//4.生成结果集
        System.out.println(collect);
    }


    /**
     * 自己发挥吧。
     * 1.打印所有的字符串用lamdba来打印
     */
    @Test
    public void test4()
    {
        List<String> strings = Arrays.asList("Abbot", "www", "Eclipse", "IntelliJ IDEA", "Fruit", "Apple", "Microsoft", "Google", "BaiDu");
        strings.forEach(n -> System.out.print(n + " "));
        System.out.println();
        strings.forEach(System.out::print);
    }


}
