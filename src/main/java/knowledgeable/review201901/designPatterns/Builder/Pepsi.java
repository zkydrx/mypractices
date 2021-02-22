package knowledgeable.review201901.designPatterns.Builder;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-20
 * Time: 11:55:09
 * Description:
 */
public class Pepsi extends ColdDrink
{

    @Override
    public String name()
    {
        return "Pepsi";
    }

    @Override
    public float price()
    {
        return 35.0f;
    }

    @Override
    public float weight()
    {
        return 520.0f;
    }


}
