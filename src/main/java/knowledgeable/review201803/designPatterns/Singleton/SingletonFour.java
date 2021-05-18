package knowledgeable.review201803.designPatterns.Singleton;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-19
 * Time: 17:05:26
 * Description:
 * 双检锁/双重校验锁（DCL，即 double-checked locking）
 */
public class SingletonFour
{
    public static SingletonFour instance;

    private SingletonFour()
    {
    }

    public static SingletonFour getInstance()
    {
        if (null == instance)
        {
            synchronized (SingletonFour.class)
            {
                if (null == instance)
                {
                    instance = new SingletonFour();
                }
            }
        }
        return instance;
    }

    public void testPrint()
    {
        System.out.println("SingletonFour 双检锁/双重校验锁（DCL，即 double-checked locking）");
    }
}
