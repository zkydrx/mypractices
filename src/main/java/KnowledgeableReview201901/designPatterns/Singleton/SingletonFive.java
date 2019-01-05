package KnowledgeableReview201901.designPatterns.Singleton;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-19
 * Time: 17:45:31
 * Description:
 * 登记式/静态内部类
 */
public class SingletonFive
{
    public static class SingletonHolder
    {
        private static final SingletonFive INSTANCE=new SingletonFive();
    }
    private SingletonFive(){}
    public static final SingletonFive getInstance()
    {
        return SingletonHolder.INSTANCE;
    }

    public void testPrint()
    {
        System.out.println("SingletonFive 登记式/静态内部类");
    }

}
