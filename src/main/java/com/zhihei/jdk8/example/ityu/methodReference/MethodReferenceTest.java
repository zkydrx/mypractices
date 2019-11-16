package com.zhihei.jdk8.example.ityu.methodReference;

import com.zhihei.jdk8.example.ityu.methodReference.moudle.Child;
import com.zhihei.jdk8.example.ityu.methodReference.moudle.Person;
import com.zhihei.jdk8.example.ityu.methodReference.moudle.Person1;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-11-16
 * Time: 11:03:32
 * Description:
 */
public class MethodReferenceTest
{
    public static void printString(MyPrintable myPrintable)
    {
        myPrintable.print("Hello,Lambda!!!");
    }

    @Test
    public void testPringString()
    {
        System.out.println("简洁版:");
        printString(s -> System.out.println(s));

        System.out.println("代码最多版");
        printString(new MyPrintable()
        {
            @Override
            public void print(String str)
            {
                System.out.println(str);
            }
        });
        /**
         * 改进
         */
        System.out.println("改进版");
        printString(System.out::println);
    }
    /**
     * 方法引用
     * 双冒号::为引用运算符，而它所在的表达式被称为方法引用。
     * 如果Lambda要表达的函数方案已经存在于某个方法的实现中，那么则可以通过双冒号
     * 来引用该方法作为Lambda的替代者。
     *
     * 三种格式：
     *
     * 对象::实例方法名
     *
     * 类::静态方法名
     *
     * 类::实例方法名
     *
     * 分析
     *
     * Lambda表达式写法：s -> System.out.println(s);
     *
     * 方法引用写法：System.out::println
     *
     * 以上两种写法完全等效：
     * 第一种：拿到参数之后通过Lambda传递给 System.out.println 方法去处理。
     * 第二种：直接让 System.out 中的 println 方法来取代Lambda。
     *
     * 注意:lambda体中调用的方法的参数列表和返回值类型要与函数式接口的抽象方法的参数列表与返回值类型一致。
     * Lambda 中 传递的参数一定是方法引用中的那个方法可以接收的类型,否则会抛出异常
     */

    /**
     * 3.1 通过对象名引用成员方法
     */
    public static void printStringByMethod(MyPrintable myPrintable)
    {
        myPrintable.print("通过对象名引用成员方法");
    }

    @Test
    public void testPrintStringByMethod()
    {
        printStringByMethod(str -> {
            MethodReferenceObj methodReferenceObj = new MethodReferenceObj();
            methodReferenceObj.printUppercaseString(str);
        });

        /**
         *  使用方法引用：
         * 1.MethodReadObj对象已经存在
         * 2.成员方法printUppercaseString已经存在
         * 所以可以使用对象名引用成员方法
         */
        MethodReferenceObj methodReferenceObj = new MethodReferenceObj();
        printStringByMethod(methodReferenceObj::printUppercaseString);


        /**
         * 3.2 通过类名引用静态方法
         * 类已经存在，静态方法已经存在，则可以通过类名直接引用静态成员方法
         */
        System.out.println("类名引用静态方法");
        printStringByMethod(MethodReferenceObj::printUppercaseStringStatic);

        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
        Comparator<Double> comparator1 = Double::compare;


    }

    public static int calc(int num, MyCalc myCalc)
    {
        return myCalc.calc(num);
    }

    @Test
    public void testCalc()
    {
        int calc = calc(-10, s -> Math.abs(s));
        System.out.println("普通版:" + calc);

        /**
         * 简洁版
         */
        int calc1 = calc(-10, Math::abs);

        System.out.println("简洁版:" + calc1);
    }

    /**
     * 通过类名引用实例方法
     * 注意：以上这种情况，需要满足一定的条件：lambda表达式中第一个参数是lambda体中的调用者，
     * 第二个参数是lambda体中的参数
     */
    @Test
    public void testMethodReferenceByClassName()
    {
        BiPredicate<String, String> biPredicate = (x, y) -> x.equals(y);
        BiPredicate<String, String> biPredicate1 = String::equalsIgnoreCase;
    }

    /**
     * 3.3 通过super引用成员方法
     * 如果存在继承关系，当Lambda中需要出现super调用时，也可以使用方法引用进行替代。
     */
    @Test
    public void testSuper()
    {
        new Child().show();
    }

    /**
     * 3.4 通过this引用成员方法
     * this代表当前对象，如果需要引用的方法就是当前类中的成员方法，
     * 那么可以使用 this::成员方法的格式来使用方法引用
     */
    public void buyCar()
    {
        System.out.println("I buy a BMW");
    }

    public void getSalary(MyWallet myWallet)
    {
        myWallet.buy();
    }

    public void doIt()
    {
        getSalary(() -> this.buyCar());
        /**
         * 1. this已经存在
         * 2. 本类的成员方法buyCar()已经存在
         * 所以可以直接使用this引用本类的成员方法buyCar.
         */
        getSalary(this::buyCar);
    }

    @Test
    public void testDoit()
    {
        new MethodReferenceTest().doIt();
    }

    /**
     * 3.5类的构造器引用
     * 由于构造器的名称与类名完全一样，并不固定。
     * 所以构造器引用使用 类名称::new 的格式表示。
     */

    @Test
    public void testConstructOfClass()
    {
        Supplier<Person> supplier = () -> new Person();
        /**
         * 构造器引用，此处引用的是无参构造器，因为supplier中的get方法没有错参数
         */
        Supplier<Person> supplier1 = Person::new;
        Person person = supplier.get();
        System.out.println(person);

        /**
         * 注意：需要调用的构造器的参数列表要与函数式接口中抽象方法的参数列表一致
         */
        Function<Integer, Person> function1 = (x) -> new Person(x);
        /**
         * 构造器引用 此处引用的是整型的一个参数的构造器 ，
         * 因为Function中的apply方法只有一个参数
         */
        Function<Integer, Person> function = Person::new;

    }

    public static void printName(String name, Integer age, PersonBuilder personBuilder)
    {
        Person1 person1 = personBuilder.builderPerson(name, age);
        System.out.println(person1.toString());
    }

    @Test
    public void testPrintName()
    {
        printName("zky", 11, (n, a) -> new Person1(n, a));
        /**
         * 使用方法引用：
         * 1.构建方法 new Person(String name) 已知
         * 2.创建对象已知
         * 可以使用Person1的引用new创建对象
         */
        printName("zky", 11, Person1::new);
    }

    /**
     * .6 数组的构造器引用
     * 数组也是 Object 的子类对象，所以同样具有构造器，只是语法稍有不同。
     * 格式：Type[]::new
     */
    @Test
    public void testArrayConstruct()
    {
        Function<Integer, String[]> function = (x) -> new String[x];
        Function<Integer, String[]> function1 = String[]::new;
        String[] apply = function.apply(10);
        String[] apply1 = function1.apply(11);
        System.out.println("apply.length:" + apply.length);
        System.out.println("apply1.length:" + apply1.length);
    }


    public static int[] createArray(int length,ArrayBuilder arrayBuilder)
    {
        return arrayBuilder.builderArray(length);
    }
    @Test
    public void testCreateArray()
    {
        int [] array1 = createArray(11,length -> new int[length]);
        System.out.println("创建数组1的长度：");
        System.out.println(array1.length);

        /**
         * 1.已知创建的是int[]数组
         * 2.创建数组长度也是已知的
         * 使用方法引用，int[]数组引用new,根据参数传递的长度创建数组
         */
        int [] array2 = createArray(11,int[]::new);
        System.out.println("创建的数组2的长度: ");
        System.out.println(array2.length);
    }


}

class MethodReferenceObj
{
    public void printUppercaseString(String str)
    {
        System.out.println(str.toUpperCase());
    }

    public static void printUppercaseStringStatic(String str)
    {
        System.out.println(str.toUpperCase());
    }


}
