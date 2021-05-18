package knowledgeable.review201803.designPatterns.Builder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-20
 * Time: 11:56:10
 * Description:
 */
public class Meal
{
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item)
    {
        items.add(item);
    }

    public float getCost()
    {
        float cost = 0.0f;
        for (Item item : items)
        {
            cost += item.price();
        }

        return cost;
    }

    public float getWeight()
    {
        float cost = 0.0f;
        for (Item item : items)
        {
            cost += item.weight();
        }

        return cost;
    }

    public void showItems()
    {
        for (Item item : items)
        {
            System.out.print("Item:" + item.name());
            System.out.print(",Packing : " + item.packing().pack());
            System.out.print(",Weight : " + item.weight());
            System.out.println(",Price : " + item.price());
        }
    }

}
