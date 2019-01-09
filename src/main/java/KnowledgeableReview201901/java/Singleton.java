package KnowledgeableReview201901.java;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-01-09
 * Time: 12:49:16
 * Description:
 */
public class Singleton
{
    private Singleton(){}
    private volatile static Singleton instance;
    public Singleton getInstance()
    {
        if(instance == null)
        {
            synchronized (Singleton.class)
            {
                if (instance == null)
                {
                    instance  = new Singleton();
                }
            }
        }
        return instance;
    }

}
