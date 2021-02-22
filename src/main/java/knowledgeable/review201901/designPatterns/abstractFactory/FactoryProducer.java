package knowledgeable.review201901.designPatterns.abstractFactory;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-19
 * Time: 15:50:06
 * Description:
 */
public class FactoryProducer
{
    public static AbstractFactory getFactory(String choice)
    {
        if(choice.equalsIgnoreCase("shape"))
        {
            return new ShapeFactory();
        }
        if(choice.equalsIgnoreCase("Color"))
        {
            return new ColorFactory();
        }
        return null;
    }
}
