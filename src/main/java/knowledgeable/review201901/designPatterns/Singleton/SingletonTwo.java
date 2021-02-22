package knowledgeable.review201901.designPatterns.Singleton;

import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-19
 * Time: 17:19:19
 * Description:
 * 懒汉式，线程安全
 */
public class SingletonTwo
{
    private static SingletonTwo instance;
    private SingletonTwo(){}
    public static synchronized SingletonTwo getInstance()
    {
        if(null == instance)
        {
            instance =new SingletonTwo();
        }
        return instance;
    }

    @Test
    public void testPrint()
    {
        System.out.println("SingleTwo ；懒汉式，线程安全");
    }

}
