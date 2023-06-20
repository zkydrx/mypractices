package knowledgeable.review201803.designPatterns.Builder;

/**
 * Created with IntelliJ IDEA. Author: Abbot Date: 2018-03-20 Time: 11:52:29
 * Description:
 */
public class VegBurger extends Burger {

	@Override
	public String name() {
		return "Veg Burger";
	}

	@Override
	public float price() {
		return 25.0f;
	}

	@Override
	public float weight() {
		return 250.0f;
	}

}
