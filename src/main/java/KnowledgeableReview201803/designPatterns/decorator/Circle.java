package KnowledgeableReview201803.designPatterns.decorator;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-27
 * Time: 00:27:44
 * Description:
 */
public class Circle implements Shape
{

    @Override
    public void draw()
    {
        System.out.println("Shape:Circle");
    }
}
