package KnowledgeableReview201901.distributed;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-01-09
 * Time: 14:37:20
 * Description:
 */
public class DistributedMain
{
    public static void main(String[] args)
    {
        Service service = new Service();
        for (int i = 0; i < 50; i++)
        {
            ThreadA threadA = new ThreadA(service);
            threadA.start();
        }
    }

}
