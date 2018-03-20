package KnowledgeableReview201803.designPatterns.Builder;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-20
 * Time: 11:51:13
 * Description:
 */
public abstract class ColdDrink implements Item
{

    @Override
    public Packing packing()
    {
        return new Bottle();
    }

    @Override
    public abstract float price();

    @Override
    public abstract float weight();
}
