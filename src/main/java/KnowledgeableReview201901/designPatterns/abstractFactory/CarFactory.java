package KnowledgeableReview201901.designPatterns.abstractFactory;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-19
 * Time: 15:10:15
 * Description:
 */
public class CarFactory implements Shape
{

    @Override
    public void create()
    {
        System.out.println("Create Car.");
    }
}
