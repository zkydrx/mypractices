package test;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2018-06-04
 * Time: 14:39:22
 * Description:
 * <p>
 * How do I print my name 1000 times in Java without looping?
 */
public class NoLoopPrintString
{

    public static void main(String[] args)
    {
        String name = "Jacek";
        String str = "X";
        str = str.replaceAll("X", "XXXXXXXXXX");
        str = str.replaceAll("X", "XXXXXXXXXX");
        str = str.replaceAll("X", "XXXXXXXXXX");
        str = str.replaceAll("X", name + "\n");
        System.out.println(str);
        new NoLoopPrintString().p1000();
    }


    public void p1000()
    {
        p300();
        p300();
        p300();
        p100();
    }

    public void p300()
    {
        p100();
        p100();
        p100();
    }

    public void p100()
    {
        p30();
        p30();
        p30();
        p10();
    }

    public void p30()
    {
        p10();
        p10();
        p10();
    }

    public void p10()
    {
        p3();
        p3();
        p3();
        p1();
    }

    public void p3()
    {
        p1();
        p1();
        p1();
    }

    public void p1()
    {
        System.out.println("Shreyash");
    }


}
