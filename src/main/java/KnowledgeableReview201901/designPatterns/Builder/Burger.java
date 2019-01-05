package KnowledgeableReview201901.designPatterns.Builder;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-20
 * Time: 11:49:02
 * Description:
 */
public abstract class Burger implements Item
{
    @Override
    public Packing packing()
    {
        return new Wrapper();
    }

    @Override
    public abstract float price();

    @Override
    public abstract float weight();
}
