package KnowledgeableReview201901.designPatterns.Builder;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-20
 * Time: 11:53:35
 * Description:
 */
public class ChickenBurger extends Burger
{

    @Override
    public String name()
    {
        return "Chicken Burger";
    }

    @Override
    public float price()
    {
        return 50.5f;
    }

    @Override
    public float weight()
    {
        return 300.0f;
    }


}
