package lambda.one;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-08-31
 * Time: 16:11
 * Description:
 */
public class TestB
{


    @FunctionalInterface
    interface Predicate<T>
    {
        boolean test(T t);
    }

    /**
     * 执行Predicate判断
     *
     * @param age       年龄
     * @param predicate Predicate函数式接口
     * @return 返回布尔类型结果
     */
    public static boolean doPredicate(int age, Predicate<Integer> predicate)
    {
        return predicate.test(age);
    }

    public static void main(String[] args)
    {
        boolean isAdult = doPredicate(20, x -> x >= 18);
        System.out.println(isAdult);
    }

    /**
     * 消费型接口示例
     */
    public static void doation(Integer money, Consumer<Integer> consumer)
    {
        consumer.accept(money);
    }

    @Test
    public void testDoation()
    {
        doation(1000, money -> System.out.println("It is sounds good and I got " + money + " $"));
    }

    /**
     * 转换字符串为Integer
     */
    public static Integer convert(String str, Function<String, Integer> function)
    {
        return function.apply(str);
    }

    @Test
    public void testConvert()
    {
        Integer convert = convert("28", x -> Integer.parseInt(x));
        System.out.println(convert);
    }

    /**
     * 断言型接口示例
     */
    public static List<String> filter(List<String> fruit, Predicate<String> predicate)
    {
        List<String> f = new ArrayList<>();
        for (String s : fruit)
        {
            if (predicate.test(s))
            {
                f.add(s);
            }
        }
        return f;
    }

    @Test
    public void testFilter()
    {
        List<String> fruit = Arrays.asList("香蕉", "菠萝", "榴莲", "西瓜", "火龙果", "枇杷果", "人参果");
        List<String> newFruit = filter(fruit, (f) -> f.length() == 3);
        System.out.println(newFruit);
    }
}
