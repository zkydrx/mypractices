package KnowledgeableReview201901.designPatterns.abstractFactory;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-19
 * Time: 15:12:49
 * Description:
 */
public class ComputerFactory implements Shape
{

    @Override
    public void create()
    {
        System.out.println("Create Computer.");
    }
}
