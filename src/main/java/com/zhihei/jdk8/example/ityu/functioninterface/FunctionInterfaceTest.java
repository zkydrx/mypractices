package com.zhihei.jdk8.example.ityu.functioninterface;

import com.zhihei.jdk8.example.ityu.functioninterface.impl.MyFunctionInterfaceImpl;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-11-13
 * Time: 00:01:10
 * Description:
 * 函数式接口的使用:一般可以作为方法的参数和返回值类型
 */
public class FunctionInterfaceTest
{
    /**
     * 定义一个方法,参数使用函数式接口MyFunctionalInterface
     *
     * @param myFunctionInterface
     */
    public static void show(MyFunctionInterface myFunctionInterface)
    {
        myFunctionInterface.hello();
    }

    @Test
    public void testFunctionInterface()
    {
        /**
         * 调用show方法,方法的参数是一个接口,所以可以传递接口的实现类对象
         */
        show(new MyFunctionInterfaceImpl());

        /**
         * 调用show方法,方法的参数是一个接口,所以我们可以传递接口的匿名内部类
         */
        show(new MyFunctionInterface()
        {
            @Override
            public void hello()
            {
                System.out.println("使用匿名内部类重写MyFunctionInterface接口中的抽象方法");
            }
        });
        /**
         * 调用show方法，由于show方法的参数是一个函数式接口，所以我们可以使用lambda表达式
         */
        show(() -> {
            System.out.println("使用lambda表达式重写MyFunctionInterface接口中的抽象方法");
        });

        /**
         * 简洁版的lambda
         */
        show(() -> System.out.println("使用lambda表达式重写MyFunctionInterface接口中的抽象方法"));
    }


    /**
     * 函数式接口和普通方法的差异
     */
    public static void print1(String message)
    {
        System.out.println(message);
    }

    public static void print2(Supplier<String> message)
    {
        System.out.println(message.get());
    }

    /**
     * 以上代码会得到同样的结果，但使用了函数式接口相当于把数据进行了延迟加载。
     * 使用函数式接口，数据并没有完全确定，等到真正调用的时候才确定，类似推模型。
     */
    @Test
    public void testSuplier()
    {
        print1("Hello Suplier<T>");
        print2(() -> "Hello Suplier<T>");
    }

    public static void showLog1(int level, String message)
    {
        if (level == 1)
        {
            System.out.println(message);
        }
    }

    public static void showLog2(int level, MessageBuilder messageBuilder)
    {
        if (level == 1)
        {
            System.out.println(messageBuilder.builderMessage());
        }
    }

    /**
     * @FunctionalInterface注解
     */
    @Test
    public void testMessageBuilder()
    {
        String message1 = "Java";
        String message2 = "Python";
        String message3 = "Go";

        showLog1(1, message1 + message2 + message3);
        /**
         * 分析：使用Lambda表达式作为参数传递,仅仅是把参数传递到showLog方法中，
         * 只有满足条件,日志的等级是1级才会调用接口MessageBuilder中的方法builderMessage，
         * 才会进行字符串的拼接；
         * 如果条件不满足,日志的等级不是1级，那么MessageBuilder接口中的方法builderMessage
         * 也不会执行，所以拼接字符串的代码也不会执行，所以不会存在性能的浪费
         */
        showLog2(1, () -> message1 + message2 + message3);
    }


    /**
     * 定义一个方法startThread,方法的参数使用函数式接口Runnable
     *
     * @param runnable
     */
    public void startThread(Runnable runnable)
    {
        /**
         * 开启多线程
         */
        new Thread(runnable).start();
    }

    /**
     * 使用函数式接口作为方法的参数
     */
    @Test
    public void testStartThread()
    {
        /**
         * 调用startThread方法,方法的参数是一个接口,那么我们可以传递这个接口的匿名内部类
         */
        startThread(new Runnable()
        {
            @Override
            public void run()
            {
                System.out.println(Thread.currentThread().getName() + "-->线程启动了");
            }
        });
        /**
         * 调用startThread方法,方法的参数是一个函数式接口,所以可以传递Lambda表达式
         */
        startThread(() -> {
            System.out.println(Thread.currentThread().getName() + "-->线程启动了");
        });

        /**
         * 简洁版的lambda
         */
        startThread(() -> System.out.println(Thread.currentThread().getName() + "-->线程启动了"));
    }


    /**
     * 如果一个方法的返回值类型是一个函数式接口，那么就可以直接返回一个Lambda表达式。
     * 当需要通过一个方法来获取一个java.util.Comparator接口类型的对象作为排序器时,就可以调该方法获取。
     * 使用函数式接口作为方法的返回值
     *
     * @return
     */
    public static Comparator<String> getCompartor()
    {
        /**
         * 方法的返回值类型是一个接口，那么我们可以返回这个接口的匿名内部类
         */
        // return new Comparator<String>()
        // {
        //     @Override
        //     public int compare(String o1, String o2)
        //     {
        //         return o2.length()-o1.length();
        //     }
        // };

        /**
         * 方法的返回值是一个函数式接口，那么我们可以返回一个lambda表达式
         */
        // return (String o1,String o2)->{
        //     return o2.length()-o1.length();
        // };

        /**
         * 优化以后的lambda表达式
         */
        return (o1, o2) -> o2.length() - o1.length();
    }

    @Test
    public void testCompartor()
    {
        String[] arr = {"a", "bb", "ccc", "ddddddd", "eeee"};
        System.out.println("排序前的数组是:");
        Arrays.stream(arr).forEach(System.out::println);
        Arrays.sort(arr, getCompartor());

        System.out.println("排序后的数组");
        Arrays.stream(arr).forEach(System.out::println);


    }

    /**
     * Supplier<T> 供给型
     * Consumer<T> 消费型
     * Predicate<T> 断定型
     * Function<T,R> 函数型
     */
    /**
     * ①提供类型：Supplier接口
     * 特点：只出不进，作为方法/构造参数、方法返回值
     * java.util.function.Supplier接口仅包含一个无参的方法：T get()。
     * 用来获取一个泛型参数指定类型的对象数据。
     * <p>
     * Supplier接口被称之为生产型接口,指定接口的泛型是什么类型,
     * 那么接口中的get方法就会生产什么类型的数据
     */
    public static String getString(Supplier<String> supplier)
    {
        return supplier.get();
    }

    @Test
    public void testSupplier()
    {
        // getString(new Supplier<String>()
        // {
        //     @Override
        //     public String get()
        //     {
        //         return null;
        //     }
        // });
        String string = getString(() -> "zky");
        System.out.println(string);


    }

    public static Integer getMaxNum(Supplier<Integer> supplier)
    {
        return supplier.get();
    }

    @Test
    public void testSuplierGetMaxNum()
    {
        int[] arr = {1, 23, -3, 124, -5};
        Integer maxNum = getMaxNum(() -> {
            int max = arr[0];
            for (int i : arr)
            {
                if (i > max)
                {
                    max = i;
                }
            }
            return max;
        });

        System.out.println("最大的值是:" + maxNum);
    }

    /**
     * ②消费类型：Consumer接口
     * 特点：只进不出，作为方法/构造参数
     * java.util.function.Consumer接口则正好与Supplier接口相反，
     * 它不是生产一个数据，而是消费一个数据，其数据类型由泛型决定。
     * Consumer接口中包含抽象方法void accept(T t)，意为消费一个指定泛型的数据。
     * <p>
     * Consumer接口是一个消费型接口,泛型执行什么类型,就可以使用accept方法消费什么类型的数据
     * 至于具体怎么消费(使用),需要自定义
     */
    public static void addName(String name, Consumer<String> consumer)
    {
        consumer.accept(name);
    }

    @Test
    public void testConsumer()
    {
        addName(("zky"), s -> System.out.println(s + " is the best man."));

        addName("zky", (name) -> {
            String s = new StringBuffer(name).reverse().toString();
            System.out.println(s + " is the best.");
        });
    }

    /**
     * andThen:
     * Consumer接口的默认方法andThen
     * 作用:需要两个Consumer接口,可以把两个Consumer接口组合到一起,在对数据进行消费
     */

    public static void andThenDo(String name, Consumer<String> consumer1, Consumer<String> consumer2)
    {
        consumer1.andThen(consumer2).accept(name);
    }

    @Test
    public void testAndThenDo()
    {
        andThenDo("zky", s -> System.out.println(s.toUpperCase()), s -> System.out.println(s + s));
    }

    /**
     * 按照格式“姓名：XX。性别：XX。”的格式将信息打印
     * 要求将打印姓名的动作作为第一个Consumer接口的Lambda实例，
     * 将打印性别的动作作为第二个Consumer接口的Lambda实例，
     * 将两个Consumer接口按照顺序“拼接”到一起。
     */
    public static void printNameAndSex(String[] arr, Consumer<String> consumer1, Consumer<String> consumer2)
    {
        for (String s : arr)
        {
            /**
             * 使用andThen方法连接两个Consumer方法，消费字符串
             */
            consumer1.andThen(consumer2).accept(s);
        }
    }

    @Test
    public void testPrintNameAndSex()
    {
        /**
         * 定义一个字符串数组
         */
        String[] arr = {"周杰伦,男", "周星驰,男", "江一燕,女", "波多,女"};
        /**
         * 调用printNameAndSex方法，传递一个字符串数组，和两个Lambda表达式
         */
        printNameAndSex(arr, s -> {
            /**
             * 消費方式:对s进行切割，获取姓名，按照指定格式输出
             */
            String name = s.split(",")[0];
            System.out.print("姓名: " + name);
        }, s -> {
            /**
             * 消費方式:对s进行切割，获取性别，按照指定格式输出
             */
            String sex = s.split(",")[1];
            System.out.println(";性别: " + sex);
        });

    }

    /**
     * ③断定类型：Predicate接口
     * 特点：boolean类型判断，作为方法/构造参数
     * java.util.function.Predicate接口
     * 作用:对某种数据类型的数据进行判断,结果返回一个boolean值
     * <p>
     * Predicate接口中包含一个抽象方法：
     * boolean test(T t):用来对指定数据类型数据进行判断的方法
     * 结果:
     * 符合条件,返回true
     * 不符合条件,返回false
     */
    public static boolean checkPredicate(String string, Predicate<String> predicate)
    {
        return predicate.test(string);
    }

    @Test
    public void testCheckPredicate()
    {
        String abc = "abcdef";
        boolean b = checkPredicate(abc, s -> s.length() == 1);

        System.out.println(b);
        boolean abc1 = checkPredicate("123", new Predicate<String>()
        {
            @Override
            public boolean test(String s)
            {
                return abc.startsWith("abc");
            }
        });
        System.out.println(abc1);
    }

    /**
     * and方法：
     * Predicate接口中有一个方法and,表示并且关系,也可以用于连接两个判断条件
     * <p>
     * 1default Predicate<T> and(Predicate<? super T> other) {
     * 2        Objects.requireNonNull(other);
     * 3        return (t) -> this.test(t) && other.test(t);
     * 4}
     *
     * @param str
     * @param predicate1
     * @param predicate2
     * @return
     */
    public static boolean validateAndStr(String str, Predicate<String> predicate1, Predicate<String> predicate2)
    {
        return predicate1.and(predicate2).test(str);
    }

    @Test
    public void testValidateStr()
    {
        boolean b = validateAndStr("abcdef", s -> s.equals("abc"), s -> s.length() > 10);
        System.out.println(b);
    }

    /**
     * or方法：
     * Predicate接口中有一个方法or,表示或者关系,也可以用于连接两个判断条件
     * <p>
     * 1    default Predicate<T> or(Predicate<? super T> other) {
     * 2        Objects.requireNonNull(other);
     * 3        return (t) -> test(t) || other.test(t);
     * 4    }
     *
     * @param str
     * @param predicate1
     * @param predicate2
     * @return
     */
    public static boolean validateOrStr(String str, Predicate<String> predicate1, Predicate<String> predicate2)
    {
        return predicate1.or(predicate2).test(str);
    }

    @Test
    public void testValidateOrStr()
    {
        String abc = "abc";
        boolean abC = validateOrStr(abc, s -> s.length() == 1, s -> s.equalsIgnoreCase("abC"));

        System.out.println("abC: " + abC);
        boolean aBc = validateOrStr(abc, new Predicate<String>()
        {
            @Override
            public boolean test(String s)
            {
                return s.length() == 1;
            }
        }, new Predicate<String>()
        {
            @Override
            public boolean test(String s)
            {
                return s.equalsIgnoreCase("aBc");
            }
        });

        System.out.println("aBc: " + aBc);
    }

    /**
     * negate方法：
     * Predicate接口中有一个方法negate,也表示取反的意思
     * <p>
     * 1    default Predicate<T> negate() {
     * 2        return (t) -> !test(t);
     * 3    }
     */

    public static boolean validateNegateStr(String str, Predicate<String> predicate)
    {
        return predicate.negate().test(str);
    }

    @Test
    public void testValidateNegateStr()
    {
        String str = "abcef";
        boolean b = validateNegateStr(str, s -> s.length() > 5);
        System.out.println(b);
    }

    public static List<String> filter(String[] arr, Predicate<String> predicate1, Predicate<String> predicate2)
    {
        List<String> list = new ArrayList<>();
        for (String s : arr)
        {
            boolean test = predicate1.and(predicate2).test(s);
            if (test)
            {
                list.add(s);
            }
        }

        return list;
    }

    @Test
    public void testFilter()
    {
        String[] array = {"Java,Ga", "Linux,L", "Apple,Jadsf", "Microsoft,Badfd"};
        List<String> l = filter(array, s -> s.split(",")[0].startsWith("L"), s -> s.split(",")[1].length() == 1);

        System.out.println(l.toString());
    }

    /**
     * ④转换类型：Function接口
     * 特点：有输入，有输出
     * java.util.function.Function接口用来根据一个类型的数据得到另一个类型的数据，
     * 前者称为前置条件，后者称为后置条件。
     * <p>
     * Function接口中最主要的抽象方法为：R apply(T t)，根据类型T的参数获取类型R的结果。
     * 使用的场景例如：将String类型转换为Integer类型。
     */
    public static void convert(String str, Function<String, Integer> function)
    {

        /**
         * 通过自动拆箱，integer 自动转为int
         */
        int apply = function.apply(str);
        System.out.println(apply);
    }

    @Test
    public void testConvert()
    {
        String s = "9999";
        convert(s, str -> Integer.parseInt(str));
        int i = Integer.parseInt(s);
        System.out.println("i: " + i);
    }

    /**
     * andThen方法：
     */
    public static String convertStringAndThen(String str, Function<String, Integer> function1, Function<Integer, String> function2)
    {
        return function1.andThen(function2).apply(str);
    }

    @Test
    public void testConvertStringAndThen()
    {
        String s = "99";
        String s3 = convertStringAndThen(s, s1 -> Integer.parseInt(s1) + 1, s2 -> s2 + " linux is the best system.");
        System.out.println(s3);
    }

    /**
     * String str = "赵丽颖,20";
     * 1.将字符串截取数字年龄部分，得到字符串；
     * 2.将上一步的字符串转换成为int类型的数字；
     * 3.将上一步的int数字累加100，得到结果int数字。
     */
    public static int convertGroup(String str, Function<String, String> function1, Function<String, Integer> function2, Function<Integer, Integer> function3)
    {
        return function1.andThen(function2).andThen(function3).apply(str);
    }

    /**
     * 注意：使用匿名内部类会编译后会多产生一个类，而使用lambda，底层是invokedynamic指令,不会有多余的
     */
    @Test
    public void testConvertGroup()
    {
        String str = "周星驰,55";
        int i = convertGroup(str, s -> s.split(",")[1], s -> Integer.parseInt(s), s -> s + 100);

        System.out.println("经过组合转换以后的结果是: " + i);
    }

    /**
     * 方法引用
     * 若lambda体中的内容，有方法已经实现了，则可以使用方法引用。方法引用是对lambda的简化
     */


}
