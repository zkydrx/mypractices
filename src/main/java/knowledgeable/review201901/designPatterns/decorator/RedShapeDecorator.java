package knowledgeable.review201901.designPatterns.decorator;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-27
 * Time: 00:30:31
 * Description:
 */
public class RedShapeDecorator extends ShapeDecorator
{

    public RedShapeDecorator(Shape decoratedShape)
    {
        super(decoratedShape);
    }

    public void draw()
    {
        decoratedShape.draw();

    }

    private void setRedBorder(Shape decoratedShape)
    {
        System.out.println("Border color: red");
    }
}
