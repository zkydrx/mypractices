package knowledgeable.review201803.designPatterns.decorator;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-27
 * Time: 00:28:28
 * Description:
 */
public abstract class ShapeDecorator implements Shape
{
    protected Shape decoratedShape;
    public ShapeDecorator(Shape decoratedShape)
    {
        this.decoratedShape = decoratedShape;
    }

    public void draw()
    {
        decoratedShape.draw();
    }
}
