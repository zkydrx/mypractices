package knowledgeable.review201803.designPatterns.factory;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-19
 * Time: 15:17:06
 * Description:
 */
public class TestFactory
{
    public static void main(String[] args)
    {
        ThingFactory thingFactory = new ThingFactory();

        Factory car = thingFactory.getType("car");
        car.create();

        Factory computer = thingFactory.getType("computer");

        computer.create();
    }
}
