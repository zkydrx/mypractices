package KnowledgeableReview201803.designPatterns.Builder;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-20
 * Time: 11:54:17
 * Description:
 */
public class Coke extends ColdDrink
{

    @Override
    public String name()
    {
        return "Coke";
    }

    @Override
    public float price()
    {
        return 30.0f;
    }

    public float weight()
    {
        return 500.0f;
    }


}
