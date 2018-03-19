package KnowledgeableReview201803.designPatterns.abstractFactory;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-19
 * Time: 15:43:07
 * Description:
 */
public abstract class AbstractFactory
{
    abstract Color getColor(String color);
    abstract Shape getShape(String shape);
}
