package knowledgeable.review201901.designPatterns.factory;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-19
 * Time: 15:12:49
 * Description:
 */
public class ComputerFactory implements Factory
{

    @Override
    public void create()
    {
        System.out.println("Create Computer.");
    }
}
