package knowledgeable.review201803.JavaInitLine;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-20
 * Time: 10:35:11
 * Description:
 */
public class SubClass extends Parent
{
    //静态变量
    public static String sStaticField = "子类--静态变量";
    //变量
    public String sField = "子类--变量";

    //静态初始化块
    static
    {
        System.out.println(sStaticField);
        System.out.println("子类--静态初始化块");
    }

    //初始化块
    {
        System.out.println(sField);
        System.out.println("子类--初始化块");
    }

    public SubClass()
    {
        System.out.println("子类--构造器");
        System.out.println("i=" + i + ",j=" + j);
    }

    public static void main(String[] args)
    {
        System.out.println("子类的main方法");
        SubClass subClass = new SubClass();
    }
}
