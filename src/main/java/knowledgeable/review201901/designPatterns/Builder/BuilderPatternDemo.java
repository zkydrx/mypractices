package knowledgeable.review201901.designPatterns.Builder;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-20
 * Time: 12:02:36
 * Description:
 */
public class BuilderPatternDemo
{
    public static void main(String[] args)
    {
        MealBuilder mealBuilder = new MealBuilder();
        Meal vegMeal = mealBuilder.prepareVegMeal();

        System.out.println("Veg Meal");
        vegMeal.showItems();
        System.out.println("Total cost : "+vegMeal.getCost());
        System.out.println("Total weight : "+vegMeal.getWeight());

        Meal nonVegMeal = mealBuilder.prepareNonVegMeal();

        System.out.println("Non-Veg Meal");
        nonVegMeal.showItems();
        System.out.println("Total cost : "+nonVegMeal.getCost());
        System.out.println("Total weight : "+nonVegMeal.getWeight());
    }
}
