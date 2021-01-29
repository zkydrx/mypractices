package knowledgeable.review202101.msb.dcl;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2021-01-29
 * Time: 19:48:09
 * Description:
 * 双重校验锁保证线程安全
 */
public class DoubleCheckLockMethod
{
    /**
     * volatile禁止指令重排
     * 必须要加，否者会出现cpu指令重排序
     * 下面通过这个小例子来解释cpu执行过程，
     * public static void main(String[] args)
     *     {
     *         Object object = new Object();
     *     }
     *     1.NEW java/lang/Object 内存空间分配一块空间。
     *     2.INVOKESPECIAL java/lang/Object.<init> ()V 初始化变量
     *     3.ASTORE 1 用指针指向变量的内存地址
     *  如果不适用volatile的话会发生指令重排序，那么可能的结果是2，与3 互换，那么此时的变量是一个没有初始化完成的对象
     *  在高并发的场景下，会出现线程拿到一个没有初始化完成的变量，这样比较尴尬，而且很难debug发现问题。
     */
    private static volatile DoubleCheckLockMethod INSTANCE;
    public DoubleCheckLockMethod()
    {
    }

    public static DoubleCheckLockMethod getInstance()
    {
        if (INSTANCE == null)
        {
            synchronized (DoubleCheckLockMethod.class)
            {
                if (null == INSTANCE)
                {
                    INSTANCE = new DoubleCheckLockMethod();
                }
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args)
    {
        for (int i = 0; i < 10000; i++)
        {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"==="+DoubleCheckLockMethod.getInstance().hashCode());
            },"t"+i).start();
        }
    }
}
