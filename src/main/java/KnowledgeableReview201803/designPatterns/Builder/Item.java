package KnowledgeableReview201803.designPatterns.Builder;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-20
 * Time: 11:45:56
 * Description:
 */
public interface Item
{
    public String name();
    public Packing packing();
    public float price();
    float weight();
}
