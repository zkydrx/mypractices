package test.Enum;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2018-07-07
 * Time: 01:02:42
 * Description:
 */
public class TestEnumOne
{
    public static void main(String[] args)
    {
        String name = Week.STA.getName();
        System.out.print(name);
        Week.STA.doWork();
        String s = Week.STA.doSomething("Have a movie.");
        System.out.print(s);
    }
}

/**
 * 可以实现接口例如FUN接口
 * 可以实现抽象方法doWork();
 */
enum Week implements FUN
{
    MON("星期一")
            {
                @Override
                public String doSomething(String str)
                {
                    return str;
                }

                @Override
                public void doWork()
                {
                    System.out.print("是工作日");
                }
            },
    TEU("星期二")
            {
                @Override
                public String doSomething(String str)
                {
                    return str;
                }

                @Override
                public void doWork()
                {
                    System.out.print("是工作日");
                }
            },
    WED("星期三")
            {
                @Override
                public String doSomething(String str)
                {
                    return str;
                }

                @Override
                public void doWork()
                {
                    System.out.print("是工作日");

                }
            },
    THU("星期四")
            {
                @Override
                public String doSomething(String str)
                {
                    return str;
                }

                @Override
                public void doWork()
                {
                    System.out.print("是工作日");

                }
            },
    FRI("星期五")
            {
                @Override
                public String doSomething(String str)
                {
                    return str;
                }

                @Override
                public void doWork()
                {
                    System.out.print("是工作日");

                }
            },
    STA("星期六")
            {
                @Override
                public String doSomething(String str)
                {
                    return str;
                }

                @Override
                public void doWork()
                {
                    System.out.print("是休息日");

                }
            },
    SUN("星期日")
            {
                @Override
                public String doSomething(String str)
                {
                    return str;
                }

                @Override
                public void doWork()
                {
                    System.out.print("是休息日");

                }
            };
    private String name;

    private Week(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    public abstract void doWork();

}

interface FUN
{
    String doSomething(String str);
}