package KnowledgeableReview201803.designPatterns.decorator;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-27
 * Time: 00:32:16
 * Description:
 */
public class TestAll
{
    public static void main(String[] args)
    {
        Shape circle = new Circle();
        Shape redCircle = new RedShapeDecorator(new Circle());

        Shape redRectangle= new RedShapeDecorator(new Rectangle());

        System.out.println("Circle with normal border");
        circle.draw();
        System.out.println("\nCircle of red border");
        redCircle.draw();
        System.out.println("\nRectangle of red border");
        redRectangle.draw();

    }
}
