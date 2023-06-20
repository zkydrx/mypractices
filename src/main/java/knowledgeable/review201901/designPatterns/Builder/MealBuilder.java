package knowledgeable.review201901.designPatterns.Builder;

/**
 * Created with IntelliJ IDEA. Author: Abbot Date: 2018-03-20 Time: 12:00:09
 * Description:
 */
public class MealBuilder {
	public Meal prepareVegMeal() {
		Meal meal = new Meal();
		meal.addItem(new VegBurger());
		meal.addItem(new Coke());
		return meal;
	}

	public Meal prepareNonVegMeal() {
		Meal meal = new Meal();
		meal.addItem(new ChickenBurger());
		meal.addItem(new Pepsi());
		return meal;
	}

}
