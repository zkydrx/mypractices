package KnowledgeableReview201803.designPatterns.factory;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-19
 * Time: 15:10:15
 * Description:
 */
public class CarFactory implements Factory
{

    @Override
    public void create()
    {
        System.out.println("Create Car.");
    }
}
